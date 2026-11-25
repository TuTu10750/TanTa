package defpackage;

/* loaded from: /tmp/classes2.dex */
public class hq3 {
    public final Object a;
    public final Thread b = Thread.currentThread();

    public hq3(Object obj) {
        this.a = obj;
    }

    public Object a() {
        if (b()) {
            return this.a;
        }
        fl3.a("No value in this thread (hasValue should be checked before)");
        return null;
    }

    public boolean b() {
        return this.b == Thread.currentThread();
    }
}
