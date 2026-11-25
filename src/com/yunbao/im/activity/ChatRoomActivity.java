package com.yunbao.im.activity;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.UserBean;
import defpackage.a73;
import defpackage.an1;
import defpackage.b5;
import defpackage.ck1;
import defpackage.fz;
import defpackage.gz;
import defpackage.ry;
import defpackage.s4;
import defpackage.uw1;
import defpackage.v31;
import defpackage.vx2;
import defpackage.w73;
import defpackage.yx2;
import defpackage.zj2;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class ChatRoomActivity extends AbsActivity implements uw1.c {
    public ViewGroup e;
    public ViewGroup f;
    public fz g;
    public boolean h;
    public uw1 i;
    public an1 j = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements an1 {
        public a() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file == null || !file.exists() || ChatRoomActivity.this.g == null) {
                return;
            }
            ChatRoomActivity.this.g.G0(file.getAbsolutePath());
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ry {

        /* loaded from: /tmp/classes2.dex */
        public class a extends vx2 {
            public a() {
            }

            @Override // defpackage.vx2
            public void a() {
                ChatRoomActivity.this.B1();
            }
        }

        /* renamed from: com.yunbao.im.activity.ChatRoomActivity$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0033b extends vx2 {
            public C0033b() {
            }

            @Override // defpackage.vx2
            public void a() {
                ChatRoomActivity.this.D1();
            }
        }

        public b() {
        }

        @Override // defpackage.ry
        public void a() {
            ChatRoomActivity.this.F1();
        }

        @Override // defpackage.ry
        public void b() {
            ChatRoomActivity chatRoomActivity = ChatRoomActivity.this;
            zj2.n(chatRoomActivity, false, chatRoomActivity.j);
        }

        @Override // defpackage.ry
        public void c() {
            if (v31.a(false)) {
                yx2.a(ChatRoomActivity.this, new C0033b(), "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO");
            }
        }

        @Override // defpackage.ry
        public void d() {
        }

        @Override // defpackage.ry
        public void e() {
            yx2.a(ChatRoomActivity.this, new a(), "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends s4 {
        public c() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("selectedImagePath");
                if (ChatRoomActivity.this.g != null) {
                    ChatRoomActivity.this.g.G0(stringExtra);
                }
            }
        }
    }

    public static void A1(Context context, UserBean userBean, boolean z, boolean z2) {
        Intent intent = new Intent(context, (Class<?>) ChatRoomActivity.class);
        intent.putExtra("userBean", userBean);
        intent.putExtra("follow", z);
        intent.putExtra("imFromHome", z2);
        context.startActivity(intent);
    }

    private void E1() {
        uw1 uw1Var = this.i;
        if (uw1Var != null) {
            uw1Var.i();
        }
        this.i = null;
        fz fzVar = this.g;
        if (fzVar != null) {
            fzVar.release();
        }
        this.g = null;
        ck1.e().s(false);
    }

    public final void B1() {
        b5.a(this, new Intent(this.b, (Class<?>) ChatChooseImageActivity.class), new c());
    }

    public boolean C1() {
        return this.h;
    }

    public final void D1() {
        gz gzVar = new gz();
        gzVar.v2(this.g);
        gzVar.d2(getSupportFragmentManager(), "ChatVoiceInputDialog");
    }

    public void F1() {
        E1();
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return w73.c;
    }

    @Override // uw1.c
    public void h(int i) {
        fz fzVar = this.g;
        if (fzVar != null) {
            fzVar.F0(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        Intent intent = getIntent();
        UserBean userBean = (UserBean) intent.getParcelableExtra("userBean");
        if (userBean == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("follow", false);
        this.h = intent.getBooleanExtra("imFromHome", false);
        this.e = (ViewGroup) findViewById(a73.g0);
        ViewGroup viewGroup = (ViewGroup) findViewById(a73.F);
        this.f = viewGroup;
        fz fzVar = new fz(this.b, viewGroup, userBean, booleanExtra);
        this.g = fzVar;
        fzVar.K0(new b());
        this.g.addToParent();
        this.g.loadData();
        this.i = new uw1(this.e, this);
        ck1.e().s(true);
    }

    public void onBackPressed() {
        fz fzVar = this.g;
        if (fzVar != null) {
            fzVar.s0();
        } else {
            F1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        E1();
        super.onDestroy();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onPause() {
        super.onPause();
        fz fzVar = this.g;
        if (fzVar != null) {
            fzVar.onPause();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onResume() {
        super.onResume();
        fz fzVar = this.g;
        if (fzVar != null) {
            fzVar.onResume();
        }
    }
}
