package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.PayContentBean;

/* loaded from: /tmp/classes2.dex */
public class lx2 extends ce3 {
    public String i;
    public String j;
    public String k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi3.o(lx2.this.d, ((PayContentBean) view.getTag()).getId());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.m4);
            this.w = (TextView) view.findViewById(d73.W2);
            this.x = (TextView) view.findViewById(d73.k3);
            this.y = (TextView) view.findViewById(d73.a4);
            this.z = (TextView) view.findViewById(d73.R3);
            view.setOnClickListener(lx2.this.l);
        }

        public void O(PayContentBean payContentBean) {
            ((RecyclerView.e0) this).a.setTag(payContentBean);
            kn1.f(lx2.this.d, payContentBean.getThumb(), this.u);
            this.v.setText(payContentBean.getTitle());
            this.w.setText(payContentBean.getVideoNum());
            this.x.setText(payContentBean.getMoney());
            int status = payContentBean.getStatus();
            TextView textView = this.y;
            if (status == 1) {
                textView.setText("");
                this.z.setText(String.format(lx2.this.i, payContentBean.getSaleNum()));
            } else {
                int status2 = payContentBean.getStatus();
                lx2 lx2Var = lx2.this;
                textView.setText(status2 == 0 ? lx2Var.j : lx2Var.k);
                this.z.setText("");
            }
        }
    }

    public lx2(Context context) {
        super(context);
        this.i = aq4.a(m93.N7);
        this.j = aq4.a(m93.g6);
        this.k = aq4.a(m93.O7);
        this.l = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.b1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((PayContentBean) this.e.get(i));
    }
}
