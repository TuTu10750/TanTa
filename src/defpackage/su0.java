package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: /tmp/classes2.dex */
public interface su0 {
    public static final su0 a = new a();

    /* loaded from: /tmp/classes2.dex */
    public static class a implements su0 {
        public static /* synthetic */ void c(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "descriptor";
            } else {
                objArr[0] = "unresolvedSuperClasses";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            if (i != 2) {
                objArr[2] = "reportIncompleteHierarchy";
            } else {
                objArr[2] = "reportCannotInferVisibility";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.su0
        public void a(m00 m00Var, List list) {
            if (m00Var == null) {
                c(0);
            }
            if (list == null) {
                c(1);
            }
        }

        @Override // defpackage.su0
        public void b(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                c(2);
            }
        }
    }

    void a(m00 m00Var, List list);

    void b(CallableMemberDescriptor callableMemberDescriptor);
}
