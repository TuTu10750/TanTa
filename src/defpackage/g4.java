package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.activity.ActiveTopicActivity;
import com.yunbao.main.bean.ActiveTopicBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class g4 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActiveTopicBean activeTopicBean = (ActiveTopicBean) view.getTag();
            if (activeTopicBean != null) {
                ActiveTopicActivity.A1(g4.this.d, activeTopicBean.getId(), activeTopicBean.getName());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.E4);
            this.v = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(g4.this.i);
        }

        public void O(ActiveTopicBean activeTopicBean) {
            ((RecyclerView.e0) this).a.setTag(activeTopicBean);
            kn1.f(g4.this.d, activeTopicBean.getThumb(), this.u);
            this.v.setText(activeTopicBean.getName());
        }
    }

    public g4(Context context, List list) {
        super(context, list);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.k0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((ActiveTopicBean) this.e.get(i));
    }
}
