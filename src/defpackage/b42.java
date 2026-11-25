package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LivePkBean;

/* loaded from: /tmp/classes2.dex */
public class b42 extends ce3 {
    public View.OnClickListener i;
    public String j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || b42.this.h == null) {
                return;
            }
            b42.this.h.onItemClick((LivePkBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public TextView y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (ImageView) view.findViewById(b73.U4);
            this.x = (ImageView) view.findViewById(b73.z3);
            TextView textView = (TextView) view.findViewById(b73.o0);
            this.y = textView;
            textView.setOnClickListener(b42.this.i);
        }

        public void O(LivePkBean livePkBean) {
            this.y.setTag(livePkBean);
            kn1.g(b42.this.d, livePkBean.getAvatar(), this.u);
            this.v.setText(livePkBean.getUserNiceName());
            this.w.setImageResource(l30.b(livePkBean.getSex()));
            LevelBean c = j30.q().c(livePkBean.getLevelAnchor());
            if (c != null) {
                kn1.f(b42.this.d, c.getThumb(), this.x);
            }
            boolean isLinkMic = livePkBean.isLinkMic();
            TextView textView = this.y;
            if (isLinkMic) {
                textView.setText(b42.this.k);
                this.y.setEnabled(false);
            } else {
                textView.setText(b42.this.j);
                this.y.setEnabled(true);
            }
        }
    }

    public b42(Context context) {
        super(context);
        this.i = new a();
        this.j = aq4.a(m93.m4);
        this.k = aq4.a(m93.n4);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.Q0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LivePkBean) this.e.get(i));
    }
}
