package defpackage;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class cv1 extends gi {
    public static final a h = new a(null);
    public static final cv1 i;
    public static final cv1 j;
    public static final cv1 k;
    public final boolean g;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        cv1 cv1Var = new cv1(1, 8, 0);
        i = cv1Var;
        j = cv1Var.m();
        k = new cv1(new int[0]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public cv1(int... iArr) {
        this(iArr, false);
        iArr.getClass();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cv1(int[] iArr, boolean z) {
        super(Arrays.copyOf(iArr, iArr.length));
        iArr.getClass();
        this.g = z;
    }

    public final boolean h(cv1 cv1Var) {
        cv1Var.getClass();
        if (a() == 2 && b() == 0) {
            cv1 cv1Var2 = i;
            if (cv1Var2.a() == 1 && cv1Var2.b() == 8) {
                return true;
            }
        }
        return i(cv1Var.k(this.g));
    }

    public final boolean i(cv1 cv1Var) {
        if ((a() == 1 && b() == 0) || a() == 0) {
            return false;
        }
        return !l(cv1Var);
    }

    public final boolean j() {
        return this.g;
    }

    public final cv1 k(boolean z) {
        cv1 cv1Var = z ? i : j;
        return cv1Var.l(this) ? cv1Var : this;
    }

    public final boolean l(cv1 cv1Var) {
        if (a() > cv1Var.a()) {
            return true;
        }
        return a() >= cv1Var.a() && b() > cv1Var.b();
    }

    public final cv1 m() {
        return (a() == 1 && b() == 9) ? new cv1(2, 0, 0) : new cv1(a(), b() + 1, 0);
    }
}
