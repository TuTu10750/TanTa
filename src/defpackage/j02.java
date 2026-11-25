package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveAdminRoomBean;

/* loaded from: /tmp/classes2.dex */
public class j02 extends ce3 {
    public String i;
    public View.OnClickListener j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || j02.this.h == null) {
                return;
            }
            j02.this.h.onItemClick((LiveAdminRoomBean) tag, 0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public TextView u;

        public b(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.X3);
            view.setOnClickListener(j02.this.j);
        }

        public void O(LiveAdminRoomBean liveAdminRoomBean) {
            ((RecyclerView.e0) this).a.setTag(liveAdminRoomBean);
            this.u.setText(String.format(j02.this.i, liveAdminRoomBean.getUserNiceName()));
        }
    }

    public j02(Context context) {
        super(context);
        this.i = aq4.a(m93.p3);
        this.j = new a();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.F0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((b) e0Var).O((LiveAdminRoomBean) this.e.get(i));
    }
}
