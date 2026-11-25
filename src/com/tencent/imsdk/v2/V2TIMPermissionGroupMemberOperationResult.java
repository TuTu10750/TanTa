package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupMemberOperationResult;

/* loaded from: /tmp/classes2.dex */
public class V2TIMPermissionGroupMemberOperationResult {
    PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = new PermissionGroupMemberOperationResult();

    public String getMemberID() {
        PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = this.permissionGroupMemberOperationResult;
        return permissionGroupMemberOperationResult == null ? "" : permissionGroupMemberOperationResult.getUserID();
    }

    public int getResultCode() {
        PermissionGroupMemberOperationResult permissionGroupMemberOperationResult = this.permissionGroupMemberOperationResult;
        if (permissionGroupMemberOperationResult == null) {
            return 0;
        }
        return permissionGroupMemberOperationResult.getResultCode();
    }

    public void setPermissionGroupMemberOperationResult(PermissionGroupMemberOperationResult permissionGroupMemberOperationResult) {
        this.permissionGroupMemberOperationResult = permissionGroupMemberOperationResult;
    }
}
