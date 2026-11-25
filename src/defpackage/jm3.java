package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SellerOrderBean;
import defpackage.am3;

/* loaded from: /tmp/classes2.dex */
public class jm3 extends am3 {
    public View.OnClickListener n;
    public View.OnClickListener o;
    public String p;
    public String q;
    public String r;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = jm3.this.m) == null) {
                return;
            }
            bVar.B((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = jm3.this.m) == null) {
                return;
            }
            bVar.E((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends am3.c {
        public TextView D;
        public View E;
        public View F;

        public c(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.L3);
            this.E = view.findViewById(d73.d0);
            this.F = view.findViewById(d73.Y0);
            this.E.setOnClickListener(jm3.this.n);
            this.F.setOnClickListener(jm3.this.o);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            TextView textView = this.D;
            String str = jm3.this.p;
            int refundType = sellerOrderBean.getRefundType();
            jm3 jm3Var = jm3.this;
            textView.setText(String.format(str, refundType == 0 ? jm3Var.q : jm3Var.r, jm3.this.k, sellerOrderBean.getTotalPrice()));
            this.E.setTag(sellerOrderBean);
            this.F.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    public jm3(Context context) {
        super(context);
        this.k = aq4.a(m93.O8);
        this.p = aq4.a(m93.Q6);
        this.q = aq4.a(m93.h7);
        this.r = aq4.a(m93.i7);
        this.n = new a();
        this.o = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.k1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((SellerOrderBean) this.e.get(i));
    }
}
