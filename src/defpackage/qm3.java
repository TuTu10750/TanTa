package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.WuliuBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class qm3 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || qm3.this.h == null) {
                return;
            }
            qm3.this.h.onItemClick((WuliuBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.j4);
            this.v = (TextView) view.findViewById(d73.R2);
            view.setOnClickListener(qm3.this.i);
        }

        public void O(WuliuBean wuliuBean) {
            ((RecyclerView.e0) this).a.setTag(wuliuBean);
            kn1.f(qm3.this.d, wuliuBean.getThumb(), this.u);
            this.v.setText(wuliuBean.getName());
        }
    }

    public qm3(Context context, List list) {
        super(context, list);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.p1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((WuliuBean) this.e.get(i));
    }
}
