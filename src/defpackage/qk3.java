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
public class qk3 extends ce3 {
    public Drawable i;
    public View.OnClickListener j;
    public int k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            int i = qk3.this.k;
            qk3 qk3Var = qk3.this;
            if (intValue == i) {
                qk3Var.b0();
                return;
            }
            if (qk3Var.k >= 0) {
                ((SearchGoodsBean) qk3.this.e.get(qk3.this.k)).setChecked(false);
                qk3 qk3Var2 = qk3.this;
                qk3Var2.r(qk3Var2.k, "payload");
            }
            SearchGoodsBean searchGoodsBean = (SearchGoodsBean) qk3.this.e.get(intValue);
            searchGoodsBean.setChecked(true);
            qk3.this.r(intValue, "payload");
            qk3.this.k = intValue;
            if (qk3.this.h != null) {
                qk3.this.h.onItemClick(searchGoodsBean, intValue);
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
            TextView textView = (TextView) view.findViewById(d73.c3);
            this.y = textView;
            textView.getPaint().setFlags(16);
            view.setOnClickListener(qk3.this.j);
        }

        public void O(SearchGoodsBean searchGoodsBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(qk3.this.d, searchGoodsBean.getThumb(), this.u);
                this.v.setText(searchGoodsBean.getName());
                this.w.setText(searchGoodsBean.getPrice());
                int type = searchGoodsBean.getType();
                TextView textView = this.y;
                if (type == 0) {
                    textView.setText((CharSequence) null);
                } else {
                    textView.setText(searchGoodsBean.getOriginPrice());
                }
            }
            this.x.setImageDrawable(searchGoodsBean.isChecked() ? qk3.this.i : null);
        }
    }

    public qk3(Context context) {
        super(context);
        this.k = -1;
        this.i = o60.d(context, v83.b);
        this.j = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((SearchGoodsBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.c1, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void P(List list) {
        super.P(list);
        this.k = -1;
    }

    public void b0() {
        int i = this.k;
        if (i >= 0) {
            ((SearchGoodsBean) this.e.get(i)).setChecked(false);
            r(this.k, "payload");
        }
        this.k = -1;
    }

    public SearchGoodsBean c0() {
        int i = this.k;
        if (i >= 0) {
            return (SearchGoodsBean) this.e.get(i);
        }
        return null;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
