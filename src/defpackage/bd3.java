package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class bd3 {
    public static final Class a(ClassLoader classLoader, String str) {
        classLoader.getClass();
        str.getClass();
        try {
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
