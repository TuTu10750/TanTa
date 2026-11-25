package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.RedPackResultBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class mc3 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public TextView x;

        public a(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (TextView) view.findViewById(b73.e5);
            this.x = (TextView) view.findViewById(b73.n6);
        }

        public void O(RedPackResultBean redPackResultBean) {
            kn1.g(mc3.this.d, redPackResultBean.getAvatar(), this.u);
            this.v.setText(redPackResultBean.getUserNiceName());
            this.w.setText(redPackResultBean.getTime());
            this.x.setText(redPackResultBean.getWinCoin());
        }
    }

    public mc3(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, int i) {
        aVar.O((RedPackResultBean) this.e.get(i));
    }

    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(this.f.inflate(x73.o1, viewGroup, false));
    }

    public int j() {
        return this.e.size();
    }
}
