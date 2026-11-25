package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.GoodsClassBean;

/* loaded from: /tmp/classes2.dex */
public class ed1 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ed1.this.h == null) {
                return;
            }
            ed1.this.h.onItemClick((GoodsClassBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends c {
        public b(View view) {
            super(view);
            view.setOnClickListener(ed1.this.i);
        }

        @Override // ed1.c
        public void O(GoodsClassBean goodsClassBean) {
            ((RecyclerView.e0) this).a.setTag(goodsClassBean);
            super.O(goodsClassBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.h4);
        }

        public void O(GoodsClassBean goodsClassBean) {
            this.u.setText(goodsClassBean.getName());
        }
    }

    public ed1(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == -1 ? new c(this.f.inflate(z73.C0, viewGroup, false)) : new b(this.f.inflate(z73.B0, viewGroup, false));
    }

    public int l(int i) {
        return ((GoodsClassBean) this.e.get(i)).isTitle() ? -1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((GoodsClassBean) this.e.get(i));
    }
}
