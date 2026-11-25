package defpackage;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveRoomTypeBean;

/* loaded from: /tmp/classes2.dex */
public class g52 extends l0 implements et2 {
    public f52 A0;
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
        return x73.Z;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(80);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.z0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
        Bundle z = z();
        if (z == null) {
            return;
        }
        f52 f52Var = new f52(this.x0, z.getInt("checkedId", 0));
        this.A0 = f52Var;
        f52Var.S(this);
        this.z0.setAdapter(this.A0);
    }

    @Override // defpackage.et2
    /* renamed from: r2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveRoomTypeBean liveRoomTypeBean, int i) {
        S1();
        k30 k30Var = this.B0;
        if (k30Var != null) {
            k30Var.a(liveRoomTypeBean);
        }
    }

    public void s2(k30 k30Var) {
        this.B0 = k30Var;
    }
}
