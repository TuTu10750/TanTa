package com.yunbao.main.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.mob.MobBean;
import defpackage.a82;
import defpackage.b82;
import defpackage.bs3;
import defpackage.c73;
import defpackage.db2;
import defpackage.et2;
import defpackage.j30;
import defpackage.k30;
import defpackage.kn1;
import defpackage.lc4;
import defpackage.le3;
import defpackage.m82;
import defpackage.m93;
import defpackage.pw3;
import defpackage.rv3;
import defpackage.t54;
import defpackage.u83;
import defpackage.y73;
import defpackage.zu0;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class LoginActivity extends AbsActivity implements et2 {
    public EditText e;
    public EditText f;
    public View g;
    public RecyclerView h;
    public boolean i;
    public String j = "phone";
    public TextView k;
    public boolean l;
    public ImageView m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public ImageView q;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginActivity.this.n = !r2.n;
            ImageView imageView = LoginActivity.this.m;
            boolean z = LoginActivity.this.n;
            LoginActivity loginActivity = LoginActivity.this;
            imageView.setImageDrawable(z ? loginActivity.o : loginActivity.p);
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
            LoginActivity.this.g.setEnabled((TextUtils.isEmpty(LoginActivity.this.e.getText().toString()) || TextUtils.isEmpty(LoginActivity.this.f.getText().toString())) ? false : true);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {

        /* loaded from: /tmp/classes2.dex */
        public class a extends ClickableSpan {
            public final /* synthetic */ JSONObject a;

            public a(JSONObject jSONObject) {
                this.a = jSONObject;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                WebViewActivity.E1(LoginActivity.this.b, this.a.getString(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL));
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(-14575654);
                textPaint.setUnderlineText(false);
            }
        }

        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (LoginActivity.this.q != null) {
                kn1.f(LoginActivity.this.b, parseObject.getString("login_img"), LoginActivity.this.q);
            }
            LoginActivity.this.l = parseObject.getIntValue("sendcode_type") == 1;
            String[] strArr2 = (String[]) JSON.parseObject(parseObject.getString("login_type"), String[].class);
            if (strArr2 != null && strArr2.length > 0) {
                List<MobBean> loginTypeList = MobBean.getLoginTypeList(strArr2);
                LoginActivity loginActivity = LoginActivity.this;
                loginActivity.h = loginActivity.findViewById(c73.h4);
                LoginActivity.this.h.setLayoutManager(new LinearLayoutManager(LoginActivity.this.b, 0, false));
                rq1 rq1Var = new rq1(LoginActivity.this.b, 0, 20.0f, 0.0f);
                rq1Var.l(true);
                LoginActivity.this.h.k(rq1Var);
                m82 m82Var = new m82(LoginActivity.this.b, loginTypeList);
                m82Var.Q(LoginActivity.this);
                LoginActivity.this.h.setAdapter(m82Var);
            }
            TextView textView = (TextView) LoginActivity.this.findViewById(c73.J3);
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
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            LoginActivity.this.V1(i, str, strArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends k30 {
        public e() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            if (LoginActivity.this.i) {
                RecommendActivity.C1(LoginActivity.this.b, LoginActivity.this.i);
            } else {
                zu0.c().j(new a82(true, false));
            }
            LoginActivity.this.finish();
        }
    }

    private void S1() {
        db2.E(new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void W1() {
        Intent intent = new Intent(this.b, (Class<?>) RegisterActivity.class);
        intent.putExtra("tip", this.l);
        startActivity(intent);
    }

    public final void Q1() {
        if (this.l) {
            startActivityForResult(new Intent(this.b, (Class<?>) ChooseCountryActivity.class), 101);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R1() {
        Intent intent = new Intent(this.b, (Class<?>) FindPwdActivity.class);
        intent.putExtra("fromLogin", true);
        intent.putExtra("tip", this.l);
        startActivity(intent);
    }

    public final void T1() {
        if (!this.n) {
            t54.a(m93.d5);
            return;
        }
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.e5);
            this.e.requestFocus();
            return;
        }
        String trim2 = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.f5);
            this.f.requestFocus();
            return;
        }
        this.j = "phone";
        String charSequence = this.k.getText().toString();
        if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("+")) {
            charSequence = charSequence.substring(1);
        }
        db2.f0(trim, trim2, charSequence, new d());
    }

    @Override // defpackage.et2
    /* renamed from: U1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(MobBean mobBean, int i) {
        if (this.n) {
            com.yunbao.common.utils.a.e(this.b).show();
        } else {
            t54.a(m93.d5);
        }
    }

    public final void V1(int i, String str, String[] strArr) {
        if (i == 0) {
            if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                String string = parseObject.getString("id");
                String string2 = parseObject.getString("token");
                this.i = parseObject.getIntValue("isreg") == 1;
                bs3.d().p("txImUserSign", parseObject.getString("usersign"));
                j30.q().Z(string, string2, true);
                S1();
                lc4.b(this.j, string);
                return;
            }
            return;
        }
        if (i != 1002) {
            t54.b(str);
            return;
        }
        if (strArr.length > 0) {
            b82 b82Var = new b82();
            JSONObject parseObject2 = JSON.parseObject(strArr[0]);
            Bundle bundle = new Bundle();
            bundle.putString("tip", parseObject2.getString("ban_reason"));
            bundle.putString("uid", parseObject2.getString("ban_tip"));
            b82Var.F1(bundle);
            b82Var.d2(getSupportFragmentManager(), "LoginForbiddenDialogFragment");
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.C;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return false;
    }

    public void loginClick(View view) {
        int id = view.getId();
        if (id == c73.D0) {
            T1();
            return;
        }
        if (id == c73.Y0) {
            W1();
        } else if (id == c73.q0) {
            R1();
        } else if (id == c73.V) {
            Q1();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        ((ImageView) findViewById(c73.j)).setImageResource(j30.q().d());
        this.q = (ImageView) findViewById(c73.k);
        this.o = o60.d(this.b, u83.b);
        this.p = o60.d(this.b, u83.a);
        ImageView imageView = (ImageView) findViewById(c73.E0);
        this.m = imageView;
        this.n = true;
        imageView.setImageDrawable(this.o);
        this.m.setOnClickListener(new a());
        this.k = (TextView) findViewById(c73.K1);
        this.e = (EditText) findViewById(c73.X1);
        this.f = (EditText) findViewById(c73.Y1);
        this.g = findViewById(c73.D0);
        b bVar = new b();
        this.e.addTextChangedListener(bVar);
        this.f.addTextChangedListener(bVar);
        String stringExtra = getIntent().getStringExtra("tip");
        if (!TextUtils.isEmpty(stringExtra)) {
            com.yunbao.common.utils.a.m(this.b, stringExtra);
        }
        zu0.c().n(this);
        db2.R(new c());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i, i2, intent);
        if (i == 101 && i2 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("toName");
            TextView textView = this.k;
            if (textView != null) {
                textView.setText(rv3.a("+", stringExtra));
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        zu0.c().p(this);
        db2.i("setLoginInfo");
        db2.i("loginByThird");
        db2.i("getBaseInfo");
        db2.i("getLoginInfo");
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @pw3(threadMode = ThreadMode.MAIN)
    public void onRegSuccessEvent(le3 le3Var) {
        finish();
    }
}
