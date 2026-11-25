package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.livegame.star.bean.StarRankBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class qt3 extends l0 implements View.OnClickListener {
    public View A0;
    public TextView B0;
    public TextView C0;
    public ImageView D0;
    public TextView E0;
    public pt3 z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (qt3.this.z0 == null) {
                qt3 qt3Var = qt3.this;
                qt3Var.z0 = new pt3(qt3Var.x0);
            }
            return qt3.this.z0;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.z(httpCallback);
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
            JSONObject jSONObject = parseObject.getJSONObject("current");
            if (qt3.this.B0 != null) {
                qt3.this.B0.setText(jSONObject.getString("num"));
            }
            if (qt3.this.C0 != null) {
                qt3.this.C0.setText(jSONObject.getString("user_nickname"));
            }
            if (qt3.this.D0 != null) {
                kn1.f(qt3.this.x0, jSONObject.getString("avatar"), qt3.this.D0);
            }
            if (qt3.this.E0 != null) {
                qt3.this.E0.setText(jSONObject.getString("total"));
            }
            return JSON.parseArray(parseObject.getString("list"), StarRankBean.class);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("gameXqtbRank");
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
        return x73.z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b73.H) {
            S1();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.e);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.H).setOnClickListener(this);
        this.A0 = k2(b73.H2);
        this.B0 = (TextView) k2(b73.T4);
        this.C0 = (TextView) k2(b73.S4);
        this.D0 = (ImageView) k2(b73.Q4);
        this.E0 = (TextView) k2(b73.R4);
        CommonRefreshView commonRefreshView = (CommonRefreshView) k2(b73.E4);
        commonRefreshView.setEmptyLayoutId(x73.q0);
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        commonRefreshView.setDataHelper(new a());
        commonRefreshView.k();
    }
}
