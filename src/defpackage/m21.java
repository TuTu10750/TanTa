package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CoinPayBean2;

/* loaded from: /tmp/classes2.dex */
public class m21 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            et2 et2Var;
            CoinPayBean2 coinPayBean2 = (CoinPayBean2) view.getTag();
            if (coinPayBean2 == null || (et2Var = m21.this.h) == null) {
                return;
            }
            et2Var.onItemClick(coinPayBean2, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(y63.g0);
            this.v = (TextView) view.findViewById(y63.T);
            view.setOnClickListener(m21.this.i);
        }

        public void O(CoinPayBean2 coinPayBean2) {
            ((RecyclerView.e0) this).a.setTag(coinPayBean2);
            kn1.f(m21.this.d, coinPayBean2.getThumb(), this.u);
            this.v.setText(coinPayBean2.getName());
        }
    }

    public m21(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(u73.J, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((CoinPayBean2) this.e.get(i));
    }
}
