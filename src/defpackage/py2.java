package defpackage;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* loaded from: /tmp/classes2.dex */
public final class py2 extends w1 {
    @Override // defpackage.w1
    public Random c() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        current.getClass();
        return current;
    }
}
