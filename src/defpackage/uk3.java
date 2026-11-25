package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SearchGoodsBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class uk3 extends ce3 {
    public Drawable i;
    public View.OnClickListener j;
    public int k;
    public String l;
    public String m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            int i = uk3.this.k;
            uk3 uk3Var = uk3.this;
            if (intValue == i) {
                uk3Var.d0();
                return;
            }
            if (uk3Var.k >= 0) {
                ((SearchGoodsBean) uk3.this.e.get(uk3.this.k)).setChecked(false);
                uk3 uk3Var2 = uk3.this;
                uk3Var2.r(uk3Var2.k, "payload");
            }
            SearchGoodsBean searchGoodsBean = (SearchGoodsBean) uk3.this.e.get(intValue);
            searchGoodsBean.setChecked(true);
            uk3.this.r(intValue, "payload");
            uk3.this.k = intValue;
            if (uk3.this.h != null) {
                uk3.this.h.onItemClick(searchGoodsBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public ImageView x;
        public TextView y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.k3);
            this.x = (ImageView) view.findViewById(d73.y2);
            this.y = (TextView) view.findViewById(d73.n3);
            view.setOnClickListener(uk3.this.j);
        }

        public void O(SearchGoodsBean searchGoodsBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(uk3.this.d, searchGoodsBean.getThumb(), this.u);
                this.v.setText(searchGoodsBean.getName());
                this.w.setText(searchGoodsBean.getPrice());
                this.y.setText(rv3.a(uk3.this.m, uk3.this.l, searchGoodsBean.getPriceYong()));
            }
            this.x.setImageDrawable(searchGoodsBean.isChecked() ? uk3.this.i : null);
        }
    }

    public uk3(Context context) {
        super(context);
        this.k = -1;
        this.i = o60.d(context, v83.b);
        this.j = new a();
        this.l = aq4.a(m93.A8);
        this.m = aq4.a(m93.O8);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((SearchGoodsBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.e1, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void P(List list) {
        super.P(list);
        this.k = -1;
    }

    public void d0() {
        int i = this.k;
        if (i >= 0) {
            ((SearchGoodsBean) this.e.get(i)).setChecked(false);
            r(this.k, "payload");
        }
        this.k = -1;
    }

    public SearchGoodsBean e0() {
        int i = this.k;
        if (i >= 0) {
            return (SearchGoodsBean) this.e.get(i);
        }
        return null;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
