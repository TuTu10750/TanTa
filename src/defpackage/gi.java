package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class gi {
    public static final a f = new a(null);
    public final int[] a;
    public final int b;
    public final int c;
    public final int d;
    public final List e;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public gi(int... iArr) {
        List k;
        iArr.getClass();
        this.a = iArr;
        Integer H = rb.H(iArr, 0);
        this.b = H != null ? H.intValue() : -1;
        Integer H2 = rb.H(iArr, 1);
        this.c = H2 != null ? H2.intValue() : -1;
        Integer H3 = rb.H(iArr, 2);
        this.d = H3 != null ? H3.intValue() : -1;
        if (iArr.length <= 3) {
            k = s20.k();
        } else {
            if (iArr.length > 1024) {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + iArr.length + '.');
            }
            k = b30.I0(pb.d(iArr).subList(3, iArr.length));
        }
        this.e = k;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.c;
    }

    public final boolean c(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 > i) {
            return true;
        }
        if (i4 < i) {
            return false;
        }
        int i5 = this.c;
        if (i5 > i2) {
            return true;
        }
        return i5 >= i2 && this.d >= i3;
    }

    public final boolean d(gi giVar) {
        giVar.getClass();
        return c(giVar.b, giVar.c, giVar.d);
    }

    public final boolean e(int i, int i2, int i3) {
        int i4 = this.b;
        if (i4 < i) {
            return true;
        }
        if (i4 > i) {
            return false;
        }
        int i5 = this.c;
        if (i5 < i2) {
            return true;
        }
        return i5 <= i2 && this.d <= i3;
    }

    public boolean equals(Object obj) {
        if (obj == null || !dq1.a(getClass(), obj.getClass())) {
            return false;
        }
        gi giVar = (gi) obj;
        return this.b == giVar.b && this.c == giVar.c && this.d == giVar.d && dq1.a(this.e, giVar.e);
    }

    public final boolean f(gi giVar) {
        giVar.getClass();
        int i = this.b;
        return i == 0 ? giVar.b == 0 && this.c == giVar.c : i == giVar.b && this.c <= giVar.c;
    }

    public final int[] g() {
        return this.a;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = i + (i * 31) + this.c;
        int i3 = i2 + (i2 * 31) + this.d;
        return i3 + (i3 * 31) + this.e.hashCode();
    }

    public String toString() {
        int[] g = g();
        ArrayList arrayList = new ArrayList();
        for (int i : g) {
            if (i == -1) {
                break;
            }
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList.isEmpty() ? "unknown" : b30.k0(arrayList, ".", null, null, 0, null, null, 62, null);
    }
}
