package com.codejudge.platform.judge;

import com.codejudge.platform.model.entity.QuestionSubmit;

/**
 * 鍒ら鏈嶅姟
 */
public interface JudgeService {

    /**
     * 鍒ら
     * @param questionSubmitId
     * @return
     */
    QuestionSubmit doJudge(long questionSubmitId);
}

