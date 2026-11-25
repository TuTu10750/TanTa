package defpackage;

import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* loaded from: /tmp/classes2.dex */
public abstract class d1 implements Iterable, bw1 {

    /* loaded from: /tmp/classes2.dex */
    public static abstract class a {
        public final rv1 a;
        public final int b;

        public a(rv1 rv1Var, int i) {
            rv1Var.getClass();
            this.a = rv1Var;
            this.b = i;
        }

        public final Object a(d1 d1Var) {
            d1Var.getClass();
            return d1Var.g().get(this.b);
        }
    }

    public abstract fb g();

    public abstract TypeRegistry h();

    public final boolean isEmpty() {
        return g().g() == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return g().iterator();
    }
}
