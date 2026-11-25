package defpackage;

import defpackage.nx3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public final class m91 extends g1 {
    public static final a m = new a(null);
    public static final q00 n = new q00(e.v, zo2.i("Function"));
    public static final q00 o = new q00(e.s, zo2.i("KFunction"));
    public final lu3 f;
    public final kv2 g;
    public final FunctionClassKind h;
    public final int i;
    public final b j;
    public final n91 k;
    public final List l;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public final class b extends h1 {

        /* loaded from: /tmp/classes2.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                try {
                    iArr[FunctionClassKind.f.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[FunctionClassKind.h.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[FunctionClassKind.g.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[FunctionClassKind.i.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                a = iArr;
            }
        }

        public b() {
            super(m91.this.f);
        }

        @Override // defpackage.ea4
        public boolean d() {
            return true;
        }

        @Override // defpackage.ea4
        public List getParameters() {
            return m91.this.l;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection k() {
            List<q00> e;
            int i = a.a[m91.this.U0().ordinal()];
            if (i == 1) {
                e = r20.e(m91.n);
            } else if (i == 2) {
                e = s20.n(m91.o, new q00(e.v, FunctionClassKind.f.d(m91.this.Q0())));
            } else if (i == 3) {
                e = r20.e(m91.n);
            } else {
                if (i != 4) {
                    u.a();
                    return null;
                }
                e = s20.n(m91.o, new q00(e.n, FunctionClassKind.g.d(m91.this.Q0())));
            }
            mm2 b = m91.this.g.b();
            ArrayList arrayList = new ArrayList(t20.v(e, 10));
            for (q00 q00Var : e) {
                m00 a2 = FindClassInModuleKt.a(b, q00Var);
                if (a2 == null) {
                    throw new IllegalStateException(("Built-in class " + q00Var + " not found").toString());
                }
                List E0 = b30.E0(getParameters(), a2.k().getParameters().size());
                ArrayList arrayList2 = new ArrayList(t20.v(E0, 10));
                Iterator it = E0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new va4(((oa4) it.next()).u()));
                }
                arrayList.add(KotlinTypeFactory.g(j.b.h(), a2, arrayList2));
            }
            return b30.I0(arrayList);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public nx3 o() {
            return nx3.a.a;
        }

        public String toString() {
            return v().toString();
        }

        @Override // defpackage.h1
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public m91 v() {
            return m91.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m91(lu3 lu3Var, kv2 kv2Var, FunctionClassKind functionClassKind, int i) {
        super(lu3Var, functionClassKind.d(i));
        lu3Var.getClass();
        kv2Var.getClass();
        functionClassKind.getClass();
        this.f = lu3Var;
        this.g = kv2Var;
        this.h = functionClassKind;
        this.i = i;
        this.j = new b();
        this.k = new n91(lu3Var, this);
        ArrayList arrayList = new ArrayList();
        pp1 pp1Var = new pp1(1, i);
        ArrayList arrayList2 = new ArrayList(t20.v(pp1Var, 10));
        Iterator it = pp1Var.iterator();
        while (it.hasNext()) {
            int nextInt = ((lp1) it).nextInt();
            K0(arrayList, this, Variance.IN_VARIANCE, "P" + nextInt);
            arrayList2.add(qc4.a);
        }
        K0(arrayList, this, Variance.OUT_VARIANCE, "R");
        this.l = b30.I0(arrayList);
    }

    public static final void K0(ArrayList arrayList, m91 m91Var, Variance variance, String str) {
        arrayList.add(pa4.R0(m91Var, j8.a0.b(), false, variance, zo2.i(str), arrayList.size(), m91Var.f));
    }

    @Override // defpackage.m00
    public boolean C() {
        return false;
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return false;
    }

    @Override // defpackage.m00
    public boolean I0() {
        return false;
    }

    @Override // defpackage.ck2
    public boolean K() {
        return false;
    }

    @Override // defpackage.m00
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b P() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.b) Y0();
    }

    public final int Q0() {
        return this.i;
    }

    public Void R0() {
        return null;
    }

    @Override // defpackage.m00
    public /* bridge */ /* synthetic */ m00 S() {
        return (m00) R0();
    }

    @Override // defpackage.m00
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public List m() {
        return s20.k();
    }

    @Override // defpackage.m00, defpackage.ta0
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public kv2 b() {
        return this.g;
    }

    public final FunctionClassKind U0() {
        return this.h;
    }

    @Override // defpackage.m00
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public List J() {
        return s20.k();
    }

    @Override // defpackage.m00
    /* renamed from: W0, reason: merged with bridge method [inline-methods] */
    public MemberScope.a Q() {
        return MemberScope.a.b;
    }

    @Override // defpackage.fm2
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public n91 z0(c cVar) {
        cVar.getClass();
        return this.k;
    }

    public Void Y0() {
        return null;
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        return j8.a0.b();
    }

    @Override // defpackage.m00, defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = ok0.e;
        pk0Var.getClass();
        return pk0Var;
    }

    @Override // defpackage.m00
    public ClassKind i() {
        return ClassKind.INTERFACE;
    }

    @Override // defpackage.ck2
    public boolean isExternal() {
        return false;
    }

    @Override // defpackage.m00
    public boolean isInline() {
        return false;
    }

    @Override // defpackage.xa0
    public xr3 j() {
        xr3 xr3Var = xr3.a;
        xr3Var.getClass();
        return xr3Var;
    }

    @Override // defpackage.z00
    public ea4 k() {
        return this.j;
    }

    @Override // defpackage.m00, defpackage.ck2
    public Modality l() {
        return Modality.ABSTRACT;
    }

    @Override // defpackage.m00
    public boolean n() {
        return false;
    }

    @Override // defpackage.a10
    public boolean o() {
        return false;
    }

    public String toString() {
        String b2 = getName().b();
        b2.getClass();
        return b2;
    }

    @Override // defpackage.m00, defpackage.a10
    public List w() {
        return this.l;
    }

    @Override // defpackage.m00
    public boolean y() {
        return false;
    }

    @Override // defpackage.m00
    public nf4 y0() {
        return null;
    }
}
