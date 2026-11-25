package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class tq2 extends l0 implements View.OnClickListener {
    public String A0;
    public String B0;
    public String C0;
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
    }

    @Override // defpackage.l0
    public void C0() {
        this.z0 = null;
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
        return u73.u;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar = this.z0;
        if (bVar != null) {
            bVar.a(this.x0, this);
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
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
        if (!TextUtils.isEmpty(this.A0)) {
            ((TextView) this.y0.findViewById(y63.h0)).setText(this.A0);
        }
        ((TextView) this.y0.findViewById(y63.y)).setText(this.B0);
        TextView textView = (TextView) this.y0.findViewById(y63.j);
        if (!TextUtils.isEmpty(this.C0)) {
            textView.setText(this.C0);
        }
        textView.setOnClickListener(this);
    }

    public void r2(b bVar) {
        this.z0 = bVar;
    }

    public void s2(String str) {
        this.B0 = str;
    }
}
