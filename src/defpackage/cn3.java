package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.b;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class cn3 extends dn3 implements Iterator, u60, bw1 {
    public int a;
    public Object b;
    public Iterator c;
    public u60 d;

    public Object f(Object obj, u60 u60Var) {
        this.b = obj;
        this.a = 3;
        this.d = u60Var;
        Object e = eq1.e();
        if (e == eq1.e()) {
            ma0.c(u60Var);
        }
        return e == eq1.e() ? e : qc4.a;
    }

    @Override // defpackage.u60
    public d getContext() {
        return EmptyCoroutineContext.a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i = this.a;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw l();
                }
                Iterator it = this.c;
                it.getClass();
                if (it.hasNext()) {
                    this.a = 2;
                    return true;
                }
                this.c = null;
            }
            this.a = 5;
            u60 u60Var = this.d;
            u60Var.getClass();
            this.d = null;
            u60Var.resumeWith(Result.b(qc4.a));
        }
    }

    public Object k(Iterator it, u60 u60Var) {
        if (!it.hasNext()) {
            return qc4.a;
        }
        this.c = it;
        this.a = 2;
        this.d = u60Var;
        Object e = eq1.e();
        if (e == eq1.e()) {
            ma0.c(u60Var);
        }
        return e == eq1.e() ? e : qc4.a;
    }

    public final Throwable l() {
        int i = this.a;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.a);
    }

    public final Object m() {
        if (hasNext()) {
            return next();
        }
        zm.a();
        return null;
    }

    public final void n(u60 u60Var) {
        this.d = u60Var;
    }

    @Override // java.util.Iterator
    public Object next() {
        int i = this.a;
        if (i == 0 || i == 1) {
            return m();
        }
        if (i == 2) {
            this.a = 1;
            Iterator it = this.c;
            it.getClass();
            return it.next();
        }
        if (i != 3) {
            throw l();
        }
        this.a = 0;
        Object obj = this.b;
        this.b = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // defpackage.u60
    public void resumeWith(Object obj) {
        b.b(obj);
        this.a = 4;
    }
}
