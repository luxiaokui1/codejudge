package com.codejudge.platform.model.dto.questionsubmit;

import lombok.Data;

import java.io.Serializable;

/**
 * 鍒涘缓璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class QuestionSubmitAddRequest implements Serializable {

    /**
     * 缂栫▼璇█
     */
    private String language;

    /**
     * 鐢ㄦ埛浠ｇ爜
     */
    private String code;

    /**
     * 棰樼洰 id
     */
    private Long questionId;

    private static final long serialVersionUID = 1L;
}
