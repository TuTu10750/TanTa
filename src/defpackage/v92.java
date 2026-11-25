package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.luckpan.bean.LuckRankBean;

/* loaded from: /tmp/classes2.dex */
public class v92 extends ce3 {
    public Drawable i;
    public Drawable j;
    public Drawable k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public TextView x;
        public TextView y;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.A4);
            this.v = (TextView) view.findViewById(b73.z4);
            this.w = (ImageView) view.findViewById(b73.d);
            this.x = (TextView) view.findViewById(b73.X3);
            this.y = (TextView) view.findViewById(b73.s1);
        }

        public void O(LuckRankBean luckRankBean, int i) {
            if (i > 2) {
                if (this.v.getVisibility() != 0) {
                    this.v.setVisibility(0);
                }
                if (this.u.getVisibility() != 4) {
                    this.u.setVisibility(4);
                }
                this.v.setText(String.valueOf(i + 1));
            } else {
                if (this.u.getVisibility() != 0) {
                    this.u.setVisibility(0);
                }
                if (this.v.getVisibility() != 4) {
                    this.v.setVisibility(4);
                }
                this.u.setText(String.valueOf(i + 1));
                if (i == 0) {
                    this.u.setBackground(v92.this.i);
                } else if (i == 1) {
                    this.u.setBackground(v92.this.j);
                } else if (i == 2) {
                    this.u.setBackground(v92.this.k);
                }
            }
            kn1.g(v92.this.d, luckRankBean.getAvatar(), this.w);
            this.x.setText(luckRankBean.getUserName());
            this.y.setText(luckRankBean.getCoin());
        }
    }

    public v92(Context context) {
        super(context);
        this.i = o60.d(context, h63.s);
        this.j = o60.d(context, h63.t);
        this.k = o60.d(context, h63.u);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.r0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((LuckRankBean) this.e.get(i), i);
    }
}
