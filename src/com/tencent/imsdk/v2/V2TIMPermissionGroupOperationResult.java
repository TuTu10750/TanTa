package com.tencent.imsdk.v2;

import com.tencent.imsdk.community.PermissionGroupOperationResult;

/* loaded from: /tmp/classes2.dex */
public class V2TIMPermissionGroupOperationResult {
    private PermissionGroupOperationResult permissionGroupOperationResult = new PermissionGroupOperationResult();

    public String getPermissionGroupID() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        return permissionGroupOperationResult != null ? permissionGroupOperationResult.getPermissionGroupID() : "";
    }

    public int getResultCode() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        if (permissionGroupOperationResult != null) {
            return permissionGroupOperationResult.getErrorCode();
        }
        return 0;
    }

    public String getResultMessage() {
        PermissionGroupOperationResult permissionGroupOperationResult = this.permissionGroupOperationResult;
        return permissionGroupOperationResult != null ? permissionGroupOperationResult.getErrorMessage() : "";
    }

    public void setPermissionGroupOperationResult(PermissionGroupOperationResult permissionGroupOperationResult) {
        this.permissionGroupOperationResult = permissionGroupOperationResult;
    }
}
