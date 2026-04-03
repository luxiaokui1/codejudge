package com.codejudge.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codejudge.platform.model.dto.question.QuestionQueryRequest;
import com.codejudge.platform.model.entity.Question;
import com.codejudge.platform.model.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.codejudge.platform.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author 鏉庨奔鐨?
* @description 閽堝琛ㄣ€恞uestion(棰樼洰)銆戠殑鏁版嵁搴撴搷浣淪ervice
* @createDate 2023-08-07 20:58:00
*/
public interface QuestionService extends IService<Question> {


    /**
     * 鏍￠獙
     *
     * @param question
     * @param add
     */
    void validQuestion(Question question, boolean add);

    /**
     * 鑾峰彇鏌ヨ鏉′欢
     *
     * @param questionQueryRequest
     * @return
     */
    QueryWrapper<Question> getQueryWrapper(QuestionQueryRequest questionQueryRequest);
    
    /**
     * 鑾峰彇棰樼洰灏佽
     *
     * @param question
     * @param request
     * @return
     */
    QuestionVO getQuestionVO(Question question, HttpServletRequest request);

    /**
     * 鍒嗛〉鑾峰彇棰樼洰灏佽
     *
     * @param questionPage
     * @param request
     * @return
     */
    Page<QuestionVO> getQuestionVOPage(Page<Question> questionPage, HttpServletRequest request);
    
}

