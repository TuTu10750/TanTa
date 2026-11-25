package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: /tmp/classes2.dex */
public abstract class tv1 {
    public static final Collection a(rv1 rv1Var) {
        rv1Var.getClass();
        Collection g = ((KClassImpl.Data) ((KClassImpl) rv1Var).T().invoke()).g();
        ArrayList arrayList = new ArrayList();
        for (Object obj : g) {
            KCallableImpl kCallableImpl = (KCallableImpl) obj;
            if (d(kCallableImpl) && (kCallableImpl instanceof kw1)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final aw1 b(rv1 rv1Var) {
        Object obj;
        rv1Var.getClass();
        Iterator it = ((KClassImpl) rv1Var).S().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            aw1 aw1Var = (aw1) obj;
            aw1Var.getClass();
            e H = ((KFunctionImpl) aw1Var).H();
            H.getClass();
            if (((c) H).A()) {
                break;
            }
        }
        return (aw1) obj;
    }

    public static final boolean c(KCallableImpl kCallableImpl) {
        return kCallableImpl.H().k0() != null;
    }

    public static final boolean d(KCallableImpl kCallableImpl) {
        return !c(kCallableImpl);
    }
}
