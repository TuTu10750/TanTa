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
import com.alibaba.fastjson.JSONObject;
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
public class k32 implements View.OnClickListener {
    public Context a;
    public View b;
    public boolean c;
    public SocketClient d;
    public ViewGroup e;
    public p0 f;
    public String g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public String l;
    public String m;
    public String n;
    public TextView o;
    public int p;
    public String q = aq4.a(m93.m3);
    public PopupWindow r;
    public uo2 s;
    public boolean t;
    public long u;
    public nh1 v;
    public int w;
    public String x;

    /* loaded from: /tmp/classes2.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: k32$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0085a extends HttpCallback {
            public C0085a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr.length <= 0) {
                    t54.b(str);
                    k32.this.k = null;
                    k32.this.m = null;
                    return;
                }
                k32.this.j = true;
                k32 k32Var = k32.this;
                k32Var.m = k32Var.k;
                boolean Q1 = ((LiveActivity) k32.this.a).Q1();
                a aVar = a.this;
                if (!Q1) {
                    lr3.a(k32.this.d, k32.this.g, k32.this.x, k32.this.l, k32.this.k);
                    return;
                }
                String str2 = k32.this.g;
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                if (parseObject != null) {
                    String string = parseObject.getString("pull");
                    if (!TextUtils.isEmpty(string)) {
                        str2 = string;
                    }
                }
                lr3.a(k32.this.d, str2, k32.this.x, k32.this.l, k32.this.k);
            }
        }

        public a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (k32.this.s != null) {
                k32.this.s.o();
            }
            boolean z = k32.this.i;
            k32 k32Var = k32.this;
            if (!z) {
                int i = k32Var.p;
                k32 k32Var2 = k32.this;
                if (i == 0) {
                    lr3.f(k32Var2.d, k32.this.k);
                } else {
                    lr3.e(k32Var2.d, k32.this.k);
                }
                k32.this.k = null;
                k32.this.m = null;
            } else if (((LiveActivity) k32Var.a).N1()) {
                t54.a(m93.E3);
                lr3.g(k32.this.d, k32.this.k);
                k32.this.k = null;
                k32.this.m = null;
            } else {
                e32.t0(k32.this.k, k32.this.l, k32.this.x, new C0085a());
            }
            k32.this.h = false;
            k32.this.o = null;
            k32.this.r = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements uo2.b {
        public b() {
        }

        @Override // uo2.c
        public void a(String str) {
        }

        @Override // uo2.b
        public void b(int i) {
            k32.this.p = i;
            if (k32.this.o != null) {
                k32.this.o.setText(k32.this.q + "(" + i + "s)...");
            }
        }

        @Override // uo2.c
        public void c() {
            if (k32.this.r != null) {
                k32.this.r.dismiss();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements a.m {
        public c() {
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            ((LiveAnchorActivity) k32.this.a).R3();
            k32.this.i = true;
            if (k32.this.r != null) {
                k32.this.r.dismiss();
            }
        }
    }

    public k32(Context context, nh1 nh1Var, boolean z, int i, View view) {
        this.a = context;
        this.c = z;
        this.w = i;
        this.b = view;
        this.v = nh1Var;
        this.e = nh1Var.K();
    }

    public String A() {
        return this.m;
    }

    public void B() {
        LiveActivity z = z();
        if (z != null) {
            z.K1();
        }
    }

    public boolean C() {
        return this.j;
    }

    public void D(UserBean userBean, String str) {
        if (!this.c || userBean == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (C() || ((LiveActivity) this.a).O1()) {
            lr3.c(this.d, userBean.getId());
            return;
        }
        if (((LiveActivity) this.a).N1()) {
            lr3.g(this.d, userBean.getId());
            return;
        }
        if (TextUtils.isEmpty(this.k) || !this.k.equals(userBean.getId())) {
            if (this.j || this.h || System.currentTimeMillis() - this.u <= 10000) {
                lr3.c(this.d, userBean.getId());
                return;
            }
            this.k = userBean.getId();
            this.l = str;
            T(userBean);
        }
    }

    public void E() {
        this.u = 0L;
        t54.a(m93.X2);
    }

    public void F() {
        if (this.j) {
            t54.a(m93.Y2);
        }
        PopupWindow popupWindow = this.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.u = 0L;
        p0 p0Var = this.f;
        if (p0Var != null) {
            p0Var.release();
            this.f.removeFromParent();
        }
        this.e.removeAllViews();
        this.f = null;
        nh1 nh1Var = this.v;
        if (nh1Var != null) {
            nh1Var.n();
        }
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        boolean z = this.c;
        Object obj = this.a;
        if (z) {
            ((LiveAnchorActivity) obj).I3(false);
            if (((LiveActivity) this.a).Q1()) {
                zu0.c().j(new rz1(1, null, null));
            } else {
                ((LiveAnchorActivity) this.a).l3();
            }
        } else {
            ((LiveAudienceActivity) obj).B3();
        }
        B();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void G(String str, String str2, String str3) {
        lx1.b("主播连麦----对方主播的播放地址---->" + str3);
        String str4 = null;
        this.k = null;
        this.u = 0L;
        this.j = true;
        this.m = str;
        this.n = str2;
        nh1 nh1Var = this.v;
        if (nh1Var != null) {
            nh1Var.U();
        }
        if (this.c) {
            t54.a(m93.V2);
            ((LiveAnchorActivity) this.a).I3(true);
        }
        boolean Q1 = ((LiveActivity) this.a).Q1();
        Context context = this.a;
        if (Q1) {
            s32 s32Var = new s32(context, this.e);
            this.f = s32Var;
            s32Var.f0(this);
            this.f.addToParent();
            this.f.d0(str3);
            if (!this.c) {
                this.f.a0();
            }
            int lastIndexOf = str3.lastIndexOf("/");
            int indexOf = str3.indexOf("?", lastIndexOf);
            if (lastIndexOf >= 0 && lastIndexOf < str3.length() && indexOf >= 0 && indexOf < str3.length() && lastIndexOf < indexOf) {
                str4 = str3.substring(lastIndexOf + 1, indexOf);
            }
            if (!TextUtils.isEmpty(str4)) {
                zu0.c().j(new rz1(1, str, str4));
            }
        } else {
            ((LiveAnchorActivity) context).P3(str, str2);
            p32 p32Var = new p32(this.a, this.e);
            this.f = p32Var;
            p32Var.f0(this);
            this.f.addToParent();
        }
        U(str);
    }

    public void H() {
        this.u = 0L;
        t54.a(m93.k3);
    }

    public void I() {
        this.u = 0L;
        t54.a(m93.a3);
    }

    public void J() {
        this.u = 0L;
        com.yunbao.common.utils.a.m(this.a, aq4.a(m93.i3));
    }

    public void K() {
        this.t = true;
        p0 p0Var = this.f;
        if (p0Var != null) {
            p0Var.b0();
        }
    }

    public final void L() {
        PopupWindow popupWindow = this.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void M() {
        if (this.c) {
            e32.f("getSwRtcToken");
        }
        B();
        uo2 uo2Var = this.s;
        if (uo2Var != null) {
            uo2Var.k();
        }
        this.s = null;
        this.d = null;
        p0 p0Var = this.f;
        if (p0Var != null) {
            p0Var.release();
        }
        this.f = null;
    }

    public void N() {
        if (this.t) {
            this.t = false;
            p0 p0Var = this.f;
            if (p0Var != null) {
                p0Var.e0();
            }
        }
    }

    public void O(String str) {
        this.n = str;
    }

    public void P(String str) {
        this.m = str;
    }

    public void Q(String str) {
        this.g = str;
    }

    public void R(String str) {
        this.x = str;
    }

    public void S(SocketClient socketClient) {
        this.d = socketClient;
    }

    public final void T(UserBean userBean) {
        if (this.c) {
            ((LiveAnchorActivity) this.a).x3();
        }
        this.h = true;
        this.i = false;
        View inflate = LayoutInflater.from(this.a).inflate(x73.H, (ViewGroup) null);
        ImageView imageView = (ImageView) inflate.findViewById(b73.d);
        TextView textView = (TextView) inflate.findViewById(b73.X3);
        ImageView imageView2 = (ImageView) inflate.findViewById(b73.U4);
        ImageView imageView3 = (ImageView) inflate.findViewById(b73.z3);
        this.o = (TextView) inflate.findViewById(b73.l6);
        inflate.findViewById(b73.P0).setOnClickListener(this);
        inflate.findViewById(b73.r).setOnClickListener(this);
        kn1.f(this.a, userBean.getAvatar(), imageView);
        textView.setText(userBean.getUserNiceName());
        imageView2.setImageResource(l30.b(userBean.getSex()));
        LevelBean c2 = j30.q().c(userBean.getLevelAnchor());
        if (c2 != null) {
            kn1.f(this.a, c2.getThumb(), imageView3);
        }
        PopupWindow popupWindow = new PopupWindow(inflate, zn0.a(180), -2, true);
        this.r = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.r.setOutsideTouchable(false);
        this.r.setFocusable(false);
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        inflate.measure(0, 0);
        int measuredWidth = i - inflate.getMeasuredWidth();
        int measuredHeight = (i2 / 2) - inflate.getMeasuredHeight();
        this.r.setOnDismissListener(new a());
        this.r.showAtLocation(this.b, 0, measuredWidth, measuredHeight);
        if (this.s == null) {
            uo2 uo2Var = new uo2();
            this.s = uo2Var;
            uo2Var.l(new b());
        }
        this.s.m(10).n();
    }

    public void U(String str) {
        LiveActivity z = z();
        if (z != null) {
            z.A2(str);
        }
    }

    public final void a() {
        if (((LiveAnchorActivity) this.a).z3()) {
            com.yunbao.common.utils.a.i(this.a, aq4.a(m93.e3), new c());
            return;
        }
        this.i = true;
        PopupWindow popupWindow = this.r;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.P0) {
            L();
        } else if (id == b73.r) {
            a();
        } else if (id == b73.K) {
            y();
        }
    }

    public void v(String str, String str2, String str3) {
        if (w()) {
            this.u = System.currentTimeMillis();
            if (TextUtils.isEmpty(str2)) {
                str2 = this.g;
            }
            lr3.b(this.d, str2, str3, str);
            t54.a(m93.b3);
        }
    }

    public boolean w() {
        if (((LiveActivity) this.a).N1()) {
            t54.a(m93.E3);
            return false;
        }
        if (this.j || ((LiveActivity) this.a).O1()) {
            t54.a(this.c ? m93.W3 : m93.V3);
            return false;
        }
        if (System.currentTimeMillis() - this.u >= 11000) {
            return true;
        }
        t54.a(m93.d3);
        return false;
    }

    public void x() {
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.p = 0;
        this.r = null;
        this.u = 0L;
        B();
        uo2 uo2Var = this.s;
        if (uo2Var != null) {
            uo2Var.k();
        }
        p0 p0Var = this.f;
        if (p0Var != null) {
            p0Var.release();
            this.f.removeFromParent();
        }
        this.f = null;
        nh1 nh1Var = this.v;
        if (nh1Var != null) {
            nh1Var.n();
        }
    }

    public void y() {
        if (TextUtils.isEmpty(this.m)) {
            return;
        }
        lr3.d(this.d, this.m);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.yunbao.live.activity.LiveActivity, android.app.Activity] */
    public final LiveActivity z() {
        Object obj = this.a;
        if (!(obj instanceof LiveActivity)) {
            return null;
        }
        ?? r2 = (LiveActivity) obj;
        if (r2.isFinishing() || r2.isDestroyed()) {
            return null;
        }
        return r2;
    }
}
