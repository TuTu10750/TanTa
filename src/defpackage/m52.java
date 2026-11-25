package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class m52 {
    public static m52 b;
    public Map a = new HashMap();

    public static m52 c() {
        if (b == null) {
            synchronized (m52.class) {
                try {
                    if (b == null) {
                        b = new m52();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public void a() {
        Map map = this.a;
        if (map != null) {
            map.clear();
        }
    }

    public List b(String str) {
        Map map = this.a;
        if (map != null) {
            return (List) map.get(str);
        }
        return null;
    }

    public void d(String str) {
        Map map = this.a;
        if (map != null) {
            map.remove(str);
        }
    }
}
