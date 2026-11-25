package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public abstract class g44 {
    public static final p04 a = new p04("NO_THREAD_ELEMENTS");
    public static final b91 b = new b91() { // from class: d44
        @Override // defpackage.b91
        public final Object invoke(Object obj, Object obj2) {
            return g44.b(obj, (d.b) obj2);
        }
    };
    public static final b91 c = new b91() { // from class: e44
        @Override // defpackage.b91
        public final Object invoke(Object obj, Object obj2) {
            ue2.a(obj);
            g44.a(null, (d.b) obj2);
            return null;
        }
    };
    public static final b91 d = new b91() { // from class: f44
        @Override // defpackage.b91
        public final Object invoke(Object obj, Object obj2) {
            return g44.c((l44) obj, (d.b) obj2);
        }
    };

    public static c44 a(c44 c44Var, d.b bVar) {
        return null;
    }

    public static Object b(Object obj, d.b bVar) {
        return obj;
    }

    public static l44 c(l44 l44Var, d.b bVar) {
        return l44Var;
    }

    public static final void d(d dVar, Object obj) {
        if (obj == a) {
            return;
        }
        if (obj instanceof l44) {
            ((l44) obj).a(dVar);
            return;
        }
        Object fold = dVar.fold(null, c);
        fold.getClass();
        ue2.a(fold);
        throw null;
    }

    public static final Object e(d dVar) {
        Object fold = dVar.fold(0, b);
        fold.getClass();
        return fold;
    }

    public static final Object f(d dVar, Object obj) {
        if (obj == null) {
            obj = e(dVar);
        }
        if (obj == 0) {
            return a;
        }
        if (obj instanceof Integer) {
            return dVar.fold(new l44(dVar, ((Number) obj).intValue()), d);
        }
        obj.getClass();
        ue2.a(obj);
        throw null;
    }
}
