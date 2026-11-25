package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class pc4 implements d.b, d.c {
    public static final pc4 a = new pc4();

    @Override // kotlin.coroutines.d
    public Object fold(Object obj, b91 b91Var) {
        return d.b.a.a(this, obj, b91Var);
    }

    @Override // kotlin.coroutines.d.b, kotlin.coroutines.d
    public d.b get(d.c cVar) {
        return d.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.d.b
    public d.c getKey() {
        return this;
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c cVar) {
        return d.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.d
    public d plus(d dVar) {
        return d.b.a.d(this, dVar);
    }
}
