package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class oy extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public Drawable g;
    public int h = 0;
    public View.OnClickListener i = new a();
    public et2 j;

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
            CoinPayBean2 coinPayBean2 = (CoinPayBean2) oy.this.e.get(intValue);
            if (oy.this.h != intValue) {
                if (oy.this.h >= 0 && oy.this.h < oy.this.e.size()) {
                    ((CoinPayBean2) oy.this.e.get(oy.this.h)).setChecked(false);
                    oy oyVar = oy.this;
                    oyVar.r(oyVar.h, "payload");
                }
                coinPayBean2.setChecked(true);
                oy.this.r(intValue, "payload");
                oy.this.h = intValue;
                if (oy.this.j != null) {
                    oy.this.j.onItemClick(coinPayBean2, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(y63.g0);
            this.v = (TextView) view.findViewById(y63.T);
            this.w = (ImageView) view.findViewById(y63.N);
            view.setOnClickListener(oy.this.i);
        }

        public void O(CoinPayBean2 coinPayBean2, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.f(oy.this.d, coinPayBean2.getThumb(), this.u);
                this.v.setText(coinPayBean2.getName());
            }
            this.w.setImageDrawable(coinPayBean2.isChecked() ? oy.this.g : null);
        }
    }

    public oy(Context context, List list) {
        this.d = context;
        this.f = LayoutInflater.from(context);
        this.e = list;
        this.g = o60.d(context, g63.c);
    }

    public CoinPayBean2 S() {
        int i;
        List list = this.e;
        if (list == null || (i = this.h) < 0 || i >= list.size()) {
            return null;
        }
        return (CoinPayBean2) this.e.get(this.h);
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((CoinPayBean2) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(u73.y, viewGroup, false));
    }

    public void W(et2 et2Var) {
        this.j = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
