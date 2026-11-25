package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.analytics.pro.ba;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public class bb implements ba.a {

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final bb a = new bb();

        private a() {
        }
    }

    public static bb a() {
        return a.a;
    }

    @Override // com.umeng.analytics.pro.ba.a
    public void a(Object obj, int i) {
        JSONObject a2;
        if (i != 101) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]: unknown event type!");
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "[CkHandler]:recv CkDispatch.CHECK event!");
        Context appContext = UMGlobalContext.getAppContext();
        if (!UMConfigure.getInitStatus() || appContext == null || UMConfigure.needSendZcfgEnv(appContext) || com.umeng.commonsdk.utils.c.a() || FieldManager.allow(com.umeng.commonsdk.utils.d.aw) || SdkVersion.SDK_TYPE == 1 || !(obj instanceof bc)) {
            return;
        }
        try {
            JSONObject g = ((bc) obj).g();
            if (!g.has("eID") || (a2 = bd.a(appContext)) == null) {
                return;
            }
            bd.a(a2, g);
            aw.a(new ar(ar.c, a2, "appkey"), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }
}
