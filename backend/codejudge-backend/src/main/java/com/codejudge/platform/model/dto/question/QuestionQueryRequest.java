package com.codejudge.platform.model.dto.question;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.codejudge.platform.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 鏌ヨ璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QuestionQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

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
     * 鍒涘缓鐢ㄦ埛 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
