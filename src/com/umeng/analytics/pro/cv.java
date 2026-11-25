package com.umeng.analytics.pro;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class cv implements cp {
    private String a;
    private String b;

    public cv(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean a() {
        try {
            if (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b)) {
                long currentTimeMillis = System.currentTimeMillis();
                return currentTimeMillis >= da.a(this.a) && currentTimeMillis <= da.a(this.b);
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
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
