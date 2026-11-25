package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.netshield.Netshield;
import com.yunbao.common.activity.AbsActivity;
import defpackage.b5;
import defpackage.c73;
import defpackage.j30;
import defpackage.lx1;
import defpackage.s4;
import defpackage.y73;
import defpackage.zm4;
import defpackage.zn0;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class FamilyActivity extends AbsActivity {
    public ProgressBar e;
    public WebView f;
    public View g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: com.yunbao.main.activity.FamilyActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0047a extends s4 {
            public C0047a() {
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                FamilyActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b5.a(FamilyActivity.this, new Intent(FamilyActivity.this.b, (Class<?>) FamilyApplyActivity.class), new C0047a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends WebViewClient {
        public b() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            FamilyActivity.this.t1(webView.getTitle());
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            lx1.b("H5-----onPageStarted--->" + str);
            if (TextUtils.isEmpty(str) || !str.contains(com.umeng.ccg.a.H)) {
                if (FamilyActivity.this.g == null || FamilyActivity.this.g.getVisibility() != 0) {
                    return;
                }
                FamilyActivity.this.g.setVisibility(4);
                return;
            }
            if (FamilyActivity.this.g == null || FamilyActivity.this.g.getVisibility() == 0) {
                return;
            }
            FamilyActivity.this.g.setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            lx1.b("H5-------->" + str);
            if (!str.startsWith("familyindex://")) {
                webView.loadUrl(str);
                return true;
            }
            FamilyActivity.C1(FamilyActivity.this.b, str.substring(14).replace("host", j30.o()));
            FamilyActivity.this.finish();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends WebChromeClient {
        public c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            FamilyActivity familyActivity = FamilyActivity.this;
            if (i == 100) {
                familyActivity.e.setVisibility(8);
            } else {
                familyActivity.e.setProgress(i);
            }
        }
    }

    public static void C1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) FamilyActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        context.startActivity(intent);
    }

    private boolean D1() {
        WebView webView = this.f;
        if (webView == null) {
            return false;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        return url.contains("Family/home");
    }

    public boolean B1() {
        WebView webView = this.f;
        return webView != null && webView.canGoBack();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        View view;
        View findViewById = findViewById(c73.d0);
        this.g = findViewById;
        findViewById.setOnClickListener(new a());
        String p = j30.p(getIntent().getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        lx1.b("H5--->" + p);
        if (p.contains("com/")) {
            String[] split = p.split("com/");
            p = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + "/" + split[1];
        }
        lx1.b("H5后--->".concat(p));
        if (!TextUtils.isEmpty(p) && p.contains(com.umeng.ccg.a.H) && (view = this.g) != null && view.getVisibility() != 0) {
            this.g.setVisibility(0);
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(c73.v4);
        this.e = (ProgressBar) findViewById(c73.a4);
        this.f = new WebView(this.b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = zn0.a(1);
        this.f.setLayoutParams(layoutParams);
        this.f.setOverScrollMode(2);
        linearLayout.addView(this.f);
        this.f.setWebViewClient(new b());
        this.f.setWebChromeClient(new c());
        WebSettings settings = this.f.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        this.f.loadUrl(p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (D1()) {
            finish();
        } else if (B1()) {
            this.f.goBack();
        } else {
            finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        WebView webView = this.f;
        if (webView != null) {
            zm4.b(webView);
            this.f = null;
        }
        super.onDestroy();
    }
}
