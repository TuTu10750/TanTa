package defpackage;

import defpackage.w94;
import kotlin.reflect.jvm.internal.impl.types.b;
import kotlin.reflect.jvm.internal.impl.types.c;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class y94 {
    public static final j a(j jVar, j8 j8Var) {
        j o;
        jVar.getClass();
        j8Var.getClass();
        if (b.a(jVar) == j8Var) {
            return jVar;
        }
        m8 b = b.b(jVar);
        if (b != null && (o = jVar.o(b)) != null) {
            jVar = o;
        }
        return (j8Var.iterator().hasNext() || !j8Var.isEmpty()) ? jVar.n(new m8(j8Var)) : jVar;
    }

    public static final j b(j8 j8Var) {
        j8Var.getClass();
        return w94.a.a(c.a, j8Var, null, null, 6, null);
    }
}
