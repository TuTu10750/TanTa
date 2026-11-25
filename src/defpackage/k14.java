package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.bean.SystemMessageBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class k14 extends b1 implements View.OnClickListener {
    public CommonRefreshView a;
    public i14 b;
    public b c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (k14.this.b == null) {
                k14 k14Var = k14.this;
                k14Var.b = new i14(k14Var.mContext);
            }
            return k14.this.b;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            xj1.i(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), SystemMessageBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void k0();
    }

    public k14(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void e0(b bVar) {
        this.c = bVar;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return w73.I;
    }

    @Override // defpackage.b1
    public void init() {
        findViewById(a73.f).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(a73.e0);
        this.a = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(w73.H);
        this.a.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.a.setDataHelper(new a());
    }

    public void loadData() {
        CommonRefreshView commonRefreshView = this.a;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        if (view.getId() != a73.f || (bVar = this.c) == null) {
            return;
        }
        bVar.k0();
    }

    @Override // defpackage.b1
    public void release() {
        this.c = null;
        xj1.a("getSystemMessageList");
    }
}
