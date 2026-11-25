package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: /tmp/classes2.dex */
public final class oh3 extends t1 {
    public final List a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements ListIterator, bw1 {
        public final ListIterator a;

        public a(int i) {
            int O;
            List list = oh3.this.a;
            O = y20.O(oh3.this, i);
            this.a = list.listIterator(O);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.a.add(obj);
            this.a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            return this.a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            int N;
            N = y20.N(oh3.this, this.a.previousIndex());
            return N;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return this.a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            int N;
            N = y20.N(oh3.this, this.a.nextIndex());
            return N;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.a.remove();
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.a.set(obj);
        }
    }

    public oh3(List list) {
        list.getClass();
        this.a = list;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int O;
        List list = this.a;
        O = y20.O(this, i);
        list.add(O, obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.a.clear();
    }

    @Override // defpackage.t1
    /* renamed from: g */
    public int getLength() {
        return this.a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        int M;
        List list = this.a;
        M = y20.M(this, i);
        return list.get(M);
    }

    @Override // defpackage.t1
    public Object h(int i) {
        int M;
        List list = this.a;
        M = y20.M(this, i);
        return list.remove(M);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i) {
        return new a(i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int M;
        List list = this.a;
        M = y20.M(this, i);
        return list.set(M, obj);
    }
}
