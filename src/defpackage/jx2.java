package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.PayContentVideoPlayBean;

/* loaded from: /tmp/classes2.dex */
public class jx2 extends ce3 {
    public boolean i;
    public String j;
    public String k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            PayContentVideoPlayBean payContentVideoPlayBean = (PayContentVideoPlayBean) tag;
            if ((jx2.this.i || payContentVideoPlayBean.getIsSee() == 1) && jx2.this.h != null) {
                jx2.this.h.onItemClick(payContentVideoPlayBean, 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;
        public View x;
        public TextView y;
        public View z;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(d73.w2);
            this.v = (TextView) view.findViewById(d73.m4);
            this.w = (TextView) view.findViewById(d73.Q1);
            this.x = view.findViewById(d73.N0);
            this.y = (TextView) view.findViewById(d73.U3);
            this.z = view.findViewById(d73.I2);
            view.setOnClickListener(jx2.this.l);
        }

        public void O(PayContentVideoPlayBean payContentVideoPlayBean, int i) {
            ((RecyclerView.e0) this).a.setTag(payContentVideoPlayBean);
            this.u.setText(payContentVideoPlayBean.getId());
            this.v.setText(payContentVideoPlayBean.getTitle());
            this.w.setText(String.format(jx2.this.k, payContentVideoPlayBean.getDurationString()));
            if (jx2.this.i) {
                if (this.x.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
                this.y.setText(jx2.this.j);
            } else {
                int isSee = payContentVideoPlayBean.getIsSee();
                View view = this.x;
                if (isSee == 1) {
                    if (view.getVisibility() != 0) {
                        this.x.setVisibility(0);
                    }
                    this.y.setText(jx2.this.j);
                } else if (view.getVisibility() == 0) {
                    this.x.setVisibility(4);
                }
            }
            int size = jx2.this.e.size() - 1;
            View view2 = this.z;
            if (i == size) {
                if (view2.getVisibility() == 0) {
                    this.z.setVisibility(4);
                }
            } else if (view2.getVisibility() != 0) {
                this.z.setVisibility(0);
            }
        }
    }

    public jx2(Context context) {
        super(context);
        this.k = aq4.a(m93.Q7);
        this.l = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(z73.a1, viewGroup, false));
    }

    public void Z(boolean z) {
        this.i = z;
        this.j = aq4.a(z ? m93.R7 : m93.F7);
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((PayContentVideoPlayBean) this.e.get(i), i);
    }
}
