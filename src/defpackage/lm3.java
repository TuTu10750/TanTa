package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SellerOrderBean;
import defpackage.am3;

/* loaded from: /tmp/classes2.dex */
public class lm3 extends am3 {
    public View.OnClickListener n;
    public String o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = lm3.this.m) == null) {
                return;
            }
            bVar.m((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends am3.c {
        public TextView D;
        public View E;

        public b(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.T1);
            View findViewById = view.findViewById(d73.e1);
            this.E = findViewById;
            findViewById.setOnClickListener(lm3.this.n);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setText(String.format(lm3.this.o, sellerOrderBean.getGoodsNum()));
            this.E.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    public lm3(Context context) {
        super(context);
        this.o = aq4.a(m93.P6);
        this.n = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.l1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((SellerOrderBean) this.e.get(i));
    }
}
