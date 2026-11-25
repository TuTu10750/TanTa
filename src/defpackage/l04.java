package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.c;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public abstract class l04 {
    public static final jo2 a;

    static {
        mt0 mt0Var = new mt0(xu0.a.i(), e.n);
        ClassKind classKind = ClassKind.INTERFACE;
        zo2 g = e.q.g();
        xr3 xr3Var = xr3.a;
        lu3 lu3Var = LockBasedStorageManager.e;
        jo2 jo2Var = new jo2(mt0Var, classKind, false, false, g, xr3Var, lu3Var);
        jo2Var.M0(Modality.ABSTRACT);
        jo2Var.O0(ok0.e);
        jo2Var.N0(r20.e(pa4.R0(jo2Var, j8.a0.b(), false, Variance.IN_VARIANCE, zo2.i("T"), 0, lu3Var)));
        jo2Var.K0();
        a = jo2Var;
    }

    public static final zp3 a(fx1 fx1Var) {
        zp3 b;
        fx1Var.getClass();
        c.q(fx1Var);
        d i = TypeUtilsKt.i(fx1Var);
        j8 annotations = fx1Var.getAnnotations();
        fx1 j = c.j(fx1Var);
        List e = c.e(fx1Var);
        List l = c.l(fx1Var);
        ArrayList arrayList = new ArrayList(t20.v(l, 10));
        Iterator it = l.iterator();
        while (it.hasNext()) {
            arrayList.add(((ta4) it.next()).getType());
        }
        j h = j.b.h();
        ea4 k = a.k();
        k.getClass();
        List w0 = b30.w0(arrayList, KotlinTypeFactory.j(h, k, r20.e(TypeUtilsKt.a(c.k(fx1Var))), false, null, 16, null));
        zp3 I = TypeUtilsKt.i(fx1Var).I();
        I.getClass();
        b = c.b(i, annotations, j, e, w0, null, I, (r17 & 128) != 0 ? false : false);
        return b.R0(fx1Var.O0());
    }
}
