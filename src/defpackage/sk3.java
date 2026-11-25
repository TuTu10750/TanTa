package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SearchPayBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class sk3 extends ce3 {
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
            int i = sk3.this.k;
            sk3 sk3Var = sk3.this;
            if (intValue == i) {
                sk3Var.b0();
                return;
            }
            if (sk3Var.k >= 0) {
                ((SearchPayBean) sk3.this.e.get(sk3.this.k)).setChecked(false);
                sk3 sk3Var2 = sk3.this;
                sk3Var2.r(sk3Var2.k, "payload");
            }
            SearchPayBean searchPayBean = (SearchPayBean) sk3.this.e.get(intValue);
            searchPayBean.setChecked(true);
            sk3.this.r(intValue, "payload");
            sk3.this.k = intValue;
            if (sk3.this.h != null) {
                sk3.this.h.onItemClick(searchPayBean, intValue);
            }
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
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.W2);
            this.x = (TextView) view.findViewById(d73.k3);
            this.y = (ImageView) view.findViewById(d73.y2);
            view.setOnClickListener(sk3.this.j);
        }

        public void O(SearchPayBean searchPayBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(sk3.this.d, searchPayBean.getThumb(), this.u);
                this.v.setText(searchPayBean.getName());
                this.w.setText(searchPayBean.getVideoNum());
                this.x.setText(searchPayBean.getPrice());
            }
            this.y.setImageDrawable(searchPayBean.isChecked() ? sk3.this.i : null);
        }
    }

    public sk3(Context context) {
        super(context);
        this.k = -1;
        this.i = o60.d(context, v83.b);
        this.j = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((SearchPayBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.d1, viewGroup, false));
    }

    @Override // defpackage.ce3
    public void P(List list) {
        super.P(list);
        this.k = -1;
    }

    public void b0() {
        int i = this.k;
        if (i >= 0) {
            ((SearchPayBean) this.e.get(i)).setChecked(false);
            r(this.k, "payload");
        }
        this.k = -1;
    }

    public SearchPayBean c0() {
        int i = this.k;
        if (i >= 0) {
            return (SearchPayBean) this.e.get(i);
        }
        return null;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
