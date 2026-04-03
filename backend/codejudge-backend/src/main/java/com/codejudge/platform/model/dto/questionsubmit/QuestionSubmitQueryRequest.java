package com.codejudge.platform.model.dto.questionsubmit;

import com.codejudge.platform.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 鏌ヨ璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 缂栫▼璇█
     */
    private String language;

    /**
     * 鎻愪氦鐘舵€?
     */
    private Integer status;

    /**
     * 棰樼洰 id
     */
    private Long questionId;


    /**
     * 鐢ㄦ埛 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
