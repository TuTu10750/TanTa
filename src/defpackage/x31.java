package defpackage;

import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yunbao.common.CommonAppContext;
import com.yunbao.live.bean.LiveAudienceFloatWindowData;
import com.yunbao.live.bean.LiveBean;
import defpackage.v31;

/* loaded from: /tmp/classes2.dex */
public class x31 implements v31.a {
    public static x31 f;
    public u31 a;
    public LiveBean b;
    public LiveAudienceFloatWindowData c;
    public int d = 0;
    public Handler e;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x31.this.b != null) {
                zu0.c().j(new d22(x31.this.b, x31.this.d));
            }
            x31.this.e();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x31.this.b != null) {
                zu0.c().j(new d22(x31.this.b, x31.this.d));
            }
            x31.this.e();
        }
    }

    public x31() {
        v31.b(this);
    }

    public static x31 f() {
        if (f == null) {
            synchronized (x31.class) {
                try {
                    if (f == null) {
                        f = new x31();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    @Override // v31.a
    public boolean a(boolean z) {
        if (z) {
            k12.c().e(false);
            k12.c().d();
            e();
            return true;
        }
        if (this.a == null || this.b == null) {
            return true;
        }
        t54.a(m93.H);
        return false;
    }

    @Override // v31.a
    public void b(boolean z) {
        u31 u31Var = this.a;
        if (u31Var != null) {
            u31Var.f(z);
        }
    }

    public void e() {
        lx1.c("float", "----dismiss---->");
        Handler handler = this.e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        u31 u31Var = this.a;
        if (u31Var != null) {
            u31Var.a();
        }
        this.a = null;
        this.b = null;
    }

    public void g() {
        w31.a().f();
    }

    public x31 h(LiveAudienceFloatWindowData liveAudienceFloatWindowData) {
        this.c = liveAudienceFloatWindowData;
        return this;
    }

    public x31 i(LiveBean liveBean) {
        this.b = liveBean;
        return this;
    }

    public x31 j(int i) {
        this.d = i;
        return this;
    }

    public void k() {
        LiveBean liveBean = this.b;
        if (liveBean == null) {
            lx1.c("float", "----show---->mLiveBean==null");
            return;
        }
        if (!liveBean.isVoiceRoom()) {
            lx1.c("float", "----show---->直播间");
            if (this.c == null) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(CommonAppContext.n()).inflate(x73.u1, (ViewGroup) null);
            u31 u31Var = new u31();
            u31Var.g(0);
            u31Var.d(0);
            u31Var.h(0);
            u31Var.i(0);
            u31Var.e(viewGroup);
            u31Var.c(new b());
            if (this.c.isTxSDK()) {
                return;
            }
            String pull = this.b.getPull();
            if ((TextUtils.isEmpty(pull) || !(pull.startsWith("http://") || pull.startsWith("https://") || pull.contains(".mp4") || pull.contains(".MP4"))) && this.e == null) {
                this.e = new Handler();
                return;
            }
            return;
        }
        lx1.c("float", "----show---->聊天室");
        View inflate = LayoutInflater.from(CommonAppContext.n()).inflate(x73.v1, (ViewGroup) null);
        kn1.g(CommonAppContext.n(), this.b.getThumb(), (ImageView) inflate.findViewById(b73.d));
        ((TextView) inflate.findViewById(b73.X3)).setText(this.b.getUserNiceName());
        ((TextView) inflate.findViewById(b73.Q2)).setText(rv3.a("ID:", this.b.getUid()));
        inflate.measure(0, 0);
        gk3 a2 = gk3.a();
        int c = a2.c();
        int b2 = a2.b();
        int measuredWidth = inflate.getMeasuredWidth();
        int a3 = zn0.a(40);
        int a4 = (b2 - a3) - zn0.a(150);
        u31 u31Var2 = new u31();
        u31Var2.g(measuredWidth);
        u31Var2.d(a3);
        u31Var2.h(c - measuredWidth);
        u31Var2.i(a4);
        u31Var2.e(inflate);
        u31Var2.c(new a());
        if (u31Var2.j()) {
            this.a = u31Var2;
        }
    }
}
