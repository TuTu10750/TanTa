package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerOrderBean;

/* loaded from: /tmp/classes2.dex */
public abstract class ol extends ce3 {
    public String i;
    public String j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public c m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ol.this.m) == null) {
                return;
            }
            cVar.A((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = ol.this.m) == null) {
                return;
            }
            cVar.r((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void A(BuyerOrderBean buyerOrderBean);

        void L(BuyerOrderBean buyerOrderBean);

        void P(BuyerOrderBean buyerOrderBean);

        void Y(BuyerOrderBean buyerOrderBean);

        void i(BuyerOrderBean buyerOrderBean);

        void o(BuyerOrderBean buyerOrderBean);

        void p(BuyerOrderBean buyerOrderBean);

        void r(BuyerOrderBean buyerOrderBean);

        void z(BuyerOrderBean buyerOrderBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public TextView A;
        public TextView B;
        public TextView C;
        public TextView u;
        public TextView v;
        public ImageView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.X3);
            this.v = (TextView) view.findViewById(d73.d4);
            this.w = (ImageView) view.findViewById(d73.e2);
            this.x = (TextView) view.findViewById(d73.W1);
            this.y = (TextView) view.findViewById(d73.Z1);
            this.z = (TextView) view.findViewById(d73.d2);
            this.A = (TextView) view.findViewById(d73.X1);
            this.B = (TextView) view.findViewById(d73.p4);
            this.C = (TextView) view.findViewById(d73.o4);
            this.u.setOnClickListener(ol.this.k);
            view.setOnClickListener(ol.this.l);
        }

        public void O(BuyerOrderBean buyerOrderBean) {
            this.u.setTag(buyerOrderBean);
            ((RecyclerView.e0) this).a.setTag(buyerOrderBean);
            this.u.setText(buyerOrderBean.getShopName());
            this.v.setText(buyerOrderBean.getStatusTip());
            kn1.f(ol.this.d, buyerOrderBean.getGoodsSpecThumb(), this.w);
            this.x.setText(buyerOrderBean.getGoodsName());
            this.y.setText(rv3.a(ol.this.j, buyerOrderBean.getGoodsPrice()));
            this.z.setText(buyerOrderBean.getGoodsSpecName());
            this.A.setText(rv3.a("x", buyerOrderBean.getGoodsNum()));
            this.B.setText(String.format(ol.this.i, buyerOrderBean.getGoodsNum()));
            this.C.setText(rv3.a(ol.this.j, buyerOrderBean.getTotalPrice()));
        }
    }

    public ol(Context context) {
        super(context);
        this.i = aq4.a(m93.I6);
        this.j = aq4.a(m93.O8);
        this.k = new a();
        this.l = new b();
    }

    public void X(c cVar) {
        this.m = cVar;
    }
}
