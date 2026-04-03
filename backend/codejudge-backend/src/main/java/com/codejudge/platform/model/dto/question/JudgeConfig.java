package com.codejudge.platform.model.dto.question;

import lombok.Data;

/**
 * 棰樼洰閰嶇疆
 */
@Data
public class JudgeConfig {

    /**
     * 鏃堕棿闄愬埗锛坢s锛?
     */
    private Long timeLimit;

    /**
     * 鍐呭瓨闄愬埗锛圞B锛?
     */
    private Long memoryLimit;

    /**
     * 鍫嗘爤闄愬埗锛圞B锛?
     */
    private Long stackLimit;
}

