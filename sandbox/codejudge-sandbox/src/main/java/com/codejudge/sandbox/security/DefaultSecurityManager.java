package com.codejudge.sandbox.security;

import java.security.Permission;

/**
 * 榛樿瀹夊叏绠＄悊鍣? */
public class DefaultSecurityManager extends SecurityManager {

    // 妫€鏌ユ墍鏈夌殑鏉冮檺
    @Override
    public void checkPermission(Permission perm) {
        System.out.println("榛樿涓嶅仛浠讳綍闄愬埗");
        System.out.println(perm);
//        super.checkPermission(perm);
    }
}

