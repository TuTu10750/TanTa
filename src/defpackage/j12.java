package defpackage;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class j12 extends l0 {
    public String A0;
    public k30 B0;
    public yy z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements ry {
        public a() {
        }

        @Override // defpackage.ry
        public void a() {
            j12.this.S1();
        }

        @Override // defpackage.ry
        public void b() {
        }

        @Override // defpackage.ry
        public void c() {
        }

        @Override // defpackage.ry
        public void d() {
        }

        @Override // defpackage.ry
        public void e() {
        }
    }

    @Override // defpackage.l0
    public void C0() {
        yy yyVar = this.z0;
        if (yyVar != null) {
            yyVar.release();
        }
        j30.E = "";
        super.C0();
    }

    public void N0() {
        super/*androidx.fragment.app.Fragment*/.N0();
        yy yyVar = this.z0;
        if (yyVar != null) {
            yyVar.onPause();
        }
    }

    public void S0() {
        super/*androidx.fragment.app.Fragment*/.S0();
        yy yyVar = this.z0;
        if (yyVar != null) {
            yyVar.onResume();
        }
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
        return x73.p;
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
        UserBean userBean;
        super.r0(bundle);
        Bundle z = z();
        if (z == null || (userBean = (UserBean) z.getParcelable("userBean")) == null) {
            return;
        }
        yy yyVar = new yy(this.x0, (ViewGroup) this.y0, userBean, z.getBoolean("follow"));
        this.z0 = yyVar;
        yyVar.F0(this.A0);
        this.z0.E0(this.B0);
        this.z0.D0(new a());
        this.z0.addToParent();
        this.z0.loadData();
    }

    public void r2(int i) {
        yy yyVar = this.z0;
        if (yyVar != null) {
            yyVar.A0(i);
        }
    }
}
