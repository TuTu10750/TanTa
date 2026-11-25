package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class h54 {
    public static long a(long j) {
        String valueOf = String.valueOf(j);
        if (valueOf.length() < 13) {
            while (valueOf.length() < 13) {
                valueOf = valueOf.concat("0");
            }
        } else if (valueOf.length() > 13) {
            valueOf = valueOf.substring(0, 13);
        }
        return Long.parseLong(valueOf);
    }
}
