package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.d;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.j;

/* loaded from: /tmp/classes2.dex */
public abstract class g2 extends ua0 implements oa4 {
    public final Variance e;
    public final boolean f;
    public final int g;
    public final wq2 h;
    public final wq2 i;
    public final lu3 j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements l81 {
        public final /* synthetic */ lu3 a;
        public final /* synthetic */ nx3 b;

        public a(lu3 lu3Var, nx3 nx3Var) {
            this.a = lu3Var;
            this.b = nx3Var;
        }

        @Override // defpackage.l81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ea4 invoke() {
            return new c(g2.this, this.a, this.b);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements l81 {
        public final /* synthetic */ zo2 a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements l81 {
            public a() {
            }

            @Override // defpackage.l81
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MemberScope invoke() {
                return TypeIntersectionScope.j("Scope for type parameter " + b.this.a.b(), g2.this.getUpperBounds());
            }
        }

        public b(zo2 zo2Var) {
            this.a = zo2Var;
        }

        @Override // defpackage.l81
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public zp3 invoke() {
            return KotlinTypeFactory.k(j.b.h(), g2.this.k(), Collections.EMPTY_LIST, false, new LazyScopeAdapter(new a()));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends AbstractTypeConstructor {
        public final nx3 d;
        public final /* synthetic */ g2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(g2 g2Var, lu3 lu3Var, nx3 nx3Var) {
            super(lu3Var);
            if (lu3Var == null) {
                u(0);
            }
            this.e = g2Var;
            this.d = nx3Var;
        }

        private static /* synthetic */ void u(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5 && i != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // defpackage.y00, defpackage.ea4
        public z00 b() {
            g2 g2Var = this.e;
            if (g2Var == null) {
                u(3);
            }
            return g2Var;
        }

        @Override // defpackage.ea4
        public boolean d() {
            return true;
        }

        @Override // defpackage.ea4
        public List getParameters() {
            List list = Collections.EMPTY_LIST;
            if (list == null) {
                u(2);
            }
            return list;
        }

        @Override // defpackage.y00
        public boolean h(z00 z00Var) {
            if (z00Var == null) {
                u(9);
            }
            return (z00Var instanceof oa4) && DescriptorEquivalenceForOverrides.a.h(this.e, (oa4) z00Var, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public Collection k() {
            List L0 = this.e.L0();
            if (L0 == null) {
                u(1);
            }
            return L0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public fx1 l() {
            return xu0.d(ErrorTypeKind.u, new String[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public nx3 o() {
            nx3 nx3Var = this.d;
            if (nx3Var == null) {
                u(5);
            }
            return nx3Var;
        }

        @Override // defpackage.ea4
        public d q() {
            d j = DescriptorUtilsKt.j(this.e);
            if (j == null) {
                u(4);
            }
            return j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public List r(List list) {
            if (list == null) {
                u(7);
            }
            List F0 = this.e.F0(list);
            if (F0 == null) {
                u(8);
            }
            return F0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
        public void t(fx1 fx1Var) {
            if (fx1Var == null) {
                u(6);
            }
            this.e.K0(fx1Var);
        }

        public String toString() {
            return this.e.getName().toString();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(lu3 lu3Var, ra0 ra0Var, j8 j8Var, zo2 zo2Var, Variance variance, boolean z, int i, xr3 xr3Var, nx3 nx3Var) {
        super(ra0Var, j8Var, zo2Var, xr3Var);
        if (lu3Var == null) {
            H(0);
        }
        if (ra0Var == null) {
            H(1);
        }
        if (j8Var == null) {
            H(2);
        }
        if (zo2Var == null) {
            H(3);
        }
        if (variance == null) {
            H(4);
        }
        if (xr3Var == null) {
            H(5);
        }
        if (nx3Var == null) {
            H(6);
        }
        this.e = variance;
        this.f = z;
        this.g = i;
        this.h = lu3Var.i(new a(lu3Var, nx3Var));
        this.i = lu3Var.i(new b(zo2Var));
        this.j = lu3Var;
    }

    private static /* synthetic */ void H(int i) {
        String str;
        int i2;
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i2 = 2;
                break;
            case 12:
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // defpackage.oa4
    public boolean E() {
        return this.f;
    }

    public List F0(List list) {
        if (list == null) {
            H(12);
        }
        if (list == null) {
            H(13);
        }
        return list;
    }

    public abstract void K0(fx1 fx1Var);

    public abstract List L0();

    @Override // defpackage.ra0
    public Object W(va0 va0Var, Object obj) {
        return va0Var.m(this, obj);
    }

    @Override // defpackage.ua0, defpackage.sa0, defpackage.ra0, defpackage.z00
    public oa4 a() {
        oa4 oa4Var = (oa4) super.a();
        if (oa4Var == null) {
            H(11);
        }
        return oa4Var;
    }

    @Override // defpackage.oa4
    public lu3 g0() {
        lu3 lu3Var = this.j;
        if (lu3Var == null) {
            H(14);
        }
        return lu3Var;
    }

    @Override // defpackage.oa4
    public int getIndex() {
        return this.g;
    }

    @Override // defpackage.oa4
    public List getUpperBounds() {
        List c2 = ((c) k()).c();
        if (c2 == null) {
            H(8);
        }
        return c2;
    }

    @Override // defpackage.oa4, defpackage.z00
    public final ea4 k() {
        ea4 ea4Var = (ea4) this.h.invoke();
        if (ea4Var == null) {
            H(9);
        }
        return ea4Var;
    }

    @Override // defpackage.oa4
    public boolean m0() {
        return false;
    }

    @Override // defpackage.oa4
    public Variance p() {
        Variance variance = this.e;
        if (variance == null) {
            H(7);
        }
        return variance;
    }

    @Override // defpackage.z00
    public zp3 u() {
        zp3 zp3Var = (zp3) this.i.invoke();
        if (zp3Var == null) {
            H(10);
        }
        return zp3Var;
    }
}
