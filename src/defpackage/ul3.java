package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.bean.GoodsPlatBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ul3 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public String k;
    public String l;
    public String m;
    public int n;
    public int o;
    public Drawable p;
    public Drawable q;
    public String r;
    public String s;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            GoodsPlatBean goodsPlatBean;
            if (ul3.this.L() && (goodsPlatBean = (GoodsPlatBean) view.getTag()) != null) {
                GoodsDetailActivity.t2(ul3.this.d, goodsPlatBean.getId(), goodsPlatBean.getType());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ul3.this.L()) {
                ec2.D0(((GoodsPlatBean) view.getTag()).getId());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (TextView) view.findViewById(d73.k3);
            this.x = (TextView) view.findViewById(d73.R3);
            this.y = (TextView) view.findViewById(d73.n3);
            TextView textView = (TextView) view.findViewById(d73.q);
            this.z = textView;
            textView.setOnClickListener(ul3.this.j);
            view.setOnClickListener(ul3.this.i);
        }

        public void O(GoodsPlatBean goodsPlatBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(goodsPlatBean);
                this.z.setTag(goodsPlatBean);
                kn1.f(ul3.this.d, goodsPlatBean.getThumb(), this.u);
                this.v.setText(goodsPlatBean.getName());
                this.w.setText(rv3.a(ul3.this.l, goodsPlatBean.getPrice()));
                this.x.setText(String.format(ul3.this.k, goodsPlatBean.getSaleNum()));
                this.y.setText(rv3.a(ul3.this.m, ul3.this.l, goodsPlatBean.getPriceYong()));
            }
            int add = goodsPlatBean.getAdd();
            TextView textView = this.z;
            if (add == 1) {
                textView.setText(ul3.this.r);
                this.z.setTextColor(ul3.this.n);
                this.z.setBackground(ul3.this.p);
            } else {
                textView.setText(ul3.this.s);
                this.z.setTextColor(ul3.this.o);
                this.z.setBackground(ul3.this.q);
            }
        }
    }

    public ul3(Context context) {
        super(context);
        this.k = aq4.a(m93.f6);
        this.l = aq4.a(m93.O8);
        this.m = aq4.a(m93.A8);
        this.n = o60.b(this.d, p53.h);
        this.o = o60.b(this.d, p53.n);
        this.p = o60.d(this.d, y53.g);
        this.q = o60.d(this.d, y53.f);
        this.r = aq4.a(m93.I0);
        this.s = aq4.a(m93.H0);
        this.i = new a();
        this.j = new b();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((GoodsPlatBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new c(this.f.inflate(z73.m1, viewGroup, false)) : new c(this.f.inflate(z73.n1, viewGroup, false));
    }

    public void h0(String str, int i) {
        List list;
        if (TextUtils.isEmpty(str) || (list = this.e) == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            GoodsPlatBean goodsPlatBean = (GoodsPlatBean) this.e.get(i2);
            if (str.equals(goodsPlatBean.getId())) {
                goodsPlatBean.setAdd(i);
                r(i2, "payload");
                return;
            }
        }
    }

    public int l(int i) {
        return i % 2 == 0 ? 1 : 2;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
