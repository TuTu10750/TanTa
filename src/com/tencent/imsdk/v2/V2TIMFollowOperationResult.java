package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.FollowOperationResult;
import java.io.Serializable;

/* loaded from: /tmp/classes2.dex */
public class V2TIMFollowOperationResult implements Serializable {
    private FollowOperationResult followOperationResult;

    public int getResultCode() {
        return this.followOperationResult.getResultCode();
    }

    public String getResultInfo() {
        return this.followOperationResult.getResultInfo();
    }

    public String getUserID() {
        return this.followOperationResult.getUserID();
    }

    public void setFollowOperationResult(FollowOperationResult followOperationResult) {
        this.followOperationResult = followOperationResult;
    }
}
