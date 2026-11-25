package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveBean;

/* loaded from: /tmp/classes2.dex */
public class wa2 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (wa2.this.L() && (tag = view.getTag()) != null) {
                int intValue = ((Integer) tag).intValue();
                if (wa2.this.h != null) {
                    wa2.this.h.onItemClick((LiveBean) wa2.this.e.get(intValue), intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView A;
        public ImageView u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public TextView y;
        public ImageView z;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.L1);
            this.v = (ImageView) view.findViewById(c73.l);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (TextView) view.findViewById(c73.H4);
            this.y = (TextView) view.findViewById(c73.U3);
            this.z = (ImageView) view.findViewById(c73.t5);
            this.A = (ImageView) view.findViewById(c73.O2);
            view.setOnClickListener(wa2.this.i);
        }

        public void O(LiveBean liveBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            kn1.f(wa2.this.d, liveBean.getThumb(), this.u);
            kn1.g(wa2.this.d, liveBean.getAvatar(), this.v);
            this.w.setText(liveBean.getUserNiceName());
            boolean isEmpty = TextUtils.isEmpty(liveBean.getTitle());
            TextView textView = this.x;
            if (!isEmpty) {
                if (textView.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
                this.x.setText(liveBean.getTitle());
            } else if (textView.getVisibility() == 0) {
                this.x.setVisibility(8);
            }
            if (this.A != null) {
                int isshop = liveBean.getIsshop();
                ImageView imageView = this.A;
                if (isshop == 1) {
                    if (imageView.getVisibility() != 0) {
                        this.A.setVisibility(0);
                    }
                } else if (imageView.getVisibility() == 0) {
                    this.A.setVisibility(4);
                }
            }
            this.y.setText(liveBean.getNums());
            this.z.setImageResource(eb2.a(liveBean.getType()));
        }
    }

    public wa2(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.B0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LiveBean) this.e.get(i), i);
    }
}
