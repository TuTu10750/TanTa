package com.yunbao.video.activity;

import android.app.Dialog;
import com.yunbao.common.bean.ConfigBean;
import defpackage.aj4;
import defpackage.gj4;
import defpackage.j30;
import defpackage.k30;
import defpackage.zh4;

/* loaded from: /tmp/classes2.dex */
public abstract class AbsVideoPlayActivity extends AbsVideoCommentActivity {
    public aj4 g;
    public Dialog h;
    public ConfigBean i;
    public String j;
    public boolean k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ConfigBean configBean) {
            AbsVideoPlayActivity.this.i = configBean;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.video.activity.AbsVideoCommentActivity, com.yunbao.common.activity.AbsActivity
    public void m1() {
        super.m1();
        getWindow().addFlags(128);
        j30.q().i(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onPause() {
        this.k = true;
        super.onPause();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        this.k = false;
    }

    @Override // com.yunbao.video.activity.AbsVideoCommentActivity
    public void y1() {
        super.y1();
        zh4.a("setVideoShare");
        zh4.a("videoDelete");
        Dialog dialog = this.h;
        if (dialog != null && dialog.isShowing()) {
            this.h.dismiss();
        }
        aj4 aj4Var = this.g;
        if (aj4Var != null) {
            aj4Var.release();
        }
        gj4.d().g(this.j);
        this.h = null;
        this.g = null;
    }
}
