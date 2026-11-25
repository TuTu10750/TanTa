package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerRefundRecordBean;

/* loaded from: /tmp/classes2.dex */
public class am extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.m);
            this.v = (TextView) view.findViewById(d73.k4);
            this.w = (TextView) view.findViewById(d73.P3);
        }

        public void O(BuyerRefundRecordBean buyerRefundRecordBean) {
            this.u.setText(buyerRefundRecordBean.getBalance());
            this.v.setText(buyerRefundRecordBean.getAddTime());
            this.w.setText(buyerRefundRecordBean.getResult());
        }
    }

    public am(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(z73.y0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((BuyerRefundRecordBean) this.e.get(i));
    }
}
