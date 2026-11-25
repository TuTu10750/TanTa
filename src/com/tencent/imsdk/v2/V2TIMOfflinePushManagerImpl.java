package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.offlinepush.EnterBackgroundParam;
import com.tencent.imsdk.offlinepush.EnterForegroundParam;
import com.tencent.imsdk.offlinepush.OfflinePushManager;

/* loaded from: /tmp/classes2.dex */
public class V2TIMOfflinePushManagerImpl extends V2TIMOfflinePushManager {
    private static final String TAG = "V2TIMOfflinePushManagerImpl";

    /* loaded from: /tmp/classes2.dex */
    public static class V2TIMOfflinePushManagerImplHolder {
        private static final V2TIMOfflinePushManagerImpl v2TIMOfflinePushManagerImpl = new V2TIMOfflinePushManagerImpl();

        private V2TIMOfflinePushManagerImplHolder() {
        }
    }

    public static V2TIMOfflinePushManagerImpl getInstance() {
        return V2TIMOfflinePushManagerImplHolder.v2TIMOfflinePushManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doBackground(int i, V2TIMCallback v2TIMCallback) {
        if (i < 0) {
            i = 0;
        }
        int instanceType = SystemUtil.getInstanceType();
        EnterBackgroundParam enterBackgroundParam = new EnterBackgroundParam();
        enterBackgroundParam.setC2cUnreadMessageCount(i);
        enterBackgroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterBackground(enterBackgroundParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.2
            public void fail(int i2, String str) {
                super.fail(i2, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doForeground(V2TIMCallback v2TIMCallback) {
        int instanceType = SystemUtil.getInstanceType();
        EnterForegroundParam enterForegroundParam = new EnterForegroundParam();
        enterForegroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterForeground(enterForegroundParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.3
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, V2TIMCallback v2TIMCallback) {
        if (v2TIMOfflinePushConfig == null) {
            v2TIMOfflinePushConfig = new V2TIMOfflinePushConfig(0L, "");
        }
        v2TIMOfflinePushConfig.getOfflinePushToken().setDeviceBrand(SystemUtil.getInstanceType());
        OfflinePushManager.getInstance().setOfflinePushToken(v2TIMOfflinePushConfig.getOfflinePushToken(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.1
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }
}
