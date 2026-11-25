package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.mall.bean.BuyerOrderBean;

/* loaded from: /tmp/classes2.dex */
public class wl extends j0 {
    public wl(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.j0
    public ol d0() {
        return new vl(this.mContext);
    }

    @Override // defpackage.j0
    public String e0() {
        return "refund";
    }

    @Override // defpackage.j0, ol.c
    public void r(BuyerOrderBean buyerOrderBean) {
        P(buyerOrderBean);
    }
}
