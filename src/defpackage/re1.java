package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class re1 extends se1 implements jj0 {
    public final Handler b;
    public final String c;
    public final boolean d;
    public final re1 e;

    public re1(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ re1(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public re1(Handler handler, String str, boolean z) {
        super(null);
        this.b = handler;
        this.c = str;
        this.d = z;
        this.e = z ? this : new re1(handler, str, true);
    }

    public static void F0(zu zuVar, re1 re1Var) {
        zuVar.e(re1Var, qc4.a);
    }

    public static qc4 G0(re1 re1Var, Runnable runnable, Throwable th) {
        re1Var.b.removeCallbacks(runnable);
        return qc4.a;
    }

    public final void H0(d dVar, Runnable runnable) {
        tt1.c(dVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        in0.b().y0(dVar, runnable);
    }

    @Override // defpackage.ra2
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public re1 D0() {
        return this.e;
    }

    @Override // defpackage.jj0
    public void T(long j, final zu zuVar) {
        final Runnable runnable = new Runnable() { // from class: pe1
            @Override // java.lang.Runnable
            public final void run() {
                re1.F0(zu.this, this);
            }
        };
        if (this.b.postDelayed(runnable, fb3.h(j, 4611686018427387903L))) {
            zuVar.d(new n81() { // from class: qe1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return re1.G0(re1.this, runnable, (Throwable) obj);
                }
            });
        } else {
            H0(zuVar.getContext(), runnable);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof re1)) {
            return false;
        }
        re1 re1Var = (re1) obj;
        return re1Var.b == this.b && re1Var.d == this.d;
    }

    public int hashCode() {
        return (this.d ? 1231 : 1237) ^ System.identityHashCode(this.b);
    }

    @Override // defpackage.n70
    public String toString() {
        String E0 = E0();
        if (E0 == null) {
            E0 = this.c;
            if (E0 == null) {
                E0 = this.b.toString();
            }
            if (this.d) {
                return E0 + ".immediate";
            }
        }
        return E0;
    }

    @Override // defpackage.n70
    public void y0(d dVar, Runnable runnable) {
        if (this.b.post(runnable)) {
            return;
        }
        H0(dVar, runnable);
    }

    @Override // defpackage.n70
    public boolean z0(d dVar) {
        return (this.d && dq1.a(Looper.myLooper(), this.b.getLooper())) ? false : true;
    }
}
