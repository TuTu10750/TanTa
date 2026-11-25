package defpackage;

import kotlin.random.Random;

/* loaded from: /tmp/classes2.dex */
public class vq1 extends uq1 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public static final a a = new a();
        public static final Integer b;

        static {
            Integer num;
            Object obj;
            Integer num2 = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
                if (num != null && num.intValue() > 0) {
                    num2 = num;
                }
                b = num2;
            }
            num = null;
            if (num != null) {
                num2 = num;
            }
            b = num2;
        }
    }

    @Override // defpackage.ny2
    public Random b() {
        return c(34) ? new py2() : super.b();
    }

    public final boolean c(int i) {
        Integer num = a.b;
        return num == null || num.intValue() >= i;
    }
}
