package defpackage;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class kj4 extends l0 {
    public Runnable z0;

    public static /* synthetic */ void r2(kj4 kj4Var, View view) {
        kj4Var.S1();
        pi3.w("video");
    }

    public static kj4 t2(String str) {
        kj4 kj4Var = new kj4();
        Bundle bundle = new Bundle();
        bundle.putString("desc", str);
        kj4Var.F1(bundle);
        return kj4Var;
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
        return b83.f;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        Runnable runnable = this.z0;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        TextView textView = (TextView) k2(f73.Y);
        String string = z() != null ? z().getString("desc") : null;
        if (!TextUtils.isEmpty(string)) {
            textView.setText(Html.fromHtml(string, 63));
        }
        k2(f73.f).setOnClickListener(new View.OnClickListener() { // from class: ij4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kj4.this.S1();
            }
        });
        k2(f73.s).setOnClickListener(new View.OnClickListener() { // from class: jj4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                kj4.r2(kj4.this, view);
            }
        });
    }

    public void u2(Runnable runnable) {
        this.z0 = runnable;
    }
}
