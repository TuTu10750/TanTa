package defpackage;

import java.util.Collections;
import java.util.Set;
import kotlin.collections.builders.SetBuilder;

/* loaded from: /tmp/classes2.dex */
public abstract class do3 {
    public static Set a(Set set) {
        set.getClass();
        return ((SetBuilder) set).h();
    }

    public static Set b() {
        return new SetBuilder();
    }

    public static Set c(int i) {
        return new SetBuilder(i);
    }

    public static Set d(Object obj) {
        Set singleton = Collections.singleton(obj);
        singleton.getClass();
        return singleton;
    }
}
