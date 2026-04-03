package com.codejudge.platform.judge.codesandbox.impl;

import com.codejudge.platform.judge.codesandbox.CodeSandbox;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeRequest;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeResponse;
import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;
import com.codejudge.platform.model.enums.JudgeInfoMessageEnum;
import com.codejudge.platform.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 绀轰緥浠ｇ爜娌欑锛堜粎涓轰簡璺戦€氫笟鍔℃祦绋嬶級
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("娴嬭瘯鎵ц鎴愬姛");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}

