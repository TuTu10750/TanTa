package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import defpackage.a82;
import defpackage.aq4;
import defpackage.bs3;
import defpackage.c73;
import defpackage.ck1;
import defpackage.db2;
import defpackage.j30;
import defpackage.k30;
import defpackage.lc4;
import defpackage.le3;
import defpackage.m93;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.y73;
import defpackage.zu0;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class FindPwdActivity extends AbsActivity {
    public EditText e;
    public EditText f;
    public EditText g;
    public EditText h;
    public TextView i;
    public View j;
    public Handler k;
    public String m;
    public String n;
    public Dialog o;
    public boolean p;
    public TextView q;
    public boolean r;
    public boolean s;
    public int l = 60;
    public HttpCallback t = new d();

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
            FindPwdActivity.this.M1();
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
            FindPwdActivity.this.M1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends Handler {
        public c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FindPwdActivity.B1(FindPwdActivity.this);
            int i = FindPwdActivity.this.l;
            FindPwdActivity findPwdActivity = FindPwdActivity.this;
            if (i <= 0) {
                findPwdActivity.i.setText(FindPwdActivity.this.m);
                FindPwdActivity.this.l = 60;
                if (FindPwdActivity.this.i != null) {
                    FindPwdActivity.this.i.setEnabled(true);
                    return;
                }
                return;
            }
            findPwdActivity.i.setText(FindPwdActivity.this.n + "(" + FindPwdActivity.this.l + "s)");
            if (FindPwdActivity.this.k != null) {
                FindPwdActivity.this.k.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            FindPwdActivity.this.i.setEnabled(false);
            if (FindPwdActivity.this.k != null) {
                FindPwdActivity.this.k.sendEmptyMessage(0);
            }
            if (TextUtils.isEmpty(str) || !str.contains("123456")) {
                return;
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (FindPwdActivity.this.o != null) {
                FindPwdActivity.this.o.dismiss();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            FindPwdActivity findPwdActivity = FindPwdActivity.this;
            if (i != 0) {
                if (findPwdActivity.o != null) {
                    FindPwdActivity.this.o.dismiss();
                }
                t54.b(str);
            } else {
                if (findPwdActivity.s) {
                    FindPwdActivity.this.P1(this.a, this.b);
                    return;
                }
                j30.q().b();
                ck1.e().j();
                lc4.c();
                Intent intent = new Intent(FindPwdActivity.this.b, (Class<?>) MainActivity.class);
                intent.addFlags(67141632);
                FindPwdActivity.this.startActivity(intent);
                t54.b(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (FindPwdActivity.this.o != null) {
                FindPwdActivity.this.o.dismiss();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                String string = parseObject.getString("id");
                String string2 = parseObject.getString("token");
                FindPwdActivity.this.p = parseObject.getIntValue("isreg") == 1;
                bs3.d().p("txImUserSign", parseObject.getString("usersign"));
                j30.q().Z(string, string2, true);
                FindPwdActivity.this.N1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends k30 {
        public g() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            if (FindPwdActivity.this.o != null) {
                FindPwdActivity.this.o.dismiss();
            }
            if (userBean != null) {
                if (FindPwdActivity.this.p) {
                    RecommendActivity.C1(FindPwdActivity.this.b, FindPwdActivity.this.p);
                } else {
                    zu0.c().j(new a82(true, FindPwdActivity.this.p));
                }
                zu0.c().j(new le3());
            }
        }
    }

    public static /* synthetic */ int B1(FindPwdActivity findPwdActivity) {
        int i = findPwdActivity.l;
        findPwdActivity.l = i - 1;
        return i;
    }

    private void O1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.L9);
            this.e.requestFocus();
            return;
        }
        this.f.requestFocus();
        String charSequence = this.q.getText().toString();
        if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("+")) {
            charSequence = charSequence.substring(1);
        }
        db2.O(trim, charSequence, this.t);
    }

    public final void M1() {
        this.j.setEnabled((TextUtils.isEmpty(this.e.getText().toString()) || TextUtils.isEmpty(this.f.getText().toString()) || TextUtils.isEmpty(this.g.getText().toString()) || TextUtils.isEmpty(this.h.getText().toString())) ? false : true);
    }

    public final void N1() {
        db2.E(new g());
    }

    public final void P1(String str, String str2) {
        String charSequence = this.q.getText().toString();
        if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("+")) {
            charSequence = charSequence.substring(1);
        }
        db2.f0(str, str2, charSequence, new f());
    }

    public final void Q1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.L9);
            this.e.requestFocus();
            return;
        }
        String trim2 = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.K9);
            this.f.requestFocus();
            return;
        }
        String trim3 = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.M9);
            this.g.requestFocus();
            return;
        }
        String trim4 = this.h.getText().toString().trim();
        if (TextUtils.isEmpty(trim4)) {
            t54.a(m93.N9);
            this.h.requestFocus();
            return;
        }
        Dialog dialog = this.o;
        if (dialog != null) {
            dialog.show();
        }
        String charSequence = this.q.getText().toString();
        if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("+")) {
            charSequence = charSequence.substring(1);
        }
        db2.s(trim, trim3, trim4, trim2, charSequence, new e(trim, trim3));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.L1));
        Intent intent = getIntent();
        this.r = intent.getBooleanExtra("tip", false);
        this.s = intent.getBooleanExtra("fromLogin", false);
        this.e = (EditText) findViewById(c73.X1);
        this.f = (EditText) findViewById(c73.T1);
        this.g = (EditText) findViewById(c73.Z1);
        this.h = (EditText) findViewById(c73.a2);
        this.i = (TextView) findViewById(c73.a0);
        this.j = findViewById(c73.Y0);
        this.m = aq4.a(m93.I9);
        this.n = aq4.a(m93.J9);
        this.q = (TextView) findViewById(c73.K1);
        this.e.addTextChangedListener(new a());
        b bVar = new b();
        this.f.addTextChangedListener(bVar);
        this.g.addTextChangedListener(bVar);
        this.h.addTextChangedListener(bVar);
        this.k = new c();
        this.o = com.yunbao.common.utils.a.c(this.b);
        zu0.c().n(this);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("toName");
            TextView textView = this.q;
            if (textView != null) {
                textView.setText(rv3.a("+", stringExtra));
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("getFindPwdCode");
        db2.i("findPwd");
        db2.i("setLoginInfo");
        db2.i("getBaseInfo");
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.k = null;
        }
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @pw3(threadMode = ThreadMode.MAIN)
    public void onRegSuccessEvent(le3 le3Var) {
        finish();
    }

    public void registerClick(View view) {
        int id = view.getId();
        if (id == c73.a0) {
            O1();
            return;
        }
        if (id == c73.Y0) {
            Q1();
        } else if (id == c73.V && this.r) {
            startActivityForResult(new Intent(this.b, (Class<?>) ChooseCountryActivity.class), 101);
        }
    }
}
