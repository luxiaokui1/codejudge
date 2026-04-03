package com.codejudge.platform.model.dto.post;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 鏇存柊璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class PostUpdateRequest implements Serializable {

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

    private static final long serialVersionUID = 1L;
}
