package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public class tj0 extends l0 {
    public k30 A0;
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

    public static /* synthetic */ void s2(tj0 tj0Var, View view) {
        k30 k30Var = tj0Var.A0;
        if (k30Var != null) {
            k30Var.a(1);
        }
        tj0Var.S1();
    }

    @Override // defpackage.l0
    public void C0() {
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
        return u73.j;
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
        ((TextView) this.y0.findViewById(y63.y)).setText(this.z0);
        this.y0.findViewById(y63.j).setOnClickListener(new View.OnClickListener() { // from class: rj0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                tj0.s2(tj0.this, view);
            }
        });
        this.y0.findViewById(y63.g).setOnClickListener(new View.OnClickListener() { // from class: sj0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                tj0.this.S1();
            }
        });
    }

    public void t2(k30 k30Var) {
        this.A0 = k30Var;
    }

    public void u2(String str) {
        this.z0 = str;
    }
}
