package defpackage;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: /tmp/classes2.dex */
public class pp2 {
    public SparseBooleanArray a = new SparseBooleanArray();
    public SparseArray b = new SparseArray();
    public int c;
    public int d;
    public int e;
    public float f;
    public int g;
    public boolean h;
    public a i;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void d(int i, int i2);

        void e(int i, int i2, float f, boolean z);

        void f(int i, int i2);

        void g(int i, int i2, float f, boolean z);
    }

    public final void a(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.d(i, this.c);
        }
        this.a.put(i, true);
    }

    public final void b(int i, float f, boolean z, boolean z2) {
        if (this.h || i == this.d || this.g == 1 || z2) {
            a aVar = this.i;
            if (aVar != null) {
                aVar.e(i, this.c, f, z);
            }
            this.b.put(i, Float.valueOf(1.0f - f));
        }
    }

    public final void c(int i, float f, boolean z, boolean z2) {
        if (!this.h && i != this.e && this.g != 1) {
            int i2 = this.d;
            if (((i != i2 - 1 && i != i2 + 1) || ((Float) this.b.get(i, Float.valueOf(0.0f))).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        a aVar = this.i;
        if (aVar != null) {
            aVar.g(i, this.c, f, z);
        }
        this.b.put(i, Float.valueOf(f));
    }

    public final void d(int i) {
        a aVar = this.i;
        if (aVar != null) {
            aVar.f(i, this.c);
        }
        this.a.put(i, false);
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.g;
    }

    public int g() {
        return this.c;
    }

    public void h(int i) {
        this.g = i;
    }

    public void i(int i, float f, int i2) {
        int i3;
        boolean z;
        Float valueOf = Float.valueOf(0.0f);
        float f2 = i + f;
        float f3 = this.f;
        boolean z2 = f3 <= f2;
        if (this.g == 0) {
            int i4 = 0;
            while (true) {
                int i5 = this.c;
                i3 = this.d;
                if (i4 >= i5) {
                    break;
                }
                if (i4 != i3) {
                    if (!this.a.get(i4)) {
                        a(i4);
                    }
                    if (((Float) this.b.get(i4, valueOf)).floatValue() != 1.0f) {
                        c(i4, 1.0f, false, true);
                    }
                }
                i4++;
            }
            b(i3, 1.0f, false, true);
            d(this.d);
        } else {
            if (f2 == f3) {
                return;
            }
            int i6 = i + 1;
            if (f == 0.0f && z2) {
                i6 = i - 1;
                z = false;
            } else {
                z = true;
            }
            for (int i7 = 0; i7 < this.c; i7++) {
                if (i7 != i && i7 != i6 && ((Float) this.b.get(i7, valueOf)).floatValue() != 1.0f) {
                    c(i7, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f4 = 1.0f - f;
                c(i6, f4, true, false);
                b(i, f4, true, false);
            } else if (z2) {
                c(i, f, true, false);
                b(i6, f, true, false);
            } else {
                float f5 = 1.0f - f;
                c(i6, f5, false, false);
                b(i, f5, false, false);
            }
        }
        this.f = f2;
    }

    public void j(int i) {
        this.e = this.d;
        this.d = i;
        d(i);
        for (int i2 = 0; i2 < this.c; i2++) {
            if (i2 != this.d && !this.a.get(i2)) {
                a(i2);
            }
        }
    }

    public void k(a aVar) {
        this.i = aVar;
    }

    public void l(boolean z) {
        this.h = z;
    }

    public void m(int i) {
        this.c = i;
        this.a.clear();
        this.b.clear();
    }
}
