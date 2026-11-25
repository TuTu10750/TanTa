package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: /tmp/classes2.dex */
public final class ue1 extends Handler {
    public final px2 a;
    public final int b;
    public final zu0 c;
    public boolean d;

    public ue1(zu0 zu0Var, Looper looper, int i) {
        super(looper);
        this.c = zu0Var;
        this.b = i;
        this.a = new px2();
    }

    public void a(uw3 uw3Var, Object obj) {
        ox2 a = ox2.a(uw3Var, obj);
        synchronized (this) {
            try {
                this.a.a(a);
                if (!this.d) {
                    this.d = true;
                    if (!sendMessage(obtainMessage())) {
                        throw new EventBusException("Could not send handler message");
                    }
                }
            } finally {
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                ox2 b = this.a.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.a.b();
                        if (b == null) {
                            this.d = false;
                            return;
                        }
                    }
                }
                this.c.f(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (!sendMessage(obtainMessage())) {
                throw new EventBusException("Could not send handler message");
            }
            this.d = true;
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }
}
