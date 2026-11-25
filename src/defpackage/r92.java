package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.LuckPanBean;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class r92 extends l0 implements View.OnClickListener {
    public q92 A0;
    public CommonRefreshView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (r92.this.A0 == null) {
                r92 r92Var = r92.this;
                r92Var.A0 = new q92(r92Var.x0, true);
            }
            return r92.this.A0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            e32.f0(((LiveActivity) r92.this.x0).L1() ? 1 : 0, i, httpCallback);
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
            return mu1.a(Arrays.toString(strArr), LuckPanBean.class);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        super.C0();
        e32.f("Turntable.GetWin");
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.i0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b73.N) {
            S1();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = zn0.a(320);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.N).setOnClickListener(this);
        CommonRefreshView commonRefreshView = (CommonRefreshView) k2(b73.E4);
        this.z0 = commonRefreshView;
        commonRefreshView.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.z0.setDataHelper(new a());
        this.z0.k();
    }
}
