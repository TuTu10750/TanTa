package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.FirstChargeBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class k21 extends l0 implements View.OnClickListener {
    public j21 A0;
    public RadioButton B0;
    public RadioButton C0;
    public RadioButton D0;
    public List E0;
    public int F0;
    public boolean G0;
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
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            k21.this.G0 = parseObject.getIntValue("has_used") == 1;
            List parseArray = JSON.parseArray(parseObject.getString("list"), FirstChargeBean.class);
            k21.this.E0 = parseArray;
            k21.this.B0.setText(((FirstChargeBean) parseArray.get(0)).getTitle());
            k21.this.C0.setText(((FirstChargeBean) parseArray.get(1)).getTitle());
            k21.this.D0.setText(((FirstChargeBean) parseArray.get(2)).getTitle());
            k21.this.F0 = 0;
            k21.this.A2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A2() {
        List list;
        if (this.A0 == null || (list = this.E0) == null) {
            return;
        }
        int size = list.size();
        int i = this.F0;
        if (size > i) {
            this.A0.P(((FirstChargeBean) this.E0.get(i)).getList());
        }
    }

    private void y2() {
        if (this.G0) {
            t54.a(m93.c0);
            return;
        }
        List list = this.E0;
        if (list != null) {
            int size = list.size();
            int i = this.F0;
            if (size > i) {
                FirstChargeBean firstChargeBean = (FirstChargeBean) this.E0.get(i);
                n21 n21Var = new n21();
                Bundle bundle = new Bundle();
                bundle.putString("id", firstChargeBean.getId());
                bundle.putString("name", firstChargeBean.getTitle());
                bundle.putString("money", firstChargeBean.getMoney());
                bundle.putString("coin", firstChargeBean.getCoin());
                n21Var.F1(bundle);
                n21Var.d2(((AbsActivity) this.x0).getSupportFragmentManager(), "FirstChargePayDialogFragment");
                S1();
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        CommonHttpUtil.cancel(CommonHttpConsts.GET_FIRST_CHARGE_RULES);
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
        return u73.k;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == y63.i) {
            S1();
            return;
        }
        if (id == y63.c) {
            z2(0);
            return;
        }
        if (id == y63.d) {
            z2(1);
        } else if (id == y63.e) {
            z2(2);
        } else if (id == y63.h) {
            y2();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(y63.i).setOnClickListener(this);
        this.B0 = (RadioButton) k2(y63.c);
        this.C0 = (RadioButton) k2(y63.d);
        this.D0 = (RadioButton) k2(y63.e);
        this.B0.setOnClickListener(this);
        this.C0.setOnClickListener(this);
        this.D0.setOnClickListener(this);
        k2(y63.h).setOnClickListener(this);
        RecyclerView k2 = k2(y63.Z);
        this.z0 = k2;
        k2.setLayoutManager(new LinearLayoutManager(this.x0, 0, false));
        j21 j21Var = new j21(this.x0);
        this.A0 = j21Var;
        this.z0.setAdapter(j21Var);
        CommonHttpUtil.getFirstChargeRules(new a());
    }

    public final void z2(int i) {
        if (this.F0 == i) {
            return;
        }
        this.F0 = i;
        A2();
    }
}
