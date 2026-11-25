package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.livegame.star.bean.StarWinMsgBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class yt3 extends dg {

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.i5);
        }

        public void O(StarWinMsgBean starWinMsgBean) {
            String giftIcon = starWinMsgBean.getGiftIcon();
            if (TextUtils.isEmpty(giftIcon)) {
                this.u.setImageDrawable(null);
            } else {
                kn1.f(yt3.this.d, giftIcon, this.u);
            }
            this.v.setText(starWinMsgBean.getTitleTrans());
        }
    }

    public yt3(Context context, List list) {
        super(context, list);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.w0, viewGroup, false));
    }

    @Override // defpackage.dg
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public void N(RecyclerView.e0 e0Var, StarWinMsgBean starWinMsgBean, int i, int i2) {
        ((a) e0Var).O(starWinMsgBean);
    }
}
