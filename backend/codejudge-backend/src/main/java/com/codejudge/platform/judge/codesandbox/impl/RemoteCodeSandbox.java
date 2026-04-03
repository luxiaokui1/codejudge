package com.codejudge.platform.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.codejudge.platform.common.ErrorCode;
import com.codejudge.platform.exception.BusinessException;
import com.codejudge.platform.judge.codesandbox.CodeSandbox;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeRequest;
import com.codejudge.platform.judge.codesandbox.model.ExecuteCodeResponse;
import org.apache.commons.lang3.StringUtils;

/**
 * 杩滅▼浠ｇ爜娌欑锛堝疄闄呰皟鐢ㄦ帴鍙ｇ殑娌欑锛?
 */
public class RemoteCodeSandbox implements CodeSandbox {

    // 瀹氫箟閴存潈璇锋眰澶村拰瀵嗛挜
    private static final String AUTH_REQUEST_HEADER = "auth";

    private static final String AUTH_REQUEST_SECRET = "secretKey";


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("杩滅▼浠ｇ爜娌欑");
        String url = System.getenv("SANDBOX_URL") != null ? System.getenv("SANDBOX_URL") : "http://localhost:8090/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .header(AUTH_REQUEST_HEADER, AUTH_REQUEST_SECRET)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)) {
            throw new BusinessException(ErrorCode.API_REQUEST_ERROR, "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}

