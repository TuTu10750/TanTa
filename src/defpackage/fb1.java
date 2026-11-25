package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.game.bean.GameParam;
import com.yunbao.game.custom.ZpBetView;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class fb1 extends m0 {
    public Animation A;
    public Animation B;
    public Animation C;
    public Handler D;
    public int E;
    public String F;
    public View G;
    public ImageView H;
    public boolean I;
    public ObjectAnimator J;
    public ObjectAnimator K;
    public int L;
    public eb1 M;
    public TextView u;
    public TextView v;
    public int w;
    public ZpBetView[] x;
    public TextView y;
    public TextView z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            fb1.this.k0(JSON.parseObject(strArr[0]).getString("coin"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            fb1.this.K0();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            fb1.this.h0(3);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (fb1.this.v == null || fb1.this.v.getVisibility() != 0) {
                return;
            }
            fb1.this.v.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            fb1.this.v.setText(String.valueOf(fb1.this.w));
            fb1 fb1Var = fb1.this;
            fb1Var.w--;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (fb1.this.u == null || fb1.this.u.getVisibility() != 0) {
                return;
            }
            fb1.this.u.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends Handler {
        public e() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 101:
                    fb1.this.z0();
                    return;
                case 102:
                default:
                    return;
                case 103:
                    if (fb1.this.u != null) {
                        fb1.this.u.startAnimation(fb1.this.B);
                        return;
                    }
                    return;
                case 104:
                    fb1.this.B0();
                    return;
                case 105:
                    fb1.this.E0();
                    return;
                case 106:
                    fb1.this.C0();
                    return;
                case 107:
                    if (fb1.this.M != null) {
                        fb1.this.M.hide();
                        return;
                    }
                    return;
                case 108:
                    fb1.this.D0();
                    return;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends HttpCallback {
        public f() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            fb1.this.o = parseObject.getString("gameid");
            fb1.this.p = parseObject.getString("token");
            fb1.this.q = parseObject.getIntValue(DeepLinkPresetEvent.UMEventParamTime);
            fb1 fb1Var = fb1.this;
            ua1 ua1Var = fb1Var.l;
            if (ua1Var != null) {
                ua1Var.b(fb1Var.f, fb1Var.o, fb1Var.p, fb1Var.q);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends HttpCallback {
        public final /* synthetic */ int a;

        public g(int i) {
            this.a = i;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            UserBean D = j30.q().D();
            if (D != null) {
                D.setLevel(parseObject.getIntValue("level"));
            }
            fb1.this.k0(parseObject.getString("coin"));
            fb1 fb1Var = fb1.this;
            ua1 ua1Var = fb1Var.l;
            if (ua1Var != null) {
                ua1Var.g(fb1Var.e, this.a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends HttpCallback {
        public h() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            fb1.this.k0(parseObject.getString("coin"));
            int intValue = parseObject.getIntValue("gamecoin");
            if (intValue <= 0) {
                t54.a(c93.b);
                return;
            }
            fb1 fb1Var = fb1.this;
            com.yunbao.common.utils.a.n(fb1Var.a, fb1Var.F, "+" + intValue + fb1.this.c);
        }
    }

    public fb1(GameParam gameParam, bb1 bb1Var) {
        super(gameParam, bb1Var);
        boolean isAnchor = gameParam.isAnchor();
        int c2 = (gk3.a().c() / 2) + zn0.a(20);
        this.i = isAnchor ? c2 : c2 + zn0.a(40);
        if (isAnchor) {
            return;
        }
        View inflate = ((ViewStub) findViewById(z63.L)).inflate();
        inflate.findViewById(z63.d).setOnClickListener(this);
        inflate.findViewById(z63.b).setOnClickListener(this);
        inflate.findViewById(z63.c).setOnClickListener(this);
        inflate.findViewById(z63.e).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(z63.f);
        this.z = textView;
        textView.setOnClickListener(this);
        for (ZpBetView zpBetView : this.x) {
            zpBetView.setOnClickListener(this);
        }
        this.e = 10;
        ya1.g(new a());
    }

    private void A0(int i) {
        ya1.d(this.o, this.e, i, new g(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        int i = this.E - 1;
        this.E = i;
        TextView textView = this.y;
        if (i <= 0) {
            textView.setVisibility(4);
            return;
        }
        textView.setText(String.valueOf(i));
        Handler handler = this.D;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
        }
    }

    private void F0(JSONObject jSONObject) {
        ZpBetView zpBetView;
        String string = jSONObject.getString("uid");
        int intValue = jSONObject.getIntValue("money");
        int intValue2 = jSONObject.getIntValue("type") - 1;
        boolean equals = string.equals(j30.q().C());
        if (equals) {
            h0(2);
        }
        ZpBetView[] zpBetViewArr = this.x;
        if (zpBetViewArr == null || intValue2 < 0 || intValue2 >= 4 || (zpBetView = zpBetViewArr[intValue2]) == null) {
            return;
        }
        zpBetView.d(intValue, equals);
    }

    private void G0(JSONObject jSONObject) {
        if (!this.k) {
            n0();
            L0();
        }
        this.t = true;
        if (!this.j) {
            this.o = jSONObject.getString("gameid");
            this.p = jSONObject.getString("token");
            this.q = jSONObject.getIntValue(DeepLinkPresetEvent.UMEventParamTime);
        }
        this.E = this.q - 1;
        TextView textView = this.y;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
            this.y.setText(String.valueOf(this.E));
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            if (textView2.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.d);
            this.u.startAnimation(this.C);
        }
        Handler handler = this.D;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
            this.D.sendEmptyMessageDelayed(103, 1500L);
        }
        h0(0);
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
    }

    private void H0() {
        lx1.c(this.b, "---------onGameClose----------->");
        f0();
        release();
    }

    private void I0(JSONObject jSONObject) {
        TextView textView = this.u;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.c);
            this.u.startAnimation(this.C);
            Handler handler = this.D;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(103, 1500L);
            }
        }
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        View view = this.G;
        if (view != null) {
            view.setRotation(0.0f);
        }
        int[] iArr = (int[]) JSON.parseObject(jSONObject.getString("ct"), int[].class);
        ObjectAnimator objectAnimator2 = this.K;
        if (objectAnimator2 != null) {
            this.L = iArr[0];
            objectAnimator2.setFloatValues(((1 - r6) * 18) + 2160);
            this.K.start();
        }
        Handler handler2 = this.D;
        if (handler2 != null) {
            handler2.sendEmptyMessageDelayed(105, 16000L);
        }
    }

    private void J0() {
        Handler handler;
        if (this.k) {
            return;
        }
        n0();
        this.t = false;
        this.w = 6;
        this.v.setText(String.valueOf(6 + 1));
        this.v.startAnimation(this.A);
        if (this.j && (handler = this.D) != null) {
            handler.sendEmptyMessageDelayed(101, 7000L);
        }
        L0();
    }

    public void C0() {
        ya1.f(this.o, new h());
    }

    public final void D0() {
        ImageView imageView = this.H;
        if (imageView != null) {
            if (this.I) {
                imageView.setImageResource(r83.q);
            } else {
                imageView.setImageResource(r83.r);
            }
            this.I = !this.I;
            L0();
        }
    }

    public void E0() {
        Handler handler;
        this.t = false;
        this.w = 6;
        TextView textView = this.u;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.f);
        }
        TextView textView2 = this.v;
        if (textView2 != null) {
            if (textView2.getVisibility() != 0) {
                this.v.setVisibility(0);
            }
            this.v.setText(String.valueOf(this.w + 1));
            this.v.startAnimation(this.A);
        }
        ZpBetView[] zpBetViewArr = this.x;
        if (zpBetViewArr != null) {
            for (ZpBetView zpBetView : zpBetViewArr) {
                if (zpBetView != null) {
                    zpBetView.a();
                }
            }
        }
        if (!this.j || (handler = this.D) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(101, 7000L);
    }

    public final void K0() {
        if (this.M == null) {
            eb1 eb1Var = new eb1(this.a, this.mParentView);
            this.M = eb1Var;
            eb1Var.addToParent();
        }
        this.M.d0(this.L);
        this.M.show();
        Handler handler = this.D;
        if (handler != null) {
            if (!this.j) {
                handler.sendEmptyMessageDelayed(106, 500L);
            }
            this.D.sendEmptyMessageDelayed(107, 8000L);
        }
    }

    public final void L0() {
        Handler handler = this.D;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(108, 1000L);
        }
    }

    @Override // defpackage.m0
    public void a0() {
        if (this.t) {
            t54.a(c93.e);
            return;
        }
        ua1 ua1Var = this.l;
        if (ua1Var != null) {
            ua1Var.c();
        }
        zu0.c().j(new cb1(false, 0));
    }

    @Override // defpackage.m0
    public void b0() {
        TextView textView;
        if (this.k) {
            return;
        }
        n0();
        int i = this.q - 1;
        this.E = i;
        if (i > 0 && (textView = this.y) != null) {
            if (textView.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
            this.y.setText(String.valueOf(this.E));
        }
        L0();
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            if (textView2.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.d);
            this.u.startAnimation(this.C);
        }
        Handler handler = this.D;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
            this.D.sendEmptyMessageDelayed(103, 1500L);
        }
        h0(0);
    }

    @Override // defpackage.m0
    public void e0(int i, JSONObject jSONObject) {
        if (this.n) {
            return;
        }
        lx1.c(this.b, "-----handleSocket--------->" + jSONObject.toJSONString());
        if (i == 1) {
            J0();
            return;
        }
        if (i == 3) {
            H0();
            return;
        }
        if (i == 4) {
            G0(jSONObject);
        } else if (i == 5) {
            F0(jSONObject);
        } else {
            if (i != 6) {
                return;
            }
            I0(jSONObject);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return v73.c;
    }

    @Override // defpackage.b1
    public void init() {
        this.u = (TextView) findViewById(z63.K);
        this.v = (TextView) findViewById(z63.i);
        this.G = findViewById(z63.t);
        this.H = (ImageView) findViewById(z63.o);
        ZpBetView[] zpBetViewArr = new ZpBetView[4];
        this.x = zpBetViewArr;
        zpBetViewArr[0] = (ZpBetView) findViewById(z63.C);
        this.x[1] = (ZpBetView) findViewById(z63.D);
        this.x[2] = (ZpBetView) findViewById(z63.E);
        this.x[3] = (ZpBetView) findViewById(z63.F);
        this.y = (TextView) findViewById(z63.j);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.G, "rotation", 0.0f, 359.0f);
        this.J = ofFloat;
        ofFloat.setRepeatCount(-1);
        this.J.setDuration(8000L);
        this.J.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.G, "rotation", 0.0f);
        this.K = ofFloat2;
        ofFloat2.addListener(new b());
        this.K.setDuration(6000L);
        this.K.setInterpolator(new AccelerateDecelerateInterpolator());
        ScaleAnimation scaleAnimation = new ScaleAnimation(4.0f, 1.0f, 4.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.A = scaleAnimation;
        scaleAnimation.setDuration(1000L);
        this.A.setRepeatCount(6);
        this.A.setRepeatMode(1);
        this.A.setInterpolator(new AccelerateInterpolator());
        this.A.setAnimationListener(new c());
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.C = scaleAnimation2;
        scaleAnimation2.setDuration(500L);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.5f, 1, 0.5f);
        this.B = scaleAnimation3;
        scaleAnimation3.setDuration(500L);
        this.B.setAnimationListener(new d());
        this.D = new e();
        this.F = aq4.a(c93.h);
    }

    @Override // defpackage.m0
    public void k0(String str) {
        TextView textView = this.z;
        if (textView != null) {
            textView.setText(rv3.a(this.d, " ", str, "  "));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == z63.C) {
            A0(1);
            return;
        }
        if (id == z63.D) {
            A0(2);
            return;
        }
        if (id == z63.E) {
            A0(3);
            return;
        }
        if (id == z63.F) {
            A0(4);
            return;
        }
        if (id == z63.d) {
            this.e = 10;
            h0(1);
            return;
        }
        if (id == z63.b) {
            this.e = 100;
            h0(1);
            return;
        }
        if (id == z63.c) {
            this.e = IjkMediaCodecInfo.RANK_MAX;
            h0(1);
        } else if (id == z63.e) {
            this.e = 10000;
            h0(1);
        } else if (id == z63.f) {
            d0();
        }
    }

    @Override // defpackage.m0, defpackage.b1
    public void release() {
        this.n = true;
        ya1.a("getCoin");
        ya1.a("gameLuckPanCreate");
        ya1.a("gameLuckPanBet");
        ya1.a("gameSettle");
        super.release();
        Handler handler = this.D;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.D = null;
        eb1 eb1Var = this.M;
        if (eb1Var != null) {
            eb1Var.release();
        }
        ObjectAnimator objectAnimator = this.J;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.K;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        TextView textView = this.v;
        if (textView != null) {
            textView.clearAnimation();
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            textView2.clearAnimation();
        }
        lx1.c(this.b, "---------release----------->");
    }

    @Override // defpackage.m0, defpackage.b1
    public void removeFromParent() {
        super.removeFromParent();
        eb1 eb1Var = this.M;
        if (eb1Var != null) {
            eb1Var.removeFromParent();
        }
    }

    public void z0() {
        if (this.j) {
            ya1.e(this.g, new f());
        }
    }
}
