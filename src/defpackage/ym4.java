package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.zzhoujay.richtext.ImageHolder;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ym4 extends l0 {
    public String A0;
    public WebView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ym4.this.S1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends WebViewClient {
        public final /* synthetic */ TextView a;

        public b(TextView textView) {
            this.a = textView;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            TextView textView = this.a;
            if (textView != null) {
                textView.setText(webView.getTitle());
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            lx1.b("H5-------->" + str);
            webView.loadUrl(str);
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends WebChromeClient {
        public final /* synthetic */ ProgressBar a;

        public c(ProgressBar progressBar) {
            this.a = progressBar;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            ProgressBar progressBar = this.a;
            if (i < 70) {
                progressBar.setProgress(i);
            } else if (progressBar.getVisibility() == 0) {
                this.a.setVisibility(8);
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        WebView webView = this.z0;
        if (webView != null) {
            zm4.b(webView);
            this.z0 = null;
        }
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return u73.x;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.e);
        window.getDecorView().setSystemUiVisibility(9472);
        window.addFlags(ImageHolder.WRAP_CONTENT);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            attributes.layoutInDisplayCutoutMode = 3;
        } else if (i >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
        }
        attributes.width = -1;
        attributes.height = -1;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z != null) {
            this.A0 = j30.p(z.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
        }
        TextView textView = (TextView) k2(y63.h0);
        ProgressBar progressBar = (ProgressBar) k2(y63.X);
        k2(y63.f).setOnClickListener(new a());
        this.z0 = new WebView(this.x0);
        this.z0.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.z0.setWebViewClient(new b(textView));
        this.z0.setWebChromeClient(new c(progressBar));
        WebSettings settings = this.z0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        ((LinearLayout) k2(y63.c0)).addView(this.z0);
        if (TextUtils.isEmpty(this.A0)) {
            return;
        }
        this.z0.loadUrl(this.A0);
    }
}
