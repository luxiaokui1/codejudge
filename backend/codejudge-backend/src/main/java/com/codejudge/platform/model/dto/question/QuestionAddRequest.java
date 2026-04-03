package com.codejudge.platform.model.dto.question;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 鍒涘缓璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class QuestionAddRequest implements Serializable {

    /**
     * 鏍囬
     */
    private String title;

    /**
     * 鍐呭
     */
    private String content;

    /**
     * 鏍囩鍒楄〃
     */
    private List<String> tags;

    /**
     * 棰樼洰绛旀
     */
    private String answer;

    /**
     * 鍒ら鐢ㄤ緥
     */
    private List<JudgeCase> judgeCase;

    /**
     * 鍒ら閰嶇疆
     */
    private JudgeConfig judgeConfig;

    private static final long serialVersionUID = 1L;
}
