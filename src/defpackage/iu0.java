package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: /tmp/classes2.dex */
public final class iu0 extends k50 {
    public final q00 b;
    public final zo2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public iu0(q00 q00Var, zo2 zo2Var) {
        super(g94.a(q00Var, zo2Var));
        q00Var.getClass();
        zo2Var.getClass();
        this.b = q00Var;
        this.c = zo2Var;
    }

    @Override // defpackage.k50
    public fx1 a(mm2 mm2Var) {
        mm2Var.getClass();
        m00 a = FindClassInModuleKt.a(mm2Var, this.b);
        zp3 zp3Var = null;
        if (a != null) {
            if (!lk0.A(a)) {
                a = null;
            }
            if (a != null) {
                zp3Var = a.u();
            }
        }
        if (zp3Var != null) {
            return zp3Var;
        }
        ErrorTypeKind errorTypeKind = ErrorTypeKind.D0;
        String q00Var = this.b.toString();
        q00Var.getClass();
        String zo2Var = this.c.toString();
        zo2Var.getClass();
        return xu0.d(errorTypeKind, q00Var, zo2Var);
    }

    public final zo2 c() {
        return this.c;
    }

    @Override // defpackage.k50
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b.j());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
