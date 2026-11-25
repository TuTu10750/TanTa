package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LuckPanBean;

/* loaded from: /tmp/classes2.dex */
public class q92 extends ce3 {
    public boolean i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public TextView x;

        public a(View view) {
            super(view);
            if (q92.this.i) {
                this.u = (TextView) view.findViewById(b73.l4);
            }
            this.v = (TextView) view.findViewById(b73.e5);
            this.w = (ImageView) view.findViewById(b73.M2);
            this.x = (TextView) view.findViewById(b73.D1);
        }

        public void O(LuckPanBean luckPanBean, int i) {
            if (q92.this.i) {
                this.u.setText(String.valueOf(i + 1));
            }
            this.v.setText(luckPanBean.getAddtime());
            this.x.setText("x" + luckPanBean.getNums());
            kn1.f(q92.this.d, luckPanBean.getThumb(), this.w);
        }
    }

    public q92(Context context, boolean z) {
        super(context);
        this.i = z;
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(this.i ? x73.l1 : x73.k1, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((LuckPanBean) this.e.get(i), i);
    }
}
