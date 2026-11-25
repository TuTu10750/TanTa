package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class dy implements Iterable, bw1 {
    public static final a d = new a(null);
    public final char a;
    public final char b;
    public final int c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public dy(char c, char c2, int i) {
        if (i == 0) {
            ik.a("Step must be non-zero.");
            throw null;
        }
        if (i == Integer.MIN_VALUE) {
            ik.a("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.a = c;
        this.b = (char) d33.c(c, c2, i);
        this.c = i;
    }

    public final char g() {
        return this.a;
    }

    public final char h() {
        return this.b;
    }

    @Override // java.lang.Iterable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public ay iterator() {
        return new ey(this.a, this.b, this.c);
    }
}
