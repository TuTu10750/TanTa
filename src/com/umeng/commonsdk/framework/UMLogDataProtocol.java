package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public interface UMLogDataProtocol {

    /* loaded from: /tmp/classes2.dex */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
