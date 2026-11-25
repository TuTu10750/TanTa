package com.yunbao.mall.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.ChooseVideoActivity;
import com.yunbao.common.custom.RatingBar;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.AddGoodsCommentImageBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.b5;
import defpackage.d73;
import defpackage.ec2;
import defpackage.et2;
import defpackage.k30;
import defpackage.kn1;
import defpackage.m93;
import defpackage.n5;
import defpackage.p53;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
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
public class BuyerCommentActivity extends AbsActivity implements View.OnClickListener {
    public String e;
    public ImageView f;
    public TextView g;
    public TextView h;
    public EditText i;
    public RatingBar j;
    public RatingBar k;
    public RatingBar l;
    public RecyclerView m;
    public CheckBox n;
    public TextView o;
    public String p;
    public String q;
    public int r;
    public int s;
    public String t;
    public n5 u;
    public int v;
    public Dialog w;
    public an1 x = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {
        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                t54.a(m93.K1);
            } else if (BuyerCommentActivity.this.u != null) {
                BuyerCommentActivity.this.u.v0(BuyerCommentActivity.this.v, file);
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
    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (BuyerCommentActivity.this.o != null) {
                BuyerCommentActivity buyerCommentActivity = BuyerCommentActivity.this;
                if (z) {
                    buyerCommentActivity.o.setText(BuyerCommentActivity.this.p);
                    BuyerCommentActivity.this.o.setTextColor(BuyerCommentActivity.this.r);
                } else {
                    buyerCommentActivity.o.setText(BuyerCommentActivity.this.q);
                    BuyerCommentActivity.this.o.setTextColor(BuyerCommentActivity.this.s);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements et2 {
        public c() {
        }

        @Override // defpackage.et2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemClick(AddGoodsCommentImageBean addGoodsCommentImageBean, int i) {
            BuyerCommentActivity.this.v = i;
            int j = BuyerCommentActivity.this.u.j() - 1;
            BuyerCommentActivity buyerCommentActivity = BuyerCommentActivity.this;
            if (i == j) {
                buyerCommentActivity.P1();
            } else {
                buyerCommentActivity.O1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends HttpCallback {
        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("order_info");
            if (BuyerCommentActivity.this.f != null) {
                kn1.f(BuyerCommentActivity.this.b, jSONObject.getString("spec_thumb_format"), BuyerCommentActivity.this.f);
            }
            if (BuyerCommentActivity.this.g != null) {
                BuyerCommentActivity.this.g.setText(jSONObject.getString("goods_name"));
            }
            if (BuyerCommentActivity.this.h != null) {
                BuyerCommentActivity.this.h.setText(rv3.a(jSONObject.getString("spec_name"), "x", jSONObject.getString("nums")));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements a.n {
        public e() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                BuyerCommentActivity buyerCommentActivity = BuyerCommentActivity.this;
                zj2.n(buyerCommentActivity, false, buyerCommentActivity.x);
            } else if (i == m93.K0) {
                BuyerCommentActivity buyerCommentActivity2 = BuyerCommentActivity.this;
                zj2.k(buyerCommentActivity2, false, buyerCommentActivity2.x);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends vx2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public a() {
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                String stringExtra = intent.getStringExtra("videoPath");
                if (TextUtils.isEmpty(stringExtra) || BuyerCommentActivity.this.u == null) {
                    return;
                }
                BuyerCommentActivity.this.u.v0(BuyerCommentActivity.this.u.j() - 1, new File(stringExtra));
            }
        }

        public f() {
        }

        @Override // defpackage.vx2
        public void a() {
            b5.a(BuyerCommentActivity.this, new Intent(BuyerCommentActivity.this.b, (Class<?>) ChooseVideoActivity.class), new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends k30 {
        public final /* synthetic */ List a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {
            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (!z) {
                    BuyerCommentActivity.this.S1();
                    return;
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    UploadBean uploadBean = (UploadBean) it.next();
                    Object tag = uploadBean.getTag();
                    if (tag != null) {
                        if (tag == BuyerCommentActivity.this.u) {
                            if (uploadBean.getType() == 1) {
                                BuyerCommentActivity.this.u.x0(uploadBean.getRemoteFileName());
                            } else if (uploadBean.getType() == 0) {
                                BuyerCommentActivity.this.u.w0(uploadBean.getRemoteFileName());
                            }
                        } else if (tag instanceof AddGoodsCommentImageBean) {
                            ((AddGoodsCommentImageBean) tag).setUploadResultUrl(uploadBean.getRemoteFileName());
                        }
                    }
                }
                BuyerCommentActivity.this.T1();
            }
        }

        public g(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public h() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            BuyerCommentActivity.this.S1();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                BuyerCommentActivity.this.setResult(-1);
                BuyerCommentActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P1() {
        if (v31.a(false)) {
            yx2.a(this, new f(), "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
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
    private java.io.File Q1(java.lang.String r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.mall.activity.BuyerCommentActivity.Q1(java.lang.String):java.io.File");
    }

    public static void R1(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) BuyerCommentActivity.class);
        intent.putExtra("mallOrderId", str);
        ((Activity) context).startActivityForResult(intent, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        Dialog dialog = this.w;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.w.dismiss();
    }

    private void U1() {
        if (this.w == null) {
            this.w = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.w.isShowing()) {
            return;
        }
        this.w.show();
    }

    public final void T1() {
        StringBuilder sb = new StringBuilder();
        List N = this.u.N();
        int size = N.size() - 1;
        for (int i = 0; i < size; i++) {
            String uploadResultUrl = ((AddGoodsCommentImageBean) N.get(i)).getUploadResultUrl();
            if (!TextUtils.isEmpty(uploadResultUrl)) {
                sb.append(uploadResultUrl);
                sb.append(",");
            }
        }
        String sb2 = sb.toString();
        if (sb2.length() > 1) {
            sb2 = sb2.substring(0, sb2.length() - 1);
        }
        ec2.t(this.e, this.t, sb2, this.u.u0(), this.u.t0(), this.n.isChecked() ? "0" : SdkVersion.MINI_VERSION, this.j.getFillCount(), this.k.getFillCount(), this.l.getFillCount(), new h());
    }

    public void V1() {
        String trim = this.i.getText().toString().trim();
        this.t = trim;
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.d7);
        } else {
            W1();
        }
    }

    public final void W1() {
        U1();
        ArrayList arrayList = new ArrayList();
        File s0 = this.u.s0();
        if (s0 != null && s0.exists()) {
            UploadBean uploadBean = new UploadBean(s0, 1);
            uploadBean.setTag(this.u);
            arrayList.add(uploadBean);
            File Q1 = Q1(s0.getAbsolutePath());
            if (Q1 != null && Q1.length() > 0 && Q1.exists()) {
                UploadBean uploadBean2 = new UploadBean(Q1, 0);
                uploadBean2.setTag(this.u);
                arrayList.add(uploadBean2);
            }
        }
        List N = this.u.N();
        int size = N.size() - 1;
        for (int i = 0; i < size; i++) {
            AddGoodsCommentImageBean addGoodsCommentImageBean = (AddGoodsCommentImageBean) N.get(i);
            File file = addGoodsCommentImageBean.getFile();
            if (file != null && file.exists()) {
                UploadBean uploadBean3 = new UploadBean(file, 0);
                uploadBean3.setTag(addGoodsCommentImageBean);
                arrayList.add(uploadBean3);
            }
        }
        if (arrayList.size() > 0) {
            rd4.d(new g(arrayList));
        } else {
            S1();
            T1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        this.e = getIntent().getStringExtra("mallOrderId");
        this.f = (ImageView) findViewById(d73.e2);
        this.g = (TextView) findViewById(d73.W1);
        this.h = (TextView) findViewById(d73.d2);
        this.i = (EditText) findViewById(d73.R1);
        this.j = (RatingBar) findViewById(d73.q3);
        this.k = (RatingBar) findViewById(d73.r3);
        this.l = (RatingBar) findViewById(d73.s3);
        RecyclerView findViewById = findViewById(d73.u3);
        this.m = findViewById;
        findViewById.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 15.0f, 0.0f);
        rq1Var.l(true);
        this.m.k(rq1Var);
        this.p = aq4.a(m93.a7);
        this.q = aq4.a(m93.c7);
        this.r = o60.b(this.b, p53.g);
        this.s = o60.b(this.b, p53.i);
        this.o = (TextView) findViewById(d73.p3);
        CheckBox checkBox = (CheckBox) findViewById(d73.y1);
        this.n = checkBox;
        checkBox.setOnCheckedChangeListener(new b());
        findViewById(d73.Q0).setOnClickListener(this);
        n5 n5Var = new n5(this.b);
        this.u = n5Var;
        n5Var.R(new c());
        this.m.setAdapter(this.u);
        ec2.G(this.e, new d());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.Q0) {
            V1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getBuyerOrderDetail");
        ec2.u("buyerSetComment");
        rd4.c();
        S1();
        super.onDestroy();
    }
}
