package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.umeng.ccg.c;

/* loaded from: /tmp/classes2.dex */
public class nd4 extends l0 {
    public String A0;
    public WebView B0;
    public b z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
            return i == 4;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(Context context, jm0 jm0Var);

        void b(Context context, jm0 jm0Var);
    }

    public static /* synthetic */ void r2(nd4 nd4Var, View view) {
        b bVar = nd4Var.z0;
        if (bVar != null) {
            bVar.b(nd4Var.x0, nd4Var);
        }
    }

    public static /* synthetic */ void s2(nd4 nd4Var, View view) {
        b bVar = nd4Var.z0;
        if (bVar != null) {
            bVar.a(nd4Var.x0, nd4Var);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.z0 = null;
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
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return u73.w;
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
        this.B0 = a2;
        if (a2 != null) {
            zm4.d(a2);
            frameLayout.addView(this.B0);
            this.B0.loadDataWithBaseURL(null, this.A0, "text/html", "utf-8", null);
        } else {
            zm4.e(frameLayout, this.A0);
        }
        ImageView imageView = (ImageView) this.y0.findViewById(y63.O);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        int c = gk3.a().c() - zn0.a(68);
        int i = (c * 137) / c.u;
        layoutParams.width = c;
        layoutParams.height = i;
        imageView.setLayoutParams(layoutParams);
        this.y0.findViewById(y63.j).setOnClickListener(new View.OnClickListener() { // from class: ld4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nd4.s2(nd4.this, view);
            }
        });
        this.y0.findViewById(y63.g).setOnClickListener(new View.OnClickListener() { // from class: md4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                nd4.r2(nd4.this, view);
            }
        });
    }

    public void t2(b bVar) {
        this.z0 = bVar;
    }

    public void u2(String str) {
        this.A0 = str;
    }
}
