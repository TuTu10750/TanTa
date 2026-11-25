package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class tx1 extends r0 implements View.OnClickListener {
    public ProgressBar f;
    public WebView g;
    public TextView h;
    public String i;
    public c j;

    /* loaded from: /tmp/classes2.dex */
    public class a extends WebViewClient {
        public a() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (tx1.this.h != null) {
                tx1.this.h.setText(webView.getTitle());
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
    public class b extends WebChromeClient {
        public b() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            tx1 tx1Var = tx1.this;
            if (i < 70) {
                tx1Var.f.setProgress(i);
            } else if (tx1Var.f.getVisibility() == 0) {
                tx1.this.f.setVisibility(8);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a();
    }

    public tx1(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup);
        this.i = j30.p(str);
    }

    public void f0(c cVar) {
        this.j = cVar;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.I1;
    }

    @Override // defpackage.r0
    public void hide() {
        c cVar = this.j;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        super.init();
        this.h = (TextView) findViewById(b73.i5);
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
        if (this.c) {
            return;
        }
        this.c = true;
        this.g.loadUrl(this.i);
    }

    @Override // defpackage.r0, defpackage.b1
    public void release() {
        super.release();
        this.j = null;
        WebView webView = this.g;
        if (webView != null) {
            zm4.b(webView);
            this.g = null;
        }
        lx1.c("LauncherAdViewHolder", "----------->release");
    }
}
