package defpackage;

import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: /tmp/classes2.dex */
public abstract class rc2 {
    public static final Object a(Map map, Object obj) {
        map.getClass();
        Object obj2 = map.get(obj);
        if (obj2 != null || map.containsKey(obj)) {
            return obj2;
        }
        throw new NoSuchElementException("Key " + obj + " is missing in the map.");
    }
}
