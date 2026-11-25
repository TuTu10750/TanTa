package com.tencent.imsdk.v2;

import com.tencent.imsdk.offlinepush.OfflinePushToken;
import java.io.Serializable;

/* loaded from: /tmp/classes2.dex */
public class V2TIMOfflinePushConfig implements Serializable {
    private OfflinePushToken offlinePushToken;

    public V2TIMOfflinePushConfig(long j, String str) {
        OfflinePushToken offlinePushToken = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken;
        offlinePushToken.setBusinessID((int) j);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(false);
    }

    @Deprecated
    public V2TIMOfflinePushConfig(long j, String str, boolean z) {
        OfflinePushToken offlinePushToken = new OfflinePushToken();
        this.offlinePushToken = offlinePushToken;
        offlinePushToken.setBusinessID((int) j);
        this.offlinePushToken.setDeviceToken(str);
        this.offlinePushToken.setIsTPNSToken(z);
    }

    public OfflinePushToken getOfflinePushToken() {
        return this.offlinePushToken;
    }
}
