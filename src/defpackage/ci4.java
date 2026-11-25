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
import java.util.HashSet;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class ci4 extends k0 implements et2 {
    public CommonRefreshView b;
    public xh4 c;
    public yi4 d;
    public String e;
    public boolean f;
    public HashSet g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (ci4.this.c == null) {
                ci4 ci4Var = ci4.this;
                ci4Var.c = new xh4(ci4Var.mContext);
                ci4.this.c.R(ci4.this);
            }
            return ci4.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            zh4.h(i, httpCallback);
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
            gj4.d().e(ci4.this.e, list);
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
            zh4.h(i, httpCallback);
        }
    }

    public ci4(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.et2
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(VideoBean videoBean, int i) {
        CommonRefreshView commonRefreshView = this.b;
        int pageCount = commonRefreshView != null ? commonRefreshView.getPageCount() : 1;
        gj4.d().f(this.e, this.d);
        VideoPlayActivity.A1(this.mContext, i, this.e, pageCount);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.H1;
    }

    @Override // defpackage.b1
    public void init() {
        this.g = new HashSet();
        this.e = "videoLike_" + hashCode();
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(c73.r4);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(y73.F1);
        this.b.setLayoutManager(new GridLayoutManager(this.mContext, 3, 1, false));
        RecyclerView.n rq1Var = new rq1(this.mContext, 0, 2.0f, 0.0f);
        rq1Var.l(true);
        this.b.setItemDecoration(rq1Var);
        this.b.setDataHelper(new a());
        this.d = new b();
        zu0.c().n(this);
    }

    @Override // defpackage.k0
    public void loadData() {
        if (isFirstLoadData()) {
            this.b.k();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        super.onPause();
        this.f = true;
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        xh4 xh4Var;
        CommonRefreshView commonRefreshView;
        super.onResume();
        if (this.f) {
            this.f = false;
            HashSet hashSet = this.g;
            if (hashSet == null || hashSet.isEmpty() || (xh4Var = this.c) == null) {
                return;
            }
            xh4Var.Z(this.g);
            if (this.c.j() == 0 && (commonRefreshView = this.b) != null) {
                commonRefreshView.n();
            }
            this.g.clear();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoLikeEvent(bi4 bi4Var) {
        if (this.g != null) {
            int a2 = bi4Var.a();
            HashSet hashSet = this.g;
            if (a2 == 0) {
                hashSet.add(bi4Var.c());
            } else {
                hashSet.remove(bi4Var.c());
            }
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onVideoScrollPageEvent(zi4 zi4Var) {
        CommonRefreshView commonRefreshView;
        if (TextUtils.isEmpty(this.e) || !this.e.equals(zi4Var.a()) || (commonRefreshView = this.b) == null) {
            return;
        }
        commonRefreshView.setPageCount(zi4Var.b());
    }

    @Override // defpackage.b1
    public void release() {
        this.d = null;
        zh4.a("getLikeVideo");
        zu0.c().p(this);
    }
}
