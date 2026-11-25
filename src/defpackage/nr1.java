package defpackage;

import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.c;

/* loaded from: /tmp/classes2.dex */
public final class nr1 implements l00 {
    public final ax1 a;
    public final DeserializedDescriptorResolver b;

    public nr1(ax1 ax1Var, DeserializedDescriptorResolver deserializedDescriptorResolver) {
        ax1Var.getClass();
        deserializedDescriptorResolver.getClass();
        this.a = ax1Var;
        this.b = deserializedDescriptorResolver;
    }

    @Override // defpackage.l00
    public k00 a(q00 q00Var) {
        q00Var.getClass();
        c a = bx1.a(this.a, q00Var, wk0.a(this.b.d().g()));
        if (a == null) {
            return null;
        }
        dq1.a(a.l(), q00Var);
        return this.b.j(a);
    }
}
