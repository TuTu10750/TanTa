package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class hv0 {
    public static final p04 a = new p04("REMOVED_TASK");
    public static final p04 b = new p04("CLOSED_EMPTY");

    public static final long c(long j) {
        if (j <= 0) {
            return 0L;
        }
        if (j >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j * 1000000;
    }
}
