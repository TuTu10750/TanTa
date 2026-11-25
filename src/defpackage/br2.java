package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public class br2 extends l0 {
    public WebView A0;
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

    @Override // defpackage.l0
    public void C0() {
        WebView webView = this.A0;
        if (webView != null) {
            zm4.b(webView);
            this.A0 = null;
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
        return u73.r;
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
        WebView a2 = zm4.a(this.x0);
        this.A0 = a2;
        if (a2 != null) {
            zm4.d(a2);
            frameLayout.addView(this.A0);
            this.A0.loadDataWithBaseURL(null, this.z0, "text/html", "utf-8", null);
        } else {
            zm4.e(frameLayout, this.z0);
        }
        this.y0.findViewById(y63.j).setOnClickListener(new View.OnClickListener() { // from class: ar2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                br2.this.T1();
            }
        });
    }

    public void s2(String str) {
        this.z0 = str;
    }

    public void t2(k61 k61Var, String str) {
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
