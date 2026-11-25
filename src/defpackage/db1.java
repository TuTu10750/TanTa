package defpackage;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.game.bean.GameParam;
import com.yunbao.game.custom.GameBetCoinView;
import com.yunbao.game.custom.PokerView;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class db1 extends m0 {
    public int A;
    public View B;
    public PokerView[] C;
    public View[] D;
    public View[] E;
    public TextView F;
    public TextView G;
    public GameBetCoinView[] H;
    public ImageView[] I;
    public ImageView J;
    public Animation K;
    public Animation L;
    public Animation M;
    public Animation N;
    public ValueAnimator O;
    public Handler P;
    public int Q;
    public int R;
    public String S;
    public TextView u;
    public TextView v;
    public View w;
    public int x;
    public Animation y;
    public int z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            db1.this.k0(JSON.parseObject(strArr[0]).getString("coin"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            db1.this.C0((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (db1.this.v == null || db1.this.v.getVisibility() != 0) {
                return;
            }
            db1.this.v.setVisibility(4);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            db1.this.v.setText(String.valueOf(db1.this.x));
            db1 db1Var = db1.this;
            db1Var.x--;
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
            if (db1.this.u == null || db1.this.u.getVisibility() != 0) {
                return;
            }
            db1.this.u.setVisibility(4);
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
                    db1.this.z0();
                    return;
                case 102:
                    db1.this.L0();
                    return;
                case 103:
                    if (db1.this.u != null) {
                        db1.this.u.startAnimation(db1.this.L);
                        return;
                    }
                    return;
                case 104:
                    db1.this.B0();
                    return;
                case 105:
                    db1.this.M0(message.arg1, (String[]) message.obj);
                    return;
                case 106:
                    db1.this.E0();
                    return;
                default:
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
            db1.this.o = parseObject.getString("gameid");
            db1.this.p = parseObject.getString("token");
            db1.this.q = parseObject.getIntValue(DeepLinkPresetEvent.UMEventParamTime);
            db1 db1Var = db1.this;
            ua1 ua1Var = db1Var.l;
            if (ua1Var != null) {
                ua1Var.f(db1Var.o);
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
            db1.this.k0(parseObject.getString("coin"));
            db1 db1Var = db1.this;
            ua1 ua1Var = db1Var.l;
            if (ua1Var != null) {
                ua1Var.d(db1Var.e, this.a);
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
            db1.this.k0(parseObject.getString("coin"));
            int intValue = parseObject.getIntValue("gamecoin");
            if (intValue <= 0) {
                t54.a(c93.b);
                return;
            }
            db1 db1Var = db1.this;
            com.yunbao.common.utils.a.n(db1Var.a, db1Var.S, "+" + intValue + db1.this.c);
        }
    }

    public db1(GameParam gameParam, bb1 bb1Var) {
        super(gameParam, bb1Var);
        boolean isAnchor = gameParam.isAnchor();
        this.i = zn0.a(isAnchor ? 150 : 190);
        if (isAnchor) {
            return;
        }
        View inflate = ((ViewStub) findViewById(z63.L)).inflate();
        inflate.findViewById(z63.d).setOnClickListener(this);
        inflate.findViewById(z63.b).setOnClickListener(this);
        inflate.findViewById(z63.c).setOnClickListener(this);
        inflate.findViewById(z63.e).setOnClickListener(this);
        TextView textView = (TextView) inflate.findViewById(z63.f);
        this.G = textView;
        textView.setOnClickListener(this);
        for (GameBetCoinView gameBetCoinView : this.H) {
            gameBetCoinView.setOnClickListener(this);
        }
        this.e = 10;
        ya1.g(new a());
    }

    public final void A0(int i) {
        ya1.b(this.o, this.e, i, new g(i));
    }

    public final void B0() {
        int i = this.Q - 1;
        this.Q = i;
        TextView textView = this.F;
        if (i <= 0) {
            textView.setVisibility(4);
            return;
        }
        textView.setText(String.valueOf(i));
        Handler handler = this.P;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
        }
    }

    public final void C0(int i) {
        ViewGroup.LayoutParams layoutParams = this.w.getLayoutParams();
        layoutParams.height = i;
        this.w.setLayoutParams(layoutParams);
    }

    public void D0() {
        ya1.f(this.o, new h());
    }

    public void E0() {
        Handler handler;
        this.t = false;
        this.x = 6;
        ImageView[] imageViewArr = this.I;
        if (imageViewArr != null) {
            for (ImageView imageView : imageViewArr) {
                if (imageView != null && imageView.getVisibility() == 0) {
                    imageView.setVisibility(4);
                }
            }
        }
        GameBetCoinView[] gameBetCoinViewArr = this.H;
        if (gameBetCoinViewArr != null) {
            for (GameBetCoinView gameBetCoinView : gameBetCoinViewArr) {
                if (gameBetCoinView != null) {
                    gameBetCoinView.a();
                    gameBetCoinView.setVisibility(8);
                }
            }
        }
        View[] viewArr = this.E;
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null && view.getVisibility() != 0) {
                    view.setVisibility(0);
                }
            }
        }
        C0(this.z);
        ImageView imageView2 = this.J;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            this.J.setVisibility(4);
        }
        View view2 = this.B;
        if (view2 != null && view2.getVisibility() == 0) {
            this.B.setVisibility(4);
        }
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
            this.v.setText(String.valueOf(this.x + 1));
            this.v.startAnimation(this.K);
        }
        if (!this.j || (handler = this.P) == null) {
            return;
        }
        handler.sendEmptyMessageDelayed(101, 7000L);
    }

    public final void F0(JSONObject jSONObject) {
        GameBetCoinView gameBetCoinView;
        String string = jSONObject.getString("uid");
        int intValue = jSONObject.getIntValue("money");
        int intValue2 = jSONObject.getIntValue("type") - 1;
        boolean equals = string.equals(j30.q().C());
        if (equals) {
            h0(2);
        }
        GameBetCoinView[] gameBetCoinViewArr = this.H;
        if (gameBetCoinViewArr == null || intValue2 < 0 || intValue2 >= 3 || (gameBetCoinView = gameBetCoinViewArr[intValue2]) == null) {
            return;
        }
        gameBetCoinView.e(intValue, equals);
    }

    public final void G0(JSONObject jSONObject) {
        this.t = true;
        if (!this.j) {
            this.o = jSONObject.getString("gameid");
            this.p = jSONObject.getString("token");
            this.q = jSONObject.getIntValue(DeepLinkPresetEvent.UMEventParamTime);
        }
        this.Q = this.q - 1;
        TextView textView = this.F;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.F.setVisibility(0);
            }
            this.F.setText(String.valueOf(this.Q));
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            if (textView2.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.d);
            this.u.startAnimation(this.M);
        }
        Handler handler = this.P;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
            this.P.sendEmptyMessageDelayed(103, 1500L);
        }
        GameBetCoinView[] gameBetCoinViewArr = this.H;
        if (gameBetCoinViewArr != null) {
            for (GameBetCoinView gameBetCoinView : gameBetCoinViewArr) {
                if (gameBetCoinView != null && gameBetCoinView.getVisibility() != 0) {
                    gameBetCoinView.setVisibility(0);
                }
            }
        }
        h0(0);
    }

    public final void H0() {
        lx1.c(this.b, "---------onGameClose----------->");
        f0();
        release();
    }

    public final void I0() {
        if (!this.k) {
            n0();
            TextView textView = this.u;
            if (textView != null && textView.getVisibility() == 0) {
                this.u.setVisibility(4);
            }
            View[] viewArr = this.D;
            if (viewArr != null) {
                for (View view : viewArr) {
                    if (view != null) {
                        view.startAnimation(this.N);
                    }
                }
            }
        }
        View[] viewArr2 = this.E;
        if (viewArr2 != null) {
            for (View view2 : viewArr2) {
                if (view2 != null && view2.getVisibility() == 0) {
                    view2.setVisibility(4);
                }
            }
        }
        TextView textView2 = this.u;
        if (textView2 != null && this.L != null && textView2.getVisibility() == 0) {
            this.u.startAnimation(this.L);
        }
        ValueAnimator valueAnimator = this.O;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
        Handler handler = this.P;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(102, 1000L);
        }
    }

    public final void J0(JSONObject jSONObject) {
        this.R = -1;
        TextView textView = this.u;
        if (textView != null) {
            if (textView.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.c);
            this.u.startAnimation(this.M);
            Handler handler = this.P;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(103, 1500L);
            }
        }
        String[][] strArr = (String[][]) JSON.parseObject(jSONObject.getString("ct"), String[][].class);
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            Message obtain = Message.obtain();
            obtain.what = 105;
            obtain.arg1 = i;
            obtain.obj = strArr[i];
            Handler handler2 = this.P;
            if (handler2 != null) {
                handler2.sendMessageDelayed(obtain, i * 2000);
            }
        }
    }

    public final void K0() {
        Handler handler;
        if (this.k) {
            return;
        }
        n0();
        this.t = false;
        this.x = 6;
        this.v.setText(String.valueOf(6 + 1));
        this.v.startAnimation(this.K);
        if (this.j && (handler = this.P) != null) {
            handler.sendEmptyMessageDelayed(101, 7000L);
        }
        View[] viewArr = this.D;
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.startAnimation(this.N);
                }
            }
        }
    }

    public final void L0() {
        ua1 ua1Var;
        GameBetCoinView[] gameBetCoinViewArr = this.H;
        if (gameBetCoinViewArr != null) {
            for (GameBetCoinView gameBetCoinView : gameBetCoinViewArr) {
                if (gameBetCoinView != null && gameBetCoinView.getVisibility() == 8) {
                    gameBetCoinView.setVisibility(4);
                }
            }
        }
        View view = this.B;
        if (view != null && view.getVisibility() != 0) {
            this.B.setVisibility(0);
        }
        PokerView[] pokerViewArr = this.C;
        if (pokerViewArr != null) {
            for (PokerView pokerView : pokerViewArr) {
                if (pokerView != null) {
                    pokerView.g();
                }
            }
        }
        if (!this.j || (ua1Var = this.l) == null) {
            return;
        }
        ua1Var.a(this.f, this.o, this.p, this.q);
    }

    public final void M0(int i, String[] strArr) {
        PokerView pokerView = this.C[i];
        if (pokerView != null) {
            pokerView.i(za1.e(strArr[0]), za1.e(strArr[1]), za1.e(strArr[2]));
        }
        ImageView imageView = this.I[i];
        if (imageView != null) {
            imageView.setVisibility(0);
            this.I[i].setImageResource(za1.c(strArr[6]));
            this.I[i].startAnimation(this.y);
        }
        if (this.R == -1 && SdkVersion.MINI_VERSION.equals(strArr[3])) {
            this.R = i;
        }
        if (i == 2) {
            int i2 = this.R;
            if (i2 >= 0) {
                int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : r83.c : r83.b : r83.a;
                this.J.setVisibility(0);
                this.J.setImageResource(i3);
            }
            Handler handler = this.P;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(106, 7000L);
            }
            if (!this.j) {
                D0();
            }
        }
        h0(3);
    }

    @Override // defpackage.m0
    public void a0() {
        if (this.t) {
            t54.a(c93.e);
            return;
        }
        ua1 ua1Var = this.l;
        if (ua1Var != null) {
            ua1Var.i();
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
        View[] viewArr = this.E;
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null && view.getVisibility() == 0) {
                    view.setVisibility(4);
                }
            }
        }
        C0(this.A);
        int i = this.q - 1;
        this.Q = i;
        if (i > 0 && (textView = this.F) != null) {
            if (textView.getVisibility() != 0) {
                this.F.setVisibility(0);
            }
            this.F.setText(String.valueOf(this.Q));
        }
        GameBetCoinView[] gameBetCoinViewArr = this.H;
        if (gameBetCoinViewArr != null) {
            int length = gameBetCoinViewArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                GameBetCoinView gameBetCoinView = this.H[i2];
                if (gameBetCoinView != null && gameBetCoinView.getVisibility() != 0) {
                    gameBetCoinView.setVisibility(0);
                    gameBetCoinView.b(this.r[i2], this.s[i2]);
                }
            }
        }
        View view2 = this.B;
        if (view2 != null && view2.getVisibility() != 0) {
            this.B.setVisibility(0);
        }
        PokerView[] pokerViewArr = this.C;
        if (pokerViewArr != null) {
            for (PokerView pokerView : pokerViewArr) {
                if (pokerView != null) {
                    pokerView.g();
                }
            }
        }
        View[] viewArr2 = this.D;
        if (viewArr2 != null) {
            for (View view3 : viewArr2) {
                if (view3 != null) {
                    view3.startAnimation(this.N);
                }
            }
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            if (textView2.getVisibility() != 0) {
                this.u.setVisibility(0);
            }
            this.u.setText(c93.d);
            this.u.startAnimation(this.M);
        }
        Handler handler = this.P;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(104, 1000L);
            this.P.sendEmptyMessageDelayed(103, 1500L);
        }
        h0(0);
    }

    @Override // defpackage.m0
    public void e0(int i, JSONObject jSONObject) {
        if (this.n) {
            return;
        }
        lx1.c(this.b, "-----handleSocket--------->" + jSONObject.toJSONString());
        switch (i) {
            case 1:
                K0();
                return;
            case 2:
                I0();
                return;
            case 3:
                H0();
                return;
            case 4:
                G0(jSONObject);
                return;
            case 5:
                F0(jSONObject);
                return;
            case 6:
                J0(jSONObject);
                return;
            default:
                return;
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return v73.b;
    }

    @Override // defpackage.b1
    public void init() {
        this.u = (TextView) findViewById(z63.K);
        this.v = (TextView) findViewById(z63.i);
        this.w = findViewById(z63.G);
        this.z = zn0.a(150);
        this.A = zn0.a(90);
        this.B = findViewById(z63.x);
        PokerView[] pokerViewArr = new PokerView[3];
        this.C = pokerViewArr;
        pokerViewArr[0] = (PokerView) findViewById(z63.u);
        this.C[1] = (PokerView) findViewById(z63.v);
        this.C[2] = (PokerView) findViewById(z63.w);
        View[] viewArr = new View[3];
        this.D = viewArr;
        viewArr[0] = findViewById(z63.C);
        this.D[1] = findViewById(z63.D);
        this.D[2] = findViewById(z63.E);
        View[] viewArr2 = new View[3];
        this.E = viewArr2;
        viewArr2[0] = findViewById(z63.q);
        this.E[1] = findViewById(z63.r);
        this.E[2] = findViewById(z63.s);
        this.F = (TextView) findViewById(z63.j);
        GameBetCoinView[] gameBetCoinViewArr = new GameBetCoinView[3];
        this.H = gameBetCoinViewArr;
        gameBetCoinViewArr[0] = (GameBetCoinView) findViewById(z63.H);
        this.H[1] = (GameBetCoinView) findViewById(z63.I);
        this.H[2] = (GameBetCoinView) findViewById(z63.J);
        ImageView[] imageViewArr = new ImageView[3];
        this.I = imageViewArr;
        imageViewArr[0] = (ImageView) findViewById(z63.z);
        this.I[1] = (ImageView) findViewById(z63.A);
        this.I[2] = (ImageView) findViewById(z63.B);
        this.J = (ImageView) findViewById(z63.k);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.z, this.A);
        this.O = ofFloat;
        ofFloat.addUpdateListener(new b());
        this.O.setDuration(1000L);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.y = scaleAnimation;
        scaleAnimation.setDuration(300L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.04f, 1.0f, 1.04f, 1, 0.5f, 1, 1.0f);
        this.N = scaleAnimation2;
        scaleAnimation2.setRepeatCount(-1);
        this.N.setRepeatMode(2);
        this.N.setDuration(800L);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(4.0f, 1.0f, 4.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.K = scaleAnimation3;
        scaleAnimation3.setDuration(1000L);
        this.K.setRepeatCount(6);
        this.K.setRepeatMode(1);
        this.K.setInterpolator(new AccelerateInterpolator());
        this.K.setAnimationListener(new c());
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.M = scaleAnimation4;
        scaleAnimation4.setDuration(500L);
        ScaleAnimation scaleAnimation5 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.5f, 1, 0.5f);
        this.L = scaleAnimation5;
        scaleAnimation5.setDuration(500L);
        this.L.setAnimationListener(new d());
        this.P = new e();
        this.S = aq4.a(c93.h);
    }

    @Override // defpackage.m0
    public void k0(String str) {
        TextView textView = this.G;
        if (textView != null) {
            textView.setText(rv3.a(this.d, " ", str, "  "));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == z63.H) {
            A0(1);
            return;
        }
        if (id == z63.I) {
            A0(2);
            return;
        }
        if (id == z63.J) {
            A0(3);
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
        ya1.a("gameJinhuaCreate");
        ya1.a("gameJinhuaBet");
        ya1.a("gameSettle");
        super.release();
        Handler handler = this.P;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.P = null;
        ValueAnimator valueAnimator = this.O;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        TextView textView = this.v;
        if (textView != null) {
            textView.clearAnimation();
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            textView2.clearAnimation();
        }
        View[] viewArr = this.D;
        if (viewArr != null) {
            for (View view : viewArr) {
                if (view != null) {
                    view.clearAnimation();
                }
            }
        }
        ImageView[] imageViewArr = this.I;
        if (imageViewArr != null) {
            for (ImageView imageView : imageViewArr) {
                if (imageView != null) {
                    imageView.clearAnimation();
                }
            }
        }
        PokerView[] pokerViewArr = this.C;
        if (pokerViewArr != null) {
            for (PokerView pokerView : pokerViewArr) {
                if (pokerView != null) {
                    pokerView.f();
                }
            }
        }
        lx1.c(this.b, "---------release----------->");
    }

    public void z0() {
        if (this.j) {
            ya1.c(this.g, new f());
        }
    }
}
