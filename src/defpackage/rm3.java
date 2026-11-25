package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsManageBean;

/* loaded from: /tmp/classes2.dex */
public class rm3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public e m;
    public String n;
    public String o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || rm3.this.m == null) {
                return;
            }
            rm3.this.m.a((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || rm3.this.m == null) {
                return;
            }
            rm3.this.m.d((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || rm3.this.m == null) {
                return;
            }
            rm3.this.m.f((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || rm3.this.m == null) {
                return;
            }
            rm3.this.m.G((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface e {
        void G(GoodsManageBean goodsManageBean);

        void a(GoodsManageBean goodsManageBean);

        void d(GoodsManageBean goodsManageBean);

        void f(GoodsManageBean goodsManageBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends RecyclerView.e0 {
        public View A;
        public View B;
        public View C;
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public View z;

        public f(View view) {
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
            this.B = view.findViewById(d73.g1);
            this.C = view.findViewById(d73.d3);
            view.setOnClickListener(rm3.this.i);
            this.z.setOnClickListener(rm3.this.j);
            this.A.setOnClickListener(rm3.this.k);
            this.B.setOnClickListener(rm3.this.l);
        }

        public void O(GoodsManageBean goodsManageBean) {
            ((RecyclerView.e0) this).a.setTag(goodsManageBean);
            this.z.setTag(goodsManageBean);
            this.A.setTag(goodsManageBean);
            this.B.setTag(goodsManageBean);
            kn1.f(rm3.this.d, goodsManageBean.getThumb(), this.u);
            this.v.setText(goodsManageBean.getName());
            this.w.setText(String.format(rm3.this.n, goodsManageBean.getSaleNum()));
            this.x.setText(rv3.a(rm3.this.o, goodsManageBean.getPrice()));
            int type = goodsManageBean.getType();
            TextView textView = this.w;
            if (type != 1) {
                textView.setText(String.format(rm3.this.n, goodsManageBean.getSaleNum()));
                if (this.y.getVisibility() == 0) {
                    this.y.setVisibility(4);
                }
                if (this.C.getVisibility() != 8) {
                    this.C.setVisibility(8);
                    return;
                }
                return;
            }
            textView.setText((CharSequence) null);
            if (this.y.getVisibility() != 0) {
                this.y.setVisibility(4);
            }
            this.y.setText(rv3.a(rm3.this.o, goodsManageBean.getOriginPrice()));
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
        }
    }

    public rm3(Context context) {
        super(context);
        this.n = aq4.a(m93.f6);
        this.o = aq4.a(m93.O8);
        this.i = new a();
        this.j = new b();
        this.k = new c();
        this.l = new d();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new f(this.f.inflate(z73.q1, viewGroup, false));
    }

    public void a0(e eVar) {
        this.m = eVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((f) e0Var).O((GoodsManageBean) this.e.get(i));
    }
}
