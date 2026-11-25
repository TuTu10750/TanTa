package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* loaded from: /tmp/classes2.dex */
public class s92 extends l0 implements View.OnClickListener {
    public WebView z0;

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
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.j0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b73.N) {
            S1();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = zn0.a(320);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.N).setOnClickListener(this);
        ViewGroup viewGroup = (ViewGroup) k2(b73.A1);
        WebView webView = new WebView(this.x0);
        this.z0 = webView;
        webView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.z0.setOverScrollMode(2);
        viewGroup.addView(this.z0);
        WebSettings settings = this.z0.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        this.z0.loadUrl(j30.p(wg1.p));
    }
}
