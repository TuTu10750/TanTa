package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: /tmp/classes2.dex */
public class ct implements cp {
    private int a;

    public ct(int i) {
        this.a = i;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        Context appContext;
        SharedPreferences a;
        try {
            appContext = UMGlobalContext.getAppContext();
        } catch (Throwable unused) {
        }
        if (appContext == null || (a = cz.a(appContext)) == null) {
            return false;
        }
        return a.getInt("cl_count", 0) >= this.a;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.cp
    public long c() {
        return 0L;
    }
}
