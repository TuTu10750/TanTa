package defpackage;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import org.greenrobot.eventbus.EventBusException;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class zu0 {
    public static String q = "EventBus";
    public static volatile zu0 r;
    public static final av0 s = new av0();
    public static final Map t = new HashMap();
    public final Map a;
    public final Map b;
    public final Map c;
    public final ThreadLocal d;
    public final ue1 e;
    public final uf f;
    public final ic g;
    public final tw3 h;
    public final ExecutorService i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final int p;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ThreadLocal {
        public a() {
        }

        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c initialValue() {
            return new c();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            a = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class c {
        public final List a = new ArrayList();
        public boolean b;
        public boolean c;
        public uw3 d;
        public Object e;
        public boolean f;
    }

    public zu0() {
        this(s);
    }

    public zu0(av0 av0Var) {
        this.d = new a();
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new ConcurrentHashMap();
        this.e = new ue1(this, Looper.getMainLooper(), 10);
        this.f = new uf(this);
        this.g = new ic(this);
        List list = av0Var.j;
        this.p = list != null ? list.size() : 0;
        this.h = new tw3(av0Var.j, av0Var.h, av0Var.g);
        this.k = av0Var.a;
        this.l = av0Var.b;
        this.m = av0Var.c;
        this.n = av0Var.d;
        this.j = av0Var.e;
        this.o = av0Var.f;
        this.i = av0Var.i;
    }

    public static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    public static zu0 c() {
        if (r == null) {
            synchronized (zu0.class) {
                try {
                    if (r == null) {
                        r = new zu0();
                    }
                } finally {
                }
            }
        }
        return r;
    }

    public static List i(Class cls) {
        List list;
        Map map = t;
        synchronized (map) {
            try {
                list = (List) map.get(cls);
                if (list == null) {
                    list = new ArrayList();
                    for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                        list.add(cls2);
                        a(list, cls2.getInterfaces());
                    }
                    t.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    public final void b(uw3 uw3Var, Object obj) {
        if (obj != null) {
            m(uw3Var, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    public ExecutorService d() {
        return this.i;
    }

    public final void e(uw3 uw3Var, Object obj, Throwable th) {
        if (!(obj instanceof qw3)) {
            if (this.j) {
                throw new EventBusException("Invoking subscriber failed", th);
            }
            if (this.k) {
                Log.e(q, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + uw3Var.a.getClass(), th);
            }
            if (this.m) {
                j(new qw3(this, th, obj, uw3Var.a));
                return;
            }
            return;
        }
        if (this.k) {
            Log.e(q, "SubscriberExceptionEvent subscriber " + uw3Var.a.getClass() + " threw an exception", th);
            qw3 qw3Var = (qw3) obj;
            Log.e(q, "Initial event " + qw3Var.c + " caused exception in " + qw3Var.d, qw3Var.b);
        }
    }

    public void f(ox2 ox2Var) {
        Object obj = ox2Var.a;
        uw3 uw3Var = ox2Var.b;
        ox2.b(ox2Var);
        if (uw3Var.c) {
            g(uw3Var, obj);
        }
    }

    public void g(uw3 uw3Var, Object obj) {
        try {
            uw3Var.b.a.invoke(uw3Var.a, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            e(uw3Var, obj, e2.getCause());
        }
    }

    public synchronized boolean h(Object obj) {
        return this.b.containsKey(obj);
    }

    public void j(Object obj) {
        c cVar = (c) this.d.get();
        List list = cVar.a;
        list.add(obj);
        if (cVar.b) {
            return;
        }
        cVar.c = Looper.getMainLooper() == Looper.myLooper();
        cVar.b = true;
        if (cVar.f) {
            throw new EventBusException("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                k(list.remove(0), cVar);
            } finally {
                cVar.b = false;
                cVar.c = false;
            }
        }
    }

    public final void k(Object obj, c cVar) {
        boolean l;
        Class<?> cls = obj.getClass();
        if (this.o) {
            List i = i(cls);
            int size = i.size();
            l = false;
            for (int i2 = 0; i2 < size; i2++) {
                l |= l(obj, cVar, (Class) i.get(i2));
            }
        } else {
            l = l(obj, cVar, cls);
        }
        if (l) {
            return;
        }
        if (this.l) {
            Log.d(q, "No subscribers registered for event " + cls);
        }
        if (!this.n || cls == lq2.class || cls == qw3.class) {
            return;
        }
        j(new lq2(this, obj));
    }

    public final boolean l(Object obj, c cVar, Class cls) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            uw3 uw3Var = (uw3) it.next();
            cVar.e = obj;
            cVar.d = uw3Var;
            try {
                m(uw3Var, obj, cVar.c);
                if (cVar.f) {
                    return true;
                }
            } finally {
                cVar.e = null;
                cVar.d = null;
                cVar.f = false;
            }
        }
        return true;
    }

    public final void m(uw3 uw3Var, Object obj, boolean z) {
        int i = b.a[uw3Var.b.b.ordinal()];
        if (i == 1) {
            g(uw3Var, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                g(uw3Var, obj);
                return;
            } else {
                this.e.a(uw3Var, obj);
                return;
            }
        }
        if (i != 3) {
            if (i == 4) {
                this.g.a(uw3Var, obj);
                return;
            } else {
                di3.a("Unknown thread mode: ", uw3Var.b.b);
                return;
            }
        }
        if (z) {
            this.f.a(uw3Var, obj);
        } else {
            g(uw3Var, obj);
        }
    }

    public void n(Object obj) {
        List a2 = this.h.a(obj.getClass());
        synchronized (this) {
            try {
                Iterator it = a2.iterator();
                while (it.hasNext()) {
                    o(obj, (sw3) it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void o(Object obj, sw3 sw3Var) {
        Class cls = sw3Var.c;
        uw3 uw3Var = new uw3(obj, sw3Var);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(uw3Var)) {
            throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || sw3Var.d > ((uw3) copyOnWriteArrayList.get(i)).b.d) {
                copyOnWriteArrayList.add(i, uw3Var);
                break;
            }
        }
        List list = (List) this.b.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.b.put(obj, list);
        }
        list.add(cls);
        if (sw3Var.e) {
            boolean z = this.o;
            Map map = this.c;
            if (!z) {
                b(uw3Var, map.get(cls));
                return;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (cls.isAssignableFrom((Class) entry.getKey())) {
                    b(uw3Var, entry.getValue());
                }
            }
        }
    }

    public synchronized void p(Object obj) {
        try {
            List list = (List) this.b.get(obj);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    q(obj, (Class) it.next());
                }
                this.b.remove(obj);
            } else {
                Log.w(q, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void q(Object obj, Class cls) {
        List list = (List) this.a.get(cls);
        if (list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                uw3 uw3Var = (uw3) list.get(i);
                if (uw3Var.a == obj) {
                    uw3Var.c = false;
                    list.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.p + ", eventInheritance=" + this.o + "]";
    }
}
