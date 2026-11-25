package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import defpackage.aq4;
import defpackage.c73;
import defpackage.ck1;
import defpackage.db2;
import defpackage.j30;
import defpackage.lc4;
import defpackage.lx1;
import defpackage.m93;
import defpackage.t54;
import defpackage.y63;
import defpackage.y73;
import defpackage.zm4;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class CancelAccountActivity extends AbsActivity implements View.OnClickListener {
    public ProgressBar e;
    public WebView f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            webView.loadUrl(str);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            CancelAccountActivity cancelAccountActivity = CancelAccountActivity.this;
            if (i == 100) {
                cancelAccountActivity.e.setVisibility(8);
            } else {
                cancelAccountActivity.e.setProgress(i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    CancelAccountActivity.this.finish();
                    j30.q().b();
                    ck1.e().j();
                    lc4.c();
                    MainActivity.s2(CancelAccountActivity.this.b);
                }
                t54.b(str);
            }
        }

        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            db2.j(new a());
        }
    }

    public static void z1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CancelAccountActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.T0));
        findViewById(c73.c0).setOnClickListener(this);
        findViewById(c73.N).setOnClickListener(this);
        String p = j30.p(getIntent().getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        lx1.b("H5--->" + p);
        this.e = (ProgressBar) findViewById(y63.X);
        WebView webView = new WebView(this.b);
        this.f = webView;
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f.setOverScrollMode(2);
        ((ViewGroup) findViewById(c73.I1)).addView(this.f);
        this.f.setWebViewClient(new a());
        this.f.setWebChromeClient(new b());
        WebSettings settings = this.f.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        this.f.loadUrl(p);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == c73.c0) {
            y1();
        } else if (id == c73.N) {
            finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("cancelAccount");
        WebView webView = this.f;
        if (webView != null) {
            zm4.b(webView);
            this.f = null;
        }
        super.onDestroy();
    }

    public final void y1() {
        new a.j(this.b).k(aq4.a(m93.U0)).d(true).g(true).h(new c()).c().show();
    }
}
