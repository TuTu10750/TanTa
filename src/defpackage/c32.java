package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.GuardUserBean;
import com.yunbao.live.bean.LiveGuardInfo;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class c32 extends l0 implements View.OnClickListener {
    public TextView A0;
    public View B0;
    public TextView C0;
    public TextView D0;
    public ce1 E0;
    public String F0;
    public String G0;
    public boolean H0;
    public LiveGuardInfo I0;
    public CommonRefreshView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (c32.this.E0 == null) {
                c32 c32Var = c32.this;
                c32Var.E0 = new ce1(c32Var.x0, true);
            }
            return c32.this.E0;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.K(c32.this.F0, i, httpCallback);
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
            return JSON.parseArray(Arrays.toString(strArr), GuardUserBean.class);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.I0 = null;
        e32.f("getGuardList");
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
        return x73.F;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        S1();
        if (TextUtils.isEmpty(this.F0) || this.I0 == null) {
            return;
        }
        b32 b32Var = new b32();
        b32Var.G2(this.I0);
        Bundle bundle = new Bundle();
        bundle.putString("coinName", "钻石");
        bundle.putString("liveUid", this.F0);
        bundle.putString("roomId", this.G0);
        bundle.putString("stream", "");
        b32Var.F1(bundle);
        b32Var.d2(y1().getSupportFragmentManager(), "LiveGuardBuyDialogFragment");
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
        attributes.height = zn0.a(360);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        Bundle z = z();
        if (z == null) {
            return;
        }
        this.H0 = z.getBoolean("anchor", false);
        this.F0 = z.getString("liveUid");
        this.G0 = z.getString("roomId");
        this.A0 = (TextView) this.y0.findViewById(b73.L2);
        View findViewById = this.y0.findViewById(b73.l);
        this.B0 = findViewById;
        if (this.H0) {
            findViewById.setVisibility(8);
            if (this.I0 != null) {
                this.A0.setText(aq4.a(m93.h2) + "(" + this.I0.getGuardNum() + ")");
            }
        } else {
            this.C0 = (TextView) this.y0.findViewById(b73.f5);
            TextView textView = (TextView) this.y0.findViewById(b73.A);
            this.D0 = textView;
            textView.setOnClickListener(this);
            if (this.I0 != null) {
                this.A0.setText(aq4.a(m93.h2) + "(" + this.I0.getGuardNum() + ")");
                int myGuardType = this.I0.getMyGuardType();
                if (myGuardType == 0) {
                    this.C0.setText(m93.n2);
                } else if (myGuardType == 1) {
                    this.C0.setText(aq4.a(m93.o2) + this.I0.getMyGuardEndTime());
                    this.D0.setText(m93.b2);
                } else if (myGuardType == 2) {
                    this.C0.setText(aq4.a(m93.p2) + this.I0.getMyGuardEndTime());
                    this.D0.setText(m93.b2);
                }
            }
        }
        CommonRefreshView commonRefreshView = (CommonRefreshView) this.y0.findViewById(b73.E4);
        this.z0 = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(this.H0 ? x73.t2 : x73.v2);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.z0.setDataHelper(new a());
        this.z0.k();
    }

    public void v2(LiveGuardInfo liveGuardInfo) {
        this.I0 = liveGuardInfo;
    }
}
