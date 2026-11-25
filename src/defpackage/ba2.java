package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ba2 extends l0 implements View.OnClickListener {
    public aa2 A0;
    public a B0;
    public List z0;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a();
    }

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
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.v;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.H) {
            S1();
            return;
        }
        if (id == b73.u) {
            S1();
            a aVar = this.B0;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.a);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        attributes.y = zn0.a(80);
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        RecyclerView k2 = k2(b73.B4);
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
        rq1 rq1Var = new rq1(this.x0, 0, 15.0f, 0.0f);
        rq1Var.l(true);
        k2.k(rq1Var);
        if (this.z0 == null) {
            this.z0 = new ArrayList();
        }
        aa2 aa2Var = new aa2(this.x0, this.z0);
        this.A0 = aa2Var;
        k2.setAdapter(aa2Var);
        k2(b73.H).setOnClickListener(this);
        k2(b73.u).setOnClickListener(this);
    }

    public void r2(a aVar) {
        this.B0 = aVar;
    }

    public void s2(List list) {
        this.z0 = list;
    }
}
