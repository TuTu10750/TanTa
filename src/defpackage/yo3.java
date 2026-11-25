package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsSimpleBean;

/* loaded from: /tmp/classes2.dex */
public class yo3 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;
    public String l;
    public boolean m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (!yo3.this.L() || (tag = view.getTag()) == null || yo3.this.h == null) {
                return;
            }
            yo3.this.h.onItemClick((GoodsSimpleBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.k3);
            this.x = (TextView) view.findViewById(d73.R3);
            this.y = (TextView) view.findViewById(d73.n3);
            if (yo3.this.m) {
                this.y.setVisibility(0);
            }
            view.setOnClickListener(yo3.this.i);
        }

        public void O(GoodsSimpleBean goodsSimpleBean) {
            ((RecyclerView.e0) this).a.setTag(goodsSimpleBean);
            kn1.f(yo3.this.d, goodsSimpleBean.getThumb(), this.u);
            this.v.setText(goodsSimpleBean.getName());
            this.w.setText(rv3.a(yo3.this.k, goodsSimpleBean.getPrice()));
            int type = goodsSimpleBean.getType();
            TextView textView = this.x;
            if (type == 1) {
                textView.setText((CharSequence) null);
            } else {
                textView.setText(String.format(yo3.this.j, goodsSimpleBean.getSaleNum()));
            }
            if (yo3.this.m) {
                this.y.setText(rv3.a(yo3.this.k, yo3.this.l, goodsSimpleBean.getPriceYong()));
            }
        }
    }

    public yo3(Context context, boolean z) {
        super(context);
        this.m = z;
        this.j = aq4.a(m93.f6);
        this.k = aq4.a(m93.O8);
        this.i = new a();
        this.l = aq4.a(m93.A8);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f.inflate(z73.w1, viewGroup, false)) : new b(this.f.inflate(z73.x1, viewGroup, false));
    }

    public int l(int i) {
        return i % 2 == 0 ? 1 : 2;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((GoodsSimpleBean) this.e.get(i));
    }
}
