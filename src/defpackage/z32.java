package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.yunbao.live.activity.LiveAdminListActivity;
import com.yunbao.live.activity.LiveBlackActivity;
import com.yunbao.live.activity.LiveShutUpActivity;

/* loaded from: /tmp/classes2.dex */
public class z32 extends k0 implements View.OnClickListener {
    public z32(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.d2;
    }

    @Override // defpackage.b1
    public void init() {
        findViewById(b73.t).setOnClickListener(this);
        findViewById(b73.l1).setOnClickListener(this);
        findViewById(b73.k1).setOnClickListener(this);
    }

    @Override // defpackage.k0
    public void loadData() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.t) {
            LiveAdminListActivity.w1(this.mContext, j30.q().C());
        } else if (id == b73.l1) {
            LiveShutUpActivity.A1(this.mContext, j30.q().C());
        } else if (id == b73.k1) {
            LiveBlackActivity.A1(this.mContext, j30.q().C());
        }
    }
}
