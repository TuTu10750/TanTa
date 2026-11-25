package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public class np1 implements Iterable, bw1 {
    public static final a d = new a(null);
    public final int a;
    public final int b;
    public final int c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final np1 a(int i, int i2, int i3) {
            return new np1(i, i2, i3);
        }
    }

    public np1(int i, int i2, int i3) {
        if (i3 == 0) {
            ik.a("Step must be non-zero.");
            throw null;
        }
        if (i3 == Integer.MIN_VALUE) {
            ik.a("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.a = i;
        this.b = d33.c(i, i2, i3);
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof np1)) {
            return false;
        }
        if (isEmpty() && ((np1) obj).isEmpty()) {
            return true;
        }
        np1 np1Var = (np1) obj;
        return this.a == np1Var.a && this.b == np1Var.b && this.c == np1Var.c;
    }

    public final int g() {
        return this.a;
    }

    public final int h() {
        return this.b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final int i() {
        return this.c;
    }

    public boolean isEmpty() {
        int i = this.c;
        int i2 = this.a;
        int i3 = this.b;
        return i > 0 ? i2 > i3 : i2 < i3;
    }

    @Override // java.lang.Iterable
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public lp1 iterator() {
        return new op1(this.a, this.b, this.c);
    }

    public String toString() {
        StringBuilder sb;
        int i;
        int i2 = this.c;
        int i3 = this.a;
        if (i2 > 0) {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append("..");
            sb.append(this.b);
            sb.append(" step ");
            i = this.c;
        } else {
            sb = new StringBuilder();
            sb.append(i3);
            sb.append(" downTo ");
            sb.append(this.b);
            sb.append(" step ");
            i = -this.c;
        }
        sb.append(i);
        return sb.toString();
    }
}
