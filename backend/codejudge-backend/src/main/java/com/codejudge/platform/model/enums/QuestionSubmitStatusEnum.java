package com.codejudge.platform.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 棰樼洰鎻愪氦鏋氫妇
 *
 * @author <a href="https://github.com/liyupi">绋嬪簭鍛橀奔鐨?/a>
 * @from <a href="https://yupi.icu">缂栫▼瀵艰埅鐭ヨ瘑鏄熺悆</a>
 */
public enum QuestionSubmitStatusEnum {

    // 0 - 寰呭垽棰樸€? - 鍒ら涓€? - 鎴愬姛銆? - 澶辫触
    WAITING("绛夊緟涓?, 0),
    RUNNING("鍒ら涓?, 1),
    SUCCEED("鎴愬姛", 2),
    FAILED("澶辫触", 3);

    private final String text;

    private final Integer value;

    QuestionSubmitStatusEnum(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 鑾峰彇鍊煎垪琛?
     *
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 鏍规嵁 value 鑾峰彇鏋氫妇
     *
     * @param value
     * @return
     */
    public static QuestionSubmitStatusEnum getEnumByValue(Integer value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (QuestionSubmitStatusEnum anEnum : QuestionSubmitStatusEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}

