package defpackage;

import defpackage.y80;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;

/* loaded from: /tmp/classes2.dex */
public class tu1 implements y80.c {
    public final JvmBuiltInsCustomizer a;

    public tu1(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        this.a = jvmBuiltInsCustomizer;
    }

    @Override // y80.c
    public Iterable a(Object obj) {
        Iterable s;
        s = JvmBuiltInsCustomizer.s(this.a, (m00) obj);
        return s;
    }
}
