package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.ActiveBean;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class f4 extends k0 {
    public CommonRefreshView b;
    public z3 c;
    public String d;
    public b e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (f4.this.c == null) {
                f4 f4Var = f4.this;
                f4Var.c = new z3(f4Var.mContext);
            }
            return f4.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            db2.x(f4.this.d, i, httpCallback);
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

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(int i);
    }

    public f4(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup, str);
    }

    public void f0(b bVar) {
        this.e = bVar;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.Y0;
    }

    @Override // defpackage.b1
    public void init() {
        this.b = (CommonRefreshView) findViewById(c73.r4);
        if (TextUtils.isEmpty(this.d) || !this.d.equals(j30.q().C())) {
            this.b.setEmptyLayoutId(y73.u1);
        } else {
            this.b.setEmptyLayoutId(y73.v1);
        }
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new a());
        zu0.c().n(this);
    }

    @Override // defpackage.k0
    public void loadData() {
        if (isFirstLoadData()) {
            this.b.k();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveCommentEvent(d4 d4Var) {
        z3 z3Var = this.c;
        if (z3Var == null || d4Var == null) {
            return;
        }
        z3Var.P0(d4Var.a(), d4Var.b());
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveDeleted(e4 e4Var) {
        z3 z3Var = this.c;
        if (z3Var == null || e4Var == null) {
            return;
        }
        z3Var.O0(e4Var.a());
        b bVar = this.e;
        if (bVar != null) {
            bVar.a(1);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onActiveLikeEvent(i4 i4Var) {
        z3 z3Var = this.c;
        if (z3Var == null || i4Var == null) {
            return;
        }
        z3Var.R0(i4Var.b(), i4Var.a(), i4Var.d(), i4Var.c());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        zu0.c().p(this);
        z3 z3Var = this.c;
        if (z3Var != null) {
            z3Var.T0();
        }
        this.e = null;
        db2.i("getHomeActive");
        super.onDestroy();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onFollowEvent(q41 q41Var) {
        z3 z3Var = this.c;
        if (z3Var == null || q41Var == null) {
            return;
        }
        z3Var.Q0(q41Var.b(), q41Var.a());
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.d = (String) objArr[0];
        }
    }
}
