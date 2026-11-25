package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.GoodsBean;

/* loaded from: /tmp/classes2.dex */
public class y22 extends ce3 {
    public View.OnClickListener i;
    public String j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || y22.this.h == null) {
                return;
            }
            y22.this.h.onItemClick((GoodsBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public View y;
        public TextView z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d5);
            this.v = (TextView) view.findViewById(b73.i5);
            this.w = (TextView) view.findViewById(b73.t4);
            this.z = (TextView) view.findViewById(b73.l4);
            TextView textView = (TextView) view.findViewById(b73.u4);
            this.x = textView;
            textView.getPaint().setFlags(16);
            View findViewById = view.findViewById(b73.A);
            this.y = findViewById;
            findViewById.setOnClickListener(y22.this.i);
        }

        public void O(GoodsBean goodsBean, int i) {
            this.y.setTag(goodsBean);
            kn1.f(y22.this.d, goodsBean.getThumb(), this.u);
            this.w.setText(rv3.a(y22.this.j, goodsBean.getPriceNow()));
            this.v.setText(goodsBean.getName());
            int type = goodsBean.getType();
            TextView textView = this.x;
            if (type == 1) {
                textView.setText(rv3.a(y22.this.j, goodsBean.getOriginPrice()));
            } else {
                textView.setText((CharSequence) null);
            }
            this.z.setText(String.valueOf(i + 1));
        }
    }

    public y22(Context context) {
        super(context);
        this.j = aq4.a(m93.O8);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.N0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((GoodsBean) this.e.get(i), i);
    }
}
