package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.RoomManageDetailActivity;
import com.yunbao.live.bean.LiveAdminRoomBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class a42 extends k0 implements et2 {
    public CommonRefreshView b;
    public j02 c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (a42.this.c == null) {
                a42 a42Var = a42.this;
                a42Var.c = new j02(a42Var.mContext);
                a42.this.c.R(a42.this);
            }
            return a42.this.c;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.Y(i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), LiveAdminRoomBean.class);
        }
    }

    public a42(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.et2
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveAdminRoomBean liveAdminRoomBean, int i) {
        RoomManageDetailActivity.w1(this.mContext, liveAdminRoomBean);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.e2;
    }

    @Override // defpackage.b1
    public void init() {
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(b73.E4);
        this.b = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.q2);
        this.b.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.b.setDataHelper(new a());
    }

    @Override // defpackage.k0
    public void loadData() {
        CommonRefreshView commonRefreshView;
        if (!isFirstLoadData() || (commonRefreshView = this.b) == null) {
            return;
        }
        commonRefreshView.k();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        e32.f("getMyAdminRoomList");
        super.onDestroy();
    }
}
