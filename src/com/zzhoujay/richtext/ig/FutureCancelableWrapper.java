package com.zzhoujay.richtext.ig;

import java.util.concurrent.Future;

/* loaded from: /tmp/classes2.dex */
class FutureCancelableWrapper implements Cancelable {
    private Future future;

    public FutureCancelableWrapper(Future future) {
        this.future = future;
    }

    @Override // com.zzhoujay.richtext.ig.Cancelable
    public void cancel() {
        Future future = this.future;
        if (future == null || future.isDone() || this.future.isCancelled()) {
            return;
        }
        this.future.cancel(true);
        this.future = null;
    }
}
