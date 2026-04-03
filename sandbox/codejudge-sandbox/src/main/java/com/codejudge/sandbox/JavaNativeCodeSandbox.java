package com.codejudge.sandbox;

import com.codejudge.sandbox.model.ExecuteCodeRequest;
import com.codejudge.sandbox.model.ExecuteCodeResponse;
import org.springframework.stereotype.Component;

/**
 * Java 鍘熺敓浠ｇ爜娌欑瀹炵幇锛堢洿鎺ュ鐢ㄦā鏉挎柟娉曪級
 */
@Component
public class JavaNativeCodeSandbox extends JavaCodeSandboxTemplate {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        return super.executeCode(executeCodeRequest);
    }
}

