package com.codejudge.platform.judge.codesandbox.model;

import lombok.Data;

/**
 * 鍒ら淇℃伅
 */
@Data
public class JudgeInfo {

    /**
     * 绋嬪簭鎵ц淇℃伅
     */
    private String message;

    /**
     * 娑堣€楀唴瀛?     */
    private Long memory;

    /**
     * 娑堣€楁椂闂达紙KB锛?     */
    private Long time;
}

