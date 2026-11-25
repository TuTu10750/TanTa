package defpackage;

import kotlin.reflect.jvm.internal.impl.descriptors.c;
import kotlin.reflect.jvm.internal.impl.descriptors.g;

/* loaded from: /tmp/classes2.dex */
public interface vs1 {
    public static final vs1 a = new a();

    /* loaded from: /tmp/classes2.dex */
    public static class a implements vs1 {
        public static /* synthetic */ void f(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "member";
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                    objArr[0] = "descriptor";
                    break;
                case 3:
                    objArr[0] = "element";
                    break;
                case 5:
                    objArr[0] = "field";
                    break;
                case 7:
                    objArr[0] = "javaClass";
                    break;
                default:
                    objArr[0] = "fqName";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "recordMethod";
                    break;
                case 3:
                case 4:
                    objArr[2] = "recordConstructor";
                    break;
                case 5:
                case 6:
                    objArr[2] = "recordField";
                    break;
                case 7:
                case 8:
                    objArr[2] = "recordClass";
                    break;
                default:
                    objArr[2] = "getClassResolvedFromSource";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.vs1
        public void a(lr1 lr1Var, m00 m00Var) {
            if (lr1Var == null) {
                f(7);
            }
            if (m00Var == null) {
                f(8);
            }
        }

        @Override // defpackage.vs1
        public void b(cs1 cs1Var, o33 o33Var) {
            if (cs1Var == null) {
                f(5);
            }
            if (o33Var == null) {
                f(6);
            }
        }

        @Override // defpackage.vs1
        public void c(js1 js1Var, g gVar) {
            if (js1Var == null) {
                f(1);
            }
            if (gVar == null) {
                f(2);
            }
        }

        @Override // defpackage.vs1
        public m00 d(r51 r51Var) {
            if (r51Var != null) {
                return null;
            }
            f(0);
            return null;
        }

        @Override // defpackage.vs1
        public void e(as1 as1Var, c cVar) {
            if (as1Var == null) {
                f(3);
            }
            if (cVar == null) {
                f(4);
            }
        }
    }

    void a(lr1 lr1Var, m00 m00Var);

    void b(cs1 cs1Var, o33 o33Var);

    void c(js1 js1Var, g gVar);

    m00 d(r51 r51Var);

    void e(as1 as1Var, c cVar);
}
