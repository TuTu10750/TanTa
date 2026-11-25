package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import defpackage.a82;
import defpackage.aq4;
import defpackage.b5;
import defpackage.bs3;
import defpackage.c73;
import defpackage.db2;
import defpackage.j30;
import defpackage.k30;
import defpackage.kn1;
import defpackage.lc4;
import defpackage.le3;
import defpackage.m93;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.u83;
import defpackage.y73;
import defpackage.zu0;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class RegisterActivity extends AbsActivity {
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
    public String s;
    public ImageView t;
    public boolean u;
    public Drawable v;
    public Drawable w;
    public ImageView x;
    public int l = 60;
    public HttpCallback y = new h();

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public a() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            if (RegisterActivity.this.o != null) {
                RegisterActivity.this.o.dismiss();
            }
            if (userBean != null) {
                if (RegisterActivity.this.p) {
                    RecommendActivity.C1(RegisterActivity.this.b, RegisterActivity.this.p);
                } else {
                    zu0.c().j(new a82(true, RegisterActivity.this.p));
                }
                zu0.c().j(new le3());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RegisterActivity.this.u = !r2.u;
            ImageView imageView = RegisterActivity.this.t;
            boolean z = RegisterActivity.this.u;
            RegisterActivity registerActivity = RegisterActivity.this;
            imageView.setImageDrawable(z ? registerActivity.v : registerActivity.w);
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
            RegisterActivity.this.U1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements TextWatcher {
        public d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            RegisterActivity.this.U1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            RegisterActivity.P1(RegisterActivity.this);
            int i = RegisterActivity.this.l;
            RegisterActivity registerActivity = RegisterActivity.this;
            if (i <= 0) {
                registerActivity.i.setText(RegisterActivity.this.m);
                RegisterActivity.this.l = 60;
                if (RegisterActivity.this.i != null) {
                    RegisterActivity.this.i.setEnabled(true);
                    return;
                }
                return;
            }
            registerActivity.i.setText(RegisterActivity.this.n + "(" + RegisterActivity.this.l + "s)");
            if (RegisterActivity.this.k != null) {
                RegisterActivity.this.k.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a extends ClickableSpan {
            public final /* synthetic */ JSONObject a;

            public a(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewActivity.E1(RegisterActivity.this.b, this.a.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(-14575654);
                textPaint.setUnderlineText(false);
            }
        }

        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (RegisterActivity.this.x != null) {
                kn1.f(RegisterActivity.this.b, parseObject.getString("login_img"), RegisterActivity.this.x);
            }
            RegisterActivity.this.r = parseObject.getIntValue("sendcode_type") == 1;
            TextView textView = (TextView) RegisterActivity.this.findViewById(c73.J3);
            if (textView != null) {
                JSONObject jSONObject = parseObject.getJSONObject("login_alert");
                String string = jSONObject.getString("login_title");
                if (TextUtils.isEmpty(string)) {
                    return;
                }
                SpannableString spannableString = new SpannableString(string);
                JSONArray parseArray = JSON.parseArray(jSONObject.getString("message"));
                int size = parseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    JSONObject jSONObject2 = parseArray.getJSONObject(i2);
                    String string2 = jSONObject2.getString("title");
                    int indexOf = string.indexOf(string2);
                    if (indexOf >= 0) {
                        spannableString.setSpan(new a(jSONObject2), indexOf, string2.length() + indexOf, 33);
                    }
                }
                textView.setText(spannableString);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setHighlightColor(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends s4 {
        public g() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("toName");
                if (RegisterActivity.this.q != null) {
                    RegisterActivity.this.q.setText(rv3.a("+", stringExtra));
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public h() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            RegisterActivity.this.i.setEnabled(false);
            if (RegisterActivity.this.k != null) {
                RegisterActivity.this.k.sendEmptyMessage(0);
            }
            if (TextUtils.isEmpty(str) || !str.contains("123456")) {
                return;
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public i(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (RegisterActivity.this.o != null) {
                RegisterActivity.this.o.dismiss();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            RegisterActivity registerActivity = RegisterActivity.this;
            if (i == 0) {
                registerActivity.X1(this.a, this.b);
                return;
            }
            if (registerActivity.o != null) {
                RegisterActivity.this.o.dismiss();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends HttpCallback {
        public j() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (RegisterActivity.this.o != null) {
                RegisterActivity.this.o.dismiss();
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("id");
            String string2 = parseObject.getString("token");
            RegisterActivity.this.p = parseObject.getIntValue("isreg") == 1;
            bs3.d().p("txImUserSign", parseObject.getString("usersign"));
            j30.q().Z(string, string2, true);
            RegisterActivity.this.V1();
            lc4.b("phone", string);
        }
    }

    public static /* synthetic */ int P1(RegisterActivity registerActivity) {
        int i2 = registerActivity.l;
        registerActivity.l = i2 - 1;
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U1() {
        this.j.setEnabled((TextUtils.isEmpty(this.e.getText().toString()) || TextUtils.isEmpty(this.f.getText().toString()) || TextUtils.isEmpty(this.g.getText().toString()) || TextUtils.isEmpty(this.h.getText().toString())) ? false : true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V1() {
        db2.E(new a());
    }

    private void W1() {
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
        db2.Y(trim, charSequence, this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X1(String str, String str2) {
        String charSequence = this.q.getText().toString();
        if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("+")) {
            charSequence = charSequence.substring(1);
        }
        db2.f0(str, str2, charSequence, new j());
    }

    private void Y1() {
        if (!this.u) {
            t54.a(m93.d5);
            return;
        }
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
        String str = charSequence;
        System.out.println("vvcode---" + this.s);
        db2.n0(this.s, trim, trim3, trim4, trim2, str, new i(trim, trim3));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.O;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.P9));
        this.r = getIntent().getBooleanExtra("tip", false);
        this.e = (EditText) findViewById(c73.X1);
        this.f = (EditText) findViewById(c73.T1);
        this.g = (EditText) findViewById(c73.Z1);
        this.h = (EditText) findViewById(c73.a2);
        this.i = (TextView) findViewById(c73.a0);
        this.v = o60.d(this.b, u83.b);
        this.w = o60.d(this.b, u83.a);
        ImageView imageView = (ImageView) findViewById(c73.E0);
        this.t = imageView;
        this.u = true;
        imageView.setImageDrawable(this.v);
        this.t.setOnClickListener(new b());
        this.j = findViewById(c73.Y0);
        this.m = aq4.a(m93.I9);
        this.n = aq4.a(m93.J9);
        this.q = (TextView) findViewById(c73.K1);
        this.e.addTextChangedListener(new c());
        d dVar = new d();
        this.f.addTextChangedListener(dVar);
        this.g.addTextChangedListener(dVar);
        this.h.addTextChangedListener(dVar);
        this.k = new e();
        this.o = com.yunbao.common.utils.a.d(this.b, getString(m93.Q9));
        zu0.c().n(this);
        db2.R(new f());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("getRegisterCode");
        db2.i("register");
        db2.i("setLoginInfo");
        db2.i("getBaseInfo");
        Handler handler = this.k;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.k = null;
        }
        super.onDestroy();
    }

    public void onNewIntent(Intent intent) {
        super/*androidx.activity.ComponentActivity*/.onNewIntent(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @pw3(threadMode = ThreadMode.MAIN)
    public void onRegSuccessEvent(le3 le3Var) {
        finish();
    }

    public void registerClick(View view) {
        int id = view.getId();
        if (id == c73.a0) {
            W1();
            return;
        }
        if (id == c73.Y0) {
            Y1();
        } else if (id == c73.V && this.r) {
            b5.a(this, new Intent(this.b, (Class<?>) ChooseCountryActivity.class), new g());
        }
    }
}
