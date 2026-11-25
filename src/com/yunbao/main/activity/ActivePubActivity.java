package com.yunbao.main.activity;

import android.app.Dialog;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.ChooseImageActivity;
import com.yunbao.common.activity.ChooseLocationActivity;
import com.yunbao.common.activity.ChooseVideoActivity;
import com.yunbao.common.custom.ActiveVoiceLayout;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.mall.bean.GoodsChooseSpecBean;
import defpackage.an1;
import defpackage.aq4;
import defpackage.c73;
import defpackage.cm4;
import defpackage.db2;
import defpackage.ec2;
import defpackage.h4;
import defpackage.j10;
import defpackage.k30;
import defpackage.k4;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.pm1;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
import defpackage.t54;
import defpackage.v31;
import defpackage.vx2;
import defpackage.y73;
import defpackage.yx2;
import defpackage.zj2;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class ActivePubActivity extends AbsActivity implements View.OnClickListener {
    public ImageView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public EditText e;
    public TextView f;
    public View g;
    public TextView h;
    public RecyclerView i;
    public h4 j;
    public k4 l;
    public cm4 m;
    public File n;
    public int o;
    public View p;
    public ActiveVoiceLayout q;
    public View r;
    public ImageView s;
    public File t;
    public Dialog v;
    public View w;
    public String x;
    public TextView y;
    public String z;
    public String k = "";
    public int u = 0;
    public an1 E = new f();

    /* loaded from: /tmp/classes2.dex */
    public class a implements a.m {
        public a() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ActivePubActivity.this.k2();
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends k30 {
        public final /* synthetic */ List a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {
            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(((UploadBean) it.next()).getRemoteFileName());
                        sb.append(";");
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(0, sb2.length() - 1);
                    }
                    ActivePubActivity.this.r2(sb2, "", "", "");
                }
            }
        }

        public b(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public final /* synthetic */ List a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {
            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                ActivePubActivity.this.r2("", "", "", ((UploadBean) list.get(0)).getRemoteFileName());
            }
        }

        public c(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, false, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends k30 {
        public final /* synthetic */ List a;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {
            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                ActivePubActivity.this.r2("", list.size() > 1 ? ((UploadBean) list.get(1)).getRemoteFileName() : "", ((UploadBean) list.get(0)).getRemoteFileName(), "");
            }
        }

        public d(List list) {
            this.a = list;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            qd4Var.a(this.a, true, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            ActivePubActivity.this.g2();
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (ActivePubActivity.this.m != null) {
                    ActivePubActivity.this.m.f();
                }
                ActivePubActivity.this.m = null;
                ActivePubActivity.this.finish();
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements an1 {
        public f() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                return;
            }
            ActivePubActivity.this.m2(file);
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (ActivePubActivity.this.f != null) {
                ActivePubActivity.this.f.setText(rv3.a(String.valueOf(charSequence.length()), "/200"));
            }
            if (ActivePubActivity.this.w != null) {
                ActivePubActivity.this.w.setEnabled(((ActivePubActivity.this.u == 0 || ActivePubActivity.this.u == 4) && TextUtils.isEmpty(charSequence)) ? false : true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements ActiveVoiceLayout.b {
        public h() {
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public File a() {
            return ActivePubActivity.this.n;
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void b() {
            ActivePubActivity.this.q2();
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void c(ActiveVoiceLayout activeVoiceLayout, File file) {
            ActivePubActivity.this.h2(file);
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void d(ActiveVoiceLayout activeVoiceLayout, String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements h4.b {

        /* loaded from: /tmp/classes2.dex */
        public class a implements pm1.c {
            public final /* synthetic */ List a;

            public a(List list) {
                this.a = list;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                kn1.e(ActivePubActivity.this.b, (File) this.a.get(i), imageView);
            }

            @Override // pm1.c
            public void b(int i) {
                if (ActivePubActivity.this.j != null) {
                    ActivePubActivity.this.j.P(i);
                }
            }

            @Override // pm1.c
            public String c(int i) {
                return null;
            }
        }

        public i() {
        }

        @Override // h4.b
        public void a() {
            ActivePubActivity.this.Z1();
        }

        @Override // h4.b
        public void b() {
            if (ActivePubActivity.this.g != null && ActivePubActivity.this.g.getVisibility() != 0) {
                ActivePubActivity.this.g.setVisibility(0);
            }
            ActivePubActivity.this.u = 0;
            if (ActivePubActivity.this.w != null) {
                ActivePubActivity.this.w.setEnabled(!TextUtils.isEmpty(ActivePubActivity.this.e.getText().toString()));
            }
        }

        @Override // h4.b
        public void onItemClick(int i) {
            List R;
            if (ActivePubActivity.this.j == null || (R = ActivePubActivity.this.j.R()) == null || R.size() == 0) {
                return;
            }
            pm1 pm1Var = new pm1();
            pm1Var.z2(R.size(), i, true, new a(R));
            pm1Var.d2(ActivePubActivity.this.getSupportFragmentManager(), "ImagePreviewDialog");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends HttpCallback {
        public j() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            JSONObject jSONObject = JSON.parseObject(strArr[0]).getJSONObject("goods_info");
            List parseArray = JSON.parseArray(jSONObject.getString("thumbs_format"), String.class);
            if (parseArray != null && parseArray.size() > 0 && ActivePubActivity.this.A != null) {
                kn1.f(ActivePubActivity.this.b, (String) parseArray.get(0), ActivePubActivity.this.A);
            }
            if (ActivePubActivity.this.C != null) {
                ActivePubActivity.this.C.setText(jSONObject.getString("name"));
            }
            List parseArray2 = JSON.parseArray(jSONObject.getString("specs_format"), GoodsChooseSpecBean.class);
            if (parseArray2 != null && parseArray2.size() > 0) {
                GoodsChooseSpecBean goodsChooseSpecBean = (GoodsChooseSpecBean) parseArray2.get(0);
                if (ActivePubActivity.this.B != null) {
                    ActivePubActivity.this.B.setText(goodsChooseSpecBean.getPrice());
                }
            }
            if (ActivePubActivity.this.D != null) {
                ActivePubActivity.this.D.setText(aq4.b(m93.f6, jSONObject.getString("sale_nums")));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends vx2 {
        public k() {
        }

        @Override // defpackage.vx2
        public void a() {
            if (ActivePubActivity.this.l == null) {
                ActivePubActivity activePubActivity = ActivePubActivity.this;
                activePubActivity.l = new k4(activePubActivity.b, (ViewGroup) ActivePubActivity.this.findViewById(c73.u4));
                ActivePubActivity.this.l.subscribeActivityLifeCycle();
            }
            if (ActivePubActivity.this.l.k0()) {
                return;
            }
            ActivePubActivity.this.l.addToParent();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends vx2 {
        public l() {
        }

        @Override // defpackage.vx2
        public void a() {
            int Q = ActivePubActivity.this.j != null ? ActivePubActivity.this.j.Q() : 0;
            Intent intent = new Intent(ActivePubActivity.this.b, (Class<?>) ChooseImageActivity.class);
            intent.putExtra("maxCount", 9 - Q);
            ActivePubActivity.this.startActivityForResult(intent, 10001);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends vx2 {
        public m() {
        }

        @Override // defpackage.vx2
        public void a() {
            ActivePubActivity.this.startActivityForResult(new Intent(ActivePubActivity.this.b, (Class<?>) ChooseVideoActivity.class), 10002);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n implements cm4.d {
        public n() {
        }

        @Override // cm4.d
        public void a() {
            if (ActivePubActivity.this.l != null && ActivePubActivity.this.l.k0()) {
                ActivePubActivity.this.l.l0();
            }
            if (ActivePubActivity.this.p.getVisibility() != 0 || ActivePubActivity.this.q == null) {
                return;
            }
            ActivePubActivity.this.q.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z1() {
        yx2.a(this, new l(), zj2.r());
    }

    private void c2() {
        if (v31.a(false)) {
            yx2.a(this, new m(), zj2.s());
        }
    }

    private void d2() {
        if (v31.a(false)) {
            yx2.a(this, new k(), zj2.s());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g2() {
        Dialog dialog = this.v;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.v.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k2() {
        db2.i("activePublish");
        ec2.u(CommonHttpConsts.GET_GOODS_INFO);
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.f();
        }
        this.m = null;
        ActiveVoiceLayout activeVoiceLayout = this.q;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.h();
        }
        this.q = null;
        rd4.c();
        g2();
        this.v = null;
    }

    private void p2() {
        if (this.v == null) {
            this.v = com.yunbao.common.utils.a.d(this.b, aq4.a(m93.ya));
        }
        if (this.v.isShowing()) {
            return;
        }
        this.v.show();
    }

    public final void a2() {
        startActivityForResult(new Intent(this.b, (Class<?>) ChooseLocationActivity.class), 10003);
    }

    public final void b2() {
        startActivityForResult(new Intent(this.b, (Class<?>) ActiveChooseTopicActivity.class), IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START);
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
    public final java.io.File e2(java.lang.String r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.main.activity.ActivePubActivity.e2(java.lang.String):java.io.File");
    }

    public final void f2() {
        ActiveVoiceLayout activeVoiceLayout = this.q;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.j();
        }
        this.o = 0;
        File file = this.n;
        if (file != null && file.exists()) {
            this.n.delete();
        }
        this.n = null;
        View view = this.p;
        if (view != null && view.getVisibility() != 8) {
            this.p.setVisibility(8);
        }
        View view2 = this.g;
        if (view2 != null && view2.getVisibility() != 0) {
            this.g.setVisibility(0);
        }
        this.u = 0;
        if (this.w != null) {
            this.w.setEnabled(!TextUtils.isEmpty(this.e.getText().toString()));
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return y73.b;
    }

    public void h2(File file) {
        if (file == null) {
            return;
        }
        if (this.m == null) {
            cm4 cm4Var = new cm4(this.b);
            this.m = cm4Var;
            cm4Var.i(new n());
        }
        this.m.j(file.getAbsolutePath());
    }

    public final void i2() {
    }

    public final void j2() {
        int i2 = this.u;
        if (i2 == 1) {
            s2();
            return;
        }
        if (i2 == 3) {
            u2();
        } else if (i2 == 2) {
            t2();
        } else {
            r2("", "", "", "");
        }
    }

    public final void l2(Intent intent) {
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("chooseImage");
        if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
            return;
        }
        h4 h4Var = this.j;
        if (h4Var != null) {
            h4Var.S(stringArrayListExtra);
        }
        View view = this.g;
        if (view != null && view.getVisibility() != 8) {
            this.g.setVisibility(8);
        }
        this.u = 1;
        View view2 = this.w;
        if (view2 != null) {
            view2.setEnabled(true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        View findViewById = findViewById(c73.T0);
        this.w = findViewById;
        findViewById.setOnClickListener(this);
        findViewById(c73.n1).setOnClickListener(this);
        findViewById(c73.C0).setOnClickListener(this);
        this.y = (TextView) findViewById(c73.J4);
        this.g = findViewById(c73.V3);
        this.h = (TextView) findViewById(c73.I3);
        this.e = (EditText) findViewById(c73.P1);
        this.f = (TextView) findViewById(c73.D4);
        this.e.addTextChangedListener(new g());
        String stringExtra = getIntent().getStringExtra("mallGoodsId");
        this.z = stringExtra;
        if (!TextUtils.isEmpty(stringExtra)) {
            t1(aq4.a(m93.P));
            this.u = 4;
            this.g.setVisibility(8);
            findViewById(c73.n2).setVisibility(0);
            this.A = (ImageView) findViewById(c73.q2);
            this.B = (TextView) findViewById(c73.o2);
            this.C = (TextView) findViewById(c73.r2);
            this.D = (TextView) findViewById(c73.p2);
            ec2.N(this.z, new j());
            return;
        }
        findViewById(c73.t0).setOnClickListener(this);
        findViewById(c73.q1).setOnClickListener(this);
        findViewById(c73.s1).setOnClickListener(this);
        this.p = findViewById(c73.E5);
        ActiveVoiceLayout activeVoiceLayout = (ActiveVoiceLayout) findViewById(c73.F5);
        this.q = activeVoiceLayout;
        activeVoiceLayout.setActionListener(new h());
        findViewById(c73.t1).setOnClickListener(this);
        this.r = findViewById(c73.w5);
        this.s = (ImageView) findViewById(c73.R2);
        this.r.setOnClickListener(this);
        RecyclerView findViewById2 = findViewById(c73.l4);
        this.i = findViewById2;
        findViewById2.setLayoutManager(new GridLayoutManager(this.b, 3, 1, false));
        rq1 rq1Var = new rq1(this.b, 0, 15.0f, 15.0f);
        rq1Var.l(true);
        this.i.k(rq1Var);
        h4 h4Var = new h4(this.b);
        this.j = h4Var;
        h4Var.T(new i());
        this.i.setAdapter(this.j);
    }

    public final void m2(File file) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file.getAbsolutePath());
        h4 h4Var = this.j;
        if (h4Var != null) {
            h4Var.S(arrayList);
        }
        View view = this.g;
        if (view != null && view.getVisibility() != 8) {
            this.g.setVisibility(8);
        }
        this.u = 1;
        View view2 = this.w;
        if (view2 != null) {
            view2.setEnabled(true);
        }
    }

    public void n2(Intent intent) {
        String stringExtra = intent.getStringExtra("chooseLocation");
        this.k = stringExtra;
        if (this.h != null) {
            boolean isEmpty = TextUtils.isEmpty(stringExtra);
            TextView textView = this.h;
            if (isEmpty) {
                textView.setText(m93.c5);
            } else {
                textView.setText(this.k);
            }
        }
    }

    public final void o2(Intent intent) {
        String stringExtra = intent.getStringExtra("videoPath");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.t = new File(stringExtra);
        View view = this.r;
        if (view != null && view.getVisibility() != 0) {
            this.r.setVisibility(0);
        }
        kn1.n(this.b, this.t, this.s);
        View view2 = this.g;
        if (view2 != null && view2.getVisibility() != 8) {
            this.g.setVisibility(8);
        }
        this.u = 2;
        View view3 = this.w;
        if (view3 != null) {
            view3.setEnabled(true);
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(i2, i3, intent);
        if (i3 != -1 || intent == null) {
            return;
        }
        if (i2 == 10001) {
            l2(intent);
            return;
        }
        if (i2 == 10002) {
            o2(intent);
            return;
        }
        if (i2 == 10003) {
            n2(intent);
            return;
        }
        if (i2 == 10004) {
            String stringExtra = intent.getStringExtra("className");
            TextView textView = this.y;
            if (textView != null) {
                textView.setHint("");
                this.y.setText(stringExtra);
            }
            this.x = intent.getStringExtra("classID");
        }
    }

    public void onBackPressed() {
        EditText editText;
        if (this.u != 0 || ((editText = this.e) != null && editText.getText().length() > 0)) {
            new a.j(this.b).k(aq4.a(m93.x0)).g(true).d(true).h(new a()).c().show();
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j10.a()) {
            int id = view.getId();
            if (id == c73.T0) {
                j2();
                return;
            }
            if (id == c73.t0) {
                Z1();
                return;
            }
            if (id == c73.q1) {
                c2();
                return;
            }
            if (id == c73.s1) {
                d2();
                return;
            }
            if (id == c73.n1) {
                b2();
                return;
            }
            if (id == c73.C0) {
                a2();
            } else if (id == c73.t1) {
                f2();
            } else if (id == c73.w5) {
                i2();
            }
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        k2();
        super.onDestroy();
    }

    public void q2() {
        cm4 cm4Var = this.m;
        if (cm4Var != null) {
            cm4Var.k();
        }
    }

    public final void r2(String str, String str2, String str3, String str4) {
        db2.f(this.u, this.e.getText().toString(), str, str2, str3, this.k, str4, this.o, this.x, this.z, new e());
    }

    public final void s2() {
        List R;
        h4 h4Var = this.j;
        if (h4Var == null || (R = h4Var.R()) == null || R.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = R.iterator();
        while (it.hasNext()) {
            arrayList.add(new UploadBean((File) it.next(), 0));
        }
        p2();
        rd4.e("dynamic/", new b(arrayList));
    }

    public final void t2() {
        File file = this.t;
        if (file == null || file.length() == 0 || !this.t.exists()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UploadBean(this.t, 1));
        File e2 = e2(this.t.getAbsolutePath());
        if (e2 != null && e2.length() > 0 && e2.exists()) {
            arrayList.add(new UploadBean(e2, 0));
        }
        p2();
        rd4.e("dynamic/", new d(arrayList));
    }

    public final void u2() {
        File file = this.n;
        if (file == null || file.length() == 0 || !this.n.exists()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new UploadBean(this.n, 2));
        p2();
        rd4.e("dynamic/", new c(arrayList));
    }

    public void v2(File file, int i2) {
        this.n = file;
        this.o = i2;
        View view = this.p;
        if (view != null && view.getVisibility() != 0) {
            this.p.setVisibility(0);
        }
        View view2 = this.g;
        if (view2 != null && view2.getVisibility() != 8) {
            this.g.setVisibility(8);
        }
        ActiveVoiceLayout activeVoiceLayout = this.q;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.setSecondsMax(i2);
        }
        this.u = 3;
        View view3 = this.w;
        if (view3 != null) {
            view3.setEnabled(true);
        }
    }
}
