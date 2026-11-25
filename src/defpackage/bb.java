package defpackage;

import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class bb extends t1 {
    public static final a d = new a(null);
    public static final Object[] e = new Object[0];
    public int a;
    public Object[] b = e;
    public int c;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void l(int i) {
        if (i < 0) {
            fl3.a("Deque is too big.");
            return;
        }
        Object[] objArr = this.b;
        if (i <= objArr.length) {
            return;
        }
        if (objArr == e) {
            this.b = new Object[fb3.c(i, 10)];
        } else {
            j(p1.a.e(objArr.length, i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        p1.a.c(i, size());
        if (i == size()) {
            addLast(obj);
            return;
        }
        if (i == 0) {
            addFirst(obj);
            return;
        }
        q();
        l(size() + 1);
        int p = p(this.a + i);
        if (i < ((size() + 1) >> 1)) {
            int k = k(p);
            int k2 = k(this.a);
            int i2 = this.a;
            Object[] objArr = this.b;
            if (k >= i2) {
                objArr[k2] = objArr[i2];
                pb.i(objArr, objArr, i2, i2 + 1, k + 1);
            } else {
                pb.i(objArr, objArr, i2 - 1, i2, objArr.length);
                Object[] objArr2 = this.b;
                objArr2[objArr2.length - 1] = objArr2[0];
                pb.i(objArr2, objArr2, 0, 1, k + 1);
            }
            this.b[k] = obj;
            this.a = k2;
        } else {
            int p2 = p(this.a + size());
            Object[] objArr3 = this.b;
            if (p < p2) {
                pb.i(objArr3, objArr3, p + 1, p, p2);
            } else {
                pb.i(objArr3, objArr3, 1, 0, p2);
                Object[] objArr4 = this.b;
                objArr4[0] = objArr4[objArr4.length - 1];
                pb.i(objArr4, objArr4, p + 1, p, objArr4.length - 1);
            }
            this.b[p] = obj;
        }
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection collection) {
        collection.getClass();
        p1.a.c(i, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i == size()) {
            return addAll(collection);
        }
        q();
        l(size() + collection.size());
        int p = p(this.a + size());
        int p2 = p(this.a + i);
        int size = collection.size();
        if (i < ((size() + 1) >> 1)) {
            int i2 = this.a;
            int i3 = i2 - size;
            if (p2 >= i2) {
                Object[] objArr = this.b;
                if (i3 >= 0) {
                    pb.i(objArr, objArr, i3, i2, p2);
                } else {
                    i3 += objArr.length;
                    int i4 = p2 - i2;
                    int length = objArr.length - i3;
                    if (length >= i4) {
                        pb.i(objArr, objArr, i3, i2, p2);
                    } else {
                        pb.i(objArr, objArr, i3, i2, i2 + length);
                        Object[] objArr2 = this.b;
                        pb.i(objArr2, objArr2, 0, this.a + length, p2);
                    }
                }
            } else {
                Object[] objArr3 = this.b;
                pb.i(objArr3, objArr3, i3, i2, objArr3.length);
                Object[] objArr4 = this.b;
                if (size >= p2) {
                    pb.i(objArr4, objArr4, objArr4.length - size, 0, p2);
                } else {
                    pb.i(objArr4, objArr4, objArr4.length - size, 0, size);
                    Object[] objArr5 = this.b;
                    pb.i(objArr5, objArr5, 0, size, p2);
                }
            }
            this.a = i3;
            i(n(p2 - size), collection);
        } else {
            int i5 = p2 + size;
            Object[] objArr6 = this.b;
            if (p2 < p) {
                int i6 = size + p;
                if (i6 <= objArr6.length) {
                    pb.i(objArr6, objArr6, i5, p2, p);
                } else if (i5 >= objArr6.length) {
                    pb.i(objArr6, objArr6, i5 - objArr6.length, p2, p);
                } else {
                    int length2 = p - (i6 - objArr6.length);
                    pb.i(objArr6, objArr6, 0, length2, p);
                    Object[] objArr7 = this.b;
                    pb.i(objArr7, objArr7, i5, p2, length2);
                }
            } else {
                pb.i(objArr6, objArr6, size, 0, p);
                Object[] objArr8 = this.b;
                if (i5 >= objArr8.length) {
                    pb.i(objArr8, objArr8, i5 - objArr8.length, p2, objArr8.length);
                } else {
                    pb.i(objArr8, objArr8, 0, objArr8.length - size, objArr8.length);
                    Object[] objArr9 = this.b;
                    pb.i(objArr9, objArr9, i5, p2, objArr9.length - size);
                }
            }
            i(p2, collection);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        collection.getClass();
        if (collection.isEmpty()) {
            return false;
        }
        q();
        l(size() + collection.size());
        i(p(this.a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        q();
        l(size() + 1);
        int k = k(this.a);
        this.a = k;
        this.b[k] = obj;
        this.c = size() + 1;
    }

    public final void addLast(Object obj) {
        q();
        l(size() + 1);
        this.b[p(this.a + size())] = obj;
        this.c = size() + 1;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!isEmpty()) {
            q();
            o(this.a, p(this.a + size()));
        }
        this.a = 0;
        this.c = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // defpackage.t1
    /* renamed from: g */
    public int getLength() {
        return this.c;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        p1.a.b(i, size());
        return this.b[p(this.a + i)];
    }

    @Override // defpackage.t1
    public Object h(int i) {
        p1.a.b(i, size());
        if (i == s20.m(this)) {
            return removeLast();
        }
        if (i == 0) {
            return removeFirst();
        }
        q();
        int p = p(this.a + i);
        Object obj = this.b[p];
        int size = size() >> 1;
        int i2 = this.a;
        if (i < size) {
            Object[] objArr = this.b;
            if (p >= i2) {
                pb.i(objArr, objArr, i2 + 1, i2, p);
            } else {
                pb.i(objArr, objArr, 1, 0, p);
                Object[] objArr2 = this.b;
                objArr2[0] = objArr2[objArr2.length - 1];
                int i3 = this.a;
                pb.i(objArr2, objArr2, i3 + 1, i3, objArr2.length - 1);
            }
            Object[] objArr3 = this.b;
            int i4 = this.a;
            objArr3[i4] = null;
            this.a = m(i4);
        } else {
            int p2 = p(i2 + s20.m(this));
            Object[] objArr4 = this.b;
            if (p <= p2) {
                pb.i(objArr4, objArr4, p, p + 1, p2 + 1);
            } else {
                pb.i(objArr4, objArr4, p, p + 1, objArr4.length);
                Object[] objArr5 = this.b;
                objArr5[objArr5.length - 1] = objArr5[0];
                pb.i(objArr5, objArr5, 0, 1, p2 + 1);
            }
            this.b[p2] = null;
        }
        this.c = size() - 1;
        return obj;
    }

    public final void i(int i, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.b.length;
        while (i < length && it.hasNext()) {
            this.b[i] = it.next();
            i++;
        }
        int i2 = this.a;
        for (int i3 = 0; i3 < i2 && it.hasNext(); i3++) {
            this.b[i3] = it.next();
        }
        this.c = size() + collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        int i;
        int p = p(this.a + size());
        int i2 = this.a;
        if (i2 < p) {
            while (i2 < p) {
                if (dq1.a(obj, this.b[i2])) {
                    i = this.a;
                } else {
                    i2++;
                }
            }
            return -1;
        }
        if (isEmpty() || (i2 = this.a) < p) {
            return -1;
        }
        int length = this.b.length;
        while (true) {
            if (i2 >= length) {
                for (int i3 = 0; i3 < p; i3++) {
                    if (dq1.a(obj, this.b[i3])) {
                        i2 = i3 + this.b.length;
                        i = this.a;
                    }
                }
                return -1;
            }
            if (dq1.a(obj, this.b[i2])) {
                i = this.a;
                break;
            }
            i2++;
        }
        return i2 - i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return size() == 0;
    }

    public final void j(int i) {
        Object[] objArr = new Object[i];
        Object[] objArr2 = this.b;
        pb.i(objArr2, objArr, 0, this.a, objArr2.length);
        Object[] objArr3 = this.b;
        int length = objArr3.length;
        int i2 = this.a;
        pb.i(objArr3, objArr, length - i2, 0, i2);
        this.a = 0;
        this.b = objArr;
    }

    public final int k(int i) {
        return i == 0 ? rb.G(this.b) : i - 1;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        int G;
        int i;
        int p = p(this.a + size());
        int i2 = this.a;
        if (i2 < p) {
            G = p - 1;
            if (i2 <= G) {
                while (!dq1.a(obj, this.b[G])) {
                    if (G != i2) {
                        G--;
                    }
                }
                i = this.a;
                return G - i;
            }
            return -1;
        }
        if (!isEmpty() && this.a >= p) {
            while (true) {
                p--;
                Object[] objArr = this.b;
                if (-1 >= p) {
                    G = rb.G(objArr);
                    int i3 = this.a;
                    if (i3 <= G) {
                        while (!dq1.a(obj, this.b[G])) {
                            if (G != i3) {
                                G--;
                            }
                        }
                        i = this.a;
                    }
                } else if (dq1.a(obj, objArr[p])) {
                    G = p + this.b.length;
                    i = this.a;
                    break;
                }
            }
            return G - i;
        }
        return -1;
    }

    public final int m(int i) {
        if (i == rb.G(this.b)) {
            return 0;
        }
        return i + 1;
    }

    public final int n(int i) {
        return i < 0 ? i + this.b.length : i;
    }

    public final void o(int i, int i2) {
        Object[] objArr = this.b;
        if (i < i2) {
            pb.q(objArr, null, i, i2);
        } else {
            pb.q(objArr, null, i, objArr.length);
            pb.q(this.b, null, 0, i2);
        }
    }

    public final int p(int i) {
        Object[] objArr = this.b;
        return i >= objArr.length ? i - objArr.length : i;
    }

    public final void q() {
        ((AbstractList) this).modCount++;
    }

    public final Object r() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        h(indexOf);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection collection) {
        int p;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int p2 = p(this.a + size());
            int i = this.a;
            if (i < p2) {
                p = i;
                while (true) {
                    objArr = this.b;
                    if (i >= p2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        z = true;
                    } else {
                        this.b[p] = obj;
                        p++;
                    }
                    i++;
                }
                pb.q(objArr, null, p, p2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        z2 = true;
                    } else {
                        this.b[i2] = obj2;
                        i2++;
                    }
                    i++;
                }
                p = p(i2);
                for (int i3 = 0; i3 < p2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        z2 = true;
                    } else {
                        this.b[p] = obj3;
                        p = m(p);
                    }
                }
                z = z2;
            }
            if (z) {
                q();
                this.c = n(p - this.a);
            }
        }
        return z;
    }

    public final Object removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        q();
        Object[] objArr = this.b;
        int i = this.a;
        Object obj = objArr[i];
        objArr[i] = null;
        this.a = m(i);
        this.c = size() - 1;
        return obj;
    }

    public final Object removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("ArrayDeque is empty.");
        }
        q();
        int p = p(this.a + s20.m(this));
        Object[] objArr = this.b;
        Object obj = objArr[p];
        objArr[p] = null;
        this.c = size() - 1;
        return obj;
    }

    @Override // java.util.AbstractList
    public void removeRange(int i, int i2) {
        p1.a.d(i, i2, size());
        int i3 = i2 - i;
        if (i3 == 0) {
            return;
        }
        if (i3 == size()) {
            clear();
            return;
        }
        if (i3 == 1) {
            h(i);
            return;
        }
        q();
        if (i < size() - i2) {
            s(i, i2);
            int p = p(this.a + i3);
            o(this.a, p);
            this.a = p;
        } else {
            t(i, i2);
            int p2 = p(this.a + size());
            o(n(p2 - i3), p2);
        }
        this.c = size() - i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection collection) {
        int p;
        Object[] objArr;
        collection.getClass();
        boolean z = false;
        z = false;
        z = false;
        if (!isEmpty() && this.b.length != 0) {
            int p2 = p(this.a + size());
            int i = this.a;
            if (i < p2) {
                p = i;
                while (true) {
                    objArr = this.b;
                    if (i >= p2) {
                        break;
                    }
                    Object obj = objArr[i];
                    if (collection.contains(obj)) {
                        this.b[p] = obj;
                        p++;
                    } else {
                        z = true;
                    }
                    i++;
                }
                pb.q(objArr, null, p, p2);
            } else {
                int length = this.b.length;
                boolean z2 = false;
                int i2 = i;
                while (i < length) {
                    Object[] objArr2 = this.b;
                    Object obj2 = objArr2[i];
                    objArr2[i] = null;
                    if (collection.contains(obj2)) {
                        this.b[i2] = obj2;
                        i2++;
                    } else {
                        z2 = true;
                    }
                    i++;
                }
                p = p(i2);
                for (int i3 = 0; i3 < p2; i3++) {
                    Object[] objArr3 = this.b;
                    Object obj3 = objArr3[i3];
                    objArr3[i3] = null;
                    if (collection.contains(obj3)) {
                        this.b[p] = obj3;
                        p = m(p);
                    } else {
                        z2 = true;
                    }
                }
                z = z2;
            }
            if (z) {
                q();
                this.c = n(p - this.a);
            }
        }
        return z;
    }

    public final void s(int i, int i2) {
        int p = p(this.a + (i - 1));
        int p2 = p(this.a + (i2 - 1));
        while (i > 0) {
            int i3 = p + 1;
            int min = Math.min(i, Math.min(i3, p2 + 1));
            Object[] objArr = this.b;
            int i4 = p2 - min;
            int i5 = p - min;
            pb.i(objArr, objArr, i4 + 1, i5 + 1, i3);
            p = n(i5);
            p2 = n(i4);
            i -= min;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        p1.a.b(i, size());
        int p = p(this.a + i);
        Object[] objArr = this.b;
        Object obj2 = objArr[p];
        objArr[p] = obj;
        return obj2;
    }

    public final void t(int i, int i2) {
        int p = p(this.a + i2);
        int p2 = p(this.a + i);
        int size = size();
        while (true) {
            size -= i2;
            if (size <= 0) {
                return;
            }
            Object[] objArr = this.b;
            i2 = Math.min(size, Math.min(objArr.length - p, objArr.length - p2));
            Object[] objArr2 = this.b;
            int i3 = p + i2;
            pb.i(objArr2, objArr2, p2, p, i3);
            p = p(i3);
            p2 = p(p2 + i2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        objArr.getClass();
        if (objArr.length < size()) {
            objArr = nb.a(objArr, size());
        }
        Object[] objArr2 = objArr;
        int p = p(this.a + size());
        int i = this.a;
        if (i < p) {
            pb.l(this.b, objArr2, 0, i, p, 2, null);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.b;
            pb.i(objArr3, objArr2, 0, this.a, objArr3.length);
            Object[] objArr4 = this.b;
            pb.i(objArr4, objArr2, objArr4.length - this.a, 0, p);
        }
        return r20.f(size(), objArr2);
    }
}
