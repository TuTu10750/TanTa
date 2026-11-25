package com.yunbao.main.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveTopicBean;
import defpackage.aq4;
import defpackage.b4;
import defpackage.c73;
import defpackage.ce3;
import defpackage.db2;
import defpackage.et2;
import defpackage.m93;
import defpackage.y73;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ActiveChooseTopicActivity extends AbsActivity implements et2 {
    public b4 e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ActiveChooseTopicActivity.this.e == null) {
                ActiveChooseTopicActivity activeChooseTopicActivity = ActiveChooseTopicActivity.this;
                activeChooseTopicActivity.e = new b4(activeChooseTopicActivity.b);
                ActiveChooseTopicActivity.this.e.R(ActiveChooseTopicActivity.this);
            }
            return ActiveChooseTopicActivity.this.e;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.t(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), ActiveTopicBean.class);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.c;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.E0));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        commonRefreshView.setDataHelper(new a());
        commonRefreshView.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        db2.i("getActiveAllTopic");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.et2
    /* renamed from: z1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(ActiveTopicBean activeTopicBean, int i) {
        Intent intent = new Intent();
        intent.putExtra("classID", activeTopicBean.getId());
        intent.putExtra("className", activeTopicBean.getName());
        setResult(-1, intent);
        finish();
    }
}
