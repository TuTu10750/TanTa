package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class sv1 extends k50 {
    public static final a b = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final k50 a(fx1 fx1Var) {
            fx1Var.getClass();
            if (gx1.a(fx1Var)) {
                return null;
            }
            int i = 0;
            fx1 fx1Var2 = fx1Var;
            while (d.c0(fx1Var2)) {
                fx1Var2 = ((ta4) b30.y0(fx1Var2.L0())).getType();
                fx1Var2.getClass();
                i++;
            }
            z00 v = fx1Var2.N0().v();
            if (v instanceof m00) {
                q00 k = DescriptorUtilsKt.k(v);
                return k == null ? new sv1(new b.a(fx1Var)) : new sv1(k, i);
            }
            if (!(v instanceof oa4)) {
                return null;
            }
            q00 m = q00.m(e.a.b.l());
            m.getClass();
            return new sv1(m, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b {

        /* loaded from: /tmp/classes2.dex */
        public static final class a extends b {
            public final fx1 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(fx1 fx1Var) {
                super(null);
                fx1Var.getClass();
                this.a = fx1Var;
            }

            public final fx1 a() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && dq1.a(this.a, ((a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.a + ')';
            }
        }

        /* renamed from: sv1$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final class C0156b extends b {
            public final r00 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0156b(r00 r00Var) {
                super(null);
                r00Var.getClass();
                this.a = r00Var;
            }

            public final int a() {
                return this.a.c();
            }

            public final q00 b() {
                return this.a.d();
            }

            public final r00 c() {
                return this.a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0156b) && dq1.a(this.a, ((C0156b) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.a + ')';
            }
        }

        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sv1(q00 q00Var, int i) {
        this(new r00(q00Var, i));
        q00Var.getClass();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sv1(r00 r00Var) {
        this(new b.C0156b(r00Var));
        r00Var.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sv1(b bVar) {
        super(bVar);
        bVar.getClass();
    }

    @Override // defpackage.k50
    public fx1 a(mm2 mm2Var) {
        mm2Var.getClass();
        j h = j.b.h();
        m00 E = mm2Var.q().E();
        E.getClass();
        return KotlinTypeFactory.g(h, E, r20.e(new va4(c(mm2Var))));
    }

    public final fx1 c(mm2 mm2Var) {
        mm2Var.getClass();
        b bVar = (b) b();
        if (bVar instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVar instanceof b.C0156b)) {
            u.a();
            return null;
        }
        r00 c = ((b.C0156b) b()).c();
        q00 a2 = c.a();
        int b2 = c.b();
        m00 a3 = FindClassInModuleKt.a(mm2Var, a2);
        if (a3 == null) {
            ErrorTypeKind errorTypeKind = ErrorTypeKind.h;
            String q00Var = a2.toString();
            q00Var.getClass();
            return xu0.d(errorTypeKind, q00Var, String.valueOf(b2));
        }
        zp3 u = a3.u();
        u.getClass();
        fx1 y = TypeUtilsKt.y(u);
        for (int i = 0; i < b2; i++) {
            y = mm2Var.q().l(Variance.INVARIANT, y);
            y.getClass();
        }
        return y;
    }
}
