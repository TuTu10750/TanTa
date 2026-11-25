package defpackage;

import com.umeng.analytics.pro.cl;
import defpackage.us0;
import io.socket.engineio.client.Transport;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: /tmp/classes2.dex */
public class a03 extends zz2 {
    public static final Logger r;
    public static boolean s;

    /* loaded from: /tmp/classes2.dex */
    public class a implements us0.a {
        public final /* synthetic */ a03 a;

        /* renamed from: a03$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0000a implements Runnable {
            public final /* synthetic */ Object[] a;

            public RunnableC0000a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a[0]);
            }
        }

        public a(a03 a03Var) {
            this.a = a03Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lv0.h(new RunnableC0000a(objArr));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements us0.a {
        public final /* synthetic */ a03 a;

        public b(a03 a03Var) {
            this.a = a03Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            this.a.a("requestHeaders", objArr[0]);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements us0.a {
        public final /* synthetic */ Runnable a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a.run();
            }
        }

        public c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lv0.h(new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements us0.a {
        public final /* synthetic */ a03 a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                        d.this.a.n("xhr post error", exc);
                    }
                }
                exc = null;
                d.this.a.n("xhr post error", exc);
            }
        }

        public d(a03 a03Var) {
            this.a = a03Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lv0.h(new a(objArr));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements us0.a {
        public final /* synthetic */ a03 a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Object[] objArr = this.a;
                e.this.a.l((String) (objArr.length > 0 ? objArr[0] : null));
            }
        }

        public e(a03 a03Var) {
            this.a = a03Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lv0.h(new a(objArr));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements us0.a {
        public final /* synthetic */ a03 a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ Object[] a;

            public a(Object[] objArr) {
                this.a = objArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                Exception exc;
                Object[] objArr = this.a;
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof Exception) {
                        exc = (Exception) obj;
                        f.this.a.n("xhr poll error", exc);
                    }
                }
                exc = null;
                f.this.a.n("xhr poll error", exc);
            }
        }

        public f(a03 a03Var) {
            this.a = a03Var;
        }

        @Override // us0.a
        public void call(Object... objArr) {
            lv0.h(new a(objArr));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class g extends us0 {
        public static final MediaType i = MediaType.parse("text/plain;charset=UTF-8");
        public String b;
        public String c;
        public String d;
        public Call.Factory e;
        public Map f;
        public Response g;
        public Call h;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Callback {
            public final /* synthetic */ g a;

            public a(g gVar) {
                this.a = gVar;
            }

            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                this.a.n(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                this.a.g = response;
                this.a.q(response.headers().toMultimap());
                try {
                    boolean isSuccessful = response.isSuccessful();
                    g gVar = this.a;
                    if (isSuccessful) {
                        gVar.o();
                    } else {
                        gVar.n(new IOException(Integer.toString(response.code())));
                    }
                    response.close();
                } catch (Throwable th) {
                    response.close();
                    throw th;
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public static class b {
            public String a;
            public String b;
            public String c;
            public Call.Factory d;
            public Map e;
        }

        public g(b bVar) {
            String str = bVar.b;
            this.b = str == null ? "GET" : str;
            this.c = bVar.a;
            this.d = bVar.c;
            this.e = bVar.d;
            this.f = bVar.e;
        }

        private void m(String str) {
            a(cl.b, str);
            r();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(Exception exc) {
            a("error", exc);
        }

        public void l() {
            if (a03.s) {
                a03.r.fine(String.format("xhr open %s: %s", this.b, this.c));
            }
            TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Map map = this.f;
            if (map != null) {
                treeMap.putAll(map);
            }
            if ("POST".equals(this.b)) {
                treeMap.put("Content-type", new LinkedList(Collections.singletonList("text/plain;charset=UTF-8")));
            }
            treeMap.put("Accept", new LinkedList(Collections.singletonList("*/*")));
            p(treeMap);
            if (a03.s) {
                a03.r.fine(String.format("sending xhr with url %s | data %s", this.c, this.d));
            }
            Request.Builder builder = new Request.Builder();
            for (Map.Entry entry : treeMap.entrySet()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    builder.addHeader((String) entry.getKey(), (String) it.next());
                }
            }
            String str = this.d;
            Call newCall = this.e.newCall(builder.url(HttpUrl.parse(this.c)).method(this.b, str != null ? RequestBody.create(i, str) : null).build());
            this.h = newCall;
            newCall.enqueue(new a(this));
        }

        public final void o() {
            try {
                m(this.g.body().string());
            } catch (IOException e) {
                n(e);
            }
        }

        public final void p(Map map) {
            a("requestHeaders", map);
        }

        public final void q(Map map) {
            a("responseHeaders", map);
        }

        public final void r() {
            a("success", new Object[0]);
        }
    }

    static {
        Logger logger = Logger.getLogger(a03.class.getName());
        r = logger;
        s = logger.isLoggable(Level.FINE);
    }

    public a03(Transport.d dVar) {
        super(dVar);
    }

    @Override // defpackage.zz2
    public void C() {
        r.fine("xhr poll");
        g L = L();
        L.e(cl.b, new e(this));
        L.e("error", new f(this));
        L.l();
    }

    @Override // defpackage.zz2
    public void D(String str, Runnable runnable) {
        g.b bVar = new g.b();
        bVar.b = "POST";
        bVar.c = str;
        bVar.e = this.o;
        g M = M(bVar);
        M.e("success", new c(runnable));
        M.e("error", new d(this));
        M.l();
    }

    public g L() {
        return M(null);
    }

    public g M(g.b bVar) {
        if (bVar == null) {
            bVar = new g.b();
        }
        bVar.a = G();
        bVar.d = this.n;
        bVar.e = this.o;
        g gVar = new g(bVar);
        gVar.e("requestHeaders", new b(this)).e("responseHeaders", new a(this));
        return gVar;
    }
}
