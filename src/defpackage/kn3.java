package defpackage;

import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class kn3 extends fn3 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements bn3 {
        public final /* synthetic */ Iterator a;

        public a(Iterator it) {
            this.a = it;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return this.a;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements bn3 {
        public final /* synthetic */ Object a;

        public b(Object obj) {
            this.a = obj;
        }

        @Override // defpackage.bn3
        public Iterator iterator() {
            return new c(this.a);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c implements Iterator, bw1 {
        public boolean a = true;
        public final /* synthetic */ Object b;

        public c(Object obj) {
            this.b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (this.a) {
                this.a = false;
                return this.b;
            }
            zm.a();
            return null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static bn3 g(Iterator it) {
        it.getClass();
        return h(new a(it));
    }

    public static final bn3 h(bn3 bn3Var) {
        bn3Var.getClass();
        return bn3Var instanceof m50 ? bn3Var : new m50(bn3Var);
    }

    public static bn3 i() {
        return pt0.a;
    }

    public static bn3 j(bn3 bn3Var) {
        bn3Var.getClass();
        return k(bn3Var, new n81() { // from class: in3
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                Iterator l;
                l = kn3.l((bn3) obj);
                return l;
            }
        });
    }

    public static final bn3 k(bn3 bn3Var, n81 n81Var) {
        return bn3Var instanceof u74 ? ((u74) bn3Var).d(n81Var) : new g31(bn3Var, new n81() { // from class: jn3
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                Object m;
                m = kn3.m(obj);
                return m;
            }
        }, n81Var);
    }

    public static final Iterator l(bn3 bn3Var) {
        bn3Var.getClass();
        return bn3Var.iterator();
    }

    public static final Object m(Object obj) {
        return obj;
    }

    public static bn3 n(final l81 l81Var) {
        l81Var.getClass();
        return h(new kb1(l81Var, new n81() { // from class: hn3
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                Object p;
                p = kn3.p(l81.this, obj);
                return p;
            }
        }));
    }

    public static bn3 o(final Object obj, n81 n81Var) {
        n81Var.getClass();
        return obj == null ? pt0.a : new kb1(new l81() { // from class: gn3
            @Override // defpackage.l81
            public final Object invoke() {
                Object q;
                q = kn3.q(obj);
                return q;
            }
        }, n81Var);
    }

    public static final Object p(l81 l81Var, Object obj) {
        obj.getClass();
        return l81Var.invoke();
    }

    public static final Object q(Object obj) {
        return obj;
    }

    public static final bn3 r(Object obj) {
        return new b(obj);
    }

    public static final bn3 s(Object... objArr) {
        objArr.getClass();
        return rb.x(objArr);
    }
}
