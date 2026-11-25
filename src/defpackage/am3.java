package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SellerOrderBean;

/* loaded from: /tmp/classes2.dex */
public abstract class am3 extends ce3 {
    public String i;
    public String j;
    public String k;
    public View.OnClickListener l;
    public b m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = am3.this.m) == null) {
                return;
            }
            bVar.x((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void B(SellerOrderBean sellerOrderBean);

        void E(SellerOrderBean sellerOrderBean);

        void O(SellerOrderBean sellerOrderBean);

        void l(SellerOrderBean sellerOrderBean);

        void m(SellerOrderBean sellerOrderBean);

        void x(SellerOrderBean sellerOrderBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView A;
        public TextView B;
        public TextView u;
        public TextView v;
        public ImageView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.Y2);
            this.v = (TextView) view.findViewById(d73.d4);
            this.w = (ImageView) view.findViewById(d73.e2);
            this.x = (TextView) view.findViewById(d73.W1);
            this.y = (TextView) view.findViewById(d73.Z1);
            this.z = (TextView) view.findViewById(d73.d2);
            this.A = (TextView) view.findViewById(d73.X1);
            this.B = (TextView) view.findViewById(d73.w1);
            view.setOnClickListener(am3.this.l);
        }

        public void O(SellerOrderBean sellerOrderBean) {
            ((RecyclerView.e0) this).a.setTag(sellerOrderBean);
            this.u.setText(String.format(am3.this.i, sellerOrderBean.getOrderNo()));
            this.v.setText(sellerOrderBean.getStatusTip());
            kn1.f(am3.this.d, sellerOrderBean.getGoodsSpecThumb(), this.w);
            this.x.setText(sellerOrderBean.getGoodsName());
            this.y.setText(rv3.a(am3.this.k, sellerOrderBean.getGoodsPrice()));
            this.z.setText(sellerOrderBean.getGoodsSpecName());
            this.A.setText(rv3.a("x", sellerOrderBean.getGoodsNum()));
            this.B.setText(String.format(am3.this.j, sellerOrderBean.getBuyerName()));
        }
    }

    public am3(Context context) {
        super(context);
        this.i = aq4.a(m93.N6);
        this.j = aq4.a(m93.O6);
        this.k = aq4.a(m93.O8);
        this.l = new a();
    }

    public void W(b bVar) {
        this.m = bVar;
    }
}
