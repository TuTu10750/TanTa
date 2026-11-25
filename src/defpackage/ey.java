package defpackage;

/* loaded from: /tmp/classes2.dex */
public final class ey extends ay {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public ey(char c, char c2, int i) {
        this.a = i;
        this.b = c2;
        boolean z = false;
        if (i <= 0 ? dq1.b(c, c2) >= 0 : dq1.b(c, c2) <= 0) {
            z = true;
        }
        this.c = z;
        this.d = z ? c : c2;
    }

    @Override // defpackage.ay
    public char d() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                zm.a();
                return (char) 0;
            }
            this.c = false;
        }
        return (char) i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }
}
