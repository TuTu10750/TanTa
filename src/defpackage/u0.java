package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.common.custom.CommonRefreshView;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public abstract class u0 extends v0 {
    public CommonRefreshView a;
    public z3 b;

    public u0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void a0() {
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.U0();
        }
    }

    @Override // defpackage.b1
    public void init() {
        zu0.c().n(this);
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveCommentEvent(d4 d4Var) {
        z3 z3Var = this.b;
        if (z3Var == null || d4Var == null) {
            return;
        }
        z3Var.P0(d4Var.a(), d4Var.b());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveDeleted(e4 e4Var) {
        z3 z3Var = this.b;
        if (z3Var == null || e4Var == null) {
            return;
        }
        z3Var.O0(e4Var.a());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveLikeEvent(i4 i4Var) {
        z3 z3Var = this.b;
        if (z3Var == null || i4Var == null) {
            return;
        }
        z3Var.R0(i4Var.b(), i4Var.a(), i4Var.d(), i4Var.c());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        zu0.c().p(this);
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        z3 z3Var = this.b;
        if (z3Var == null || q41Var == null) {
            return;
        }
        z3Var.Q0(q41Var.b(), q41Var.a());
    }
}
