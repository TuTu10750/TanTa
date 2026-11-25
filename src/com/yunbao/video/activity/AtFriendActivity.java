package com.yunbao.video.activity;

import android.content.Intent;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.b83;
import defpackage.ce3;
import defpackage.et2;
import defpackage.f73;
import defpackage.m93;
import defpackage.qc;
import defpackage.zh4;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class AtFriendActivity extends AbsActivity {
    public CommonRefreshView e;
    public qc f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {

        /* renamed from: com.yunbao.video.activity.AtFriendActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0061a implements et2 {
            public C0061a() {
            }

            @Override // defpackage.et2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onItemClick(UserBean userBean, int i) {
                Intent intent = new Intent();
                intent.putExtra("userBean", userBean);
                AtFriendActivity.this.setResult(-1, intent);
                AtFriendActivity.this.finish();
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (AtFriendActivity.this.f == null) {
                AtFriendActivity atFriendActivity = AtFriendActivity.this;
                atFriendActivity.f = new qc(atFriendActivity.b);
                AtFriendActivity.this.f.R(new C0061a());
            }
            return AtFriendActivity.this.f;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            zh4.d(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), UserBean.class);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return b83.a;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.R));
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(f73.N);
        this.e = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.e.setDataHelper(new a());
        this.e.k();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zh4.a("getAtFriendList");
        super.onDestroy();
    }
}
