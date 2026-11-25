package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.bean.BuyerOrderBean;
import defpackage.ol;

/* loaded from: /tmp/classes2.dex */
public class xl extends ol {
    public xl(Context context) {
        super(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new ol.d(this.f.inflate(z73.x0, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((ol.d) e0Var).O((BuyerOrderBean) this.e.get(i));
    }
}
