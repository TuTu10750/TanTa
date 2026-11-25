package defpackage;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class r82 implements Iterable, bw1 {
    public static final a d = new a(null);
    public final long a;
    public final long b;
    public final long c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r82(long j, long j2, long j3) {
        if (j3 == 0) {
            ik.a("Step must be non-zero.");
            throw null;
        }
        if (j3 == Long.MIN_VALUE) {
            ik.a("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.a = j;
        this.b = d33.d(j, j2, j3);
        this.c = j3;
    }

    public final long g() {
        return this.a;
    }

    public final long h() {
        return this.b;
    }

    @Override // java.lang.Iterable
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public q82 iterator() {
        return new s82(this.a, this.b, this.c);
    }
}
