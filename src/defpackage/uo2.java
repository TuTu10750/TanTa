package defpackage;

import android.os.Handler;
import android.os.SystemClock;

/* loaded from: /tmp/classes2.dex */
public class uo2 {
    public long a;
    public int b;
    public c f;
    public final StringBuilder e = new StringBuilder();
    public final Runnable c = new a();
    public final Handler d = new Handler();

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            uo2.c(uo2.this);
            if (uo2.this.b < 0) {
                uo2.this.b = 0;
            }
            if (uo2.this.f != null) {
                boolean z = uo2.this.f instanceof b;
                uo2 uo2Var = uo2.this;
                if (z) {
                    ((b) uo2Var.f).b(uo2.this.b);
                } else {
                    uo2Var.f.a(uo2.this.j());
                }
            }
            int i = uo2.this.b;
            uo2 uo2Var2 = uo2.this;
            if (i > 0) {
                uo2.g(uo2Var2, 1000L);
                uo2.this.d.postAtTime(uo2.this.c, uo2.this.a);
            } else if (uo2Var2.f != null) {
                uo2.this.f.c();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b extends c {
        void b(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(String str);

        void c();
    }

    public static /* synthetic */ int c(uo2 uo2Var) {
        int i = uo2Var.b;
        uo2Var.b = i - 1;
        return i;
    }

    public static /* synthetic */ long g(uo2 uo2Var, long j) {
        long j2 = uo2Var.a + j;
        uo2Var.a = j2;
        return j2;
    }

    public final String j() {
        int i = this.b;
        int i2 = i / 3600;
        int i3 = i % 3600;
        int i4 = i3 > 0 ? i3 / 60 : 0;
        int i5 = i % 60;
        StringBuilder sb = this.e;
        sb.delete(0, sb.length());
        if (i2 > 0) {
            if (i2 < 10) {
                this.e.append("0");
            }
            this.e.append(i2);
            this.e.append(":");
        }
        if (i4 > 0) {
            if (i4 < 10) {
                this.e.append("0");
            }
            this.e.append(i4);
            this.e.append(":");
        } else {
            this.e.append("00:");
        }
        if (i5 > 0) {
            if (i5 < 10) {
                this.e.append("0");
            }
            this.e.append(i5);
        } else {
            this.e.append("00");
        }
        String sb2 = this.e.toString();
        lx1.c("倒计时", "getTimeString-------->".concat(sb2));
        return sb2;
    }

    public void k() {
        this.d.removeCallbacks(this.c);
        this.f = null;
        lx1.c("倒计时", "release-------->");
    }

    public uo2 l(c cVar) {
        this.f = cVar;
        return this;
    }

    public uo2 m(int i) {
        this.b = i;
        return this;
    }

    public uo2 n() {
        long uptimeMillis = SystemClock.uptimeMillis() + 1000;
        this.a = uptimeMillis;
        this.d.postAtTime(this.c, uptimeMillis);
        c cVar = this.f;
        if (cVar != null) {
            if (cVar instanceof b) {
                ((b) cVar).b(this.b);
            } else {
                cVar.a(j());
            }
        }
        lx1.c("倒计时", "start-------->");
        return this;
    }

    public void o() {
        this.d.removeCallbacks(this.c);
    }
}
