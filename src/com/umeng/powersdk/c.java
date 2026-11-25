package com.umeng.powersdk;

import android.app.Activity;
import android.os.BatteryManager;
import com.efs.sdk.base.core.config.GlobalInfoManager;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public final class c {
    int a;
    int b;
    int c;
    WeakReference<Activity> d;
    boolean e;
    int f;
    boolean g;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final c a = new c(0);
    }

    private c() {
        this.a = 1;
        this.b = 0;
        this.c = 0;
        this.e = true;
    }

    public /* synthetic */ c(byte b) {
        this();
    }

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            BatteryManager batteryManager = (BatteryManager) PowerManager.getApplicationContext().getSystemService("batterymanager");
            if (batteryManager != null) {
                float longProperty = (float) batteryManager.getLongProperty(2);
                if (longProperty >= 10000.0f || longProperty <= -10000.0f) {
                    longProperty /= 1000.0f;
                }
                jSONObject.put("ci", Math.abs(longProperty));
            }
        } catch (Throwable unused) {
        }
        try {
            com.umeng.powersdk.a a2 = b.a(PowerManager.getApplicationContext()).a();
            jSONObject.put("le", a2.a);
            jSONObject.put("vo", a2.b);
            jSONObject.put("te", a2.c);
            jSONObject.put("st", a2.d);
            jSONObject.put("ch", a2.e);
            jSONObject.put("ts", a2.f);
            try {
                long longValue = ((Long) GlobalInfoManager.getInstance().getGlobalInfo().getGlobalInfoMap().get("stime")).longValue();
                if (longValue > 0) {
                    jSONObject.put("ptime", System.currentTimeMillis() - longValue);
                }
            } catch (Throwable unused2) {
            }
            WeakReference<Activity> weakReference = this.d;
            if (weakReference != null) {
                jSONObject.put("c_act", weakReference.get().getClass().getName());
            }
        } catch (Throwable unused3) {
        }
        return jSONObject;
    }
}
