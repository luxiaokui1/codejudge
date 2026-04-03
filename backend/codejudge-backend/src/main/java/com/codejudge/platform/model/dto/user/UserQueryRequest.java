package com.codejudge.platform.model.dto.user;

import com.codejudge.platform.common.PageRequest;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 鐢ㄦ埛鏌ヨ璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserQueryRequest extends PageRequest implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 寮€鏀惧钩鍙癷d
     */
    private String unionId;

    /**
     * 鍏紬鍙穙penId
     */
    private String mpOpenId;

    /**
     * 鐢ㄦ埛鏄电О
     */
    private String userName;

    /**
     * 绠€浠?
     */
    private String userProfile;

    /**
     * 鐢ㄦ埛瑙掕壊锛歶ser/admin/ban
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}
