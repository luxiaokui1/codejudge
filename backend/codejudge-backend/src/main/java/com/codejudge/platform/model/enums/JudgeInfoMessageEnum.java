package com.codejudge.platform.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 鍒ら淇℃伅娑堟伅鏋氫妇
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public enum JudgeInfoMessageEnum {

    ACCEPTED("鎴愬姛", "Accepted"),
    WRONG_ANSWER("绛旀閿欒", "Wrong Answer"),
    COMPILE_ERROR("Compile Error", "缂栬瘧閿欒"),
    MEMORY_LIMIT_EXCEEDED("", "鍐呭瓨婧㈠嚭"),
    TIME_LIMIT_EXCEEDED("Time Limit Exceeded", "瓒呮椂"),
    PRESENTATION_ERROR("Presentation Error", "灞曠ず閿欒"),
    WAITING("Waiting", "绛夊緟涓?),
    OUTPUT_LIMIT_EXCEEDED("Output Limit Exceeded", "杈撳嚭婧㈠嚭"),
    DANGEROUS_OPERATION("Dangerous Operation", "鍗遍櫓鎿嶄綔"),
    RUNTIME_ERROR("Runtime Error", "杩愯閿欒"),
    SYSTEM_ERROR("System Error", "绯荤粺閿欒");

    private final String text;

    private final String value;

    JudgeInfoMessageEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 鑾峰彇鍊煎垪琛?
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 鏍规嵁 value 鑾峰彇鏋氫妇
     *
     * @param value
     * @return
     */
    public static JudgeInfoMessageEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (JudgeInfoMessageEnum anEnum : JudgeInfoMessageEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

