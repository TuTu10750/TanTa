package defpackage;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class g22 extends l0 implements et2 {
    public boolean A0;
    public e22 B0;
    public f22 z0;

    @Override // defpackage.l0
    public void C0() {
        if (this.A0) {
            zu0.c().p(this);
        }
        this.z0 = null;
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
        return x73.L;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onImUnReadCountEvent(kk1 kk1Var) {
        ik1 h = ck1.e().h();
        if (h != null) {
            String g = h.g();
            e22 e22Var = this.B0;
            if (e22Var != null) {
                e22Var.S(g);
            }
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
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        super.r0(bundle);
        Bundle z11 = z();
        if (z11 != null) {
            boolean z12 = z11.getBoolean("hasGame", false);
            boolean z13 = z11.getBoolean("openFlash", false);
            boolean z14 = z11.getBoolean("TASK", false);
            boolean z15 = z11.getBoolean("LUCK_PAN", false);
            boolean z16 = z11.getBoolean("HAS_FACE", false);
            this.A0 = z11.getBoolean("HAS_MSG", false);
            boolean z17 = z11.getBoolean("screenRecord", false);
            boolean z18 = z11.getBoolean("linkMic", false);
            boolean z19 = z11.getBoolean("isMute", false);
            boolean z20 = z11.getBoolean("isChangeType", false);
            z10 = z11.getBoolean("fullHD", false);
            z = z12;
            z2 = z13;
            z3 = z14;
            z4 = z15;
            z5 = z16;
            z6 = z17;
            z7 = z18;
            z8 = z19;
            z9 = z20;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            z7 = false;
            z8 = false;
            z9 = false;
            z10 = false;
        }
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        findViewById.setHasFixedSize(true);
        findViewById.setLayoutManager(new GridLayoutManager(this.x0, 5, 1, false));
        e22 e22Var = new e22(this.x0, z, z2, z3, z4, z5, z6, z7, z8, z9, z10);
        e22Var.R(this);
        findViewById.setAdapter(e22Var);
        this.B0 = e22Var;
        if (this.A0) {
            zu0.c().n(this);
        }
    }

    @Override // defpackage.et2
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(Integer num, int i) {
        S1();
        f22 f22Var = this.z0;
        if (f22Var != null) {
            f22Var.a(num.intValue());
        }
    }

    public void s2(f22 f22Var) {
        this.z0 = f22Var;
    }
}
