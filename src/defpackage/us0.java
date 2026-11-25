package defpackage;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /tmp/classes2.dex */
public abstract class us0 {
    public ConcurrentMap a = new ConcurrentHashMap();

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void call(Object... objArr);
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a {
        public final String a;
        public final a b;

        public b(String str, a aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            us0.this.d(this.a, this);
            this.b.call(objArr);
        }
    }

    public static boolean g(a aVar, a aVar2) {
        if (aVar.equals(aVar2)) {
            return true;
        }
        if (aVar2 instanceof b) {
            return aVar.equals(((b) aVar2).b);
        }
        return false;
    }

    public us0 a(String str, Object... objArr) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                ((a) it.next()).call(objArr);
            }
        }
        return this;
    }

    public us0 b() {
        this.a.clear();
        return this;
    }

    public us0 c(String str) {
        this.a.remove(str);
        return this;
    }

    public us0 d(String str, a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator it = concurrentLinkedQueue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (g(aVar, (a) it.next())) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    public us0 e(String str, a aVar) {
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) this.a.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            ConcurrentLinkedQueue concurrentLinkedQueue2 = (ConcurrentLinkedQueue) this.a.putIfAbsent(str, concurrentLinkedQueue);
            if (concurrentLinkedQueue2 != null) {
                concurrentLinkedQueue = concurrentLinkedQueue2;
            }
        }
        concurrentLinkedQueue.add(aVar);
        return this;
    }

    public us0 f(String str, a aVar) {
        e(str, new b(str, aVar));
        return this;
    }
}
