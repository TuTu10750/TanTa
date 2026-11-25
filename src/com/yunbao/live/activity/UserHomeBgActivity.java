package com.yunbao.live.activity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.UriDownloadCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import defpackage.an1;
import defpackage.b73;
import defpackage.e32;
import defpackage.j30;
import defpackage.k30;
import defpackage.kd4;
import defpackage.kn1;
import defpackage.m93;
import defpackage.pd4;
import defpackage.qd4;
import defpackage.rd4;
import defpackage.rv3;
import defpackage.t54;
import defpackage.vx2;
import defpackage.x73;
import defpackage.yn0;
import defpackage.yx2;
import defpackage.zj2;
import defpackage.zu0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class UserHomeBgActivity extends AbsActivity implements View.OnClickListener {
    public ImageView e;
    public String f;
    public an1 g = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {

        /* renamed from: com.yunbao.live.activity.UserHomeBgActivity$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0038a extends k30 {
            public final /* synthetic */ List a;
            public final /* synthetic */ Dialog b;

            /* renamed from: com.yunbao.live.activity.UserHomeBgActivity$a$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0039a implements pd4 {

                /* renamed from: com.yunbao.live.activity.UserHomeBgActivity$a$a$a$a, reason: collision with other inner class name */
                /* loaded from: /tmp/classes2.dex */
                public class C0040a extends HttpCallback {
                    public C0040a() {
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onFinish() {
                        C0038a.this.b.dismiss();
                    }

                    @Override // com.yunbao.common.http.HttpCallback
                    public void onSuccess(int i, String str, String[] strArr) {
                        if (i == 0 && strArr.length > 0) {
                            UserHomeBgActivity.this.f = JSON.parseObject(strArr[0]).getString("bg_img");
                            zu0.c().j(new kd4(UserHomeBgActivity.this.f, 1));
                        }
                        t54.b(str);
                    }
                }

                public C0039a() {
                }

                @Override // defpackage.pd4
                public void a(List list, boolean z) {
                    if (z) {
                        e32.I0(((UploadBean) list.get(0)).getRemoteFileName(), new C0040a());
                    }
                }
            }

            public C0038a(List list, Dialog dialog) {
                this.a = list;
                this.b = dialog;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(qd4 qd4Var) {
                qd4Var.a(this.a, true, new C0039a());
            }
        }

        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists()) {
                t54.a(m93.K1);
                return;
            }
            kn1.e(UserHomeBgActivity.this.b, file, UserHomeBgActivity.this.e);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new UploadBean(file, 0));
            Dialog c = com.yunbao.common.utils.a.c(UserHomeBgActivity.this.b);
            c.show();
            rd4.e("avatar/", new C0038a(arrayList, c));
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.n {
        public b() {
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            if (i == m93.R0) {
                UserHomeBgActivity userHomeBgActivity = UserHomeBgActivity.this;
                zj2.m(userHomeBgActivity, true, 10, 7, userHomeBgActivity.g);
            } else if (i == m93.K0) {
                UserHomeBgActivity userHomeBgActivity2 = UserHomeBgActivity.this;
                zj2.j(userHomeBgActivity2, true, 10, 7, userHomeBgActivity2.g);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends vx2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends UriDownloadCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.UriDownloadCallback
            public void onSuccess() {
                t54.a(m93.U9);
            }
        }

        public c() {
        }

        @Override // defpackage.vx2
        public void a() {
            long uptimeMillis = SystemClock.uptimeMillis();
            String str = rv3.b() + ".png";
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", "image/png");
            contentValues.put("title", str);
            contentValues.put("date_modified", Long.valueOf(uptimeMillis));
            contentValues.put("date_added", Long.valueOf(uptimeMillis));
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", Environment.DIRECTORY_DCIM);
            } else {
                contentValues.put("_data", j30.N + str);
            }
            new yn0("save_img").b(CommonAppContext.n().getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues), UserHomeBgActivity.this.f, new a());
        }
    }

    public static void E1(Context context, String str, boolean z) {
        Intent intent = new Intent(context, (Class<?>) UserHomeBgActivity.class);
        intent.putExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL, str);
        intent.putExtra("self", z);
        context.startActivity(intent);
    }

    public final void C1() {
        com.yunbao.common.utils.a.r(this.b, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new b());
    }

    public final void D1() {
        yx2.a((AbsActivity) this.b, new c(), zj2.u());
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return x73.n;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public boolean j1() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        if (intent.getBooleanExtra("self", false)) {
            findViewById(b73.F).setOnClickListener(this);
            findViewById(b73.U).setOnClickListener(this);
        } else {
            findViewById(b73.F).setVisibility(4);
            findViewById(b73.U).setVisibility(4);
        }
        ImageView imageView = (ImageView) findViewById(b73.R2);
        this.e = imageView;
        imageView.setOnClickListener(this);
        String stringExtra = intent.getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        this.f = stringExtra;
        kn1.f(this.b, stringExtra, this.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.F) {
            C1();
        } else if (id == b73.U) {
            D1();
        } else if (id == b73.R2) {
            finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e32.f("setUserHomeBgImg");
        super.onDestroy();
    }
}
