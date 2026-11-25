package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;

/* loaded from: /tmp/classes2.dex */
public class r33 extends n33 implements q33 {
    public fx1 m;
    public final q33 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r33(o33 o33Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, boolean z2, boolean z3, CallableMemberDescriptor.Kind kind, q33 q33Var, xr3 xr3Var) {
        super(modality, pk0Var, o33Var, j8Var, zo2.l("<get-" + o33Var.getName() + ">"), z, z2, z3, kind, xr3Var);
        if (o33Var == null) {
            H(0);
        }
        if (j8Var == null) {
            H(1);
        }
        if (modality == null) {
            H(2);
        }
        if (pk0Var == null) {
            H(3);
        }
        if (kind == null) {
            H(4);
        }
        if (xr3Var == null) {
            H(5);
        }
        this.n = q33Var != null ? q33Var : this;
    }

    private static /* synthetic */ void H(int i) {
        String str = (i == 6 || i == 7 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 6 || i == 7 || i == 8) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i == 7) {
            objArr[1] = "getValueParameters";
        } else if (i != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 6 && i != 7 && i != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 6 && i != 7 && i != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public q33 a() {
        q33 q33Var = this.n;
        if (q33Var == null) {
            H(8);
        }
        return q33Var;
    }

    public void P0(fx1 fx1Var) {
        if (fx1Var == null) {
            fx1Var = B0().getType();
        }
        this.m = fx1Var;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.d(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection e() {
        Collection K0 = super.K0(true);
        if (K0 == null) {
            H(6);
        }
        return K0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public fx1 getReturnType() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List h() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            H(7);
        }
        return list;
    }
}
