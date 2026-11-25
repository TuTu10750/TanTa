package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: /tmp/classes2.dex */
public class ai implements ad {
    private String a;
    private long b;

    public ai(String str, long j) {
        this.a = str;
        this.b = j;
    }

    @Override // com.umeng.analytics.pro.ad
    public boolean a() {
        try {
            String str = "interval_" + this.a;
            SharedPreferences a = av.a(UMGlobalContext.getAppContext());
            if (a == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - a.getLong(str, 0L);
            if (currentTimeMillis > this.b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.ad
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ad
    public long c() {
        return 0L;
    }
}
