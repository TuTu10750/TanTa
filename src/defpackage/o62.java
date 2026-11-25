package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.LiveVoiceControlBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class o62 extends ce3 {
    public View.OnClickListener i;
    public View.OnClickListener j;
    public c k;
    public Drawable l;
    public Drawable m;
    public int n;
    public int o;
    public Drawable p;
    public final boolean q;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o62.this.k != null) {
                o62.this.k.c((LiveVoiceControlBean) view.getTag());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (o62.this.k != null) {
                o62.this.k.e((LiveVoiceControlBean) view.getTag());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void c(LiveVoiceControlBean liveVoiceControlBean);

        void e(LiveVoiceControlBean liveVoiceControlBean);
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public View A;
        public TextView u;
        public ImageView v;
        public TextView w;
        public ImageView x;
        public ImageView y;
        public TextView z;

        public d(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.d3);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (TextView) view.findViewById(b73.X3);
            this.x = (ImageView) view.findViewById(b73.U4);
            this.y = (ImageView) view.findViewById(b73.z3);
            this.z = (TextView) view.findViewById(b73.P);
            this.A = view.findViewById(b73.T);
            this.z.setOnClickListener(o62.this.i);
            this.A.setOnClickListener(o62.this.j);
        }

        public void O(LiveVoiceControlBean liveVoiceControlBean, int i, Object obj) {
            this.z.setTag(liveVoiceControlBean);
            this.A.setTag(liveVoiceControlBean);
            int status = liveVoiceControlBean.getStatus();
            this.u.setText(String.valueOf(i + 1));
            if (status == 0 || status == 2) {
                if (obj == null) {
                    this.v.setImageDrawable(o62.this.p);
                    this.w.setText((CharSequence) null);
                    this.x.setImageDrawable(null);
                    this.y.setImageDrawable(null);
                }
                if (this.A.getVisibility() == 0) {
                    this.A.setVisibility(4);
                }
                if (o62.this.q) {
                    if (this.z.getVisibility() != 4) {
                        this.z.setVisibility(4);
                        return;
                    }
                    return;
                }
                TextView textView = this.z;
                if (status == 2) {
                    textView.setBackground(o62.this.m);
                    this.z.setTextColor(o62.this.o);
                    this.z.setText(m93.A);
                    return;
                } else {
                    textView.setBackground(o62.this.l);
                    this.z.setTextColor(o62.this.n);
                    this.z.setText(m93.z);
                    return;
                }
            }
            if (obj == null) {
                kn1.g(o62.this.d, liveVoiceControlBean.getAvatar(), this.v);
                this.w.setText(liveVoiceControlBean.getUserName());
                this.x.setImageResource(l30.b(liveVoiceControlBean.getSex()));
                LevelBean s = j30.q().s(liveVoiceControlBean.getLevel());
                if (s != null) {
                    kn1.f(o62.this.d, s.getThumb(), this.y);
                }
            }
            boolean equals = j30.q().C().equals(liveVoiceControlBean.getUid());
            View view = this.A;
            if (equals) {
                if (view.getVisibility() != 4) {
                    this.A.setVisibility(4);
                }
            } else if (view.getVisibility() != 0) {
                this.A.setVisibility(0);
            }
            if (this.z.getVisibility() != 0) {
                this.z.setVisibility(0);
            }
            TextView textView2 = this.z;
            if (status == -1) {
                textView2.setBackground(o62.this.l);
                this.z.setTextColor(o62.this.n);
                this.z.setText(m93.B);
            } else {
                textView2.setBackground(o62.this.m);
                this.z.setTextColor(o62.this.o);
                this.z.setText(m93.y);
            }
        }
    }

    public o62(Context context, List list) {
        super(context, list);
        this.l = o60.d(context, h63.a);
        this.m = o60.d(context, h63.b);
        this.p = o60.d(context, t83.x);
        this.n = o60.b(context, p53.b);
        this.o = o60.b(context, p53.n);
        this.q = ((LiveActivity) this.d).M1();
        this.i = new a();
        this.j = new b();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((d) e0Var).O((LiveVoiceControlBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(x73.h1, viewGroup, false));
    }

    public void d0(int i, int i2) {
        LiveVoiceControlBean liveVoiceControlBean;
        if (i < 0 || i >= this.e.size() || (liveVoiceControlBean = (LiveVoiceControlBean) this.e.get(i)) == null) {
            return;
        }
        liveVoiceControlBean.setStatus(i2);
        if (i2 == 0) {
            q(i);
        } else {
            r(i, "payload");
        }
    }

    public void e0(c cVar) {
        this.k = cVar;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
