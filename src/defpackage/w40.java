package defpackage;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /tmp/classes2.dex */
public final class w40 extends bn {
    public final n81 a;
    public final ConcurrentHashMap b;

    public w40(n81 n81Var) {
        n81Var.getClass();
        this.a = n81Var;
        this.b = new ConcurrentHashMap();
    }

    @Override // defpackage.bn
    public Object a(Class cls) {
        cls.getClass();
        ConcurrentHashMap concurrentHashMap = this.b;
        Object obj = concurrentHashMap.get(cls);
        if (obj != null) {
            return obj;
        }
        Object invoke = this.a.invoke(cls);
        Object putIfAbsent = concurrentHashMap.putIfAbsent(cls, invoke);
        return putIfAbsent == null ? invoke : putIfAbsent;
    }
}
