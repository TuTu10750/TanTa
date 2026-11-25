package defpackage;

import com.uc.crashsdk.export.CrashStatKey;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: /tmp/classes2.dex */
public abstract class ik0 {

    /* loaded from: /tmp/classes2.dex */
    public static class a extends rq2 {
        public final /* synthetic */ su0 a;
        public final /* synthetic */ Set b;
        public final /* synthetic */ boolean c;

        /* renamed from: ik0$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0075a implements n81 {
            public C0075a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // defpackage.n81
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public qc4 invoke(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    a(0);
                }
                a.this.a.b(callableMemberDescriptor);
                return qc4.a;
            }
        }

        public a(su0 su0Var, Set set, boolean z) {
            this.a = su0Var;
            this.b = set;
            this.c = z;
        }

        private static /* synthetic */ void f(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "fromSuper";
            } else if (i == 2) {
                objArr[0] = "fromCurrent";
            } else if (i == 3) {
                objArr[0] = "member";
            } else if (i != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i == 1 || i == 2) {
                objArr[2] = "conflict";
            } else if (i == 3 || i == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // defpackage.cv2
        public void a(CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                f(0);
            }
            OverridingUtil.K(callableMemberDescriptor, new C0075a());
            this.b.add(callableMemberDescriptor);
        }

        @Override // defpackage.cv2
        public void d(CallableMemberDescriptor callableMemberDescriptor, Collection collection) {
            if (callableMemberDescriptor == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.c || callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                super.d(callableMemberDescriptor, collection);
            }
        }

        @Override // defpackage.rq2
        public void e(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
            if (callableMemberDescriptor == null) {
                f(1);
            }
            if (callableMemberDescriptor2 == null) {
                f(2);
            }
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 18 ? 3 : 2];
        switch (i) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[0] = "annotationClass";
                break;
        }
        if (i != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case CrashStatKey.LOG_UPLOAD_BYTES_LIMIT /* 19 */:
            case CrashStatKey.LOG_UPLOAD_BUILTIN_LIMIT /* 20 */:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i == 18) {
            throw new IllegalStateException(format);
        }
    }

    public static h b(zo2 zo2Var, m00 m00Var) {
        if (zo2Var == null) {
            a(19);
        }
        if (m00Var == null) {
            a(20);
        }
        Collection m = m00Var.m();
        if (m.size() != 1) {
            return null;
        }
        for (h hVar : ((b) m.iterator().next()).h()) {
            if (hVar.getName().equals(zo2Var)) {
                return hVar;
            }
        }
        return null;
    }

    public static Collection c(zo2 zo2Var, Collection collection, Collection collection2, m00 m00Var, su0 su0Var, OverridingUtil overridingUtil, boolean z) {
        if (zo2Var == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (m00Var == null) {
            a(15);
        }
        if (su0Var == null) {
            a(16);
        }
        if (overridingUtil == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.v(zo2Var, collection, collection2, m00Var, new a(su0Var, linkedHashSet, z));
        return linkedHashSet;
    }

    public static Collection d(zo2 zo2Var, Collection collection, Collection collection2, m00 m00Var, su0 su0Var, OverridingUtil overridingUtil) {
        if (zo2Var == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (m00Var == null) {
            a(3);
        }
        if (su0Var == null) {
            a(4);
        }
        if (overridingUtil == null) {
            a(5);
        }
        return c(zo2Var, collection, collection2, m00Var, su0Var, overridingUtil, false);
    }

    public static Collection e(zo2 zo2Var, Collection collection, Collection collection2, m00 m00Var, su0 su0Var, OverridingUtil overridingUtil) {
        if (zo2Var == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (m00Var == null) {
            a(9);
        }
        if (su0Var == null) {
            a(10);
        }
        if (overridingUtil == null) {
            a(11);
        }
        return c(zo2Var, collection, collection2, m00Var, su0Var, overridingUtil, true);
    }
}
