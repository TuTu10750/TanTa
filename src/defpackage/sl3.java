package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.CountryBean;
import com.yunbao.common.bean.CountryListBean;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import defpackage.pl3;
import java.lang.reflect.Field;
import java.util.Arrays;

/* loaded from: /tmp/classes2.dex */
public class sl3 extends l0 {
    public pl3 A0;
    public k30 B0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            sl3.this.A0.P(mu1.a(Arrays.toString(strArr), CountryListBean.class));
        }
    }

    public static /* synthetic */ void s2(sl3 sl3Var, CountryBean countryBean) {
        sl3Var.B0.a(countryBean);
        sl3Var.S1();
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
        return u73.s;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(y63.f).setOnClickListener(new View.OnClickListener() { // from class: ql3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                sl3.this.S1();
            }
        });
        RecyclerView k2 = k2(y63.Z);
        this.z0 = k2;
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        pl3 pl3Var = new pl3(this.x0);
        this.A0 = pl3Var;
        pl3Var.T(new pl3.a() { // from class: rl3
            @Override // pl3.a
            public final void a(CountryBean countryBean) {
                sl3.s2(sl3.this, countryBean);
            }
        });
        this.z0.setAdapter(this.A0);
        u2();
    }

    public final void u2() {
        CommonHttpUtil.getCountrys(new a());
    }

    public void v2(k30 k30Var) {
        this.B0 = k30Var;
    }

    public void w2(k61 k61Var, String str) {
        try {
            Field declaredField = jm0.class.getDeclaredField("u0");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = jm0.class.getDeclaredField("v0");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            s61 o = k61Var.o();
            o.d(this, str);
            o.i();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
