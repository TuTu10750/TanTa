package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.l;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public class ly1 extends fm2 {
    public final fm2 b;
    public final TypeSubstitutor c;
    public TypeSubstitutor d;
    public List e;
    public List f;
    public ea4 g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements n81 {
        public a() {
        }

        @Override // defpackage.n81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(oa4 oa4Var) {
            return Boolean.valueOf(!oa4Var.m0());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements n81 {
        public b() {
        }

        @Override // defpackage.n81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zp3 invoke(zp3 zp3Var) {
            return ly1.this.M0(zp3Var);
        }
    }

    public ly1(fm2 fm2Var, TypeSubstitutor typeSubstitutor) {
        this.b = fm2Var;
        this.c = typeSubstitutor;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void A0(int r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ly1.A0(int):void");
    }

    @Override // defpackage.m00
    public boolean C() {
        return this.b.C();
    }

    @Override // defpackage.m00
    public MemberScope D0() {
        MemberScope z0 = z0(DescriptorUtilsKt.o(lk0.g(this.b)));
        if (z0 == null) {
            A0(12);
        }
        return z0;
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return this.b.E0();
    }

    @Override // defpackage.m00
    public List G0() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(17);
        }
        return list;
    }

    @Override // defpackage.fm2
    public MemberScope H(l lVar, c cVar) {
        if (lVar == null) {
            A0(5);
        }
        if (cVar == null) {
            A0(6);
        }
        MemberScope H = this.b.H(lVar, cVar);
        if (!this.c.k()) {
            return new SubstitutingScope(H, K0());
        }
        if (H == null) {
            A0(7);
        }
        return H;
    }

    @Override // defpackage.m00
    public boolean I0() {
        return this.b.I0();
    }

    @Override // defpackage.m00
    public Collection J() {
        Collection J = this.b.J();
        if (J == null) {
            A0(31);
        }
        return J;
    }

    @Override // defpackage.m00
    public zb3 J0() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.ck2
    public boolean K() {
        return this.b.K();
    }

    public final TypeSubstitutor K0() {
        if (this.d == null) {
            if (this.c.k()) {
                this.d = this.c;
            } else {
                List parameters = this.b.k().getParameters();
                this.e = new ArrayList(parameters.size());
                this.d = jk0.b(parameters, this.c.j(), this, this.e);
                this.f = b30.X(this.e, new a());
            }
        }
        return this.d;
    }

    @Override // defpackage.vw3
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public m00 c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A0(23);
        }
        return typeSubstitutor.k() ? this : new ly1(this, TypeSubstitutor.h(typeSubstitutor.j(), K0().j()));
    }

    public final zp3 M0(zp3 zp3Var) {
        return (zp3Var == null || this.c.k()) ? zp3Var : (zp3) K0().p(zp3Var, Variance.INVARIANT);
    }

    @Override // defpackage.m00
    public kotlin.reflect.jvm.internal.impl.descriptors.b P() {
        return this.b.P();
    }

    @Override // defpackage.m00
    public MemberScope Q() {
        MemberScope Q = this.b.Q();
        if (Q == null) {
            A0(15);
        }
        return Q;
    }

    @Override // defpackage.m00
    public m00 S() {
        return this.b.S();
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.h(this, obj);
    }

    @Override // defpackage.ra0, defpackage.z00
    public m00 a() {
        m00 a2 = this.b.a();
        if (a2 == null) {
            A0(21);
        }
        return a2;
    }

    @Override // defpackage.m00
    public MemberScope a0(l lVar) {
        if (lVar == null) {
            A0(10);
        }
        MemberScope H = H(lVar, DescriptorUtilsKt.o(lk0.g(this)));
        if (H == null) {
            A0(11);
        }
        return H;
    }

    @Override // defpackage.m00, defpackage.ta0
    public ra0 b() {
        ra0 b2 = this.b.b();
        if (b2 == null) {
            A0(22);
        }
        return b2;
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        j8 annotations = this.b.getAnnotations();
        if (annotations == null) {
            A0(19);
        }
        return annotations;
    }

    @Override // defpackage.ep2
    public zo2 getName() {
        zo2 name = this.b.getName();
        if (name == null) {
            A0(20);
        }
        return name;
    }

    @Override // defpackage.m00, defpackage.ya0
    public pk0 getVisibility() {
        pk0 visibility = this.b.getVisibility();
        if (visibility == null) {
            A0(27);
        }
        return visibility;
    }

    @Override // defpackage.m00
    public ClassKind i() {
        ClassKind i = this.b.i();
        if (i == null) {
            A0(25);
        }
        return i;
    }

    @Override // defpackage.ck2
    public boolean isExternal() {
        return this.b.isExternal();
    }

    @Override // defpackage.m00
    public boolean isInline() {
        return this.b.isInline();
    }

    @Override // defpackage.xa0
    public xr3 j() {
        xr3 xr3Var = xr3.a;
        if (xr3Var == null) {
            A0(29);
        }
        return xr3Var;
    }

    @Override // defpackage.z00
    public ea4 k() {
        ea4 k = this.b.k();
        if (this.c.k()) {
            if (k == null) {
                A0(0);
            }
            return k;
        }
        if (this.g == null) {
            TypeSubstitutor K0 = K0();
            Collection c = k.c();
            ArrayList arrayList = new ArrayList(c.size());
            Iterator it = c.iterator();
            while (it.hasNext()) {
                arrayList.add(K0.p((fx1) it.next(), Variance.INVARIANT));
            }
            this.g = new v00(this, this.e, arrayList, LockBasedStorageManager.e);
        }
        ea4 ea4Var = this.g;
        if (ea4Var == null) {
            A0(1);
        }
        return ea4Var;
    }

    @Override // defpackage.m00, defpackage.ck2
    public Modality l() {
        Modality l = this.b.l();
        if (l == null) {
            A0(26);
        }
        return l;
    }

    @Override // defpackage.m00
    public Collection m() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> m = this.b.m();
        ArrayList arrayList = new ArrayList(m.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : m) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.b) bVar.v().h(bVar.a()).e(bVar.l()).d(bVar.getVisibility()).r(bVar.i()).j(false).build()).c(K0()));
        }
        return arrayList;
    }

    @Override // defpackage.m00
    public boolean n() {
        return this.b.n();
    }

    @Override // defpackage.a10
    public boolean o() {
        return this.b.o();
    }

    @Override // defpackage.m00, defpackage.z00
    public zp3 u() {
        zp3 k = KotlinTypeFactory.k(kotlin.reflect.jvm.internal.impl.types.c.a.a(getAnnotations(), null, null), k(), n.g(k().getParameters()), false, D0());
        if (k == null) {
            A0(16);
        }
        return k;
    }

    @Override // defpackage.m00, defpackage.a10
    public List w() {
        K0();
        List list = this.f;
        if (list == null) {
            A0(30);
        }
        return list;
    }

    @Override // defpackage.m00
    public MemberScope x0() {
        MemberScope x0 = this.b.x0();
        if (x0 == null) {
            A0(28);
        }
        return x0;
    }

    @Override // defpackage.m00
    public boolean y() {
        return this.b.y();
    }

    @Override // defpackage.m00
    public nf4 y0() {
        nf4 y0 = this.b.y0();
        if (y0 == null) {
            return null;
        }
        return y0.b(new b());
    }

    @Override // defpackage.fm2
    public MemberScope z0(c cVar) {
        if (cVar == null) {
            A0(13);
        }
        MemberScope z0 = this.b.z0(cVar);
        if (!this.c.k()) {
            return new SubstitutingScope(z0, K0());
        }
        if (z0 == null) {
            A0(14);
        }
        return z0;
    }
}
