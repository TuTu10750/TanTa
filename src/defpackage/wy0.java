package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.a;

/* loaded from: /tmp/classes2.dex */
public class wy0 extends z1 implements bc3 {
    public final a c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wy0(a aVar, fx1 fx1Var, bc3 bc3Var) {
        super(fx1Var, bc3Var);
        if (aVar == null) {
            b(0);
        }
        if (fx1Var == null) {
            b(1);
        }
        this.c = aVar;
    }

    public static /* synthetic */ void b(int i) {
        String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 2 ? 3 : 2];
        if (i == 1) {
            objArr[0] = "receiverType";
        } else if (i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else if (i != 3) {
            objArr[0] = "callableDescriptor";
        } else {
            objArr[0] = "newType";
        }
        if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/ExtensionReceiver";
        } else {
            objArr[1] = "getDeclarationDescriptor";
        }
        if (i != 2) {
            if (i != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "replaceType";
            }
        }
        String format = String.format(str, objArr);
        if (i == 2) {
            throw new IllegalStateException(format);
        }
    }

    public String toString() {
        return getType() + ": Ext {" + this.c + "}";
    }
}
