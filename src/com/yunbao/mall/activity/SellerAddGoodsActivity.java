package com.yunbao.mall.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.ChooseVideoActivity;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.AddGoodsImageBean;
import com.yunbao.mall.bean.AddGoodsSpecBean;
import com.yunbao.mall.bean.GoodsClassBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.b5;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.k30;
import defpackage.m93;
import defpackage.o5;
import defpackage.p5;
import defpackage.pd4;
import defpackage.q5;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.s4;
import defpackage.t54;
import defpackage.v31;
import defpackage.vx2;
import defpackage.yx2;
import defpackage.z73;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class SellerAddGoodsActivity extends AbsActivity {
    public String A;
    public String B;
    public an1 C = new c();
    public String e;
    public TextView f;
    public TextView g;
    public RecyclerView h;
    public q5 i;
    public TextView j;
    public RecyclerView k;
    public o5 l;
    public RecyclerView m;
    public p5 n;
    public TextView o;
    public int p;
    public int q;
    public int r;
    public int s;
    public CheckBox t;
    public View u;
    public EditText v;
    public GoodsClassBean w;
    public Dialog x;
    public String y;
    public String z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public final /* synthetic */ List a;

        /* renamed from: com.yunbao.mall.activity.SellerAddGoodsActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0057a implements pd4 {
            public C0057a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z) {
                    SellerAddGoodsActivity.this.c2();
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    UploadBean uploadBean = (UploadBean) it.next();
                    Object tag = uploadBean.getTag();
                    if (tag != null) {
                        if (tag == SellerAddGoodsActivity.this.i) {
                            if (uploadBean.getType() == 1) {
                                SellerAddGoodsActivity.this.i.C0(uploadBean.getRemoteFileName());
                            } else if (uploadBean.getType() == 0) {
                                SellerAddGoodsActivity.this.i.A0(uploadBean.getRemoteFileName());
                            }
                        } else if (tag instanceof AddGoodsImageBean) {
                            ((AddGoodsImageBean) tag).setUploadResultUrl(uploadBean.getRemoteFileName());
                        } else if (tag instanceof AddGoodsSpecBean) {
                            ((AddGoodsSpecBean) tag).setUploadResultUrl(uploadBean.getRemoteFileName());
                        }
                    }
                }
                SellerAddGoodsActivity.this.d2();
            }
        }

        public a(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new C0057a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            SellerAddGoodsActivity.this.c2();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                SellerAddGoodsActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements an1 {
        public c() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                t54.a(m93.K1);
                return;
            }
            int i = SellerAddGoodsActivity.this.s;
            SellerAddGoodsActivity sellerAddGoodsActivity = SellerAddGoodsActivity.this;
            if (i == 0) {
                if (sellerAddGoodsActivity.i != null) {
                    SellerAddGoodsActivity.this.i.z0(SellerAddGoodsActivity.this.p, file);
                    return;
                }
                return;
            }
            int i2 = sellerAddGoodsActivity.s;
            SellerAddGoodsActivity sellerAddGoodsActivity2 = SellerAddGoodsActivity.this;
            if (i2 == 1) {
                if (sellerAddGoodsActivity2.l != null) {
                    SellerAddGoodsActivity.this.l.o0(SellerAddGoodsActivity.this.q, file);
                }
            } else {
                if (sellerAddGoodsActivity2.s != 2 || SellerAddGoodsActivity.this.n == null) {
                    return;
                }
                SellerAddGoodsActivity.this.n.h0(SellerAddGoodsActivity.this.r, file);
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
    public class d implements et2 {
        public d() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(AddGoodsImageBean addGoodsImageBean, int i) {
            SellerAddGoodsActivity.this.p = i;
            SellerAddGoodsActivity.this.s = 0;
            SellerAddGoodsActivity sellerAddGoodsActivity = SellerAddGoodsActivity.this;
            if (i == 0) {
                sellerAddGoodsActivity.Z1();
            } else {
                sellerAddGoodsActivity.Y1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements et2 {
        public e() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(AddGoodsImageBean addGoodsImageBean, int i) {
            SellerAddGoodsActivity.this.q = i;
            SellerAddGoodsActivity.this.s = 1;
            SellerAddGoodsActivity.this.Y1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements et2 {
        public f() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(AddGoodsSpecBean addGoodsSpecBean, int i) {
            SellerAddGoodsActivity.this.r = i;
            SellerAddGoodsActivity.this.s = 2;
            SellerAddGoodsActivity.this.Y1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SellerAddGoodsActivity.this.u != null) {
                SellerAddGoodsActivity sellerAddGoodsActivity = SellerAddGoodsActivity.this;
                if (z) {
                    if (sellerAddGoodsActivity.u.getVisibility() != 8) {
                        SellerAddGoodsActivity.this.u.setVisibility(8);
                    }
                } else if (sellerAddGoodsActivity.u.getVisibility() != 0) {
                    SellerAddGoodsActivity.this.u.setVisibility(0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public h() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("goods_info");
            SellerAddGoodsActivity.this.w = new GoodsClassBean();
            SellerAddGoodsActivity.this.w.setOneClassId(jSONObject.getString("one_classid"));
            SellerAddGoodsActivity.this.w.setTwoClassId(jSONObject.getString("two_classid"));
            SellerAddGoodsActivity.this.w.setId(jSONObject.getString("three_classid"));
            if (SellerAddGoodsActivity.this.f != null) {
                SellerAddGoodsActivity.this.f.setText(jSONObject.getString("three_class_name"));
            }
            if (SellerAddGoodsActivity.this.g != null) {
                SellerAddGoodsActivity.this.g.setText(jSONObject.getString("name"));
            }
            if (SellerAddGoodsActivity.this.j != null) {
                SellerAddGoodsActivity.this.j.setText(jSONObject.getString("content"));
            }
            double doubleValue = jSONObject.getDoubleValue("postage");
            SellerAddGoodsActivity sellerAddGoodsActivity = SellerAddGoodsActivity.this;
            if (doubleValue > 0.0d) {
                if (sellerAddGoodsActivity.t != null) {
                    SellerAddGoodsActivity.this.t.setChecked(false);
                }
                if (SellerAddGoodsActivity.this.u != null && SellerAddGoodsActivity.this.u.getVisibility() != 0) {
                    SellerAddGoodsActivity.this.u.setVisibility(0);
                }
                if (SellerAddGoodsActivity.this.o != null) {
                    SellerAddGoodsActivity.this.o.setText(String.valueOf(doubleValue));
                }
            } else {
                if (sellerAddGoodsActivity.u != null && SellerAddGoodsActivity.this.u.getVisibility() != 8) {
                    SellerAddGoodsActivity.this.u.setVisibility(8);
                }
                if (SellerAddGoodsActivity.this.t != null) {
                    SellerAddGoodsActivity.this.t.setChecked(true);
                }
            }
            if (SellerAddGoodsActivity.this.v != null) {
                SellerAddGoodsActivity.this.v.setText(jSONObject.getString("share_income"));
            }
            if (SellerAddGoodsActivity.this.i != null) {
                SellerAddGoodsActivity.this.i.C0(jSONObject.getString("video_url"));
                SellerAddGoodsActivity.this.i.A0(jSONObject.getString("video_thumb"));
                SellerAddGoodsActivity.this.i.D0(jSONObject.getString("video_url_format"));
                SellerAddGoodsActivity.this.i.B0(jSONObject.getString("video_thumb_format"));
                ArrayList arrayList = new ArrayList();
                AddGoodsImageBean addGoodsImageBean = new AddGoodsImageBean();
                addGoodsImageBean.setImgUrl(jSONObject.getString("video_thumb_format"));
                arrayList.add(addGoodsImageBean);
                JSONArray jSONArray = jSONObject.getJSONArray("thumbs_format");
                int size = jSONArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String string = jSONArray.getString(i2);
                    if (!TextUtils.isEmpty(string)) {
                        AddGoodsImageBean addGoodsImageBean2 = new AddGoodsImageBean();
                        addGoodsImageBean2.setImgUrl(string);
                        arrayList.add(addGoodsImageBean2);
                    }
                }
                if (arrayList.size() < 10) {
                    arrayList.add(new AddGoodsImageBean());
                }
                SellerAddGoodsActivity.this.i.P(arrayList);
            }
            if (SellerAddGoodsActivity.this.l != null) {
                ArrayList arrayList2 = new ArrayList();
                JSONArray jSONArray2 = jSONObject.getJSONArray("pictures_format");
                int size2 = jSONArray2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String string2 = jSONArray2.getString(i3);
                    if (!TextUtils.isEmpty(string2)) {
                        AddGoodsImageBean addGoodsImageBean3 = new AddGoodsImageBean();
                        addGoodsImageBean3.setImgUrl(string2);
                        arrayList2.add(addGoodsImageBean3);
                    }
                }
                if (arrayList2.size() < 20) {
                    arrayList2.add(new AddGoodsImageBean());
                }
                SellerAddGoodsActivity.this.l.P(arrayList2);
            }
            if (SellerAddGoodsActivity.this.n != null) {
                SellerAddGoodsActivity.this.n.P(JSON.parseArray(jSONObject.getString("specs_format"), AddGoodsSpecBean.class));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends s4 {
        public i() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                SellerAddGoodsActivity.this.w = (GoodsClassBean) intent.getParcelableExtra("mallGoodsClass");
                if (SellerAddGoodsActivity.this.f != null) {
                    SellerAddGoodsActivity.this.f.setText(SellerAddGoodsActivity.this.w.getName());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements a.n {
        public j() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                SellerAddGoodsActivity sellerAddGoodsActivity = SellerAddGoodsActivity.this;
                zj2.n(sellerAddGoodsActivity, false, sellerAddGoodsActivity.C);
            } else if (i == m93.K0) {
                SellerAddGoodsActivity sellerAddGoodsActivity2 = SellerAddGoodsActivity.this;
                zj2.k(sellerAddGoodsActivity2, false, sellerAddGoodsActivity2.C);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends vx2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public a() {
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                String stringExtra = intent.getStringExtra("videoPath");
                if (TextUtils.isEmpty(stringExtra) || SellerAddGoodsActivity.this.i == null) {
                    return;
                }
                SellerAddGoodsActivity.this.i.z0(0, new File(stringExtra));
            }
        }

        public k() {
        }

        @Override // defpackage.vx2
        public void a() {
            b5.a(SellerAddGoodsActivity.this, new Intent(SellerAddGoodsActivity.this.b, (Class<?>) ChooseVideoActivity.class), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        if (v31.a(false)) {
            yx2.a(this, new k(), "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0067, code lost:
    
        if (r6 == null) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007b A[Catch: IOException -> 0x0014, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0014, blocks: (B:6:0x0010, B:49:0x007b, B:44:0x0028), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002e A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.io.File a2(java.lang.String r6) {
        /*
            r5 = this;
            r5 = 0
            android.media.MediaMetadataRetriever r0 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r0.<init>()     // Catch: java.lang.Throwable -> L1e java.lang.Exception -> L21
            r0.setDataSource(r6)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r1 = 0
            r3 = 3
            android.graphics.Bitmap r1 = r0.getFrameAtTime(r1, r3)     // Catch: java.lang.Throwable -> L19 java.lang.Exception -> L1c
            r0.release()     // Catch: java.io.IOException -> L14
            goto L2c
        L14:
            r6 = move-exception
            defpackage.ah1.a(r6)
            return r5
        L19:
            r6 = move-exception
            goto L79
        L1c:
            r1 = move-exception
            goto L23
        L1e:
            r6 = move-exception
            r0 = r5
            goto L79
        L21:
            r1 = move-exception
            r0 = r5
        L23:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L19
            if (r0 == 0) goto L2b
            r0.release()     // Catch: java.io.IOException -> L14
        L2b:
            r1 = r5
        L2c:
            if (r1 != 0) goto L2f
            return r5
        L2f:
            java.lang.String r0 = ".mp4"
            java.lang.String r2 = ".jpg"
            java.lang.String r6 = r6.replace(r0, r2)
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L60
            android.graphics.Bitmap$CompressFormat r5 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2 = 100
            r1.compress(r5, r2, r6)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r6.flush()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r6.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
        L4e:
            r6.close()     // Catch: java.io.IOException -> L52
            goto L6a
        L52:
            r5 = move-exception
            r5.printStackTrace()
            goto L6a
        L57:
            r5 = move-exception
            goto L6e
        L59:
            r5 = move-exception
            goto L64
        L5b:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
            goto L6e
        L60:
            r6 = move-exception
            r4 = r6
            r6 = r5
            r5 = r4
        L64:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r6 == 0) goto L6a
            goto L4e
        L6a:
            r1.recycle()
            return r0
        L6e:
            if (r6 == 0) goto L78
            r6.close()     // Catch: java.io.IOException -> L74
            goto L78
        L74:
            r6 = move-exception
            r6.printStackTrace()
        L78:
            throw r5
        L79:
            if (r0 == 0) goto L7e
            r0.release()     // Catch: java.io.IOException -> L14
        L7e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.mall.activity.SellerAddGoodsActivity.a2(java.lang.String):java.io.File");
    }

    public static void b2(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SellerAddGoodsActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("mallGoodsId", str);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c2() {
        Dialog dialog = this.x;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.x.dismiss();
    }

    private void e2() {
        if (this.x == null) {
            this.x = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.x.isShowing()) {
            return;
        }
        this.x.show();
    }

    private void f2() {
        if (this.w == null) {
            t54.a(m93.T5);
            return;
        }
        String trim = this.g.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.U5);
            return;
        }
        this.y = trim;
        String trim2 = this.j.getText().toString().trim();
        if (TextUtils.isEmpty(trim2)) {
            t54.a(m93.V5);
            return;
        }
        this.z = trim2;
        if (this.t.isChecked()) {
            this.A = "0";
        } else {
            String trim3 = this.o.getText().toString().trim();
            if (TextUtils.isEmpty(trim3)) {
                t54.a(m93.W5);
                return;
            }
            this.A = trim3;
        }
        String trim4 = this.v.getText().toString().trim();
        if (TextUtils.isEmpty(trim4)) {
            this.B = "0";
        } else {
            this.B = trim4;
        }
        p5 p5Var = this.n;
        if (p5Var != null) {
            for (AddGoodsSpecBean addGoodsSpecBean : p5Var.N()) {
                if (TextUtils.isEmpty(addGoodsSpecBean.getName())) {
                    t54.a(m93.X5);
                    return;
                } else if (TextUtils.isEmpty(addGoodsSpecBean.getNum())) {
                    t54.a(m93.Y5);
                    return;
                } else if (TextUtils.isEmpty(addGoodsSpecBean.getPrice())) {
                    t54.a(m93.Z5);
                    return;
                }
            }
        }
        g2();
    }

    private void g2() {
        ArrayList arrayList = new ArrayList();
        q5 q5Var = this.i;
        if (q5Var != null) {
            File w0 = q5Var.w0();
            if (w0 != null && w0.exists()) {
                UploadBean uploadBean = new UploadBean(w0, 1);
                uploadBean.setTag(this.i);
                arrayList.add(uploadBean);
                File a2 = a2(w0.getAbsolutePath());
                if (a2 != null && a2.length() > 0 && a2.exists()) {
                    UploadBean uploadBean2 = new UploadBean(a2, 0);
                    uploadBean2.setTag(this.i);
                    arrayList.add(uploadBean2);
                }
            }
            List N = this.i.N();
            int size = N.size();
            for (int i2 = 1; i2 < size; i2++) {
                AddGoodsImageBean addGoodsImageBean = (AddGoodsImageBean) N.get(i2);
                File file = addGoodsImageBean.getFile();
                if (file != null && file.exists()) {
                    UploadBean uploadBean3 = new UploadBean(file, 0);
                    uploadBean3.setTag(addGoodsImageBean);
                    arrayList.add(uploadBean3);
                }
            }
        }
        o5 o5Var = this.l;
        if (o5Var != null) {
            List N2 = o5Var.N();
            int size2 = N2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AddGoodsImageBean addGoodsImageBean2 = (AddGoodsImageBean) N2.get(i3);
                File file2 = addGoodsImageBean2.getFile();
                if (file2 != null && file2.exists()) {
                    UploadBean uploadBean4 = new UploadBean(file2, 0);
                    uploadBean4.setTag(addGoodsImageBean2);
                    arrayList.add(uploadBean4);
                }
            }
        }
        p5 p5Var = this.n;
        if (p5Var != null) {
            List N3 = p5Var.N();
            int size3 = N3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                AddGoodsSpecBean addGoodsSpecBean = (AddGoodsSpecBean) N3.get(i4);
                File file3 = addGoodsSpecBean.getFile();
                if (file3 != null && file3.exists()) {
                    UploadBean uploadBean5 = new UploadBean(file3, 0);
                    uploadBean5.setTag(addGoodsSpecBean);
                    arrayList.add(uploadBean5);
                }
            }
        }
        if (arrayList.size() > 0) {
            e2();
            rd4.d(new a(arrayList));
        } else if (!TextUtils.isEmpty(this.e)) {
            d2();
        } else {
            c2();
            t54.a(m93.a6);
        }
    }

    public final void W1() {
        p5 p5Var = this.n;
        if (p5Var != null) {
            p5Var.g0();
        }
    }

    public final void X1() {
        b5.a(this, new Intent(this.b, (Class<?>) ChooseGoodsClassActivity.class), new i());
    }

    public void addGoodsClick(View view) {
        int id = view.getId();
        if (id == d73.s0) {
            X1();
        } else if (id == d73.u) {
            W1();
        } else if (id == d73.n1) {
            f2();
        }
    }

    public final void d2() {
        StringBuilder sb = new StringBuilder();
        List N = this.i.N();
        int size = N.size();
        for (int i2 = 1; i2 < size; i2++) {
            String uploadResultUrl = ((AddGoodsImageBean) N.get(i2)).getUploadResultUrl();
            if (!TextUtils.isEmpty(uploadResultUrl)) {
                sb.append(uploadResultUrl);
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        int i3 = 0;
        if (sb2.length() > 1) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        String str = sb2;
        sb.delete(0, sb.length());
        List N2 = this.l.N();
        int size2 = N2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            String uploadResultUrl2 = ((AddGoodsImageBean) N2.get(i4)).getUploadResultUrl();
            if (!TextUtils.isEmpty(uploadResultUrl2)) {
                sb.append(uploadResultUrl2);
                sb.append(",");
            }
        }
        String sb3 = sb.toString();
        if (sb3.length() > 1) {
            sb3 = sb3.substring(0, sb3.length() - 1);
        }
        String str2 = sb3;
        List N3 = this.n.N();
        int size3 = N3.size();
        while (i3 < size3) {
            AddGoodsSpecBean addGoodsSpecBean = (AddGoodsSpecBean) N3.get(i3);
            i3++;
            addGoodsSpecBean.setId(String.valueOf(i3));
            String uploadResultUrl3 = addGoodsSpecBean.getUploadResultUrl();
            if (!TextUtils.isEmpty(uploadResultUrl3)) {
                addGoodsSpecBean.setThumb(uploadResultUrl3);
            }
        }
        ec2.A0(this.w.getOneClassId(), this.w.getTwoClassId(), this.w.getId(), this.y, this.z, JSON.toJSONString(N3), this.A, this.B, this.i.y0(), this.i.x0(), str, str2, this.e, new b());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.I;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.M5));
        this.e = getIntent().getStringExtra("mallGoodsId");
        this.f = (TextView) findViewById(d73.S1);
        this.g = (TextView) findViewById(d73.f2);
        this.j = (TextView) findViewById(d73.V1);
        this.o = (TextView) findViewById(d73.j3);
        RecyclerView findViewById = findViewById(d73.A3);
        this.h = findViewById;
        findViewById.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 15.0f, 0.0f);
        rq1Var.l(true);
        this.h.k(rq1Var);
        q5 q5Var = new q5(this.b);
        this.i = q5Var;
        q5Var.R(new d());
        this.h.setAdapter(this.i);
        RecyclerView findViewById2 = findViewById(d73.w3);
        this.k = findViewById2;
        findViewById2.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var2 = new rq1(this.b, 0, 15.0f, 0.0f);
        rq1Var2.l(true);
        this.k.k(rq1Var2);
        o5 o5Var = new o5(this.b);
        this.l = o5Var;
        o5Var.R(new e());
        this.k.setAdapter(this.l);
        RecyclerView findViewById3 = findViewById(d73.z3);
        this.m = findViewById3;
        findViewById3.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        p5 p5Var = new p5(this.b);
        this.n = p5Var;
        p5Var.R(new f());
        this.m.setAdapter(this.n);
        this.u = findViewById(d73.q2);
        CheckBox checkBox = (CheckBox) findViewById(d73.y1);
        this.t = checkBox;
        checkBox.setOnCheckedChangeListener(new g());
        this.v = (EditText) findViewById(d73.n3);
        if (!TextUtils.isEmpty(this.e)) {
            ec2.N(this.e, new h());
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AddGoodsImageBean());
        arrayList.add(new AddGoodsImageBean());
        this.i.P(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new AddGoodsImageBean());
        this.l.P(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new AddGoodsSpecBean());
        this.n.P(arrayList3);
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("setGoods");
        ec2.u(CommonHttpConsts.GET_GOODS_INFO);
        rd4.c();
        c2();
        super.onDestroy();
    }
}
