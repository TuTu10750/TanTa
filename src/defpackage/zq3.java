package defpackage;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class zq3 extends AbstractSet {
    public static final b c = new b(null);
    public Object a;
    public int b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements Iterator, bw1 {
        public final Iterator a;

        public a(Object[] objArr) {
            objArr.getClass();
            this.a = db.a(objArr);
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return this.a.next();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final zq3 a() {
            return new zq3(null);
        }

        public final zq3 b(Collection collection) {
            collection.getClass();
            zq3 zq3Var = new zq3(null);
            zq3Var.addAll(collection);
            return zq3Var;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c implements Iterator, bw1 {
        public final Object a;
        public boolean b = true;

        public c(Object obj) {
            this.a = obj;
        }

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.b) {
                this.b = false;
                return this.a;
            }
            zm.a();
            return null;
        }
    }

    public zq3() {
    }

    public /* synthetic */ zq3(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final zq3 g() {
        return c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [java.util.AbstractCollection, java.util.LinkedHashSet] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        Object[] objArr;
        if (size() == 0) {
            this.a = obj;
        } else if (size() != 1) {
            int size = size();
            Object obj2 = this.a;
            if (size < 5) {
                obj2.getClass();
                Object[] objArr2 = (Object[]) obj2;
                if (rb.B(objArr2, obj)) {
                    return false;
                }
                if (size() == 4) {
                    ?? f = eo3.f(Arrays.copyOf(objArr2, objArr2.length));
                    f.add(obj);
                    objArr = f;
                } else {
                    Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                    copyOf[copyOf.length - 1] = obj;
                    objArr = copyOf;
                }
                this.a = objArr;
            } else {
                obj2.getClass();
                if (!ka4.d(obj2).add(obj)) {
                    return false;
                }
            }
        } else {
            if (dq1.a(this.a, obj)) {
                return false;
            }
            this.a = new Object[]{this.a, obj};
        }
        i(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.a = null;
        i(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return dq1.a(this.a, obj);
        }
        int size = size();
        Object obj2 = this.a;
        if (size < 5) {
            obj2.getClass();
            return rb.B((Object[]) obj2, obj);
        }
        obj2.getClass();
        return ((Set) obj2).contains(obj);
    }

    public int h() {
        return this.b;
    }

    public void i(int i) {
        this.b = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        if (size() == 0) {
            return Collections.EMPTY_SET.iterator();
        }
        if (size() == 1) {
            return new c(this.a);
        }
        int size = size();
        Object obj = this.a;
        if (size < 5) {
            obj.getClass();
            return new a((Object[]) obj);
        }
        obj.getClass();
        return ka4.d(obj).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return h();
    }
}
