package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CountryBean;

/* loaded from: /tmp/classes2.dex */
public class qq1 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (qq1.this.L() && (tag = view.getTag()) != null) {
                qq1.this.h.onItemClick((CountryBean) tag, 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(y63.l0);
            this.v = (TextView) view.findViewById(y63.k0);
            view.setOnClickListener(qq1.this.i);
        }

        public void O(CountryBean countryBean) {
            ((RecyclerView.e0) this).a.setTag(countryBean);
            this.u.setText(countryBean.getName() + " " + countryBean.getName_en());
            TextView textView = this.v;
            StringBuilder sb = new StringBuilder("+");
            sb.append(countryBean.getTel());
            textView.setText(sb.toString());
        }
    }

    public qq1(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(u73.H, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((CountryBean) this.e.get(i));
    }
}
