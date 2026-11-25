package com.yunbao.im.activity;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.bean.VideoImMsgBean;
import defpackage.a73;
import defpackage.aq4;
import defpackage.ce3;
import defpackage.gk1;
import defpackage.m93;
import defpackage.w73;
import defpackage.xj1;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ImMsgLikeActivity extends AbsActivity {
    public CommonRefreshView e;
    public gk1 f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ImMsgLikeActivity.this.f == null) {
                ImMsgLikeActivity imMsgLikeActivity = ImMsgLikeActivity.this;
                imMsgLikeActivity.f = new gk1(imMsgLikeActivity.b);
            }
            return ImMsgLikeActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            xj1.f(i, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return JSON.parseArray(Arrays.toString(strArr), VideoImMsgBean.class);
        }
    }

    public static void z1(Context context) {
        context.startActivity(new Intent(context, (Class<?>) ImMsgLikeActivity.class));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.d;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.T));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(a73.e0);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        xj1.a("getImLikeList");
        super.onDestroy();
    }
}
