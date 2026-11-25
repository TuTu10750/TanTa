package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.star.bean.StarRecordGiftBean;

/* loaded from: /tmp/classes2.dex */
public class ut3 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.h2);
            this.v = (TextView) view.findViewById(b73.D1);
        }

        public void O(StarRecordGiftBean starRecordGiftBean) {
            kn1.f(ut3.this.d, starRecordGiftBean.getGiftIcon(), this.u);
            this.v.setText(starRecordGiftBean.getCount());
        }
    }

    public ut3(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.u0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((StarRecordGiftBean) this.e.get(i));
    }
}
