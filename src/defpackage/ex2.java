package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.mall.activity.PayContentPubActivity;
import com.yunbao.mall.bean.PayContentVideoBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ex2 extends k0 implements et2 {
    public RecyclerView b;
    public dx2 c;
    public int d;

    public ex2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.d = -1;
    }

    public List a0() {
        dx2 dx2Var = this.c;
        if (dx2Var != null) {
            return dx2Var.N();
        }
        return null;
    }

    @Override // defpackage.et2
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(PayContentVideoBean payContentVideoBean, int i) {
        this.d = i;
        ((PayContentPubActivity) this.mContext).I1();
    }

    public void d0(String str, String str2) {
        int i = this.d;
        if (i >= 0) {
            this.c.e0(str, str2, i);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.U1;
    }

    @Override // defpackage.b1
    public void init() {
        RecyclerView findViewById = findViewById(d73.u3);
        this.b = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        dx2 dx2Var = new dx2(this.mContext);
        this.c = dx2Var;
        dx2Var.R(this);
        this.b.setAdapter(this.c);
    }
}
