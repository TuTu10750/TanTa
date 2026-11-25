package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class p52 extends l0 implements View.OnClickListener {
    public o52 A0;
    public k30 B0;
    public RecyclerView z0;

    @Override // defpackage.l0
    public void C0() {
        this.B0 = null;
        super.C0();
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
        return x73.Y;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != b73.C && id == b73.N) {
            r2();
        }
        S1();
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
        this.y0.findViewById(b73.C).setOnClickListener(this);
        this.y0.findViewById(b73.N).setOnClickListener(this);
        Bundle z = z();
        if (z == null) {
            return;
        }
        int i = z.getInt("checkedCoin", 0);
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.z0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        o52 o52Var = new o52(this.x0, i);
        this.A0 = o52Var;
        this.z0.setAdapter(o52Var);
    }

    public final void r2() {
        k30 k30Var;
        o52 o52Var = this.A0;
        if (o52Var == null || (k30Var = this.B0) == null) {
            return;
        }
        k30Var.a(Integer.valueOf(o52Var.T()));
    }

    public void s2(k30 k30Var) {
        this.B0 = k30Var;
    }
}
