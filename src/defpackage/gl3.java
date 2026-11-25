package defpackage;

import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class gl3 {
    public static final a h = new a(null);
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public boolean e;
    public gl3 f;
    public gl3 g;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public gl3() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public gl3(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        bArr.getClass();
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = z;
        this.e = z2;
    }

    public final void a() {
        int i;
        gl3 gl3Var = this.g;
        if (gl3Var == this) {
            fl3.a("cannot compact");
            return;
        }
        gl3Var.getClass();
        if (gl3Var.e) {
            int i2 = this.c - this.b;
            gl3 gl3Var2 = this.g;
            gl3Var2.getClass();
            int i3 = 8192 - gl3Var2.c;
            gl3 gl3Var3 = this.g;
            gl3Var3.getClass();
            if (gl3Var3.d) {
                i = 0;
            } else {
                gl3 gl3Var4 = this.g;
                gl3Var4.getClass();
                i = gl3Var4.b;
            }
            if (i2 > i3 + i) {
                return;
            }
            gl3 gl3Var5 = this.g;
            gl3Var5.getClass();
            g(gl3Var5, i2);
            b();
            kl3.b(this);
        }
    }

    public final gl3 b() {
        gl3 gl3Var = this.f;
        if (gl3Var == this) {
            gl3Var = null;
        }
        gl3 gl3Var2 = this.g;
        gl3Var2.getClass();
        gl3Var2.f = this.f;
        gl3 gl3Var3 = this.f;
        gl3Var3.getClass();
        gl3Var3.g = this.g;
        this.f = null;
        this.g = null;
        return gl3Var;
    }

    public final gl3 c(gl3 gl3Var) {
        gl3Var.getClass();
        gl3Var.g = this;
        gl3Var.f = this.f;
        gl3 gl3Var2 = this.f;
        gl3Var2.getClass();
        gl3Var2.g = gl3Var;
        this.f = gl3Var;
        return gl3Var;
    }

    public final gl3 d() {
        this.d = true;
        return new gl3(this.a, this.b, this.c, true, false);
    }

    public final gl3 e(int i) {
        gl3 c;
        if (i <= 0 || i > this.c - this.b) {
            ik.a("byteCount out of range");
            return null;
        }
        if (i >= 1024) {
            c = d();
        } else {
            c = kl3.c();
            byte[] bArr = this.a;
            byte[] bArr2 = c.a;
            int i2 = this.b;
            pb.j(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        c.c = c.b + i;
        this.b += i;
        gl3 gl3Var = this.g;
        gl3Var.getClass();
        gl3Var.c(c);
        return c;
    }

    public final gl3 f() {
        byte[] bArr = this.a;
        return new gl3(Arrays.copyOf(bArr, bArr.length), this.b, this.c, false, true);
    }

    public final void g(gl3 gl3Var, int i) {
        gl3Var.getClass();
        if (!gl3Var.e) {
            fl3.a("only owner can write");
            return;
        }
        int i2 = gl3Var.c;
        if (i2 + i > 8192) {
            if (gl3Var.d) {
                el3.a();
                return;
            }
            int i3 = gl3Var.b;
            if ((i2 + i) - i3 > 8192) {
                el3.a();
                return;
            }
            byte[] bArr = gl3Var.a;
            pb.j(bArr, bArr, 0, i3, i2, 2, null);
            gl3Var.c -= gl3Var.b;
            gl3Var.b = 0;
        }
        byte[] bArr2 = this.a;
        byte[] bArr3 = gl3Var.a;
        int i4 = gl3Var.c;
        int i5 = this.b;
        pb.f(bArr2, bArr3, i4, i5, i5 + i);
        gl3Var.c += i;
        this.b += i;
    }
}
