package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public class co3 extends v0 {
    public EditText a;
    public EditText b;
    public TextView c;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
            } else {
                t54.b("设置密码成功");
                co3.this.mContext.finish();
            }
        }
    }

    public co3(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.v0
    public void getData() {
        String obj = this.a.getText().toString();
        String obj2 = this.b.getText().toString();
        if (obj.isEmpty()) {
            t54.b("密码不能为空");
            return;
        }
        if (obj2.isEmpty()) {
            t54.b("确认密码不能为空");
        } else if (obj2.equals(obj)) {
            db2.w0(obj, new a());
        } else {
            t54.b("两次密码不一样");
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.W0;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (EditText) findViewById(c73.f2);
        this.b = (EditText) findViewById(c73.g2);
        TextView textView = (TextView) findViewById(c73.K4);
        this.c = textView;
        textView.setText("账号：" + j30.q().D().getUserLogin());
        findViewById(c73.o5).setOnClickListener(new View.OnClickListener() { // from class: bo3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                co3.this.getData();
            }
        });
    }
}
