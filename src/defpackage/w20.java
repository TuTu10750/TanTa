package defpackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class w20 extends v20 {
    public static void y(List list) {
        list.getClass();
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static void z(List list, Comparator comparator) {
        list.getClass();
        comparator.getClass();
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
