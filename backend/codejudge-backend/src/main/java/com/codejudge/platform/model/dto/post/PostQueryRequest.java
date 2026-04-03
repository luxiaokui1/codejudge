package com.codejudge.platform.model.dto.post;

import com.codejudge.platform.common.PageRequest;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 鏌ヨ璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PostQueryRequest extends PageRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * id
     */
    private Long notId;

    /**
     * 鎼滅储璇?
     */
    private String searchText;

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
     * 鑷冲皯鏈変竴涓爣绛?
     */
    private List<String> orTags;

    /**
     * 鍒涘缓鐢ㄦ埛 id
     */
    private Long userId;

    /**
     * 鏀惰棌鐢ㄦ埛 id
     */
    private Long favourUserId;

    private static final long serialVersionUID = 1L;
}
