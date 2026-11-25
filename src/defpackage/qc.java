package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class qc extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || qc.this.h == null) {
                return;
            }
            qc.this.h.onItemClick((UserBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(f73.c);
            this.v = (TextView) view.findViewById(f73.I);
            this.w = (TextView) view.findViewById(f73.T);
            view.setOnClickListener(qc.this.i);
        }

        public void O(UserBean userBean) {
            ((RecyclerView.e0) this).a.setTag(userBean);
            kn1.g(qc.this.d, userBean.getAvatar(), this.u);
            this.v.setText(userBean.getUserNiceName());
            this.w.setText(userBean.getSignature());
        }
    }

    public qc(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(b83.g, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((UserBean) this.e.get(i));
    }
}
