package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.du2;

/* loaded from: /tmp/classes2.dex */
class bn implements bf {
    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean a = du2.a();
        bu.a("getOAID", "isSupported", Boolean.valueOf(a));
        if (a) {
            return du2.b(context);
        }
        return null;
    }
}
