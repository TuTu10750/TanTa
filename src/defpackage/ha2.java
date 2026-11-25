package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ha2 extends u0 {

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            ha2 ha2Var = ha2.this;
            if (ha2Var.b == null) {
                ha2Var.b = new z3(ha2Var.mContext);
            }
            return ha2.this.b;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.z(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), ActiveBean.class);
        }
    }

    public ha2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.i1;
    }

    @Override // defpackage.u0, defpackage.b1
    public void init() {
        super.init();
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.a = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.s1);
        this.a.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.a.setDataHelper(new a());
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonRefreshView commonRefreshView = this.a;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.u0, defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        z3 z3Var = this.b;
        if (z3Var != null) {
            z3Var.T0();
        }
        db2.i("getActiveNewest");
    }
}
