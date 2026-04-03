package com.codejudge.platform.model.dto.user;

import java.io.Serializable;
import lombok.Data;

/**
 * 鐢ㄦ埛鍒涘缓璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class UserAddRequest implements Serializable {

    /**
     * 鐢ㄦ埛鏄电О
     */
    private String userName;

    /**
     * 璐﹀彿
     */
    private String userAccount;

    /**
     * 鐢ㄦ埛澶村儚
     */
    private String userAvatar;

    /**
     * 鐢ㄦ埛瑙掕壊: user, admin
     */
    private String userRole;

    private static final long serialVersionUID = 1L;
}
