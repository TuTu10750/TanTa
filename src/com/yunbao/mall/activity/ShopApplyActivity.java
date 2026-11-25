package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.ManageClassBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.b5;
import defpackage.d73;
import defpackage.ec2;
import defpackage.g00;
import defpackage.j30;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.z73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ShopApplyActivity extends AbsActivity {
    public String A;
    public String B;
    public String C;
    public String D;
    public File E;
    public File F;
    public Dialog I;
    public TextView e;
    public TextView f;
    public TextView g;
    public EditText h;
    public EditText i;
    public TextView j;
    public EditText k;
    public View l;
    public EditText m;
    public View n;
    public EditText o;
    public EditText p;
    public TextView q;
    public EditText r;
    public View s;
    public ImageView t;
    public ImageView u;
    public ImageView v;
    public TextView w;
    public List x;
    public String y;
    public String z;
    public String G = "";
    public String H = "";
    public an1 J = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {
        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists() || ShopApplyActivity.this.v == null) {
                return;
            }
            ImageView imageView = ShopApplyActivity.this.v;
            ImageView imageView2 = ShopApplyActivity.this.t;
            ShopApplyActivity shopApplyActivity = ShopApplyActivity.this;
            if (imageView == imageView2) {
                shopApplyActivity.E = file;
            } else if (shopApplyActivity.v == ShopApplyActivity.this.u) {
                ShopApplyActivity.this.F = file;
            }
            kn1.e(ShopApplyActivity.this.b, file, ShopApplyActivity.this.v);
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (ShopApplyActivity.this.e != null) {
                ShopApplyActivity.this.e.setText(parseObject.getString("username"));
            }
            if (ShopApplyActivity.this.f != null) {
                ShopApplyActivity.this.f.setText(parseObject.getString("cardno"));
            }
            if (ShopApplyActivity.this.h != null) {
                ShopApplyActivity.this.h.setText(parseObject.getString("contact"));
            }
            if (ShopApplyActivity.this.i != null) {
                ShopApplyActivity.this.i.setText(parseObject.getString("phone"));
            }
            ShopApplyActivity.this.y = parseObject.getString("province");
            ShopApplyActivity.this.z = parseObject.getString("city");
            ShopApplyActivity.this.A = parseObject.getString("area");
            if (ShopApplyActivity.this.j != null) {
                ShopApplyActivity.this.j.setText(rv3.a(ShopApplyActivity.this.y, " ", ShopApplyActivity.this.z, " ", ShopApplyActivity.this.A));
            }
            if (ShopApplyActivity.this.k != null) {
                ShopApplyActivity.this.k.setText(parseObject.getString("address"));
            }
            if (ShopApplyActivity.this.m != null) {
                ShopApplyActivity.this.m.setText(parseObject.getString("service_phone"));
            }
            if (ShopApplyActivity.this.o != null) {
                ShopApplyActivity.this.o.setText(parseObject.getString("receiver"));
            }
            if (ShopApplyActivity.this.p != null) {
                ShopApplyActivity.this.p.setText(parseObject.getString("receiver_phone"));
            }
            ShopApplyActivity.this.B = parseObject.getString("receiver_province");
            ShopApplyActivity.this.C = parseObject.getString("receiver_city");
            ShopApplyActivity.this.D = parseObject.getString("receiver_area");
            if (ShopApplyActivity.this.q != null) {
                ShopApplyActivity.this.q.setText(rv3.a(ShopApplyActivity.this.B, " ", ShopApplyActivity.this.C, " ", ShopApplyActivity.this.D));
            }
            if (ShopApplyActivity.this.r != null) {
                ShopApplyActivity.this.r.setText(parseObject.getString("receiver_address"));
            }
            ShopApplyActivity.this.G = parseObject.getString("certificate");
            ShopApplyActivity.this.H = parseObject.getString("other");
            if (ShopApplyActivity.this.t != null) {
                kn1.f(ShopApplyActivity.this.b, parseObject.getString("certificate_format"), ShopApplyActivity.this.t);
            }
            if (ShopApplyActivity.this.u != null) {
                kn1.f(ShopApplyActivity.this.b, parseObject.getString("other_format"), ShopApplyActivity.this.u);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends s4 {
        public c() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                ShopApplyActivity.this.x = intent.getParcelableArrayListExtra("mallApplyManageClass");
                if (ShopApplyActivity.this.g != null) {
                    ShopApplyActivity.this.g.setText(m93.z5);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements a.n {
        public d() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                ShopApplyActivity shopApplyActivity = ShopApplyActivity.this;
                zj2.n(shopApplyActivity, false, shopApplyActivity.J);
            } else if (i == m93.K0) {
                ShopApplyActivity shopApplyActivity2 = ShopApplyActivity.this;
                zj2.k(shopApplyActivity2, false, shopApplyActivity2.J);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            if (parseObject.getIntValue("bond_status") != 0) {
                t54.a(m93.C5);
                return;
            }
            Intent intent = new Intent(ShopApplyActivity.this.b, (Class<?>) ShopApplyBondActivity.class);
            intent.putExtra("mallApplyBond", parseObject.getString("shop_bond"));
            ShopApplyActivity.this.startActivity(intent);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends k30 {
        public final /* synthetic */ Dialog a;

        public f(Dialog dialog) {
            this.a = dialog;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ArrayList arrayList) {
            this.a.dismiss();
            if (arrayList != null) {
                ShopApplyActivity.this.v2(arrayList);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements e {
        public g() {
        }

        public void a(Province province, City city, County county) {
            if (ShopApplyActivity.this.w != null) {
                String areaName = province.getAreaName();
                String areaName2 = city.getAreaName();
                String areaName3 = county.getAreaName();
                ShopApplyActivity.this.w.setText(rv3.a(areaName, " ", areaName2, " ", areaName3));
                TextView textView = ShopApplyActivity.this.w;
                TextView textView2 = ShopApplyActivity.this.j;
                ShopApplyActivity shopApplyActivity = ShopApplyActivity.this;
                if (textView == textView2) {
                    shopApplyActivity.y = areaName;
                    ShopApplyActivity.this.z = areaName2;
                    ShopApplyActivity.this.A = areaName3;
                } else if (shopApplyActivity.w == ShopApplyActivity.this.q) {
                    ShopApplyActivity.this.B = areaName;
                    ShopApplyActivity.this.C = areaName2;
                    ShopApplyActivity.this.D = areaName3;
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ String k;
        public final /* synthetic */ String l;
        public final /* synthetic */ String m;

        /* loaded from: /tmp/classes2.dex */
        public class a extends k30 {
            public final /* synthetic */ List a;

            /* renamed from: com.yunbao.mall.activity.ShopApplyActivity$h$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0058a implements pd4 {

                /* renamed from: com.yunbao.mall.activity.ShopApplyActivity$h$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0059a extends HttpCallback {
                    public C0059a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        ShopApplyActivity.this.t2();
                        if (i == 0) {
                            ShopApplyActivity.this.finish();
                        }
                        t54.b(str);
                    }
                }

                public C0058a() {
                }

                @Override // defpackage.pd4
                public void a(List list, boolean z) {
                    File file = ShopApplyActivity.this.E;
                    a aVar = a.this;
                    if (file != null) {
                        ShopApplyActivity.this.G = ((UploadBean) list.get(0)).getRemoteFileName();
                        if (list.size() > 1) {
                            ShopApplyActivity.this.H = ((UploadBean) list.get(1)).getRemoteFileName();
                        }
                    } else {
                        ShopApplyActivity.this.H = ((UploadBean) list.get(0)).getRemoteFileName();
                    }
                    h hVar = h.this;
                    String str = hVar.a;
                    String str2 = hVar.b;
                    String str3 = hVar.c;
                    String str4 = hVar.d;
                    String str5 = hVar.e;
                    String str6 = ShopApplyActivity.this.y;
                    String str7 = ShopApplyActivity.this.z;
                    String str8 = ShopApplyActivity.this.A;
                    h hVar2 = h.this;
                    ec2.c(str, str2, str3, str4, str5, str6, str7, str8, hVar2.f, hVar2.g, hVar2.h, hVar2.i, hVar2.j, hVar2.k, hVar2.l, hVar2.m, ShopApplyActivity.this.G, ShopApplyActivity.this.H, new C0059a());
                }
            }

            public a(List list) {
                this.a = list;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(qd4 qd4Var) {
                qd4Var.a(this.a, true, new C0058a());
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b extends HttpCallback {
            public b() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                ShopApplyActivity.this.t2();
                if (i == 0) {
                    ShopApplyActivity.this.finish();
                }
                t54.b(str);
            }
        }

        public h(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = str5;
            this.f = str6;
            this.g = str7;
            this.h = str8;
            this.i = str9;
            this.j = str10;
            this.k = str11;
            this.l = str12;
            this.m = str13;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            if (JSON.parseObject(strArr[0]).getIntValue("bond_status") == 0) {
                t54.a(m93.K5);
                return;
            }
            if (ShopApplyActivity.this.E == null && ShopApplyActivity.this.F == null) {
                ec2.c(this.a, this.b, this.c, this.d, this.e, ShopApplyActivity.this.y, ShopApplyActivity.this.z, ShopApplyActivity.this.A, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, ShopApplyActivity.this.G, ShopApplyActivity.this.H, new b());
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (ShopApplyActivity.this.E != null) {
                arrayList.add(new UploadBean(ShopApplyActivity.this.E, 0));
            }
            if (ShopApplyActivity.this.F != null) {
                arrayList.add(new UploadBean(ShopApplyActivity.this.F, 0));
            }
            ShopApplyActivity.this.w2();
            rd4.d(new a(arrayList));
        }
    }

    private void p2() {
        ArrayList e2 = g00.g().e();
        if (e2 != null && e2.size() != 0) {
            v2(e2);
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.b);
        c2.show();
        g00.g().f(new f(c2));
    }

    private void q2() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new d());
    }

    public static void s2(Context context, String str, String str2, boolean z) {
        Intent intent = new Intent(context, (Class<?>) ShopApplyActivity.class);
        intent.putExtra("uid", str);
        intent.putExtra("nickname", str2);
        intent.putExtra("mallApplyFailed", z);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t2() {
        Dialog dialog = this.I;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.I.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void v2(ArrayList arrayList) {
        com.yunbao.common.utils.a.g(this, arrayList, j30.q().z(), j30.q().f(), j30.q().k(), new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w2() {
        if (this.I == null) {
            this.I = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.I.isShowing()) {
            return;
        }
        this.I.show();
    }

    private void x2() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.D5);
            return;
        }
        String trim2 = this.f.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.E5);
            return;
        }
        List list = this.x;
        if (list == null || list.size() == 0) {
            t54.a(m93.y5);
            return;
        }
        String trim3 = this.h.getText().toString().trim();
        if (TextUtils.isEmpty(trim3)) {
            t54.a(m93.F5);
            return;
        }
        String trim4 = this.i.getText().toString().trim();
        if (TextUtils.isEmpty(trim4)) {
            t54.a(m93.G5);
            return;
        }
        if (TextUtils.isEmpty(this.j.getText().toString().trim())) {
            t54.a(m93.H5);
            return;
        }
        String trim5 = this.k.getText().toString().trim();
        if (TextUtils.isEmpty(trim5)) {
            t54.a(m93.I5);
            return;
        }
        if (this.E == null && TextUtils.isEmpty(this.G)) {
            t54.a(m93.J5);
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            sb.append(((ManageClassBean) it.next()).getId());
            sb.append(",");
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        String str = sb2;
        String trim6 = this.m.getText().toString().trim();
        String str2 = TextUtils.isEmpty(trim6) ? trim4 : trim6;
        String trim7 = this.o.getText().toString().trim();
        String str3 = TextUtils.isEmpty(trim7) ? trim3 : trim7;
        String trim8 = this.p.getText().toString().trim();
        String str4 = TextUtils.isEmpty(trim8) ? trim4 : trim8;
        String str5 = this.B;
        if (TextUtils.isEmpty(str5)) {
            str5 = this.y;
        }
        String str6 = str5;
        String str7 = this.C;
        if (TextUtils.isEmpty(str7)) {
            str7 = this.z;
        }
        String str8 = str7;
        String str9 = this.D;
        if (TextUtils.isEmpty(str9)) {
            str9 = this.A;
        }
        String str10 = str9;
        String trim9 = this.r.getText().toString().trim();
        ec2.z(new h(trim, trim2, str, trim3, trim4, trim5, str2, str3, str4, str6, str8, str10, TextUtils.isEmpty(trim9) ? trim5 : trim9));
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.U;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.w5));
        this.e = (TextView) findViewById(d73.R2);
        this.f = (TextView) findViewById(d73.x1);
        this.g = (TextView) findViewById(d73.M2);
        this.h = (EditText) findViewById(d73.N2);
        this.i = (EditText) findViewById(d73.O2);
        this.j = (TextView) findViewById(d73.L2);
        this.k = (EditText) findViewById(d73.K2);
        this.l = findViewById(d73.F2);
        this.m = (EditText) findViewById(d73.H2);
        this.n = findViewById(d73.G3);
        this.o = (EditText) findViewById(d73.I3);
        this.p = (EditText) findViewById(d73.J3);
        this.q = (TextView) findViewById(d73.F3);
        this.r = (EditText) findViewById(d73.E3);
        this.s = findViewById(d73.G2);
        this.t = (ImageView) findViewById(d73.A2);
        this.u = (ImageView) findViewById(d73.B2);
        ((TextView) findViewById(d73.w2)).setText(j30.q().C());
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("uid");
        this.e.setText(intent.getStringExtra("nickname"));
        this.f.setText(stringExtra);
        if (intent.getBooleanExtra("mallApplyFailed", false)) {
            ec2.i0(new b());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBondStatus");
        ec2.u("applyShop");
        ec2.u("getShopApplyInfo");
        rd4.c();
        t2();
        this.I = null;
        super.onDestroy();
    }

    public final void r2() {
        Intent intent = new Intent(this.b, (Class<?>) ManageClassActivity.class);
        List list = this.x;
        if (list != null && list.size() > 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator it = this.x.iterator();
            while (it.hasNext()) {
                arrayList.add(((ManageClassBean) it.next()).getId());
            }
            intent.putStringArrayListExtra("mallApplyManageClass", arrayList);
        }
        b5.a(this, intent, new c());
    }

    public void shopApplyClick(View view) {
        int id = view.getId();
        if (id == d73.C0) {
            r2();
            return;
        }
        if (id == d73.B0) {
            this.w = this.j;
            p2();
            return;
        }
        if (id == d73.z0) {
            y2(this.m, this.l);
            return;
        }
        if (id == d73.Z0) {
            y2(this.n, this.s);
            return;
        }
        if (id == d73.X0) {
            this.w = this.q;
            p2();
            return;
        }
        if (id == d73.v0) {
            this.v = this.t;
            q2();
        } else if (id == d73.w0) {
            this.v = this.u;
            q2();
        } else if (id == d73.G) {
            u2();
        } else if (id == d73.n1) {
            x2();
        }
    }

    public final void u2() {
        ec2.z(new e());
    }

    public final void y2(View view, View view2) {
        if (view.getVisibility() == 0) {
            view.setVisibility(8);
            view2.setRotation(90.0f);
        } else {
            view.setVisibility(0);
            view2.setRotation(270.0f);
        }
    }
}
