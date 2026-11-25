package defpackage;

import defpackage.uw2;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.internal.ZipFilesKt;

/* loaded from: /tmp/classes2.dex */
public final class pq4 extends n11 {
    public static final a i = new a(null);
    public static final uw2 j = uw2.a.e(uw2.b, "/", false, 1, null);
    public final uw2 e;
    public final n11 f;
    public final Map g;
    public final String h;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public pq4(uw2 uw2Var, n11 n11Var, Map map, String str) {
        uw2Var.getClass();
        n11Var.getClass();
        map.getClass();
        this.e = uw2Var;
        this.f = n11Var;
        this.g = map;
        this.h = str;
    }

    private final List s(uw2 uw2Var, boolean z) {
        mq4 mq4Var = (mq4) this.g.get(r(uw2Var));
        if (mq4Var != null) {
            return b30.I0(mq4Var.b());
        }
        if (!z) {
            return null;
        }
        nq4.a("not a directory: ", uw2Var);
        return null;
    }

    @Override // defpackage.n11
    public kq3 b(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.n11
    public void c(uw2 uw2Var, uw2 uw2Var2) {
        uw2Var.getClass();
        uw2Var2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.n11
    public void g(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.n11
    public void i(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.n11
    public List k(uw2 uw2Var) {
        uw2Var.getClass();
        List s = s(uw2Var, true);
        s.getClass();
        return s;
    }

    @Override // defpackage.n11
    public k11 m(uw2 uw2Var) {
        k11 k11Var;
        Throwable th;
        uw2Var.getClass();
        mq4 mq4Var = (mq4) this.g.get(r(uw2Var));
        Throwable th2 = null;
        if (mq4Var == null) {
            return null;
        }
        k11 k11Var2 = new k11(!mq4Var.h(), mq4Var.h(), null, mq4Var.h() ? null : Long.valueOf(mq4Var.g()), null, mq4Var.e(), null, null, 128, null);
        if (mq4Var.f() == -1) {
            return k11Var2;
        }
        e11 n = this.f.n(this.e);
        try {
            sk d = qs2.d(n.m0(mq4Var.f()));
            try {
                k11Var = ZipFilesKt.h(d, k11Var2);
                if (d != null) {
                    try {
                        d.close();
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                th = null;
            } catch (Throwable th4) {
                if (d != null) {
                    try {
                        d.close();
                    } catch (Throwable th5) {
                        qv0.a(th4, th5);
                    }
                }
                th = th4;
                k11Var = null;
            }
        } catch (Throwable th6) {
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable th7) {
                    qv0.a(th6, th7);
                }
            }
            k11Var = null;
            th2 = th6;
        }
        if (th != null) {
            throw th;
        }
        k11Var.getClass();
        if (n != null) {
            try {
                n.close();
            } catch (Throwable th8) {
                th2 = th8;
            }
        }
        if (th2 != null) {
            throw th2;
        }
        k11Var.getClass();
        return k11Var;
    }

    @Override // defpackage.n11
    public e11 n(uw2 uw2Var) {
        uw2Var.getClass();
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // defpackage.n11
    public kq3 p(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // defpackage.n11
    public wr3 q(uw2 uw2Var) {
        sk skVar;
        uw2Var.getClass();
        mq4 mq4Var = (mq4) this.g.get(r(uw2Var));
        Throwable th = null;
        if (mq4Var == null) {
            oq4.a("no such file: ", uw2Var);
            return null;
        }
        e11 n = this.f.n(this.e);
        try {
            skVar = qs2.d(n.m0(mq4Var.f()));
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (n != null) {
                try {
                    n.close();
                } catch (Throwable th4) {
                    qv0.a(th3, th4);
                }
            }
            th = th3;
            skVar = null;
        }
        if (th != null) {
            throw th;
        }
        skVar.getClass();
        ZipFilesKt.k(skVar);
        return mq4Var.d() == 0 ? new s21(skVar, mq4Var.g(), true) : new s21(new lo1(new s21(skVar, mq4Var.c(), true), new Inflater(true)), mq4Var.g(), false);
    }

    public final uw2 r(uw2 uw2Var) {
        return j.l(uw2Var, true);
    }
}
