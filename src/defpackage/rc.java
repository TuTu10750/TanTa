package defpackage;

/* loaded from: /tmp/classes2.dex */
public class rc {
    public String a;
    public String b;
    public String c;
    public int d;
    public int e;

    public rc(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = i + str3.length();
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }

    public void e(int i) {
        this.d += i;
        this.e += i;
    }

    public boolean f() {
        int i = this.e;
        int i2 = this.d;
        return i > i2 && i - i2 == this.c.length();
    }
}
