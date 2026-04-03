package com.codejudge.platform.judge.strategy;

import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;

/**
 * 鍒ら绛栫暐
 */
public interface JudgeStrategy {

    /**
     * 鎵ц鍒ら
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext);
}

