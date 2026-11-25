package defpackage;

/* loaded from: /tmp/classes2.dex */
public class ic implements Runnable {
    public final px2 a = new px2();
    public final zu0 b;

    public ic(zu0 zu0Var) {
        this.b = zu0Var;
    }

    public void a(uw3 uw3Var, Object obj) {
        this.a.a(ox2.a(uw3Var, obj));
        this.b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        ox2 b = this.a.b();
        if (b != null) {
            this.b.f(b);
        } else {
            fl3.a("No pending post available");
        }
    }
}
