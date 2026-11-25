package defpackage;

/* loaded from: /tmp/classes2.dex */
public class aw0 {
    public int a;
    public int b;
    public int c;

    public aw0(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            aw0 aw0Var = (aw0) obj;
            if (this.a == aw0Var.a && this.b == aw0Var.b && this.c == aw0Var.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }
}
