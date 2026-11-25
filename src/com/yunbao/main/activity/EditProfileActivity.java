package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.qqtheme.framework.entity.City;
import cn.qqtheme.framework.entity.County;
import cn.qqtheme.framework.entity.Province;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.analytics.pro.cl;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import defpackage.an1;
import defpackage.aq4;
import defpackage.b5;
import defpackage.c73;
import defpackage.db2;
import defpackage.g00;
import defpackage.hd4;
import defpackage.hh1;
import defpackage.j30;
import defpackage.k30;
import defpackage.kd4;
import defpackage.kn1;
import defpackage.lx1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.ph1;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
import defpackage.s4;
import defpackage.t54;
import defpackage.y73;
import defpackage.zj2;
import defpackage.zu0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class EditProfileActivity extends AbsActivity {
    public ImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public UserBean k;
    public String l;
    public String m;
    public String n;
    public RelativeLayout o;
    public TextView p;
    public RelativeLayout q;
    public TextView r;
    public an1 s = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {

        /* renamed from: com.yunbao.main.activity.EditProfileActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0043a extends k30 {
            public final /* synthetic */ File a;

            /* renamed from: com.yunbao.main.activity.EditProfileActivity$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0044a implements pd4 {

                /* renamed from: com.yunbao.main.activity.EditProfileActivity$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0045a extends HttpCallback {

                    /* renamed from: com.yunbao.main.activity.EditProfileActivity$a$a$a$a$a, reason: collision with other inner class name */
                    /* loaded from: /tmp/classes2.dex */
                    public class C0046a implements hh1 {
                        public C0046a() {
                        }

                        @Override // defpackage.hh1
                        public void onError(int i, String str) {
                            lx1.d("9527", "setting IM--Avatar and Name failed");
                        }

                        @Override // defpackage.hh1
                        public void onSuccess() {
                            lx1.d("9527", "setting IM--Avatar and Name success");
                        }
                    }

                    public C0045a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        if (i != 0 || strArr.length <= 0) {
                            t54.b(str);
                            return;
                        }
                        t54.a(m93.G1);
                        UserBean D = j30.q().D();
                        if (D != null) {
                            JSONObject parseObject = JSON.parseObject(strArr[0]);
                            D.setAvatar(parseObject.getString("avatar"));
                            ph1.a(D.getAvatar(), D.getUserNiceName(), new C0046a());
                            D.setAvatarThumb(parseObject.getString("avatarThumb"));
                            zu0.c().j(new kd4(parseObject.getString("avatar"), 2));
                        }
                    }
                }

                public C0044a() {
                }

                @Override // defpackage.pd4
                public void a(List list, boolean z) {
                    if (z) {
                        db2.x0(((UploadBean) list.get(0)).getRemoteFileName(), new C0045a());
                    }
                }
            }

            public C0043a(File file) {
                this.a = file;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(qd4 qd4Var) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new UploadBean(this.a, 0));
                qd4Var.a(arrayList, true, new C0044a());
            }
        }

        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file != null) {
                kn1.e(EditProfileActivity.this.b, file, EditProfileActivity.this.e);
                rd4.e("avatar/", new C0043a(file));
            }
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends k30 {
        public b() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(UserBean userBean) {
            EditProfileActivity.this.k = userBean;
            EditProfileActivity.this.V1(userBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.n {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            int i2 = m93.R0;
            EditProfileActivity editProfileActivity = EditProfileActivity.this;
            if (i == i2) {
                zj2.l(editProfileActivity, editProfileActivity.s);
            } else {
                zj2.i(editProfileActivity, editProfileActivity.s);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends s4 {
        public d() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("nickname");
                EditProfileActivity.this.k.setUserNiceName(stringExtra);
                EditProfileActivity.this.f.setText(stringExtra);
                zu0.c().j(new hd4());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends s4 {
        public e() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("sign");
                EditProfileActivity.this.k.setSignature(stringExtra);
                EditProfileActivity.this.g.setText(stringExtra);
                zu0.c().j(new hd4());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements a.k {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                } else if (strArr.length > 0) {
                    t54.b(JSON.parseObject(strArr[0]).getString(cl.h));
                    EditProfileActivity.this.k.setBirthday(this.a);
                    EditProfileActivity.this.h.setText(this.a);
                    zu0.c().j(new hd4());
                }
            }
        }

        public f() {
        }

        @Override // com.yunbao.common.utils.a.k
        public void a(String str) {
            db2.y0("{\"birthday\":\"" + str + "\"}", new a(str));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends s4 {
        public g() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                int intExtra = intent.getIntExtra("sex", 0);
                if (intExtra == 1) {
                    EditProfileActivity.this.i.setText(m93.ea);
                    EditProfileActivity.this.k.setSex(intExtra);
                } else if (intExtra == 2) {
                    EditProfileActivity.this.i.setText(m93.da);
                    EditProfileActivity.this.k.setSex(intExtra);
                }
                zu0.c().j(new hd4());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends k30 {
        public final /* synthetic */ Dialog a;

        public h(Dialog dialog) {
            this.a = dialog;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ArrayList arrayList) {
            this.a.dismiss();
            if (arrayList != null) {
                EditProfileActivity.this.U1(arrayList);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements e {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0) {
                    JSONObject parseObject = JSON.parseObject(strArr[0]);
                    if (strArr.length > 0) {
                        UserBean D = j30.q().D();
                        if (D != null) {
                            D.setLocation(this.a);
                        }
                        zu0.c().j(new hd4());
                    }
                    t54.b(parseObject.getString(cl.h));
                }
            }
        }

        public i() {
        }

        public void a(Province province, City city, County county) {
            String areaName = province.getAreaName();
            String areaName2 = city.getAreaName();
            String areaName3 = county.getAreaName();
            EditProfileActivity.this.l = areaName;
            EditProfileActivity.this.m = areaName2;
            EditProfileActivity.this.n = areaName3;
            String a2 = rv3.a(EditProfileActivity.this.l, EditProfileActivity.this.m, EditProfileActivity.this.n);
            if (EditProfileActivity.this.j != null) {
                EditProfileActivity.this.j.setText(a2);
            }
            db2.y0("{\"location\":\"" + a2 + "\"}", new a(a2));
        }
    }

    public final void O1() {
        ArrayList e2 = g00.g().e();
        if (e2 != null && e2.size() != 0) {
            U1(e2);
            return;
        }
        Dialog c2 = com.yunbao.common.utils.a.c(this.b);
        c2.show();
        g00.g().f(new h(c2));
    }

    public final void P1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new c());
    }

    public final void Q1() {
        if (this.k == null) {
            return;
        }
        com.yunbao.common.utils.a.h(this.b, new f());
    }

    public final void R1() {
        if (this.k == null) {
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) EditNameActivity.class);
        intent.putExtra("nickname", this.k.getUserNiceName());
        b5.a(this, intent, new d());
    }

    public final void S1() {
        if (this.k == null) {
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) EditSexActivity.class);
        intent.putExtra("sex", this.k.getSex());
        b5.a(this, intent, new g());
    }

    public final void T1() {
        if (this.k == null) {
            return;
        }
        Intent intent = new Intent(this.b, (Class<?>) EditSignActivity.class);
        intent.putExtra("sign", this.k.getSignature());
        b5.a(this, intent, new e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U1(ArrayList arrayList) {
        String str = this.l;
        String str2 = this.m;
        String str3 = this.n;
        if (TextUtils.isEmpty(str)) {
            str = j30.q().z();
        }
        String str4 = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = j30.q().f();
        }
        String str5 = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = j30.q().k();
        }
        com.yunbao.common.utils.a.g(this, arrayList, str4, str5, str3, new i());
    }

    public final void V1(UserBean userBean) {
        kn1.g(this.b, userBean.getAvatar(), this.e);
        this.f.setText(userBean.getUserNiceName());
        this.g.setText(userBean.getSignature());
        this.h.setText(userBean.getBirthday());
        this.i.setText(userBean.getSex() == 1 ? m93.ea : m93.da);
        this.j.setText(userBean.getLocation());
        if (userBean.getUserLogin() == null || userBean.getUserLogin().isEmpty()) {
            this.o.setVisibility(8);
            this.q.setVisibility(8);
        } else {
            this.o.setVisibility(0);
            this.p.setText(userBean.getUserLogin());
            this.q.setVisibility(0);
        }
        int isPass = this.k.getIsPass();
        TextView textView = this.r;
        if (isPass == 1) {
            textView.setText("修改密码");
        } else {
            textView.setText("设置密码");
        }
    }

    public void editProfileClick(View view) {
        if (c1()) {
            int id = view.getId();
            if (id == c73.J) {
                P1();
                return;
            }
            if (id == c73.M0) {
                R1();
                return;
            }
            if (id == c73.h1) {
                T1();
                return;
            }
            if (id == c73.L) {
                Q1();
                return;
            }
            if (id == c73.e1) {
                S1();
                return;
            }
            if (id == c73.X) {
                O1();
                return;
            }
            if (id == c73.U0) {
                int isPass = this.k.getIsPass();
                Context context = this.b;
                if (isPass == 1) {
                    context.startActivity(new Intent(this.b, (Class<?>) UpdatePwdActivity.class));
                } else {
                    context.startActivity(new Intent(this.b, (Class<?>) SetPwdActivity.class));
                }
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.q;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.A1));
        this.o = (RelativeLayout) findViewById(c73.Q0);
        this.p = (TextView) findViewById(c73.Y3);
        this.q = (RelativeLayout) findViewById(c73.U0);
        this.e = (ImageView) findViewById(c73.l);
        this.f = (TextView) findViewById(c73.L3);
        this.g = (TextView) findViewById(c73.z4);
        this.r = (TextView) findViewById(c73.Y1);
        this.h = (TextView) findViewById(c73.A);
        this.i = (TextView) findViewById(c73.x4);
        this.j = (TextView) findViewById(c73.B1);
        UserBean D = j30.q().D();
        this.k = D;
        if (D != null) {
            V1(D);
        } else {
            db2.E(new b());
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        rd4.c();
        db2.i("updateAvatar");
        db2.i("updateFields");
        super.onDestroy();
    }
}
