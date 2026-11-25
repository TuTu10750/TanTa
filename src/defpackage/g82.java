package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.main.activity.RegisterNewActivity;

/* loaded from: /tmp/classes2.dex */
public class g82 extends v0 {
    public EditText a;
    public EditText b;

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
            j30.q().Z(parseObject.getString("uid"), parseObject.getString("token"), false);
            t54.b("登录成功");
            g82.this.mContext.finish();
        }
    }

    public g82(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public static /* synthetic */ void a0(g82 g82Var, View view) {
        g82Var.mContext.startActivity(new Intent(g82Var.mContext, (Class<?>) RegisterNewActivity.class));
        g82Var.mContext.finish();
    }

    @Override // defpackage.v0
    public void getData() {
        String obj = this.a.getText().toString();
        String obj2 = this.b.getText().toString();
        if (obj.isEmpty()) {
            t54.b("账号不能为空");
        } else if (obj2.isEmpty()) {
            t54.b("密码不能为空");
        } else {
            db2.a(obj, obj2, new a());
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.c0;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (EditText) findViewById(c73.b2);
        this.b = (EditText) findViewById(c73.f2);
        findViewById(c73.S4).setOnClickListener(new View.OnClickListener() { // from class: e82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g82.this.getData();
            }
        });
        findViewById(c73.Y4).setOnClickListener(new View.OnClickListener() { // from class: f82
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g82.a0(g82.this, view);
            }
        });
    }
}
