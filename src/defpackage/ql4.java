package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ql4 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater f;
    public et2 h;
    public int i = 0;
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
                ql4 ql4Var = ql4.this;
                if (ql4Var.i == intValue) {
                    return;
                }
                CoinPayBean2 coinPayBean2 = (CoinPayBean2) ql4Var.e.get(intValue);
                if (ql4.this.h != null) {
                    ql4.this.h.onItemClick(coinPayBean2, intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.o3);
            this.v = (TextView) view.findViewById(c73.T4);
            view.setOnClickListener(ql4.this.g);
        }

        public void O(CoinPayBean2 coinPayBean2, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            this.v.setText(coinPayBean2.getName());
            kn1.f(ql4.this.d, coinPayBean2.getThumb(), this.u);
            int i2 = ql4.this.i;
            View view = ((RecyclerView.e0) this).a;
            if (i2 == i) {
                view.setBackgroundResource(i63.c);
                this.v.setTextColor(-1);
            } else {
                view.setBackgroundResource(i63.d);
                this.v.setTextColor(-10066330);
            }
        }
    }

    public ql4(Context context) {
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    public CoinPayBean2 P() {
        int i;
        CoinPayBean2 coinPayBean2;
        List list = this.e;
        if (list == null || list.size() <= 0 || (i = this.i) < 0 || i >= this.e.size() || (coinPayBean2 = (CoinPayBean2) this.e.get(this.i)) == null) {
            return null;
        }
        return coinPayBean2;
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
        bVar.O((CoinPayBean2) this.e.get(i), i);
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.Q0, viewGroup, false));
    }

    public void S(List list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.e.clear();
        ((CoinPayBean2) list.get(0)).setChecked(true);
        this.e.addAll(list);
        p();
    }

    public void T(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
