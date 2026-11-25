package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.TurntableGiftBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class t92 extends RecyclerView.Adapter {
    public final Context d;
    public List e;
    public LayoutInflater f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.R2);
            this.v = (TextView) view.findViewById(b73.c5);
        }

        public void O(TurntableGiftBean turntableGiftBean, int i, Object obj) {
            if (obj == null) {
                kn1.f(t92.this.d, turntableGiftBean.getThumb(), this.u);
                this.v.setText(turntableGiftBean.getName() + "x" + turntableGiftBean.getNums());
            }
        }
    }

    public t92(Context context, List list) {
        this.f = LayoutInflater.from(context);
        this.d = context;
        this.e = list;
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, int i) {
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public void A(a aVar, int i, List list) {
        aVar.O((TurntableGiftBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.m1, viewGroup, false));
    }

    public int j() {
        return this.e.size();
    }
}
