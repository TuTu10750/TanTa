package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveBean;

/* loaded from: /tmp/classes2.dex */
public class t62 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (t62.this.h == null || tag == null) {
                return;
            }
            t62.this.h.onItemClick((LiveBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public View z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.E4);
            this.v = (ImageView) view.findViewById(c73.l);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.H4);
            this.y = (TextView) view.findViewById(c73.U3);
            this.z = view.findViewById(c73.G2);
            view.setOnClickListener(t62.this.i);
        }

        public void O(LiveBean liveBean) {
            ((RecyclerView.e0) this).a.setTag(liveBean);
            kn1.f(t62.this.d, liveBean.getThumb(), this.u);
            kn1.g(t62.this.d, liveBean.getAvatar(), this.v);
            this.w.setText(liveBean.getUserNiceName());
            this.x.setText(liveBean.getTitle());
            this.y.setText(liveBean.getNums());
            int recommend = liveBean.getRecommend();
            View view = this.z;
            if (recommend == 1) {
                if (view.getVisibility() != 0) {
                    this.z.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
        }
    }

    public t62(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.z0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LiveBean) this.e.get(i));
    }
}
