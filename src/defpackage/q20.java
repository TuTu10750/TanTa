package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class q20 {
    public static final void a(Collection collection, Object obj) {
        collection.getClass();
        if (obj != null) {
            collection.add(obj);
        }
    }

    public static final int b(int i) {
        if (i < 3) {
            return 3;
        }
        return i + (i / 3) + 1;
    }

    public static final List c(ArrayList arrayList) {
        arrayList.getClass();
        int size = arrayList.size();
        if (size == 0) {
            return s20.k();
        }
        if (size == 1) {
            return r20.e(b30.b0(arrayList));
        }
        arrayList.trimToSize();
        return arrayList;
    }

    public static final Map d(Iterable iterable) {
        iterable.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            linkedHashMap.put(it.next(), Integer.valueOf(i));
            i++;
        }
        return linkedHashMap;
    }

    public static final HashMap e(int i) {
        return new HashMap(b(i));
    }

    public static final HashSet f(int i) {
        return new HashSet(b(i));
    }

    public static final LinkedHashSet g(int i) {
        return new LinkedHashSet(b(i));
    }
}
