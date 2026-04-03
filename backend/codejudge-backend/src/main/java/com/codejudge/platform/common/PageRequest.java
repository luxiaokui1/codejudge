package com.codejudge.platform.common;

import com.codejudge.platform.constant.CommonConstant;
import lombok.Data;

/**
 * 鍒嗛〉璇锋眰
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
@Data
public class PageRequest {

    /**
     * 褰撳墠椤靛彿
     */
    private long current = 1;

    /**
     * 椤甸潰澶у皬
     */
    private long pageSize = 10;

    /**
     * 鎺掑簭瀛楁
     */
    private String sortField;

    /**
     * 鎺掑簭椤哄簭锛堥粯璁ゅ崌搴忥級
     */
    private String sortOrder = CommonConstant.SORT_ORDER_ASC;
}

