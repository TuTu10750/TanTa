package com.umeng.commonsdk.deeplink;

import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public interface InstallParamsCallback {
    void onFailure(int i, String str);

    void onSuccess(Map<String, Object> map);
}
