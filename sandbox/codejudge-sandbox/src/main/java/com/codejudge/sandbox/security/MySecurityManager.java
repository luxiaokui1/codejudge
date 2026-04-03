package com.codejudge.sandbox.security;

import java.security.Permission;

public class MySecurityManager extends SecurityManager {


    // 妫€鏌ユ墍鏈夌殑鏉冮檺
    @Override
    public void checkPermission(Permission perm) {
//        super.checkPermission(perm);
    }

    // 妫€娴嬬▼搴忔槸鍚﹀彲鎵ц鏂囦欢
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec 鏉冮檺寮傚父锛? + cmd);
    }

    // 妫€娴嬬▼搴忔槸鍚﹀厑璁歌鏂囦欢

    @Override
    public void checkRead(String file) {
        System.out.println(file);
        if (file.contains("C:\\code\\yuoj-code-sandbox")) {
            return;
        }
//        throw new SecurityException("checkRead 鏉冮檺寮傚父锛? + file);
    }

    // 妫€娴嬬▼搴忔槸鍚﹀厑璁稿啓鏂囦欢
    @Override
    public void checkWrite(String file) {
//        throw new SecurityException("checkWrite 鏉冮檺寮傚父锛? + file);
    }

    // 妫€娴嬬▼搴忔槸鍚﹀厑璁稿垹闄ゆ枃浠?    @Override
    public void checkDelete(String file) {
//        throw new SecurityException("checkDelete 鏉冮檺寮傚父锛? + file);
    }

    // 妫€娴嬬▼搴忔槸鍚﹀厑璁歌繛鎺ョ綉缁?    @Override
    public void checkConnect(String host, int port) {
//        throw new SecurityException("checkConnect 鏉冮檺寮傚父锛? + host + ":" + port);
    }
}

