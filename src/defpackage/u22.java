package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.BackPackGiftBean;
import defpackage.o0;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class u22 extends o0 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            View view = u22.this.d;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            List a;
            if (i != 0 || strArr.length <= 0 || (a = mu1.a(Arrays.toString(strArr), BackPackGiftBean.class)) == null) {
                return;
            }
            u22.this.i0(a);
        }
    }

    public u22(Context context, ViewGroup viewGroup, String str, String str2) {
        super(context, viewGroup, str, str2);
    }

    @Override // defpackage.o0
    public int b0() {
        return 2;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.a2;
    }

    @Override // defpackage.o0, defpackage.b1
    public void init() {
        super.init();
    }

    public void j0(int i, int i2) {
        v22 v22Var = this.l;
        if (v22Var != null) {
            v22Var.w(i, i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.o0
    public void loadData() {
        o0.b bVar = this.p;
        if (bVar != null) {
            bVar.d(this.m);
        }
        if (isFirstLoadData()) {
            boolean L1 = ((LiveActivity) this.mContext).L1();
            e32.E(L1 ? 1 : 0, new a());
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        e32.f("Backpack.getBackpack");
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.n = (String) objArr[0];
        this.o = (String) objArr[1];
    }
}
