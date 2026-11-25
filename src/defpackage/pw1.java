package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KVariance;

/* loaded from: /tmp/classes2.dex */
public final class pw1 {
    public static final a c = new a(null);
    public static final pw1 d = new pw1(null, null);
    public final KVariance a;
    public final lw1 b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final pw1 a(lw1 lw1Var) {
            lw1Var.getClass();
            return new pw1(KVariance.b, lw1Var);
        }

        public final pw1 b(lw1 lw1Var) {
            lw1Var.getClass();
            return new pw1(KVariance.c, lw1Var);
        }

        public final pw1 c() {
            return pw1.d;
        }

        public final pw1 d(lw1 lw1Var) {
            lw1Var.getClass();
            return new pw1(KVariance.a, lw1Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final /* synthetic */ class b {
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

    public pw1(KVariance kVariance, lw1 lw1Var) {
        String str;
        this.a = kVariance;
        this.b = lw1Var;
        if ((kVariance == null) == (lw1Var == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        ff1.a(str);
        throw null;
    }

    public final KVariance a() {
        return this.a;
    }

    public final lw1 b() {
        return this.b;
    }

    public final lw1 c() {
        return this.b;
    }

    public final KVariance d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pw1)) {
            return false;
        }
        pw1 pw1Var = (pw1) obj;
        return this.a == pw1Var.a && dq1.a(this.b, pw1Var.b);
    }

    public int hashCode() {
        KVariance kVariance = this.a;
        int hashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        lw1 lw1Var = this.b;
        return hashCode + (lw1Var != null ? lw1Var.hashCode() : 0);
    }

    public String toString() {
        KVariance kVariance = this.a;
        int i = kVariance == null ? -1 : b.a[kVariance.ordinal()];
        if (i == -1) {
            return "*";
        }
        if (i == 1) {
            return String.valueOf(this.b);
        }
        if (i == 2) {
            return "in " + this.b;
        }
        if (i != 3) {
            u.a();
            return null;
        }
        return "out " + this.b;
    }
}
