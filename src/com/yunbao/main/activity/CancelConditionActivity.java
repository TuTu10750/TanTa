package com.yunbao.main.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.CancelConditionBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.db2;
import defpackage.m93;
import defpackage.wu;
import defpackage.y73;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class CancelConditionActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public RecyclerView f;
    public View g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (CancelConditionActivity.this.f != null) {
                CancelConditionActivity.this.f.setAdapter(new wu(CancelConditionActivity.this.b, JSON.parseArray(parseObject.getString("list"), CancelConditionBean.class)));
            }
            if (CancelConditionActivity.this.g != null) {
                CancelConditionActivity.this.g.setEnabled(parseObject.getIntValue("can_cancel") == 1);
            }
        }
    }

    public static void z1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) CancelConditionActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        context.startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.V0));
        RecyclerView findViewById = findViewById(c73.h4);
        this.f = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        View findViewById2 = findViewById(c73.O0);
        this.g = findViewById2;
        findViewById2.setOnClickListener(this);
        this.e = getIntent().getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        db2.G(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        CancelAccountActivity.z1(this.b, this.e);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getCancelCondition");
        super.onDestroy();
    }
}
