package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;

/* loaded from: /tmp/classes2.dex */
public abstract class lt3 {
    public static final r51 a;
    public static final r51 b;

    static {
        r51 r51Var = new r51("java.lang");
        a = r51Var;
        r51 c = r51Var.c(zo2.i("annotation"));
        c.getClass();
        b = c;
    }

    public static final q00 k(String str) {
        return new q00(kt3.a.b(), zo2.i(str));
    }

    public static final q00 l(String str) {
        return new q00(kt3.a.f(), zo2.i(str));
    }

    public static final q00 m(String str) {
        return new q00(kt3.a.c(), zo2.i(str));
    }

    public static final q00 n(String str) {
        return new q00(kt3.a.d(), zo2.i(str));
    }

    public static final q00 o(String str) {
        return new q00(kt3.a.e(), zo2.i(str));
    }

    public static final Map p(Map map) {
        Set<Map.Entry> entrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(fb3.c(sc2.e(t20.v(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair a2 = g94.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(a2.c(), a2.d());
        }
        return linkedHashMap;
    }

    public static final q00 q(zo2 zo2Var) {
        kt3 kt3Var = kt3.a;
        return new q00(kt3Var.a().h(), zo2.i(zo2Var.d() + kt3Var.a().j().d()));
    }

    public static final q00 r(String str) {
        return new q00(kt3.a.g(), zo2.i(str));
    }

    public static final q00 s(String str) {
        return new q00(kt3.a.h(), zo2.i(str));
    }

    public static final q00 t(q00 q00Var) {
        return new q00(kt3.a.f(), zo2.i("U" + q00Var.j().d()));
    }
}
