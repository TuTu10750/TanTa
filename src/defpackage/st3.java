package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.star.bean.StarRecordBean;

/* loaded from: /tmp/classes2.dex */
public class st3 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public RecyclerView w;
        public ut3 x;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.i5);
            this.v = (TextView) view.findViewById(b73.e5);
            RecyclerView findViewById = view.findViewById(b73.B4);
            this.w = findViewById;
            findViewById.setLayoutManager(new LinearLayoutManager(st3.this.d, 0, false));
            ut3 ut3Var = new ut3(st3.this.d);
            this.x = ut3Var;
            this.w.setAdapter(ut3Var);
        }

        public void O(StarRecordBean starRecordBean) {
            this.u.setText(starRecordBean.getTitle());
            this.v.setText(starRecordBean.getAddTime());
            this.x.P(starRecordBean.getList());
        }
    }

    public st3(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.t0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((StarRecordBean) this.e.get(i));
    }
}
