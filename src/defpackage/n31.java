package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.c;
import kotlin.reflect.jvm.internal.impl.types.j;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class n31 extends l31 implements t80 {
    public static final a e = new a(null);
    public static boolean f;
    public boolean d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n31(zp3 zp3Var, zp3 zp3Var2) {
        super(zp3Var, zp3Var2);
        zp3Var.getClass();
        zp3Var2.getClass();
    }

    @Override // defpackage.t80
    public boolean A0() {
        return (V0().N0().v() instanceof oa4) && dq1.a(V0().N0(), W0().N0());
    }

    @Override // defpackage.gd4
    public gd4 R0(boolean z) {
        return KotlinTypeFactory.d(V0().R0(z), W0().R0(z));
    }

    @Override // defpackage.gd4
    public gd4 T0(j jVar) {
        jVar.getClass();
        return KotlinTypeFactory.d(V0().T0(jVar), W0().T0(jVar));
    }

    @Override // defpackage.l31
    public zp3 U0() {
        Z0();
        return V0();
    }

    @Override // defpackage.l31
    public String X0(DescriptorRenderer descriptorRenderer, b bVar) {
        descriptorRenderer.getClass();
        bVar.getClass();
        if (!bVar.n()) {
            return descriptorRenderer.t(descriptorRenderer.w(V0()), descriptorRenderer.w(W0()), TypeUtilsKt.i(this));
        }
        return "(" + descriptorRenderer.w(V0()) + ".." + descriptorRenderer.w(W0()) + ')';
    }

    @Override // defpackage.gd4
    /* renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public l31 X0(c cVar) {
        cVar.getClass();
        fx1 a2 = cVar.a(V0());
        a2.getClass();
        fx1 a3 = cVar.a(W0());
        a3.getClass();
        return new n31((zp3) a2, (zp3) a3);
    }

    public final void Z0() {
        if (!f || this.d) {
            return;
        }
        this.d = true;
        q31.b(V0());
        q31.b(W0());
        dq1.a(V0(), W0());
        kotlin.reflect.jvm.internal.impl.types.checker.b.a.c(V0(), W0());
    }

    @Override // defpackage.l31
    public String toString() {
        return "(" + V0() + ".." + W0() + ')';
    }

    @Override // defpackage.t80
    public fx1 z0(fx1 fx1Var) {
        gd4 d;
        fx1Var.getClass();
        gd4 Q0 = fx1Var.Q0();
        if (Q0 instanceof l31) {
            d = Q0;
        } else {
            if (!(Q0 instanceof zp3)) {
                u.a();
                return null;
            }
            zp3 zp3Var = (zp3) Q0;
            d = KotlinTypeFactory.d(zp3Var, zp3Var.R0(true));
        }
        return hb4.b(d, Q0);
    }
}
