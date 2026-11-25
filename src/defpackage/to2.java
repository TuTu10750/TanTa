package defpackage;

import kotlinx.coroutines.sync.a;

/* loaded from: /tmp/classes2.dex */
public abstract class to2 {
    public static final p04 a = new p04("NO_OWNER");
    public static final p04 b = new p04("ALREADY_LOCKED_BY_OWNER");

    public static final oo2 a(boolean z) {
        return new a(z);
    }

    public static /* synthetic */ oo2 b(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return a(z);
    }
}
