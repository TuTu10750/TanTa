package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveContributeActivity;

/* loaded from: /tmp/classes2.dex */
public class o12 extends r0 implements View.OnClickListener {
    public ProgressBar f;
    public WebView g;
    public String h;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            lx1.b("H5-------->" + str);
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
            o12 o12Var = o12.this;
            if (i < 70) {
                o12Var.f.setProgress(i);
            } else if (o12Var.f.getVisibility() == 0) {
                o12.this.f.setVisibility(8);
            }
        }
    }

    public o12(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.h = null;
    }

    public o12(Context context, ViewGroup viewGroup, String str) {
        this(context, viewGroup);
        this.h = str;
    }

    @Override // defpackage.r0
    public void a0() {
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.T1;
    }

    @Override // defpackage.r0
    public void hide() {
        Object obj = this.mContext;
        if (obj instanceof LiveContributeActivity) {
            ((LiveContributeActivity) obj).onBackPressed();
        } else {
            super.hide();
        }
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        super.init();
        this.f = (ProgressBar) findViewById(b73.v4);
        this.g = new WebView(this.mContext);
        this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.g.setWebViewClient(new a());
        this.g.setWebChromeClient(new b());
        WebSettings settings = this.g.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        ((LinearLayout) this.mContentView).addView(this.g);
    }

    @Override // defpackage.r0
    public void loadData() {
        Object obj = this.mContext;
        if (obj instanceof LiveActivity) {
            this.h = ((LiveActivity) obj).F1();
        } else if (obj instanceof LiveContributeActivity) {
            this.h = ((LiveContributeActivity) obj).w1();
        }
        if (TextUtils.isEmpty(this.h) || this.g == null) {
            return;
        }
        String a2 = rv3.a(wg1.b, j30.q().C(), "&", "language", "=", rx1.c().d(), "&token=", j30.q().B(), "&anchor_id=", this.h);
        lx1.c("9527", "url:" + a2);
        this.g.loadUrl(a2);
    }

    @Override // defpackage.r0, defpackage.b1
    public void release() {
        super.release();
        WebView webView = this.g;
        if (webView != null) {
            zm4.b(webView);
            this.g = null;
        }
    }
}
