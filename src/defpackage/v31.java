package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class v31 {
    public static a a;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        boolean a(boolean z);

        void b(boolean z);
    }

    public static boolean a(boolean z) {
        a aVar = a;
        if (aVar != null) {
            return aVar.a(z);
        }
        return true;
    }

    public static void b(a aVar) {
        a = aVar;
    }

    public static void c(boolean z) {
        a aVar = a;
        if (aVar != null) {
            aVar.b(z);
        }
    }
}
