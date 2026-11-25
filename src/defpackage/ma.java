package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class ma {
    public static final List a = new ArrayList();

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a();

        void b();
    }

    public static void a(a aVar) {
        List list = a;
        if (list != null) {
            list.add(aVar);
        }
    }

    public static void b() {
        List list = a;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
    }

    public static void c() {
        List list = a;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }
}
