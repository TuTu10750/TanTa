package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.bean.GoodsSimpleBean;

/* loaded from: /tmp/classes2.dex */
public class dc2 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (dc2.this.L()) {
                GoodsSimpleBean goodsSimpleBean = (GoodsSimpleBean) view.getTag();
                GoodsDetailActivity.u2(dc2.this.d, goodsSimpleBean.getId(), false, goodsSimpleBean.getType());
            }
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
            this.u = (ImageView) view.findViewById(c73.E4);
            this.v = (TextView) view.findViewById(c73.L3);
            this.w = (TextView) view.findViewById(c73.Z3);
            this.x = (TextView) view.findViewById(d73.R3);
            TextView textView = (TextView) view.findViewById(d73.c3);
            this.y = textView;
            textView.getPaint().setFlags(16);
            view.setOnClickListener(dc2.this.i);
        }

        public void O(GoodsSimpleBean goodsSimpleBean) {
            ((RecyclerView.e0) this).a.setTag(goodsSimpleBean);
            kn1.f(dc2.this.d, goodsSimpleBean.getThumb(), this.u);
            this.v.setText(goodsSimpleBean.getName());
            this.w.setText(rv3.a(dc2.this.k, goodsSimpleBean.getPrice()));
            int type = goodsSimpleBean.getType();
            TextView textView = this.x;
            if (type == 1) {
                textView.setText((CharSequence) null);
                this.y.setText(goodsSimpleBean.getOriginPrice());
            } else {
                textView.setText(String.format(dc2.this.j, goodsSimpleBean.getSaleNum()));
                this.y.setText((CharSequence) null);
            }
        }
    }

    public dc2(Context context) {
        super(context);
        this.j = aq4.a(m93.f6);
        this.k = aq4.a(m93.O8);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f.inflate(z73.t1, viewGroup, false)) : new b(this.f.inflate(z73.v1, viewGroup, false));
    }

    public int l(int i) {
        return i % 2 == 1 ? 2 : 1;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof b) {
            ((b) e0Var).O((GoodsSimpleBean) this.e.get(i));
        }
    }
}
