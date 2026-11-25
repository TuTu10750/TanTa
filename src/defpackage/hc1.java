package defpackage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: /tmp/classes2.dex */
public final class hc1 extends ScheduledThreadPoolExecutor {

    /* loaded from: /tmp/classes2.dex */
    public static final class b {
        public static final hc1 a = new hc1();
    }

    public hc1() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    public static hc1 a() {
        return b.a;
    }
}
