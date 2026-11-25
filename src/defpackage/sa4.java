package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KVariance;

/* loaded from: /tmp/classes2.dex */
public abstract class sa4 implements nw1 {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {

        /* renamed from: sa4$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static final /* synthetic */ class C0154a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[KVariance.values().length];
                try {
                    iArr[KVariance.a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[KVariance.b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[KVariance.c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(nw1 nw1Var) {
            nw1Var.getClass();
            StringBuilder sb = new StringBuilder();
            int i = C0154a.a[nw1Var.p().ordinal()];
            if (i == 1) {
                qc4 qc4Var = qc4.a;
            } else if (i == 2) {
                sb.append("in ");
            } else {
                if (i != 3) {
                    u.a();
                    return null;
                }
                sb.append("out ");
            }
            sb.append(nw1Var.getName());
            return sb.toString();
        }
    }
}
