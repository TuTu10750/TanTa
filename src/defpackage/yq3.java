package defpackage;

import com.umeng.analytics.pro.bv;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: /tmp/classes2.dex */
public class yq3 extends AbstractList implements RandomAccess {
    public int a;
    public Object b;

    /* loaded from: /tmp/classes2.dex */
    public static class b implements Iterator {
        public static final b a = new b();

        public static b a() {
            return a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends d {
        public final int b;

        public c() {
            super();
            this.b = ((AbstractList) yq3.this).modCount;
        }

        @Override // yq3.d
        public void a() {
            if (((AbstractList) yq3.this).modCount == this.b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) yq3.this).modCount + "; expected: " + this.b);
        }

        @Override // yq3.d
        public Object c() {
            return yq3.this.b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            yq3.this.clear();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class d implements Iterator {
        public boolean a;

        public d() {
        }

        public abstract void a();

        public abstract Object c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.a;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.a) {
                zm.a();
                return null;
            }
            this.a = true;
            a();
            return c();
        }
    }

    public static /* synthetic */ void g(int i) {
        String str = (i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 2 || i == 3 || i == 5 || i == 6 || i == 7) ? 2 : 3];
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = bv.av;
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i == 2 || i == 3) {
            objArr[1] = "iterator";
        } else if (i == 5 || i == 6 || i == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 2 && i != 3 && i != 5 && i != 6 && i != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, Object obj) {
        int i2;
        if (i < 0 || i > (i2 = this.a)) {
            n82.a("Index: ", i, ", Size: ", this.a);
            return;
        }
        if (i2 == 0) {
            this.b = obj;
        } else if (i2 == 1 && i == 0) {
            this.b = new Object[]{obj, this.b};
        } else {
            Object[] objArr = new Object[i2 + 1];
            Object obj2 = this.b;
            if (i2 == 1) {
                objArr[0] = obj2;
            } else {
                Object[] objArr2 = (Object[]) obj2;
                System.arraycopy(objArr2, 0, objArr, 0, i);
                System.arraycopy(objArr2, i, objArr, i + 1, this.a - i);
            }
            objArr[i] = obj;
            this.b = objArr;
        }
        this.a++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        int i = this.a;
        if (i == 0) {
            this.b = obj;
        } else {
            Object obj2 = this.b;
            if (i == 1) {
                this.b = new Object[]{obj2, obj};
            } else {
                Object[] objArr = (Object[]) obj2;
                int length = objArr.length;
                if (i >= length) {
                    int i2 = ((length * 3) / 2) + 1;
                    int i3 = i + 1;
                    if (i2 < i3) {
                        i2 = i3;
                    }
                    Object[] objArr2 = new Object[i2];
                    this.b = objArr2;
                    System.arraycopy(objArr, 0, objArr2, 0, length);
                    objArr = objArr2;
                }
                objArr[this.a] = obj;
            }
        }
        this.a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.b = null;
        this.a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            n82.a("Index: ", i, ", Size: ", this.a);
            return null;
        }
        Object obj = this.b;
        return i2 == 1 ? obj : ((Object[]) obj)[i];
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        int i = this.a;
        if (i == 0) {
            b a2 = b.a();
            if (a2 == null) {
                g(2);
            }
            return a2;
        }
        if (i == 1) {
            return new c();
        }
        Iterator it = super.iterator();
        if (it == null) {
            g(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object remove(int i) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            n82.a("Index: ", i, ", Size: ", this.a);
            return null;
        }
        Object obj = this.b;
        if (i2 == 1) {
            this.b = null;
        } else {
            Object[] objArr = (Object[]) obj;
            Object obj2 = objArr[i];
            if (i2 == 2) {
                this.b = objArr[1 - i];
            } else {
                int i3 = (i2 - i) - 1;
                if (i3 > 0) {
                    System.arraycopy(objArr, i + 1, objArr, i, i3);
                }
                objArr[this.a - 1] = null;
            }
            obj = obj2;
        }
        this.a--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int i, Object obj) {
        int i2;
        if (i < 0 || i >= (i2 = this.a)) {
            n82.a("Index: ", i, ", Size: ", this.a);
            return null;
        }
        Object obj2 = this.b;
        if (i2 == 1) {
            this.b = obj;
            return obj2;
        }
        Object[] objArr = (Object[]) obj2;
        Object obj3 = objArr[i];
        objArr[i] = obj;
        return obj3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.a;
    }

    @Override // java.util.List
    public void sort(Comparator comparator) {
        int i = this.a;
        if (i >= 2) {
            Arrays.sort((Object[]) this.b, 0, i, comparator);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray(Object[] objArr) {
        if (objArr == null) {
            g(4);
        }
        int length = objArr.length;
        int i = this.a;
        if (i == 1) {
            if (length == 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), 1);
                objArr2[0] = this.b;
                return objArr2;
            }
            objArr[0] = this.b;
        } else {
            if (length < i) {
                Object[] copyOf = Arrays.copyOf((Object[]) this.b, i, objArr.getClass());
                if (copyOf == null) {
                    g(6);
                }
                return copyOf;
            }
            if (i != 0) {
                System.arraycopy(this.b, 0, objArr, 0, i);
            }
        }
        int i2 = this.a;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }
}
