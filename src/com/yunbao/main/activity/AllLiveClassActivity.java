package com.yunbao.main.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.LiveClassBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.et2;
import defpackage.j30;
import defpackage.m12;
import defpackage.m93;
import defpackage.y73;
import defpackage.za2;
import defpackage.zu0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class AllLiveClassActivity extends AbsActivity {

    /* loaded from: /tmp/classes2.dex */
    public class a implements et2 {
        public a() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(LiveClassBean liveClassBean, int i) {
            if (AllLiveClassActivity.this.c1()) {
                zu0.c().j(new m12(liveClassBean.getId()));
                AllLiveClassActivity.this.finish();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.f;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.f0));
        RecyclerView findViewById = findViewById(c73.h4);
        findViewById.setLayoutManager(new GridLayoutManager(this.b, 5, 1, false));
        ConfigBean h = j30.q().h();
        List<LiveClassBean> liveClass = h != null ? h.getLiveClass() : null;
        if (liveClass == null) {
            liveClass = new ArrayList<>();
        }
        za2 za2Var = new za2(this.b, liveClass);
        za2Var.R(new a());
        findViewById.setAdapter(za2Var);
    }
}
