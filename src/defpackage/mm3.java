package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.mall.activity.SellerSendActivity;
import com.yunbao.mall.bean.SellerOrderBean;

/* loaded from: /tmp/classes2.dex */
public class mm3 extends a1 {
    public mm3(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.a1
    public String i0() {
        return "wait_shipment";
    }

    @Override // defpackage.a1
    public am3 j0() {
        return new lm3(this.mContext);
    }

    @Override // defpackage.a1, am3.b
    public void x(SellerOrderBean sellerOrderBean) {
        SellerSendActivity.T1(this.mContext, sellerOrderBean.getId());
    }
}
