package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsSimpleBean;

/* loaded from: /tmp/classes2.dex */
public class wo3 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (!wo3.this.L() || (tag = view.getTag()) == null || wo3.this.h == null) {
                return;
            }
            wo3.this.h.onItemClick((GoodsSimpleBean) tag, 0);
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
            TextView textView = (TextView) view.findViewById(d73.c3);
            this.y = textView;
            textView.getPaint().setFlags(16);
            view.setOnClickListener(wo3.this.i);
        }

        public void O(GoodsSimpleBean goodsSimpleBean) {
            ((RecyclerView.e0) this).a.setTag(goodsSimpleBean);
            kn1.f(wo3.this.d, goodsSimpleBean.getThumb(), this.u);
            this.v.setText(goodsSimpleBean.getName());
            this.w.setText(rv3.a(wo3.this.k, goodsSimpleBean.getPrice()));
            int type = goodsSimpleBean.getType();
            TextView textView = this.x;
            if (type == 1) {
                textView.setText((CharSequence) null);
                this.y.setText(goodsSimpleBean.getOriginPrice());
            } else {
                textView.setText(String.format(wo3.this.j, goodsSimpleBean.getSaleNum()));
                this.y.setText((CharSequence) null);
            }
        }
    }

    public wo3(Context context) {
        super(context);
        this.j = aq4.a(m93.f6);
        this.k = aq4.a(m93.O8);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new b(this.f.inflate(z73.t1, viewGroup, false)) : new b(this.f.inflate(z73.v1, viewGroup, false));
    }

    public int l(int i) {
        return i % 2 == 0 ? 1 : 2;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((GoodsSimpleBean) this.e.get(i));
    }
}
