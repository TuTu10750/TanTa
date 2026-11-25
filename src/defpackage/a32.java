package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.LiveBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class a32 extends l0 implements et2 {
    public y22 A0;
    public TextView B0;
    public String C0;
    public CommonRefreshView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (a32.this.A0 == null) {
                a32 a32Var = a32.this;
                a32Var.A0 = new y22(a32Var.x0);
                a32.this.A0.R(a32.this);
            }
            return a32.this.A0;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.e0(i, a32.this.C0, httpCallback);
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
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (a32.this.B0 != null) {
                a32.this.B0.setText(rv3.a(aq4.a(m93.U1), " ", parseObject.getString("nums")));
            }
            return JSON.parseArray(parseObject.getString("list"), GoodsBean.class);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.x0 = null;
        e32.f("Shop.GetSale");
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.N;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = zn0.a(320);
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z != null) {
            this.C0 = z.getString("liveUid");
        }
        this.B0 = (TextView) k2(b73.i5);
        CommonRefreshView commonRefreshView = (CommonRefreshView) k2(b73.E4);
        this.z0 = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(x73.s2);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.z0.setDataHelper(new a());
        this.z0.k();
    }

    @Override // defpackage.et2
    /* renamed from: w2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsBean goodsBean, int i) {
        LiveBean E1 = ((LiveActivity) this.x0).E1();
        int type = goodsBean.getType();
        Context context = this.x0;
        if (type == 1) {
            pi3.h(context, goodsBean.getId(), false, E1);
        } else {
            pi3.f(context, goodsBean.getId(), false, this.C0, null, E1);
        }
    }
}
