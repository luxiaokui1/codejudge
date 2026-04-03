package com.codejudge.platform.judge.codesandbox.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExecuteCodeResponse {

    private List<String> outputList;

    /**
     * 鎺ュ彛淇℃伅
     */
    private String message;

    /**
     * 鎵ц鐘舵€?
     */
    private Integer status;

    /**
     * 鍒ら淇℃伅
     */
    private JudgeInfo judgeInfo;
}

