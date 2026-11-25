package defpackage;

import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.LoginNewActivity;

/* loaded from: /tmp/classes2.dex */
public class pe3 extends v0 {
    public EditText a;
    public EditText b;
    public EditText c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            if (z || pe3.this.a.getText().toString().trim().matches("^[a-zA-Z][a-zA-Z0-9_]{5,17}$")) {
                return;
            }
            pe3.this.a.setError("账号要求：字母开头，可使用字母、数字、下划线，长度6-18为。");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            t54.b("注册成功");
            j30.q().D().setUserLogin(this.a);
            zu0.c().j(new le3());
            pe3.this.mContext.finish();
        }
    }

    public pe3(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public static /* synthetic */ void b0(pe3 pe3Var, View view) {
        pe3Var.mContext.startActivity(new Intent(pe3Var.mContext, (Class<?>) LoginNewActivity.class));
        pe3Var.mContext.finish();
    }

    @Override // defpackage.v0
    public void getData() {
        String obj = this.a.getText().toString();
        String obj2 = this.b.getText().toString();
        String obj3 = this.c.getText().toString();
        if (obj.isEmpty()) {
            t54.b("账号不能为空");
            return;
        }
        if (!obj.matches("^[a-zA-Z][a-zA-Z0-9_]{5,17}$")) {
            t54.b("账号要求：字母开头，可使用字母、数字、下划线，长度6-18为。");
            return;
        }
        if (obj2.isEmpty()) {
            t54.b("密码不能为空");
            return;
        }
        if (obj3.isEmpty()) {
            t54.b("确认密码不能为空");
        } else if (obj3.equals(obj2)) {
            db2.b(obj, obj2, new b(obj));
        } else {
            t54.b("两次密码不一样");
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.V0;
    }

    @Override // defpackage.b1
    public void init() {
        EditText editText = (EditText) findViewById(c73.b2);
        this.a = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(18)});
        this.a.setOnFocusChangeListener(new a());
        this.b = (EditText) findViewById(c73.f2);
        this.c = (EditText) findViewById(c73.g2);
        findViewById(c73.Z4).setOnClickListener(new View.OnClickListener() { // from class: ne3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pe3.this.getData();
            }
        });
        findViewById(c73.S4).setOnClickListener(new View.OnClickListener() { // from class: oe3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pe3.b0(pe3.this, view);
            }
        });
    }
}
