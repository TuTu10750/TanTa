package defpackage;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public interface jp3 {
    public static final jp3 a = new a();

    /* loaded from: /tmp/classes2.dex */
    public static class a implements jp3 {
        public static /* synthetic */ void c(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                    objArr[0] = "owner";
                    break;
                case 2:
                    objArr[0] = "returnType";
                    break;
                case 3:
                    objArr[0] = "valueParameters";
                    break;
                case 4:
                    objArr[0] = "typeParameters";
                    break;
                case 5:
                    objArr[0] = "descriptor";
                    break;
                case 6:
                    objArr[0] = "signatureErrors";
                    break;
                default:
                    objArr[0] = "method";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$1";
            if (i == 5 || i == 6) {
                objArr[2] = "reportSignatureErrors";
            } else {
                objArr[2] = "resolvePropagatedSignature";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.jp3
        public void a(CallableMemberDescriptor callableMemberDescriptor, List list) {
            if (callableMemberDescriptor == null) {
                c(5);
            }
            if (list == null) {
                c(6);
            }
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // defpackage.jp3
        public b b(ks1 ks1Var, m00 m00Var, fx1 fx1Var, fx1 fx1Var2, List list, List list2) {
            if (ks1Var == null) {
                c(0);
            }
            if (m00Var == null) {
                c(1);
            }
            if (fx1Var == null) {
                c(2);
            }
            if (list == null) {
                c(3);
            }
            if (list2 == null) {
                c(4);
            }
            return new b(fx1Var, fx1Var2, list, list2, Collections.EMPTY_LIST, false);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        public final fx1 a;
        public final fx1 b;
        public final List c;
        public final List d;
        public final List e;
        public final boolean f;

        public b(fx1 fx1Var, fx1 fx1Var2, List list, List list2, List list3, boolean z) {
            if (fx1Var == null) {
                a(0);
            }
            if (list == null) {
                a(1);
            }
            if (list2 == null) {
                a(2);
            }
            if (list3 == null) {
                a(3);
            }
            this.a = fx1Var;
            this.b = fx1Var2;
            this.c = list;
            this.d = list2;
            this.e = list3;
            this.f = z;
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 4 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 4 || i == 5 || i == 6 || i == 7) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "valueParameters";
                    break;
                case 2:
                    objArr[0] = "typeParameters";
                    break;
                case 3:
                    objArr[0] = "signatureErrors";
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
                    break;
                default:
                    objArr[0] = "returnType";
                    break;
            }
            if (i == 4) {
                objArr[1] = "getReturnType";
            } else if (i == 5) {
                objArr[1] = "getValueParameters";
            } else if (i == 6) {
                objArr[1] = "getTypeParameters";
            } else if (i != 7) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/SignaturePropagator$PropagatedSignature";
            } else {
                objArr[1] = "getErrors";
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

        public List b() {
            List list = this.e;
            if (list == null) {
                a(7);
            }
            return list;
        }

        public fx1 c() {
            return this.b;
        }

        public fx1 d() {
            fx1 fx1Var = this.a;
            if (fx1Var == null) {
                a(4);
            }
            return fx1Var;
        }

        public List e() {
            List list = this.d;
            if (list == null) {
                a(6);
            }
            return list;
        }

        public List f() {
            List list = this.c;
            if (list == null) {
                a(5);
            }
            return list;
        }

        public boolean g() {
            return this.f;
        }
    }

    void a(CallableMemberDescriptor callableMemberDescriptor, List list);

    b b(ks1 ks1Var, m00 m00Var, fx1 fx1Var, fx1 fx1Var2, List list, List list2);
}
