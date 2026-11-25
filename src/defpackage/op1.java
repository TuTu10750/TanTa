package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class op1 extends lp1 {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public op1(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // defpackage.lp1
    public int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
            return i;
        }
        if (this.c) {
            this.c = false;
            return i;
        }
        zm.a();
        return 0;
    }
}
