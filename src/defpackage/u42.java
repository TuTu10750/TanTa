package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveRecordBean;
import java.util.Arrays;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class u42 extends k0 implements et2 {
    public CommonRefreshView b;
    public t42 c;
    public c d;
    public String e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (u42.this.c == null) {
                u42 u42Var = u42.this;
                u42Var.c = new t42(u42Var.mContext);
                u42.this.c.R(u42.this);
            }
            return u42.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.R(u42.this.e, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LiveRecordBean.class);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            lx1.b("直播回放的url--->" + JSON.parseObject(strArr[0]).getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
            if (u42.this.d != null) {
                u42.this.d.a();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        UserBean a();
    }

    public u42(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup, str);
    }

    public final void g0(String str) {
        if (v31.a(true)) {
            e32.C(str, new b());
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.k2;
    }

    @Override // defpackage.et2
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveRecordBean liveRecordBean, int i) {
        g0(liveRecordBean.getId());
    }

    public void i0(c cVar) {
        this.d = cVar;
    }

    @Override // defpackage.b1
    public void init() {
        if (TextUtils.isEmpty(this.e)) {
            return;
        }
        CommonRefreshView commonRefreshView = (CommonRefreshView) this.mContentView;
        this.b = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        boolean equals = this.e.equals(j30.q().C());
        CommonRefreshView commonRefreshView2 = this.b;
        if (equals) {
            commonRefreshView2.setEmptyLayoutId(x73.z2);
        } else {
            commonRefreshView2.setEmptyLayoutId(x73.A2);
        }
        this.b.setDataHelper(new a());
    }

    @Override // defpackage.k0
    public void loadData() {
        if (isFirstLoadData()) {
            this.b.k();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        e32.f("getLiveRecord");
        this.d = null;
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.e = (String) objArr[0];
        }
    }
}
