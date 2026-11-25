package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.PayContentBuyBean;

/* loaded from: /tmp/classes2.dex */
public class xw2 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi3.o(xw2.this.d, ((PayContentBuyBean) view.getTag()).getGoodsId());
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
            this.v = (TextView) view.findViewById(d73.m4);
            this.w = (TextView) view.findViewById(d73.W2);
            this.x = (TextView) view.findViewById(d73.R2);
            this.y = (ImageView) view.findViewById(d73.l);
            view.setOnClickListener(xw2.this.i);
        }

        public void O(PayContentBuyBean payContentBuyBean) {
            ((RecyclerView.e0) this).a.setTag(payContentBuyBean);
            kn1.f(xw2.this.d, payContentBuyBean.getThumb(), this.u);
            kn1.g(xw2.this.d, payContentBuyBean.getAvatar(), this.y);
            this.v.setText(payContentBuyBean.getTitle());
            this.w.setText(payContentBuyBean.getVideoNum());
            this.x.setText(payContentBuyBean.getUserName());
        }
    }

    public xw2(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.U0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((PayContentBuyBean) this.e.get(i));
    }
}
