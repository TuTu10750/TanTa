package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class sl4 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater f;
    public et2 h;
    public int i = (gk3.a().c() - zn0.a(56)) / 3;
    public int j = 0;
    public List e = new ArrayList();
    public View.OnClickListener g = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                CoinPayBean2.ChargeConfigBean chargeConfigBean = (CoinPayBean2.ChargeConfigBean) sl4.this.e.get(intValue);
                if (sl4.this.h != null) {
                    sl4.this.h.onItemClick(chargeConfigBean, intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.v = (TextView) view.findViewById(c73.V4);
            this.u = (TextView) view.findViewById(c73.T4);
            this.w = (TextView) view.findViewById(c73.g5);
            view.setOnClickListener(sl4.this.g);
        }

        public void O(CoinPayBean2.ChargeConfigBean chargeConfigBean, int i) {
            this.u.setText(chargeConfigBean.getName());
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            boolean isEmpty = chargeConfigBean.getRemark().isEmpty();
            TextView textView = this.w;
            if (isEmpty) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                this.w.setText(chargeConfigBean.getRemark());
            }
            SpannableString spannableString = new SpannableString("￥" + chargeConfigBean.getMoney());
            spannableString.setSpan(new AbsoluteSizeSpan(14, true), 0, 1, 33);
            this.v.setText(spannableString);
            ViewGroup.LayoutParams layoutParams = ((RecyclerView.e0) this).a.getLayoutParams();
            layoutParams.width = sl4.this.i;
            ((RecyclerView.e0) this).a.setLayoutParams(layoutParams);
            int i2 = sl4.this.j;
            View view = ((RecyclerView.e0) this).a;
            if (i2 == i) {
                view.setBackgroundResource(i63.a);
            } else {
                view.setBackgroundResource(i63.b);
            }
        }
    }

    public sl4(Context context) {
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((CoinPayBean2.ChargeConfigBean) this.e.get(i), i);
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.S0, viewGroup, false));
    }

    public void R(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.e.clear();
        ((CoinPayBean2.ChargeConfigBean) list.get(0)).setChecked(true);
        this.e.addAll(list);
        p();
    }

    public void S(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
