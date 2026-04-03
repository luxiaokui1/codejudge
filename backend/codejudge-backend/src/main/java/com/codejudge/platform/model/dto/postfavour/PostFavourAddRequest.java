package com.codejudge.platform.model.dto.postfavour;

import java.io.Serializable;
import lombok.Data;

/**
 * 甯栧瓙鏀惰棌 / 鍙栨秷鏀惰棌璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class PostFavourAddRequest implements Serializable {

    /**
     * 甯栧瓙 id
     */
    private Long postId;

    private static final long serialVersionUID = 1L;
}
