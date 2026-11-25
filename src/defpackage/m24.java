package defpackage;

import android.os.Handler;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class m24 {
    public final Handler a = new Handler();
    public final Map b = new HashMap();

    /* loaded from: /tmp/classes2.dex */
    public class a {
        public final Runnable a;
        public final long b;
        public final long c;
        public long d;

        /* renamed from: m24$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0134a implements Runnable {
            public final /* synthetic */ m24 a;
            public final /* synthetic */ Runnable b;

            public RunnableC0134a(m24 m24Var, Runnable runnable) {
                this.a = m24Var;
                this.b = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable runnable = this.b;
                if (runnable != null) {
                    runnable.run();
                }
                if (a.this.c > 0) {
                    a aVar = a.this;
                    a.c(aVar, aVar.c);
                    m24.this.a.postAtTime(a.this.a, a.this.d);
                }
            }
        }

        public a(Runnable runnable, long j, long j2) {
            j = j < 0 ? 0L : j;
            j2 = j2 < 0 ? 0L : j2;
            this.a = new RunnableC0134a(m24.this, runnable);
            this.b = j;
            this.c = j2;
        }

        public static /* synthetic */ long c(a aVar, long j) {
            long j2 = aVar.d + j;
            aVar.d = j2;
            return j2;
        }

        public void e() {
            m24.this.a.removeCallbacks(this.a);
        }

        public void f() {
            long uptimeMillis = SystemClock.uptimeMillis();
            this.d = uptimeMillis;
            long j = this.b;
            if (j == 0) {
                this.a.run();
            } else {
                this.d = uptimeMillis + j;
                m24.this.a.postAtTime(this.a, this.d);
            }
        }
    }

    public void b() {
        if (this.b.size() > 0) {
            for (Map.Entry entry : this.b.entrySet()) {
                ((a) entry.getValue()).e();
                lx1.c("TaskScheduler", "cancelAllTasks--->" + ((String) entry.getKey()));
            }
            this.b.clear();
        }
    }

    public void c(String str) {
        a aVar = (a) this.b.get(str);
        if (aVar != null) {
            aVar.e();
            this.b.remove(str);
            lx1.c("TaskScheduler", "cancelTask--->" + str);
        }
    }

    public void d(String str, long j, long j2, Runnable runnable) {
        a aVar = (a) this.b.get(str);
        if (aVar != null) {
            aVar.e();
        }
        a aVar2 = new a(runnable, j, j2);
        this.b.put(str, aVar2);
        aVar2.f();
        lx1.c("TaskScheduler", "startTask--->" + str);
    }
}
