package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class gj4 {
    public static gj4 c;
    public Map a = new HashMap();
    public Map b = new HashMap();

    public static gj4 d() {
        if (c == null) {
            synchronized (gj4.class) {
                try {
                    if (c == null) {
                        c = new gj4();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public void a() {
        Map map = this.a;
        if (map != null) {
            map.clear();
        }
        Map map2 = this.b;
        if (map2 != null) {
            map2.clear();
        }
    }

    public List b(String str) {
        Map map = this.a;
        if (map != null) {
            return (List) map.get(str);
        }
        return null;
    }

    public yi4 c(String str) {
        Map map = this.b;
        if (map != null) {
            return (yi4) map.get(str);
        }
        return null;
    }

    public void e(String str, List list) {
        Map map = this.a;
        if (map != null) {
            map.put(str, list);
        }
    }

    public void f(String str, yi4 yi4Var) {
        Map map = this.b;
        if (map != null) {
            map.put(str, yi4Var);
        }
    }

    public void g(String str) {
        Map map = this.b;
        if (map != null) {
            map.remove(str);
        }
    }
}
