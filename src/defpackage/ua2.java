package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: /tmp/classes2.dex */
public final class ua2 {
    public static final ua2 a;
    public static final ra2 b;

    static {
        ua2 ua2Var = new ua2();
        a = ua2Var;
        n14.f("kotlinx.coroutines.fast.service.loader", true);
        b = ua2Var.a();
    }

    public final ra2 a() {
        Object next;
        ra2 e;
        try {
            List S = SequencesKt___SequencesKt.S(kn3.g(ServiceLoader.load(ta2.class, ta2.class.getClassLoader()).iterator()));
            Iterator it = S.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c = ((ta2) next).c();
                    do {
                        Object next2 = it.next();
                        int c2 = ((ta2) next2).c();
                        if (c < c2) {
                            next = next2;
                            c = c2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            ta2 ta2Var = (ta2) next;
            if (ta2Var != null && (e = va2.e(ta2Var, S)) != null) {
                return e;
            }
            va2.b(null, null, 3, null);
            return null;
        } catch (Throwable th) {
            va2.b(th, null, 2, null);
            return null;
        }
    }
}
