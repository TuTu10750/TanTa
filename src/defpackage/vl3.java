package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.GoodsManageBean;

/* loaded from: /tmp/classes2.dex */
public class vl3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public c k;
    public String l;
    public String m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || vl3.this.k == null) {
                return;
            }
            vl3.this.k.a((GoodsManageBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements a.m {
            public final /* synthetic */ GoodsManageBean a;

            public a(GoodsManageBean goodsManageBean) {
                this.a = goodsManageBean;
            }

            @Override // com.yunbao.common.utils.a.m
            public void b(Dialog dialog, String str) {
                ec2.D0(this.a.getId());
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GoodsManageBean goodsManageBean = (GoodsManageBean) view.getTag();
            if (goodsManageBean != null) {
                new a.j(vl3.this.d).k(aq4.a(m93.C8)).g(true).o(true).d(true).h(new a(goodsManageBean)).c().show();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(GoodsManageBean goodsManageBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public View z;

        public d(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.R3);
            this.x = (TextView) view.findViewById(d73.k3);
            this.y = (TextView) view.findViewById(d73.n3);
            this.z = view.findViewById(d73.M);
            view.setOnClickListener(vl3.this.i);
            this.z.setOnClickListener(vl3.this.j);
        }

        public void O(GoodsManageBean goodsManageBean) {
            ((RecyclerView.e0) this).a.setTag(goodsManageBean);
            this.z.setTag(goodsManageBean);
            kn1.f(vl3.this.d, goodsManageBean.getThumb(), this.u);
            this.v.setText(goodsManageBean.getName());
            this.w.setText(String.format(vl3.this.l, goodsManageBean.getSaleNum()));
            this.x.setText(rv3.a(vl3.this.m, goodsManageBean.getPrice()));
            this.y.setText(rv3.a(vl3.this.n, vl3.this.m, goodsManageBean.getPriceYong()));
        }
    }

    public vl3(Context context) {
        super(context);
        this.l = aq4.a(m93.f6);
        this.m = aq4.a(m93.O8);
        this.n = aq4.a(m93.A8);
        this.i = new a();
        this.j = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(z73.f1, viewGroup, false));
    }

    public void a0(c cVar) {
        this.k = cVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((d) e0Var).O((GoodsManageBean) this.e.get(i));
    }
}
