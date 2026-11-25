package defpackage;

import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class ox2 {
    public static final List d = new ArrayList();
    public Object a;
    public uw3 b;
    public ox2 c;

    public ox2(Object obj, uw3 uw3Var) {
        this.a = obj;
        this.b = uw3Var;
    }

    public static ox2 a(uw3 uw3Var, Object obj) {
        List list = d;
        synchronized (list) {
            try {
                int size = list.size();
                if (size <= 0) {
                    return new ox2(obj, uw3Var);
                }
                ox2 ox2Var = (ox2) list.remove(size - 1);
                ox2Var.a = obj;
                ox2Var.b = uw3Var;
                ox2Var.c = null;
                return ox2Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(ox2 ox2Var) {
        ox2Var.a = null;
        ox2Var.b = null;
        ox2Var.c = null;
        List list = d;
        synchronized (list) {
            try {
                if (list.size() < 10000) {
                    list.add(ox2Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
