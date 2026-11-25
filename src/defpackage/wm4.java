package defpackage;

import io.socket.engineio.client.Transport;
import io.socket.engineio.parser.Parser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class wm4 extends Transport {
    public static final Logger q = Logger.getLogger(a03.class.getName());
    public WebSocket p;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebSocketListener {
        public final /* synthetic */ wm4 a;

        /* renamed from: wm4$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0164a implements Runnable {
            public final /* synthetic */ Map a;

            public RunnableC0164a(Map map) {
                this.a = map;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.a("responseHeaders", this.a);
                a.this.a.o();
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements Runnable {
            public final /* synthetic */ String a;

            public b(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.l(this.a);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class c implements Runnable {
            public final /* synthetic */ ByteString a;

            public c(ByteString byteString) {
                this.a = byteString;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.m(this.a.L());
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class d implements Runnable {
            public d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.k();
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class e implements Runnable {
            public final /* synthetic */ Throwable a;

            public e(Throwable th) {
                this.a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.a.n("websocket error", (Exception) this.a);
            }
        }

        public a(wm4 wm4Var) {
            this.a = wm4Var;
        }

        @Override // okhttp3.WebSocketListener
        public void onClosed(WebSocket webSocket, int i, String str) {
            lv0.h(new d());
        }

        @Override // okhttp3.WebSocketListener
        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (th instanceof Exception) {
                lv0.h(new e(th));
            }
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, String str) {
            if (str == null) {
                return;
            }
            lv0.h(new b(str));
        }

        @Override // okhttp3.WebSocketListener
        public void onMessage(WebSocket webSocket, ByteString byteString) {
            if (byteString == null) {
                return;
            }
            lv0.h(new c(byteString));
        }

        @Override // okhttp3.WebSocketListener
        public void onOpen(WebSocket webSocket, Response response) {
            lv0.h(new RunnableC0164a(response.headers().toMultimap()));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public final /* synthetic */ wm4 a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                wm4 wm4Var = b.this.a;
                wm4Var.b = true;
                wm4Var.a("drain", new Object[0]);
            }
        }

        public b(wm4 wm4Var) {
            this.a = wm4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            lv0.j(new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Parser.c {
        public final /* synthetic */ wm4 a;
        public final /* synthetic */ int[] b;
        public final /* synthetic */ Runnable c;

        public c(wm4 wm4Var, int[] iArr, Runnable runnable) {
            this.a = wm4Var;
            this.b = iArr;
            this.c = runnable;
        }

        @Override // io.socket.engineio.parser.Parser.c
        public void a(Object obj) {
            try {
                if (obj instanceof String) {
                    this.a.p.send((String) obj);
                } else if (obj instanceof byte[]) {
                    this.a.p.send(ByteString.z((byte[]) obj));
                }
            } catch (IllegalStateException unused) {
                wm4.q.fine("websocket closed before we could write");
            }
            int[] iArr = this.b;
            int i = iArr[0] - 1;
            iArr[0] = i;
            if (i == 0) {
                this.c.run();
            }
        }
    }

    public wm4(Transport.d dVar) {
        super(dVar);
        this.c = "websocket";
    }

    public String A() {
        String str;
        Map map = this.d;
        if (map == null) {
            map = new HashMap();
        }
        String str2 = this.e ? "wss" : "ws";
        if (this.g <= 0 || ((!"wss".equals(str2) || this.g == 443) && (!"ws".equals(str2) || this.g == 80))) {
            str = "";
        } else {
            str = ":" + this.g;
        }
        if (this.f) {
            map.put(this.j, iq4.b());
        }
        String b2 = mw2.b(map);
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
        WebSocket webSocket = this.p;
        if (webSocket != null) {
            webSocket.close(IjkMediaCodecInfo.RANK_MAX, "");
            this.p = null;
        }
    }

    @Override // io.socket.engineio.client.Transport
    public void j() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Map map = this.o;
        if (map != null) {
            treeMap.putAll(map);
        }
        a("requestHeaders", treeMap);
        Request.Builder url = new Request.Builder().url(A());
        for (Map.Entry entry : treeMap.entrySet()) {
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                url.addHeader((String) entry.getKey(), (String) it.next());
            }
        }
        this.p = this.m.newWebSocket(url.build(), new a(this));
    }

    @Override // io.socket.engineio.client.Transport
    public void s(tv2[] tv2VarArr) {
        this.b = false;
        b bVar = new b(this);
        int[] iArr = {tv2VarArr.length};
        for (tv2 tv2Var : tv2VarArr) {
            Transport.ReadyState readyState = this.l;
            if (readyState != Transport.ReadyState.OPENING && readyState != Transport.ReadyState.OPEN) {
                return;
            }
            Parser.e(tv2Var, new c(this, iArr, bVar));
        }
    }
}
