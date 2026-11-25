package defpackage;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.bean.GuardBuyBean;
import com.yunbao.live.bean.GuardRightBean;
import com.yunbao.live.bean.LiveGuardInfo;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class b32 extends l0 implements View.OnClickListener {
    public RadioGroup A0;
    public RadioButton[] B0;
    public TextView C0;
    public TextView D0;
    public String E0;
    public View F0;
    public List G0;
    public List H0;
    public de1 I0;
    public long J0;
    public String K0;
    public String L0;
    public String M0;
    public LiveGuardInfo N0;
    public GuardBuyBean O0;
    public Drawable P0;
    public Drawable Q0;
    public RecyclerView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            b32.this.G0 = JSON.parseArray(parseObject.getString("privilege"), GuardRightBean.class);
            b32.this.H0 = JSON.parseArray(parseObject.getString("list"), GuardBuyBean.class);
            b32.this.J0 = parseObject.getLongValue("coin");
            b32.this.D0.setText(String.valueOf(b32.this.J0));
            int size = b32.this.H0.size();
            int length = b32.this.B0.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 < size) {
                    GuardBuyBean guardBuyBean = (GuardBuyBean) b32.this.H0.get(i2);
                    b32.this.B0[i2].setText(rv3.a(guardBuyBean.getName(), UMCustomLogInfoBuilder.LINE_SEP, String.valueOf(guardBuyBean.getCoin()), b32.this.E0));
                }
            }
            b32.this.F2(0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            b32.this.E2();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            b32.this.E2();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                parseObject.getString("votestotal");
                int intValue = parseObject.getIntValue("guard_nums");
                int intValue2 = parseObject.getIntValue("type");
                zu0.c().j(new ne4(parseObject.getIntValue("level")));
                if (b32.this.N0 != null) {
                    b32.this.N0.setMyGuardType(intValue2);
                    b32.this.N0.setMyGuardEndTime(parseObject.getString("endtime"));
                    b32.this.N0.setGuardNum(intValue);
                }
                b32.this.J0 = parseObject.getLongValue("coin");
                String valueOf = String.valueOf(b32.this.J0);
                b32.this.D0.setText(valueOf);
                UserBean D = j30.q().D();
                if (D != null) {
                    D.setCoin(valueOf);
                    D.setLevel(parseObject.getIntValue("level"));
                }
                b32.this.S1();
            }
            t54.b(str);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.N0 = null;
        e32.f("getGuardBuyList");
        super.C0();
    }

    public final void C2() {
        GuardBuyBean guardBuyBean = this.O0;
        if (guardBuyBean == null) {
            return;
        }
        com.yunbao.common.utils.a.i(this.x0, aq4.b(m93.f2, Integer.valueOf(guardBuyBean.getCoin()), this.E0, this.O0.getShopName()), new c());
    }

    public final void D2() {
        LiveGuardInfo liveGuardInfo;
        if (TextUtils.isEmpty(this.K0) || (liveGuardInfo = this.N0) == null || this.O0 == null) {
            return;
        }
        if (liveGuardInfo.getMyGuardType() > this.O0.getType()) {
            com.yunbao.common.utils.a.m(this.x0, aq4.a(m93.d2));
        } else if (this.N0.getMyGuardType() == 1 && this.O0.getType() == 2) {
            com.yunbao.common.utils.a.i(this.x0, aq4.a(m93.e2), new b());
        } else {
            C2();
        }
    }

    public final void E2() {
        GuardBuyBean guardBuyBean = this.O0;
        if (guardBuyBean == null) {
            return;
        }
        e32.e(this.K0, this.L0, this.M0, guardBuyBean.getId(), new d());
    }

    public final void F2(int i) {
        RadioGroup radioGroup = this.A0;
        if (radioGroup != null) {
            radioGroup.setBackground(i == 2 ? this.Q0 : this.P0);
        }
        List list = this.G0;
        if (list == null || this.H0 == null) {
            return;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else {
                ((GuardRightBean) it.next()).setChecked(false);
            }
        }
        if (this.H0.size() > i) {
            GuardBuyBean guardBuyBean = (GuardBuyBean) this.H0.get(i);
            this.O0 = guardBuyBean;
            for (int i2 : guardBuyBean.getPrivilege()) {
                if (this.G0.size() > i2) {
                    ((GuardRightBean) this.G0.get(i2)).setChecked(true);
                }
            }
            de1 de1Var = this.I0;
            if (de1Var == null) {
                de1 de1Var2 = new de1(this.x0, this.G0);
                this.I0 = de1Var2;
                this.z0.setAdapter(de1Var2);
            } else {
                de1Var.p();
            }
            this.F0.setEnabled(this.J0 >= ((long) guardBuyBean.getCoin()));
        }
    }

    public void G2(LiveGuardInfo liveGuardInfo) {
        this.N0 = liveGuardInfo;
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
        return x73.E;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.m) {
            F2(0);
            return;
        }
        if (id == b73.o) {
            F2(1);
        } else if (id == b73.p) {
            F2(2);
        } else if (id == b73.A) {
            D2();
        }
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
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.z0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.z0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        this.A0 = (RadioGroup) this.y0.findViewById(b73.y4);
        RadioButton[] radioButtonArr = new RadioButton[3];
        this.B0 = radioButtonArr;
        radioButtonArr[0] = (RadioButton) this.y0.findViewById(b73.m);
        this.B0[1] = (RadioButton) this.y0.findViewById(b73.o);
        this.B0[2] = (RadioButton) this.y0.findViewById(b73.p);
        this.C0 = (TextView) this.y0.findViewById(b73.w1);
        this.D0 = (TextView) this.y0.findViewById(b73.s1);
        this.F0 = this.y0.findViewById(b73.A);
        this.B0[0].setOnClickListener(this);
        this.B0[1].setOnClickListener(this);
        this.B0[2].setOnClickListener(this);
        this.P0 = o60.d(this.x0, t83.a);
        this.Q0 = o60.d(this.x0, t83.b);
        this.F0.setOnClickListener(this);
        Bundle z = z();
        if (z != null) {
            this.K0 = z.getString("liveUid");
            this.L0 = z.getString("roomId");
            this.M0 = z.getString("stream");
            String string = z.getString("coinName");
            this.E0 = string;
            this.C0.setText(aq4.a(m93.j2) + string + ":");
        }
        e32.J(new a());
    }
}
