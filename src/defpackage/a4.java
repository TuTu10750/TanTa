package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.activity.ActiveTopicActivity;
import com.yunbao.main.bean.ActiveTopicBean;

/* loaded from: /tmp/classes2.dex */
public class a4 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActiveTopicBean activeTopicBean = (ActiveTopicBean) view.getTag();
            if (activeTopicBean != null) {
                ActiveTopicActivity.A1(a4.this.d, activeTopicBean.getId(), activeTopicBean.getName());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.E4);
            this.v = (TextView) view.findViewById(c73.L3);
            this.w = (TextView) view.findViewById(c73.U3);
            view.setOnClickListener(a4.this.i);
        }

        public void O(ActiveTopicBean activeTopicBean) {
            ((RecyclerView.e0) this).a.setTag(activeTopicBean);
            kn1.f(a4.this.d, activeTopicBean.getThumb(), this.u);
            this.v.setText(activeTopicBean.getName());
            this.w.setText(activeTopicBean.getNumString());
        }
    }

    public a4(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.f0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((ActiveTopicBean) this.e.get(i));
    }
}
