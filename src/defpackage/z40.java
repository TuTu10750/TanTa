package defpackage;

/* loaded from: /tmp/classes2.dex */
public class z40 {
    public volatile boolean a;

    public synchronized void a() {
        this.a = false;
    }

    public synchronized void b() {
        boolean z = this.a;
        this.a = true;
        if (!z) {
            notify();
        }
    }
}
