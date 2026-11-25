package defpackage;

import com.zzhoujay.richtext.ImageHolder;
import defpackage.tm;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: /tmp/classes2.dex */
public class fi3 extends tm {
    public static final int[] h;
    public final int b;
    public final tm c;
    public final tm d;
    public final int e;
    public final int f;
    public int g;

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        public final Stack a;

        public b() {
            this.a = new Stack();
        }

        public final tm b(tm tmVar, tm tmVar2) {
            c(tmVar);
            c(tmVar2);
            tm tmVar3 = (tm) this.a.pop();
            while (!this.a.isEmpty()) {
                tmVar3 = new fi3((tm) this.a.pop(), tmVar3);
            }
            return tmVar3;
        }

        public final void c(tm tmVar) {
            if (tmVar.p()) {
                e(tmVar);
                return;
            }
            if (tmVar instanceof fi3) {
                fi3 fi3Var = (fi3) tmVar;
                c(fi3Var.c);
                c(fi3Var.d);
            } else {
                String valueOf = String.valueOf(tmVar.getClass());
                StringBuilder sb = new StringBuilder(valueOf.length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }

        public final int d(int i) {
            int binarySearch = Arrays.binarySearch(fi3.h, i);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        public final void e(tm tmVar) {
            int d = d(tmVar.size());
            int i = fi3.h[d + 1];
            if (this.a.isEmpty() || ((tm) this.a.peek()).size() >= i) {
                this.a.push(tmVar);
                return;
            }
            int i2 = fi3.h[d];
            tm tmVar2 = (tm) this.a.pop();
            while (true) {
                if (this.a.isEmpty() || ((tm) this.a.peek()).size() >= i2) {
                    break;
                } else {
                    tmVar2 = new fi3((tm) this.a.pop(), tmVar2);
                }
            }
            fi3 fi3Var = new fi3(tmVar2, tmVar);
            while (!this.a.isEmpty()) {
                if (((tm) this.a.peek()).size() >= fi3.h[d(fi3Var.size()) + 1]) {
                    break;
                } else {
                    fi3Var = new fi3((tm) this.a.pop(), fi3Var);
                }
            }
            this.a.push(fi3Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c implements Iterator {
        public final Stack a;
        public f02 b;

        public c(tm tmVar) {
            this.a = new Stack();
            this.b = a(tmVar);
        }

        public final f02 a(tm tmVar) {
            while (tmVar instanceof fi3) {
                fi3 fi3Var = (fi3) tmVar;
                this.a.push(fi3Var);
                tmVar = fi3Var.c;
            }
            return (f02) tmVar;
        }

        public final f02 c() {
            while (!this.a.isEmpty()) {
                f02 a = a(((fi3) this.a.pop()).d);
                if (!a.isEmpty()) {
                    return a;
                }
            }
            return null;
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public f02 next() {
            f02 f02Var = this.b;
            if (f02Var != null) {
                this.b = c();
                return f02Var;
            }
            zm.a();
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements tm.a {
        public final c a;
        public tm.a b;
        public int c;

        public d() {
            c cVar = new c(fi3.this);
            this.a = cVar;
            this.b = cVar.next().iterator();
            this.c = fi3.this.size();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte next() {
            return Byte.valueOf(b());
        }

        @Override // tm.a
        public byte b() {
            if (!this.b.hasNext()) {
                this.b = this.a.next().iterator();
            }
            this.c--;
            return this.b.b();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.c > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ImageHolder.MATCH_PARENT));
        h = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = h;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public fi3(tm tmVar, tm tmVar2) {
        this.g = 0;
        this.c = tmVar;
        this.d = tmVar2;
        int size = tmVar.size();
        this.e = size;
        this.b = size + tmVar2.size();
        this.f = Math.max(tmVar.o(), tmVar2.o()) + 1;
    }

    public static tm D(tm tmVar, tm tmVar2) {
        fi3 fi3Var = tmVar instanceof fi3 ? (fi3) tmVar : null;
        if (tmVar2.size() == 0) {
            return tmVar;
        }
        if (tmVar.size() == 0) {
            return tmVar2;
        }
        int size = tmVar.size() + tmVar2.size();
        if (size < 128) {
            return E(tmVar, tmVar2);
        }
        if (fi3Var != null && fi3Var.d.size() + tmVar2.size() < 128) {
            return new fi3(fi3Var.c, E(fi3Var.d, tmVar2));
        }
        if (fi3Var == null || fi3Var.c.o() <= fi3Var.d.o() || fi3Var.o() <= tmVar2.o()) {
            return size >= h[Math.max(tmVar.o(), tmVar2.o()) + 1] ? new fi3(tmVar, tmVar2) : new b().b(tmVar, tmVar2);
        }
        return new fi3(fi3Var.c, new fi3(fi3Var.d, tmVar2));
    }

    public static f02 E(tm tmVar, tm tmVar2) {
        int size = tmVar.size();
        int size2 = tmVar2.size();
        byte[] bArr = new byte[size + size2];
        tmVar.m(bArr, 0, 0, size);
        tmVar2.m(bArr, 0, size, size2);
        return new f02(bArr);
    }

    public final boolean F(tm tmVar) {
        c cVar = new c(this);
        f02 f02Var = (f02) cVar.next();
        c cVar2 = new c(tmVar);
        f02 f02Var2 = (f02) cVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = f02Var.size() - i;
            int size2 = f02Var2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? f02Var.A(f02Var2, i2, min) : f02Var2.A(f02Var, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.b;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                pr4.a();
                return false;
            }
            if (min == size) {
                f02Var = (f02) cVar.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == size2) {
                f02Var2 = (f02) cVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public tm.a iterator() {
        return new d();
    }

    public boolean equals(Object obj) {
        int u;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tm)) {
            return false;
        }
        tm tmVar = (tm) obj;
        if (this.b != tmVar.size()) {
            return false;
        }
        if (this.b == 0) {
            return true;
        }
        if (this.g == 0 || (u = tmVar.u()) == 0 || this.g == u) {
            return F(tmVar);
        }
        return false;
    }

    public int hashCode() {
        int i = this.g;
        if (i == 0) {
            int i2 = this.b;
            i = s(i2, 0, i2);
            if (i == 0) {
                i = 1;
            }
            this.g = i;
        }
        return i;
    }

    @Override // defpackage.tm
    public void n(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            this.c.n(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.d.n(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.c.n(bArr, i, i2, i6);
            this.d.n(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // defpackage.tm
    public int o() {
        return this.f;
    }

    @Override // defpackage.tm
    public boolean p() {
        return this.b >= h[this.f];
    }

    @Override // defpackage.tm
    public boolean q() {
        int t = this.c.t(0, 0, this.e);
        tm tmVar = this.d;
        return tmVar.t(t, 0, tmVar.size()) == 0;
    }

    @Override // defpackage.tm
    public int s(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            return this.c.s(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.d.s(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.d.s(this.c.s(i, i2, i6), 0, i3 - i6);
    }

    @Override // defpackage.tm
    public int size() {
        return this.b;
    }

    @Override // defpackage.tm
    public int t(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.e;
        if (i4 <= i5) {
            return this.c.t(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.d.t(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.d.t(this.c.t(i, i2, i6), 0, i3 - i6);
    }

    @Override // defpackage.tm
    public int u() {
        return this.g;
    }

    @Override // defpackage.tm
    public String w(String str) {
        return new String(v(), str);
    }

    @Override // defpackage.tm
    public void z(OutputStream outputStream, int i, int i2) {
        int i3 = i + i2;
        int i4 = this.e;
        if (i3 <= i4) {
            this.c.z(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.d.z(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.c.z(outputStream, i, i5);
            this.d.z(outputStream, 0, i2 - i5);
        }
    }
}
