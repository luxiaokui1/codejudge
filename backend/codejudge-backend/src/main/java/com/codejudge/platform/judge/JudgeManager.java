package com.codejudge.platform.judge;

import com.codejudge.platform.judge.strategy.DefaultJudgeStrategy;
import com.codejudge.platform.judge.strategy.JavaLanguageJudgeStrategy;
import com.codejudge.platform.judge.strategy.JudgeContext;
import com.codejudge.platform.judge.strategy.JudgeStrategy;
import com.codejudge.platform.judge.codesandbox.model.JudgeInfo;
import com.codejudge.platform.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 鍒ら绠＄悊锛堢畝鍖栬皟鐢級
 */
@Service
public class JudgeManager {

    /**
     * 鎵ц鍒ら
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}

