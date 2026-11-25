package com.yunbao.phonelive.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.k;
import androidx.media3.common.p;
import androidx.media3.common.y;
import androidx.media3.ui.PlayerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netshield.Netshield;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.AdBean;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CircleProgress;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.FileDownloadCallback;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.LinkFortyWrapper;
import com.yunbao.main.activity.MainActivity;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.a83;
import defpackage.aq4;
import defpackage.bs3;
import defpackage.d93;
import defpackage.db2;
import defpackage.e73;
import defpackage.fa2;
import defpackage.j30;
import defpackage.k30;
import defpackage.kn1;
import defpackage.lx1;
import defpackage.t54;
import defpackage.tx1;
import defpackage.yn0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {
    public Handler a;
    public Context b;
    public ViewGroup c;
    public ConstraintLayout d;
    public ViewGroup e;
    public CircleProgress f;
    public List g;
    public List h;
    public int i;
    public int j;
    public int k;
    public int l = 2000;
    public View m;
    public View n;
    public tx1 o;
    public boolean p;
    public boolean q;
    public boolean r;
    public View s;
    public TextView t;
    public yn0 u;
    public nw0 v;
    public PlayerView w;

    /* loaded from: /tmp/classes2.dex */
    public class a extends FileDownloadCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.FileDownloadCallback
        public void onError(Throwable th) {
            if (LauncherActivity.this.a != null && LauncherActivity.this.a.hasMessages(3)) {
                LauncherActivity.this.a.removeMessages(3);
            }
            LauncherActivity.this.w1();
        }

        @Override // com.yunbao.common.http.FileDownloadCallback
        public void onSuccess(File file) {
            if (LauncherActivity.this.a == null || !LauncherActivity.this.a.hasMessages(3)) {
                return;
            }
            LauncherActivity.this.a.removeMessages(3);
            LauncherActivity.this.A1(file);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements kn1.a {
        public final /* synthetic */ ImageView a;

        public b(ImageView imageView) {
            this.a = imageView;
        }

        @Override // kn1.a
        public void onLoadFailed() {
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            this.a.setImageDrawable(drawable);
            if (LauncherActivity.this.d == null || LauncherActivity.this.d.getVisibility() != 0) {
                return;
            }
            LauncherActivity.this.d.setVisibility(4);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements p.d {
        public c() {
        }

        public void E(int i) {
            if (i != 3) {
                if (i != 4) {
                    return;
                }
                LauncherActivity.this.w1();
                lx1.c("LauncherActivity", "视频播放结束------>");
                return;
            }
            if (LauncherActivity.this.d == null || LauncherActivity.this.d.getVisibility() != 0) {
                return;
            }
            LauncherActivity.this.d.setVisibility(4);
        }

        public void b0(PlaybackException playbackException) {
            t54.b(aq4.a(d93.a));
            LauncherActivity.this.w1();
        }

        public void i(y yVar) {
            int i;
            if (LauncherActivity.this.w == null) {
                return;
            }
            int i2 = yVar.a;
            int i3 = yVar.b;
            if (i2 <= 0 || i3 <= 0) {
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) LauncherActivity.this.w.getLayoutParams();
            if (i2 >= i3) {
                layoutParams.gravity = 16;
                i = (LauncherActivity.this.w.getWidth() / i2) * i3;
            } else {
                i = -1;
            }
            if (i != layoutParams.height) {
                layoutParams.height = i;
                LauncherActivity.this.w.requestLayout();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                LauncherActivity.this.t.setText("选择最优路线中...");
                lx1.d("9528", "WHAT_GET_CONFIG:" + System.currentTimeMillis());
                int localhostPort = Netshield.getLocalhostPort(j30.G());
                lx1.d("9528", "localPort:" + localhostPort);
                if (localhostPort != -1) {
                    LauncherActivity.this.t1();
                    return;
                }
                return;
            }
            if (i == 1) {
                lx1.d("9528", "WHAT_COUNT_DOWN:" + System.currentTimeMillis());
                LauncherActivity.this.E1();
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                lx1.c("LauncherActivity", "Video download timeout, skipping to main activity.");
                if (LauncherActivity.this.u != null) {
                    LauncherActivity.this.u.a();
                    LauncherActivity.this.u = null;
                }
                LauncherActivity.this.w1();
                return;
            }
            Intent intent = new Intent(LauncherActivity.this.b, (Class<?>) RebootActivity.class);
            intent.setFlags(268435456);
            t54.b("重启App");
            LauncherActivity.this.startActivity(intent);
            LauncherActivity.this.finish();
            LauncherActivity.this.finishAffinity();
            Process.killProcess(Process.myPid());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i("9523", "Thread11:" + System.currentTimeMillis());
            int startService = Netshield.startService("998", "de62d3e947ab10496b1c9090915d2d04");
            Log.d("9523", "Client code: " + startService);
            if (startService != 0) {
                Log.e("9523", "SDK初始化失败");
                return;
            }
            Log.d("9523", "Client IP: " + Netshield.getClientIP());
            j30.o();
            LinkFortyWrapper.INSTANCE.a().initialize(CommonAppContext.n(), null);
            if (LauncherActivity.this.a != null) {
                LauncherActivity.this.a.sendEmptyMessage(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (parseObject.getIntValue("switch") != 1) {
                LauncherActivity.this.w1();
                return;
            }
            List parseArray = JSON.parseArray(parseObject.getString("list"), AdBean.class);
            if (parseArray == null || parseArray.size() <= 0) {
                LauncherActivity.this.w1();
                return;
            }
            LauncherActivity.this.g = parseArray;
            LauncherActivity.this.l = parseObject.getIntValue(DeepLinkPresetEvent.UMEventParamTime) * IjkMediaCodecInfo.RANK_MAX;
            if (LauncherActivity.this.e != null) {
                LauncherActivity.this.e.setOnClickListener(LauncherActivity.this);
            }
            int intValue = parseObject.getIntValue("type");
            LauncherActivity launcherActivity = LauncherActivity.this;
            if (intValue != 0) {
                launcherActivity.B1(((AdBean) parseArray.get(0)).getUrl());
            } else {
                launcherActivity.z1(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends k30 {
        public g() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ConfigBean configBean) {
            LauncherActivity.this.v1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends k30 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public h(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            if (userBean != null) {
                j30.q().Z(this.a, this.b, false);
                LauncherActivity.this.x1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j30.q().b();
            LauncherActivity.this.x1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a extends k30 {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(UserBean userBean) {
                lx1.d("9528", "getBaseInfo:" + System.currentTimeMillis());
                if (userBean != null) {
                    bs3.d().p("txImUserSign", userBean.getUserSig());
                    j30.q().Z(this.a, this.b, false);
                    LauncherActivity.this.x1();
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j30.q().b();
                LauncherActivity.this.x1();
            }
        }

        public j() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr == null || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("uid");
            String string2 = parseObject.getString("token");
            CommonHttpUtil.deviceCheck(LauncherActivity.this.b, string, string2);
            db2.F(string, string2, new a(string, string2), new b());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements tx1.c {
        public k() {
        }

        @Override // tx1.c
        public void a() {
            LauncherActivity.this.w1();
        }
    }

    private void X0() {
        Log.i("9523", "init:" + System.currentTimeMillis());
        new Thread(new e()).start();
    }

    public final void A1(File file) {
        View view = this.n;
        if (view != null && view.getVisibility() != 0) {
            this.n.setVisibility(0);
        }
        nw0 g2 = new b(this.b).i(new androidx.media3.exoplayer.source.d(this.b).k(pg4.i(this.b))).g();
        this.v = g2;
        g2.y(al3.d);
        PlayerView playerView = new PlayerView(this.b);
        this.w = playerView;
        playerView.setPlayer(this.v);
        this.w.setUseController(false);
        this.w.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.e.addView(this.w);
        this.v.d(true);
        this.v.P(2);
        this.v.g(2);
        this.v.T(new c());
        this.v.G(new k.c().h(file.getAbsolutePath()).a());
        this.v.a();
        this.v.h();
        s1(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(String str) {
        if (TextUtils.isEmpty(str)) {
            w1();
            return;
        }
        String a2 = fa2.a(str);
        if (TextUtils.isEmpty(a2)) {
            w1();
            return;
        }
        File file = new File(getCacheDir(), a2);
        if (file.exists()) {
            A1(file);
            return;
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(3, 5000L);
        }
        yn0 yn0Var = new yn0("ad_video");
        this.u = yn0Var;
        yn0Var.c(getCacheDir(), a2, str, new a());
    }

    public final void C1() {
        View view = this.w;
        nw0 nw0Var = this.v;
        this.w = null;
        this.v = null;
        if (view != null) {
            try {
                view.setPlayer((p) null);
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Exception unused) {
            }
        }
        if (nw0Var != null) {
            try {
                nw0Var.stop();
            } catch (Exception unused2) {
            }
            nw0Var.release();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(9472);
        window.addFlags(ImageHolder.WRAP_CONTENT);
        window.setStatusBarColor(0);
    }

    public final void E1() {
        int i2;
        int i3 = this.j + 100;
        this.j = i3;
        if (i3 > this.i) {
            return;
        }
        CircleProgress circleProgress = this.f;
        if (circleProgress != null) {
            circleProgress.setCurProgress(i3);
        }
        int i4 = this.j / this.l;
        if (i4 < this.g.size() && (i2 = this.k) != i4) {
            View view = (View) this.h.get(i2);
            if (view != null && view.getVisibility() == 0) {
                view.setVisibility(4);
            }
            this.k = i4;
            s1(i4);
        }
        int i5 = this.j;
        int i6 = this.i;
        if (i5 >= i6) {
            if (i5 == i6) {
                w1();
            }
        } else {
            Handler handler = this.a;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 100L);
            }
        }
    }

    public void onBackPressed() {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.a = null;
        }
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != e73.b && id != e73.c) {
            if (id == e73.d) {
                u1();
                return;
            }
            return;
        }
        View view2 = this.m;
        if (view2 != null) {
            view2.setClickable(false);
        }
        View view3 = this.n;
        if (view3 != null) {
            view3.setClickable(false);
        }
        w1();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i2 = configuration.orientation;
        if (i2 == 1) {
            lx1.d("9528", "竖屏操作");
        } else if (i2 == 2) {
            lx1.d("9528", "横屏操作");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        setContentView(a83.a);
        Intent intent = getIntent();
        if (!isTaskRoot() && intent != null && intent.hasCategory("android.intent.category.LAUNCHER") && intent.getAction() != null && intent.getAction().equals("android.intent.action.MAIN")) {
            lx1.d("9523", "finish");
            finish();
            return;
        }
        D1();
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        this.b = this;
        this.t = (TextView) findViewById(e73.h);
        this.c = (ViewGroup) findViewById(e73.g);
        this.d = findViewById(e73.e);
        this.f = (CircleProgress) findViewById(e73.f);
        this.e = (ViewGroup) findViewById(e73.d);
        this.m = findViewById(e73.b);
        this.n = findViewById(e73.c);
        this.m.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.s = findViewById(e73.a);
        this.a = new d(Looper.getMainLooper());
        this.t.setText("初始化中...");
        X0();
    }

    public void onDestroy() {
        lx1.d("9528", "LauncherActivity---onDestroy");
        y1();
        lx1.c("LauncherActivity", "----------> onDestroy");
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
    }

    public void onPause() {
        lx1.d("9528", "LauncherActivity---onPause");
        this.p = true;
        nw0 nw0Var = this.v;
        if (nw0Var != null && nw0Var.isPlaying()) {
            this.v.pause();
        }
        Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(2);
        }
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
    }

    public void onResume() {
        nw0 nw0Var;
        lx1.d("9528", "LauncherActivity---onResume");
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        if (this.p && (nw0Var = this.v) != null && nw0Var.isPlaying()) {
            this.v.h();
        }
        this.p = false;
        Handler handler = this.a;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(2, 8000L);
        }
    }

    public final void s1(int i2) {
        if (i2 < 0 || i2 >= this.g.size()) {
            return;
        }
        AdBean adBean = (AdBean) this.g.get(i2);
        if (adBean == null || TextUtils.isEmpty(adBean.getLink())) {
            if (this.s.getVisibility() == 0) {
                this.s.setVisibility(4);
            }
        } else if (this.s.getVisibility() != 0) {
            this.s.setVisibility(0);
        }
    }

    public final void t1() {
        Handler handler = this.a;
        if (handler != null) {
            handler.removeMessages(2);
        }
        lx1.d("9528", "checkUidAndToken:" + System.currentTimeMillis());
        if (this.q) {
            return;
        }
        this.q = true;
        String[] f2 = bs3.d().f("uid", "token");
        String str = f2[0];
        String str2 = f2[1];
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (j30.q().N()) {
                db2.F(str, str2, new h(str, str2), new i());
                return;
            } else {
                x1();
                return;
            }
        }
        this.t.setText("正在为您创建角色...");
        lx1.d("9528", "getAuth:" + System.currentTimeMillis());
        CommonHttpUtil.getAuth(j30.q().j(), new j());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u1() {
        AdBean adBean;
        List list = this.g;
        if (list != null) {
            int size = list.size();
            int i2 = this.k;
            if (size <= i2 || (adBean = (AdBean) this.g.get(i2)) == null) {
                return;
            }
            String link = adBean.getLink();
            if (TextUtils.isEmpty(link)) {
                return;
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            C1();
            if (adBean.getTarget() == 0 || adBean.getTarget() == 2) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(link));
                startActivity(intent);
                return;
            }
            if (adBean.getTarget() == 1 && this.o == null) {
                tx1 tx1Var = new tx1(this.b, this.c, link);
                this.o = tx1Var;
                tx1Var.addToParent();
                this.o.loadData();
                this.o.show();
                this.o.f0(new k());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v1() {
        lx1.d("9528", "forwardMainActivity:" + System.currentTimeMillis());
        C1();
        MainActivity.t2(this.b, getIntent().getData());
        y1();
        finish();
    }

    public final void w1() {
        this.t.setText("正在获取配置信息...");
        lx1.d("9528", "getConfig:" + System.currentTimeMillis());
        CommonHttpUtil.getConfig(new g());
    }

    public final void x1() {
        CommonHttpUtil.getGuide(new f());
    }

    public final void y1() {
        if (this.r) {
            return;
        }
        this.r = true;
        Handler handler = this.a;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.a = null;
        }
        yn0 yn0Var = this.u;
        if (yn0Var != null) {
            yn0Var.a();
            this.u = null;
        }
        db2.i("getBaseInfo");
        CommonHttpUtil.cancel(CommonHttpConsts.GET_CONFIG);
        C1();
        tx1 tx1Var = this.o;
        if (tx1Var != null) {
            tx1Var.release();
        }
        this.o = null;
    }

    public final void z1(boolean z) {
        if (this.e != null && z) {
            int size = this.g.size();
            if (size <= 0) {
                w1();
                return;
            }
            this.h = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                ImageView imageView = new ImageView(this.b);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setBackgroundColor(-1);
                this.h.add(imageView);
                kn1.j(this.b, ((AdBean) this.g.get(i2)).getUrl(), new b(imageView));
            }
            for (int i3 = size - 1; i3 >= 0; i3--) {
                this.e.addView((View) this.h.get(i3));
            }
            View view = this.m;
            if (view != null && view.getVisibility() != 0) {
                this.m.setVisibility(0);
            }
            int i4 = size * this.l;
            this.i = i4;
            CircleProgress circleProgress = this.f;
            if (circleProgress != null) {
                circleProgress.setMaxProgress(i4);
            }
            Handler handler = this.a;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 100L);
            }
            s1(0);
        }
    }
}
