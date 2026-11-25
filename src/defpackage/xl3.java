package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SellerOrderBean;
import defpackage.am3;

/* loaded from: /tmp/classes2.dex */
public class xl3 extends am3 {
    public View.OnClickListener n;
    public View.OnClickListener o;
    public View.OnClickListener p;
    public View.OnClickListener q;
    public View.OnClickListener r;
    public String s;
    public String t;
    public String u;
    public String v;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = xl3.this.m) == null) {
                return;
            }
            bVar.O((SellerOrderBean) tag);
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
            if (tag == null || (bVar = xl3.this.m) == null) {
                return;
            }
            bVar.B((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = xl3.this.m) == null) {
                return;
            }
            bVar.l((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = xl3.this.m) == null) {
                return;
            }
            bVar.E((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = xl3.this.m) == null) {
                return;
            }
            bVar.m((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends am3.c {
        public TextView D;
        public View E;

        public f(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.T1);
            View findViewById = view.findViewById(d73.n0);
            this.E = findViewById;
            findViewById.setOnClickListener(xl3.this.n);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setText(String.format(xl3.this.v, sellerOrderBean.getGoodsNum()));
            this.E.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends am3.c {
        public View D;

        public g(View view) {
            super(view);
            View findViewById = view.findViewById(d73.d0);
            this.D = findViewById;
            findViewById.setOnClickListener(xl3.this.o);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends am3.c {
        public TextView D;
        public View E;

        public h(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.T1);
            View findViewById = view.findViewById(d73.r1);
            this.E = findViewById;
            findViewById.setOnClickListener(xl3.this.p);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setText(String.format(xl3.this.v, sellerOrderBean.getGoodsNum()));
            this.E.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends am3.c {
        public TextView D;
        public View E;
        public View F;

        public i(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.L3);
            this.E = view.findViewById(d73.d0);
            this.F = view.findViewById(d73.Y0);
            this.E.setOnClickListener(xl3.this.o);
            this.F.setOnClickListener(xl3.this.q);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            TextView textView = this.D;
            String str = xl3.this.s;
            int refundType = sellerOrderBean.getRefundType();
            xl3 xl3Var = xl3.this;
            textView.setText(String.format(str, refundType == 0 ? xl3Var.t : xl3Var.u, xl3.this.k, sellerOrderBean.getTotalPrice()));
            this.E.setTag(sellerOrderBean);
            this.F.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends am3.c {
        public TextView D;
        public View E;

        public j(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.T1);
            View findViewById = view.findViewById(d73.e1);
            this.E = findViewById;
            findViewById.setOnClickListener(xl3.this.r);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setText(String.format(xl3.this.v, sellerOrderBean.getGoodsNum()));
            this.E.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    public xl3(Context context) {
        super(context);
        this.v = aq4.a(m93.P6);
        this.s = aq4.a(m93.Q6);
        this.t = aq4.a(m93.h7);
        this.u = aq4.a(m93.i7);
        this.n = new a();
        this.o = new b();
        this.p = new c();
        this.q = new d();
        this.r = new e();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        return i2 == -1 ? new f(this.f.inflate(z73.h1, viewGroup, false)) : i2 == 0 ? new g(this.f.inflate(z73.i1, viewGroup, false)) : i2 == 1 ? new j(this.f.inflate(z73.l1, viewGroup, false)) : i2 == 2 ? new h(this.f.inflate(z73.j1, viewGroup, false)) : i2 == 5 ? new i(this.f.inflate(z73.k1, viewGroup, false)) : new am3.c(this.f.inflate(z73.g1, viewGroup, false));
    }

    public int l(int i2) {
        int status = ((SellerOrderBean) this.e.get(i2)).getStatus();
        if (status == -1) {
            return -1;
        }
        if (status == 0) {
            return 0;
        }
        if (status == 1) {
            return 1;
        }
        if (status == 2 || status == 3) {
            return 2;
        }
        return (status != 4 && status == 5) ? 5 : -1;
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
        ((am3.c) e0Var).O((SellerOrderBean) this.e.get(i2));
    }
}
