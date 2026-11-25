package com.yunbao.main.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.yunbao.common.activity.AbsActivity;
import defpackage.bs3;
import defpackage.c73;
import defpackage.y73;

/* loaded from: /tmp/classes2.dex */
public class ABActivity extends AbsActivity {

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ABActivity.this.finish();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements RadioGroup.OnCheckedChangeListener {
        public final /* synthetic */ RadioButton a;

        public b(RadioButton radioButton) {
            this.a = radioButton;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (((RadioButton) ABActivity.this.findViewById(i)) == this.a) {
                bs3.d().p("pid", "680");
                bs3.d().p("key", "fccb3cdc9acc14a6e70a12f74560c026");
            } else {
                bs3.d().p("pid", "679");
                bs3.d().p("key", "cabd2456e09f226a7a65778ce9a6e3fb");
            }
            ABActivity.this.x1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.a;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1("选择服务器地址（默认测试地址）");
        ((ImageView) findViewById(c73.K)).setOnClickListener(new a());
        RadioGroup radioGroup = (RadioGroup) findViewById(c73.t4);
        RadioButton radioButton = (RadioButton) findViewById(c73.d4);
        RadioButton radioButton2 = (RadioButton) findViewById(c73.e4);
        String g = bs3.d().g("pid");
        if (g.equals("679")) {
            radioButton2.setChecked(true);
        } else if (g.equals("680")) {
            radioButton.setChecked(true);
        }
        radioGroup.setOnCheckedChangeListener(new b(radioButton));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x1() {
        MainActivity.y0.finish();
        Intent intent = new Intent();
        intent.setClassName(getApplication().getPackageName(), "com.yunbao.phonelive.activity.LauncherActivity");
        intent.addFlags(268435456);
        startActivity(intent);
    }
}
