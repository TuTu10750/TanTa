package com.yunbao.main.activity;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.linkforty.sdk.models.DeepLinkData;
import com.netshield.Netshield;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.VersionBean;
import com.yunbao.common.custom.TabButtonGroup;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.activity.ChatActivity;
import com.yunbao.im.dao.IMMessageBean;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.live.bean.LiveConfigBean;
import com.yunbao.live.socket.SocketClient;
import com.yunbao.main.LinkFortyWrapper;
import com.yunbao.main.activity.MainActivity;
import com.yunbao.main.presenter.CheckLivePresenter;
import com.yunbao.video.activity.AbsVideoPlayActivity;
import com.zzhoujay.richtext.RichText;
import defpackage.a82;
import defpackage.b91;
import defpackage.bb2;
import defpackage.br2;
import defpackage.c73;
import defpackage.cb2;
import defpackage.cc2;
import defpackage.ck1;
import defpackage.d22;
import defpackage.db2;
import defpackage.dk4;
import defpackage.e32;
import defpackage.gj4;
import defpackage.hi;
import defpackage.ie3;
import defpackage.ig4;
import defpackage.ik1;
import defpackage.j30;
import defpackage.ja2;
import defpackage.jr2;
import defpackage.k12;
import defpackage.k30;
import defpackage.ka;
import defpackage.kk1;
import defpackage.lx1;
import defpackage.m52;
import defpackage.m93;
import defpackage.n02;
import defpackage.n10;
import defpackage.n81;
import defpackage.nb2;
import defpackage.oi3;
import defpackage.pi3;
import defpackage.pw3;
import defpackage.qa2;
import defpackage.qc4;
import defpackage.rv3;
import defpackage.sb2;
import defpackage.t54;
import defpackage.tb2;
import defpackage.v31;
import defpackage.vb2;
import defpackage.vl0;
import defpackage.vx2;
import defpackage.wb2;
import defpackage.x31;
import defpackage.y0;
import defpackage.y73;
import defpackage.yx2;
import defpackage.zn0;
import defpackage.zu0;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class MainActivity extends AbsVideoPlayActivity implements qa2 {
    public static MainActivity y0;
    public boolean B;
    public CheckLivePresenter C;
    public boolean D;
    public long E;
    public AudioManager F;
    public boolean G;
    public TextView H;
    public ConnectivityManager I;
    public ConnectivityManager.NetworkCallback J;
    public Handler K;
    public boolean L;
    public Runnable M;
    public HttpCallback N;
    public boolean O;
    public View P;
    public TextView Q;
    public int R;
    public cc2 S;
    public SocketClient T;
    public final OkHttpClient W;
    public final Random X;
    public final Random Y;
    public ScheduledExecutorService Z;
    public ScheduledFuture f0;
    public ScheduledFuture g0;
    public Call h0;
    public int i0;
    public String j0;
    public boolean k0;
    public ViewGroup l;
    public boolean l0;
    public TabButtonGroup m;
    public Object m0;
    public ViewPager n;
    public Object n0;
    public List o;
    public int o0;
    public cb2 p;
    public int p0;
    public ja2 q;
    public int q0;
    public sb2 r;
    public int r0;
    public bb2 s;
    public long s0;
    public nb2 t;
    public String t0;
    public y0[] u;
    public View u0;
    public View v;
    public Map v0;
    public int w;
    public Map w0;
    public ObjectAnimator x;
    public tb2 x0;
    public ObjectAnimator y;
    public boolean z;
    public boolean A = true;
    public final Object U = new Object();
    public final AtomicBoolean V = new AtomicBoolean(false);

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            lx1.b("OpenInstall---setDistribut---> " + i + "---msg----> " + str);
            if (i == 0 || i == 1004) {
                LinkFortyWrapper.INSTANCE.a().markInstallBound(MainActivity.this.b);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements tb2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends vx2 {
            public final /* synthetic */ JSONObject a;

            public a(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // defpackage.vx2
            public void a() {
                MainActivity.this.v2(this.a);
            }
        }

        /* renamed from: com.yunbao.main.activity.MainActivity$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0049b extends vx2 {
            public final /* synthetic */ JSONObject a;

            public C0049b(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // defpackage.vx2
            public void a() {
                MainActivity.this.u2(this.a);
            }
        }

        public b() {
        }

        @Override // defpackage.tb2
        public void a(JSONObject jSONObject) {
        }

        @Override // defpackage.tb2
        public void b(JSONObject jSONObject) {
            yx2.a(MainActivity.this, new C0049b(jSONObject), "android.permission.RECORD_AUDIO");
        }

        @Override // defpackage.tb2
        public void c(JSONObject jSONObject) {
            yx2.a(MainActivity.this, new a(jSONObject), "android.permission.RECORD_AUDIO");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public c() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(VersionBean versionBean) {
            if (versionBean == null || rv3.h(versionBean.getIsUp(), 0) != 1 || ig4.c(versionBean.getApkVersion())) {
                return;
            }
            ig4.d(MainActivity.this.b, versionBean, 0, versionBean.getApkUrl());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            super.onFinish();
            MainActivity.this.j2();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            int intValue = parseObject.getIntValue("is_open");
            String string = parseObject.getString("notice");
            if (intValue == 1) {
                br2 br2Var = new br2();
                br2Var.s2(string);
                br2Var.t2(MainActivity.this.getSupportFragmentManager(), "NoticeDialog");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends ConnectivityManager.NetworkCallback {
        public e() {
        }

        public static /* synthetic */ void a(e eVar) {
            if (MainActivity.this.I.getActiveNetwork() == null) {
                MainActivity.this.H.setVisibility(0);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: ma2
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.this.H.setVisibility(8);
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: na2
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.e.a(MainActivity.e.this);
                }
            });
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements Runnable {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    MainActivity.this.O = false;
                    if (MainActivity.this.K != null) {
                        MainActivity.this.K.removeCallbacks(MainActivity.this.M);
                    }
                    if (i == 10010 || i == 10011) {
                        pi3.x(str);
                    }
                }
            }
        }

        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MainActivity.this.K == null) {
                MainActivity.this.K = new Handler();
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            if (MainActivity.this.N == null) {
                MainActivity.this.N = new a();
            }
            db2.k(MainActivity.this.N);
            if (MainActivity.this.O) {
                MainActivity.this.K.postAtTime(MainActivity.this.M, uptimeMillis + (1000 - (uptimeMillis % 1000)) + 9000);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements TabButtonGroup.a {
        public g() {
        }

        @Override // com.yunbao.common.custom.TabButtonGroup.a
        public boolean a(int i) {
            if (j30.q().L()) {
                return true;
            }
            if (i == 3 && !j30.q().N()) {
                pi3.k(MainActivity.this.b);
                return true;
            }
            if (i != 2 || j30.q().N()) {
                return false;
            }
            pi3.k(MainActivity.this.b);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements TabButtonGroup.b {
        public h() {
        }

        @Override // com.yunbao.common.custom.TabButtonGroup.b
        public void a(int i) {
            if (i != 0 || MainActivity.this.p == null) {
                return;
            }
            MainActivity.this.p.o0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements ViewPager.j {
        public i() {
        }

        public void a(int i, float f, int i2) {
        }

        public void b(int i) {
        }

        public void c(int i) {
            j30.q().a0(i);
            if (i == 0) {
                zu0.c().j(new ie3());
            }
            MainActivity.this.F2(i, true);
            if (MainActivity.this.u != null) {
                int length = MainActivity.this.u.length;
                int i2 = 0;
                while (i2 < length) {
                    y0 y0Var = MainActivity.this.u[i2];
                    if (y0Var != null) {
                        y0Var.setShowed(i == i2);
                    }
                    i2++;
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements SocketClient.l {
        public j() {
        }

        @Override // com.yunbao.live.socket.SocketClient.l
        public void a(String str) {
            lx1.c("HeartbeatSocket", "server_message--->" + str);
        }

        @Override // com.yunbao.live.socket.SocketClient.l
        public void b(String str) {
            lx1.c("HeartbeatSocket", "heartbeat_result_ack--->" + str);
        }

        @Override // com.yunbao.live.socket.SocketClient.l
        public void c(String str) {
            lx1.c("HeartbeatSocket", "heartbeat_stop--->" + str);
            MainActivity.this.b3("heartbeat_stop");
        }

        @Override // com.yunbao.live.socket.SocketClient.l
        public void d(String str) {
            MainActivity.this.C2(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ List e;
        public final /* synthetic */ List f;
        public final /* synthetic */ n g;

        public k(int i, String str, String str2, String str3, List list, List list2, n nVar) {
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = list;
            this.f = list2;
            this.g = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.p2(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l implements Runnable {
        public l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MainActivity.this.r2("scheduled");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m implements Callback {
        public final /* synthetic */ long a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public m(long j, int i, String str) {
            this.a = j;
            this.b = i;
            this.c = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
            String str = iOException.getClass().getSimpleName() + ":" + iOException.getMessage();
            if (MainActivity.this.q2(this.b, call, false, 0, elapsedRealtime, str)) {
                lx1.c("HeartbeatSocket", "heartbeat request fail id=" + this.c + ", durationMs=" + elapsedRealtime + ", error=" + str);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            String str;
            int code = response.code();
            try {
                String M2 = MainActivity.this.M2(response);
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.a;
                boolean z = code >= 200 && code < 400;
                MainActivity mainActivity = MainActivity.this;
                int i = this.b;
                if (z) {
                    str = "";
                } else {
                    str = "HTTP " + code;
                }
                if (mainActivity.q2(i, call, z, code, elapsedRealtime, str)) {
                    lx1.c("HeartbeatSocket", "heartbeat request done id=" + this.c + ", statusCode=" + code + ", durationMs=" + elapsedRealtime + ", response=" + MainActivity.this.E2(M2));
                }
                response.close();
            } catch (Throwable th) {
                response.close();
                throw th;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class n {
        public final String a;
        public final List b;
        public final String c;
        public final String d;

        public n(String str, List list, String str2, String str3) {
            this.a = TextUtils.isEmpty(str) ? "none" : str;
            this.b = list == null ? Collections.EMPTY_LIST : list;
            this.c = str2;
            this.d = str3;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class o {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;

        public o(String str, String str2, String str3, String str4, int i, int i2, int i3) {
            this.a = str;
            this.b = "int".equals(str2) ? "int" : "string";
            this.c = "random".equals(str3) ? "random" : "fixed";
            this.d = str4 == null ? "" : str4;
            this.e = i;
            this.f = i2;
            this.g = i3;
        }

        public final String a(Random random) {
            int min = Math.min(this.f, this.g);
            long j = min;
            long max = (Math.max(this.f, this.g) - j) + 1;
            if (max <= 1) {
                return String.valueOf(min);
            }
            return String.valueOf(j + (max <= 2147483647L ? random.nextInt((int) max) : (long) (random.nextDouble() * max)));
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0009, code lost:
        
            if (r4 > 1024) goto L4;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.String b(java.util.Random r5) {
            /*
                r4 = this;
                int r4 = r4.e
                r0 = 1
                if (r4 >= r0) goto L7
            L5:
                r4 = r0
                goto Lc
            L7:
                r0 = 1024(0x400, float:1.435E-42)
                if (r4 <= r0) goto Lc
                goto L5
            Lc:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r4)
                r1 = 0
            L12:
                if (r1 >= r4) goto L26
                r2 = 62
                int r2 = r5.nextInt(r2)
                java.lang.String r3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789"
                char r2 = r3.charAt(r2)
                r0.append(r2)
                int r1 = r1 + 1
                goto L12
            L26:
                java.lang.String r4 = r0.toString()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.activity.MainActivity.o.b(java.util.Random):java.lang.String");
        }

        public String c(Random random) {
            return !"random".equals(this.c) ? this.d : "int".equals(this.b) ? a(random) : b(random);
        }
    }

    public MainActivity() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.W = builder.connectTimeout(10L, timeUnit).readTimeout(10L, timeUnit).writeTimeout(10L, timeUnit).build();
        this.X = new Random();
        this.Y = new Random();
        this.t0 = "";
        this.v0 = new HashMap<Integer, String>() { // from class: com.yunbao.main.activity.MainActivity.8
            {
                put(0, "bindPopTimeMain");
                put(1, "bindPopTimeVideo");
                put(2, "bindPopTimeRecharge");
                put(4, "bindPopTimeMy");
            }
        };
        this.w0 = new HashMap<Integer, String>() { // from class: com.yunbao.main.activity.MainActivity.9
            {
                put(0, "home");
                put(1, "video");
                put(2, "recharge");
                put(4, "my");
            }
        };
        this.x0 = new b();
    }

    public static /* synthetic */ qc4 A1(MainActivity mainActivity, Uri uri, DeepLinkData deepLinkData) {
        mainActivity.getClass();
        lx1.d("9890", "setDeepLinkCallback");
        mainActivity.X2(deepLinkData);
        return null;
    }

    public static /* synthetic */ qc4 B1(MainActivity mainActivity, DeepLinkData deepLinkData) {
        mainActivity.getClass();
        lx1.d("9890", "setDeferredDeepLinkCallback");
        if (deepLinkData == null || deepLinkData.getDeepLinkParameters() == null || !deepLinkData.getDeepLinkParameters().containsKey("share_code")) {
            return null;
        }
        mainActivity.W2((String) deepLinkData.getDeepLinkParameters().get("share_code"));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j2() {
        j30.q().E(new c());
    }

    public static void s2(Context context) {
        t2(context, null);
    }

    public static void t2(Context context, Uri uri) {
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        if (uri != null) {
            intent.setData(uri);
        }
        context.startActivity(intent);
    }

    public final void A2() {
        db2.T(new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B2() {
        Intent intent = getIntent();
        int intExtra = intent.getIntExtra("pushType", 0);
        intent.getStringExtra("pushData");
        if (intExtra == 2 && j30.q().N()) {
            ChatActivity.y1(this.b);
        }
    }

    public final void C2(String str) {
        lx1.c("HeartbeatSocket", "heartbeat_task--->" + str);
        if (TextUtils.isEmpty(str)) {
            b3("empty payload");
            return;
        }
        try {
            JSONObject parseObject = JSON.parseObject(str);
            if (parseObject == null) {
                b3("empty task");
                return;
            }
            if (parseObject.containsKey("enabled") && !parseObject.getBooleanValue("enabled")) {
                b3("disabled by server");
                return;
            }
            synchronized (this.U) {
                this.j0 = str;
            }
            if (D2()) {
                L2("background task updated");
            } else {
                Z2(parseObject);
            }
        } catch (Exception e2) {
            lx1.c("HeartbeatSocket", "heartbeat task parse fail--->" + e2.getMessage());
        }
    }

    public final boolean D2() {
        boolean z;
        synchronized (this.U) {
            z = this.k0;
        }
        return z;
    }

    public final String E2(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 2000) {
            return str;
        }
        return str.substring(0, 2000) + "...(truncated,totalLength=" + str.length() + ")";
    }

    public final void F2(int i2, boolean z) {
        y0 y0Var;
        View view = this.u0;
        if (i2 == 1) {
            view.setBackgroundColor(-16316665);
            this.m.setSelectVideo(true);
        } else {
            view.setBackgroundColor(-1);
            this.m.setSelectVideo(false);
        }
        y0[] y0VarArr = this.u;
        if (y0VarArr == null) {
            return;
        }
        y0 y0Var2 = y0VarArr[i2];
        y0 y0Var3 = y0Var2;
        if (y0Var2 == null) {
            List list = this.o;
            y0Var3 = y0Var2;
            if (list != null) {
                y0Var3 = y0Var2;
                if (i2 < list.size()) {
                    FrameLayout frameLayout = (FrameLayout) this.o.get(i2);
                    if (frameLayout == null) {
                        return;
                    }
                    if (i2 == 0) {
                        cb2 cb2Var = new cb2(this.b, frameLayout);
                        this.p = cb2Var;
                        cb2Var.k0(this);
                        y0Var = this.p;
                    } else if (i2 == 1) {
                        bb2 bb2Var = new bb2(this.b, frameLayout);
                        this.s = bb2Var;
                        y0Var = bb2Var;
                    } else if (i2 == 2) {
                        sb2 sb2Var = new sb2(this.b, frameLayout);
                        this.r = sb2Var;
                        y0Var = sb2Var;
                    } else if (i2 == 3) {
                        cc2 cc2Var = new cc2(this.b, frameLayout);
                        this.S = cc2Var;
                        y0Var = cc2Var;
                    } else {
                        y0Var = y0Var2;
                        if (i2 == 4) {
                            nb2 nb2Var = new nb2(this.b, frameLayout);
                            this.t = nb2Var;
                            y0Var = nb2Var;
                        }
                    }
                    if (y0Var == null) {
                        return;
                    }
                    this.u[i2] = y0Var;
                    y0Var.addToParent();
                    y0Var.subscribeActivityLifeCycle();
                    y0Var3 = y0Var;
                }
            }
        }
        if (!z || y0Var3 == null) {
            return;
        }
        lx1.d("9527", "MainHomeView----Load----position:8888");
        y0Var3.loadData();
    }

    public final void G2() {
        ck1.e().i(j30.q().C());
    }

    public final String H2(String str) {
        return (TextUtils.isEmpty(str) || !"random".equalsIgnoreCase(str.trim())) ? "fixed" : "random";
    }

    public final String I2(String str) {
        return (TextUtils.isEmpty(str) || !"int".equalsIgnoreCase(str.trim())) ? "string" : "int";
    }

    public final o J2(JSONObject jSONObject) {
        String string = jSONObject.getString("key");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        String I2 = I2(jSONObject.getString("type"));
        String H2 = H2(jSONObject.getString("mode"));
        Object obj = jSONObject.get("value");
        return new o(string, I2, H2, obj == null ? "" : String.valueOf(obj), jSONObject.getIntValue("length"), jSONObject.getIntValue("min"), jSONObject.getIntValue("max"));
    }

    public final List K2(JSONObject jSONObject, String str) {
        o J2;
        ArrayList arrayList = new ArrayList();
        Object obj = jSONObject.get(str);
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            for (int i2 = 0; i2 < jSONArray.size(); i2++) {
                Object obj2 = jSONArray.get(i2);
                if ((obj2 instanceof JSONObject) && (J2 = J2((JSONObject) obj2)) != null) {
                    arrayList.add(J2);
                }
            }
        } else if (obj instanceof JSONObject) {
            for (Map.Entry entry : ((JSONObject) obj).entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey())) {
                    Object value = entry.getValue();
                    arrayList.add(new o((String) entry.getKey(), "string", "fixed", value == null ? "" : String.valueOf(value), 0, 0, 0));
                }
            }
        }
        return arrayList;
    }

    public final void L2(String str) {
        r2(str);
        synchronized (this.U) {
            try {
                ScheduledFuture scheduledFuture = this.f0;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    this.f0 = null;
                }
                ScheduledFuture scheduledFuture2 = this.g0;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    this.g0 = null;
                }
                this.i0++;
                g2();
                k2();
                this.V.set(false);
                this.l0 = !TextUtils.isEmpty(this.j0);
            } catch (Throwable th) {
                throw th;
            }
        }
        lx1.c("HeartbeatSocket", "heartbeat task pause reason=" + str);
    }

    @Override // defpackage.qa2
    public void M(boolean z) {
        ObjectAnimator objectAnimator;
        ObjectAnimator objectAnimator2;
        if (this.z) {
            return;
        }
        if (z) {
            if (!this.A || (objectAnimator2 = this.y) == null) {
                return;
            }
            objectAnimator2.start();
            return;
        }
        if (!this.B || (objectAnimator = this.x) == null) {
            return;
        }
        objectAnimator.start();
    }

    public final String M2(Response response) {
        if (response == null || response.body() == null) {
            return "";
        }
        try {
            long contentLength = response.body().getContentLength();
            String string = response.peekBody(IjkMediaMeta.AV_CH_TOP_FRONT_CENTER).string();
            if (contentLength <= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER) {
                return string;
            }
            return string + "...(truncated,contentLength=" + contentLength + ")";
        } catch (Exception e2) {
            return "read response fail:" + e2.getClass().getSimpleName() + ":" + e2.getMessage();
        } catch (OutOfMemoryError unused) {
            return "read response fail:OutOfMemoryError";
        }
    }

    public final void N2(boolean z, int i2, long j2, String str) {
        if (this.m0 == null) {
            return;
        }
        this.o0++;
        if (z) {
            this.p0++;
        } else {
            this.q0++;
        }
        this.s0 += j2;
        this.r0 = i2;
        if (z || str == null) {
            str = "";
        }
        this.t0 = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O2() {
        /*
            r4 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r4.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            r4.I = r0
            if (r0 != 0) goto Ld
            return
        Ld:
            android.net.Network r0 = r0.getActiveNetwork()
            r1 = 0
            r2 = 12
            if (r0 == 0) goto L34
            android.net.ConnectivityManager r0 = r4.I
            android.net.Network r3 = r0.getActiveNetwork()
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r3)
            if (r0 == 0) goto L34
            android.net.ConnectivityManager r0 = r4.I
            android.net.Network r3 = r0.getActiveNetwork()
            android.net.NetworkCapabilities r0 = r0.getNetworkCapabilities(r3)
            boolean r0 = r0.hasCapability(r2)
            if (r0 == 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = r1
        L35:
            android.widget.TextView r3 = r4.H
            if (r0 == 0) goto L3b
            r1 = 8
        L3b:
            r3.setVisibility(r1)
            com.yunbao.main.activity.MainActivity$e r0 = new com.yunbao.main.activity.MainActivity$e
            r0.<init>()
            r4.J = r0
            android.net.NetworkRequest$Builder r0 = new android.net.NetworkRequest$Builder
            r0.<init>()
            android.net.NetworkRequest$Builder r0 = r0.addCapability(r2)
            android.net.NetworkRequest r0 = r0.build()
            android.net.ConnectivityManager r1 = r4.I
            android.net.ConnectivityManager$NetworkCallback r4 = r4.J
            r1.registerNetworkCallback(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.activity.MainActivity.O2():void");
    }

    public final void P2() {
        r2("release");
        synchronized (this.U) {
            try {
                ScheduledFuture scheduledFuture = this.f0;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    this.f0 = null;
                }
                ScheduledFuture scheduledFuture2 = this.g0;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    this.g0 = null;
                }
                this.i0++;
                g2();
                this.j0 = null;
                this.l0 = false;
                ScheduledExecutorService scheduledExecutorService = this.Z;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                    this.Z = null;
                }
                k2();
                this.V.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void Q2() {
        if (j30.q().N()) {
            m2();
            j30.q().C();
            G2();
        }
    }

    public final void R2() {
        this.o0 = 0;
        this.p0 = 0;
        this.q0 = 0;
        this.s0 = 0L;
        this.r0 = 0;
        this.t0 = "";
    }

    public final void S2(Object obj, Object obj2) {
        this.m0 = obj;
        this.n0 = obj2;
        R2();
    }

    public final void T2() {
        synchronized (this.U) {
            if (this.l0 && !TextUtils.isEmpty(this.j0)) {
                this.l0 = false;
                String str = this.j0;
                try {
                    JSONObject parseObject = JSON.parseObject(str);
                    if (parseObject == null) {
                        b3("resume empty task");
                    } else {
                        lx1.c("HeartbeatSocket", "heartbeat task resume from foreground");
                        Z2(parseObject);
                    }
                } catch (Exception e2) {
                    lx1.c("HeartbeatSocket", "heartbeat task resume parse fail--->" + e2.getMessage());
                    b3("resume parse fail");
                }
            }
        }
    }

    public final void U2() {
        ScheduledExecutorService scheduledExecutorService = this.Z;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            this.Z = Executors.newSingleThreadScheduledExecutor();
        }
        ScheduledFuture scheduledFuture = this.g0;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        long nextInt = this.X.nextInt(120001);
        this.g0 = this.Z.scheduleAtFixedRate(new l(), nextInt, 120000L, TimeUnit.MILLISECONDS);
        lx1.c("HeartbeatSocket", "heartbeat result report scheduled initialDelayMs=" + nextInt);
    }

    public void V2(int i2) {
        TabButtonGroup tabButtonGroup = this.m;
        if (tabButtonGroup != null) {
            tabButtonGroup.setCurPosition(i2);
        }
    }

    public final void W2(String str) {
        db2.u0(j30.q().j(), str, new a());
    }

    public final void X2(DeepLinkData deepLinkData) {
        if (deepLinkData == null) {
            lx1.d("9890", "finish");
            return;
        }
        if (deepLinkData.getCustomParameters() != null) {
            lx1.d("9890", "getCustomParameters1" + deepLinkData.getCustomParameters().toString());
            if (deepLinkData.getCustomParameters().containsKey("share_code")) {
                W2((String) deepLinkData.getCustomParameters().get("share_code"));
            }
        }
    }

    public final void Y2() {
        if (j30.q().Q()) {
            t54.a(m93.t0);
        } else if (v31.a(false)) {
            vb2 vb2Var = new vb2();
            vb2Var.w2(this.x0);
            vb2Var.d2(getSupportFragmentManager(), "MainStartDialogFragment");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00e2 A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:29:0x00c9, B:31:0x00cd, B:34:0x00dd, B:36:0x00e2, B:37:0x00e5, B:38:0x0114, B:42:0x00d7), top: B:28:0x00c9 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Z2(com.alibaba.fastjson.JSONObject r20) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.activity.MainActivity.Z2(com.alibaba.fastjson.JSONObject):void");
    }

    public final void a3() {
        if (this.O) {
            return;
        }
        this.O = true;
        if (this.M == null) {
            this.M = new f();
        }
        this.M.run();
    }

    public final void b3(String str) {
        r2(str);
        synchronized (this.U) {
            try {
                ScheduledFuture scheduledFuture = this.f0;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(true);
                    this.f0 = null;
                }
                ScheduledFuture scheduledFuture2 = this.g0;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(true);
                    this.g0 = null;
                }
                this.i0++;
                g2();
                this.j0 = null;
                this.l0 = false;
                k2();
                this.V.set(false);
            } catch (Throwable th) {
                throw th;
            }
        }
        lx1.c("HeartbeatSocket", "heartbeat task stop reason=" + str);
    }

    public final n c2(JSONObject jSONObject, String str) {
        if (!"POST".equals(str)) {
            return new n("none", null, null, null);
        }
        String string = jSONObject.getString("body_type");
        if (!TextUtils.isEmpty(string)) {
            string = string.trim().toLowerCase();
        }
        if ("form".equals(string)) {
            return new n("form", K2(jSONObject, "body_form"), null, "application/x-www-form-urlencoded");
        }
        if ("json".equals(string)) {
            return new n("json", null, jSONObject.getString("body_json"), "application/json");
        }
        if ("none".equals(string)) {
            return new n("none", null, null, null);
        }
        String x2 = x2(jSONObject);
        return new n("json", null, x2, TextUtils.isEmpty(x2) ? null : "application/json; charset=utf-8");
    }

    public final void c3() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.I;
        if (connectivityManager == null || (networkCallback = this.J) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback);
        } catch (Exception unused) {
        }
        this.J = null;
    }

    public final String d2(URL url) {
        StringBuilder sb = new StringBuilder();
        sb.append(url.getProtocol());
        sb.append("://");
        sb.append(url.getHost());
        int port = url.getPort();
        if (port > 0 && port != url.getDefaultPort()) {
            sb.append(':');
            sb.append(port);
        }
        sb.append('/');
        return sb.toString();
    }

    public void d3(LiveBean liveBean, String str, int i2) {
        e3(liveBean, str, i2, true);
    }

    public final String e2(n nVar) {
        if (nVar == null) {
            return null;
        }
        return "form".equals(nVar.a) ? n2(nVar.b, false) : nVar.c;
    }

    public void e3(LiveBean liveBean, String str, int i2, boolean z) {
        if (v31.a(true)) {
            if (this.C == null) {
                this.C = new CheckLivePresenter(this.b);
            }
            this.C.watchLive(liveBean, z);
        }
    }

    public final String f2(String str, List list) {
        String n2 = n2(list, true);
        if (TextUtils.isEmpty(n2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str.contains("?") ? "&" : "?");
        sb.append(n2);
        return sb.toString();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.E;
    }

    public final void g2() {
        Call call = this.h0;
        if (call != null) {
            call.cancel();
            this.h0 = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h2() {
        String a2 = vl0.a(this);
        a2.getClass();
        char c2 = 65535;
        switch (a2.hashCode()) {
            case -1039745817:
                if (a2.equals("normal")) {
                    c2 = 0;
                    break;
                }
                break;
            case 3506402:
                if (a2.equals("root")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1336193813:
                if (a2.equals("emulator")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                lx1.a("DeviceCheck", "正常设备");
                return;
            case 1:
                lx1.a("DeviceCheck", "当前设备已Root");
                return;
            case 2:
                lx1.a("DeviceCheck", "当前设备是模拟器");
                return;
            default:
                return;
        }
    }

    public final void i2() {
    }

    public final void k2() {
        this.m0 = null;
        this.n0 = null;
        R2();
    }

    public final org.json.JSONObject l2() {
        if (this.m0 != null && this.o0 > 0) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("task_id", this.m0);
                Object obj = this.n0;
                if (obj != null) {
                    jSONObject.put("dispatch_id", obj);
                }
                jSONObject.put("total", this.o0);
                jSONObject.put("success", this.p0);
                jSONObject.put("fail", this.q0);
                jSONObject.put("avg_duration_ms", Math.round(((float) this.s0) / this.o0));
                jSONObject.put("last_status_code", this.r0);
                String str = this.t0;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("last_error", str);
                return jSONObject;
            } catch (Exception e2) {
                lx1.c("HeartbeatSocket", "heartbeat result payload build fail--->" + e2.getMessage());
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.video.activity.AbsVideoPlayActivity, com.yunbao.video.activity.AbsVideoCommentActivity, com.yunbao.common.activity.AbsActivity
    public void m1() {
        super.m1();
        LinkFortyWrapper.Companion companion = LinkFortyWrapper.INSTANCE;
        if (!companion.a().getIsInit()) {
            companion.a().initialize(this.b, null);
        }
        getWindow().addFlags(128);
        getWindow().addFlags(8192);
        lx1.d("9528", "MainActivity--onCreate:" + System.currentTimeMillis());
        y0 = this;
        this.F = (AudioManager) this.b.getSystemService("audio");
        this.l = (ViewGroup) findViewById(c73.u4);
        this.H = (TextView) findViewById(c73.U4);
        O2();
        this.u0 = findViewById(c73.z);
        this.Q = (TextView) findViewById(c73.n5);
        TabButtonGroup tabButtonGroup = (TabButtonGroup) findViewById(c73.B4);
        this.m = tabButtonGroup;
        tabButtonGroup.setClickIntercepter(new g());
        this.m.setOnBtnClickListener(new h());
        ViewPager findViewById = findViewById(c73.y5);
        this.n = findViewById;
        findViewById.setOffscreenPageLimit(5);
        this.o = new ArrayList();
        for (int i2 = 0; i2 < 5; i2++) {
            FrameLayout frameLayout = new FrameLayout(this.b);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.o.add(frameLayout);
        }
        this.u = new y0[5];
        bb2 bb2Var = new bb2(this.b, (ViewGroup) this.o.get(1));
        this.s = bb2Var;
        bb2Var.addToParent();
        this.s.subscribeActivityLifeCycle();
        this.s.k0();
        this.u[1] = this.s;
        this.n.setAdapter(new dk4(this.o));
        this.n.c(new i());
        this.m.setViewPager(this.n);
        this.w = zn0.a(70);
        this.v = findViewById(c73.C);
        this.P = findViewById(c73.r0);
        CommonAppContext.n().C();
        View view = this.P;
        if (view != null && view.getVisibility() != 4) {
            this.P.setVisibility(4);
        }
        j30.q().S(false);
        cb2 cb2Var = this.p;
        if (cb2Var != null) {
            cb2Var.q0(true);
        }
        zu0.c().n(this);
        RichText.initCacheDir(this.b);
        A2();
        Q2();
        j30.q().X(true);
        this.D = true;
        i2();
        String I = j30.I();
        String str = "http://127.0.0.1:" + Netshield.getLocalhostPort(I);
        lx1.c("HeartbeatSocket", "init w3 socket ruleName=" + I + ", url=" + str);
        SocketClient socketClient = new SocketClient(str, null);
        this.T = socketClient;
        socketClient.P(true);
        this.T.O(new j());
        this.T.u();
        h2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m2() {
        LinkFortyWrapper.Companion companion = LinkFortyWrapper.INSTANCE;
        companion.a().setDeferredDeepLinkCallback(this.b, new n81() { // from class: ka2
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return MainActivity.B1(MainActivity.this, (DeepLinkData) obj);
            }
        });
        companion.a().setDeepLinkCallback(this.b, new b91() { // from class: la2
            @Override // defpackage.b91
            public final Object invoke(Object obj, Object obj2) {
                return MainActivity.A1(MainActivity.this, (Uri) obj, (DeepLinkData) obj2);
            }
        });
        if (getIntent().getData() != null) {
            companion.a().handleDeepLink(this.b, getIntent().getData());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void mainClick(View view) {
        if (!j30.q().L() && c1()) {
            int id = view.getId();
            if (id == c73.W0) {
                RankActivity.w1(this.b, 0);
                return;
            }
            if (e1()) {
                if (id == c73.j1) {
                    Y2();
                    return;
                }
                if (id == c73.c1) {
                    SearchActivity.E1(this.b);
                    return;
                }
                if (id == c73.L0) {
                    ChatActivity.y1(this.b);
                } else if (id == c73.G) {
                    startActivity(new Intent(this.b, (Class<?>) ActivePubActivity.class));
                } else if (id == c73.E3) {
                    startActivity(new Intent(this.b, (Class<?>) ActivePubActivity.class));
                }
            }
        }
    }

    public final String n2(List list, boolean z) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            if (oVar != null && !TextUtils.isEmpty(oVar.a)) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(o2(oVar.a, z));
                sb.append('=');
                sb.append(o2(oVar.c(this.Y), z));
            }
        }
        return sb.toString();
    }

    public final String o2(String str, boolean z) {
        if (str == null) {
            str = "";
        }
        try {
            String encode = URLEncoder.encode(str, StandardCharsets.UTF_8.name());
            return z ? encode.replace("+", "%20") : encode;
        } catch (Exception unused) {
            return "";
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onAppLifecycleEvent(ka kaVar) {
        if (!kaVar.a()) {
            synchronized (this.U) {
                this.k0 = true;
            }
            L2("app background");
            lx1.d("socket", "555555555555555555");
            return;
        }
        lx1.d("socket", "4444444444444");
        synchronized (this.U) {
            this.k0 = false;
        }
        SocketClient socketClient = this.T;
        if (socketClient != null) {
            socketClient.u();
        }
        T2();
    }

    public void onBackPressed() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.E <= 2000) {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        } else {
            this.E = currentTimeMillis;
            t54.a(m93.i5);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onBindPhoneDialogEvent(hi hiVar) {
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onCloseFloatWindowEvent(n10 n10Var) {
        x31.f().e();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        TabButtonGroup tabButtonGroup = this.m;
        if (tabButtonGroup != null) {
            tabButtonGroup.b();
        }
        Handler handler = this.K;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.K = null;
        P2();
        SocketClient socketClient = this.T;
        if (socketClient != null) {
            socketClient.y();
            this.T = null;
        }
        zu0.c().p(this);
        e32.f("getLiveSdk");
        db2.i(CommonHttpConsts.GET_CONFIG);
        db2.i("requestBonus");
        db2.i("getBonus");
        db2.i("setDistribut");
        db2.i("changeTeenagerTime");
        CheckLivePresenter checkLivePresenter = this.C;
        if (checkLivePresenter != null) {
            checkLivePresenter.cancel();
        }
        j30.q().W(null);
        j30.q().X(false);
        c3();
        m52.c().a();
        gj4.d().a();
        x31.f().e();
        k12.c().e(false);
        k12.c().d();
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImUnReadCountEvent(kk1 kk1Var) {
        lx1.d("9527", "onImUnReadCountEvent：");
        if (j30.q().O()) {
            ik1 h2 = ck1.e().h();
            lx1.d("9527", "未读消息数：" + h2);
            if (h2 != null) {
                String h3 = h2.h();
                lx1.d("9527", "未读消息数11：" + h3);
                boolean equals = h3.equals("0");
                TextView textView = this.Q;
                if (equals) {
                    textView.setVisibility(8);
                    return;
                }
                textView.setText(h3);
                this.Q.setVisibility(0);
                ja2 ja2Var = this.q;
                if (ja2Var != null) {
                    ja2Var.l0(h3);
                }
                nb2 nb2Var = this.t;
                if (nb2Var != null) {
                    nb2Var.q0(h3);
                }
                if (h3.equals("99+")) {
                    this.R = 99;
                } else {
                    this.R = rv3.h(h3, 0);
                }
            }
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 24) {
            AudioManager audioManager = this.F;
            if (audioManager != null) {
                audioManager.adjustStreamVolume(3, 1, 5);
            }
            return true;
        }
        if (i2 != 25) {
            return super.onKeyDown(i2, keyEvent);
        }
        AudioManager audioManager2 = this.F;
        if (audioManager2 != null) {
            audioManager2.adjustStreamVolume(3, -1, 5);
        }
        return true;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveAudienceExitEvent(n02 n02Var) {
        LiveBean b2 = n02Var.b();
        if (b2 != null) {
            x31.f().j(0).i(b2).h(n02Var.a()).g();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveFloatWindowEvent(d22 d22Var) {
        if (d22Var.b() == 0) {
            e3(d22Var.a(), "", 0, false);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLoginChangeEvent(a82 a82Var) {
        this.L = true;
        this.G = a82Var.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onNewIntent(Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
        if (intent != null) {
            if (intent.getData() != null) {
                LinkFortyWrapper.INSTANCE.a().handleDeepLink(this.b, intent.getData());
            }
            if (intent.getBooleanExtra("exit", false)) {
                finish();
                return;
            }
            TabButtonGroup tabButtonGroup = this.m;
            if (tabButtonGroup != null) {
                tabButtonGroup.a(0);
            }
            if (j30.q().Q()) {
                a3();
                return;
            }
            this.O = false;
            Handler handler = this.K;
            if (handler != null) {
                handler.removeCallbacks(this.M);
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onNotificiationLiveEvent(jr2 jr2Var) {
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        int i2 = bundle.getInt("CurrentItem", 0);
        ViewPager viewPager = this.n;
        if (viewPager != null && i2 != viewPager.getCurrentItem()) {
            this.n.M(i2, false);
        }
        TabButtonGroup tabButtonGroup = this.m;
        if (tabButtonGroup != null) {
            tabButtonGroup.setCurPosition(i2);
        }
    }

    @Override // com.yunbao.video.activity.AbsVideoPlayActivity, com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        if (this.D) {
            this.D = false;
            F2(0, true);
            cb2 cb2Var = this.p;
            if (cb2Var != null) {
                cb2Var.setShowed(true);
            }
            B2();
        }
        if (this.L) {
            this.L = false;
            Q2();
        }
        j30.q().Q();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onRouteEvent(oi3 oi3Var) {
        throw null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super/*androidx.activity.ComponentActivity*/.onSaveInstanceState(bundle);
        ViewPager viewPager = this.n;
        if (viewPager != null) {
            bundle.putInt("CurrentItem", viewPager.getCurrentItem());
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onTabPositionEvent(wb2 wb2Var) {
        throw null;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onUpdateCurrentView(IMMessageBean iMMessageBean) {
        lx1.d("9527", "onUpdateCurrentView");
        this.Q.setVisibility(0);
        int i2 = this.R + 1;
        this.R = i2;
        TextView textView = this.Q;
        if (i2 > 99) {
            textView.setText("99+");
            return;
        }
        textView.setText(this.R + "");
    }

    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v7, types: [okhttp3.OkHttpClient] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void p2(int i2, String str, String str2, String str3, List list, List list2, n nVar) {
        String str4;
        long j2;
        Call call;
        boolean z;
        boolean z2;
        if (!this.V.compareAndSet(false, true)) {
            lx1.c("HeartbeatSocket", "heartbeat request skip id=" + str + ", previous request still running");
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        try {
            str4 = f2(str2, list);
            URL url = new URL(str4);
            Request.Builder url2 = new Request.Builder().url(url);
            if (list2 != null) {
                Iterator it = list2.iterator();
                z = false;
                z2 = false;
                while (it.hasNext()) {
                    o oVar = (o) it.next();
                    if (oVar != null && !TextUtils.isEmpty(oVar.a)) {
                        url2.addHeader(oVar.a, oVar.c(this.Y));
                        if ("content-type".equalsIgnoreCase(oVar.a)) {
                            z2 = true;
                        }
                        if (!"referer".equalsIgnoreCase(oVar.a) && !"referrer".equalsIgnoreCase(oVar.a)) {
                        }
                        z = true;
                    }
                }
            } else {
                z = false;
                z2 = false;
            }
            if (!z) {
                url2.header("Referer", d2(url));
            }
            if ("POST".equals(str3)) {
                String e2 = e2(nVar);
                String str5 = nVar == null ? null : nVar.d;
                if (z2 || TextUtils.isEmpty(str5)) {
                    str5 = null;
                }
                url2.post(RequestBody.create(TextUtils.isEmpty(str5) ? null : MediaType.parse(str5), TextUtils.isEmpty(e2) ? new byte[0] : e2.getBytes(StandardCharsets.UTF_8)));
            } else {
                url2.get();
            }
            Request build = url2.build();
            ?? r3 = this.W;
            Call newCall = r3.newCall(build);
            try {
                synchronized (this.U) {
                    try {
                        try {
                            if (i2 != this.i0) {
                                this.V.set(false);
                                newCall.cancel();
                                return;
                            }
                            this.h0 = newCall;
                            lx1.c("HeartbeatSocket", "heartbeat request enqueue id=" + str + ", method=" + str3 + ", url=" + str4);
                            try {
                                newCall.enqueue(new m(elapsedRealtime, i2, str));
                            } catch (Exception e3) {
                                e = e3;
                                r3 = elapsedRealtime;
                                str4 = str;
                                call = newCall;
                                j2 = r3;
                                if (call != null) {
                                    call.cancel();
                                }
                                long elapsedRealtime2 = SystemClock.elapsedRealtime() - j2;
                                String str6 = e.getClass().getSimpleName() + ":" + e.getMessage();
                                if (q2(i2, null, false, 0, elapsedRealtime2, str6)) {
                                    lx1.c("HeartbeatSocket", "heartbeat request fail id=" + str4 + ", durationMs=" + elapsedRealtime2 + ", error=" + str6);
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } finally {
                        th = th;
                        while (true) {
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        }
                    }
                }
            } catch (Exception e5) {
                e = e5;
                str4 = str;
                r3 = elapsedRealtime;
            }
        } catch (Exception e6) {
            e = e6;
            str4 = str;
            j2 = elapsedRealtime;
            call = null;
        }
    }

    public final boolean q2(int i2, Call call, boolean z, int i3, long j2, String str) {
        synchronized (this.U) {
            try {
                if (i2 != this.i0) {
                    return false;
                }
                if (call != null && call != this.h0) {
                    return false;
                }
                if (call == null && this.h0 != null) {
                    return false;
                }
                if (call != null) {
                    this.h0 = null;
                }
                this.V.set(false);
                N2(z, i3, j2, str);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void r2(String str) {
        org.json.JSONObject l2;
        SocketClient socketClient;
        synchronized (this.U) {
            try {
                l2 = l2();
                if (l2 != null) {
                    R2();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (l2 == null || (socketClient = this.T) == null) {
            return;
        }
        socketClient.L(l2);
        lx1.c("HeartbeatSocket", "heartbeat result flush reason=" + str + ", payload=" + l2);
    }

    public final void u2(JSONObject jSONObject) {
        String string = jSONObject.getString("liveban_title");
        System.out.println("obj.getIntValue(\"live_sdk\")---" + jSONObject.getIntValue("live_sdk"));
        LiveAnchorActivity.r3(this.b, jSONObject.getIntValue("live_sdk"), null, 0, false, string, true);
    }

    public final void v2(JSONObject jSONObject) {
        int intValue = jSONObject.getIntValue("isshop");
        String string = jSONObject.getString("liveban_title");
        int intValue2 = jSONObject.getIntValue("live_sdk");
        LiveAnchorActivity.r3(this.b, intValue2, intValue2 == 1 ? (LiveConfigBean) JSON.parseObject(jSONObject.getString("android_tx"), LiveConfigBean.class) : null, intValue, true, string, false);
    }

    public int w2() {
        return this.n.getCurrentItem();
    }

    public final String x2(JSONObject jSONObject) {
        Object obj = jSONObject.get("body");
        if (obj == null) {
            return null;
        }
        return obj instanceof String ? (String) obj : JSON.toJSONString(obj);
    }

    public final Object y2(JSONObject jSONObject, String str, String str2, Object obj) {
        Object obj2 = jSONObject.get(str);
        if (obj2 == null && !TextUtils.isEmpty(str2)) {
            obj2 = jSONObject.get(str2);
        }
        return obj2 == null ? obj : obj2;
    }

    public final String z2(JSONObject jSONObject, String str, String str2, String str3) {
        String string = jSONObject.getString(str);
        if (TextUtils.isEmpty(string) && !TextUtils.isEmpty(str2)) {
            string = jSONObject.getString(str2);
        }
        return TextUtils.isEmpty(string) ? str3 : string;
    }
}
