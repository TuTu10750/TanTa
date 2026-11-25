package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.FirstChargeItemBean;

/* loaded from: /tmp/classes2.dex */
public class j21 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(y63.M);
            this.v = (TextView) view.findViewById(y63.T);
            this.w = (TextView) view.findViewById(y63.z);
        }

        public void O(FirstChargeItemBean firstChargeItemBean) {
            kn1.f(j21.this.d, firstChargeItemBean.getIcon(), this.u);
            this.w.setText(rv3.a("x", firstChargeItemBean.getCount()));
            this.v.setText(firstChargeItemBean.getName());
        }
    }

    public j21(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(u73.I, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((FirstChargeItemBean) this.e.get(i));
    }
}
