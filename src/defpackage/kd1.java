package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsPayBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class kd1 extends ce3 {
    public View.OnClickListener i;
    public int j;
    public String k;
    public Drawable l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue == kd1.this.j) {
                return;
            }
            ((GoodsPayBean) kd1.this.e.get(intValue)).setChecked(true);
            ((GoodsPayBean) kd1.this.e.get(kd1.this.j)).setChecked(false);
            kd1.this.r(intValue, "payload");
            kd1 kd1Var = kd1.this;
            kd1Var.r(kd1Var.j, "payload");
            kd1.this.j = intValue;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends c {
        public TextView y;

        public b(View view) {
            super(view);
            this.y = (TextView) view.findViewById(d73.m);
        }

        @Override // kd1.c
        public void O(GoodsPayBean goodsPayBean, int i, Object obj) {
            super.O(goodsPayBean, i, obj);
            if (obj == null) {
                this.y.setText(rv3.a("(", kd1.this.k, ")"));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (ImageView) view.findViewById(d73.y2);
            view.setOnClickListener(kd1.this.i);
        }

        public void O(GoodsPayBean goodsPayBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(kd1.this.d, goodsPayBean.getThumb(), this.u);
                this.v.setText(goodsPayBean.getName());
            }
            this.w.setImageDrawable(goodsPayBean.isChecked() ? kd1.this.l : null);
        }
    }

    public kd1(Context context, List list, String str) {
        super(context, list);
        this.k = str;
        this.l = o60.d(this.d, v83.f);
        this.i = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((GoodsPayBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new b(this.f.inflate(z73.P0, viewGroup, false)) : new c(this.f.inflate(z73.O0, viewGroup, false));
    }

    public GoodsPayBean a0() {
        for (GoodsPayBean goodsPayBean : this.e) {
            if (goodsPayBean.isChecked()) {
                return goodsPayBean;
            }
        }
        return null;
    }

    public int l(int i) {
        return "balance".equals(((GoodsPayBean) this.e.get(i)).getId()) ? -1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
