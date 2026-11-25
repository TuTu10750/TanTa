package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.dj1;

/* loaded from: /tmp/classes2.dex */
class bs implements bf {
    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean b = dj1.b();
        bu.a("getOAID", "isSupported", Boolean.valueOf(b));
        if (b) {
            return dj1.c(context);
        }
        return null;
    }
}
