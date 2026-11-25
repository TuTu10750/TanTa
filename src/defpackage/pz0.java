package defpackage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.a;

/* loaded from: /tmp/classes2.dex */
public final class pz0 {
    public static final pz0 a;
    public static final Map b;
    public static final Map c;

    static {
        pz0 pz0Var = new pz0();
        a = pz0Var;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        b = linkedHashMap;
        kt3 kt3Var = kt3.a;
        pz0Var.c(kt3Var.l(), pz0Var.a("java.util.ArrayList", "java.util.LinkedList"));
        pz0Var.c(kt3Var.n(), pz0Var.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        pz0Var.c(kt3Var.m(), pz0Var.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        q00 m = q00.m(new r51("java.util.function.Function"));
        m.getClass();
        pz0Var.c(m, pz0Var.a("java.util.function.UnaryOperator"));
        q00 m2 = q00.m(new r51("java.util.function.BiFunction"));
        m2.getClass();
        pz0Var.c(m2, pz0Var.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(g94.a(((q00) entry.getKey()).b(), ((q00) entry.getValue()).b()));
        }
        c = a.s(arrayList);
    }

    public final List a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(q00.m(new r51(str)));
        }
        return arrayList;
    }

    public final r51 b(r51 r51Var) {
        r51Var.getClass();
        return (r51) c.get(r51Var);
    }

    public final void c(q00 q00Var, List list) {
        Map map = b;
        for (Object obj : list) {
            map.put(obj, q00Var);
        }
    }
}
