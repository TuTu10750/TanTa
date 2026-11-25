package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.SellerOrderBean;
import defpackage.am3;

/* loaded from: /tmp/classes2.dex */
public class fm3 extends am3 {
    public View.OnClickListener n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            am3.b bVar;
            Object tag = view.getTag();
            if (tag == null || (bVar = fm3.this.m) == null) {
                return;
            }
            bVar.B((SellerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends am3.c {
        public View D;

        public b(View view) {
            super(view);
            View findViewById = view.findViewById(d73.d0);
            this.D = findViewById;
            findViewById.setOnClickListener(fm3.this.n);
        }

        @Override // am3.c
        public void O(SellerOrderBean sellerOrderBean) {
            this.D.setTag(sellerOrderBean);
            super.O(sellerOrderBean);
        }
    }

    public fm3(Context context) {
        super(context);
        this.n = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.i1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((SellerOrderBean) this.e.get(i));
    }
}
