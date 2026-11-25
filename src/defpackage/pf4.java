package defpackage;

/* loaded from: /tmp/classes2.dex */
public class pf4 {
    public String a;
    public int b;
    public long c = System.currentTimeMillis() + 86400000;

    public pf4(String str, int i) {
        this.a = str;
        this.b = i;
    }

    public String toString() {
        return "ValueData{value='" + this.a + "', code=" + this.b + ", expired=" + this.c + '}';
    }
}
