package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.l;
import kotlin.reflect.jvm.internal.impl.types.n;

/* loaded from: /tmp/classes2.dex */
public abstract class g1 extends fm2 {
    public final zo2 b;
    public final wq2 c;
    public final wq2 d;
    public final wq2 e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements l81 {

        /* renamed from: g1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0067a implements n81 {
            public C0067a() {
            }

            @Override // defpackage.n81
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public zp3 invoke(kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
                z00 f = cVar.f(g1.this);
                return f == null ? (zp3) g1.this.c.invoke() : f instanceof r94 ? KotlinTypeFactory.b((r94) f, n.g(f.k().getParameters())) : f instanceof fm2 ? n.v(f.k().a(cVar), ((fm2) f).z0(cVar), this) : f.u();
            }
        }

        public a() {
        }

        @Override // defpackage.l81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zp3 invoke() {
            g1 g1Var = g1.this;
            return n.u(g1Var, g1Var.D0(), new C0067a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements l81 {
        public b() {
        }

        @Override // defpackage.l81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MemberScope invoke() {
            return new yo1(g1.this.D0());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements l81 {
        public c() {
        }

        @Override // defpackage.l81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zb3 invoke() {
            return new yx1(g1.this);
        }
    }

    public g1(lu3 lu3Var, zo2 zo2Var) {
        if (lu3Var == null) {
            A0(0);
        }
        if (zo2Var == null) {
            A0(1);
        }
        this.b = zo2Var;
        this.c = lu3Var.i(new a());
        this.d = lu3Var.i(new b());
        this.e = lu3Var.i(new c());
    }

    private static /* synthetic */ void A0(int i) {
        String str = (i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 9 || i == 12 || i == 14 || i == 16 || i == 17 || i == 19 || i == 20) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i == 2) {
            objArr[1] = "getName";
        } else if (i == 3) {
            objArr[1] = "getOriginal";
        } else if (i == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i == 9 || i == 12 || i == 14 || i == 16) {
            objArr[1] = "getMemberScope";
        } else if (i == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i == 19) {
            objArr[1] = "substitute";
        } else if (i != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 4 && i != 5 && i != 6 && i != 9 && i != 12 && i != 14 && i != 16 && i != 17 && i != 19 && i != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.m00
    public MemberScope D0() {
        MemberScope z0 = z0(DescriptorUtilsKt.o(lk0.g(this)));
        if (z0 == null) {
            A0(17);
        }
        return z0;
    }

    @Override // defpackage.vw3
    /* renamed from: F0 */
    public m00 c(TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A0(18);
        }
        return typeSubstitutor.k() ? this : new ly1(this, typeSubstitutor);
    }

    @Override // defpackage.m00
    public List G0() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            A0(6);
        }
        return list;
    }

    @Override // defpackage.fm2
    public MemberScope H(l lVar, kotlin.reflect.jvm.internal.impl.types.checker.c cVar) {
        if (lVar == null) {
            A0(10);
        }
        if (cVar == null) {
            A0(11);
        }
        if (!lVar.f()) {
            return new SubstitutingScope(z0(cVar), TypeSubstitutor.g(lVar));
        }
        MemberScope z0 = z0(cVar);
        if (z0 == null) {
            A0(12);
        }
        return z0;
    }

    @Override // defpackage.m00
    public zb3 J0() {
        zb3 zb3Var = (zb3) this.e.invoke();
        if (zb3Var == null) {
            A0(5);
        }
        return zb3Var;
    }

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.h(this, obj);
    }

    @Override // defpackage.ra0, defpackage.z00
    public m00 a() {
        return this;
    }

    @Override // defpackage.m00
    public MemberScope a0(l lVar) {
        if (lVar == null) {
            A0(15);
        }
        MemberScope H = H(lVar, DescriptorUtilsKt.o(lk0.g(this)));
        if (H == null) {
            A0(16);
        }
        return H;
    }

    @Override // defpackage.ep2
    public zo2 getName() {
        zo2 zo2Var = this.b;
        if (zo2Var == null) {
            A0(2);
        }
        return zo2Var;
    }

    @Override // defpackage.m00, defpackage.z00
    public zp3 u() {
        zp3 zp3Var = (zp3) this.c.invoke();
        if (zp3Var == null) {
            A0(20);
        }
        return zp3Var;
    }

    @Override // defpackage.m00
    public MemberScope x0() {
        MemberScope memberScope = (MemberScope) this.d.invoke();
        if (memberScope == null) {
            A0(4);
        }
        return memberScope;
    }
}
