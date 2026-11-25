package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.activity.PayContentActivity2;
import com.yunbao.mall.activity.PayContentPubActivity;
import com.yunbao.mall.bean.PayContentBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class mx2 extends k0 implements View.OnClickListener {
    public CommonRefreshView b;
    public lx2 c;
    public String d;
    public boolean e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (mx2.this.c == null) {
                mx2 mx2Var = mx2.this;
                mx2Var.c = new lx2(mx2Var.mContext);
            }
            return mx2.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            if (TextUtils.isEmpty(mx2.this.d)) {
                return;
            }
            boolean equals = mx2.this.d.equals(j30.q().C());
            mx2 mx2Var = mx2.this;
            if (!equals) {
                ec2.k0(mx2Var.d, i, httpCallback);
            } else if (mx2Var.mContext instanceof PayContentActivity2) {
                ec2.S(i, httpCallback);
            } else {
                ec2.k0(mx2.this.d, i, httpCallback);
            }
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
            return JSON.parseArray(Arrays.toString(strArr), PayContentBean.class);
        }
    }

    public mx2(Context context, ViewGroup viewGroup, String str, boolean z) {
        super(context, viewGroup, str, Boolean.valueOf(z));
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.W1;
    }

    @Override // defpackage.b1
    public void init() {
        if (this.e) {
            View findViewById = findViewById(d73.P0);
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(this);
        }
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.Q1);
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new a());
    }

    @Override // defpackage.k0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.b;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PayContentPubActivity.K1(this.mContext);
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        ec2.u("getMyPayContentList");
        ec2.u("getToPayContent");
        super.onDestroy();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.d = (String) objArr[0];
        }
        if (objArr.length > 1) {
            this.e = ((Boolean) objArr[1]).booleanValue();
        }
    }
}
