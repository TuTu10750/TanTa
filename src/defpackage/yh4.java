package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.video.activity.VideoPlayActivity;
import com.yunbao.video.bean.VideoBean;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class yh4 extends k0 implements et2 {
    public CommonRefreshView b;
    public xh4 c;
    public String d;
    public yi4 e;
    public c f;
    public String g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (yh4.this.c == null) {
                yh4 yh4Var = yh4.this;
                yh4Var.c = new xh4(yh4Var.mContext);
                yh4.this.c.R(yh4.this);
            }
            return yh4.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            zh4.f(yh4.this.d, i, httpCallback);
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
            gj4.d().e(yh4.this.g, list);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return mu1.a(Arrays.toString(strArr), VideoBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements yi4 {
        public b() {
        }

        @Override // defpackage.yi4
        public void loadData(int i, HttpCallback httpCallback) {
            zh4.f(yh4.this.d, i, httpCallback);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(int i);
    }

    public yh4(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup, str);
    }

    @Override // defpackage.et2
    /* renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(VideoBean videoBean, int i) {
        CommonRefreshView commonRefreshView = this.b;
        int pageCount = commonRefreshView != null ? commonRefreshView.getPageCount() : 1;
        gj4.d().f(this.g, this.e);
        VideoPlayActivity.A1(this.mContext, i, this.g, pageCount);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.H1;
    }

    public void h0(c cVar) {
        this.f = cVar;
    }

    @Override // defpackage.b1
    public void init() {
        if (TextUtils.isEmpty(this.d)) {
            return;
        }
        this.g = "videoUser_" + hashCode();
        this.b = (CommonRefreshView) findViewById(c73.r4);
        boolean equals = this.d.equals(j30.q().C());
        CommonRefreshView commonRefreshView = this.b;
        if (equals) {
            commonRefreshView.setEmptyLayoutId(y73.D1);
        } else {
            commonRefreshView.setEmptyLayoutId(y73.E1);
        }
        this.b.setLayoutManager(new GridLayoutManager(this.mContext, 3, 1, false));
        RecyclerView.n rq1Var = new rq1(this.mContext, 0, 2.0f, 0.0f);
        rq1Var.l(true);
        this.b.setItemDecoration(rq1Var);
        this.b.setDataHelper(new a());
        this.e = new b();
        zu0.c().n(this);
    }

    @Override // defpackage.k0
    public void loadData() {
        if (isFirstLoadData()) {
            this.b.k();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoDeleteEvent(gh4 gh4Var) {
        if (this.c != null) {
            throw null;
        }
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(1);
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoScrollPageEvent(zi4 zi4Var) {
        CommonRefreshView commonRefreshView;
        if (TextUtils.isEmpty(this.g) || !this.g.equals(zi4Var.a()) || (commonRefreshView = this.b) == null) {
            return;
        }
        commonRefreshView.setPageCount(zi4Var.b());
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.d = (String) objArr[0];
    }

    @Override // defpackage.b1
    public void release() {
        this.e = null;
        this.f = null;
        zh4.a("getHomeVideo");
        zu0.c().p(this);
    }
}
