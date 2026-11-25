package defpackage;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: /tmp/classes2.dex */
public final class at1 {
    public static final at1 a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final q00 f;
    public static final r51 g;
    public static final q00 h;
    public static final q00 i;
    public static final q00 j;
    public static final HashMap k;
    public static final HashMap l;
    public static final HashMap m;
    public static final HashMap n;
    public static final HashMap o;
    public static final HashMap p;
    public static final List q;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final q00 a;
        public final q00 b;
        public final q00 c;

        public a(q00 q00Var, q00 q00Var2, q00 q00Var3) {
            q00Var.getClass();
            q00Var2.getClass();
            q00Var3.getClass();
            this.a = q00Var;
            this.b = q00Var2;
            this.c = q00Var3;
        }

        public final q00 a() {
            return this.a;
        }

        public final q00 b() {
            return this.b;
        }

        public final q00 c() {
            return this.c;
        }

        public final q00 d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return dq1.a(this.a, aVar.a) && dq1.a(this.b, aVar.b) && dq1.a(this.c, aVar.c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.b + ", kotlinMutable=" + this.c + ')';
        }
    }

    static {
        at1 at1Var = new at1();
        a = at1Var;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.f;
        sb.append(functionClassKind.c().toString());
        sb.append('.');
        sb.append(functionClassKind.b());
        b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.h;
        sb2.append(functionClassKind2.c().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.b());
        c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.g;
        sb3.append(functionClassKind3.c().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.b());
        d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.i;
        sb4.append(functionClassKind4.c().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.b());
        e = sb4.toString();
        q00 m2 = q00.m(new r51("kotlin.jvm.functions.FunctionN"));
        m2.getClass();
        f = m2;
        r51 b2 = m2.b();
        b2.getClass();
        g = b2;
        kt3 kt3Var = kt3.a;
        h = kt3Var.k();
        i = kt3Var.j();
        j = at1Var.g(Class.class);
        k = new HashMap();
        l = new HashMap();
        m = new HashMap();
        n = new HashMap();
        o = new HashMap();
        p = new HashMap();
        q00 m3 = q00.m(e.a.U);
        m3.getClass();
        r51 r51Var = e.a.c0;
        r51 h2 = m3.h();
        r51 h3 = m3.h();
        h3.getClass();
        r51 g2 = kotlin.reflect.jvm.internal.impl.name.a.g(r51Var, h3);
        a aVar = new a(at1Var.g(Iterable.class), m3, new q00(h2, g2, false));
        q00 m4 = q00.m(e.a.T);
        m4.getClass();
        r51 r51Var2 = e.a.b0;
        r51 h4 = m4.h();
        r51 h5 = m4.h();
        h5.getClass();
        a aVar2 = new a(at1Var.g(Iterator.class), m4, new q00(h4, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var2, h5), false));
        q00 m5 = q00.m(e.a.V);
        m5.getClass();
        r51 r51Var3 = e.a.d0;
        r51 h6 = m5.h();
        r51 h7 = m5.h();
        h7.getClass();
        a aVar3 = new a(at1Var.g(Collection.class), m5, new q00(h6, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var3, h7), false));
        q00 m6 = q00.m(e.a.W);
        m6.getClass();
        r51 r51Var4 = e.a.e0;
        r51 h8 = m6.h();
        r51 h9 = m6.h();
        h9.getClass();
        a aVar4 = new a(at1Var.g(List.class), m6, new q00(h8, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var4, h9), false));
        q00 m7 = q00.m(e.a.Y);
        m7.getClass();
        r51 r51Var5 = e.a.g0;
        r51 h10 = m7.h();
        r51 h11 = m7.h();
        h11.getClass();
        a aVar5 = new a(at1Var.g(Set.class), m7, new q00(h10, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var5, h11), false));
        q00 m8 = q00.m(e.a.X);
        m8.getClass();
        r51 r51Var6 = e.a.f0;
        r51 h12 = m8.h();
        r51 h13 = m8.h();
        h13.getClass();
        a aVar6 = new a(at1Var.g(ListIterator.class), m8, new q00(h12, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var6, h13), false));
        r51 r51Var7 = e.a.Z;
        q00 m9 = q00.m(r51Var7);
        m9.getClass();
        r51 r51Var8 = e.a.h0;
        r51 h14 = m9.h();
        r51 h15 = m9.h();
        h15.getClass();
        a aVar7 = new a(at1Var.g(Map.class), m9, new q00(h14, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var8, h15), false));
        q00 d2 = q00.m(r51Var7).d(e.a.a0.g());
        d2.getClass();
        r51 r51Var9 = e.a.i0;
        r51 h16 = d2.h();
        r51 h17 = d2.h();
        h17.getClass();
        List n2 = s20.n(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, new a(at1Var.g(Map.Entry.class), d2, new q00(h16, kotlin.reflect.jvm.internal.impl.name.a.g(r51Var9, h17), false)));
        q = n2;
        at1Var.f(Object.class, e.a.b);
        at1Var.f(String.class, e.a.h);
        at1Var.f(CharSequence.class, e.a.g);
        at1Var.e(Throwable.class, e.a.u);
        at1Var.f(Cloneable.class, e.a.d);
        at1Var.f(Number.class, e.a.r);
        at1Var.e(Comparable.class, e.a.v);
        at1Var.f(Enum.class, e.a.s);
        at1Var.e(Annotation.class, e.a.G);
        Iterator it = n2.iterator();
        while (it.hasNext()) {
            a.d((a) it.next());
        }
        for (JvmPrimitiveType jvmPrimitiveType : JvmPrimitiveType.values()) {
            at1 at1Var2 = a;
            q00 m10 = q00.m(jvmPrimitiveType.j());
            m10.getClass();
            PrimitiveType i2 = jvmPrimitiveType.i();
            i2.getClass();
            q00 m11 = q00.m(e.c(i2));
            m11.getClass();
            at1Var2.a(m10, m11);
        }
        for (q00 q00Var : kotlin.reflect.jvm.internal.impl.builtins.a.a.a()) {
            at1 at1Var3 = a;
            q00 m12 = q00.m(new r51("kotlin.jvm.internal." + q00Var.j().b() + "CompanionObject"));
            m12.getClass();
            q00 d3 = q00Var.d(ls3.d);
            d3.getClass();
            at1Var3.a(m12, d3);
        }
        for (int i3 = 0; i3 < 23; i3++) {
            at1 at1Var4 = a;
            q00 m13 = q00.m(new r51("kotlin.jvm.functions.Function" + i3));
            m13.getClass();
            at1Var4.a(m13, e.a(i3));
            at1Var4.c(new r51(c + i3), h);
        }
        for (int i4 = 0; i4 < 22; i4++) {
            FunctionClassKind functionClassKind5 = FunctionClassKind.i;
            a.c(new r51((functionClassKind5.c().toString() + '.' + functionClassKind5.b()) + i4), h);
        }
        at1 at1Var5 = a;
        r51 l2 = e.a.c.l();
        l2.getClass();
        at1Var5.c(l2, at1Var5.g(Void.class));
    }

    public final void a(q00 q00Var, q00 q00Var2) {
        b(q00Var, q00Var2);
        r51 b2 = q00Var2.b();
        b2.getClass();
        c(b2, q00Var);
    }

    public final void b(q00 q00Var, q00 q00Var2) {
        HashMap hashMap = k;
        s51 j2 = q00Var.b().j();
        j2.getClass();
        hashMap.put(j2, q00Var2);
    }

    public final void c(r51 r51Var, q00 q00Var) {
        HashMap hashMap = l;
        s51 j2 = r51Var.j();
        j2.getClass();
        hashMap.put(j2, q00Var);
    }

    public final void d(a aVar) {
        q00 a2 = aVar.a();
        q00 b2 = aVar.b();
        q00 c2 = aVar.c();
        a(a2, b2);
        r51 b3 = c2.b();
        b3.getClass();
        c(b3, a2);
        o.put(c2, b2);
        p.put(b2, c2);
        r51 b4 = b2.b();
        b4.getClass();
        r51 b5 = c2.b();
        b5.getClass();
        HashMap hashMap = m;
        s51 j2 = c2.b().j();
        j2.getClass();
        hashMap.put(j2, b4);
        HashMap hashMap2 = n;
        s51 j3 = b4.j();
        j3.getClass();
        hashMap2.put(j3, b5);
    }

    public final void e(Class cls, r51 r51Var) {
        q00 g2 = g(cls);
        q00 m2 = q00.m(r51Var);
        m2.getClass();
        a(g2, m2);
    }

    public final void f(Class cls, s51 s51Var) {
        r51 l2 = s51Var.l();
        l2.getClass();
        e(cls, l2);
    }

    public final q00 g(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            q00 m2 = q00.m(new r51(cls.getCanonicalName()));
            m2.getClass();
            return m2;
        }
        q00 d2 = g(declaringClass).d(zo2.i(cls.getSimpleName()));
        d2.getClass();
        return d2;
    }

    public final r51 h() {
        return g;
    }

    public final List i() {
        return q;
    }

    public final boolean j(s51 s51Var, String str) {
        Integer p2;
        String b2 = s51Var.b();
        b2.getClass();
        String C0 = hw3.C0(b2, str, "");
        return C0.length() > 0 && !hw3.y0(C0, '0', false, 2, null) && (p2 = ew3.p(C0)) != null && p2.intValue() >= 23;
    }

    public final boolean k(s51 s51Var) {
        return m.containsKey(s51Var);
    }

    public final boolean l(s51 s51Var) {
        return n.containsKey(s51Var);
    }

    public final q00 m(r51 r51Var) {
        r51Var.getClass();
        return (q00) k.get(r51Var.j());
    }

    public final q00 n(s51 s51Var) {
        s51Var.getClass();
        if (!j(s51Var, b) && !j(s51Var, d)) {
            if (!j(s51Var, c) && !j(s51Var, e)) {
                return (q00) l.get(s51Var);
            }
            return h;
        }
        return f;
    }

    public final r51 o(s51 s51Var) {
        return (r51) m.get(s51Var);
    }

    public final r51 p(s51 s51Var) {
        return (r51) n.get(s51Var);
    }
}
