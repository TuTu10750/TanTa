package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.GuardRightBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class de1 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.i5);
            this.w = (TextView) view.findViewById(b73.I1);
        }

        public void O(GuardRightBean guardRightBean) {
            this.v.setText(guardRightBean.getTitle());
            this.w.setText(guardRightBean.getDes());
            boolean isChecked = guardRightBean.isChecked();
            de1 de1Var = de1.this;
            if (isChecked) {
                kn1.f(de1Var.d, guardRightBean.getIcon1(), this.u);
            } else {
                kn1.f(de1Var.d, guardRightBean.getIcon0(), this.u);
            }
        }
    }

    public de1(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, int i) {
        aVar.O((GuardRightBean) this.e.get(i));
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.B0, viewGroup, false));
    }

    public int j() {
        return this.e.size();
    }
}
