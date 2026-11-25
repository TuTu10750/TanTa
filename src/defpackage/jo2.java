package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.c;

/* loaded from: /tmp/classes2.dex */
public class jo2 extends n00 {
    public final ClassKind i;
    public final boolean j;
    public Modality k;
    public pk0 l;
    public ea4 m;
    public List n;
    public final Collection o;
    public final lu3 p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo2(ra0 ra0Var, ClassKind classKind, boolean z, boolean z2, zo2 zo2Var, xr3 xr3Var, lu3 lu3Var) {
        super(lu3Var, ra0Var, zo2Var, xr3Var, z2);
        if (ra0Var == null) {
            A0(0);
        }
        if (classKind == null) {
            A0(1);
        }
        if (zo2Var == null) {
            A0(2);
        }
        if (xr3Var == null) {
            A0(3);
        }
        if (lu3Var == null) {
            A0(4);
        }
        this.o = new ArrayList();
        this.p = lu3Var;
        this.i = classKind;
        this.j = z;
    }

    private static /* synthetic */ void A0(int i) {
        String str;
        int i2;
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                i2 = 2;
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "kind";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 6:
                objArr[0] = "modality";
                break;
            case 9:
                objArr[0] = "visibility";
                break;
            case 12:
                objArr[0] = "supertype";
                break;
            case 14:
                objArr[0] = "typeParameters";
                break;
            case 16:
                objArr[0] = "kotlinTypeRefiner";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i) {
            case 5:
                objArr[1] = "getAnnotations";
                break;
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/MutableClassDescriptor";
                break;
            case 7:
                objArr[1] = "getModality";
                break;
            case 8:
                objArr[1] = "getKind";
                break;
            case 10:
                objArr[1] = "getVisibility";
                break;
            case 11:
                objArr[1] = "getTypeConstructor";
                break;
            case 13:
                objArr[1] = "getConstructors";
                break;
            case 15:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 17:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 18:
                objArr[1] = "getStaticScope";
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                objArr[1] = "getSealedSubclasses";
                break;
        }
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                break;
            case 6:
                objArr[2] = "setModality";
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 12:
                objArr[2] = "addSupertype";
                break;
            case 14:
                objArr[2] = "setTypeParameterDescriptors";
                break;
            case 16:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 5:
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
            case 17:
            case 18:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
                throw new IllegalStateException(format);
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // defpackage.m00
    public boolean C() {
        return false;
    }

    @Override // defpackage.ck2
    public boolean E0() {
        return false;
    }

    @Override // defpackage.m00
    public boolean I0() {
        return false;
    }

    @Override // defpackage.m00
    public Collection J() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(19);
        }
        return list;
    }

    @Override // defpackage.ck2
    public boolean K() {
        return false;
    }

    public void K0() {
        this.m = new v00(this, this.n, this.o, this.p);
        Iterator it = m().iterator();
        while (it.hasNext()) {
            ((j00) ((e) it.next())).g1(u());
        }
    }

    @Override // defpackage.m00
    /* renamed from: L0, reason: merged with bridge method [inline-methods] */
    public Set m() {
        Set set = Collections.EMPTY_SET;
        if (set == null) {
            A0(13);
        }
        return set;
    }

    public void M0(Modality modality) {
        if (modality == null) {
            A0(6);
        }
        this.k = modality;
    }

    public void N0(List list) {
        if (list == null) {
            A0(14);
        }
        if (this.n == null) {
            this.n = new ArrayList(list);
        } else {
            di3.a("Type parameters are already set for ", getName());
        }
    }

    public void O0(pk0 pk0Var) {
        if (pk0Var == null) {
            A0(9);
        }
        this.l = pk0Var;
    }

    @Override // defpackage.m00
    public b P() {
        return null;
    }

    @Override // defpackage.m00
    public MemberScope Q() {
        MemberScope.a aVar = MemberScope.a.b;
        if (aVar == null) {
            A0(18);
        }
        return aVar;
    }

    @Override // defpackage.m00
    public m00 S() {
        return null;
    }

    @Override // defpackage.a8
    public j8 getAnnotations() {
        j8 b = j8.a0.b();
        if (b == null) {
            A0(5);
        }
        return b;
    }

    @Override // defpackage.m00, defpackage.ya0
    public pk0 getVisibility() {
        pk0 pk0Var = this.l;
        if (pk0Var == null) {
            A0(10);
        }
        return pk0Var;
    }

    @Override // defpackage.m00
    public ClassKind i() {
        ClassKind classKind = this.i;
        if (classKind == null) {
            A0(8);
        }
        return classKind;
    }

    @Override // defpackage.m00
    public boolean isInline() {
        return false;
    }

    @Override // defpackage.z00
    public ea4 k() {
        ea4 ea4Var = this.m;
        if (ea4Var == null) {
            A0(11);
        }
        return ea4Var;
    }

    @Override // defpackage.m00, defpackage.ck2
    public Modality l() {
        Modality modality = this.k;
        if (modality == null) {
            A0(7);
        }
        return modality;
    }

    @Override // defpackage.m00
    public boolean n() {
        return false;
    }

    @Override // defpackage.a10
    public boolean o() {
        return this.j;
    }

    public String toString() {
        return sa0.z0(this);
    }

    @Override // defpackage.m00, defpackage.a10
    public List w() {
        List list = this.n;
        if (list == null) {
            A0(15);
        }
        return list;
    }

    @Override // defpackage.m00
    public boolean y() {
        return false;
    }

    @Override // defpackage.m00
    public nf4 y0() {
        return null;
    }

    @Override // defpackage.fm2
    public MemberScope z0(c cVar) {
        if (cVar == null) {
            A0(16);
        }
        MemberScope.a aVar = MemberScope.a.b;
        if (aVar == null) {
            A0(17);
        }
        return aVar;
    }
}
