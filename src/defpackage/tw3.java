package defpackage;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: /tmp/classes2.dex */
public class tw3 {
    public static final Map d = new ConcurrentHashMap();
    public static final a[] e = new a[4];
    public List a;
    public final boolean b;
    public final boolean c;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public final List a = new ArrayList();
        public final Map b = new HashMap();
        public final Map c = new HashMap();
        public final StringBuilder d = new StringBuilder(128);
        public Class e;
        public Class f;
        public boolean g;

        public boolean a(Method method, Class cls) {
            Object put = this.b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    pr4.a();
                    return false;
                }
                this.b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class cls) {
            this.d.setLength(0);
            this.d.append(method.getName());
            StringBuilder sb = this.d;
            sb.append('>');
            sb.append(cls.getName());
            String sb2 = this.d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.c.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.c.put(sb2, cls2);
            return false;
        }

        public void c(Class cls) {
            this.f = cls;
            this.e = cls;
            this.g = false;
        }

        public void d() {
            if (this.g) {
                this.f = null;
                return;
            }
            Class superclass = this.f.getSuperclass();
            this.f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f = null;
            }
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.c.clear();
            this.d.setLength(0);
            this.e = null;
            this.f = null;
            this.g = false;
        }
    }

    public tw3(List list, boolean z, boolean z2) {
        this.a = list;
        this.b = z;
        this.c = z2;
    }

    public List a(Class cls) {
        Map map = d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        List c = this.c ? c(cls) : b(cls);
        if (!c.isEmpty()) {
            map.put(cls, c);
            return c;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List b(Class cls) {
        a g = g();
        g.c(cls);
        while (g.f != null) {
            f(g);
            d(g);
            g.d();
        }
        return e(g);
    }

    public final List c(Class cls) {
        a g = g();
        g.c(cls);
        while (g.f != null) {
            d(g);
            g.d();
        }
        return e(g);
    }

    public final void d(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f.getMethods();
            aVar.g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    pw3 pw3Var = (pw3) method.getAnnotation(pw3.class);
                    if (pw3Var != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.a.add(new sw3(method, cls, pw3Var.threadMode(), pw3Var.priority(), pw3Var.sticky()));
                        }
                    }
                } else if (this.b && method.isAnnotationPresent(pw3.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.b && method.isAnnotationPresent(pw3.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + "." + method.getName()).concat(" is a illegal @Subscribe method: must be public, non-static, and non-abstract"));
            }
        }
    }

    public final List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.e();
        synchronized (e) {
            int i = 0;
            while (true) {
                if (i >= 4) {
                    break;
                }
                try {
                    a[] aVarArr = e;
                    if (aVarArr[i] == null) {
                        aVarArr[i] = aVar;
                        break;
                    }
                    i++;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return arrayList;
    }

    public final rw3 f(a aVar) {
        aVar.getClass();
        List list = this.a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                ue2.a(it.next());
                throw null;
            }
        }
        return null;
    }

    public final a g() {
        synchronized (e) {
            for (int i = 0; i < 4; i++) {
                try {
                    a[] aVarArr = e;
                    a aVar = aVarArr[i];
                    if (aVar != null) {
                        aVarArr[i] = null;
                        return aVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return new a();
        }
    }
}
