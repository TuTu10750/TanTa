package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;

/* loaded from: /tmp/classes2.dex */
public class y42 extends l0 implements View.OnClickListener {
    public View A0;
    public EditText B0;
    public EditText C0;
    public EditText D0;
    public EditText E0;
    public EditText F0;
    public TextView G0;
    public TextView H0;
    public TextView I0;
    public CheckBox J0;
    public int K0;
    public String L0;
    public String M0;
    public String N0;
    public long O0 = 100;
    public long P0 = 10;
    public long Q0 = 1;
    public long R0 = 100;
    public View z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            boolean isEmpty = TextUtils.isEmpty(charSequence2);
            y42 y42Var = y42.this;
            if (isEmpty) {
                y42Var.O0 = 0L;
            } else {
                y42Var.O0 = Long.parseLong(charSequence2);
            }
            y42 y42Var2 = y42.this;
            y42Var2.B2(rv3.k(y42Var2.O0));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            boolean isEmpty = TextUtils.isEmpty(charSequence2);
            y42 y42Var = y42.this;
            if (isEmpty) {
                y42Var.Q0 = 0L;
            } else {
                y42Var.Q0 = Long.parseLong(charSequence2);
            }
            y42 y42Var2 = y42.this;
            y42Var2.B2(rv3.k(y42Var2.Q0 * y42.this.R0));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            String charSequence2 = charSequence.toString();
            boolean isEmpty = TextUtils.isEmpty(charSequence2);
            y42 y42Var = y42.this;
            if (isEmpty) {
                y42Var.R0 = 0L;
            } else {
                y42Var.R0 = Long.parseLong(charSequence2);
            }
            y42 y42Var2 = y42.this;
            y42Var2.B2(rv3.k(y42Var2.Q0 * y42.this.R0));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (strArr.length > 0) {
                    JSONObject parseObject = JSON.parseObject(strArr[0]);
                    UserBean D = j30.q().D();
                    if (D != null) {
                        D.setLevel(parseObject.getIntValue("level"));
                        D.setLevelAnchor(parseObject.getIntValue("level_anchor"));
                    }
                }
                y42.this.S1();
                ((LiveActivity) y42.this.x0).s2();
            }
            t54.b(str);
        }
    }

    public void A2(String str) {
        this.L0 = str;
    }

    public final void B2(String str) {
        TextView textView = this.G0;
        if (textView != null) {
            textView.setText(String.format(this.M0, str, this.N0));
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("sendRedPack");
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
        return x73.W;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.L0) {
            this.K0 = 1;
            View view2 = this.z0;
            if (view2 != null && view2.getVisibility() != 0) {
                this.z0.setVisibility(0);
            }
            View view3 = this.A0;
            if (view3 != null && view3.getVisibility() == 0) {
                this.A0.setVisibility(4);
            }
            B2(rv3.k(this.O0));
            return;
        }
        if (id != b73.I0) {
            if (id == b73.Y0) {
                z2();
                return;
            }
            return;
        }
        this.K0 = 0;
        View view4 = this.A0;
        if (view4 != null && view4.getVisibility() != 0) {
            this.A0.setVisibility(0);
        }
        View view5 = this.z0;
        if (view5 != null && view5.getVisibility() == 0) {
            this.z0.setVisibility(4);
        }
        B2(rv3.k(this.Q0 * this.R0));
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(300);
        attributes.height = zn0.a(380);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        if (TextUtils.isEmpty(this.L0)) {
            return;
        }
        this.M0 = aq4.a(m93.E9);
        this.H0 = (TextView) this.y0.findViewById(b73.x1);
        this.I0 = (TextView) this.y0.findViewById(b73.y1);
        String g = j30.q().g();
        this.N0 = g;
        this.H0.setText(g);
        this.I0.setText(this.N0);
        this.z0 = this.y0.findViewById(b73.G2);
        this.A0 = this.y0.findViewById(b73.E2);
        this.B0 = (EditText) this.y0.findViewById(b73.P1);
        this.C0 = (EditText) this.y0.findViewById(b73.R1);
        this.D0 = (EditText) this.y0.findViewById(b73.O1);
        this.E0 = (EditText) this.y0.findViewById(b73.Q1);
        this.B0.setText(String.valueOf(this.O0));
        this.C0.setText(String.valueOf(this.P0));
        this.D0.setText(String.valueOf(this.Q0));
        this.E0.setText(String.valueOf(this.R0));
        this.B0.addTextChangedListener(new a());
        this.D0.addTextChangedListener(new b());
        this.E0.addTextChangedListener(new c());
        this.y0.findViewById(b73.L0).setOnClickListener(this);
        this.y0.findViewById(b73.I0).setOnClickListener(this);
        TextView textView = (TextView) this.y0.findViewById(b73.Y0);
        this.G0 = textView;
        textView.setOnClickListener(this);
        B2(rv3.k(this.O0));
        this.F0 = (EditText) this.y0.findViewById(b73.S1);
        this.J0 = (CheckBox) this.y0.findViewById(b73.q1);
        this.K0 = 1;
    }

    public final void z2() {
        String trim;
        String trim2;
        if (this.K0 == 1) {
            trim = this.B0.getText().toString().trim();
            trim2 = this.C0.getText().toString().trim();
        } else {
            trim = this.D0.getText().toString().trim();
            trim2 = this.E0.getText().toString().trim();
        }
        String str = trim;
        String str2 = trim2;
        if (TextUtils.isEmpty(str)) {
            t54.a(m93.F9);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            t54.a(m93.G9);
            return;
        }
        String trim3 = this.F0.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            trim3 = this.F0.getHint().toString().trim();
        }
        e32.A0(this.L0, str, str2, trim3, this.K0, !this.J0.isChecked() ? 1 : 0, new d());
    }
}
