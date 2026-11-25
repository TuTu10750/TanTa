package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.main.bean.GoodsShareUserBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class nd1 extends ce3 {
    public View.OnClickListener i;
    public Drawable j;
    public Drawable k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            ((GoodsShareUserBean) nd1.this.e.get(intValue)).setChecked(!r0.isChecked());
            nd1.this.r(intValue, "payload");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView A;
        public ImageView u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public ImageView y;
        public ImageView z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.K2);
            this.v = (ImageView) view.findViewById(c73.l);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.z4);
            this.y = (ImageView) view.findViewById(c73.x4);
            this.z = (ImageView) view.findViewById(c73.v3);
            this.A = (ImageView) view.findViewById(c73.u3);
            view.setOnClickListener(nd1.this.i);
        }

        public void O(GoodsShareUserBean goodsShareUserBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                kn1.g(nd1.this.d, goodsShareUserBean.getAvatar(), this.v);
                this.w.setText(goodsShareUserBean.getUserNiceName());
                this.x.setText(goodsShareUserBean.getSignature());
                this.y.setImageResource(l30.b(goodsShareUserBean.getSex()));
                LevelBean c = j30.q().c(goodsShareUserBean.getLevelAnchor());
                if (c != null) {
                    kn1.f(nd1.this.d, c.getThumb(), this.z);
                }
                LevelBean s = j30.q().s(goodsShareUserBean.getLevel());
                if (s != null) {
                    kn1.f(nd1.this.d, s.getThumb(), this.A);
                }
            }
            ImageView imageView = this.u;
            boolean isChecked = goodsShareUserBean.isChecked();
            nd1 nd1Var = nd1.this;
            imageView.setImageDrawable(isChecked ? nd1Var.j : nd1Var.k);
        }
    }

    public nd1(Context context) {
        super(context);
        this.j = o60.d(context, v83.b);
        this.k = o60.d(context, v83.a);
        this.i = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((GoodsShareUserBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.x0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
