package defpackage;

import defpackage.sk0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class wi3 {
    public static final a c = new a(null);
    public final rk0 a;
    public final qv2 b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final wi3 a(ClassLoader classLoader) {
            classLoader.getClass();
            vd3 vd3Var = new vd3(classLoader);
            sk0.a aVar = sk0.b;
            ClassLoader classLoader2 = qc4.class.getClassLoader();
            classLoader2.getClass();
            sk0.a.C0155a a = aVar.a(vd3Var, new vd3(classLoader2), new ad3(classLoader), "runtime module for " + classLoader, vi3.b, xi3.a);
            return new wi3(a.a().a(), new qv2(a.b(), vd3Var), null);
        }
    }

    public wi3(rk0 rk0Var, qv2 qv2Var) {
        this.a = rk0Var;
        this.b = qv2Var;
    }

    public /* synthetic */ wi3(rk0 rk0Var, qv2 qv2Var, DefaultConstructorMarker defaultConstructorMarker) {
        this(rk0Var, qv2Var);
    }

    public final rk0 a() {
        return this.a;
    }

    public final mm2 b() {
        return this.a.p();
    }

    public final qv2 c() {
        return this.b;
    }
}
