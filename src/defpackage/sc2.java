package defpackage;

import com.zzhoujay.richtext.ImageHolder;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;

/* loaded from: /tmp/classes2.dex */
public abstract class sc2 extends rc2 {
    public static Map b(Map map) {
        map.getClass();
        return ((MapBuilder) map).m();
    }

    public static Map c() {
        return new MapBuilder();
    }

    public static Map d(int i) {
        return new MapBuilder(i);
    }

    public static int e(int i) {
        return i < 0 ? i : i < 3 ? i + 1 : i < 1073741824 ? (int) ((i / 0.75f) + 1.0f) : ImageHolder.MATCH_PARENT;
    }

    public static Map f(Pair pair) {
        pair.getClass();
        Map singletonMap = Collections.singletonMap(pair.c(), pair.d());
        singletonMap.getClass();
        return singletonMap;
    }

    public static final Map g(Map map) {
        map.getClass();
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        singletonMap.getClass();
        return singletonMap;
    }

    public static SortedMap h(Map map, Comparator comparator) {
        map.getClass();
        comparator.getClass();
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
