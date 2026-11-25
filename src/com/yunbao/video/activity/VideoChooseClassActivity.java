package com.yunbao.video.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.VideoClassBean;
import defpackage.ah4;
import defpackage.aq4;
import defpackage.b83;
import defpackage.et2;
import defpackage.f73;
import defpackage.m93;

/* loaded from: /tmp/classes2.dex */
public class VideoChooseClassActivity extends AbsActivity implements et2 {
    public RecyclerView e;

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return b83.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.oa));
        int intExtra = getIntent().getIntExtra("videoId", 0);
        RecyclerView findViewById = findViewById(f73.M);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        ah4 ah4Var = new ah4(this.b, intExtra);
        ah4Var.R(this);
        this.e.setAdapter(ah4Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(VideoClassBean videoClassBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("videoId", videoClassBean.getId());
        intent.putExtra("className", videoClassBean.getName());
        setResult(-1, intent);
        finish();
    }
}
