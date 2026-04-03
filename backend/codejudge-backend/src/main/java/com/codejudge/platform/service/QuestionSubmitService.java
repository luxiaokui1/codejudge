package com.codejudge.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codejudge.platform.model.dto.question.QuestionQueryRequest;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.codejudge.platform.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.entity.User;
import com.codejudge.platform.model.vo.QuestionSubmitVO;
import com.codejudge.platform.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 鏉庨奔鐨?
* @description 閽堝琛ㄣ€恞uestion_submit(棰樼洰鎻愪氦)銆戠殑鏁版嵁搴撴搷浣淪ervice
* @createDate 2023-08-07 20:58:53
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    
    /**
     * 棰樼洰鎻愪氦
     *
     * @param questionSubmitAddRequest 棰樼洰鎻愪氦淇℃伅
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 鑾峰彇鏌ヨ鏉′欢
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 鑾峰彇棰樼洰灏佽
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 鍒嗛〉鑾峰彇棰樼洰灏佽
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}

