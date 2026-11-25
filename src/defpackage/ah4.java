package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.bean.VideoClassBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ah4 extends ce3 {
    public Drawable i;
    public View.OnClickListener j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || ah4.this.h == null) {
                return;
            }
            ah4.this.h.onItemClick((VideoClassBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public ImageView v;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(f73.I);
            this.v = (ImageView) view.findViewById(f73.A);
            view.setOnClickListener(ah4.this.j);
        }

        public void O(VideoClassBean videoClassBean, Object obj) {
            if (obj == null) {
                ((RecyclerView.e0) this).a.setTag(videoClassBean);
                this.u.setText(videoClassBean.getName());
            }
            this.v.setImageDrawable(videoClassBean.isChecked() ? ah4.this.i : null);
        }
    }

    public ah4(Context context, int i) {
        super(context);
        this.j = new a();
        this.i = o60.d(context, q83.n1);
        this.e.addAll(JSON.parseArray(j30.q().h().getVideoClass(), VideoClassBean.class));
        for (VideoClassBean videoClassBean : this.e) {
            if (i == videoClassBean.getId()) {
                videoClassBean.setChecked(true);
                return;
            }
        }
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((VideoClassBean) this.e.get(i), list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(b83.h, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
