package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import defpackage.an1;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.t54;
import defpackage.z73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsAddOutSideActivity extends AbsActivity implements View.OnClickListener {
    public EditText e;
    public EditText f;
    public EditText g;
    public EditText h;
    public EditText i;
    public ImageView j;
    public File k;
    public View l;
    public Dialog m;
    public String n;
    public String o;
    public an1 p = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {
        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                return;
            }
            GoodsAddOutSideActivity.this.k = file;
            GoodsAddOutSideActivity.this.o = null;
            if (GoodsAddOutSideActivity.this.j != null) {
                kn1.e(GoodsAddOutSideActivity.this.b, file, GoodsAddOutSideActivity.this.j);
            }
            GoodsAddOutSideActivity.this.O1();
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
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
            GoodsAddOutSideActivity.this.O1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("goods_info");
            if (GoodsAddOutSideActivity.this.e != null) {
                GoodsAddOutSideActivity.this.e.setText(jSONObject.getString("href"));
            }
            if (GoodsAddOutSideActivity.this.f != null) {
                GoodsAddOutSideActivity.this.f.setText(jSONObject.getString("name"));
            }
            if (GoodsAddOutSideActivity.this.i != null) {
                GoodsAddOutSideActivity.this.i.setText(jSONObject.getString("goods_desc"));
            }
            if (GoodsAddOutSideActivity.this.g != null) {
                GoodsAddOutSideActivity.this.g.setText(jSONObject.getString("original_price"));
            }
            if (GoodsAddOutSideActivity.this.h != null) {
                GoodsAddOutSideActivity.this.h.setText(jSONObject.getString("present_price"));
            }
            GoodsAddOutSideActivity.this.o = jSONObject.getString("thumbs");
            JSONArray jSONArray = jSONObject.getJSONArray("thumbs_format");
            if (jSONArray == null || jSONArray.size() <= 0) {
                return;
            }
            String string = jSONArray.getString(0);
            if (GoodsAddOutSideActivity.this.j != null) {
                kn1.f(GoodsAddOutSideActivity.this.b, string, GoodsAddOutSideActivity.this.j);
            }
            GoodsAddOutSideActivity.this.O1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements a.n {
        public d() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                GoodsAddOutSideActivity goodsAddOutSideActivity = GoodsAddOutSideActivity.this;
                zj2.n(goodsAddOutSideActivity, false, goodsAddOutSideActivity.p);
            } else if (i == m93.K0) {
                GoodsAddOutSideActivity goodsAddOutSideActivity2 = GoodsAddOutSideActivity.this;
                zj2.k(goodsAddOutSideActivity2, false, goodsAddOutSideActivity2.p);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends k30 {
        public final /* synthetic */ List a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: com.yunbao.mall.activity.GoodsAddOutSideActivity$e$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0054a extends HttpCallback {
                public C0054a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onFinish() {
                    GoodsAddOutSideActivity.this.N1();
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        GoodsAddOutSideActivity.this.finish();
                    }
                    t54.b(str);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z) {
                    GoodsAddOutSideActivity.this.N1();
                    return;
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                String remoteFileName = ((UploadBean) list.get(0)).getRemoteFileName();
                String str = GoodsAddOutSideActivity.this.n;
                e eVar = e.this;
                ec2.C0(str, eVar.b, eVar.c, eVar.d, eVar.e, eVar.f, remoteFileName, new C0054a());
            }
        }

        public e(List list, String str, String str2, String str3, String str4, String str5) {
            this.a = list;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            GoodsAddOutSideActivity.this.N1();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                GoodsAddOutSideActivity.this.finish();
            }
            t54.b(str);
        }
    }

    public static void L1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) GoodsAddOutSideActivity.class);
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        Dialog dialog = this.m;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.m.dismiss();
    }

    private void P1() {
        if (this.m == null) {
            this.m = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.m.isShowing()) {
            return;
        }
        this.m.show();
    }

    private void Q1() {
        String trim = this.e.getText().toString().trim();
        String trim2 = this.f.getText().toString().trim();
        String trim3 = this.g.getText().toString().trim();
        String trim4 = this.h.getText().toString().trim();
        String trim5 = this.i.getText().toString().trim();
        File file = this.k;
        if (file != null && file.exists()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new UploadBean(this.k, 0));
            P1();
            rd4.d(new e(arrayList, trim, trim2, trim3, trim4, trim5));
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(this.o);
        String str = this.n;
        if (!isEmpty) {
            ec2.C0(str, trim, trim2, trim3, trim4, trim5, this.o, new f());
        } else if (TextUtils.isEmpty(str)) {
            t54.a(m93.a6);
        }
    }

    public final void K1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new d());
    }

    public final void M1() {
        ec2.N(this.n, new c());
    }

    public final void O1() {
        if (this.l != null) {
            this.l.setEnabled((TextUtils.isEmpty(this.e.getText().toString().trim()) || TextUtils.isEmpty(this.f.getText().toString().trim()) || TextUtils.isEmpty(this.h.getText().toString().trim()) || TextUtils.isEmpty(this.g.getText().toString().trim()) || TextUtils.isEmpty(this.i.getText().toString().trim()) || (this.k == null && TextUtils.isEmpty(this.o))) ? false : true);
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.i8));
        this.e = (EditText) findViewById(d73.J2);
        this.f = (EditText) findViewById(d73.R2);
        this.g = (EditText) findViewById(d73.m3);
        this.h = (EditText) findViewById(d73.l3);
        this.i = (EditText) findViewById(d73.O1);
        this.j = (ImageView) findViewById(d73.x2);
        View findViewById = findViewById(d73.b0);
        this.l = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(d73.u0).setOnClickListener(this);
        b bVar = new b();
        this.e.addTextChangedListener(bVar);
        this.f.addTextChangedListener(bVar);
        this.g.addTextChangedListener(bVar);
        this.h.addTextChangedListener(bVar);
        this.i.addTextChangedListener(bVar);
        String stringExtra = getIntent().getStringExtra("mallGoodsId");
        this.n = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        M1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.u0) {
            K1();
        } else if (id == d73.b0) {
            Q1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u(CommonHttpConsts.GET_GOODS_INFO);
        ec2.u("setOutsideGoods");
        N1();
        super.onDestroy();
    }
}
