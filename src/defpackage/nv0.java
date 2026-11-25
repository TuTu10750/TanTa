package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class nv0 {
    public static final boolean a(Throwable th) {
        th.getClass();
        Class<?> cls = th.getClass();
        while (!dq1.a(cls.getCanonicalName(), "com.intellij.openapi.progress.ProcessCanceledException")) {
            cls = cls.getSuperclass();
            if (cls == null) {
                return false;
            }
        }
        return true;
    }

    public static final RuntimeException b(Throwable th) {
        th.getClass();
        throw th;
    }
}
