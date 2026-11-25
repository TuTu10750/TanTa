package defpackage;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /tmp/classes2.dex */
public class tm4 {
    public final Handler.Callback a;
    public final b b;
    public Lock c;
    public final a d;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public a a;
        public a b;
        public final Runnable c;
        public final c d;
        public Lock e;

        public a(Lock lock, Runnable runnable) {
            this.c = runnable;
            this.e = lock;
            this.d = new c(new WeakReference(runnable), new WeakReference(this));
        }

        public void a(a aVar) {
            this.e.lock();
            try {
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.b = aVar;
                }
                aVar.a = aVar2;
                this.a = aVar;
                aVar.b = this;
                this.e.unlock();
            } catch (Throwable th) {
                this.e.unlock();
                throw th;
            }
        }

        public c b() {
            this.e.lock();
            try {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a = this.a;
                }
                a aVar2 = this.a;
                if (aVar2 != null) {
                    aVar2.b = aVar;
                }
                this.b = null;
                this.a = null;
                this.e.unlock();
                return this.d;
            } catch (Throwable th) {
                this.e.unlock();
                throw th;
            }
        }

        public c c(Runnable runnable) {
            this.e.lock();
            try {
                for (a aVar = this.a; aVar != null; aVar = aVar.a) {
                    if (aVar.c == runnable) {
                        return aVar.b();
                    }
                }
                this.e.unlock();
                return null;
            } finally {
                this.e.unlock();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends Handler {
        public final WeakReference a = null;

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Handler.Callback callback;
            WeakReference weakReference = this.a;
            if (weakReference == null || (callback = (Handler.Callback) weakReference.get()) == null) {
                return;
            }
            callback.handleMessage(message);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c implements Runnable {
        public final WeakReference a;
        public final WeakReference b;

        public c(WeakReference weakReference, WeakReference weakReference2) {
            this.a = weakReference;
            this.b = weakReference2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = (Runnable) this.a.get();
            a aVar = (a) this.b.get();
            if (aVar != null) {
                aVar.b();
            }
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public tm4() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.c = reentrantLock;
        this.d = new a(reentrantLock, null);
        this.a = null;
        this.b = new b();
    }

    public final boolean a(Runnable runnable) {
        return this.b.post(d(runnable));
    }

    public final boolean b(Runnable runnable, long j) {
        return this.b.postDelayed(d(runnable), j);
    }

    public final void c(Runnable runnable) {
        c c2 = this.d.c(runnable);
        if (c2 != null) {
            this.b.removeCallbacks(c2);
        }
    }

    public final c d(Runnable runnable) {
        if (runnable == null) {
            z60.a("Runnable can't be null");
            return null;
        }
        a aVar = new a(this.c, runnable);
        this.d.a(aVar);
        return aVar.d;
    }
}
