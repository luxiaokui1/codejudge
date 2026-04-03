package com.codejudge.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.constant.CommonConstant;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.judge.JudgeService;
import com.codejudge.platform.mapper.QuestionSubmitMapper;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.QuestionSubmit;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.enums.QuestionSubmitLanguageEnum;
import com.codejudge.platform.model.enums.QuestionSubmitStatusEnum;
import com.codejudge.platform.model.vo.QuestionSubmitVO;
import com.codejudge.platform.service.QuestionService;
import com.codejudge.platform.service.QuestionSubmitService;
import com.codejudge.platform.service.UserService;
import com.codejudge.platform.utils.SqlUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
* @author 鏉庨奔鐨?
* @description 閽堝琛ㄣ€恞uestion_submit(棰樼洰鎻愪氦)銆戠殑鏁版嵁搴撴搷浣淪ervice瀹炵幇
* @createDate 2023-08-07 20:58:53
*/
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    
    @Resource
    private QuestionService questionService;

    @Resource
    private UserService userService;

    @Resource
    @Lazy
    private JudgeService judgeService;

    /**
     * 鎻愪氦棰樼洰
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        // 鏍￠獙缂栫▼璇█鏄惁鍚堟硶
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "缂栫▼璇█閿欒");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 鍒ゆ柇瀹炰綋鏄惁瀛樺湪锛屾牴鎹被鍒幏鍙栧疄浣?
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 鏄惁宸叉彁浜ら鐩?
        long userId = loginUser.getId();
        // 姣忎釜鐢ㄦ埛涓茶鎻愪氦棰樼洰
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        // 璁剧疆鍒濆鐘舵€?
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");
        boolean save = this.save(questionSubmit);
        if (!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "鏁版嵁鎻掑叆澶辫触");
        }
        Long questionSubmitId = questionSubmit.getId();
        // 鎵ц鍒ら鏈嶅姟
        CompletableFuture.runAsync(() -> {
            judgeService.doJudge(questionSubmitId);
        });
        return questionSubmitId;
    }


    /**
     * 鑾峰彇鏌ヨ鍖呰绫伙紙鐢ㄦ埛鏍规嵁鍝簺瀛楁鏌ヨ锛屾牴鎹墠绔紶鏉ョ殑璇锋眰瀵硅薄锛屽緱鍒?mybatis 妗嗘灦鏀寔鐨勬煡璇?QueryWrapper 绫伙級
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest) {
        QueryWrapper<QuestionSubmit> queryWrapper = new QueryWrapper<>();
        if (questionSubmitQueryRequest == null) {
            return queryWrapper;
        }
        String language = questionSubmitQueryRequest.getLanguage();
        Integer status = questionSubmitQueryRequest.getStatus();
        Long questionId = questionSubmitQueryRequest.getQuestionId();
        Long userId = questionSubmitQueryRequest.getUserId();
        String sortField = questionSubmitQueryRequest.getSortField();
        String sortOrder = questionSubmitQueryRequest.getSortOrder();

        // 鎷兼帴鏌ヨ鏉′欢
        queryWrapper.eq(StringUtils.isNotBlank(language), "language", language);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq(ObjectUtils.isNotEmpty(questionId), "questionId", questionId);
        queryWrapper.eq(QuestionSubmitStatusEnum.getEnumByValue(status) != null, "status", status);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

    @Override
    public QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser) {
        QuestionSubmitVO questionSubmitVO = QuestionSubmitVO.objToVo(questionSubmit);
        // 鑴辨晱锛氫粎鏈汉鍜岀鐞嗗憳鑳界湅瑙佽嚜宸憋紙鎻愪氦 userId 鍜岀櫥褰曠敤鎴?id 涓嶅悓锛夋彁浜ょ殑浠ｇ爜
        long userId = loginUser.getId();
        // 澶勭悊鑴辨晱
        if (userId != questionSubmit.getUserId() && !userService.isAdmin(loginUser)) {
            questionSubmitVO.setCode(null);
        }
        return questionSubmitVO;
    }

    @Override
    public Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser) {
        List<QuestionSubmit> questionSubmitList = questionSubmitPage.getRecords();
        Page<QuestionSubmitVO> questionSubmitVOPage = new Page<>(questionSubmitPage.getCurrent(), questionSubmitPage.getSize(), questionSubmitPage.getTotal());
        if (CollectionUtils.isEmpty(questionSubmitList)) {
            return questionSubmitVOPage;
        }
        List<QuestionSubmitVO> questionSubmitVOList = questionSubmitList.stream()
                .map(questionSubmit -> getQuestionSubmitVO(questionSubmit, loginUser))
                .collect(Collectors.toList());
        questionSubmitVOPage.setRecords(questionSubmitVOList);
        return questionSubmitVOPage;
    }


}





