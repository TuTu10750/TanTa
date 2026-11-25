package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;

/* loaded from: /tmp/classes2.dex */
public class cs implements cp {
    private final String a;
    private final long b;

    public cs(String str, long j) {
        this.a = str;
        this.b = j;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        Context appContext;
        SharedPreferences a;
        try {
            appContext = UMGlobalContext.getAppContext();
        } catch (Throwable unused) {
        }
        if (appContext == null || this.a == null || (a = cz.a(appContext)) == null) {
            return false;
        }
        long j = a.getLong("interval_" + HelperUtils.getMD5(this.a), 0L);
        if (j == 0) {
            return true;
        }
        return (System.currentTimeMillis() - j) / 1000 >= this.b;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.cp
    public long c() {
        return 0L;
    }

    public void d() {
        SharedPreferences a;
        try {
            Context appContext = UMGlobalContext.getAppContext();
            if (appContext != null && this.a != null && (a = cz.a(appContext)) != null) {
                a.edit().putLong("interval_" + HelperUtils.getMD5(this.a), System.currentTimeMillis()).apply();
            }
        } catch (Throwable unused) {
        }
    }
}
