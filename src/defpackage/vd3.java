package defpackage;

import defpackage.ax1;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.builtins.e;

/* loaded from: /tmp/classes2.dex */
public final class vd3 implements ax1 {
    public final ClassLoader a;
    public final zk b;

    public vd3(ClassLoader classLoader) {
        classLoader.getClass();
        this.a = classLoader;
        this.b = new zk();
    }

    @Override // defpackage.ax1
    public ax1.a a(lr1 lr1Var, cv1 cv1Var) {
        String b;
        lr1Var.getClass();
        cv1Var.getClass();
        r51 d = lr1Var.d();
        if (d == null || (b = d.b()) == null) {
            return null;
        }
        return d(b);
    }

    @Override // defpackage.ax1
    public ax1.a b(q00 q00Var, cv1 cv1Var) {
        String b;
        q00Var.getClass();
        cv1Var.getClass();
        b = wd3.b(q00Var);
        return d(b);
    }

    @Override // defpackage.ex1
    public InputStream c(r51 r51Var) {
        r51Var.getClass();
        if (r51Var.i(e.u)) {
            return this.b.a(vk.r.r(r51Var));
        }
        return null;
    }

    public final ax1.a d(String str) {
        ud3 a;
        Class a2 = bd3.a(this.a, str);
        if (a2 == null || (a = ud3.c.a(a2)) == null) {
            return null;
        }
        return new ax1.a.C0001a(a, null, 2, null);
    }
}
