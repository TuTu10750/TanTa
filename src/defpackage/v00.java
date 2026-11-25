package defpackage;

import defpackage.nx3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class v00 extends h1 implements ea4 {
    public final m00 d;
    public final List e;
    public final Collection f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v00(m00 m00Var, List list, Collection collection, lu3 lu3Var) {
        super(lu3Var);
        if (m00Var == null) {
            u(0);
        }
        if (list == null) {
            u(1);
        }
        if (collection == null) {
            u(2);
        }
        if (lu3Var == null) {
            u(3);
        }
        this.d = m00Var;
        this.e = Collections.unmodifiableList(new ArrayList(list));
        this.f = Collections.unmodifiableCollection(collection);
    }

    public static /* synthetic */ void u(int i) {
        String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 1:
                objArr[0] = "parameters";
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i == 4) {
            objArr[1] = "getParameters";
        } else if (i == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i != 4 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // defpackage.ea4
    public boolean d() {
        return true;
    }

    @Override // defpackage.ea4
    public List getParameters() {
        List list = this.e;
        if (list == null) {
            u(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public Collection k() {
        Collection collection = this.f;
        if (collection == null) {
            u(6);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    public nx3 o() {
        nx3.a aVar = nx3.a.a;
        if (aVar == null) {
            u(7);
        }
        return aVar;
    }

    public String toString() {
        return lk0.m(this.d).b();
    }

    @Override // defpackage.y00, defpackage.ea4
    public m00 v() {
        m00 m00Var = this.d;
        if (m00Var == null) {
            u(5);
        }
        return m00Var;
    }
}
