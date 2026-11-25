package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class t82 extends r82 {
    public static final a e = new a(null);
    public static final t82 f = new t82(1, 0);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public t82(long j, long j2) {
        super(j, j2, 1L);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t82)) {
            return false;
        }
        if (isEmpty() && ((t82) obj).isEmpty()) {
            return true;
        }
        t82 t82Var = (t82) obj;
        return g() == t82Var.g() && h() == t82Var.h();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (g() ^ (g() >>> 32))) + (h() ^ (h() >>> 32)));
    }

    public boolean isEmpty() {
        return g() > h();
    }

    public String toString() {
        return g() + ".." + h();
    }
}
