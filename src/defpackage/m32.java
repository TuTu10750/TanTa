package defpackage;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.custom.ProgressTextView;
import com.yunbao.live.socket.SocketClient;
import defpackage.uo2;

/* loaded from: /tmp/classes2.dex */
public class m32 implements View.OnClickListener {
    public Context a;
    public View b;
    public boolean c;
    public SocketClient d;
    public ViewGroup e;
    public boolean f;
    public boolean g;
    public boolean h;
    public String i;
    public String j;
    public String k;
    public String l;
    public ProgressTextView m;
    public int n;
    public PopupWindow o;
    public uo2 q;
    public o32 r;
    public boolean u;
    public boolean v;
    public int w;
    public String x;
    public long y = -1;
    public String s = aq4.a(m93.o4);
    public String t = aq4.a(m93.p4);
    public Handler p = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                m32.this.H();
            } else {
                if (i != 1) {
                    return;
                }
                m32.this.R();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends k30 {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public b(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            int intValue = num.intValue();
            m32 m32Var = m32.this;
            if (intValue == -1) {
                m32Var.v = false;
                return;
            }
            mr3.b(m32Var.d, this.a, this.b, num.intValue());
            t54.a(m93.c3);
            if (m32.this.r == null) {
                m32 m32Var2 = m32.this;
                m32Var2.r = new o32(m32Var2.a, m32.this.e);
                m32.this.r.addToParent();
            }
            m32.this.r.t0(true);
            m32.this.w = 10;
            m32.this.y = -1L;
            m32.this.G();
            if (m32.this.c) {
                ((LiveAnchorActivity) m32.this.a).I3(false);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements PopupWindow.OnDismissListener {
        public final /* synthetic */ int a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                } else {
                    mr3.a(m32.this.d, m32.this.i, c.this.a);
                    m32.this.h = true;
                }
            }
        }

        public c(int i) {
            this.a = i;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (m32.this.p != null) {
                m32.this.p.removeMessages(0);
            }
            boolean z = m32.this.g;
            m32 m32Var = m32.this;
            if (z) {
                e32.t0(m32Var.i, m32.this.j, m32.this.x, new a());
            } else {
                int i = m32Var.n;
                m32 m32Var2 = m32.this;
                if (i < 0) {
                    mr3.d(m32Var2.d, m32.this.i);
                } else {
                    mr3.e(m32Var2.d, m32.this.i);
                }
                m32.this.i = null;
                m32.this.j = null;
                if (m32.this.c) {
                    ((LiveAnchorActivity) m32.this.a).I3(true);
                }
            }
            m32.this.v = false;
            m32.this.f = false;
            m32.this.m = null;
            m32.this.o = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements uo2.c {
        public d() {
        }

        @Override // uo2.c
        public void a(String str) {
            if (m32.this.r != null) {
                boolean z = m32.this.u;
                m32 m32Var = m32.this;
                String str2 = z ? m32Var.t : m32Var.s;
                m32.this.r.u0(str2 + " " + str);
            }
        }

        @Override // uo2.c
        public void c() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m32.this.L();
            if (m32.this.c) {
                ((LiveAnchorActivity) m32.this.a).I3(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements uo2.c {
        public f() {
        }

        @Override // uo2.c
        public void a(String str) {
            if (m32.this.r != null) {
                boolean z = m32.this.u;
                m32 m32Var = m32.this;
                String str2 = z ? m32Var.t : m32Var.s;
                m32.this.r.u0(str2 + " " + str);
            }
        }

        @Override // uo2.c
        public void c() {
            if (m32.this.u) {
                m32.this.L();
                if (m32.this.c) {
                    ((LiveAnchorActivity) m32.this.a).I3(true);
                }
            }
        }
    }

    public m32(Context context, nh1 nh1Var, boolean z, View view) {
        this.a = context;
        this.c = z;
        this.b = view;
        this.e = nh1Var.V();
    }

    public void C(String str, String str2) {
        if (this.h) {
            t54.a(m93.X3);
        } else if (this.v) {
            t54.a(m93.d3);
        } else {
            this.v = true;
            new t6(this.a, new b(str, str2)).show();
        }
    }

    public void D() {
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = 0;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.y = -1L;
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.release();
            this.r.removeFromParent();
        }
        this.r = null;
        uo2 uo2Var = this.q;
        if (uo2Var != null) {
            uo2Var.k();
        }
    }

    public final long E() {
        if (this.y == -1) {
            this.y = SystemClock.uptimeMillis();
        }
        long j = this.y + 1000;
        this.y = j;
        return j;
    }

    public final void F() {
        this.v = false;
        Handler handler = this.p;
        if (handler != null) {
            handler.removeMessages(1);
        }
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.t0(false);
        }
    }

    public final void G() {
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.s0(this.w);
        }
        Handler handler = this.p;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(1, E());
        }
    }

    public final void H() {
        int i = this.n - 1;
        this.n = i;
        if (i < 0) {
            PopupWindow popupWindow = this.o;
            if (popupWindow != null) {
                popupWindow.dismiss();
                return;
            }
            return;
        }
        ProgressTextView progressTextView = this.m;
        if (progressTextView != null) {
            progressTextView.setProgress(i);
            Handler handler = this.p;
            if (handler != null) {
                handler.sendEmptyMessageAtTime(0, E());
            }
        }
    }

    public void I(String str, long j, long j2, int i) {
        this.h = true;
        this.v = false;
        this.u = false;
        this.l = str;
        this.i = null;
        this.j = null;
        if (this.r == null) {
            o32 o32Var = new o32(this.a, this.e);
            this.r = o32Var;
            o32Var.addToParent();
        }
        this.r.v0();
        this.r.q0();
        this.r.r0(j, j2);
        Y(i);
    }

    public void J(UserBean userBean, String str, int i) {
        if (!this.c || userBean == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(this.i) || !this.i.equals(userBean.getId())) {
            if (this.v) {
                mr3.c(this.d, userBean.getId());
                return;
            }
            if (this.h || this.f) {
                mr3.c(this.d, userBean.getId());
                return;
            }
            this.i = userBean.getId();
            this.j = str;
            X(userBean, i);
        }
    }

    public void K() {
        F();
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(true);
        }
        t54.a(m93.X2);
    }

    public void L() {
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        uo2 uo2Var = this.q;
        if (uo2Var != null) {
            uo2Var.k();
        }
        PopupWindow popupWindow = this.o;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.o = null;
        this.h = false;
        this.u = false;
        this.v = false;
        F();
        this.l = null;
        this.i = null;
        this.j = null;
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.removeFromParent();
            this.r.release();
        }
        this.r = null;
    }

    public void M(String str) {
        if (this.u) {
            return;
        }
        this.u = true;
        uo2 uo2Var = this.q;
        if (uo2Var != null) {
            uo2Var.k();
        }
        if (this.r == null || TextUtils.isEmpty(str)) {
            return;
        }
        if ("0".equals(str)) {
            this.r.n0(0);
            this.r.p0();
            Handler handler = this.p;
            if (handler != null) {
                handler.postDelayed(new e(), 3000L);
                return;
            }
            return;
        }
        boolean equals = str.equals(this.k);
        o32 o32Var = this.r;
        if (equals) {
            o32Var.n0(1);
        } else {
            o32Var.n0(-1);
        }
        if (this.q == null) {
            this.q = new uo2();
        }
        this.q.m(60).l(new f()).n();
    }

    public void N() {
        F();
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(true);
        }
        t54.a(m93.a3);
    }

    public void O() {
        F();
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(true);
        }
        t54.a(m93.l3);
    }

    public void P(String str, int i) {
        this.h = true;
        this.v = false;
        F();
        this.u = false;
        this.l = str;
        this.i = null;
        this.j = null;
        if (this.r == null) {
            o32 o32Var = new o32(this.a, this.e);
            this.r = o32Var;
            o32Var.addToParent();
        }
        this.r.w0();
        this.r.v0();
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(false);
        }
        Y(i);
    }

    public void Q(long j, long j2) {
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.r0(j, j2);
        }
    }

    public final void R() {
        int i = this.w - 1;
        this.w = i;
        if (i >= 0) {
            G();
            return;
        }
        F();
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(true);
        }
    }

    public final void S() {
        PopupWindow popupWindow = this.o;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void T() {
        Handler handler = this.p;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.p = null;
        this.d = null;
        o32 o32Var = this.r;
        if (o32Var != null) {
            o32Var.release();
        }
        this.r = null;
        uo2 uo2Var = this.q;
        if (uo2Var != null) {
            uo2Var.k();
            this.q = null;
        }
    }

    public void U(String str) {
        this.k = str;
    }

    public void V(String str) {
        this.x = str;
    }

    public void W(SocketClient socketClient) {
        this.d = socketClient;
    }

    public final void X(UserBean userBean, int i) {
        this.f = true;
        this.g = false;
        View inflate = LayoutInflater.from(this.a).inflate(x73.G, (ViewGroup) null);
        this.m = (ProgressTextView) inflate.findViewById(b73.q4);
        inflate.findViewById(b73.P0).setOnClickListener(this);
        inflate.findViewById(b73.r).setOnClickListener(this);
        ((TextView) inflate.findViewById(b73.I5)).setText("对方发起" + i + "秒PK");
        this.n = 10;
        this.y = -1L;
        PopupWindow popupWindow = new PopupWindow(inflate, zn0.a(280), -2, true);
        this.o = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        this.o.setOutsideTouchable(false);
        this.o.setFocusable(false);
        this.o.setOnDismissListener(new c(i));
        this.o.showAtLocation(this.b, 17, 0, 0);
        Handler handler = this.p;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(0, E());
        }
        if (this.c) {
            ((LiveAnchorActivity) this.a).I3(false);
        }
    }

    public final void Y(int i) {
        if (this.q == null) {
            this.q = new uo2();
        }
        this.q.m(i).l(new d()).n();
    }

    public final void a() {
        this.g = true;
        PopupWindow popupWindow = this.o;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == b73.P0) {
            S();
        } else if (id == b73.r) {
            a();
        }
    }
}
