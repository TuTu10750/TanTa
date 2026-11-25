package defpackage;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: /tmp/classes2.dex */
public abstract class dl0 extends lv2 {
    public final lu3 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dl0(r51 r51Var, lu3 lu3Var, mm2 mm2Var) {
        super(mm2Var, r51Var);
        r51Var.getClass();
        lu3Var.getClass();
        mm2Var.getClass();
        this.g = lu3Var;
    }

    public abstract l00 F0();

    public boolean K0(zo2 zo2Var) {
        zo2Var.getClass();
        MemberScope s = s();
        return (s instanceof DeserializedMemberScope) && ((DeserializedMemberScope) s).q().contains(zo2Var);
    }

    public abstract void L0(rk0 rk0Var);
}
