package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.luckpan.bean.LuckpanRecordBean;

/* loaded from: /tmp/classes2.dex */
public class x92 extends ce3 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public RecyclerView w;
        public z92 x;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.i5);
            this.v = (TextView) view.findViewById(b73.e5);
            RecyclerView findViewById = view.findViewById(b73.B4);
            this.w = findViewById;
            findViewById.setLayoutManager(new LinearLayoutManager(x92.this.d, 0, false));
            z92 z92Var = new z92(x92.this.d);
            this.x = z92Var;
            this.w.setAdapter(z92Var);
        }

        public void O(LuckpanRecordBean luckpanRecordBean) {
            this.u.setText(luckpanRecordBean.getTitle());
            this.v.setText(luckpanRecordBean.getAddTime());
            this.x.P(luckpanRecordBean.getList());
        }
    }

    public x92(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.m0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((a) e0Var).O((LuckpanRecordBean) this.e.get(i));
    }
}
