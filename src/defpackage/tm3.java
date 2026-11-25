package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsManageBean;

/* loaded from: /tmp/classes2.dex */
public class tm3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public d l;
    public String m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || tm3.this.l == null) {
                return;
            }
            tm3.this.l.a((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || tm3.this.l == null) {
                return;
            }
            tm3.this.l.Q((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || tm3.this.l == null) {
                return;
            }
            tm3.this.l.D((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        void D(GoodsManageBean goodsManageBean);

        void Q(GoodsManageBean goodsManageBean);

        void a(GoodsManageBean goodsManageBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public View A;
        public View B;
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
            this.z = view.findViewById(d73.O0);
            this.B = view.findViewById(d73.d3);
            this.A = view.findViewById(d73.t1);
            view.setOnClickListener(tm3.this.i);
            this.z.setOnClickListener(tm3.this.j);
            this.A.setOnClickListener(tm3.this.k);
        }

        public void O(GoodsManageBean goodsManageBean) {
            ((RecyclerView.e0) this).a.setTag(goodsManageBean);
            this.z.setTag(goodsManageBean);
            this.A.setTag(goodsManageBean);
            kn1.f(tm3.this.d, goodsManageBean.getThumb(), this.u);
            this.v.setText(goodsManageBean.getName());
            this.w.setText(String.format(tm3.this.m, goodsManageBean.getSaleNum()));
            this.x.setText(rv3.a(tm3.this.n, goodsManageBean.getPrice()));
            int type = goodsManageBean.getType();
            TextView textView = this.w;
            if (type != 1) {
                textView.setText(String.format(tm3.this.m, goodsManageBean.getSaleNum()));
                if (this.y.getVisibility() == 0) {
                    this.y.setVisibility(4);
                }
                if (this.B.getVisibility() != 8) {
                    this.B.setVisibility(8);
                }
                if (this.z.getVisibility() != 0) {
                    this.z.setVisibility(0);
                    return;
                }
                return;
            }
            textView.setText((CharSequence) null);
            if (this.y.getVisibility() != 0) {
                this.y.setVisibility(4);
            }
            this.y.setText(rv3.a(tm3.this.n, goodsManageBean.getOriginPrice()));
            if (this.B.getVisibility() != 0) {
                this.B.setVisibility(0);
            }
            if (this.z.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
        }
    }

    public tm3(Context context) {
        super(context);
        this.m = aq4.a(m93.f6);
        this.n = aq4.a(m93.O8);
        this.i = new a();
        this.j = new b();
        this.k = new c();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new e(this.f.inflate(z73.r1, viewGroup, false));
    }

    public void Z(d dVar) {
        this.l = dVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((e) e0Var).O((GoodsManageBean) this.e.get(i));
    }
}
