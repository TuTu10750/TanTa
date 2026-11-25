package com.yunbao.common.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.yunbao.common.CommonAppContext;
import defpackage.m93;
import defpackage.t54;
import defpackage.u73;
import defpackage.y63;

/* loaded from: /tmp/classes2.dex */
public class ErrorActivity extends AbsActivity {
    public TextView e;
    public String f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ErrorActivity.this.x1();
        }
    }

    public static void y1(String str, String str2) {
        Intent intent = new Intent(CommonAppContext.n(), (Class<?>) ErrorActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("title", str);
        intent.putExtra("error", str2);
        CommonAppContext.n().startActivity(intent);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return u73.e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("title");
        this.f = intent.getStringExtra("error");
        t1(stringExtra);
        TextView textView = (TextView) findViewById(y63.f0);
        this.e = textView;
        textView.setText(this.f);
        findViewById(y63.k).setOnClickListener(new a());
    }

    public final void x1() {
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        ((ClipboardManager) this.b.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.f));
        t54.a(m93.u1);
    }
}
