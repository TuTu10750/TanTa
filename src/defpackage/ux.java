package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: /tmp/classes2.dex */
public abstract /* synthetic */ class ux {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
