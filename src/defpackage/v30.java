package defpackage;

import kotlin.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class v30 implements u60 {
    public static final v30 a = new v30();

    @Override // defpackage.u60
    public d getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // defpackage.u60
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
