package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.luckpan.bean.LuckpanRecordGiftBean;

/* loaded from: /tmp/classes2.dex */
public class z92 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.h2);
            this.v = (TextView) view.findViewById(b73.D1);
        }

        public void O(LuckpanRecordGiftBean luckpanRecordGiftBean) {
            kn1.f(z92.this.d, luckpanRecordGiftBean.getGiftIcon(), this.u);
            this.v.setText(luckpanRecordGiftBean.getCount());
        }
    }

    public z92(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.n0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((LuckpanRecordGiftBean) this.e.get(i));
    }
}
