package com.codejudge.sandbox;


import com.codejudge.sandbox.model.ExecuteCodeRequest;
import com.codejudge.sandbox.model.ExecuteCodeResponse;

/**
 * 浠ｇ爜娌欑鎺ュ彛瀹氫箟
 */
public interface CodeSandbox {

    /**
     * 鎵ц浠ｇ爜
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}

