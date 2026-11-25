package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.im.bean.SystemMessageBean;

/* loaded from: /tmp/classes2.dex */
public class i14 extends ce3 {
    public Drawable i;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(a73.G);
            this.v = (TextView) view.findViewById(a73.m0);
            this.w = (ImageView) view.findViewById(a73.O);
        }

        public void O(SystemMessageBean systemMessageBean) {
            this.u.setText(systemMessageBean.getContent());
            this.v.setText(systemMessageBean.getAddtime());
            this.w.setImageDrawable(i14.this.i);
        }
    }

    public i14(Context context) {
        super(context);
        int d = j30.q().d();
        if (d != 0) {
            this.i = o60.d(context, d);
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(w73.y, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((SystemMessageBean) this.e.get(i));
    }
}
