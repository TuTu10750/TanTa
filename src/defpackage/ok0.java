package defpackage;

import defpackage.om2;
import defpackage.yl4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public abstract class ok0 {
    public static final pk0 a;
    public static final pk0 b;
    public static final pk0 c;
    public static final pk0 d;
    public static final pk0 e;
    public static final pk0 f;
    public static final pk0 g;
    public static final pk0 h;
    public static final pk0 i;
    public static final Set j;
    public static final Map k;
    public static final pk0 l;
    public static final bc3 m;
    public static final bc3 n;
    public static final bc3 o;
    public static final om2 p;
    public static final Map q;

    /* loaded from: /tmp/classes2.dex */
    public static class a implements bc3 {
        @Override // defpackage.bc3
        public fx1 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b implements bc3 {
        @Override // defpackage.bc3
        public fx1 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c implements bc3 {
        @Override // defpackage.bc3
        public fx1 getType() {
            throw new IllegalStateException("This method should not be called");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class d extends lj0 {
        public d(am4 am4Var) {
            super(am4Var);
        }

        public static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "what";
            } else if (i != 2) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$1";
            if (i == 1 || i == 2) {
                objArr[2] = "isVisible";
            } else {
                objArr[2] = "hasContainingSourceFile";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0, types: [ra0, ya0] */
        /* JADX WARN: Type inference failed for: r3v1, types: [ra0] */
        /* JADX WARN: Type inference failed for: r3v2, types: [ra0] */
        /* JADX WARN: Type inference failed for: r3v4, types: [ra0] */
        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == 0) {
                g(1);
            }
            if (ra0Var == null) {
                g(2);
            }
            if (lk0.J(ya0Var) && h(ra0Var)) {
                return ok0.f(ya0Var, ra0Var);
            }
            if (ya0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) {
                a10 b = ((kotlin.reflect.jvm.internal.impl.descriptors.c) ya0Var).b();
                if (z && lk0.G(b) && lk0.J(b) && (ra0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) && lk0.J(ra0Var.b()) && ok0.f(ya0Var, ra0Var)) {
                    return true;
                }
            }
            while (ya0Var != 0) {
                ya0Var = ya0Var.b();
                if (((ya0Var instanceof m00) && !lk0.x(ya0Var)) || (ya0Var instanceof kv2)) {
                    break;
                }
            }
            if (ya0Var == 0) {
                return false;
            }
            while (ra0Var != null) {
                if (ya0Var == ra0Var) {
                    return true;
                }
                if (ra0Var instanceof kv2) {
                    return (ya0Var instanceof kv2) && ya0Var.d().equals(((kv2) ra0Var).d()) && lk0.b(ra0Var, ya0Var);
                }
                ra0Var = ra0Var.b();
            }
            return false;
        }

        public final boolean h(ra0 ra0Var) {
            if (ra0Var == null) {
                g(0);
            }
            return lk0.j(ra0Var) != yr3.a;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e extends lj0 {
        public e(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$2";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            ra0 q;
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            if (!ok0.a.e(bc3Var, ya0Var, ra0Var, z)) {
                return false;
            }
            if (bc3Var == ok0.n) {
                return true;
            }
            if (bc3Var == ok0.m || (q = lk0.q(ya0Var, m00.class)) == null || !(bc3Var instanceof a44)) {
                return false;
            }
            return ((a44) bc3Var).t().a().equals(q.a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class f extends lj0 {
        public f(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "from";
            } else if (i == 2) {
                objArr[0] = "whatDeclaration";
            } else if (i != 3) {
                objArr[0] = "what";
            } else {
                objArr[0] = "fromClass";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$3";
            if (i == 2 || i == 3) {
                objArr[2] = "doesReceiverFitForProtectedVisibility";
            } else {
                objArr[2] = "isVisible";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            m00 m00Var;
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            m00 m00Var2 = (m00) lk0.q(ya0Var, m00.class);
            m00 m00Var3 = (m00) lk0.r(ra0Var, m00.class, false);
            if (m00Var3 == null) {
                return false;
            }
            if (m00Var2 != null && lk0.x(m00Var2) && (m00Var = (m00) lk0.q(m00Var2, m00.class)) != null && lk0.H(m00Var3, m00Var)) {
                return true;
            }
            ya0 M = lk0.M(ya0Var);
            m00 m00Var4 = (m00) lk0.q(M, m00.class);
            if (m00Var4 == null) {
                return false;
            }
            if (lk0.H(m00Var3, m00Var4) && h(bc3Var, M, m00Var3)) {
                return true;
            }
            return e(bc3Var, ya0Var, m00Var3.b(), z);
        }

        public final boolean h(bc3 bc3Var, ya0 ya0Var, m00 m00Var) {
            if (ya0Var == null) {
                g(2);
            }
            if (m00Var == null) {
                g(3);
            }
            if (bc3Var == ok0.o) {
                return false;
            }
            if (!(ya0Var instanceof CallableMemberDescriptor) || (ya0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.c) || bc3Var == ok0.n) {
                return true;
            }
            if (bc3Var == ok0.m || bc3Var == null) {
                return false;
            }
            fx1 type = bc3Var.getType();
            return lk0.I(type, m00Var) || kotlin.reflect.jvm.internal.impl.types.e.a(type);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class g extends lj0 {
        public g(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$4";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            if (lk0.g(ra0Var).G(lk0.g(ya0Var))) {
                return ok0.p.a(ya0Var, ra0Var);
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class h extends lj0 {
        public h(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$5";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class i extends lj0 {
        public i(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$6";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            throw new IllegalStateException("This method shouldn't be invoked for LOCAL visibility");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class j extends lj0 {
        public j(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$7";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            throw new IllegalStateException("Visibility is unknown yet");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class k extends lj0 {
        public k(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$8";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return false;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class l extends lj0 {
        public l(am4 am4Var) {
            super(am4Var);
        }

        private static /* synthetic */ void g(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "what";
            } else {
                objArr[0] = "from";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities$9";
            objArr[2] = "isVisible";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.pk0
        public boolean e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
            if (ya0Var == null) {
                g(0);
            }
            if (ra0Var == null) {
                g(1);
            }
            return false;
        }
    }

    static {
        d dVar = new d(yl4.e.c);
        a = dVar;
        e eVar = new e(yl4.f.c);
        b = eVar;
        f fVar = new f(yl4.g.c);
        c = fVar;
        g gVar = new g(yl4.b.c);
        d = gVar;
        h hVar = new h(yl4.h.c);
        e = hVar;
        i iVar = new i(yl4.d.c);
        f = iVar;
        j jVar = new j(yl4.a.c);
        g = jVar;
        k kVar = new k(yl4.c.c);
        h = kVar;
        l lVar = new l(yl4.i.c);
        i = lVar;
        j = Collections.unmodifiableSet(eo3.h(dVar, eVar, gVar, iVar));
        HashMap e2 = q20.e(4);
        e2.put(eVar, 0);
        e2.put(dVar, 0);
        e2.put(gVar, 1);
        e2.put(fVar, 1);
        e2.put(hVar, 2);
        k = Collections.unmodifiableMap(e2);
        l = hVar;
        m = new a();
        n = new b();
        o = new c();
        Iterator it = ServiceLoader.load(om2.class, om2.class.getClassLoader()).iterator();
        p = it.hasNext() ? (om2) it.next() : om2.a.a;
        q = new HashMap();
        i(dVar);
        i(eVar);
        i(fVar);
        i(gVar);
        i(hVar);
        i(iVar);
        i(jVar);
        i(kVar);
        i(lVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(int r8) {
        /*
            r0 = 16
            if (r8 == r0) goto L7
            java.lang.String r1 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto L9
        L7:
            java.lang.String r1 = "@NotNull method %s.%s must not return null"
        L9:
            r2 = 3
            r3 = 2
            if (r8 == r0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r3
        L10:
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = "kotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibilities"
            r6 = 1
            r7 = 0
            if (r8 == r6) goto L3a
            if (r8 == r2) goto L3a
            r2 = 5
            if (r8 == r2) goto L3a
            r2 = 7
            if (r8 == r2) goto L3a
            switch(r8) {
                case 9: goto L3a;
                case 10: goto L35;
                case 11: goto L30;
                case 12: goto L35;
                case 13: goto L30;
                case 14: goto L2b;
                case 15: goto L2b;
                case 16: goto L28;
                default: goto L23;
            }
        L23:
            java.lang.String r2 = "what"
            r4[r7] = r2
            goto L3e
        L28:
            r4[r7] = r5
            goto L3e
        L2b:
            java.lang.String r2 = "visibility"
            r4[r7] = r2
            goto L3e
        L30:
            java.lang.String r2 = "second"
            r4[r7] = r2
            goto L3e
        L35:
            java.lang.String r2 = "first"
            r4[r7] = r2
            goto L3e
        L3a:
            java.lang.String r2 = "from"
            r4[r7] = r2
        L3e:
            java.lang.String r2 = "toDescriptorVisibility"
            if (r8 == r0) goto L45
            r4[r6] = r5
            goto L47
        L45:
            r4[r6] = r2
        L47:
            switch(r8) {
                case 2: goto L70;
                case 3: goto L70;
                case 4: goto L6b;
                case 5: goto L6b;
                case 6: goto L66;
                case 7: goto L66;
                case 8: goto L61;
                case 9: goto L61;
                case 10: goto L5c;
                case 11: goto L5c;
                case 12: goto L57;
                case 13: goto L57;
                case 14: goto L52;
                case 15: goto L4f;
                case 16: goto L74;
                default: goto L4a;
            }
        L4a:
            java.lang.String r2 = "isVisible"
            r4[r3] = r2
            goto L74
        L4f:
            r4[r3] = r2
            goto L74
        L52:
            java.lang.String r2 = "isPrivate"
            r4[r3] = r2
            goto L74
        L57:
            java.lang.String r2 = "compare"
            r4[r3] = r2
            goto L74
        L5c:
            java.lang.String r2 = "compareLocal"
            r4[r3] = r2
            goto L74
        L61:
            java.lang.String r2 = "findInvisibleMember"
            r4[r3] = r2
            goto L74
        L66:
            java.lang.String r2 = "inSameFile"
            r4[r3] = r2
            goto L74
        L6b:
            java.lang.String r2 = "isVisibleWithAnyReceiver"
            r4[r3] = r2
            goto L74
        L70:
            java.lang.String r2 = "isVisibleIgnoringReceiver"
            r4[r3] = r2
        L74:
            java.lang.String r1 = java.lang.String.format(r1, r4)
            if (r8 == r0) goto L80
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r1)
            goto L85
        L80:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            r8.<init>(r1)
        L85:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ok0.a(int):void");
    }

    public static Integer d(pk0 pk0Var, pk0 pk0Var2) {
        if (pk0Var == null) {
            a(12);
        }
        if (pk0Var2 == null) {
            a(13);
        }
        Integer a2 = pk0Var.a(pk0Var2);
        if (a2 != null) {
            return a2;
        }
        Integer a3 = pk0Var2.a(pk0Var);
        if (a3 != null) {
            return Integer.valueOf(-a3.intValue());
        }
        return null;
    }

    public static ya0 e(bc3 bc3Var, ya0 ya0Var, ra0 ra0Var, boolean z) {
        ya0 e2;
        if (ya0Var == null) {
            a(8);
        }
        if (ra0Var == null) {
            a(9);
        }
        for (ya0 ya0Var2 = (ya0) ya0Var.a(); ya0Var2 != null && ya0Var2.getVisibility() != f; ya0Var2 = (ya0) lk0.q(ya0Var2, ya0.class)) {
            if (!ya0Var2.getVisibility().e(bc3Var, ya0Var2, ra0Var, z)) {
                return ya0Var2;
            }
        }
        if (!(ya0Var instanceof q94) || (e2 = e(bc3Var, ((q94) ya0Var).n0(), ra0Var, z)) == null) {
            return null;
        }
        return e2;
    }

    public static boolean f(ra0 ra0Var, ra0 ra0Var2) {
        if (ra0Var == null) {
            a(6);
        }
        if (ra0Var2 == null) {
            a(7);
        }
        yr3 j2 = lk0.j(ra0Var2);
        if (j2 != yr3.a) {
            return j2.equals(lk0.j(ra0Var));
        }
        return false;
    }

    public static boolean g(pk0 pk0Var) {
        if (pk0Var == null) {
            a(14);
        }
        return pk0Var == a || pk0Var == b;
    }

    public static boolean h(ya0 ya0Var, ra0 ra0Var, boolean z) {
        if (ya0Var == null) {
            a(2);
        }
        if (ra0Var == null) {
            a(3);
        }
        return e(n, ya0Var, ra0Var, z) == null;
    }

    public static void i(pk0 pk0Var) {
        q.put(pk0Var.b(), pk0Var);
    }

    public static pk0 j(am4 am4Var) {
        if (am4Var == null) {
            a(15);
        }
        pk0 pk0Var = (pk0) q.get(am4Var);
        if (pk0Var != null) {
            return pk0Var;
        }
        n.a("Inapplicable visibility: ", am4Var);
        return null;
    }
}
