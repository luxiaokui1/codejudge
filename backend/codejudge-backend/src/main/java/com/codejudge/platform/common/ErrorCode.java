package com.codejudge.platform.common;

/**
 * 鑷畾涔夐敊璇爜
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public enum ErrorCode {

    SUCCESS(0, "ok"),
    PARAMS_ERROR(40000, "璇锋眰鍙傛暟閿欒"),
    NOT_LOGIN_ERROR(40100, "鏈櫥褰?),
    NO_AUTH_ERROR(40101, "鏃犳潈闄?),
    NOT_FOUND_ERROR(40400, "璇锋眰鏁版嵁涓嶅瓨鍦?),
    FORBIDDEN_ERROR(40300, "绂佹璁块棶"),
    SYSTEM_ERROR(50000, "绯荤粺鍐呴儴寮傚父"),
    OPERATION_ERROR(50001, "鎿嶄綔澶辫触"),
    API_REQUEST_ERROR(50010, "鎺ュ彛璋冪敤澶辫触");

    /**
     * 鐘舵€佺爜
     */
    private final int code;

    /**
     * 淇℃伅
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

