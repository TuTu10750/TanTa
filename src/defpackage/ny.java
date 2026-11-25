package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ny extends RecyclerView.Adapter {
    public List d;
    public LayoutInflater e;
    public Drawable h;
    public Drawable i;
    public int j;
    public et2 l;
    public boolean m;
    public String f = j30.q().g();
    public String g = aq4.a(m93.p1);
    public View.OnClickListener k = new a();

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
            CoinPayBean2.ChargeConfigBean chargeConfigBean = (CoinPayBean2.ChargeConfigBean) ny.this.d.get(intValue);
            if (ny.this.j != intValue) {
                if (ny.this.j >= 0 && ny.this.j < ny.this.d.size()) {
                    ((CoinPayBean2.ChargeConfigBean) ny.this.d.get(ny.this.j)).setChecked(false);
                    ny nyVar = ny.this;
                    nyVar.r(nyVar.j, "payload");
                }
                chargeConfigBean.setChecked(true);
                ny.this.r(intValue, "payload");
                ny.this.j = intValue;
            }
            if (ny.this.l != null) {
                ny.this.l.onItemClick(chargeConfigBean, intValue);
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
            this.u = (TextView) view.findViewById(y63.w);
            this.v = (TextView) view.findViewById(y63.R);
            this.w = (TextView) view.findViewById(y63.H);
            this.x = view.findViewById(y63.b);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = (((gk3.a().c() - zn0.a(40)) / 3) * 135) / 220;
            view.setLayoutParams(layoutParams);
            view.setOnClickListener(ny.this.k);
        }

        public void O(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                TextView textView = this.u;
                boolean unused = ny.this.m;
                textView.setText(chargeConfigBean.getName());
                this.v.setText(rv3.a(ny.this.m ? "$" : "￥", chargeConfigBean.getMoney()));
            }
            View view = this.x;
            boolean isChecked = chargeConfigBean.isChecked();
            ny nyVar = ny.this;
            view.setBackground(isChecked ? nyVar.h : nyVar.i);
        }
    }

    public ny(Context context, List list) {
        this.e = LayoutInflater.from(context);
        this.d = list;
        this.h = o60.d(context, q83.b);
        this.i = o60.d(context, q83.a);
    }

    public CoinPayBean2.ChargeConfigBean T() {
        int i;
        List list = this.d;
        if (list == null || list.size() <= 0 || (i = this.j) < 0) {
            return null;
        }
        return (CoinPayBean2.ChargeConfigBean) this.d.get(i);
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((CoinPayBean2.ChargeConfigBean) this.d.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(u73.G, viewGroup, false));
    }

    public void X(boolean z) {
        if (this.m == z) {
            return;
        }
        this.m = z;
        p();
    }

    public void Y(et2 et2Var) {
        this.l = et2Var;
    }

    public int j() {
        return this.d.size();
    }
}
