package defpackage;

import java.lang.ref.WeakReference;

/* loaded from: /tmp/classes2.dex */
public final class sm4 {
    public final WeakReference a;
    public final int b;
    public ClassLoader c;

    public sm4(ClassLoader classLoader) {
        classLoader.getClass();
        this.a = new WeakReference(classLoader);
        this.b = System.identityHashCode(classLoader);
        this.c = classLoader;
    }

    public final void a(ClassLoader classLoader) {
        this.c = classLoader;
    }

    public boolean equals(Object obj) {
        return (obj instanceof sm4) && this.a.get() == ((sm4) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        String obj;
        ClassLoader classLoader = (ClassLoader) this.a.get();
        return (classLoader == null || (obj = classLoader.toString()) == null) ? "<null>" : obj;
    }
}
