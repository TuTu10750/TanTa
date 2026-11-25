package com.yunbao.video.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.yunbao.video.bean.VideoBean;
import defpackage.aj4;
import defpackage.b83;
import defpackage.dh4;
import defpackage.f73;
import defpackage.gj4;
import defpackage.lx1;
import defpackage.zh4;
import java.util.ArrayList;

/* loaded from: /tmp/classes2.dex */
public class VideoPlayActivity extends AbsVideoPlayActivity {
    public static void A1(Context context, int i, String str, int i2) {
        Intent intent = new Intent(context, (Class<?>) VideoPlayActivity.class);
        intent.putExtra("videoPosition", i);
        intent.putExtra("videoKey", str);
        intent.putExtra("videoPage", i2);
        context.startActivity(intent);
    }

    public static void B1(Context context, VideoBean videoBean) {
        if (videoBean == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(videoBean);
        gj4.d().e("videoSingle", arrayList);
        Intent intent = new Intent(context, (Class<?>) VideoPlayActivity.class);
        intent.putExtra("videoPosition", 0);
        intent.putExtra("videoKey", "videoSingle");
        intent.putExtra("videoPage", 1);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return b83.d;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.video.activity.AbsVideoPlayActivity, com.yunbao.video.activity.AbsVideoCommentActivity, com.yunbao.common.activity.AbsActivity
    public void m1() {
        super.m1();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("videoKey");
        this.j = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        aj4 aj4Var = new aj4(this.b, (ViewGroup) findViewById(f73.u), intent.getIntExtra("videoPosition", 0), this.j, intent.getIntExtra("videoPage", 1));
        this.g = aj4Var;
        aj4Var.addToParent();
        this.g.subscribeActivityLifeCycle();
        zh4.p();
    }

    public void onBackPressed() {
        dh4 dh4Var = this.e;
        if (dh4Var == null || dh4Var.z0()) {
            zh4.c();
            y1();
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        y1();
        super.onDestroy();
        lx1.b("VideoPlayActivity------->onDestroy");
    }
}
