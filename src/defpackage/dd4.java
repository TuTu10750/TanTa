package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedArrayType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.builtins.e;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public final class dd4 {
    public static final dd4 a = new dd4();
    public static final Set b;
    public static final Set c;
    public static final HashMap d;
    public static final HashMap e;
    public static final HashMap f;
    public static final Set g;

    static {
        UnsignedType[] values = UnsignedType.values();
        ArrayList arrayList = new ArrayList(values.length);
        for (UnsignedType unsignedType : values) {
            arrayList.add(unsignedType.d());
        }
        b = b30.M0(arrayList);
        UnsignedArrayType[] values2 = UnsignedArrayType.values();
        ArrayList arrayList2 = new ArrayList(values2.length);
        for (UnsignedArrayType unsignedArrayType : values2) {
            arrayList2.add(unsignedArrayType.b());
        }
        c = b30.M0(arrayList2);
        d = new HashMap();
        e = new HashMap();
        f = a.k(g94.a(UnsignedArrayType.c, zo2.i("ubyteArrayOf")), g94.a(UnsignedArrayType.d, zo2.i("ushortArrayOf")), g94.a(UnsignedArrayType.e, zo2.i("uintArrayOf")), g94.a(UnsignedArrayType.f, zo2.i("ulongArrayOf")));
        UnsignedType[] values3 = UnsignedType.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (UnsignedType unsignedType2 : values3) {
            linkedHashSet.add(unsignedType2.b().j());
        }
        g = linkedHashSet;
        for (UnsignedType unsignedType3 : UnsignedType.values()) {
            d.put(unsignedType3.b(), unsignedType3.c());
            e.put(unsignedType3.c(), unsignedType3.b());
        }
    }

    public static final boolean d(fx1 fx1Var) {
        z00 v;
        fx1Var.getClass();
        if (n.w(fx1Var) || (v = fx1Var.N0().v()) == null) {
            return false;
        }
        return a.c(v);
    }

    public final q00 a(q00 q00Var) {
        q00Var.getClass();
        return (q00) d.get(q00Var);
    }

    public final boolean b(zo2 zo2Var) {
        zo2Var.getClass();
        return g.contains(zo2Var);
    }

    public final boolean c(ra0 ra0Var) {
        ra0Var.getClass();
        ra0 b2 = ra0Var.b();
        return (b2 instanceof kv2) && dq1.a(((kv2) b2).d(), e.v) && b.contains(ra0Var.getName());
    }
}
