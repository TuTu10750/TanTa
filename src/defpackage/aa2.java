package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.luckpan.bean.LuckpanResultBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class aa2 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.h2);
            this.v = (TextView) view.findViewById(b73.D1);
            this.w = (TextView) view.findViewById(b73.i2);
            this.x = (TextView) view.findViewById(b73.l5);
        }

        public void O(LuckpanResultBean luckpanResultBean) {
            kn1.f(aa2.this.d, luckpanResultBean.getGiftIcon(), this.u);
            this.v.setText(luckpanResultBean.getCount());
            this.w.setText(luckpanResultBean.getGiftNameTrans());
            this.x.setText(luckpanResultBean.getTotalCoin());
        }
    }

    public aa2(Context context, List list) {
        super(context, list);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.o0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((LuckpanResultBean) this.e.get(i));
    }
}
