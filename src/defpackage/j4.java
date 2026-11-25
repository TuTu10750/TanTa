package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.main.activity.ActiveTopicActivity;
import com.yunbao.main.bean.ActiveTopicBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class j4 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActiveTopicBean activeTopicBean = (ActiveTopicBean) view.getTag();
            if (activeTopicBean != null) {
                ActiveTopicActivity.A1(j4.this.d, activeTopicBean.getId(), activeTopicBean.getName());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(c73.L3);
            view.setOnClickListener(j4.this.i);
        }

        public void O(ActiveTopicBean activeTopicBean) {
            ((RecyclerView.e0) this).a.setTag(activeTopicBean);
            this.u.setText(activeTopicBean.getName());
        }
    }

    public j4(Context context, List list) {
        super(context, list);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(y73.m0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((ActiveTopicBean) this.e.get(i));
    }
}
