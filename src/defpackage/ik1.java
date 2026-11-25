package defpackage;

/* loaded from: /tmp/classes2.dex */
public class ik1 {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    public void a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public String b() {
        return !j30.q().N() ? "0" : e(this.e);
    }

    public String c() {
        return !j30.q().N() ? "0" : e(this.f);
    }

    public String d() {
        return !j30.q().N() ? "0" : e(this.c);
    }

    public final String e(int i) {
        if (i < 0) {
            i = 0;
        }
        return i > 99 ? "99+" : String.valueOf(i);
    }

    public String f() {
        return !j30.q().N() ? "0" : e(this.d);
    }

    public String g() {
        if (!j30.q().N()) {
            return "0";
        }
        int e = ((((this.a + bs3.d().e("systemMsgCount", 0)) - this.c) - this.d) - this.e) - this.f;
        if (j30.q().Q()) {
            e -= this.b;
        }
        return e(e);
    }

    public String h() {
        return i(true);
    }

    public String i(boolean z) {
        if (!j30.q().N()) {
            return "0";
        }
        int i = this.a;
        if (z) {
            i += bs3.d().e("systemMsgCount", 0);
        }
        if (j30.q().Q()) {
            i -= this.b;
        }
        return e(i);
    }

    public void j(int i) {
        this.e = i;
    }

    public void k(int i) {
        this.f = i;
    }

    public void l(int i) {
        this.c = i;
    }

    public void m(int i) {
        this.b = i;
    }

    public void n(int i) {
        this.d = i;
    }

    public void o(int i) {
        this.a = i;
    }
}
