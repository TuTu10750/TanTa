package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.bean.LiveTypeConfig;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.upload.UploadBean;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LiveChooseClassActivity;
import com.yunbao.live.bean.LiveRoomTypeBean;
import defpackage.k52;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class s42 extends b1 implements View.OnClickListener {
    public LinearLayout A;
    public LinearLayout B;
    public String C;
    public String D;
    public LiveTypeConfig E;
    public ImageView a;
    public TextView b;
    public TextView c;
    public EditText d;
    public File e;
    public TextView f;
    public ImageView g;
    public TextView h;
    public TextView i;
    public int j;
    public int k;
    public int l;
    public String m;
    public int n;
    public boolean o;
    public int p;
    public int q;
    public boolean r;
    public ImageView s;
    public TextView t;
    public String u;
    public boolean v;
    public Dialog w;
    public boolean x;
    public String y;
    public String z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends k30 {
        public final /* synthetic */ LiveRoomTypeBean a;

        public a(LiveRoomTypeBean liveRoomTypeBean) {
            this.a = liveRoomTypeBean;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            s42.this.k = this.a.getId();
            s42.this.i.setText(this.a.getName());
            s42.this.l = num.intValue();
            s42.this.m = "";
            s42.this.n = num.intValue();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends k30 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        /* loaded from: /tmp/classes2.dex */
        public class a implements pd4 {

            /* renamed from: s42$b$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0153a extends HttpCallback {
                public C0153a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onFinish() {
                    s42.this.Q0();
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i != 0 || strArr.length <= 0) {
                        t54.b(str);
                        return;
                    }
                    s42.this.v = true;
                    lx1.c("开播", "createRoom------->" + strArr[0]);
                    e32.r(strArr[0]);
                    ((LiveAnchorActivity) s42.this.mContext).Q3(strArr[0], s42.this.k, s42.this.l, b.this.a);
                    ((LiveAnchorActivity) s42.this.mContext).G3(b.this.c == 1);
                }
            }

            public a() {
            }

            @Override // defpackage.pd4
            public void a(List list, boolean z) {
                b bVar = b.this;
                if (!z) {
                    s42.this.Q0();
                    return;
                }
                if (s42.this.v) {
                    return;
                }
                System.out.println("--oooo33333333333");
                String remoteFileName = ((UploadBean) list.get(0)).getRemoteFileName();
                if (remoteFileName.startsWith("ali_")) {
                    String replace = remoteFileName.replace("ali_", "");
                    s42.this.D = ((UploadBean) list.get(0)).getBucket_url() + "/" + replace;
                    bs3.d().p("liveCover", s42.this.D);
                }
                String C = j30.q().C();
                int i = s42.this.p;
                b bVar2 = b.this;
                String str = bVar2.a;
                int i2 = s42.this.k;
                b bVar3 = b.this;
                e32.p(C, i, str, 0, i2, bVar3.b, bVar3.c, s42.this.D, s42.this.o, 0, 0, new C0153a());
            }
        }

        public b(String str, String str2, int i) {
            this.a = str;
            this.b = str2;
            this.c = i;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(qd4 qd4Var) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new UploadBean(s42.this.e, 0));
            qd4Var.a(arrayList, false, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;

        public c(String str, int i) {
            this.a = str;
            this.b = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            lx1.c("开播", "createRoom------->" + strArr[0]);
            e32.r(strArr[0]);
            s42.this.v = true;
            ((LiveAnchorActivity) s42.this.mContext).Q3(strArr[0], s42.this.k, s42.this.l, this.a);
            ((LiveAnchorActivity) s42.this.mContext).G3(this.b == 1);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements k52.a {
        public d() {
        }

        @Override // k52.a
        public void c0(String str) {
            if ("link".equals(str)) {
                ((LiveActivity) s42.this.mContext).A1();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements a.m {
        public e() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            s42.this.d1();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements an1 {
        public f() {
        }

        @Override // defpackage.an1
        public void a(File file) {
            if (file != null) {
                kn1.e(s42.this.mContext, file, s42.this.a);
                if (s42.this.e == null) {
                    s42.this.b.setText(aq4.a(m93.x3));
                    s42.this.b.setBackground(o60.d(s42.this.mContext, h63.e));
                }
                s42.this.e = file;
            }
        }

        @Override // defpackage.an1
        public void b() {
        }

        @Override // defpackage.an1
        public void c() {
            ((LiveAnchorActivity) s42.this.mContext).i3();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements a.n {
        public final /* synthetic */ an1 a;

        public g(an1 an1Var) {
            this.a = an1Var;
        }

        @Override // com.yunbao.common.utils.a.n
        public void a(String str, int i) {
            int i2 = m93.R0;
            s42 s42Var = s42.this;
            if (i == i2) {
                zj2.l((AbsActivity) s42Var.mContext, this.a);
            } else {
                zj2.i((AbsActivity) s42Var.mContext, this.a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends s4 {
        public h() {
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            s42.this.j = intent.getIntExtra("classID", 0);
            s42.this.h.setText(intent.getStringExtra("className"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends m30 {
        public i() {
        }

        @Override // defpackage.m30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i, Integer num) {
            s42.this.k = i;
            s42.this.l = num.intValue();
            s42.this.m = "";
            s42.this.n = 0;
            int i2 = s42.this.k;
            s42 s42Var = s42.this;
            if (i2 == 0) {
                s42Var.i.setText("普通房间");
                return;
            }
            int i3 = s42Var.k;
            s42 s42Var2 = s42.this;
            if (i3 == 2) {
                s42Var2.i.setText("门票房间");
            } else if (s42Var2.k == 3) {
                s42.this.n = num.intValue();
                s42.this.i.setText("计时房间");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends k30 {
        public j() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(LiveRoomTypeBean liveRoomTypeBean) {
            int id = liveRoomTypeBean.getId();
            if (id == 0) {
                s42.this.S0(liveRoomTypeBean);
                return;
            }
            if (id == 1) {
                s42.this.U0(liveRoomTypeBean);
            } else if (id == 2) {
                s42.this.T0(liveRoomTypeBean);
            } else {
                if (id != 3) {
                    return;
                }
                s42.this.V0(liveRoomTypeBean);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements a.m {
        public final /* synthetic */ LiveRoomTypeBean a;

        public k(LiveRoomTypeBean liveRoomTypeBean) {
            this.a = liveRoomTypeBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            if (TextUtils.isEmpty(str)) {
                t54.a(m93.N4);
                return;
            }
            s42.this.k = this.a.getId();
            s42.this.i.setText(this.a.getName());
            s42.this.l = 0;
            s42.this.m = str;
            s42.this.n = 0;
            dialog.dismiss();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l implements a.m {
        public final /* synthetic */ LiveRoomTypeBean a;

        public l(LiveRoomTypeBean liveRoomTypeBean) {
            this.a = liveRoomTypeBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            if (TextUtils.isEmpty(str)) {
                t54.a(m93.L4);
                return;
            }
            s42.this.k = this.a.getId();
            s42.this.i.setText(this.a.getName());
            if (rv3.g(str)) {
                s42.this.l = rv3.h(str, 0);
            }
            s42.this.m = "";
            s42.this.n = 0;
            dialog.dismiss();
        }
    }

    public s42(Context context, ViewGroup viewGroup, int i2, int i3, String str, boolean z, String str2, String str3) {
        super(context, viewGroup, Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(z), str2, str3);
        this.m = "";
        this.o = true;
    }

    private void L0() {
        ((LiveAnchorActivity) this.mContext).h3();
    }

    private void O0() {
        ((LiveAnchorActivity) this.mContext).onBackPressed();
    }

    private void P0() {
        String trim = this.d.getText().toString().trim();
        if (trim.isEmpty()) {
            t54.b("直播标题不能为空");
            return;
        }
        bs3.d().p("liveTitle", trim);
        int i2 = (((LiveActivity) this.mContext).L1() || !this.r) ? 0 : 1;
        String valueOf = this.k == 1 ? this.m : String.valueOf(this.l);
        File file = this.e;
        if (file != null && file.exists()) {
            a1();
            rd4.e("liveshow/", new b(trim, valueOf, i2));
        } else {
            if (this.v) {
                return;
            }
            System.out.println("--oooo4444444444");
            e32.p(j30.q().C(), this.p, trim, 0, this.k, valueOf, i2, this.D, this.o, 0, 0, new c(trim, i2));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void W0() {
        f fVar = new f();
        int i2 = this.p;
        Context context = this.mContext;
        if (i2 == 1) {
            zj2.i((AbsActivity) context, fVar);
        } else {
            com.yunbao.common.utils.a.r(context, new Integer[]{Integer.valueOf(m93.K0), Integer.valueOf(m93.R0)}, new g(fVar));
        }
    }

    private void b1() {
        P0();
    }

    private void c1() {
        if (this.o) {
            new a.j(this.mContext).k(aq4.a(m93.d4)).g(true).j(aq4.a(m93.c4)).h(new e()).c().show();
        } else {
            d1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        boolean z = this.o;
        this.o = !z;
        ImageView imageView = this.g;
        if (imageView != null) {
            imageView.setImageResource(!z ? t83.t0 : t83.s0);
        }
        TextView textView = this.f;
        if (textView != null) {
            textView.setText(this.o ? j30.q().f() : aq4.a(m93.b4));
        }
    }

    private void y() {
        ((LiveAnchorActivity) this.mContext).T3();
    }

    public final void M0() {
        Intent intent = new Intent(this.mContext, (Class<?>) LiveChooseClassActivity.class);
        intent.putExtra("classID", this.j);
        b5.a((AbsActivity) this.mContext, intent, new h());
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [v52, android.app.Dialog] */
    public final void N0() {
        if (this.E != null) {
            ?? v52Var = new v52(this.mContext, this.E);
            v52Var.o(new i());
            v52Var.show();
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("checkedId", this.k);
            g52 g52Var = new g52();
            g52Var.F1(bundle);
            g52Var.s2(new j());
            g52Var.d2(((LiveAnchorActivity) this.mContext).getSupportFragmentManager(), "LiveRoomTypeDialogFragment");
        }
    }

    public final void Q0() {
        Dialog dialog = this.w;
        if (dialog != null) {
            dialog.dismiss();
            this.w = null;
        }
    }

    public final void R0() {
        String h2 = bs3.d().h("liveCover", j30.q().D().getAvatar());
        this.D = h2;
        kn1.f(this.mContext, h2, this.a);
        String g2 = bs3.d().g("liveTitle");
        this.C = g2;
        this.d.setText(g2);
    }

    public final void S0(LiveRoomTypeBean liveRoomTypeBean) {
        this.k = liveRoomTypeBean.getId();
        this.i.setText(liveRoomTypeBean.getName());
        this.l = 0;
        this.n = 0;
        this.m = "";
    }

    public final void T0(LiveRoomTypeBean liveRoomTypeBean) {
        new a.j(this.mContext).q(aq4.a(m93.K4)).g(true).m(true).l(aq4.a(m93.L7)).n(1).p(8).h(new l(liveRoomTypeBean)).c().show();
    }

    public final void U0(LiveRoomTypeBean liveRoomTypeBean) {
        new a.j(this.mContext).q(aq4.a(m93.M4)).g(true).m(true).l(aq4.a(m93.f5)).n(2).h(new k(liveRoomTypeBean)).c().show();
    }

    public final void V0(LiveRoomTypeBean liveRoomTypeBean) {
        p52 p52Var = new p52();
        Bundle bundle = new Bundle();
        bundle.putInt("checkedCoin", this.n);
        p52Var.F1(bundle);
        p52Var.s2(new a(liveRoomTypeBean));
        p52Var.d2(((LiveAnchorActivity) this.mContext).getSupportFragmentManager(), "LiveTimeDialogFragment");
    }

    public final void X0() {
        boolean z = this.r;
        this.r = !z;
        ImageView imageView = this.s;
        if (imageView != null) {
            imageView.setImageResource(!z ? t83.v0 : t83.u0);
        }
        TextView textView = this.t;
        if (textView != null) {
            textView.setTextColor(o60.b(this.mContext, this.r ? p53.g : p53.n));
        }
    }

    public void Y0(LiveTypeConfig liveTypeConfig) {
        this.E = liveTypeConfig;
        if (liveTypeConfig.getIsTicketRoom() == 1 || this.E.getIsTimeRoom() == 1) {
            this.A.setVisibility(8);
        }
    }

    public final void Z0() {
        k52 k52Var = new k52();
        k52Var.s2(new d());
        k52Var.d2(((LiveActivity) this.mContext).getSupportFragmentManager(), "LiveShareDialogFragment");
    }

    public final void a1() {
        if (this.w == null) {
            Dialog c2 = com.yunbao.common.utils.a.c(this.mContext);
            this.w = c2;
            c2.show();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.i2;
    }

    public void hide() {
        View view = this.mContentView;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.mContentView.setVisibility(4);
    }

    @Override // defpackage.b1
    public void init() {
        setStatusHeight();
        this.a = (ImageView) findViewById(b73.d);
        this.b = (TextView) findViewById(b73.G1);
        this.d = (EditText) findViewById(b73.S1);
        TextView textView = (TextView) findViewById(b73.r1);
        this.f = textView;
        textView.setText(j30.q().f());
        this.g = (ImageView) findViewById(b73.N3);
        findViewById(b73.w0).setOnClickListener(this);
        this.o = true;
        findViewById(b73.g).setOnClickListener(this);
        findViewById(b73.H).setOnClickListener(this);
        findViewById(b73.f1).setOnClickListener(this);
        findViewById(b73.b1).setOnClickListener(this);
        this.c = (TextView) findViewById(b73.m5);
        this.B = (LinearLayout) findViewById(b73.H3);
        this.c.setText(Html.fromHtml("已阅读并同意《<a href='protocol'><font color='#0E93FF'>" + this.y + "</font></a>》"));
        String str = this.z;
        if (str == null || !str.isEmpty()) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
        this.B.setOnClickListener(this);
        TextView textView2 = (TextView) findViewById(b73.X1);
        if (textView2 != null) {
            textView2.setText(this.u);
        }
        this.A = (LinearLayout) findViewById(b73.S0);
        if (!((LiveActivity) this.mContext).L1()) {
            this.i = (TextView) findViewById(b73.M5);
            this.h = (TextView) findViewById(b73.D3);
            findViewById(b73.t0).setOnClickListener(this);
            if (this.x) {
                findViewById(b73.B).setVisibility(8);
                findViewById(b73.z).setVisibility(8);
            } else {
                findViewById(b73.B).setOnClickListener(this);
                findViewById(b73.z).setOnClickListener(this);
            }
            View findViewById = findViewById(b73.c1);
            findViewById.setOnClickListener(this);
            this.s = (ImageView) findViewById(b73.V4);
            this.t = (TextView) findViewById(b73.W4);
            if (this.q != 1) {
                findViewById.setVisibility(8);
            }
        }
        R0();
    }

    public void onClick(View view) {
        if (canClick()) {
            int id = view.getId();
            if (id == b73.g) {
                W0();
                return;
            }
            if (id == b73.B) {
                y();
                return;
            }
            if (id == b73.H) {
                O0();
                return;
            }
            if (id == b73.t0) {
                M0();
                return;
            }
            if (id == b73.z) {
                L0();
                return;
            }
            if (id == b73.S0) {
                N0();
                return;
            }
            if (id == b73.f1) {
                b1();
                return;
            }
            if (id == b73.w0) {
                c1();
                return;
            }
            if (id == b73.c1) {
                X0();
                return;
            }
            if (id == b73.b1) {
                Z0();
            } else {
                if (id != b73.H3 || this.z.isEmpty()) {
                    return;
                }
                WebViewActivity.E1(this.mContext, this.z);
            }
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        if (zu0.c().h(this)) {
            zu0.c().p(this);
        }
        rd4.c();
        e32.f("createRoom");
        Q0();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLocationCityEvent(k72 k72Var) {
        if (this.o && this.f != null) {
            throw null;
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.p = ((Integer) objArr[0]).intValue();
        }
        if (objArr.length > 1) {
            this.q = ((Integer) objArr[1]).intValue();
        }
        if (objArr.length > 2) {
            this.u = (String) objArr[2];
        }
        if (objArr.length > 3) {
            this.x = ((Boolean) objArr[3]).booleanValue();
        }
        if (objArr.length > 4) {
            this.y = (String) objArr[4];
        }
        if (objArr.length > 5) {
            this.z = (String) objArr[5];
        }
    }

    @Override // defpackage.b1
    public void release() {
        super.release();
        if (zu0.c().h(this)) {
            zu0.c().p(this);
        }
    }

    public void show() {
        View view = this.mContentView;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.mContentView.setVisibility(0);
    }
}
