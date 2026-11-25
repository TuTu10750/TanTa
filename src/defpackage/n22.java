package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.utils.SVGARect;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.live.bean.GlobalGiftBean;
import com.yunbao.live.bean.LiveGiftPrizePoolWinBean;
import com.yunbao.live.bean.LiveLuckGiftWinBean;
import com.yunbao.live.bean.LiveReceiveGiftBean;
import defpackage.kn1;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import pl.droidsonroids.gif.GifImageView;

/* loaded from: /tmp/classes2.dex */
public class n22 {
    public static boolean m0;
    public static ThreadPoolExecutor n0;
    public static final AtomicBoolean o0 = new AtomicBoolean(false);
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public k30 F;
    public int G;
    public int H;
    public int I;
    public int J;
    public LiveReceiveGiftBean K;
    public String L;
    public SVGAParser M;
    public File N;
    public int O;
    public long P;
    public ViewGroup Q;
    public t22 R;
    public w22 S;
    public ViewGroup T;
    public Animation U;
    public Animation V;
    public ViewGroup W;
    public FrameLayout X;
    public List Y;
    public Drawable Z;
    public Context a;
    public float a0;
    public ViewGroup b;
    public float b0;
    public ViewGroup c;
    public List c0;
    public SVGAImageView d;
    public int d0;
    public GifImageView e;
    public int e0;
    public pl.droidsonroids.gif.a f;
    public ScaleAnimation f0;
    public View g;
    public ScaleAnimation g0;
    public TextView h;
    public String h0;
    public ObjectAnimator i;
    public TextView i0;
    public ObjectAnimator j;
    public ObjectAnimator j0;
    public View k;
    public ObjectAnimator k0;
    public TextView[] l;
    public ObjectAnimator l0;
    public ObjectAnimator m;
    public ValueAnimator n;
    public ObjectAnimator o;
    public int p;
    public r22 q;
    public x22[] r;
    public ConcurrentLinkedQueue s;
    public ConcurrentLinkedQueue t;
    public ConcurrentLinkedQueue u;
    public ConcurrentLinkedQueue v;
    public ConcurrentLinkedQueue w;
    public Map x;
    public Handler y;
    public MediaController z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements kn1.a {
        public a() {
        }

        @Override // kn1.a
        public void onLoadFailed() {
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessage(-1);
            }
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            n22.this.L0(drawable);
            n22.this.e.setImageDrawable(drawable);
            n22.this.T0();
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessageDelayed(-1, 4000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements SVGAParser.ParseCompletion {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        public void onComplete(SVGAVideoEntity sVGAVideoEntity) {
            if (this.a != n22.this.O) {
                return;
            }
            n22.this.J0();
            n22.this.F0(sVGAVideoEntity);
        }

        public void onError() {
            if (this.a != n22.this.O) {
                return;
            }
            n22.this.J0();
            n22.this.I0();
            n22.this.v0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements kn1.a {
        public final /* synthetic */ float a;

        public c(float f) {
            this.a = f;
        }

        @Override // kn1.a
        public void onLoadFailed() {
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            if (drawable == null) {
                return;
            }
            n22.this.Z = drawable;
            if (n22.this.Y == null) {
                n22.this.Y = new ArrayList();
            }
            n22 n22Var = n22.this;
            n22Var.d0 = n22Var.c0.size();
            int size = n22.this.d0 - n22.this.Y.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    ImageView imageView = new ImageView(n22.this.a);
                    n22.this.X.addView(imageView);
                    n22.this.Y.add(imageView);
                }
            }
            n22 n22Var2 = n22.this;
            n22Var2.b0 = (n22Var2.a0 * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth();
            int i2 = 0;
            while (true) {
                int i3 = n22.this.d0;
                n22 n22Var3 = n22.this;
                if (i2 >= i3) {
                    n22Var3.e0 = 0;
                    n22.this.A0();
                    return;
                }
                ImageView imageView2 = (ImageView) n22Var3.Y.get(i2);
                PointF pointF = (PointF) n22.this.c0.get(i2);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView2.getLayoutParams();
                if (layoutParams == null) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (n22.this.a0 * 2.0f), (int) (n22.this.b0 * 2.0f));
                    layoutParams2.leftMargin = (int) ((pointF.x * this.a) - n22.this.a0);
                    layoutParams2.topMargin = (int) ((pointF.y * this.a) - n22.this.b0);
                    imageView2.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.width = (int) (n22.this.a0 * 2.0f);
                    layoutParams.height = (int) (n22.this.b0 * 2.0f);
                    layoutParams.leftMargin = (int) ((pointF.x * this.a) - n22.this.a0);
                    layoutParams.topMargin = (int) ((pointF.y * this.a) - n22.this.b0);
                    imageView2.requestLayout();
                }
                i2++;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            String str;
            n22.this.D = false;
            if (n22.this.w == null || (str = (String) n22.this.w.poll()) == null) {
                return;
            }
            n22.this.C0(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends AnimatorListenerAdapter {

        /* loaded from: /tmp/classes2.dex */
        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (n22.this.l0 == null || n22.this.i0 == null) {
                    return;
                }
                n22.this.l0.setFloatValues(0.0f, (-n22.this.G) - n22.this.i0.getWidth());
                n22.this.l0.start();
            }
        }

        public e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (n22.this.k0 == null) {
                n22 n22Var = n22.this;
                n22Var.k0 = ObjectAnimator.ofFloat(n22Var.i0, "translationX", n22.this.H, 0.0f);
                n22.this.k0.setDuration(1500L);
                n22.this.k0.addListener(new a());
            }
            n22.this.k0.start();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements SVGACallback {
        public f() {
        }

        public void onFinished() {
            long currentTimeMillis = 4000 - (System.currentTimeMillis() - n22.this.P);
            if (currentTimeMillis < 0) {
                currentTimeMillis = 0;
            }
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessageDelayed(-1, currentTimeMillis);
            }
        }

        public void onPause() {
        }

        public void onRepeat() {
        }

        public void onStep(int i, double d) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessageDelayed(-2, 2000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            n22.this.g.setAlpha(1.0f - valueAnimator.getAnimatedFraction());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessageDelayed(-3, 1200L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements ValueAnimator.AnimatorUpdateListener {
        public j() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * n22.this.p;
            n22.this.l[0].setTranslationX(-floatValue);
            n22.this.l[1].setTranslationX(n22.this.p - floatValue);
            n22.this.l[2].setTranslationX((n22.this.p * 2) - floatValue);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends AnimatorListenerAdapter {
        public k() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (n22.this.y != null) {
                n22.this.y.sendEmptyMessageDelayed(-4, 1200L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends AnimatorListenerAdapter {
        public l() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            GlobalGiftBean globalGiftBean;
            n22.this.k.setTranslationX(n22.this.J);
            n22.this.B = false;
            if (n22.this.u == null || (globalGiftBean = (GlobalGiftBean) n22.this.u.poll()) == null) {
                return;
            }
            n22.this.S0(globalGiftBean);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends Handler {
        public m() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveReceiveGiftBean liveReceiveGiftBean;
            int i = message.what;
            if (i == -1) {
                n22.this.I0();
                n22.this.N = null;
                n22.i(n22.this);
                if (n22.this.y != null) {
                    n22.this.y.removeMessages(-9);
                }
                n22.this.A = false;
                if (n22.this.e != null) {
                    n22.this.e.setImageDrawable(null);
                }
                if (n22.this.f != null && !n22.this.f.e()) {
                    n22.this.f.stop();
                    n22.this.f.f();
                    n22.this.f = null;
                }
                if (n22.this.d != null) {
                    n22.this.d.clear();
                }
                LiveReceiveGiftBean liveReceiveGiftBean2 = (LiveReceiveGiftBean) n22.this.t.poll();
                if (liveReceiveGiftBean2 != null) {
                    n22.this.Q0(liveReceiveGiftBean2);
                    return;
                }
                return;
            }
            if (i == -2) {
                n22.this.j.setFloatValues(0.0f, (-n22.this.G) - n22.this.g.getWidth());
                n22.this.j.start();
                return;
            }
            if (i == -3) {
                n22.this.n.start();
                return;
            }
            if (i == -4) {
                n22.this.o.start();
                return;
            }
            if (i == -5) {
                n22.this.A0();
                return;
            }
            if (i == -6) {
                if (n22.this.X != null) {
                    n22.this.X.startAnimation(n22.this.g0);
                }
                if (n22.this.q != null) {
                    n22.this.q.hide();
                }
                if (n22.this.y != null) {
                    n22.this.y.sendEmptyMessageDelayed(-7, 500L);
                    return;
                }
                return;
            }
            if (i == -7) {
                n22.this.t0();
                n22.this.C = false;
                if (n22.this.v == null || (liveReceiveGiftBean = (LiveReceiveGiftBean) n22.this.v.poll()) == null) {
                    return;
                }
                n22.this.P0(liveReceiveGiftBean);
                return;
            }
            if (i == -8) {
                if (message.arg1 == n22.this.O) {
                    lx1.c("SVGA", "decode svga timeout, retry later");
                    File file = n22.this.N;
                    n22.i(n22.this);
                    n22.this.I0();
                    MemoryPressureUtil.e();
                    MemoryPressureUtil.l();
                    n22.this.O0(file);
                    return;
                }
                return;
            }
            if (i == -9) {
                Object obj = message.obj;
                File file2 = obj instanceof File ? (File) obj : null;
                if (file2 != null && file2.equals(n22.this.N) && n22.this.A) {
                    n22.this.u0(file2);
                    return;
                }
                return;
            }
            x22 x22Var = n22.this.r[message.what];
            if (x22Var != null) {
                LiveReceiveGiftBean liveReceiveGiftBean3 = (LiveReceiveGiftBean) n22.this.s.poll();
                if (liveReceiveGiftBean3 == null) {
                    x22Var.hide();
                    return;
                }
                n22.this.x.remove(liveReceiveGiftBean3.getKey());
                x22Var.n0(liveReceiveGiftBean3, false);
                n22.this.K0(message.what);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n extends k30 {
        public n() {
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(File file) {
            n22 n22Var = n22.this;
            if (file != null) {
                n22Var.E0(file);
            } else {
                n22Var.v0();
            }
        }
    }

    static {
        y0();
    }

    public n22(Context context, View view, GifImageView gifImageView, SVGAImageView sVGAImageView, ViewGroup viewGroup) {
        y0();
        this.a = context;
        this.b = (ViewGroup) view.findViewById(b73.d2);
        this.c = (ViewGroup) view.findViewById(b73.g2);
        this.Q = (ViewGroup) view.findViewById(b73.P3);
        this.e = gifImageView;
        this.d = sVGAImageView;
        this.T = viewGroup;
        this.W = (ViewGroup) view.findViewById(b73.k5);
        this.d.setCallback(new f());
        this.g = view.findViewById(b73.a2);
        this.h = (TextView) view.findViewById(b73.Z1);
        this.X = (FrameLayout) view.findViewById(b73.K1);
        this.a0 = gk3.a().c() / 20.0f;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.5f, 1.0f, 1.5f, 1, 0.5f, 1, 0.5f);
        this.f0 = scaleAnimation;
        scaleAnimation.setDuration(100L);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 2.5f, 1.0f, 2.5f, 1, 0.5f, 1, 0.5f);
        this.g0 = scaleAnimation2;
        scaleAnimation2.setDuration(300L);
        this.i0 = (TextView) view.findViewById(b73.p2);
        this.g = view.findViewById(b73.a2);
        this.h = (TextView) view.findViewById(b73.Z1);
        int a2 = zn0.a(500);
        this.J = a2;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.g, "translationX", a2, 0.0f);
        this.i = ofFloat;
        ofFloat.setDuration(1000L);
        this.i.setInterpolator(new LinearInterpolator());
        this.i.addListener(new g());
        this.G = zn0.a(10);
        this.H = zn0.a(20);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.g, "translationX", 0.0f);
        this.j = ofFloat2;
        ofFloat2.setDuration(800L);
        this.j.setInterpolator(new AccelerateDecelerateInterpolator());
        this.j.addUpdateListener(new h());
        this.L = aq4.a(m93.D4);
        this.h0 = aq4.a(m93.r8);
        this.I = zn0.a(50);
        this.k = view.findViewById(b73.o2);
        TextView[] textViewArr = new TextView[3];
        this.l = textViewArr;
        textViewArr[0] = (TextView) view.findViewById(b73.l2);
        this.l[1] = (TextView) view.findViewById(b73.m2);
        this.l[2] = (TextView) view.findViewById(b73.n2);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.k, "translationX", this.J, 0.0f);
        this.m = ofFloat3;
        ofFloat3.setDuration(1000L);
        this.m.setInterpolator(linearInterpolator);
        this.m.addListener(new i());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 2.0f);
        this.n = ofFloat4;
        ofFloat4.setInterpolator(linearInterpolator);
        this.n.setDuration(4500L);
        this.n.addUpdateListener(new j());
        this.n.addListener(new k());
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.k, "alpha", 1.0f, 0.0f);
        this.o = ofFloat5;
        ofFloat5.setDuration(500L);
        this.o.setRepeatCount(3);
        this.o.addListener(new l());
        x22[] x22VarArr = new x22[2];
        this.r = x22VarArr;
        x22VarArr[0] = new x22(context, (ViewGroup) view.findViewById(b73.e2));
        this.r[0].addToParent();
        this.s = new ConcurrentLinkedQueue();
        this.t = new ConcurrentLinkedQueue();
        this.u = new ConcurrentLinkedQueue();
        this.v = new ConcurrentLinkedQueue();
        this.w = new ConcurrentLinkedQueue();
        this.x = new HashMap();
        this.y = new m();
        this.F = new n();
    }

    public static /* synthetic */ Thread a(final Runnable runnable) {
        Thread thread = new Thread(new Runnable() { // from class: l22
            @Override // java.lang.Runnable
            public final void run() {
                n22.c(runnable);
            }
        }, "SVGAParser-Serial");
        thread.setPriority(4);
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: m22
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread2, Throwable th) {
                n22.b(thread2, th);
            }
        });
        return thread;
    }

    public static /* synthetic */ void b(Thread thread, Throwable th) {
        if (th instanceof OutOfMemoryError) {
            x0();
            return;
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            defaultUncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    public static /* synthetic */ void c(Runnable runnable) {
        try {
            runnable.run();
        } catch (OutOfMemoryError unused) {
            x0();
        }
    }

    public static /* synthetic */ int i(n22 n22Var) {
        int i2 = n22Var.O;
        n22Var.O = i2 + 1;
        return i2;
    }

    public static void w0() {
        o0.set(false);
    }

    public static void x0() {
        w0();
        try {
            lx1.c("SVGA", "svga parser thread oom, clear memory and wait for retry");
        } catch (Throwable unused) {
        }
        MemoryPressureUtil.e();
        MemoryPressureUtil.l();
    }

    public static synchronized void y0() {
        synchronized (n22.class) {
            try {
                ThreadPoolExecutor threadPoolExecutor = n0;
                if (threadPoolExecutor != null) {
                    if (!threadPoolExecutor.isShutdown()) {
                        if (n0.isTerminated()) {
                        }
                        SVGAParser.Companion.setThreadPoolExecutor(n0);
                        m0 = true;
                    }
                }
                ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: k22
                    @Override // java.util.concurrent.ThreadFactory
                    public final Thread newThread(Runnable runnable) {
                        return n22.a(runnable);
                    }
                });
                n0 = threadPoolExecutor2;
                threadPoolExecutor2.allowCoreThreadTimeOut(true);
                SVGAParser.Companion.setThreadPoolExecutor(n0);
                m0 = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A0() {
        int i2 = this.e0;
        if (i2 < this.d0) {
            ImageView imageView = (ImageView) this.Y.get(i2);
            imageView.setImageDrawable(this.Z);
            imageView.startAnimation(this.f0);
            int i3 = this.e0 + 1;
            this.e0 = i3;
            int i4 = this.d0;
            Handler handler = this.y;
            if (i3 < i4) {
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(-5, 200L);
                }
            } else if (handler != null) {
                handler.sendEmptyMessageDelayed(-6, 500L);
            }
        }
    }

    public final void B0(LiveReceiveGiftBean liveReceiveGiftBean) {
        ConcurrentLinkedQueue concurrentLinkedQueue = this.t;
        if (concurrentLinkedQueue == null || liveReceiveGiftBean == null) {
            return;
        }
        concurrentLinkedQueue.offer(liveReceiveGiftBean);
    }

    public void C0(String str) {
        if (TextUtils.isEmpty(str) || this.i0 == null) {
            return;
        }
        if (this.D) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.w;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.offer(str);
                return;
            }
            return;
        }
        this.D = true;
        if (str.length() > 0) {
            str = rv3.a(str.substring(0, 1), "***", this.h0);
        }
        this.i0.setText(str);
        if (this.l0 == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.i0, "translationX", this.H);
            this.l0 = ofFloat;
            ofFloat.setDuration(1000L);
            this.l0.setInterpolator(new AccelerateDecelerateInterpolator());
            this.l0.addListener(new d());
        }
        if (this.j0 == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.i0, "translationX", this.J, this.H);
            this.j0 = ofFloat2;
            ofFloat2.setDuration(1000L);
            this.j0.setInterpolator(new LinearInterpolator());
            this.j0.addListener(new e());
        }
        this.j0.start();
    }

    public final void D0(File file) {
        try {
            pl.droidsonroids.gif.a aVar = new pl.droidsonroids.gif.a(file);
            this.f = aVar;
            aVar.i(1);
            L0(this.f);
            this.e.setImageDrawable(this.f);
            if (this.z == null) {
                MediaController mediaController = new MediaController(this.a);
                this.z = mediaController;
                mediaController.setVisibility(8);
            }
            this.z.setMediaPlayer((pl.droidsonroids.gif.a) this.e.getDrawable());
            this.z.setAnchorView(this.e);
            int duration = this.f.getDuration();
            this.z.show(duration);
            if (duration < 4000) {
                duration = 4000;
            }
            Handler handler = this.y;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(-1, duration);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            v0();
        } catch (OutOfMemoryError unused) {
            lx1.c("SVGA", "play gif oom, skip gift animation");
            v0();
        }
    }

    public final void E0(File file) {
        if (this.K.getGifType() != 0) {
            u0(file);
        } else {
            T0();
            D0(file);
        }
    }

    public final void F0(SVGAVideoEntity sVGAVideoEntity) {
        SVGAImageView sVGAImageView = this.d;
        if (sVGAImageView == null || sVGAVideoEntity == null) {
            v0();
            return;
        }
        try {
            sVGAImageView.clear();
            SVGARect videoSize = sVGAVideoEntity.getVideoSize();
            M0(videoSize.getWidth(), videoSize.getHeight());
            this.d.setImageDrawable(new SVGADrawable(sVGAVideoEntity));
            this.P = System.currentTimeMillis();
            this.d.startAnimation();
            T0();
        } catch (Exception e2) {
            e2.printStackTrace();
            v0();
        } catch (OutOfMemoryError unused) {
            lx1.c("SVGA", "play svga oom, retry later");
            I0();
            MemoryPressureUtil.e();
            MemoryPressureUtil.l();
            O0(this.N);
        }
    }

    public final boolean G0(File file) {
        try {
            SVGAImageView sVGAImageView = this.d;
            if (sVGAImageView != null) {
                sVGAImageView.clear();
            }
        } catch (Throwable unused) {
        }
        if (MemoryPressureUtil.h() == MemoryPressureUtil.Level.NORMAL) {
            return true;
        }
        lx1.c("SVGA", "svga low memory, available=" + MemoryPressureUtil.g() + ", file=" + file.length());
        MemoryPressureUtil.e();
        MemoryPressureUtil.l();
        return MemoryPressureUtil.h() != MemoryPressureUtil.Level.CRITICAL;
    }

    public void H0() {
        s0();
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.i.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator2 = this.j;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllListeners();
            this.j.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator3 = this.m;
        if (objectAnimator3 != null) {
            objectAnimator3.removeAllListeners();
            this.m.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.n.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator4 = this.o;
        if (objectAnimator4 != null) {
            objectAnimator4.removeAllListeners();
            this.o.removeAllUpdateListeners();
        }
        x22 x22Var = this.r[0];
        if (x22Var != null) {
            x22Var.release();
        }
        x22 x22Var2 = this.r[1];
        if (x22Var2 != null) {
            x22Var2.release();
        }
        SVGAImageView sVGAImageView = this.d;
        if (sVGAImageView != null) {
            sVGAImageView.setCallback((SVGACallback) null);
        }
        t22 t22Var = this.R;
        if (t22Var != null) {
            t22Var.release();
        }
        w22 w22Var = this.S;
        if (w22Var != null) {
            w22Var.release();
        }
        Animation animation = this.V;
        if (animation != null) {
            animation.cancel();
            this.V.setAnimationListener(null);
        }
        Animation animation2 = this.U;
        if (animation2 != null) {
            animation2.cancel();
            this.U.setAnimationListener(null);
        }
        r22 r22Var = this.q;
        if (r22Var != null) {
            r22Var.release();
        }
        ObjectAnimator objectAnimator5 = this.j0;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
            this.j0.removeAllListeners();
            this.j0.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator6 = this.k0;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
            this.k0.removeAllListeners();
            this.k0.removeAllUpdateListeners();
        }
        ObjectAnimator objectAnimator7 = this.l0;
        if (objectAnimator7 != null) {
            objectAnimator7.cancel();
            this.l0.removeAllListeners();
            this.l0.removeAllUpdateListeners();
        }
        this.d = null;
        this.F = null;
        this.y = null;
        this.R = null;
        this.S = null;
        this.j0 = null;
        this.k0 = null;
        this.l0 = null;
    }

    public final void I0() {
        if (this.E) {
            this.E = false;
            w0();
            J0();
        }
    }

    public final void J0() {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeMessages(-8);
        }
    }

    public final void K0(int i2) {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeMessages(i2);
            this.y.sendEmptyMessageDelayed(i2, 5000L);
        }
    }

    public final void L0(Drawable drawable) {
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.height = (int) ((this.e.getWidth() * intrinsicHeight) / intrinsicWidth);
        this.e.setLayoutParams(layoutParams);
    }

    public final void M0(double d2, double d3) {
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.height = (int) ((this.d.getWidth() * d3) / d2);
        this.d.setLayoutParams(layoutParams);
    }

    public final void N0(int i2) {
        Handler handler = this.y;
        if (handler != null) {
            handler.removeMessages(-8);
            Message obtain = Message.obtain();
            obtain.what = -8;
            obtain.arg1 = i2;
            this.y.sendMessageDelayed(obtain, 60000L);
        }
    }

    public final void O0(File file) {
        if (this.y == null || !z0(file)) {
            v0();
            return;
        }
        this.y.removeMessages(-9);
        Message obtain = Message.obtain();
        obtain.what = -9;
        obtain.obj = file;
        this.y.sendMessageDelayed(obtain, 2000L);
    }

    public final void P0(LiveReceiveGiftBean liveReceiveGiftBean) {
        if (liveReceiveGiftBean == null) {
            return;
        }
        if (this.C) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.v;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.offer(liveReceiveGiftBean);
                return;
            }
            return;
        }
        this.C = true;
        List<PointF> pointList = liveReceiveGiftBean.getPointList();
        this.c0 = pointList;
        if (pointList == null || pointList.size() <= 0) {
            return;
        }
        if (this.q == null) {
            r22 r22Var = new r22(this.a, this.c);
            this.q = r22Var;
            r22Var.addToParent();
        }
        this.q.h0(liveReceiveGiftBean);
        float drawWidth = liveReceiveGiftBean.getDrawWidth();
        float drawHeight = liveReceiveGiftBean.getDrawHeight();
        if (drawWidth <= 0.0f || drawHeight <= 0.0f) {
            return;
        }
        float c2 = gk3.a().c() / drawWidth;
        FrameLayout frameLayout = this.X;
        if (frameLayout != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
            layoutParams.width = gk3.a().c();
            layoutParams.height = (int) (drawHeight * c2);
            this.X.requestLayout();
        }
        kn1.j(this.a, liveReceiveGiftBean.getGiftIcon(), new c(c2));
    }

    public final void Q0(LiveReceiveGiftBean liveReceiveGiftBean) {
        String gifUrl = liveReceiveGiftBean.getGifUrl();
        lx1.b("gif礼物----->" + liveReceiveGiftBean.getGiftName() + "----->" + gifUrl);
        if (TextUtils.isEmpty(gifUrl)) {
            return;
        }
        if (this.A) {
            if (this.t != null) {
                B0(liveReceiveGiftBean);
                return;
            }
            return;
        }
        this.A = true;
        this.K = liveReceiveGiftBean;
        if (gifUrl.endsWith(".gif") || gifUrl.endsWith(".svga")) {
            tb1.a(fa2.a(gifUrl), gifUrl, this.F);
        } else {
            kn1.j(this.a, gifUrl, new a());
        }
    }

    public void R0(LiveReceiveGiftBean liveReceiveGiftBean) {
        if (liveReceiveGiftBean.getType() == 1) {
            Q0(liveReceiveGiftBean);
        } else if (liveReceiveGiftBean.getType() == 3) {
            P0(liveReceiveGiftBean);
        } else {
            V0(liveReceiveGiftBean);
        }
    }

    public void S0(GlobalGiftBean globalGiftBean) {
        if (this.B) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.u;
            if (concurrentLinkedQueue != null) {
                concurrentLinkedQueue.offer(globalGiftBean);
                return;
            }
            return;
        }
        this.B = true;
        String b2 = aq4.b(m93.T1, globalGiftBean.getUserName(), globalGiftBean.getLiveName(), globalGiftBean.getGiftName());
        this.l[0].setText(b2);
        this.l[1].setText(b2);
        this.l[2].setText(b2);
        this.l[0].measure(0, 0);
        this.p = this.I + this.l[0].getMeasuredWidth();
        this.l[0].setTranslationX(0.0f);
        this.l[1].setTranslationX(this.p);
        this.l[2].setTranslationX(this.p * 2);
        this.k.setAlpha(1.0f);
        this.m.start();
    }

    public final void T0() {
        LiveReceiveGiftBean liveReceiveGiftBean = this.K;
        if (liveReceiveGiftBean == null || liveReceiveGiftBean.getIsGlobal() != 0) {
            return;
        }
        this.h.setText(String.format(this.L, this.K.getUserNiceName(), this.K.getGiftName()));
        this.g.setAlpha(1.0f);
        this.i.start();
    }

    public void U0(LiveLuckGiftWinBean liveLuckGiftWinBean) {
        ViewGroup viewGroup = this.Q;
        if (viewGroup == null || liveLuckGiftWinBean == null) {
            return;
        }
        if (this.R == null) {
            t22 t22Var = new t22(this.a, viewGroup);
            this.R = t22Var;
            t22Var.addToParent();
        }
        this.R.g0(liveLuckGiftWinBean);
    }

    public final void V0(LiveReceiveGiftBean liveReceiveGiftBean) {
        boolean l0 = this.r[0].l0();
        x22[] x22VarArr = this.r;
        if (l0) {
            x22 x22Var = x22VarArr[1];
            if (x22Var == null || !x22Var.m0(liveReceiveGiftBean)) {
                this.r[0].n0(liveReceiveGiftBean, false);
                K0(0);
                return;
            } else {
                this.r[1].n0(liveReceiveGiftBean, true);
                K0(1);
                return;
            }
        }
        boolean m02 = x22VarArr[0].m0(liveReceiveGiftBean);
        x22[] x22VarArr2 = this.r;
        if (m02) {
            x22VarArr2[0].n0(liveReceiveGiftBean, true);
            K0(0);
            return;
        }
        if (x22VarArr2[1] == null) {
            x22VarArr2[1] = new x22(this.a, this.b);
            this.r[1].addToParent();
        }
        boolean l02 = this.r[1].l0();
        x22[] x22VarArr3 = this.r;
        if (l02) {
            x22VarArr3[1].n0(liveReceiveGiftBean, false);
            K0(1);
            return;
        }
        if (x22VarArr3[1].m0(liveReceiveGiftBean)) {
            this.r[1].n0(liveReceiveGiftBean, true);
            K0(1);
            return;
        }
        String key = liveReceiveGiftBean.getKey();
        boolean containsKey = this.x.containsKey(key);
        Map map = this.x;
        if (containsKey) {
            LiveReceiveGiftBean liveReceiveGiftBean2 = (LiveReceiveGiftBean) map.get(key);
            liveReceiveGiftBean2.setLianCount(liveReceiveGiftBean2.getLianCount() + 1);
        } else {
            map.put(key, liveReceiveGiftBean);
            this.s.offer(liveReceiveGiftBean);
        }
    }

    public void W0(LiveGiftPrizePoolWinBean liveGiftPrizePoolWinBean) {
        ViewGroup viewGroup = this.T;
        if (viewGroup == null) {
            return;
        }
        if (this.S == null) {
            w22 w22Var = new w22(this.a, viewGroup);
            this.S = w22Var;
            w22Var.addToParent();
        }
        this.S.j0(liveGiftPrizePoolWinBean);
    }

    public final boolean p0() {
        if (!o0.compareAndSet(false, true)) {
            return false;
        }
        this.E = true;
        return true;
    }

    public void q0() {
        s0();
        r0();
        View view = this.g;
        if (view != null) {
            float translationX = view.getTranslationX();
            int i2 = this.J;
            if (translationX != i2) {
                this.g.setTranslationX(i2);
            }
        }
        View view2 = this.k;
        if (view2 != null) {
            float translationX2 = view2.getTranslationX();
            int i3 = this.J;
            if (translationX2 != i3) {
                this.k.setTranslationX(i3);
            }
        }
    }

    public final void r0() {
        x22 x22Var = this.r[0];
        if (x22Var != null) {
            x22Var.j0();
        }
        x22 x22Var2 = this.r[1];
        if (x22Var2 != null) {
            x22Var2.j0();
        }
        r22 r22Var = this.q;
        if (r22Var != null) {
            r22Var.g0();
        }
    }

    public final void s0() {
        I0();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        CommonHttpUtil.cancel(CommonHttpConsts.DOWNLOAD_GIF);
        Handler handler = this.y;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ObjectAnimator objectAnimator = this.i;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.j;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        ObjectAnimator objectAnimator3 = this.m;
        if (objectAnimator3 != null) {
            objectAnimator3.cancel();
        }
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator4 = this.o;
        if (objectAnimator4 != null) {
            objectAnimator4.cancel();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.s;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue2 = this.t;
        if (concurrentLinkedQueue2 != null) {
            concurrentLinkedQueue2.clear();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue3 = this.u;
        if (concurrentLinkedQueue3 != null) {
            concurrentLinkedQueue3.clear();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue4 = this.v;
        if (concurrentLinkedQueue4 != null) {
            concurrentLinkedQueue4.clear();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue5 = this.w;
        if (concurrentLinkedQueue5 != null) {
            concurrentLinkedQueue5.clear();
        }
        Map map = this.x;
        if (map != null) {
            map.clear();
        }
        MediaController mediaController = this.z;
        if (mediaController != null) {
            mediaController.hide();
            this.z.setAnchorView(null);
        }
        GifImageView gifImageView = this.e;
        if (gifImageView != null) {
            gifImageView.setImageDrawable(null);
        }
        pl.droidsonroids.gif.a aVar = this.f;
        if (aVar != null && !aVar.e()) {
            this.f.stop();
            this.f.f();
            this.f = null;
        }
        SVGAImageView sVGAImageView = this.d;
        if (sVGAImageView != null) {
            sVGAImageView.stopAnimation(true);
            this.d.clear();
        }
        t22 t22Var = this.R;
        if (t22Var != null) {
            t22Var.f0();
        }
        w22 w22Var = this.S;
        if (w22Var != null) {
            w22Var.i0();
        }
        ObjectAnimator objectAnimator5 = this.j0;
        if (objectAnimator5 != null) {
            objectAnimator5.cancel();
        }
        ObjectAnimator objectAnimator6 = this.k0;
        if (objectAnimator6 != null) {
            objectAnimator6.cancel();
        }
        ObjectAnimator objectAnimator7 = this.l0;
        if (objectAnimator7 != null) {
            objectAnimator7.cancel();
        }
        TextView textView = this.i0;
        if (textView != null) {
            textView.setTranslationX(this.J);
        }
        t0();
    }

    public final void t0() {
        List list = this.Y;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ImageView imageView : this.Y) {
            imageView.clearAnimation();
            imageView.setImageDrawable(null);
        }
    }

    public final void u0(File file) {
        if (!z0(file)) {
            v0();
            return;
        }
        this.N = file;
        if (!G0(file)) {
            O0(file);
            return;
        }
        y0();
        if (!p0()) {
            lx1.c("SVGA", "svga decode busy, retry later");
            O0(file);
            return;
        }
        if (this.M == null) {
            this.M = new SVGAParser(this.a);
        }
        int i2 = this.O + 1;
        this.O = i2;
        b bVar = new b(i2);
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            N0(i2);
            this.M.decodeFromInputStream(bufferedInputStream, file.getAbsolutePath(), bVar, true, (SVGAParser.PlayCallback) null, (String) null);
        } catch (Exception e2) {
            J0();
            I0();
            e2.printStackTrace();
            v0();
        } catch (OutOfMemoryError unused) {
            J0();
            I0();
            lx1.c("SVGA", "decode svga oom, retry later");
            MemoryPressureUtil.e();
            MemoryPressureUtil.l();
            O0(file);
        }
    }

    public final void v0() {
        I0();
        Handler handler = this.y;
        if (handler == null) {
            this.A = false;
            return;
        }
        handler.removeMessages(-1);
        this.y.removeMessages(-9);
        this.y.sendEmptyMessage(-1);
    }

    public final boolean z0(File file) {
        return file != null && file.exists() && file.length() > 0;
    }
}
