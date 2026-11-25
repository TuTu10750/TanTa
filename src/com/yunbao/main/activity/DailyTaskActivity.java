package com.yunbao.main.activity;

import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.DailyTaskBean;
import defpackage.aq4;
import defpackage.c73;
import defpackage.e32;
import defpackage.m93;
import defpackage.y73;
import defpackage.z80;

/* loaded from: /tmp/classes2.dex */
public class DailyTaskActivity extends AbsActivity {

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
            ((TextView) DailyTaskActivity.this.findViewById(c73.G4)).setText(parseObject.getString("tip_m"));
            RecyclerView findViewById = DailyTaskActivity.this.findViewById(c73.h4);
            findViewById.setLayoutManager(new LinearLayoutManager(DailyTaskActivity.this.b, 1, false));
            findViewById.setAdapter(new z80(DailyTaskActivity.this.b, JSON.parseArray(parseObject.getString("list"), DailyTaskBean.class)));
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.o;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.v1));
        e32.G("", 0, new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e32.f("getDailyTask");
        e32.f("dailyTaskReward");
        super.onDestroy();
    }
}
