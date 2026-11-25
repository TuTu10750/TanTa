package com.yunbao.live.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.LiveClassBean;
import defpackage.aq4;
import defpackage.b73;
import defpackage.et2;
import defpackage.j30;
import defpackage.k30;
import defpackage.m93;
import defpackage.q42;
import defpackage.x73;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveChooseClassActivity extends AbsActivity implements et2 {
    public RecyclerView e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ConfigBean configBean) {
            List<LiveClassBean> liveClass;
            if (configBean == null || (liveClass = configBean.getLiveClass()) == null) {
                return;
            }
            int size = liveClass.size();
            for (int i = 0; i < size; i++) {
                LiveClassBean liveClassBean = liveClass.get(i);
                if (liveClassBean.getId() == this.a) {
                    liveClassBean.setChecked(true);
                } else {
                    liveClassBean.setChecked(false);
                }
            }
            q42 q42Var = new q42(LiveChooseClassActivity.this.b, liveClass);
            q42Var.Q(LiveChooseClassActivity.this);
            LiveChooseClassActivity.this.e.setAdapter(q42Var);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.v3));
        RecyclerView findViewById = findViewById(b73.B4);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        j30.q().i(new a(getIntent().getIntExtra("classID", 0)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: y1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveClassBean liveClassBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("classID", liveClassBean.getId());
        intent.putExtra("className", liveClassBean.getName());
        setResult(-1, intent);
        finish();
    }
}
