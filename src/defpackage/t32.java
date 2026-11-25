package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.socket.SocketClient;
import defpackage.uo2;

/* loaded from: /tmp/classes2.dex */
public class t32 implements View.OnClickListener {
    public Context a;
    public View b;
    public SocketClient c;
    public boolean d;
    public String e;
    public ViewGroup f;
    public TextView g;
    public String h;
    public String i;
    public String j;
    public long k;
    public boolean l;
    public boolean m;
    public boolean n;
    public String o = aq4.a(m93.m3);
    public int p;
    public PopupWindow q;
    public uo2 r;
    public p0 s;
    public q0 t;
    public boolean u;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {

        /* renamed from: t32$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0157a implements j42 {
            public C0157a() {
            }

            @Override // defpackage.j42
            public void a() {
                com.yunbao.common.utils.a.i(t32.this.a, aq4.a(m93.g3), null);
                nr3.f(t32.this.c);
            }

            @Override // defpackage.j42
            public void b() {
                nr3.g(t32.this.c, "", t32.this.e);
            }

            @Override // defpackage.j42
            public void c() {
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            String string = JSON.parseObject(strArr[0]).getString("pushurl");
            t32 t32Var = t32.this;
            t32Var.t = new u32(t32Var.a, t32.this.f);
            t32.this.t.d0(new C0157a());
            t32.this.t.addToParent();
            t32.this.t.f0(string);
            zu0.c().j(new qz1(true));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                return;
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                t32.this.z();
            } else {
                t54.b(str);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends vx2 {
        public final /* synthetic */ long a;

        public d(long j) {
            this.a = j;
        }

        @Override // defpackage.vx2
        public void a() {
            t32.this.k = this.a;
            nr3.e(t32.this.c);
            t54.a(m93.b3);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements PopupWindow.OnDismissListener {
        public e() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (t32.this.r != null) {
                t32.this.r.o();
            }
            boolean z = t32.this.n;
            t32 t32Var = t32.this;
            if (!z) {
                int i = t32Var.p;
                t32 t32Var2 = t32.this;
                if (i == 0) {
                    nr3.c(t32Var2.c, t32.this.h);
                } else {
                    nr3.d(t32Var2.c, t32.this.h);
                }
                t32.this.h = null;
            } else if (((LiveActivity) t32Var.a).N1()) {
                t54.a(m93.E3);
                nr3.d(t32.this.c, t32.this.h);
                return;
            } else {
                if (((LiveActivity) t32.this.a).P1()) {
                    t54.a(m93.W3);
                    return;
                }
                t32.this.l = true;
                t32 t32Var3 = t32.this;
                t32Var3.i = t32Var3.h;
                nr3.a(t32.this.c, t32.this.h);
            }
            t32.this.m = false;
            t32.this.g = null;
            t32.this.q = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements uo2.b {
        public f() {
        }

        @Override // uo2.c
        public void a(String str) {
        }

        @Override // uo2.b
        public void b(int i) {
            t32.this.p = i;
            if (t32.this.g != null) {
                t32.this.g.setText(t32.this.o + "(" + i + "s)...");
            }
        }

        @Override // uo2.c
        public void c() {
            if (t32.this.q != null) {
                t32.this.q.dismiss();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements a.m {
        public g() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ((LiveAnchorActivity) t32.this.a).R3();
            t32.this.n = true;
            if (t32.this.q != null) {
                t32.this.q.dismiss();
            }
        }
    }

    public t32(Context context, nh1 nh1Var, boolean z, int i, View view) {
        this.a = context;
        this.b = view;
        this.d = z;
        this.f = nh1Var.Z();
    }

    public final void A() {
        e32.j(this.e, new c());
    }

    public void B() {
        e32.f("checkLinkMicEnable");
        this.l = false;
        this.m = false;
        this.n = false;
        this.k = 0L;
        this.h = null;
        this.i = null;
        this.j = null;
        this.q = null;
        uo2 uo2Var = this.r;
        if (uo2Var != null) {
            uo2Var.k();
        }
        p0 p0Var = this.s;
        if (p0Var != null) {
            p0Var.release();
            this.s.removeFromParent();
        }
        this.s = null;
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.release();
            this.t.removeFromParent();
        }
        this.t = null;
        ViewGroup viewGroup = this.f;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        this.f.removeAllViews();
    }

    public final void C() {
        e32.n(this.e, new b());
    }

    public final void D(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str.equals(this.i)) {
            if (!"undefined".equals(str2)) {
                t54.b(str2 + aq4.a(m93.f3));
            }
            boolean Q1 = ((LiveActivity) this.a).Q1();
            boolean z = this.d;
            if (Q1) {
                if (z) {
                    p0 p0Var = this.s;
                    if (p0Var != null) {
                        p0Var.release();
                        this.s.removeFromParent();
                    }
                    this.s = null;
                    zu0.c().j(new rz1(0, null, null));
                } else if (TextUtils.isEmpty(this.i) || !this.i.equals(j30.q().C())) {
                    p0 p0Var2 = this.s;
                    if (p0Var2 != null) {
                        p0Var2.release();
                        this.s.removeFromParent();
                    }
                    this.s = null;
                } else {
                    q0 q0Var = this.t;
                    if (q0Var != null) {
                        q0Var.release();
                        this.t.removeFromParent();
                    }
                    this.t = null;
                    zu0.c().j(new qz1(false));
                }
            } else if (z) {
                p0 p0Var3 = this.s;
                if (p0Var3 != null) {
                    p0Var3.release();
                    this.s.removeFromParent();
                }
                this.s = null;
            } else if (!TextUtils.isEmpty(this.i) && this.i.equals(j30.q().C())) {
                ((LiveAudienceActivity) this.a).h4(false);
            }
        }
        this.l = false;
        this.i = null;
        this.j = null;
        this.h = null;
    }

    public String E() {
        return this.i;
    }

    public boolean F() {
        return this.l;
    }

    public void G(String str) {
        if (this.d || TextUtils.isEmpty(str)) {
            return;
        }
        this.i = str;
        if (str.equals(j30.q().C())) {
            this.k = 0L;
            t54.a(m93.V2);
            this.l = true;
            if (((LiveActivity) this.a).Q1()) {
                e32.L(this.e, new a());
            } else {
                ((LiveAudienceActivity) this.a).h4(true);
            }
        }
    }

    public void H() {
        this.k = 0L;
        t54.a(m93.W2);
    }

    public void I(String str, String str2) {
        D(str, str2);
    }

    public void J() {
        this.k = 0L;
        t54.a(m93.Z2);
    }

    public void K() {
        this.k = 0L;
        t54.a(m93.j3);
    }

    public void L(UserBean userBean) {
        if (this.d && userBean != null) {
            if (F() || ((LiveActivity) this.a).P1() || ((LiveActivity) this.a).N1()) {
                nr3.b(this.c, userBean.getId());
                return;
            }
            if (TextUtils.isEmpty(this.h) || !this.h.equals(userBean.getId())) {
                if (this.l || this.m) {
                    nr3.b(this.c, userBean.getId());
                } else {
                    this.h = userBean.getId();
                    X(userBean);
                }
            }
        }
    }

    public void M(String str, String str2) {
        D(str, str2);
    }

    public void N(UserBean userBean) {
        if (userBean != null) {
            String id = userBean.getId();
            if (TextUtils.isEmpty(id)) {
                return;
            }
            if (id.equals(this.h)) {
                uo2 uo2Var = this.r;
                if (uo2Var != null) {
                    uo2Var.k();
                }
                PopupWindow popupWindow = this.q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
                this.l = false;
                this.h = null;
            }
            if (id.equals(this.i)) {
                D(id, userBean.getUserNiceName());
            }
        }
    }

    public void O(String str) {
    }

    public void P(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.d || TextUtils.isEmpty(this.h) || str.equals(this.h)) {
            this.h = null;
            this.j = str2;
            this.i = str;
            if (!((LiveActivity) this.a).Q1()) {
                if (this.d) {
                    p32 p32Var = new p32(this.a, this.f);
                    this.s = p32Var;
                    p32Var.f0(this);
                    this.s.addToParent();
                    return;
                }
                return;
            }
            s32 s32Var = new s32(this.a, this.f);
            this.s = s32Var;
            if (this.d) {
                s32Var.f0(this);
            }
            this.s.addToParent();
            this.s.d0(str3);
            int lastIndexOf = str3.lastIndexOf("/");
            int indexOf = str3.indexOf("?", lastIndexOf);
            if (lastIndexOf < 0 || lastIndexOf >= str3.length() || indexOf < 0 || indexOf >= str3.length() || lastIndexOf >= indexOf) {
                return;
            }
            String substring = str3.substring(lastIndexOf + 1, indexOf);
            if (TextUtils.isEmpty(substring)) {
                return;
            }
            zu0.c().j(new rz1(0, str, substring));
        }
    }

    public void Q() {
        if (((AbsActivity) this.a).e1()) {
            if (((LiveActivity) this.a).N1()) {
                t54.a(m93.E3);
                return;
            }
            if (((LiveActivity) this.a).P1()) {
                t54.a(m93.V3);
            } else if (this.l) {
                C();
            } else {
                A();
            }
        }
    }

    public void R() {
        this.u = true;
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.a0();
        }
        p0 p0Var = this.s;
        if (p0Var != null) {
            p0Var.b0();
        }
    }

    public void S() {
        e32.f("getTxLinkMicAccUrl");
        e32.f("getLinkMicStream");
        e32.f("linkMicShowVideo");
        uo2 uo2Var = this.r;
        if (uo2Var != null) {
            uo2Var.k();
        }
        this.r = null;
        this.c = null;
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.release();
        }
        p0 p0Var = this.s;
        if (p0Var != null) {
            p0Var.release();
        }
        this.t = null;
        this.s = null;
    }

    public void T() {
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.e0();
        }
    }

    public void U() {
        if (this.u) {
            this.u = false;
            q0 q0Var = this.t;
            if (q0Var != null) {
                q0Var.b0();
            }
            p0 p0Var = this.s;
            if (p0Var != null) {
                p0Var.e0();
            }
        }
    }

    public void V(String str) {
        this.e = str;
    }

    public void W(SocketClient socketClient) {
        this.c = socketClient;
    }

    public final void X(UserBean userBean) {
        if (this.d) {
            ((LiveAnchorActivity) this.a).x3();
        }
        this.m = true;
        this.n = false;
        View inflate = LayoutInflater.from(this.a).inflate(x73.H, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(b73.d);
        TextView textView = (TextView) inflate.findViewById(b73.X3);
        ImageView imageView2 = (ImageView) inflate.findViewById(b73.U4);
        ImageView imageView3 = (ImageView) inflate.findViewById(b73.z3);
        this.g = (TextView) inflate.findViewById(b73.l6);
        inflate.findViewById(b73.P0).setOnClickListener(this);
        inflate.findViewById(b73.r).setOnClickListener(this);
        kn1.f(this.a, userBean.getAvatar(), imageView);
        textView.setText(userBean.getUserNiceName());
        imageView2.setImageResource(l30.b(userBean.getSex()));
        LevelBean s = j30.q().s(userBean.getLevel());
        if (s != null) {
            kn1.f(this.a, s.getThumb(), imageView3);
        }
        this.p = 10;
        PopupWindow popupWindow = new PopupWindow(inflate, zn0.a(180), -2, true);
        this.q = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.q.setOutsideTouchable(false);
        this.q.setFocusable(false);
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        inflate.measure(0, 0);
        int measuredWidth = i - inflate.getMeasuredWidth();
        int measuredHeight = (i2 / 2) - inflate.getMeasuredHeight();
        this.q.setOnDismissListener(new e());
        this.q.showAtLocation(this.b, 0, measuredWidth, measuredHeight);
        if (this.r == null) {
            uo2 uo2Var = new uo2();
            this.r = uo2Var;
            uo2Var.l(new f());
        }
        this.r.m(10).n();
    }

    public void Y() {
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.F();
        }
    }

    public void Z() {
        q0 q0Var = this.t;
        if (q0Var != null) {
            q0Var.y();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j10.a()) {
            int id = view.getId();
            if (id == b73.P0) {
                y();
            } else if (id == b73.r) {
                x();
            } else if (id == b73.K) {
                C();
            }
        }
    }

    public final void x() {
        if (((LiveAnchorActivity) this.a).z3()) {
            com.yunbao.common.utils.a.i(this.a, aq4.a(m93.e3), new g());
            return;
        }
        this.n = true;
        PopupWindow popupWindow = this.q;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void y() {
        PopupWindow popupWindow = this.q;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void z() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.k < 11000) {
            t54.a(m93.d3);
        } else {
            yx2.a((AbsActivity) this.a, new d(currentTimeMillis), "android.permission.CAMERA", "android.permission.RECORD_AUDIO");
        }
    }
}
