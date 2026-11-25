package defpackage;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.yunbao.im.dao.IMUserBean;
import com.yunbao.live.activity.LiveActivity;
import defpackage.oj1;

/* loaded from: /tmp/classes2.dex */
public class i12 extends l0 {
    public k30 A0;
    public oj1 z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements oj1.e {
        public a() {
        }

        @Override // oj1.e
        public void a() {
            i12.this.S1();
        }

        @Override // oj1.e
        public void b(IMUserBean iMUserBean) {
            if (j10.a()) {
                if ("goodsorder_admin".equals(iMUserBean.getId())) {
                    if (j30.q().Q()) {
                        t54.a(m93.t0);
                        return;
                    } else {
                        pi3.b(i12.this.x0, "com.yunbao.mall.activity.OrderMessageActivity");
                        return;
                    }
                }
                if (i12.this.x0 instanceof LiveActivity) {
                    ((LiveActivity) i12.this.x0).U1(iMUserBean.getUserBean(), iMUserBean.getAttent() == 1);
                }
                if (i12.this.A0 != null) {
                    i12.this.A0.a(iMUserBean.getImConUserBean());
                }
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        oj1 oj1Var = this.z0;
        if (oj1Var != null) {
            oj1Var.release();
        }
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
        return w73.h;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(300);
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.setSoftInputMode(3);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.z0 = new oj1(this.x0, (ViewGroup) this.y0, 1);
        Bundle z = z();
        if (z != null) {
            this.z0.C0(z.getString("liveUid"));
        }
        this.z0.B0(new a());
        this.z0.addToParent();
        this.z0.loadData();
    }
}
