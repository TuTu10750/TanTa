package defpackage;

import defpackage.us0;
import io.socket.engineio.client.Transport;
import io.socket.engineio.parser.Parser;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: /tmp/classes2.dex */
public abstract class zz2 extends Transport {
    public static final Logger q = Logger.getLogger(zz2.class.getName());
    public boolean p;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        /* renamed from: zz2$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0173a implements Runnable {
            public final /* synthetic */ zz2 a;

            public RunnableC0173a(zz2 zz2Var) {
                this.a = zz2Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                zz2.q.fine("paused");
                this.a.l = Transport.ReadyState.PAUSED;
                a.this.a.run();
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements us0.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public b(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // us0.a
            public void call(Object... objArr) {
                zz2.q.fine("pre-pause polling complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class c implements us0.a {
            public final /* synthetic */ int[] a;
            public final /* synthetic */ Runnable b;

            public c(int[] iArr, Runnable runnable) {
                this.a = iArr;
                this.b = runnable;
            }

            @Override // us0.a
            public void call(Object... objArr) {
                zz2.q.fine("pre-pause writing complete");
                int[] iArr = this.a;
                int i = iArr[0] - 1;
                iArr[0] = i;
                if (i == 0) {
                    this.b.run();
                }
            }
        }

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            zz2 zz2Var = zz2.this;
            zz2Var.l = Transport.ReadyState.PAUSED;
            RunnableC0173a runnableC0173a = new RunnableC0173a(zz2Var);
            if (!zz2.this.p && zz2.this.b) {
                runnableC0173a.run();
                return;
            }
            int[] iArr = {0};
            if (zz2.this.p) {
                zz2.q.fine("we are currently polling - waiting to pause");
                iArr[0] = iArr[0] + 1;
                zz2.this.f("pollComplete", new b(iArr, runnableC0173a));
            }
            if (zz2.this.b) {
                return;
            }
            zz2.q.fine("we are currently writing - waiting to pause");
            iArr[0] = iArr[0] + 1;
            zz2.this.f("drain", new c(iArr, runnableC0173a));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Parser.b {
        public final /* synthetic */ zz2 a;

        public b(zz2 zz2Var) {
            this.a = zz2Var;
        }

        @Override // io.socket.engineio.parser.Parser.b
        public boolean a(tv2 tv2Var, int i, int i2) {
            if (this.a.l == Transport.ReadyState.OPENING && "open".equals(tv2Var.a)) {
                this.a.o();
            }
            boolean equals = "close".equals(tv2Var.a);
            zz2 zz2Var = this.a;
            if (equals) {
                zz2Var.k();
                return false;
            }
            zz2Var.p(tv2Var);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements us0.a {
        public final /* synthetic */ zz2 a;

        public c(zz2 zz2Var) {
            this.a = zz2Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            zz2.q.fine("writing close packet");
            this.a.s(new tv2[]{new tv2("close")});
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Runnable {
        public final /* synthetic */ zz2 a;

        public d(zz2 zz2Var) {
            this.a = zz2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            zz2 zz2Var = this.a;
            zz2Var.b = true;
            zz2Var.a("drain", new Object[0]);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Parser.c {
        public final /* synthetic */ zz2 a;
        public final /* synthetic */ Runnable b;

        public e(zz2 zz2Var, Runnable runnable) {
            this.a = zz2Var;
            this.b = runnable;
        }

        @Override // io.socket.engineio.parser.Parser.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(String str) {
            this.a.D(str, this.b);
        }
    }

    public zz2(Transport.d dVar) {
        super(dVar);
        this.c = "polling";
    }

    public abstract void C();

    public abstract void D(String str, Runnable runnable);

    public void E(Runnable runnable) {
        lv0.h(new a(runnable));
    }

    public final void F() {
        q.fine("polling");
        this.p = true;
        C();
        a("poll", new Object[0]);
    }

    public String G() {
        String str;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str2 = this.e ? "https" : "http";
        if (this.f) {
            map.put(this.j, iq4.b());
        }
        String b2 = mw2.b(map);
        if (this.g <= 0 || ((!"https".equals(str2) || this.g == 443) && (!"http".equals(str2) || this.g == 80))) {
            str = "";
        } else {
            str = ":" + this.g;
        }
        if (b2.length() > 0) {
            b2 = "?".concat(b2);
        }
        boolean contains = this.i.contains(":");
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("://");
        String str3 = this.i;
        if (contains) {
            str3 = "[" + str3 + "]";
        }
        sb.append(str3);
        sb.append(str);
        sb.append(this.h);
        sb.append(b2);
        return sb.toString();
    }

    @Override // io.socket.engineio.client.Transport
    public void i() {
        c cVar = new c(this);
        if (this.l == Transport.ReadyState.OPEN) {
            q.fine("transport open - closing");
            cVar.call(new Object[0]);
        } else {
            q.fine("transport not open - deferring close");
            f("open", cVar);
        }
    }

    @Override // io.socket.engineio.client.Transport
    public void j() {
        F();
    }

    @Override // io.socket.engineio.client.Transport
    public void l(String str) {
        t(str);
    }

    @Override // io.socket.engineio.client.Transport
    public void s(tv2[] tv2VarArr) {
        this.b = false;
        Parser.g(tv2VarArr, new e(this, new d(this)));
    }

    public final void t(Object obj) {
        Logger logger = q;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            logger.fine(String.format("polling got data %s", obj));
        }
        Parser.d((String) obj, new b(this));
        if (this.l != Transport.ReadyState.CLOSED) {
            this.p = false;
            a("pollComplete", new Object[0]);
            if (this.l == Transport.ReadyState.OPEN) {
                F();
            } else if (logger.isLoggable(level)) {
                logger.fine(String.format("ignoring poll - transport state '%s'", this.l));
            }
        }
    }
}
