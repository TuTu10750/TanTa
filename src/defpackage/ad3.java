package defpackage;

import defpackage.qr1;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: /tmp/classes2.dex */
public final class ad3 implements qr1 {
    public final ClassLoader a;

    public ad3(ClassLoader classLoader) {
        classLoader.getClass();
        this.a = classLoader;
    }

    @Override // defpackage.qr1
    public Set a(r51 r51Var) {
        r51Var.getClass();
        return null;
    }

    @Override // defpackage.qr1
    public qs1 b(r51 r51Var, boolean z) {
        r51Var.getClass();
        return new md3(r51Var);
    }

    @Override // defpackage.qr1
    public lr1 c(qr1.a aVar) {
        aVar.getClass();
        q00 a = aVar.a();
        r51 h = a.h();
        h.getClass();
        String b = a.i().b();
        b.getClass();
        String E = fw3.E(b, '.', '$', false, 4, null);
        if (!h.d()) {
            E = h.b() + '.' + E;
        }
        Class a2 = bd3.a(this.a, E);
        if (a2 != null) {
            return new ReflectJavaClass(a2);
        }
        return null;
    }
}
