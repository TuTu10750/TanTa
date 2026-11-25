package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.a;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public final class o91 extends up3 {
    public static final a E = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o91 a(m91 m91Var, boolean z) {
            m91Var.getClass();
            List w = m91Var.w();
            o91 o91Var = new o91(m91Var, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            zb3 J0 = m91Var.J0();
            List k = s20.k();
            List k2 = s20.k();
            ArrayList arrayList = new ArrayList();
            for (Object obj : w) {
                if (((oa4) obj).p() != Variance.IN_VARIANCE) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<co1> O0 = b30.O0(arrayList);
            ArrayList arrayList2 = new ArrayList(t20.v(O0, 10));
            for (co1 co1Var : O0) {
                arrayList2.add(o91.E.b(o91Var, co1Var.c(), (oa4) co1Var.d()));
            }
            o91Var.R0(null, J0, k, k2, arrayList2, ((oa4) b30.m0(w)).u(), Modality.ABSTRACT, ok0.e);
            o91Var.Z0(true);
            return o91Var;
        }

        public final h b(o91 o91Var, int i, oa4 oa4Var) {
            String lowerCase;
            String b = oa4Var.getName().b();
            b.getClass();
            if (dq1.a(b, "T")) {
                lowerCase = "instance";
            } else if (dq1.a(b, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = b.toLowerCase(Locale.ROOT);
                lowerCase.getClass();
            }
            j8 b2 = j8.a0.b();
            zo2 i2 = zo2.i(lowerCase);
            i2.getClass();
            zp3 u = oa4Var.u();
            u.getClass();
            xr3 xr3Var = xr3.a;
            xr3Var.getClass();
            return new ValueParameterDescriptorImpl(o91Var, null, i, b2, i2, u, false, false, false, null, xr3Var);
        }
    }

    public o91(ra0 ra0Var, o91 o91Var, CallableMemberDescriptor.Kind kind, boolean z) {
        super(ra0Var, o91Var, j8.a0.b(), fu2.i, kind, xr3.a);
        f1(true);
        h1(z);
        Y0(false);
    }

    public /* synthetic */ o91(ra0 ra0Var, o91 o91Var, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(ra0Var, o91Var, kind, z);
    }

    @Override // defpackage.up3, kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public kotlin.reflect.jvm.internal.impl.descriptors.impl.a L0(ra0 ra0Var, e eVar, CallableMemberDescriptor.Kind kind, zo2 zo2Var, j8 j8Var, xr3 xr3Var) {
        ra0Var.getClass();
        kind.getClass();
        j8Var.getClass();
        xr3Var.getClass();
        return new o91(ra0Var, (o91) eVar, kind, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a
    public e M0(a.c cVar) {
        cVar.getClass();
        o91 o91Var = (o91) super.M0(cVar);
        if (o91Var == null) {
            return null;
        }
        List h = o91Var.h();
        h.getClass();
        if (h != null && h.isEmpty()) {
            return o91Var;
        }
        Iterator it = h.iterator();
        while (it.hasNext()) {
            fx1 type = ((h) it.next()).getType();
            type.getClass();
            if (c.d(type) != null) {
                List h2 = o91Var.h();
                h2.getClass();
                ArrayList arrayList = new ArrayList(t20.v(h2, 10));
                Iterator it2 = h2.iterator();
                while (it2.hasNext()) {
                    fx1 type2 = ((h) it2.next()).getType();
                    type2.getClass();
                    arrayList.add(c.d(type2));
                }
                return o91Var.p1(arrayList);
            }
        }
        return o91Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean O() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, defpackage.ck2
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.a, kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    public final e p1(List list) {
        zo2 zo2Var;
        int size = h().size() - list.size();
        boolean z = true;
        if (size == 0) {
            List h = h();
            h.getClass();
            List<Pair> Q0 = b30.Q0(list, h);
            if (Q0 != null && Q0.isEmpty()) {
                return this;
            }
            for (Pair pair : Q0) {
                if (!dq1.a((zo2) pair.getFirst(), ((h) pair.getSecond()).getName())) {
                }
            }
            return this;
        }
        List<h> h2 = h();
        h2.getClass();
        ArrayList arrayList = new ArrayList(t20.v(h2, 10));
        for (h hVar : h2) {
            zo2 name = hVar.getName();
            name.getClass();
            int index = hVar.getIndex();
            int i = index - size;
            if (i >= 0 && (zo2Var = (zo2) list.get(i)) != null) {
                name = zo2Var;
            }
            arrayList.add(hVar.H0(this, name, index));
        }
        a.c S0 = S0(TypeSubstitutor.b);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((zo2) it.next()) == null) {
                    break;
                }
            }
        }
        z = false;
        a.c h3 = S0.G(z).b(arrayList).h(a());
        h3.getClass();
        e M0 = super.M0(h3);
        M0.getClass();
        return M0;
    }
}
