package defpackage;

import android.content.Context;
import io.anyrtc.live.ArLiveEngine;

/* loaded from: /tmp/classes2.dex */
public abstract class ra {
    public static ArLiveEngine a;
    public static int b;

    public static synchronized ArLiveEngine a(Context context) {
        synchronized (ra.class) {
            if (context == null) {
                return null;
            }
            try {
                if (a == null) {
                    a = ArLiveEngine.create(context.getApplicationContext());
                }
                ArLiveEngine arLiveEngine = a;
                if (arLiveEngine != null) {
                    b++;
                }
                return arLiveEngine;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static synchronized void b(ArLiveEngine arLiveEngine) {
        synchronized (ra.class) {
            if (arLiveEngine != null) {
                ArLiveEngine arLiveEngine2 = a;
                if (arLiveEngine2 != null && arLiveEngine == arLiveEngine2) {
                    int i = b;
                    if (i > 0) {
                        b = i - 1;
                    }
                }
            }
        }
    }
}
