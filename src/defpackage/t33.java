package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public class t33 extends n33 implements s33 {
    public h m;
    public final s33 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t33(o33 o33Var, j8 j8Var, Modality modality, pk0 pk0Var, boolean z, boolean z2, boolean z3, CallableMemberDescriptor.Kind kind, s33 s33Var, xr3 xr3Var) {
        super(modality, pk0Var, o33Var, j8Var, zo2.l("<set-" + o33Var.getName() + ">"), z, z2, z3, kind, xr3Var);
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
        this.n = s33Var != null ? s33Var : this;
    }

    private static /* synthetic */ void H(int i) {
        String str;
        int i2;
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 9:
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
                objArr[0] = "parameter";
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public static ValueParameterDescriptorImpl O0(s33 s33Var, fx1 fx1Var, j8 j8Var) {
        if (s33Var == null) {
            H(7);
        }
        if (fx1Var == null) {
            H(8);
        }
        if (j8Var == null) {
            H(9);
        }
        return new ValueParameterDescriptorImpl(s33Var, null, 0, j8Var, ls3.o, fx1Var, false, false, false, null, xr3.a);
    }

    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    /* renamed from: P0, reason: merged with bridge method [inline-methods] */
    public s33 a() {
        s33 s33Var = this.n;
        if (s33Var == null) {
            H(13);
        }
        return s33Var;
    }

    public void Q0(h hVar) {
        if (hVar == null) {
            H(6);
        }
        this.m = hVar;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.b(this, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection e() {
        Collection K0 = super.K0(false);
        if (K0 == null) {
            H(10);
        }
        return K0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public fx1 getReturnType() {
        zp3 Z = DescriptorUtilsKt.j(this).Z();
        if (Z == null) {
            H(12);
        }
        return Z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List h() {
        h hVar = this.m;
        if (hVar == null) {
            pr4.a();
            return null;
        }
        List singletonList = Collections.singletonList(hVar);
        if (singletonList == null) {
            H(11);
        }
        return singletonList;
    }
}
