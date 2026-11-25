package defpackage;

import defpackage.uw2;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.internal.ResourceFileSystem;

/* loaded from: /tmp/classes2.dex */
public abstract class n11 {
    public static final a a = new a(null);
    public static final n11 b;
    public static final uw2 c;
    public static final n11 d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        n11 jv1Var;
        try {
            Class.forName("java.nio.file.Files");
            jv1Var = new hq2();
        } catch (ClassNotFoundException unused) {
            jv1Var = new jv1();
        }
        b = jv1Var;
        uw2.a aVar = uw2.b;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        c = uw2.a.e(aVar, property, false, 1, null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        classLoader.getClass();
        d = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public final kq3 a(uw2 uw2Var) {
        uw2Var.getClass();
        return b(uw2Var, false);
    }

    public abstract kq3 b(uw2 uw2Var, boolean z);

    public abstract void c(uw2 uw2Var, uw2 uw2Var2);

    public final void d(uw2 uw2Var) {
        uw2Var.getClass();
        e(uw2Var, false);
    }

    public final void e(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        h.a(this, uw2Var, z);
    }

    public final void f(uw2 uw2Var) {
        uw2Var.getClass();
        g(uw2Var, false);
    }

    public abstract void g(uw2 uw2Var, boolean z);

    public final void h(uw2 uw2Var) {
        uw2Var.getClass();
        i(uw2Var, false);
    }

    public abstract void i(uw2 uw2Var, boolean z);

    public final boolean j(uw2 uw2Var) {
        uw2Var.getClass();
        return h.b(this, uw2Var);
    }

    public abstract List k(uw2 uw2Var);

    public final k11 l(uw2 uw2Var) {
        uw2Var.getClass();
        return h.c(this, uw2Var);
    }

    public abstract k11 m(uw2 uw2Var);

    public abstract e11 n(uw2 uw2Var);

    public final kq3 o(uw2 uw2Var) {
        uw2Var.getClass();
        return p(uw2Var, false);
    }

    public abstract kq3 p(uw2 uw2Var, boolean z);

    public abstract wr3 q(uw2 uw2Var);
}
