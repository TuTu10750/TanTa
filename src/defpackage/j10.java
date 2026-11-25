package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class j10 {
    public static long a;
    public static long b;

    public static boolean a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - a < 500) {
            return false;
        }
        a = currentTimeMillis;
        return true;
    }

    public static boolean b(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        lx1.c("9898", "111" + currentTimeMillis);
        lx1.c("9898", "222" + b);
        if (currentTimeMillis - b < i) {
            return false;
        }
        b = currentTimeMillis;
        return true;
    }
}
