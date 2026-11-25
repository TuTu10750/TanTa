package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class ft1 {
    public final xs1 a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final fx1 a;
        public final int b;

        public a(fx1 fx1Var, int i) {
            this.a = fx1Var;
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public final fx1 b() {
            return this.a;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public final zp3 a;
        public final int b;
        public final boolean c;

        public b(zp3 zp3Var, int i, boolean z) {
            this.a = zp3Var;
            this.b = i;
            this.c = z;
        }

        public final boolean a() {
            return this.c;
        }

        public final int b() {
            return this.b;
        }

        public final zp3 c() {
            return this.a;
        }
    }

    public ft1(xs1 xs1Var) {
        xs1Var.getClass();
        this.a = xs1Var;
    }

    public static /* synthetic */ b c(ft1 ft1Var, zp3 zp3Var, n81 n81Var, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = false;
        }
        if ((i2 & 16) != 0) {
            z2 = false;
        }
        return ft1Var.b(zp3Var, n81Var, i, typeComponentPosition, z, z2);
    }

    public final fx1 a(fx1 fx1Var, n81 n81Var, boolean z) {
        fx1Var.getClass();
        n81Var.getClass();
        return d(fx1Var.Q0(), n81Var, 0, z).b();
    }

    public final b b(zp3 zp3Var, n81 n81Var, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        z00 v;
        z00 f;
        Boolean h;
        ea4 N0;
        du0 du0Var;
        j8 e;
        Boolean bool;
        a aVar;
        ta4 s;
        n81 n81Var2 = n81Var;
        boolean a2 = da4.a(typeComponentPosition);
        boolean z3 = (z2 && z) ? false : true;
        fx1 fx1Var = null;
        if ((a2 || !zp3Var.L0().isEmpty()) && (v = zp3Var.N0().v()) != null) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a aVar2 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a) n81Var2.invoke(Integer.valueOf(i));
            f = ia4.f(v, aVar2, typeComponentPosition);
            h = ia4.h(aVar2, typeComponentPosition);
            if (f == null || (N0 = f.k()) == null) {
                N0 = zp3Var.N0();
            }
            ea4 ea4Var = N0;
            ea4Var.getClass();
            int i2 = i + 1;
            List L0 = zp3Var.L0();
            List parameters = ea4Var.getParameters();
            parameters.getClass();
            Iterator it = L0.iterator();
            Iterator it2 = parameters.iterator();
            ArrayList arrayList = new ArrayList(Math.min(t20.v(L0, 10), t20.v(parameters, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                oa4 oa4Var = (oa4) it2.next();
                ta4 ta4Var = (ta4) next;
                if (z3) {
                    bool = h;
                    if (!ta4Var.c()) {
                        aVar = d(ta4Var.getType().Q0(), n81Var2, i2, z2);
                    } else if (((kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.a) n81Var2.invoke(Integer.valueOf(i2))).d() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                        gd4 Q0 = ta4Var.getType().Q0();
                        aVar = new a(KotlinTypeFactory.d(q31.c(Q0).R0(false), q31.d(Q0).R0(true)), 1);
                    } else {
                        aVar = new a(null, 1);
                    }
                } else {
                    bool = h;
                    aVar = new a(fx1Var, 0);
                }
                i2 += aVar.a();
                if (aVar.b() != null) {
                    fx1 b2 = aVar.b();
                    Variance b3 = ta4Var.b();
                    b3.getClass();
                    s = TypeUtilsKt.f(b2, b3, oa4Var);
                } else if (f == null || ta4Var.c()) {
                    s = f != null ? n.s(oa4Var) : null;
                } else {
                    fx1 type = ta4Var.getType();
                    type.getClass();
                    Variance b4 = ta4Var.b();
                    b4.getClass();
                    s = TypeUtilsKt.f(type, b4, oa4Var);
                }
                arrayList.add(s);
                n81Var2 = n81Var;
                h = bool;
                fx1Var = null;
            }
            Boolean bool2 = h;
            int i3 = i2 - i;
            if (f == null && bool2 == null) {
                if (!arrayList.isEmpty()) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        if (((ta4) it3.next()) == null) {
                        }
                    }
                }
                return new b(null, i3, false);
            }
            j8 annotations = zp3Var.getAnnotations();
            du0Var = ia4.b;
            if (f == null) {
                du0Var = null;
            }
            e = ia4.e(s20.p(annotations, du0Var, bool2 != null ? ia4.g() : null));
            j b5 = y94.b(e);
            List L02 = zp3Var.L0();
            Iterator it4 = arrayList.iterator();
            Iterator it5 = L02.iterator();
            ArrayList arrayList2 = new ArrayList(Math.min(t20.v(arrayList, 10), t20.v(L02, 10)));
            while (it4.hasNext() && it5.hasNext()) {
                Object next2 = it4.next();
                ta4 ta4Var2 = (ta4) it5.next();
                ta4 ta4Var3 = (ta4) next2;
                if (ta4Var3 != null) {
                    ta4Var2 = ta4Var3;
                }
                arrayList2.add(ta4Var2);
            }
            zp3 j = KotlinTypeFactory.j(b5, ea4Var, arrayList2, bool2 != null ? bool2.booleanValue() : zp3Var.O0(), null, 16, null);
            if (aVar2.b()) {
                j = e(j);
            }
            return new b(j, i3, bool2 != null && aVar2.e());
        }
        return new b(null, 1, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x009b, code lost:
    
        if (r1 == null) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ft1.a d(defpackage.gd4 r21, defpackage.n81 r22, int r23, boolean r24) {
        /*
            r20 = this;
            r0 = r21
            boolean r1 = defpackage.gx1.a(r0)
            r2 = 0
            if (r1 == 0) goto L10
            ft1$a r0 = new ft1$a
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        L10:
            boolean r1 = r0 instanceof defpackage.l31
            if (r1 == 0) goto Lb2
            boolean r8 = r0 instanceof defpackage.ib3
            r1 = r0
            l31 r1 = (defpackage.l31) r1
            zp3 r4 = r1.V0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r3 = r20
            r5 = r22
            r6 = r23
            r9 = r24
            ft1$b r10 = r3.b(r4, r5, r6, r7, r8, r9)
            zp3 r4 = r1.W0()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r7 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            ft1$b r3 = r3.b(r4, r5, r6, r7, r8, r9)
            r10.b()
            r3.b()
            zp3 r4 = r10.c()
            if (r4 != 0) goto L48
            zp3 r4 = r3.c()
            if (r4 != 0) goto L48
            goto La8
        L48:
            boolean r2 = r10.a()
            if (r2 != 0) goto L8a
            boolean r2 = r3.a()
            if (r2 == 0) goto L55
            goto L8a
        L55:
            if (r8 == 0) goto L71
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r2 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            zp3 r0 = r10.c()
            if (r0 != 0) goto L63
            zp3 r0 = r1.V0()
        L63:
            zp3 r3 = r3.c()
            if (r3 != 0) goto L6d
            zp3 r3 = r1.W0()
        L6d:
            r2.<init>(r0, r3)
            goto La8
        L71:
            zp3 r0 = r10.c()
            if (r0 != 0) goto L7b
            zp3 r0 = r1.V0()
        L7b:
            zp3 r2 = r3.c()
            if (r2 != 0) goto L85
            zp3 r2 = r1.W0()
        L85:
            gd4 r2 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.d(r0, r2)
            goto La8
        L8a:
            zp3 r1 = r3.c()
            if (r1 == 0) goto L9d
            zp3 r2 = r10.c()
            if (r2 != 0) goto L97
            r2 = r1
        L97:
            gd4 r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.d(r2, r1)
            if (r1 != 0) goto La4
        L9d:
            zp3 r1 = r10.c()
            r1.getClass()
        La4:
            gd4 r2 = defpackage.hb4.d(r0, r1)
        La8:
            ft1$a r0 = new ft1$a
            int r1 = r10.b()
            r0.<init>(r2, r1)
            return r0
        Lb2:
            boolean r1 = r0 instanceof defpackage.zp3
            if (r1 == 0) goto Lea
            r12 = r0
            zp3 r12 = (defpackage.zp3) r12
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r15 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r18 = 8
            r19 = 0
            r16 = 0
            r11 = r20
            r13 = r22
            r14 = r23
            r17 = r24
            ft1$b r1 = c(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            ft1$a r2 = new ft1$a
            boolean r3 = r1.a()
            if (r3 == 0) goto Lde
            zp3 r3 = r1.c()
            gd4 r0 = defpackage.hb4.d(r0, r3)
            goto Le2
        Lde:
            zp3 r0 = r1.c()
        Le2:
            int r1 = r1.b()
            r2.<init>(r0, r1)
            return r2
        Lea:
            u.a()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ft1.d(gd4, n81, int, boolean):ft1$a");
    }

    public final zp3 e(zp3 zp3Var) {
        return this.a.a() ? ms3.h(zp3Var, true) : new zq2(zp3Var);
    }
}
