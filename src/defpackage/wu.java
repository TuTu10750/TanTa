package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.bean.CancelConditionBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class wu extends ce3 {
    public Drawable i;
    public Drawable j;
    public int k;
    public int l;
    public String m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public TextView x;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.H4);
            this.v = (TextView) view.findViewById(c73.J1);
            this.w = (ImageView) view.findViewById(c73.I2);
            this.x = (TextView) view.findViewById(c73.A4);
        }

        public void O(CancelConditionBean cancelConditionBean) {
            this.u.setText(cancelConditionBean.getTitle());
            this.v.setText(cancelConditionBean.getContent());
            int isOK = cancelConditionBean.getIsOK();
            TextView textView = this.x;
            if (isOK == 1) {
                textView.setText(wu.this.n);
                this.x.setTextColor(wu.this.l);
                this.w.setImageDrawable(wu.this.j);
            } else {
                textView.setText(wu.this.m);
                this.x.setTextColor(wu.this.k);
                this.w.setImageDrawable(wu.this.i);
            }
        }
    }

    public wu(Context context, List list) {
        super(context, list);
        this.i = o60.d(context, u83.m);
        this.j = o60.d(context, u83.n);
        this.k = o60.b(context, p53.g);
        this.l = o60.b(context, p53.h);
        this.m = aq4.a(m93.X0);
        this.n = aq4.a(m93.W0);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(y73.t0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((CancelConditionBean) this.e.get(i));
    }
}
