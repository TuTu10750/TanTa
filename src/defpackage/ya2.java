package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ya2 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ya2.this.L()) {
                int intValue = ((Integer) view.getTag()).intValue();
                ya2.this.h.onItemClick((LiveBean) ya2.this.e.get(intValue), intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public View u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public RelativeLayout y;

        public b(View view) {
            super(view);
            this.u = view.findViewById(b73.k3);
            this.v = (ImageView) view.findViewById(b73.F1);
            this.w = (TextView) view.findViewById(b73.X3);
            this.x = (TextView) view.findViewById(b73.l4);
            this.y = (RelativeLayout) view.findViewById(b73.J3);
            view.setOnClickListener(ya2.this.i);
        }

        public void O(LiveBean liveBean, int i) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            kn1.f(ya2.this.d, liveBean.getThumb(), this.v);
            boolean isEmpty = liveBean.getTitle().isEmpty();
            TextView textView = this.w;
            if (isEmpty) {
                textView.setText(liveBean.getUserNiceName());
            } else {
                textView.setText(liveBean.getTitle());
            }
            this.x.setText(liveBean.getNums());
            boolean isPK = liveBean.getIsPK();
            RelativeLayout relativeLayout = this.y;
            if (isPK) {
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
            }
        }
    }

    public ya2(Context context, List list) {
        super(context, list);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.T0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof b) {
            ((b) e0Var).O((LiveBean) this.e.get(i), i);
        }
    }
}
