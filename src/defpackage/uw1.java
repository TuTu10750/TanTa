package defpackage;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;

/* loaded from: /tmp/classes2.dex */
public class uw1 {
    public View a;
    public Handler b;
    public Rect c = new Rect();
    public int d;
    public int e;
    public c f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                uw1.this.e();
            } catch (OutOfMemoryError e) {
                uw1.this.j("handle keyboard frame oom", e);
            } catch (RuntimeException e2) {
                if (!uw1.this.g(e2)) {
                    throw e2;
                }
                uw1.this.j("handle keyboard frame dead system", e2);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                uw1.this.f();
            } catch (OutOfMemoryError e) {
                uw1.this.j("init keyboard frame oom", e);
            } catch (RuntimeException e2) {
                if (!uw1.this.g(e2)) {
                    throw e2;
                }
                uw1.this.j("init keyboard frame dead system", e2);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void h(int i);
    }

    public uw1(View view, c cVar) {
        this.a = view;
        this.f = cVar;
        a aVar = new a();
        this.b = aVar;
        aVar.postDelayed(new b(), 200L);
    }

    public final void e() {
        if (k()) {
            int height = this.c.height();
            if (this.e != height) {
                int i = this.d - height;
                this.e = height;
                c cVar = this.f;
                if (cVar != null) {
                    cVar.h(i);
                }
            }
            h();
        }
    }

    public final void f() {
        if (k()) {
            int height = this.c.height();
            this.d = height;
            this.e = height;
            h();
        }
    }

    public final boolean g(Throwable th) {
        while (th != null) {
            String name = th.getClass().getName();
            if ("android.os.DeadSystemException".equals(name) || "android.os.DeadSystemRuntimeException".equals(name)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public final void h() {
        if (this.b != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.b.sendEmptyMessageAtTime(0, uptimeMillis + (200 - (uptimeMillis % 200)));
        }
    }

    public void i() {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.b = null;
        this.a = null;
        this.c = null;
        this.f = null;
        lx1.c("KeyBoardUtil", "---release--->");
    }

    public final void j(String str, Throwable th) {
        lx1.c("KeyBoardUtil", "---" + str + ", stop keyboard watcher--->" + th.getClass().getName() + ": " + th.getMessage());
        i();
    }

    public final boolean k() {
        View view = this.a;
        if (view != null && this.c != null && view.isAttachedToWindow()) {
            try {
                this.a.getWindowVisibleDisplayFrame(this.c);
                return true;
            } catch (OutOfMemoryError e) {
                j("getWindowVisibleDisplayFrame oom", e);
            } catch (RuntimeException e2) {
                if (g(e2)) {
                    j("getWindowVisibleDisplayFrame dead system", e2);
                } else {
                    lx1.c("KeyBoardUtil", "---getWindowVisibleDisplayFrame error--->" + e2.getMessage());
                }
                return false;
            }
        }
        return false;
    }
}
