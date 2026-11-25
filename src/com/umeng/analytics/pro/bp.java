package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.bu2;

/* loaded from: /tmp/classes2.dex */
public class bp implements bf {
    private boolean a = false;

    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.a) {
            bu2.a(context);
            this.a = true;
        }
        boolean b = bu2.b();
        bu.a("getOAID", "isSupported", Boolean.valueOf(b));
        if (b) {
            return bu2.c(context);
        }
        return null;
    }
}
