package defpackage;

import java.util.concurrent.CountDownLatch;

/* loaded from: /tmp/classes2.dex */
public final /* synthetic */ class zy3 implements Runnable {
    public final /* synthetic */ CountDownLatch a;

    public /* synthetic */ zy3(CountDownLatch countDownLatch) {
        this.a = countDownLatch;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.countDown();
    }
}
