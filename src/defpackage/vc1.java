package defpackage;

import android.util.Log;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class vc1 extends kotlin.coroutines.a implements o70 {
    public static final a a = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public vc1() {
        super(o70.b0);
    }

    @Override // defpackage.o70
    public void handleException(d dVar, Throwable th) {
        dVar.getClass();
        th.getClass();
        Log.e("CoroutineCrash", "Uncaught coroutine exception in " + dVar, th);
    }
}
