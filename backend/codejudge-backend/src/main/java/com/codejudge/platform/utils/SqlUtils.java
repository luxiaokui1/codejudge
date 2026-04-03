package com.codejudge.platform.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * SQL 宸ュ叿
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public class SqlUtils {

    /**
     * 鏍￠獙鎺掑簭瀛楁鏄惁鍚堟硶锛堥槻姝?SQL 娉ㄥ叆锛?
     *
     * @param sortField
     * @return
     */
    public static boolean validSortField(String sortField) {
        if (StringUtils.isBlank(sortField)) {
            return false;
        }
        return !StringUtils.containsAny(sortField, "=", "(", ")", " ");
    }
}

