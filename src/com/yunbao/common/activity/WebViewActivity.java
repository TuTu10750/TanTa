package com.yunbao.common.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.netshield.Netshield;
import defpackage.an1;
import defpackage.ig4;
import defpackage.j30;
import defpackage.lx1;
import defpackage.m93;
import defpackage.pi3;
import defpackage.t54;
import defpackage.u73;
import defpackage.wq1;
import defpackage.y63;
import defpackage.zj2;
import defpackage.zm4;
import defpackage.zn0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class WebViewActivity extends AbsActivity {
    public ProgressBar e;
    public ProgressBar f;
    public WebView g;
    public final int h = 8001;
    public final int i = 8002;
    public String j = "";
    public Map k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            WebViewActivity.this.f.setVisibility(8);
            if (WebViewActivity.this.j.isEmpty()) {
                WebViewActivity.this.t1(webView.getTitle());
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            lx1.b("H5-------->" + str);
            if (str.startsWith("copy://")) {
                String substring = str.substring(7);
                if (!TextUtils.isEmpty(substring)) {
                    WebViewActivity.this.D1(substring);
                }
            } else if (str.startsWith("tel://")) {
                String substring2 = str.substring(6);
                if (!TextUtils.isEmpty(substring2)) {
                    WebViewActivity.this.B1(substring2);
                }
            } else if (str.startsWith("auth://")) {
                pi3.d(WebViewActivity.this, 8001);
            } else {
                if (!str.startsWith("http")) {
                    try {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        WebViewActivity.this.startActivity(intent);
                        WebViewActivity.this.finish();
                        return true;
                    } catch (Exception unused) {
                        t54.b("未安装该应用");
                        return true;
                    }
                }
                webView.loadUrl(str, WebViewActivity.this.k);
            }
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
            WebViewActivity webViewActivity = WebViewActivity.this;
            if (i == 100) {
                webViewActivity.e.setVisibility(8);
            } else {
                webViewActivity.e.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            zj2.k(WebViewActivity.this, false, new a(valueCallback));
            return true;
        }
    }

    public static void E1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        context.startActivity(intent);
    }

    public static void F1(Context context, String str, String str2) {
        Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        intent.putExtra("title", str2);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B1(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:" + str));
        startActivity(intent);
    }

    public boolean C1() {
        WebView webView = this.g;
        return webView != null && webView.canGoBack();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1(String str) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
        t54.a(m93.u1);
    }

    public final boolean G1() {
        WebView webView = this.g;
        if (webView == null) {
            return false;
        }
        String url = webView.getUrl();
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        return url.contains("appapi/Auth/succ");
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        String p = j30.p(intent.getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        if (intent.hasExtra("title")) {
            String stringExtra = intent.getStringExtra("title");
            this.j = stringExtra;
            t1(stringExtra);
        }
        lx1.b("H5--->" + p);
        String site = j30.q().h().getSite();
        System.out.println("site----" + site);
        String[] split = p.split(site);
        if (p.contains(site) && split.length > 1) {
            p = "http://127.0.0.1:" + Netshield.getLocalhostPort(j30.G()) + split[1];
        }
        lx1.b("H5后--->".concat(p));
        LinearLayout linearLayout = (LinearLayout) findViewById(y63.c0);
        this.e = (ProgressBar) findViewById(y63.X);
        this.f = (ProgressBar) findViewById(y63.u);
        WebView webView = new WebView(this.b);
        this.g = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setMixedContentMode(2);
        settings.setUserAgentString(settings.getUserAgentString() + "AppWebView/1.0");
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setAcceptThirdPartyCookies(this.g, true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = zn0.a(1);
        this.g.setLayoutParams(layoutParams);
        this.g.setOverScrollMode(2);
        linearLayout.addView(this.g);
        this.g.setWebViewClient(new a());
        this.g.setWebChromeClient(new b());
        WebSettings settings2 = this.g.getSettings();
        settings2.setJavaScriptEnabled(true);
        settings2.setMixedContentMode(0);
        this.g.addJavascriptInterface(new wq1(this), "Android");
        HashMap hashMap = new HashMap();
        this.k = hashMap;
        hashMap.put("X-App-Version", ig4.b() + "");
        this.k.put("X-App-Source", "android");
        this.g.loadUrl(p, this.k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if ((i == 8001 || i == 8002) && i2 == -1) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (G1()) {
            finish();
        } else if (C1()) {
            this.g.goBack();
        } else {
            finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        WebView webView = this.g;
        if (webView != null) {
            zm4.b(webView);
            this.g = null;
        }
        super.onDestroy();
    }
}
