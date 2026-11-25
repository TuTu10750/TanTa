package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class pp1 extends np1 {
    public static final a e = new a(null);
    public static final pp1 f = new pp1(1, 0);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final pp1 a() {
            return pp1.f;
        }
    }

    public pp1(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // defpackage.np1
    public boolean equals(Object obj) {
        if (!(obj instanceof pp1)) {
            return false;
        }
        if (isEmpty() && ((pp1) obj).isEmpty()) {
            return true;
        }
        pp1 pp1Var = (pp1) obj;
        return g() == pp1Var.g() && h() == pp1Var.h();
    }

    @Override // defpackage.np1
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // defpackage.np1
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean l(int i) {
        return g() <= i && i <= h();
    }

    public Integer m() {
        return Integer.valueOf(h());
    }

    public Integer n() {
        return Integer.valueOf(g());
    }

    @Override // defpackage.np1
    public String toString() {
        return g() + ".." + h();
    }
}
