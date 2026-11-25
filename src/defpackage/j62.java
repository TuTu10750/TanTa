package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public class j62 extends l0 {
    public String A0;
    public WebView B0;
    public String C0 = "";
    public String z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    public static /* synthetic */ void s2(j62 j62Var, View view) {
        pi3.w(j62Var.C0);
        j62Var.S1();
    }

    public static /* synthetic */ void t2(j62 j62Var, View view) {
        String str = j62Var.A0;
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(j62Var.A0));
            j62Var.x0.startActivity(intent);
        }
        j62Var.S1();
    }

    @Override // defpackage.l0
    public void C0() {
        WebView webView = this.B0;
        if (webView != null) {
            zm4.b(webView);
            this.B0 = null;
        }
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return false;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return u73.n;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Dialog V1 = V1();
        if (V1 != null) {
            V1.setOnKeyListener(new a());
        }
        FrameLayout frameLayout = (FrameLayout) this.y0.findViewById(y63.p0);
        WebView webView = new WebView(this.x0);
        this.B0 = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.B0.getSettings().setDefaultTextEncodingName("utf-8");
        frameLayout.addView(this.B0);
        this.B0.loadDataWithBaseURL(null, this.z0, "text/html", "utf-8", null);
        this.y0.findViewById(y63.j).setOnClickListener(new View.OnClickListener() { // from class: g62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j62.s2(j62.this, view);
            }
        });
        this.y0.findViewById(y63.g).setOnClickListener(new View.OnClickListener() { // from class: h62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j62.t2(j62.this, view);
            }
        });
        this.y0.findViewById(y63.i).setOnClickListener(new View.OnClickListener() { // from class: i62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j62.this.S1();
            }
        });
    }

    public void u2(String str, String str2) {
        this.z0 = str;
        this.A0 = str2;
    }

    public void v2(String str) {
        this.C0 = str;
    }

    public void w2(k61 k61Var, String str) {
        try {
            Field declaredField = jm0.class.getDeclaredField("u0");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = jm0.class.getDeclaredField("v0");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            s61 o = k61Var.o();
            o.d(this, str);
            o.i();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
