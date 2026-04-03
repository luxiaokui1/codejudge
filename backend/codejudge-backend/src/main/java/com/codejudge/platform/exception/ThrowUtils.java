package com.codejudge.platform.exception;

import com.codejudge.platform.common.ErrorCode;

/**
 * 鎶涘紓甯稿伐鍏风被
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public class ThrowUtils {

    /**
     * 鏉′欢鎴愮珛鍒欐姏寮傚父
     *
     * @param condition
     * @param runtimeException
     */
    public static void throwIf(boolean condition, RuntimeException runtimeException) {
        if (condition) {
            throw runtimeException;
        }
    }

    /**
     * 鏉′欢鎴愮珛鍒欐姏寮傚父
     *
     * @param condition
     * @param errorCode
     */
    public static void throwIf(boolean condition, ErrorCode errorCode) {
        throwIf(condition, new BusinessException(errorCode));
    }

    /**
     * 鏉′欢鎴愮珛鍒欐姏寮傚父
     *
     * @param condition
     * @param errorCode
     * @param message
     */
    public static void throwIf(boolean condition, ErrorCode errorCode, String message) {
        throwIf(condition, new BusinessException(errorCode, message));
    }
}

