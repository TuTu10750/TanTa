package defpackage;

import kotlin.reflect.jvm.internal.impl.load.kotlin.c;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;

/* loaded from: /tmp/classes2.dex */
public final class dx1 implements bl0 {
    public final c b;
    public final un1 c;
    public final boolean d;
    public final DeserializedContainerAbiStability e;

    public dx1(c cVar, un1 un1Var, boolean z, DeserializedContainerAbiStability deserializedContainerAbiStability) {
        cVar.getClass();
        deserializedContainerAbiStability.getClass();
        this.b = cVar;
        this.c = un1Var;
        this.d = z;
        this.e = deserializedContainerAbiStability;
    }

    @Override // defpackage.xr3
    public yr3 a() {
        yr3 yr3Var = yr3.a;
        yr3Var.getClass();
        return yr3Var;
    }

    @Override // defpackage.bl0
    public String c() {
        return "Class '" + this.b.l().b().b() + '\'';
    }

    public final c d() {
        return this.b;
    }

    public String toString() {
        return dx1.class.getSimpleName() + ": " + this.b;
    }
}
