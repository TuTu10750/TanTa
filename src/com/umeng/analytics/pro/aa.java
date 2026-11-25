package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import defpackage.kc1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /tmp/classes2.dex */
public class aa implements z {
    private long a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.z
    public long a() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey == null) {
            kc1.a("Appkey is null or empty, Please check!");
            return null;
        }
        return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
    }

    @Override // com.umeng.analytics.pro.z
    public void a(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.z
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(x.b, 0L);
            edit.putLong(x.e, currentTimeMillis);
            edit.putLong(x.f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }

    @Override // com.umeng.analytics.pro.z
    public boolean a(long j, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j == 0 || currentTimeMillis - j >= this.a) && j2 > 0 && currentTimeMillis - j2 > this.a;
    }
}
