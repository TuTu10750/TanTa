package defpackage;

import kotlin.random.Random;

/* loaded from: /tmp/classes2.dex */
public abstract class w1 extends Random {
    @Override // kotlin.random.Random
    public int b(int i) {
        return c().nextInt(i);
    }

    public abstract java.util.Random c();
}
