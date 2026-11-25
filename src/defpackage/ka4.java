package defpackage;

import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public abstract class ka4 {
    public static Iterable a(Object obj) {
        if ((obj instanceof bw1) && !(obj instanceof cw1)) {
            n(obj, "kotlin.collections.MutableIterable");
        }
        return f(obj);
    }

    public static List b(Object obj) {
        if ((obj instanceof bw1) && !(obj instanceof dw1)) {
            n(obj, "kotlin.collections.MutableList");
        }
        return g(obj);
    }

    public static Map c(Object obj) {
        if ((obj instanceof bw1) && !(obj instanceof ew1)) {
            n(obj, "kotlin.collections.MutableMap");
        }
        return h(obj);
    }

    public static Set d(Object obj) {
        if ((obj instanceof bw1) && !(obj instanceof hw1)) {
            n(obj, "kotlin.collections.MutableSet");
        }
        return i(obj);
    }

    public static Object e(Object obj, int i) {
        if (obj != null && !k(obj, i)) {
            n(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static Iterable f(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static List g(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static Map h(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static Set i(Object obj) {
        try {
            return (Set) obj;
        } catch (ClassCastException e) {
            throw m(e);
        }
    }

    public static int j(Object obj) {
        if (obj instanceof l91) {
            return ((l91) obj).getArity();
        }
        if (obj instanceof l81) {
            return 0;
        }
        if (obj instanceof n81) {
            return 1;
        }
        if (obj instanceof b91) {
            return 2;
        }
        if (obj instanceof d91) {
            return 3;
        }
        if (obj instanceof e91) {
            return 4;
        }
        if (obj instanceof f91) {
            return 5;
        }
        if (obj instanceof g91) {
            return 6;
        }
        if (obj instanceof h91) {
            return 7;
        }
        if (obj instanceof i91) {
            return 8;
        }
        if (obj instanceof j91) {
            return 9;
        }
        if (obj instanceof m81) {
            return 10;
        }
        if (obj instanceof o81) {
            return 11;
        }
        if (obj instanceof p81) {
            return 12;
        }
        if (obj instanceof q81) {
            return 13;
        }
        if (obj instanceof r81) {
            return 14;
        }
        if (obj instanceof s81) {
            return 15;
        }
        if (obj instanceof t81) {
            return 16;
        }
        if (obj instanceof u81) {
            return 17;
        }
        if (obj instanceof v81) {
            return 18;
        }
        if (obj instanceof w81) {
            return 19;
        }
        if (obj instanceof y81) {
            return 20;
        }
        if (obj instanceof z81) {
            return 21;
        }
        return obj instanceof a91 ? 22 : -1;
    }

    public static boolean k(Object obj, int i) {
        return (obj instanceof c91) && j(obj) == i;
    }

    public static Throwable l(Throwable th) {
        return dq1.e(th, ka4.class.getName());
    }

    public static ClassCastException m(ClassCastException classCastException) {
        throw ((ClassCastException) l(classCastException));
    }

    public static void n(Object obj, String str) {
        o((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void o(String str) {
        throw m(new ClassCastException(str));
    }
}
