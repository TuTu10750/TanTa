package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsManageBean;

/* loaded from: /tmp/classes2.dex */
public class om3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public d l;
    public String m;
    public String n;
    public String o;
    public String p;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || om3.this.l == null) {
                return;
            }
            om3.this.l.a((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || om3.this.l == null) {
                return;
            }
            om3.this.l.d((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || om3.this.l == null) {
                return;
            }
            om3.this.l.f((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        void a(GoodsManageBean goodsManageBean);

        void d(GoodsManageBean goodsManageBean);

        void f(GoodsManageBean goodsManageBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public View A;
        public View B;
        public TextView C;
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public View z;

        public e(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.R3);
            this.x = (TextView) view.findViewById(d73.k3);
            TextView textView = (TextView) view.findViewById(d73.c3);
            this.y = textView;
            textView.getPaint().setFlags(16);
            this.z = view.findViewById(d73.q0);
            this.A = view.findViewById(d73.i0);
            this.B = view.findViewById(d73.d3);
            this.C = (TextView) view.findViewById(d73.a4);
            view.setOnClickListener(om3.this.i);
            this.z.setOnClickListener(om3.this.j);
            this.A.setOnClickListener(om3.this.k);
        }

        public void O(GoodsManageBean goodsManageBean) {
            ((RecyclerView.e0) this).a.setTag(goodsManageBean);
            this.z.setTag(goodsManageBean);
            this.A.setTag(goodsManageBean);
            kn1.f(om3.this.d, goodsManageBean.getThumb(), this.u);
            this.v.setText(goodsManageBean.getName());
            this.x.setText(rv3.a(om3.this.n, goodsManageBean.getPrice()));
            int type = goodsManageBean.getType();
            TextView textView = this.w;
            if (type == 1) {
                textView.setText((CharSequence) null);
                if (this.y.getVisibility() != 0) {
                    this.y.setVisibility(4);
                }
                this.y.setText(rv3.a(om3.this.n, goodsManageBean.getOriginPrice()));
                if (this.B.getVisibility() != 0) {
                    this.B.setVisibility(0);
                }
            } else {
                textView.setText(String.format(om3.this.m, goodsManageBean.getSaleNum()));
                if (this.y.getVisibility() == 0) {
                    this.y.setVisibility(4);
                }
                if (this.B.getVisibility() != 8) {
                    this.B.setVisibility(8);
                }
            }
            if (goodsManageBean.getStatus() == 0) {
                this.C.setText(om3.this.o);
                return;
            }
            int status = goodsManageBean.getStatus();
            TextView textView2 = this.C;
            if (status == 2) {
                textView2.setText(om3.this.p);
            } else {
                textView2.setText((CharSequence) null);
            }
        }
    }

    public om3(Context context) {
        super(context);
        this.m = aq4.a(m93.f6);
        this.n = aq4.a(m93.O8);
        this.i = new a();
        this.j = new b();
        this.k = new c();
        this.o = aq4.a(m93.g6);
        this.p = aq4.a(m93.m8);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new e(this.f.inflate(z73.o1, viewGroup, false));
    }

    public void b0(d dVar) {
        this.l = dVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((e) e0Var).O((GoodsManageBean) this.e.get(i));
    }
}
