package com.yunbao.main.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.netshield.Netshield;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import defpackage.an1;
import defpackage.c73;
import defpackage.db2;
import defpackage.j30;
import defpackage.k52;
import defpackage.kn1;
import defpackage.lx1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.t54;
import defpackage.vx2;
import defpackage.y73;
import defpackage.yx2;
import defpackage.zj2;
import defpackage.zm4;
import defpackage.zn0;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ThreeDistributActivity extends AbsActivity implements View.OnClickListener, k52.a {
    public ProgressBar e;
    public WebView f;
    public TextView g;
    public View h;
    public ImageView i;
    public File j;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            ThreeDistributActivity.this.t1(webView.getTitle());
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            lx1.b("H5-------->" + str);
            if (!str.startsWith("copy://")) {
                webView.loadUrl(str);
                return true;
            }
            String substring = str.substring(7);
            if (TextUtils.isEmpty(substring)) {
                return true;
            }
            ThreeDistributActivity.this.G1(substring);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends WebChromeClient {

        /* loaded from: /tmp/classes2.dex */
        public class a implements an1 {
            public final /* synthetic */ ValueCallback a;

            public a(ValueCallback valueCallback) {
                this.a = valueCallback;
            }

            @Override // defpackage.an1
            public void a(File file) {
                this.a.onReceiveValue(new Uri[]{Uri.fromFile(file)});
            }

            @Override // defpackage.an1
            public void b() {
                this.a.onReceiveValue(null);
            }

            @Override // defpackage.an1
            public void c() {
            }
        }

        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ThreeDistributActivity threeDistributActivity = ThreeDistributActivity.this;
            if (i == 100) {
                threeDistributActivity.e.setVisibility(8);
            } else {
                threeDistributActivity.e.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            zj2.k(ThreeDistributActivity.this, false, new a(valueCallback));
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (ThreeDistributActivity.this.g != null) {
                ThreeDistributActivity.this.g.setText(parseObject.getString(cl.g));
            }
            if (ThreeDistributActivity.this.i != null) {
                kn1.f(ThreeDistributActivity.this.b, parseObject.getString("qr"), ThreeDistributActivity.this.i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends vx2 {
        public d() {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // defpackage.vx2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 338
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.activity.ThreeDistributActivity.d.a():void");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void G1(String str) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
        t54.a(m93.u1);
    }

    public static void H1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) ThreeDistributActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str2);
        intent.putExtra("tip", str);
        context.startActivity(intent);
    }

    private boolean I1() {
        WebView webView = this.f;
        if (webView != null) {
            String url = webView.getUrl();
            if (!TextUtils.isEmpty(url)) {
                return url.contains("g=appapi&m=Auth&a=success") || url.contains("g=appapi&m=Family&a=home");
            }
        }
        return false;
    }

    public boolean F1() {
        WebView webView = this.f;
        return webView != null && webView.canGoBack();
    }

    public final void J1() {
        yx2.a(this, new d(), zj2.u());
    }

    @Override // k52.a
    public void c0(String str) {
        File file = this.j;
        if (file != null) {
            file.exists();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.W;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        t1(intent.getStringExtra("tip"));
        this.h = findViewById(c73.y4);
        ImageView imageView = (ImageView) findViewById(c73.j);
        TextView textView = (TextView) findViewById(c73.k);
        j30 q = j30.q();
        imageView.setImageResource(q.d());
        textView.setText(q.e());
        ImageView imageView2 = (ImageView) findViewById(c73.l);
        TextView textView2 = (TextView) findViewById(c73.L3);
        TextView textView3 = (TextView) findViewById(c73.H2);
        this.g = (TextView) findViewById(c73.h3);
        this.i = (ImageView) findViewById(c73.b4);
        findViewById(c73.f1).setOnClickListener(this);
        UserBean D = q.D();
        if (D != null) {
            kn1.g(this.b, D.getAvatar(), imageView2);
            textView2.setText(D.getUserNiceName());
            textView3.setText(rv3.a("ID:", D.getId()));
        }
        String p = j30.p(intent.getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        if (p.contains("com/")) {
            String[] split = p.split("com/");
            p = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/" + split[1];
        }
        lx1.b("H5--->".concat(p));
        LinearLayout linearLayout = (LinearLayout) findViewById(c73.I1);
        this.e = (ProgressBar) findViewById(c73.a4);
        this.f = new WebView(this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = zn0.a(1);
        this.f.setLayoutParams(layoutParams);
        this.f.setOverScrollMode(2);
        linearLayout.addView(this.f);
        this.f.setWebViewClient(new a());
        this.f.setWebChromeClient(new b());
        WebSettings settings = this.f.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        this.f.loadUrl(p);
        db2.V(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (I1()) {
            finish();
        } else if (F1()) {
            this.f.goBack();
        } else {
            finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == c73.f1) {
            J1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getQrCode");
        WebView webView = this.f;
        if (webView != null) {
            zm4.b(webView);
            this.f = null;
        }
        super.onDestroy();
    }
}
