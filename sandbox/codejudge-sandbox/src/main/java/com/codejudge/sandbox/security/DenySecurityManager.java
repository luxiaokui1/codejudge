package com.codejudge.sandbox.security;

import java.security.Permission;

/**
 * 绂佺敤鎵€鏈夋潈闄愬畨鍏ㄧ鐞嗗櫒
 */
public class DenySecurityManager extends SecurityManager {

    // 妫€鏌ユ墍鏈夌殑鏉冮檺
    @Override
    public void checkPermission(Permission perm) {
        throw new SecurityException("鏉冮檺寮傚父锛? + perm.toString());
    }
}

