package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class l31 extends gd4 implements o31 {
    public final zp3 b;
    public final zp3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l31(zp3 zp3Var, zp3 zp3Var2) {
        super(null);
        zp3Var.getClass();
        zp3Var2.getClass();
        this.b = zp3Var;
        this.c = zp3Var2;
    }

    @Override // defpackage.fx1
    public List L0() {
        return U0().L0();
    }

    @Override // defpackage.fx1
    public j M0() {
        return U0().M0();
    }

    @Override // defpackage.fx1
    public ea4 N0() {
        return U0().N0();
    }

    @Override // defpackage.fx1
    public boolean O0() {
        return U0().O0();
    }

    public abstract zp3 U0();

    public final zp3 V0() {
        return this.b;
    }

    public final zp3 W0() {
        return this.c;
    }

    public abstract String X0(DescriptorRenderer descriptorRenderer, b bVar);

    @Override // defpackage.fx1
    public MemberScope s() {
        return U0().s();
    }

    public String toString() {
        return DescriptorRenderer.j.w(this);
    }
}
