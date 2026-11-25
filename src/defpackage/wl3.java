package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.bean.GoodsManageBean;
import defpackage.vl3;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class wl3 extends k0 implements vl3.c {
    public CommonRefreshView b;
    public vl3 c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (wl3.this.c == null) {
                wl3 wl3Var = wl3.this;
                wl3Var.c = new vl3(wl3Var.mContext);
                wl3.this.c.a0(wl3.this);
            }
            return wl3.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            ec2.R(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GoodsManageBean.class);
        }
    }

    public wl3(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // vl3.c
    public void a(GoodsManageBean goodsManageBean) {
        GoodsDetailActivity.t2(this.mContext, goodsManageBean.getId(), goodsManageBean.getType());
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return z73.Z1;
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(d73.C3);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(z73.N1);
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
}
