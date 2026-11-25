package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ga2 extends u0 {
    public List c;
    public View d;
    public View e;
    public View f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pi3.k(ga2.this.mContext);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements CommonRefreshView.e {
        public b() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            ga2 ga2Var = ga2.this;
            if (ga2Var.b == null) {
                ga2Var.b = new z3(ga2Var.mContext);
            }
            return ga2.this.b;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            boolean N = j30.q().N();
            ga2 ga2Var = ga2.this;
            if (N) {
                if (ga2Var.e != null && ga2.this.e.getVisibility() != 0) {
                    ga2.this.e.setVisibility(0);
                }
                if (ga2.this.f != null && ga2.this.f.getVisibility() == 0) {
                    ga2.this.f.setVisibility(4);
                }
                db2.w(i, httpCallback);
                return;
            }
            if (ga2Var.f != null && ga2.this.f.getVisibility() != 0) {
                ga2.this.f.setVisibility(0);
            }
            if (ga2.this.e != null && ga2.this.e.getVisibility() == 0) {
                ga2.this.e.setVisibility(4);
            }
            httpCallback.onSuccess(0, "", l50.a);
            httpCallback.onFinish();
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
            if (j30.q().N()) {
                return JSON.parseArray(Arrays.toString(strArr), ActiveBean.class);
            }
            if (ga2.this.c == null) {
                ga2.this.c = new ArrayList();
            }
            return ga2.this.c;
        }
    }

    public ga2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.i1;
    }

    @Override // defpackage.u0, defpackage.b1
    public void init() {
        super.init();
        this.a = (CommonRefreshView) findViewById(c73.r4);
        View inflate = LayoutInflater.from(this.mContext).inflate(y73.s1, this.a.getmEmptyLayout(), false);
        this.d = inflate;
        this.e = inflate.findViewById(c73.v2);
        View findViewById = this.d.findViewById(c73.y2);
        this.f = findViewById;
        findViewById.findViewById(y63.r).setOnClickListener(new a());
        this.a.setEmptyLayoutView(this.d);
        this.a.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.a.setDataHelper(new b());
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
        db2.i("getActiveFollow");
    }
}
