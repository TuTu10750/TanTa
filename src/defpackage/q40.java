package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class q40 {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final Integer e;

    public q40(int i, int i2, int i3, boolean z, Integer num) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = z;
        this.e = num;
    }

    public /* synthetic */ q40(int i, int i2, int i3, boolean z, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i4 & 8) != 0 ? false : z, (i4 & 16) != 0 ? null : num);
    }

    public final int a() {
        return this.b;
    }

    public final Integer b() {
        return this.e;
    }

    public final int c() {
        return this.a;
    }

    public final boolean d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q40)) {
            return false;
        }
        q40 q40Var = (q40) obj;
        return this.a == q40Var.a && this.b == q40Var.b && this.c == q40Var.c && this.d == q40Var.d && dq1.a(this.e, q40Var.e);
    }

    public int hashCode() {
        int hashCode = ((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Boolean.hashCode(this.d)) * 31;
        Integer num = this.e;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        return "CompressionTarget(width=" + this.a + ", height=" + this.b + ", estimatedSizeKb=" + this.c + ", isLongImage=" + this.d + ", targetSizeKb=" + this.e + ")";
    }
}
