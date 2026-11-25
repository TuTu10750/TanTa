package com.umeng.analytics.pro;

/* loaded from: /tmp/classes2.dex */
public class ag implements ad {
    private long a;

    public ag(long j) {
        this.a = j;
    }

    @Override // com.umeng.analytics.pro.ad
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.ad
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ad
    public long c() {
        return this.a;
    }
}
