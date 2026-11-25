package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LiveClassBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class lb2 extends ce3 {
    public int i;
    public int j;
    public Drawable k;
    public Drawable l;
    public View.OnClickListener m;
    public int n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue;
            Object tag = view.getTag();
            if (tag == null || lb2.this.n == (intValue = ((Integer) tag).intValue())) {
                return;
            }
            ((LiveClassBean) lb2.this.e.get(lb2.this.n)).setChecked(false);
            lb2 lb2Var = lb2.this;
            lb2Var.r(lb2Var.n, "payload");
            LiveClassBean liveClassBean = (LiveClassBean) lb2.this.e.get(intValue);
            liveClassBean.setChecked(true);
            lb2.this.r(intValue, "payload");
            lb2.this.n = intValue;
            if (lb2.this.h != null) {
                lb2.this.h.onItemClick(liveClassBean, intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.C4);
            view.setOnClickListener(lb2.this.m);
        }

        public void O(LiveClassBean liveClassBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
                this.u.setText(liveClassBean.getName());
            }
            boolean isChecked = liveClassBean.isChecked();
            TextView textView = this.u;
            if (isChecked) {
                textView.setTextColor(lb2.this.i);
                this.u.setBackground(lb2.this.k);
            } else {
                textView.setTextColor(lb2.this.j);
                this.u.setBackground(lb2.this.l);
            }
        }
    }

    public lb2(Context context) {
        super(context);
        this.e.add(new LiveClassBean(0, aq4.a(m93.n3), true));
        this.e.add(new LiveClassBean(1, aq4.a(m93.q), false));
        this.i = o60.b(this.d, p53.n);
        this.j = Color.parseColor("#7D7D7D");
        this.k = o60.d(this.d, i63.p);
        this.l = o60.d(this.d, i63.o);
        this.m = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((LiveClassBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.F0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
