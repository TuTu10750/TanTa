package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: /tmp/classes2.dex */
public abstract class y1 extends sa0 implements zb3 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(j8 j8Var) {
        super(j8Var, ls3.i);
        if (j8Var == null) {
            H(0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(j8 j8Var, zo2 zo2Var) {
        super(j8Var, zo2Var);
        if (j8Var == null) {
            H(1);
        }
        if (zo2Var == null) {
            H(2);
        }
    }

    private static /* synthetic */ void H(int i) {
        String str;
        int i2;
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "substitutor";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
            default:
                objArr[0] = "annotations";
                break;
        }
        switch (i) {
            case 4:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 5:
                objArr[1] = "getTypeParameters";
                break;
            case 6:
                objArr[1] = "getType";
                break;
            case 7:
                objArr[1] = "getValueParameters";
                break;
            case 8:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 9:
                objArr[1] = "getVisibility";
                break;
            case 10:
                objArr[1] = "getOriginal";
                break;
            case 11:
                objArr[1] = "getSource";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractReceiverParameterDescriptor";
                break;
        }
        switch (i) {
            case 3:
                objArr[2] = "substitute";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // defpackage.sa0, defpackage.ra0, defpackage.z00
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public cw2 a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean F() {
        return false;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.a(this, obj);
    }

    @Override // defpackage.vw3
    public zb3 c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            H(3);
        }
        if (!typeSubstitutor.k()) {
            fx1 p = b() instanceof m00 ? typeSubstitutor.p(getType(), Variance.OUT_VARIANCE) : typeSubstitutor.p(getType(), Variance.INVARIANT);
            if (p == null) {
                return null;
            }
            if (p != getType()) {
                return new ac3(b(), new v74(p), getAnnotations());
            }
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection e() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            H(8);
        }
        return set;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 e0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public fx1 getReturnType() {
        return getType();
    }

    @Override // defpackage.qf4
    public fx1 getType() {
        fx1 type = getValue().getType();
        if (type == null) {
            H(6);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            H(5);
        }
        return list;
    }

    @Override // defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = ok0.f;
        if (pk0Var == null) {
            H(9);
        }
        return pk0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List h() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            H(7);
        }
        return list;
    }

    @Override // defpackage.xa0
    public xr3 j() {
        xr3 xr3Var = xr3.a;
        if (xr3Var == null) {
            H(11);
        }
        return xr3Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 k0() {
        return null;
    }
}
