package com.umeng.powersdk;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.umeng.analytics.pro.cl;

/* loaded from: /tmp/classes2.dex */
public final class b {
    private static Context a;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final b a = new b(0);
    }

    private b() {
    }

    public /* synthetic */ b(byte b) {
        this();
    }

    public static b a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return a.a;
    }

    public final synchronized com.umeng.powersdk.a a() {
        com.umeng.powersdk.a aVar;
        com.umeng.powersdk.a aVar2 = null;
        try {
            Intent registerReceiver = a.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i = 0;
            int intExtra = registerReceiver.getIntExtra("level", 0);
            int intExtra2 = registerReceiver.getIntExtra("voltage", 0);
            int intExtra3 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra4 = registerReceiver.getIntExtra(cl.i, 0);
            int i2 = -1;
            if (intExtra4 != 1) {
                if (intExtra4 == 2) {
                    i2 = 1;
                } else if (intExtra4 == 3 || intExtra4 == 4) {
                    i2 = 0;
                } else if (intExtra4 == 5) {
                    i2 = 2;
                }
            }
            int intExtra5 = registerReceiver.getIntExtra("plugged", 0);
            if (intExtra5 == 1) {
                i = 1;
            } else if (intExtra5 == 2) {
                i = 2;
            }
            aVar = new com.umeng.powersdk.a();
            try {
                aVar.a = intExtra;
                aVar.b = intExtra2;
                aVar.d = i2;
                aVar.c = intExtra3;
                aVar.e = i;
                aVar.f = System.currentTimeMillis();
            } catch (Throwable unused) {
                aVar2 = aVar;
                aVar = aVar2;
                return aVar;
            }
        } catch (Throwable unused2) {
        }
        return aVar;
    }
}
