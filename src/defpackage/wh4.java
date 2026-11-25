package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.GoodsBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class wh4 extends ce3 {
    public View.OnClickListener i;
    public Drawable j;
    public Drawable k;
    public int l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getTag() == null) {
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            wh4.this.Y((GoodsBean) wh4.this.e.get(intValue), intValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public ImageView y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(f73.V);
            this.v = (TextView) view.findViewById(f73.x);
            this.w = (TextView) view.findViewById(f73.J);
            this.x = (TextView) view.findViewById(f73.K);
            this.y = (ImageView) view.findViewById(f73.B);
            view.setOnClickListener(wh4.this.i);
        }

        public void O(GoodsBean goodsBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(wh4.this.d, goodsBean.getThumb(), this.u);
                this.w.setText(goodsBean.getHaveUnitPrice());
                this.x.setText(goodsBean.getHaveUnitmOriginPrice());
                this.x.getPaint().setFlags(16);
                this.v.setText(goodsBean.getName());
            }
            ImageView imageView = this.y;
            boolean isAdded = goodsBean.isAdded();
            wh4 wh4Var = wh4.this;
            imageView.setImageDrawable(isAdded ? wh4Var.j : wh4Var.k);
        }
    }

    public wh4(Context context) {
        super(context);
        this.l = -1;
        this.i = new a();
        this.j = o60.d(this.d, q83.n1);
        this.k = o60.d(this.d, q83.m1);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((GoodsBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(b83.k, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void M() {
        super.M();
        this.l = -1;
    }

    @Override // defpackage.ce3
    public void P(List list) {
        super.P(list);
        this.l = -1;
    }

    public final void Y(GoodsBean goodsBean, int i) {
        int i2 = this.l;
        if (i2 == i) {
            goodsBean.setAdded(false);
            r(i, "payload");
            this.l = -1;
            et2 et2Var = this.h;
            if (et2Var != null) {
                et2Var.onItemClick(null, i);
                return;
            }
            return;
        }
        if (i2 >= 0 && i2 < this.e.size()) {
            ((GoodsBean) this.e.get(this.l)).setAdded(false);
            r(this.l, "payload");
        }
        goodsBean.setAdded(true);
        r(i, "payload");
        this.l = i;
        et2 et2Var2 = this.h;
        if (et2Var2 != null) {
            et2Var2.onItemClick(goodsBean, i);
        }
    }

    public void Z(GoodsBean goodsBean) {
        List list = this.e;
        if (list == null) {
            return;
        }
        if (goodsBean == null) {
            int i = this.l;
            if (i != -1) {
                ((GoodsBean) list.get(i)).setAdded(true);
                r(this.l, "payload");
                this.l = -1;
                return;
            }
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            GoodsBean goodsBean2 = (GoodsBean) this.e.get(i2);
            if (goodsBean2.getId().equals(goodsBean.getId())) {
                Y(goodsBean2, i2);
            }
        }
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
