package defpackage;

import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.dao.IMMessageBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ck1 {
    public static ck1 b;
    public hj1 a = new m94();

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(IMMessageBean iMMessageBean, int i);

        void b(IMMessageBean iMMessageBean);

        void c(IMMessageBean iMMessageBean, boolean z);
    }

    public static ck1 e() {
        if (b == null) {
            synchronized (ck1.class) {
                try {
                    if (b == null) {
                        b = new ck1();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a() {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.j();
        }
    }

    public void b() {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.h();
        }
    }

    public void c(String str, k30 k30Var) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.l(str, k30Var);
        }
    }

    public void d(ImMessageBean imMessageBean, boolean z, k30 k30Var) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.i(imMessageBean, z, k30Var);
        }
    }

    public void f(k30 k30Var) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.a(k30Var);
        }
    }

    public void g(IMMessageBean iMMessageBean, k30 k30Var) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.p(iMMessageBean, k30Var);
        }
    }

    public ik1 h() {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            return hj1Var.e();
        }
        return null;
    }

    public void i(String str) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.r(str);
        }
    }

    public void j() {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.f();
        }
    }

    public void k() {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.q();
        }
    }

    public void l(String str) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.b(str);
        }
    }

    public void m(String str) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.g(str);
        }
    }

    public void n(String str, String str2) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.k(str, str2);
        }
    }

    public void o(String str, String str2, a aVar) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.m(str, str2, aVar);
        }
    }

    public void p(String str, int i, String str2, a aVar) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.o(str, i, str2, aVar);
        }
    }

    public void q(String str, String str2, a aVar) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.d(str, str2, aVar);
        }
    }

    public void r(List list, String str, Runnable runnable) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.c(list, str, runnable);
        }
    }

    public void s(boolean z) {
        hj1 hj1Var = this.a;
        if (hj1Var != null) {
            hj1Var.n(z);
        }
    }
}
