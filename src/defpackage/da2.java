package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.luckpan.bean.LuckpanWinMsgBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class da2 extends dg {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public TextView u;

        public a(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.i5);
        }

        public void O(LuckpanWinMsgBean luckpanWinMsgBean) {
            this.u.setText(luckpanWinMsgBean.getTitleTrans());
        }
    }

    public da2(Context context, List list) {
        super(context, list);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.p0, viewGroup, false));
    }

    @Override // defpackage.dg
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void N(RecyclerView.e0 e0Var, LuckpanWinMsgBean luckpanWinMsgBean, int i, int i2) {
        ((a) e0Var).O(luckpanWinMsgBean);
    }
}
