package defpackage;

import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public class va4 extends ua4 {
    public final Variance a;
    public final fx1 b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public va4(fx1 fx1Var) {
        this(Variance.INVARIANT, fx1Var);
        if (fx1Var == null) {
            d(2);
        }
    }

    public va4(Variance variance, fx1 fx1Var) {
        if (variance == null) {
            d(0);
        }
        if (fx1Var == null) {
            d(1);
        }
        this.a = variance;
        this.b = fx1Var;
    }

    public static /* synthetic */ void d(int i) {
        String str = (i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
                objArr[0] = "type";
                break;
            case 4:
            case 5:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
                break;
            case 6:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "projection";
                break;
        }
        if (i == 4) {
            objArr[1] = "getProjectionKind";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        } else {
            objArr[1] = "getType";
        }
        if (i == 3) {
            objArr[2] = "replaceType";
        } else if (i != 4 && i != 5) {
            if (i != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "refine";
            }
        }
        String format = String.format(str, objArr);
        if (i != 4 && i != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.ta4
    public ta4 a(c cVar) {
        if (cVar == null) {
            d(6);
        }
        return new va4(this.a, cVar.a(this.b));
    }

    @Override // defpackage.ta4
    public Variance b() {
        Variance variance = this.a;
        if (variance == null) {
            d(4);
        }
        return variance;
    }

    @Override // defpackage.ta4
    public boolean c() {
        return false;
    }

    @Override // defpackage.ta4
    public fx1 getType() {
        fx1 fx1Var = this.b;
        if (fx1Var == null) {
            d(5);
        }
        return fx1Var;
    }
}
