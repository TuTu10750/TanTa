package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Field;

/* loaded from: /tmp/classes2.dex */
public class l12 extends l0 implements View.OnClickListener {
    public String A0;
    public EditText B0;
    public b C0;
    public int z0;

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
        void a();

        void b();
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
        return this.z0 == 1 ? x73.K : x73.J;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.C0 == null) {
            return;
        }
        int id = view.getId();
        if (id == b73.H || id == b73.C) {
            this.C0.a();
            S1();
            return;
        }
        if (id == b73.N) {
            if (this.z0 != 1) {
                S1();
                this.C0.b();
                return;
            }
            EditText editText = this.B0;
            if (editText != null) {
                String trim = editText.getText().toString().trim();
                if (TextUtils.isEmpty(trim)) {
                    t54.b(aq4.a(m93.N3));
                    return;
                }
                String a2 = fa2.a(trim);
                if (TextUtils.isEmpty(a2) || !a2.equalsIgnoreCase(this.A0)) {
                    t54.b(aq4.a(m93.l4));
                } else {
                    S1();
                    this.C0.b();
                }
            }
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(250);
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
        k2(b73.H).setOnClickListener(this);
        k2(b73.C).setOnClickListener(this);
        k2(b73.N).setOnClickListener(this);
        TextView textView = (TextView) k2(b73.f5);
        if (this.z0 == 1) {
            this.B0 = (EditText) k2(b73.N1);
            textView.setText(aq4.a(m93.x4));
            return;
        }
        String g = j30.q().g();
        int i = this.z0;
        if (i == 2) {
            textView.setText(aq4.b(m93.w4, this.A0, g));
        } else if (i == 3) {
            textView.setText(aq4.b(m93.y4, this.A0, g));
        }
    }

    public void r2(b bVar) {
        this.C0 = bVar;
    }

    public void s2(int i, String str) {
        this.z0 = i;
        this.A0 = str;
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
