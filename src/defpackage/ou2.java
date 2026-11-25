package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.activity.BuyerOrderDetailActivity;
import com.yunbao.mall.activity.BuyerRefundDetailActivity;
import com.yunbao.mall.activity.SellerOrderDetailActivity;
import com.yunbao.mall.activity.SellerRefundDetailActivity;
import com.yunbao.mall.activity.SellerSendActivity;
import com.yunbao.mall.bean.OrderMsgBean;

/* loaded from: /tmp/classes2.dex */
public class ou2 extends ce3 {
    public View.OnClickListener i;
    public SpannableString j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OrderMsgBean orderMsgBean = (OrderMsgBean) view.getTag();
            if (orderMsgBean.getIsYong() == 1) {
                return;
            }
            if (orderMsgBean.getType() == 0) {
                int status = orderMsgBean.getStatus();
                ou2 ou2Var = ou2.this;
                if (status == 5) {
                    BuyerRefundDetailActivity.Z1(ou2Var.d, orderMsgBean.getOrderId());
                    return;
                } else {
                    BuyerOrderDetailActivity.f2(ou2Var.d, orderMsgBean.getOrderId());
                    return;
                }
            }
            int status2 = orderMsgBean.getStatus();
            if (status2 == 5) {
                SellerRefundDetailActivity.V1(ou2.this.d, orderMsgBean.getOrderId());
                return;
            }
            ou2 ou2Var2 = ou2.this;
            if (status2 == 1) {
                SellerSendActivity.T1(ou2Var2.d, orderMsgBean.getOrderId());
            } else {
                SellerOrderDetailActivity.Z1(ou2Var2.d, orderMsgBean.getOrderId());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;
        public TextView w;
        public View x;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.k4);
            this.v = (ImageView) view.findViewById(d73.l);
            this.w = (TextView) view.findViewById(d73.h4);
            View findViewById = view.findViewById(d73.H);
            this.x = findViewById;
            findViewById.setOnClickListener(ou2.this.i);
        }

        public void O(OrderMsgBean orderMsgBean) {
            this.x.setTag(orderMsgBean);
            this.u.setText(orderMsgBean.getAddTime());
            kn1.g(ou2.this.d, orderMsgBean.getAvatar(), this.v);
            this.w.setText(orderMsgBean.getTitle());
            if (orderMsgBean.getIsYong() == 0) {
                this.w.append(ou2.this.j);
            }
        }
    }

    public ou2(Context context) {
        super(context);
        String a2 = aq4.a(m93.c8);
        SpannableString spannableString = new SpannableString(a2);
        this.j = spannableString;
        spannableString.setSpan(new ForegroundColorSpan(-16747777), 0, a2.length(), 33);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.T0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((OrderMsgBean) this.e.get(i));
    }
}
