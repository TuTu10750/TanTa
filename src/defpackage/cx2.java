package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.PayContentClassBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class cx2 extends ce3 {
    public Drawable i;
    public View.OnClickListener j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || cx2.this.h == null) {
                return;
            }
            cx2.this.h.onItemClick((PayContentClassBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.R2);
            this.v = (ImageView) view.findViewById(d73.x2);
            view.setOnClickListener(cx2.this.j);
        }

        public void O(PayContentClassBean payContentClassBean, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(payContentClassBean);
                this.u.setText(payContentClassBean.getName());
            }
            this.v.setImageDrawable(payContentClassBean.isChecked() ? cx2.this.i : null);
        }
    }

    public cx2(Context context) {
        super(context);
        this.i = o60.d(context, v83.b);
        this.j = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((PayContentClassBean) this.e.get(i), list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.V0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
