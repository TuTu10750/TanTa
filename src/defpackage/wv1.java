package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class wv1 {

    /* loaded from: /tmp/classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final zp3 a(j jVar, ea4 ea4Var, List list, boolean z) {
        u94 starProjectionImpl;
        List parameters = ea4Var.getParameters();
        parameters.getClass();
        ArrayList arrayList = new ArrayList(t20.v(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                s20.u();
            }
            pw1 pw1Var = (pw1) obj;
            KTypeImpl kTypeImpl = (KTypeImpl) pw1Var.c();
            fx1 p = kTypeImpl != null ? kTypeImpl.p() : null;
            KVariance d = pw1Var.d();
            int i3 = d == null ? -1 : a.a[d.ordinal()];
            if (i3 == -1) {
                Object obj2 = parameters.get(i);
                obj2.getClass();
                starProjectionImpl = new StarProjectionImpl((oa4) obj2);
            } else if (i3 == 1) {
                Variance variance = Variance.INVARIANT;
                p.getClass();
                starProjectionImpl = new va4(variance, p);
            } else if (i3 == 2) {
                Variance variance2 = Variance.IN_VARIANCE;
                p.getClass();
                starProjectionImpl = new va4(variance2, p);
            } else {
                if (i3 != 3) {
                    u.a();
                    return null;
                }
                Variance variance3 = Variance.OUT_VARIANCE;
                p.getClass();
                starProjectionImpl = new va4(variance3, p);
            }
            arrayList.add(starProjectionImpl);
            i = i2;
        }
        return KotlinTypeFactory.j(jVar, ea4Var, arrayList, z, null, 16, null);
    }

    public static final lw1 b(uv1 uv1Var, List list, boolean z, List list2) {
        z00 l;
        uv1Var.getClass();
        list.getClass();
        list2.getClass();
        vv1 vv1Var = uv1Var instanceof vv1 ? (vv1) uv1Var : null;
        if (vv1Var == null || (l = vv1Var.l()) == null) {
            StringBuilder sb = new StringBuilder("Cannot create type for an unsupported classifier: ");
            sb.append(uv1Var);
            Class<?> cls = uv1Var.getClass();
            sb.append(" (");
            sb.append(cls);
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
        ea4 k = l.k();
        k.getClass();
        List parameters = k.getParameters();
        parameters.getClass();
        if (parameters.size() == list.size()) {
            return new KTypeImpl(a(list2.isEmpty() ? j.b.h() : j.b.h(), k, list, z), null, 2, null);
        }
        throw new IllegalArgumentException("Class declares " + parameters.size() + " type parameters, but " + list.size() + " were provided.");
    }
}
