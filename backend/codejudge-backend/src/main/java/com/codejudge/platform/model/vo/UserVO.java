package com.codejudge.platform.model.vo;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 鐢ㄦ埛瑙嗗浘锛堣劚鏁忥級
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class UserVO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 鐢ㄦ埛鏄电О
     */
    private String userName;

    /**
     * 鐢ㄦ埛澶村儚
     */
    private String userAvatar;

    /**
     * 鐢ㄦ埛绠€浠?
     */
    private String userProfile;

    /**
     * 鐢ㄦ埛瑙掕壊锛歶ser/admin/ban
     */
    private String userRole;

    /**
     * 鍒涘缓鏃堕棿
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
