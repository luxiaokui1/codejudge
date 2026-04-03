package com.codejudge.sandbox.model;

import lombok.Data;

/**
 * 杩涚▼鎵ц淇℃伅
 */
@Data
public class ExecuteMessage {

    private Integer exitValue;

    private String message;

    private String errorMessage;

    private Long time;

    private Long memory;
}

