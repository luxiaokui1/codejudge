package com.codejudge.platform.judge.codesandbox;

import com.codejudge.platform.judge.codesandbox.impl.ExampleCodeSandbox;
import com.codejudge.platform.judge.codesandbox.impl.RemoteCodeSandbox;
import com.codejudge.platform.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * 浠ｇ爜娌欑宸ュ巶锛堟牴鎹瓧绗︿覆鍙傛暟鍒涘缓鎸囧畾鐨勪唬鐮佹矙绠卞疄渚嬶級
 */
public class CodeSandboxFactory {

    /**
     * 鍒涘缓浠ｇ爜娌欑绀轰緥
     *
     * @param type 娌欑绫诲瀷
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}

