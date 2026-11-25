package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class k20 extends RecyclerView.Adapter {
    public String d;
    public LayoutInflater g;
    public et2 i;
    public Drawable j;
    public Drawable k;
    public boolean m;
    public int l = 0;
    public int n = (gk3.a().c() - zn0.a(56)) / 3;
    public List e = new ArrayList();
    public String f = aq4.a(m93.p1);
    public View.OnClickListener h = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            CoinPayBean2.ChargeConfigBean chargeConfigBean = (CoinPayBean2.ChargeConfigBean) k20.this.e.get(intValue);
            if (k20.this.i != null) {
                k20.this.i.onItemClick(chargeConfigBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;
        public View x;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.C1);
            this.v = (TextView) view.findViewById(c73.K3);
            this.w = (TextView) view.findViewById(y63.H);
            this.x = view.findViewById(c73.x);
            view.setOnClickListener(k20.this.h);
        }

        public void O(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i, Object obj) {
            ViewGroup.LayoutParams layoutParams = ((RecyclerView.e0) this).a.getLayoutParams();
            layoutParams.height = k20.this.n;
            ((RecyclerView.e0) this).a.setLayoutParams(layoutParams);
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.u.setText(chargeConfigBean.getName());
                this.v.setText(rv3.a(k20.this.m ? "$" : "￥", chargeConfigBean.getMoney()));
            }
            View view = this.x;
            k20 k20Var = k20.this;
            view.setBackground(k20Var.l == i ? k20Var.j : k20Var.k);
        }
    }

    public k20(Context context, String str) {
        this.d = str;
        this.g = LayoutInflater.from(context);
        this.j = o60.d(context, i63.a);
        this.k = o60.d(context, i63.b);
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        Object obj = list.size() > 0 ? list.get(0) : null;
        if (e0Var instanceof b) {
            ((b) e0Var).O((CoinPayBean2.ChargeConfigBean) this.e.get(i), i, obj);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.g.inflate(u73.F, viewGroup, false));
    }

    public CoinPayBean2.ChargeConfigBean S() {
        int i;
        List list = this.e;
        if (list == null || list.size() <= 0 || (i = this.l) < 0) {
            return null;
        }
        return (CoinPayBean2.ChargeConfigBean) this.e.get(i);
    }

    public void T(boolean z) {
        if (this.m == z) {
            return;
        }
        this.m = z;
        p();
    }

    public void U(List list) {
        this.l = 0;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.e.clear();
        ((CoinPayBean2.ChargeConfigBean) list.get(0)).setChecked(true);
        this.e.addAll(list);
        p();
    }

    public void V(et2 et2Var) {
        this.i = et2Var;
    }

    public int j() {
        return this.e.size();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
