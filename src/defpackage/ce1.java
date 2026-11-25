package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.GuardUserBean;

/* loaded from: /tmp/classes2.dex */
public class ce1 extends ce3 {
    public String i;
    public boolean j;
    public Drawable k;
    public Drawable l;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public TextView y;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (ImageView) view.findViewById(b73.U4);
            this.x = (ImageView) view.findViewById(b73.z3);
            this.y = (TextView) view.findViewById(b73.i6);
        }

        public void O(GuardUserBean guardUserBean) {
            kn1.g(ce1.this.d, guardUserBean.getAvatar(), this.u);
            this.v.setText(guardUserBean.getUserNiceName());
            this.w.setImageResource(l30.b(guardUserBean.getSex()));
            LevelBean s = j30.q().s(guardUserBean.getLevel());
            if (s != null) {
                kn1.f(ce1.this.d, s.getThumb(), this.x);
            }
            String contribute = guardUserBean.getContribute();
            String b = aq4.b(m93.q2, contribute, ce1.this.i);
            SpannableString spannableString = new SpannableString(b);
            int indexOf = b.indexOf(contribute);
            if (indexOf >= 0) {
                spannableString.setSpan(new ForegroundColorSpan(-42888), indexOf, contribute.length() + indexOf, 33);
            }
            this.y.setText(spannableString);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;
        public TextView w;
        public ImageView x;
        public ImageView y;
        public TextView z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (TextView) view.findViewById(b73.X3);
            this.x = (ImageView) view.findViewById(b73.U4);
            this.y = (ImageView) view.findViewById(b73.z3);
            this.z = (TextView) view.findViewById(b73.i6);
        }

        public void O(GuardUserBean guardUserBean) {
            kn1.g(ce1.this.d, guardUserBean.getAvatar(), this.v);
            this.w.setText(guardUserBean.getUserNiceName());
            this.x.setImageResource(l30.b(guardUserBean.getSex()));
            LevelBean s = j30.q().s(guardUserBean.getLevel());
            if (s != null) {
                kn1.f(ce1.this.d, s.getThumb(), this.y);
            }
            this.z.setText(guardUserBean.getContribute() + " " + ce1.this.i);
            int type = guardUserBean.getType();
            ImageView imageView = this.u;
            if (type == 1) {
                imageView.setImageDrawable(ce1.this.k);
            } else {
                imageView.setImageDrawable(ce1.this.l);
            }
        }
    }

    public ce1(Context context, boolean z) {
        super(context);
        this.j = z;
        this.i = j30.q().F();
        this.k = o60.d(context, t83.A);
        this.l = o60.d(context, t83.B);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new a(this.f.inflate(this.j ? x73.z0 : x73.A0, viewGroup, false));
        }
        return new b(this.f.inflate(this.j ? x73.x0 : x73.y0, viewGroup, false));
    }

    @Override // defpackage.ce3
    public int j() {
        return this.e.size();
    }

    public int l(int i) {
        return i == 0 ? 1 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof a) {
            ((a) e0Var).O((GuardUserBean) this.e.get(i));
        } else {
            ((b) e0Var).O((GuardUserBean) this.e.get(i));
        }
    }
}
