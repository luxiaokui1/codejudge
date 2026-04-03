package com.codejudge.platform.judge;

import cn.hutool.json.JSONUtil;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.judge.codesandbox.CodeSandbox;
import com.codejudge.platform.judge.codesandbox.CodeSandboxFactory;
import com.codejudge.platform.judge.codesandbox.CodeSandboxProxy;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeRequest;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeResponse;
import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;
import com.codejudge.platform.judge.strategy.JudgeContext;
import com.codejudge.platform.model.dto.question.JudgeCase;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.QuestionSubmit;
import com.codejudge.platform.model.enums.QuestionSubmitStatusEnum;
import com.codejudge.platform.service.QuestionService;
import com.codejudge.platform.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionService questionService;

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private JudgeManager judgeManager;

    @Value("${codesandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "Submission not found");
        }

        try {
            Long questionId = questionSubmit.getQuestionId();
            Question question = questionService.getById(questionId);
            if (question == null) {
                throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "Question not found");
            }
            if (!questionSubmit.getStatus().equals(QuestionSubmitStatusEnum.WAITING.getValue())) {
                throw new BusinessException(ErrorCode.OPERATION_ERROR, "The submission is already being judged");
            }

            // Move the record into RUNNING before calling the remote sandbox.
            QuestionSubmit questionSubmitUpdate = new QuestionSubmit();
            questionSubmitUpdate.setId(questionSubmitId);
            questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.RUNNING.getValue());
            boolean update = questionSubmitService.updateById(questionSubmitUpdate);
            if (!update) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Failed to update submission status");
            }

            // The backend never executes user code directly. It delegates compilation and runtime work
            // to a dedicated sandbox service, which returns structured execution results.
            CodeSandbox codeSandbox = new CodeSandboxProxy(CodeSandboxFactory.newInstance(type));
            List<JudgeCase> judgeCaseList = JSONUtil.toList(question.getJudgeCase(), JudgeCase.class);
            List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());

            ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                    .code(questionSubmit.getCode())
                    .language(questionSubmit.getLanguage())
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);

            // Build the comparison context so the strategy layer can derive the final verdict.
            JudgeContext judgeContext = new JudgeContext();
            judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
            judgeContext.setInputList(inputList);
            judgeContext.setOutputList(executeCodeResponse.getOutputList());
            judgeContext.setJudgeCaseList(judgeCaseList);
            judgeContext.setQuestion(question);
            judgeContext.setQuestionSubmit(questionSubmit);
            JudgeInfo judgeInfo = judgeManager.doJudge(judgeContext);

            questionSubmitUpdate = new QuestionSubmit();
            questionSubmitUpdate.setId(questionSubmitId);
            questionSubmitUpdate.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
            questionSubmitUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
            update = questionSubmitService.updateById(questionSubmitUpdate);
            if (!update) {
                throw new BusinessException(ErrorCode.SYSTEM_ERROR, "Failed to persist the final judge result");
            }

            return questionSubmitService.getById(questionSubmitId);
        } catch (Exception e) {
            // Never leave the submission permanently stuck in RUNNING when something goes wrong.
            QuestionSubmit failUpdate = new QuestionSubmit();
            failUpdate.setId(questionSubmitId);
            failUpdate.setStatus(QuestionSubmitStatusEnum.FAILED.getValue());
            JudgeInfo judgeInfo = new JudgeInfo();
            judgeInfo.setMessage(e.getMessage());
            failUpdate.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
            questionSubmitService.updateById(failUpdate);
            throw e;
        }
    }
}

