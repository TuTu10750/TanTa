package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.main.bean.ListBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ib2 extends ce3 {
    public final String i;
    public final String j;
    public final String k;
    public final View.OnClickListener l;
    public final View.OnClickListener m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ListBean listBean;
            if (ib2.this.L() && (listBean = (ListBean) view.getTag()) != null) {
                pi3.q(ib2.this.d, listBean.getUid());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (((AbsActivity) ib2.this.d).e1() && ib2.this.L() && (tag = view.getTag()) != null) {
                CommonHttpUtil.setAttention(((ListBean) ib2.this.e.get(((Integer) tag).intValue())).getUid(), null);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public MyRadioButton y;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.W3);
            this.v = (ImageView) view.findViewById(c73.l);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.G5);
            MyRadioButton myRadioButton = (MyRadioButton) view.findViewById(c73.m0);
            this.y = myRadioButton;
            myRadioButton.setOnClickListener(ib2.this.l);
            view.setOnClickListener(ib2.this.m);
        }

        public void O(ListBean listBean, int i, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(listBean);
                this.u.setText(rv3.a("NO.", String.valueOf(i + 4)));
                kn1.g(ib2.this.d, listBean.getAvatarThumb(), this.v);
                this.w.setText(listBean.getUserNiceName());
                this.x.setText(rv3.a(listBean.getTotalCoinFormat(), " ", ib2.this.i));
            }
            this.y.setTag(Integer.valueOf(i));
            int attention = listBean.getAttention();
            MyRadioButton myRadioButton = this.y;
            if (attention == 1) {
                myRadioButton.a(true);
                this.y.setText(ib2.this.k);
            } else {
                myRadioButton.a(false);
                this.y.setText(ib2.this.j);
            }
        }
    }

    public ib2(Context context, String str) {
        super(context);
        this.i = str;
        this.j = aq4.a(m93.M1);
        this.k = aq4.a(m93.N1);
        this.m = new a();
        this.l = new b();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((ListBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(y73.E0, viewGroup, false));
    }

    public void d0(String str, int i) {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            ListBean listBean = (ListBean) this.e.get(i2);
            if (listBean != null && str.equals(listBean.getUid())) {
                listBean.setAttention(i);
                r(i2, "payload");
                return;
            }
        }
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
