package com.codejudge.platform.model.dto.postfavour;

import com.codejudge.platform.common.PageRequest;
import com.codejudge.platform.model.dto.post.PostQueryRequest;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 甯栧瓙鏀惰棌鏌ヨ璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * 甯栧瓙鏌ヨ璇锋眰
     */
    private PostQueryRequest postQueryRequest;

    /**
     * 鐢ㄦ埛 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
