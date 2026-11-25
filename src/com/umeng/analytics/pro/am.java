package com.umeng.analytics.pro;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class am {
    private String a;
    private boolean e = false;
    private int d = -1;
    private int c = -1;
    private int b = -1;

    public am(String str) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            boolean contains = this.a.contains("-");
            String str = this.a;
            if (!contains) {
                this.d = Integer.valueOf(str).intValue();
                this.e = false;
                return;
            }
            String[] split = str.split("-");
            if (split.length == 2) {
                this.b = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                this.c = intValue;
                if (this.b < 1) {
                    this.b = 1;
                }
                if (intValue > 24) {
                    this.c = 24;
                }
            }
            this.e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i) {
        int i2;
        if (this.e) {
            int i3 = this.b;
            return i3 != -1 && (i2 = this.c) != -1 && i >= i3 && i <= i2;
        }
        int i4 = this.d;
        return i4 != -1 && i == i4;
    }
}
