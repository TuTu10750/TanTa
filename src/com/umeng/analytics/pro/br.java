package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.cj1;

/* loaded from: /tmp/classes2.dex */
public class br implements bf {
    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = cj1.a(context);
        bu.a("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return cj1.b(context);
        }
        return null;
    }
}
