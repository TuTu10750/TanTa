package com.zzhoujay.markdown.parser;

/* loaded from: /tmp/classes2.dex */
public interface QueueConsumer {

    /* loaded from: /tmp/classes2.dex */
    public interface QueueProvider {
        LineQueue getQueue();
    }

    void setQueueProvider(QueueProvider queueProvider);
}
