package defpackage;

import com.zzhoujay.richtext.ImageHolder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class p1 extends j1 implements List, bw1 {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i <= i2) {
                    return;
                }
                lc1.a("startIndex: ", i, " > endIndex: ", i2);
            } else {
                throw new IndexOutOfBoundsException("startIndex: " + i + ", endIndex: " + i2 + ", size: " + i3);
            }
        }

        public final void b(int i, int i2) {
            if (i < 0 || i >= i2) {
                kt0.a("index: ", i, ", size: ", i2);
            }
        }

        public final void c(int i, int i2) {
            if (i < 0 || i > i2) {
                kt0.a("index: ", i, ", size: ", i2);
            }
        }

        public final void d(int i, int i2, int i3) {
            if (i >= 0 && i2 <= i3) {
                if (i <= i2) {
                    return;
                }
                lc1.a("fromIndex: ", i, " > toIndex: ", i2);
            } else {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
        }

        public final int e(int i, int i2) {
            int i3 = i + (i >> 1);
            if (i3 - i2 < 0) {
                i3 = i2;
            }
            if (i3 - 2147483639 <= 0) {
                return i3;
            }
            if (i2 > 2147483639) {
                return ImageHolder.MATCH_PARENT;
            }
            return 2147483639;
        }

        public final boolean f(Collection collection, Collection collection2) {
            collection.getClass();
            collection2.getClass();
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!dq1.a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(Collection collection) {
            collection.getClass();
            Iterator it = collection.iterator();
            int i = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i = (i * 31) + (next != null ? next.hashCode() : 0);
            }
            return i;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Iterator, bw1 {
        public int a;

        public b() {
        }

        public final int d() {
            return this.a;
        }

        public final void e(int i) {
            this.a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a < p1.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                zm.a();
                return null;
            }
            p1 p1Var = p1.this;
            int i = this.a;
            this.a = i + 1;
            return p1Var.get(i);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends b implements ListIterator, bw1 {
        public c(int i) {
            super();
            p1.a.c(i, p1.this.size());
            e(i);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return d() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return d();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                zm.a();
                return null;
            }
            p1 p1Var = p1.this;
            e(d() - 1);
            return p1Var.get(d());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return d() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class d extends p1 implements RandomAccess {
        public final p1 b;
        public final int c;
        public int d;

        public d(p1 p1Var, int i, int i2) {
            p1Var.getClass();
            this.b = p1Var;
            this.c = i;
            p1.a.d(i, i2, p1Var.size());
            this.d = i2 - i;
        }

        @Override // defpackage.p1, java.util.List
        public Object get(int i) {
            p1.a.b(i, this.d);
            return this.b.get(this.c + i);
        }

        @Override // defpackage.j1
        public int h() {
            return this.d;
        }

        @Override // defpackage.p1, java.util.List
        public List subList(int i, int i2) {
            p1.a.d(i, i2, this.d);
            p1 p1Var = this.b;
            int i3 = this.c;
            return new d(p1Var, i + i3, i3 + i2);
        }
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return a.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return a.g(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (dq1.a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (dq1.a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new c(i);
    }

    @Override // java.util.List
    public Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new d(this, i, i2);
    }
}
