package com.codejudge.platform.judge.codesandbox;

import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeRequest;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CodeSandboxProxy implements CodeSandbox {

    private final CodeSandbox codeSandbox;


    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("浠ｇ爜娌欑璇锋眰淇℃伅锛? + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("浠ｇ爜娌欑鍝嶅簲淇℃伅锛? + executeCodeResponse.toString());
        return executeCodeResponse;
    }
}

