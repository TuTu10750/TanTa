package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveRecordBean;

/* loaded from: /tmp/classes2.dex */
public class t42 extends ce3 {
    public View.OnClickListener i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (t42.this.L() && (tag = view.getTag()) != null) {
                LiveRecordBean liveRecordBean = (LiveRecordBean) tag;
                if (t42.this.h != null) {
                    t42.this.h.onItemClick(liveRecordBean, 0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.i5);
            this.v = (TextView) view.findViewById(b73.e5);
            this.w = (TextView) view.findViewById(b73.l4);
            view.setOnClickListener(t42.this.i);
        }

        public void O(LiveRecordBean liveRecordBean) {
            ((RecyclerView.e0) this).a.setTag(liveRecordBean);
            this.u.setText(liveRecordBean.getTitle());
            this.v.setText(liveRecordBean.getDateEndTime());
            this.w.setText(rv3.i(liveRecordBean.getNums()));
        }
    }

    public t42(Context context) {
        super(context);
        this.i = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.U0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LiveRecordBean) this.e.get(i));
    }
}
