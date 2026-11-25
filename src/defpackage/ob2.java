package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.im.activity.ChatRoomActivity;
import com.yunbao.im.dao.IMUserBean;
import defpackage.uj1;

/* loaded from: /tmp/classes2.dex */
public class ob2 extends v0 {
    public uj1 a;

    /* loaded from: /tmp/classes2.dex */
    public class a implements uj1.g {
        public a() {
        }

        @Override // uj1.g
        public void a() {
        }

        @Override // uj1.g
        public void b(IMUserBean iMUserBean) {
            if (!"goodsorder_admin".equals(iMUserBean.getId())) {
                ChatRoomActivity.A1(ob2.this.mContext, iMUserBean.getUserBean(), iMUserBean.getAttent() == 1, false);
            } else if (j30.q().Q()) {
                t54.a(m93.t0);
            } else {
                pi3.b(ob2.this.mContext, "com.yunbao.mall.activity.OrderMessageActivity");
            }
        }
    }

    public ob2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.k;
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        j30.q().d0(2);
        uj1 uj1Var = new uj1(this.mContext, (ViewGroup) findViewById(a73.g0), 0);
        this.a = uj1Var;
        uj1Var.A0(new a());
        this.a.addToParent();
        this.a.loadData();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        j30.q().d0(0);
        uj1 uj1Var = this.a;
        if (uj1Var != null) {
            uj1Var.release();
        }
        super.onDestroy();
    }
}
