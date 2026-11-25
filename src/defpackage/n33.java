package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;

/* loaded from: /tmp/classes2.dex */
public abstract class n33 extends ua0 implements f {
    public boolean e;
    public final boolean f;
    public final Modality g;
    public final o33 h;
    public final boolean i;
    public final CallableMemberDescriptor.Kind j;
    public pk0 k;
    public e l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n33(Modality modality, pk0 pk0Var, o33 o33Var, j8 j8Var, zo2 zo2Var, boolean z, boolean z2, boolean z3, CallableMemberDescriptor.Kind kind, xr3 xr3Var) {
        super(o33Var.b(), j8Var, zo2Var, xr3Var);
        if (modality == null) {
            H(0);
        }
        if (pk0Var == null) {
            H(1);
        }
        if (o33Var == null) {
            H(2);
        }
        if (j8Var == null) {
            H(3);
        }
        if (zo2Var == null) {
            H(4);
        }
        if (xr3Var == null) {
            H(5);
        }
        this.l = null;
        this.g = modality;
        this.k = pk0Var;
        this.h = o33Var;
        this.e = z;
        this.f = z2;
        this.i = z3;
        this.j = kind;
    }

    private static /* synthetic */ void H(int i) {
        String str;
        int i2;
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 7:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                i2 = 2;
                break;
            case 7:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "visibility";
                break;
            case 2:
                objArr[0] = "correspondingProperty";
                break;
            case 3:
                objArr[0] = "annotations";
                break;
            case 4:
                objArr[0] = "name";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 7:
                objArr[0] = "substitutor";
                break;
            case 16:
                objArr[0] = "overriddenDescriptors";
                break;
            default:
                objArr[0] = "modality";
                break;
        }
        switch (i) {
            case 6:
                objArr[1] = "getKind";
                break;
            case 7:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyAccessorDescriptorImpl";
                break;
            case 8:
                objArr[1] = "substitute";
                break;
            case 9:
                objArr[1] = "getTypeParameters";
                break;
            case 10:
                objArr[1] = "getModality";
                break;
            case 11:
                objArr[1] = "getVisibility";
                break;
            case 12:
                objArr[1] = "getCorrespondingVariable";
                break;
            case 13:
                objArr[1] = "getCorrespondingProperty";
                break;
            case 14:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 15:
                objArr[1] = "getOverriddenDescriptors";
                break;
        }
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                break;
            case 7:
                objArr[2] = "substitute";
                break;
            case 16:
                objArr[2] = "setOverriddenDescriptors";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 6:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                throw new IllegalStateException(format);
            case 7:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    public o33 B0() {
        o33 o33Var = this.h;
        if (o33Var == null) {
            H(13);
        }
        return o33Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean C0() {
        return false;
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean F() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    /* renamed from: F0, reason: merged with bridge method [inline-methods] */
    public f M(ra0 ra0Var, Modality modality, pk0 pk0Var, CallableMemberDescriptor.Kind kind, boolean z) {
        throw new UnsupportedOperationException("Accessors must be copied by the corresponding property");
    }

    @Override // defpackage.ck2
    public boolean K() {
        return false;
    }

    public Collection K0(boolean z) {
        ArrayList arrayList = new ArrayList(0);
        for (o33 o33Var : B0().e()) {
            ra0 f = z ? o33Var.f() : o33Var.g();
            if (f != null) {
                arrayList.add(f);
            }
        }
        return arrayList;
    }

    public void L0(boolean z) {
        this.e = z;
    }

    public void M0(e eVar) {
        this.l = eVar;
    }

    public void N0(pk0 pk0Var) {
        this.k = pk0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean O() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    public boolean T() {
        return this.e;
    }

    @Override // defpackage.vw3
    public e c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            H(7);
        }
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public e d0() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 e0() {
        return B0().e0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List getTypeParameters() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            H(9);
        }
        return list;
    }

    @Override // defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = this.k;
        if (pk0Var == null) {
            H(11);
        }
        return pk0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public Object h0(a.InterfaceC0097a interfaceC0097a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.j;
        if (kind == null) {
            H(6);
        }
        return kind;
    }

    @Override // defpackage.ck2
    public boolean isExternal() {
        return this.f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInfix() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isOperator() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public zb3 k0() {
        return B0().k0();
    }

    @Override // defpackage.ck2
    public Modality l() {
        Modality modality = this.g;
        if (modality == null) {
            H(10);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List p0() {
        List p0 = B0().p0();
        if (p0 == null) {
            H(14);
        }
        return p0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean v0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void w0(Collection collection) {
        if (collection == null) {
            H(16);
        }
    }
}
