package com.codejudge.platform.judge.codesandbox.impl;

import com.codejudge.platform.judge.codesandbox.CodeSandbox;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeRequest;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 绗笁鏂逛唬鐮佹矙绠憋紙璋冪敤缃戜笂鐜版垚鐨勪唬鐮佹矙绠憋級
 */
public class ThirdPartyCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("绗笁鏂逛唬鐮佹矙绠?);
        return null;
    }
}

