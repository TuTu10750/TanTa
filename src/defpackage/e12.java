package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveShutUpBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class e12 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                if (e12.this.h != null) {
                    e12.this.h.onItemClick((LiveShutUpBean) e12.this.e.get(intValue), intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public ImageView w;
        public ImageView x;
        public View y;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (ImageView) view.findViewById(b73.U4);
            this.x = (ImageView) view.findViewById(b73.z3);
            View findViewById = view.findViewById(b73.Q);
            this.y = findViewById;
            findViewById.setOnClickListener(e12.this.i);
        }

        public void O(LiveShutUpBean liveShutUpBean, int i, Object obj) {
            this.y.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(e12.this.d, liveShutUpBean.getAvatar(), this.u);
                this.v.setText(liveShutUpBean.getUserNiceName());
                this.w.setImageResource(l30.b(liveShutUpBean.getSex()));
                LevelBean s = j30.q().s(liveShutUpBean.getLevel());
                if (s != null) {
                    kn1.f(e12.this.d, s.getThumb(), this.x);
                }
            }
        }
    }

    public e12(Context context) {
        super(context);
        this.i = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((LiveShutUpBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.C0, viewGroup, false));
    }

    public void Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (str.equals(((LiveShutUpBean) this.e.get(i)).getUid())) {
                break;
            } else {
                i++;
            }
        }
        if (i >= 0) {
            this.e.remove(i);
            p();
        }
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
