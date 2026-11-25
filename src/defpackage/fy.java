package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class fy extends dy {
    public static final a e = new a(null);
    public static final fy f = new fy(1, 0);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public fy(char c, char c2) {
        super(c, c2, 1);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof fy)) {
            return false;
        }
        if (isEmpty() && ((fy) obj).isEmpty()) {
            return true;
        }
        fy fyVar = (fy) obj;
        return g() == fyVar.g() && h() == fyVar.h();
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    public boolean isEmpty() {
        return dq1.b(g(), h()) > 0;
    }

    public String toString() {
        return g() + ".." + h();
    }
}
