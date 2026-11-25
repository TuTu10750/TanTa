package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerOrderBean;
import defpackage.ol;

/* loaded from: /tmp/classes2.dex */
public class vl extends ol {
    public View.OnClickListener n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = vl.this.m) == null) {
                return;
            }
            cVar.P((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends ol.d {
        public View E;

        public b(View view) {
            super(view);
            View findViewById = view.findViewById(d73.V0);
            this.E = findViewById;
            findViewById.setOnClickListener(vl.this.n);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    public vl(Context context) {
        super(context);
        this.n = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.w0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((BuyerOrderBean) this.e.get(i));
    }
}
