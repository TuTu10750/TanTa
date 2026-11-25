package com.yunbao.live.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.live.bean.LiveAdminRoomBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.m93;
import defpackage.x73;

/* loaded from: /tmp/classes2.dex */
public class RoomManageDetailActivity extends AbsActivity implements View.OnClickListener {
    public LiveAdminRoomBean e;

    public static void w1(Context context, LiveAdminRoomBean liveAdminRoomBean) {
        Intent intent = new Intent(context, (Class<?>) RoomManageDetailActivity.class);
        intent.putExtra("liveAdminRoom", liveAdminRoomBean);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        LiveAdminRoomBean liveAdminRoomBean = (LiveAdminRoomBean) getIntent().getParcelableExtra("liveAdminRoom");
        this.e = liveAdminRoomBean;
        if (liveAdminRoomBean == null) {
            return;
        }
        t1(String.format(aq4.a(m93.p3), this.e.getUserNiceName()));
        findViewById(b73.l1).setOnClickListener(this);
        findViewById(b73.k1).setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.l1) {
            LiveShutUpActivity.A1(this.b, this.e.getLiveUid());
        } else if (id == b73.k1) {
            LiveBlackActivity.A1(this.b, this.e.getLiveUid());
        }
    }
}
