package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class eb3 {
    public static final void a(boolean z, Number number) {
        number.getClass();
        if (z) {
            return;
        }
        throw new IllegalArgumentException("Step must be positive, was: " + number + '.');
    }
}
