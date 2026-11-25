package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerOrderBean;
import defpackage.ol;

/* loaded from: /tmp/classes2.dex */
public class tl extends ol {
    public View.OnClickListener n;
    public View.OnClickListener o;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = tl.this.m) == null) {
                return;
            }
            cVar.L((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ol.c cVar;
            Object tag = view.getTag();
            if (tag == null || (cVar = tl.this.m) == null) {
                return;
            }
            cVar.i((BuyerOrderBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends ol.d {
        public View E;
        public View F;

        public c(View view) {
            super(view);
            this.E = view.findViewById(d73.r1);
            this.F = view.findViewById(d73.b0);
            this.E.setOnClickListener(tl.this.n);
            this.F.setOnClickListener(tl.this.o);
        }

        @Override // ol.d
        public void O(BuyerOrderBean buyerOrderBean) {
            this.E.setTag(buyerOrderBean);
            this.F.setTag(buyerOrderBean);
            super.O(buyerOrderBean);
        }
    }

    public tl(Context context) {
        super(context);
        this.n = new a();
        this.o = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(z73.v0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((BuyerOrderBean) this.e.get(i));
    }
}
