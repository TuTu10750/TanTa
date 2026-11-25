package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.builtins.e;

/* loaded from: /tmp/classes2.dex */
public final class al {
    public static final al a = new al();
    public static final Map b;
    public static final Map c;
    public static final Set d;
    public static final Set e;

    static {
        r51 d2;
        r51 d3;
        r51 c2;
        r51 c3;
        r51 d4;
        r51 c4;
        r51 c5;
        r51 c6;
        s51 s51Var = e.a.s;
        d2 = bl.d(s51Var, "name");
        Pair a2 = g94.a(d2, zo2.i("name"));
        d3 = bl.d(s51Var, "ordinal");
        Pair a3 = g94.a(d3, zo2.i("ordinal"));
        c2 = bl.c(e.a.V, "size");
        Pair a4 = g94.a(c2, zo2.i("size"));
        r51 r51Var = e.a.Z;
        c3 = bl.c(r51Var, "size");
        Pair a5 = g94.a(c3, zo2.i("size"));
        d4 = bl.d(e.a.g, "length");
        Pair a6 = g94.a(d4, zo2.i("length"));
        c4 = bl.c(r51Var, "keys");
        Pair a7 = g94.a(c4, zo2.i("keySet"));
        c5 = bl.c(r51Var, "values");
        Pair a8 = g94.a(c5, zo2.i("values"));
        c6 = bl.c(r51Var, "entries");
        Map l = a.l(a2, a3, a4, a5, a6, a7, a8, g94.a(c6, zo2.i("entrySet")));
        b = l;
        Set<Map.Entry> entrySet = l.entrySet();
        ArrayList<Pair> arrayList = new ArrayList(t20.v(entrySet, 10));
        for (Map.Entry entry : entrySet) {
            arrayList.add(new Pair(((r51) entry.getKey()).g(), entry.getValue()));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair pair : arrayList) {
            zo2 zo2Var = (zo2) pair.d();
            Object obj = linkedHashMap.get(zo2Var);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(zo2Var, obj);
            }
            ((List) obj).add((zo2) pair.c());
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(sc2.e(linkedHashMap.size()));
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry2.getKey(), b30.U((Iterable) entry2.getValue()));
        }
        c = linkedHashMap2;
        Set keySet = b.keySet();
        d = keySet;
        ArrayList arrayList2 = new ArrayList(t20.v(keySet, 10));
        Iterator it = keySet.iterator();
        while (it.hasNext()) {
            arrayList2.add(((r51) it.next()).g());
        }
        e = b30.M0(arrayList2);
    }

    public final Map a() {
        return b;
    }

    public final List b(zo2 zo2Var) {
        zo2Var.getClass();
        List list = (List) c.get(zo2Var);
        return list == null ? s20.k() : list;
    }

    public final Set c() {
        return d;
    }

    public final Set d() {
        return e;
    }
}
