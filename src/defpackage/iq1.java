package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import pl.droidsonroids.gif.a;

/* loaded from: /tmp/classes2.dex */
public class iq1 extends Handler {
    public final WeakReference a;

    public iq1(a aVar) {
        super(Looper.getMainLooper());
        this.a = new WeakReference(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = (a) this.a.get();
        if (aVar == null) {
            return;
        }
        if (message.what == -1) {
            aVar.invalidateSelf();
            return;
        }
        Iterator it = aVar.h.iterator();
        if (it.hasNext()) {
            ue2.a(it.next());
            throw null;
        }
    }
}
