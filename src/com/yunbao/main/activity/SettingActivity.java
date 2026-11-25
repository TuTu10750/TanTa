package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.VersionBean;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.main.activity.SettingActivity;
import com.yunbao.main.bean.SettingBean;
import defpackage.aq4;
import defpackage.bs3;
import defpackage.c73;
import defpackage.ck1;
import defpackage.db2;
import defpackage.ig4;
import defpackage.io3;
import defpackage.j30;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.rv3;
import defpackage.rx1;
import defpackage.t54;
import defpackage.y73;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SettingActivity extends AbsActivity implements io3.d {
    public RecyclerView e;
    public Handler f;
    public io3 g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            List<SettingBean> parseArray = JSON.parseArray(Arrays.toString(strArr), SettingBean.class);
            if (!ig4.c(j30.q().h().getVersion())) {
                for (SettingBean settingBean : parseArray) {
                    if (settingBean.getName().equals("检查更新")) {
                        settingBean.setChecked(true);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            SettingBean settingBean2 = new SettingBean();
            settingBean2.setId(-1);
            settingBean2.setName(aq4.a(m93.Y9));
            settingBean2.setChecked(bs3.d().c() == 0.05f);
            arrayList.add(settingBean2);
            SettingBean settingBean3 = new SettingBean();
            settingBean3.setId(-3);
            settingBean3.setName(aq4.a(m93.ca));
            settingBean3.setChecked(j30.q().P());
            arrayList.add(settingBean3);
            SettingBean settingBean4 = new SettingBean();
            settingBean4.setId(-2);
            settingBean4.setName(aq4.a(m93.ba));
            settingBean4.setChecked(bs3.d().i());
            arrayList.add(settingBean4);
            arrayList.addAll(parseArray);
            SettingActivity settingActivity = SettingActivity.this;
            settingActivity.g = new io3(settingActivity.b, arrayList, ig4.b(), SettingActivity.this.K1());
            SettingActivity.this.g.W(SettingActivity.this);
            SettingActivity.this.e.setAdapter(SettingActivity.this.g);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.n {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            SettingActivity.this.G1("English".equals(str) ? "en" : "zh-cn");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public c() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ConfigBean configBean) {
            Intent intent = new Intent(SettingActivity.this.b, (Class<?>) MainActivity.class);
            intent.addFlags(67141632);
            SettingActivity.this.b.startActivity(intent);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {
        public d() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(VersionBean versionBean) {
            if (versionBean != null) {
                if (ig4.c(versionBean.getApkVersion())) {
                    t54.a(m93.ja);
                } else {
                    ig4.d(SettingActivity.this.b, versionBean, 1, versionBean.getApkUrl());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Runnable {
        public final /* synthetic */ Dialog a;
        public final /* synthetic */ int b;

        public e(Dialog dialog, int i) {
            this.a = dialog;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dialog dialog = this.a;
            if (dialog != null) {
                dialog.dismiss();
            }
            if (SettingActivity.this.g != null) {
                SettingActivity.this.g.X(SettingActivity.this.K1());
                SettingActivity.this.g.q(this.b);
            }
            t54.a(m93.Z9);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void w1(SettingActivity settingActivity, View view) {
        settingActivity.b.startActivity(new Intent(settingActivity.b, (Class<?>) LoginNewActivity.class));
        settingActivity.finish();
    }

    public final void G1(String str) {
        if (TextUtils.isEmpty(str) || rx1.c().d().equals(str)) {
            return;
        }
        rx1.c().k(str);
        ck1.e().a();
        CommonHttpUtil.getConfig(new c());
    }

    public final void H1() {
        j30.q().E(new d());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I1(int i) {
        Dialog d2 = com.yunbao.common.utils.a.d(this.b, getString(m93.aa));
        d2.show();
        kn1.b();
        File file = new File(j30.P);
        if (file.exists() && file.length() > 0) {
            file.delete();
        }
        File externalFilesDir = CommonAppContext.n().getExternalFilesDir(null);
        if (externalFilesDir.exists() && externalFilesDir.length() > 0) {
            externalFilesDir.delete();
        }
        if (this.f == null) {
            this.f = new Handler();
        }
        this.f.postDelayed(new e(d2, i), 2000L);
    }

    @Override // io3.d
    public void J() {
        com.yunbao.common.utils.a.s(this.b, new String[]{"简体中文", "English"}, new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void J1() {
        startActivity(new Intent(this.b, (Class<?>) ModifyPwdActivity.class));
    }

    public final String K1() {
        return kn1.p();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.R;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io3.d
    public void i(SettingBean settingBean, int i) {
        String href = settingBean.getHref();
        if (!TextUtils.isEmpty(href)) {
            if (settingBean.getId() == 19) {
                CancelConditionActivity.z1(this.b, href);
                return;
            }
            if (settingBean.getId() == 17) {
                if (!href.contains("?")) {
                    href = rv3.a(href, "?");
                }
                href = rv3.a(href, "&token=", j30.q().B(), "&uid=", j30.q().C(), "&version=", Build.VERSION.RELEASE, "&model=", Build.MODEL);
            }
            WebViewActivity.E1(this.b, href);
            return;
        }
        if (settingBean.getId() == -5) {
            this.b.startActivity(new Intent(this.b, (Class<?>) LoginNewActivity.class));
            finish();
            return;
        }
        if (settingBean.getId() == 15) {
            J1();
            return;
        }
        if (settingBean.getId() == 16) {
            H1();
        } else if (settingBean.getId() == 18) {
            I1(i);
        } else if (settingBean.getId() == -301) {
            startActivity(new Intent((Context) this, (Class<?>) ABActivity.class));
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.X9));
        findViewById(c73.D3).setOnClickListener(new View.OnClickListener() { // from class: ho3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingActivity.w1(SettingActivity.this, view);
            }
        });
        RecyclerView findViewById = findViewById(c73.h4);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        db2.Z(new a());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f = null;
        }
        db2.i("getSettingList");
        CommonHttpUtil.cancel(CommonHttpConsts.GET_CONFIG);
        db2.i("setLiveWindow");
        super.onDestroy();
    }

    @Override // io3.d
    public void q(SettingBean settingBean) {
        int id = settingBean.getId();
        if (id == -1) {
            bs3.d().l(settingBean.isChecked() ? 0.05f : -1.0f);
            v1();
        } else if (id == -2) {
            bs3.d().m(settingBean.isChecked());
        }
    }
}
