package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.bean.MainStartDialogBean;
import java.util.ArrayList;

/* loaded from: /tmp/classes2.dex */
public class vb2 extends l0 implements et2 {
    public JSONObject A0;
    public tb2 z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            vb2.this.S1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            vb2.this.A0 = JSON.parseObject(strArr[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new MainStartDialogBean(u83.u, m93.n5));
            arrayList.add(new MainStartDialogBean(u83.x, m93.d));
            arrayList.add(new MainStartDialogBean(u83.v, m93.Ra));
            arrayList.add(new MainStartDialogBean(u83.w, m93.o5));
            ub2 ub2Var = new ub2(vb2.this.x0, arrayList);
            ub2Var.R(vb2.this);
            RecyclerView k2 = vb2.this.k2(c73.h4);
            k2.setLayoutManager(new GridLayoutManager(vb2.this.x0, 4, 1, false));
            k2.setAdapter(ub2Var);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("getLiveSdk");
        this.z0 = null;
        super.C0();
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
        return y73.a0;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(c73.Z).setOnClickListener(new a());
        e32.T(new b());
    }

    @Override // defpackage.et2
    /* renamed from: v2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(MainStartDialogBean mainStartDialogBean, int i) {
        tb2 tb2Var;
        S1();
        int textRes = mainStartDialogBean.getTextRes();
        if (textRes == m93.n5) {
            tb2 tb2Var2 = this.z0;
            if (tb2Var2 != null) {
                tb2Var2.a(this.A0);
                return;
            }
            return;
        }
        if (textRes == m93.d) {
            tb2 tb2Var3 = this.z0;
            if (tb2Var3 != null) {
                tb2Var3.c(this.A0);
                return;
            }
            return;
        }
        if (textRes == m93.o5) {
            t54.b("下个版本开放，敬请期待");
        } else {
            if (textRes != m93.Ra || (tb2Var = this.z0) == null) {
                return;
            }
            tb2Var.b(this.A0);
        }
    }

    public void w2(tb2 tb2Var) {
        this.z0 = tb2Var;
    }
}
