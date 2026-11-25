package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.yunbao.mall.activity.BuyerRefundOfficialActivity;
import com.yunbao.mall.bean.RefundReasonBean;
import com.zyyoona7.wheel.WheelView;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class fs2 extends l0 implements View.OnClickListener {
    public List A0;
    public WheelView z0;

    @Override // defpackage.l0
    public void C0() {
        WheelView wheelView = this.z0;
        if (wheelView != null) {
            wheelView.s();
        }
        this.z0 = null;
        this.x0 = null;
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
        return z73.e0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object obj;
        WheelView wheelView;
        int id = view.getId();
        if (id == d73.M) {
            S1();
            return;
        }
        if (id != d73.p0 || (obj = this.x0) == null || this.A0 == null || (wheelView = this.z0) == null) {
            return;
        }
        ((BuyerRefundOfficialActivity) obj).M1((RefundReasonBean) wheelView.getSelectedItemData());
        S1();
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
        if (this.A0 == null) {
            return;
        }
        k2(d73.M).setOnClickListener(this);
        k2(d73.p0).setOnClickListener(this);
        WheelView wheelView = (WheelView) k2(d73.x4);
        this.z0 = wheelView;
        wheelView.setData(this.A0);
    }

    public void r2(List list) {
        this.A0 = list;
    }
}
