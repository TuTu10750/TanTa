package defpackage;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.mob.MobBean;

/* loaded from: /tmp/classes2.dex */
public class k52 extends l0 implements et2 {
    public a A0;
    public boolean B0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void c0(String str);
    }

    @Override // defpackage.l0
    public void C0() {
        super.C0();
        this.A0 = null;
        this.x0 = null;
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
        return x73.a0;
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
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.z0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.z0.setLayoutManager(new GridLayoutManager(this.x0, 4, 1, false));
        j52 j52Var = new j52(this.x0, this.B0);
        j52Var.P(this);
        this.z0.setAdapter(j52Var);
    }

    @Override // defpackage.et2
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(MobBean mobBean, int i) {
        if (g2()) {
            S1();
            this.x0 = null;
            a aVar = this.A0;
            if (aVar != null) {
                aVar.c0(mobBean.getType());
            }
        }
    }

    public void s2(a aVar) {
        this.A0 = aVar;
    }

    public void t2(boolean z) {
        this.B0 = z;
    }
}
