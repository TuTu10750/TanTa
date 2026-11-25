package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public abstract class ix1 {
    public static final im2 a = new im2("KotlinTypeRefiner");

    public static final im2 a() {
        return a;
    }

    public static final List b(c cVar, Iterable iterable) {
        cVar.getClass();
        iterable.getClass();
        ArrayList arrayList = new ArrayList(t20.v(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(cVar.a((fx1) it.next()));
        }
        return arrayList;
    }
}
