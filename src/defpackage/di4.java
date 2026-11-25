package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.media3.common.k;
import androidx.media3.common.p;
import androidx.media3.common.y;
import androidx.media3.ui.PlayerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.video.bean.VideoBean;
import java.util.HashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class di4 extends b1 implements View.OnClickListener {
    public static boolean v = false;
    public Map a;
    public String b;
    public PlayerView c;
    public View d;
    public nw0 e;
    public boolean f;
    public boolean g;
    public d h;
    public View i;
    public ObjectAnimator j;
    public boolean k;
    public boolean l;
    public VideoBean m;
    public boolean n;
    public boolean o;
    public Runnable p;
    public m30 q;
    public k30 r;
    public k30 s;
    public Handler t;
    public Runnable u;

    /* loaded from: /tmp/classes2.dex */
    public class a implements p.d {
        public a() {
        }

        public void E(int i) {
            if (i == 2) {
                if (di4.this.h != null) {
                    di4.this.h.t();
                    return;
                }
                return;
            }
            if (i != 3) {
                if (i == 4 && !di4.this.l) {
                    di4.this.l = true;
                    if (di4.this.m != null) {
                        zh4.r(di4.this.m.getUid(), di4.this.m.getId());
                        return;
                    }
                    return;
                }
                return;
            }
            di4.this.k = true;
            di4.this.n = false;
            di4.this.t.post(di4.this.u);
            if (di4.this.h != null) {
                di4.this.h.s();
                di4.this.h.I();
            }
            if (di4.this.f && di4.this.e != null) {
                di4.this.e.pause();
            }
            if (di4.this.d == null || di4.this.d.getVisibility() != 0) {
                return;
            }
            di4.this.d.setVisibility(4);
        }

        public void i(y yVar) {
            di4.this.A0(yVar.a, yVar.b);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (di4.this.e == null || di4.this.e.f() != 3 || di4.this.n) {
                return;
            }
            long currentPosition = di4.this.e.getCurrentPosition();
            long duration = di4.this.e.getDuration();
            if (di4.this.q != null) {
                di4.this.q.a((int) duration, Integer.valueOf((int) currentPosition));
            }
            di4.this.t.postDelayed(this, 500L);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if ((i == 0 || i == 40019) && strArr.length > 0) {
                if (di4.this.r != null) {
                    di4.this.r.a(strArr[0]);
                }
                if (JSON.parseObject(strArr[0]).getIntValue("is_play") != 1) {
                    di4.this.o = true;
                    boolean unused = di4.v = true;
                    di4.this.B0();
                    di4.this.K0();
                    di4.this.g = true;
                    return;
                }
                if (di4.v) {
                    boolean unused2 = di4.v = false;
                    di4.this.o = false;
                    di4.this.g = false;
                    di4.this.z0();
                    di4.this.e.h();
                    if (di4.this.s != null) {
                        di4.this.s.a(1);
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface d {
        void I();

        void s();

        void t();
    }

    public di4(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.a = new HashMap();
        this.n = false;
        this.o = false;
        this.t = new Handler(Looper.getMainLooper());
        this.u = new b();
    }

    public void A0(float f, float f2) {
        PlayerView playerView = this.c;
        if (playerView == null || f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) playerView.getLayoutParams();
        int width = f / f2 > 0.5625f ? (int) ((this.c.getWidth() / f) * f2) : -1;
        if (width != layoutParams.height) {
            layoutParams.height = width;
            this.c.requestLayout();
        }
    }

    public void B0() {
        nw0 nw0Var;
        this.f = true;
        if (this.g || (nw0Var = this.e) == null) {
            return;
        }
        nw0Var.pause();
    }

    public final void C0() {
        MemoryPressureUtil.Level c2 = pg4.c();
        if (c2 == MemoryPressureUtil.Level.CRITICAL) {
            w0("before play");
            MemoryPressureUtil.l();
        } else if (c2 == MemoryPressureUtil.Level.LOW) {
            MemoryPressureUtil.l();
        }
    }

    public void D0() {
        nw0 nw0Var;
        if (this.f && !this.g && (nw0Var = this.e) != null) {
            nw0Var.h();
        }
        this.f = false;
    }

    public void E0(d dVar) {
        this.h = dVar;
    }

    public void F0(int i) {
        if (this.e != null) {
            Log.d("ExoPlayer", "Manual seek to: " + i);
            this.n = true;
            this.t.removeCallbacks(this.u);
            this.e.seekTo(i * IjkMediaCodecInfo.RANK_MAX);
            if (!this.e.c()) {
                this.e.h();
            }
        }
        if (this.g) {
            this.g = false;
            z0();
        }
    }

    public void G0(Runnable runnable) {
        this.p = runnable;
    }

    public void H0(k30 k30Var) {
        this.s = k30Var;
    }

    public void I0(m30 m30Var) {
        this.q = m30Var;
    }

    public void J0(k30 k30Var) {
        this.r = k30Var;
    }

    public final void K0() {
        View view = this.i;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.i.setVisibility(0);
    }

    public void L0(VideoBean videoBean) {
        M0(videoBean, true);
    }

    public void M0(VideoBean videoBean, boolean z) {
        this.k = false;
        this.g = false;
        this.l = false;
        this.n = false;
        this.o = v;
        this.m = videoBean;
        this.f = !z;
        View view = this.d;
        if (view != null && view.getVisibility() != 0) {
            this.d.setVisibility(0);
        }
        this.t.removeCallbacksAndMessages(null);
        z0();
        if (videoBean == null) {
            return;
        }
        String href = videoBean.getHref();
        this.b = href;
        if (TextUtils.isEmpty(href)) {
            return;
        }
        C0();
        k.c h = new k.c().h(this.b);
        if (this.b.contains(".m3u8")) {
            h.d("application/x-mpegURL");
        }
        this.e.J(h.a(), this.a.containsKey(videoBean.getId()) ? ((Integer) this.a.get(r5)).intValue() : 0L);
        this.e.a();
        lx1.c("9990", "mPaused:" + this.f);
        if (this.f) {
            nw0 nw0Var = this.e;
            if (nw0Var != null) {
                nw0Var.pause();
                return;
            }
            return;
        }
        if (!this.o) {
            this.e.h();
            k30 k30Var = this.s;
            if (k30Var != null) {
                k30Var.a(1);
            }
            O0();
            return;
        }
        K0();
        this.g = true;
        Runnable runnable = this.p;
        if (runnable != null) {
            runnable.run();
        }
        O0();
    }

    public void N0() {
        VideoBean videoBean;
        if (this.e == null || (videoBean = this.m) == null) {
            return;
        }
        this.a.put(videoBean.getId(), Integer.valueOf((int) this.e.getCurrentPosition()));
        try {
            this.e.stop();
            this.e.m();
        } catch (OutOfMemoryError unused) {
            w0("stopPlay oom");
        } catch (RuntimeException e) {
            lx1.c("ExoPlayer", "stopPlay failed--->" + e.getMessage());
        }
    }

    public final void O0() {
        zh4.s(this.m.getUid(), this.m.getId(), new c());
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return b83.v;
    }

    @Override // defpackage.b1
    public void init() {
        androidx.media3.exoplayer.source.d k = new androidx.media3.exoplayer.source.d(this.mContext).k(pg4.i(this.mContext));
        nw0 g = new b(this.mContext).i(k).h(new a().c(2500, 10000, 500, IjkMediaCodecInfo.RANK_MAX).b(0, false).d(true).a()).g();
        this.e = g;
        g.y(al3.d);
        PlayerView findViewById = findViewById(f73.e0);
        this.c = findViewById;
        findViewById.setPlayer(this.e);
        this.c.setUseController(false);
        this.e.d(true);
        this.e.P(2);
        this.e.g(2);
        this.e.T(new a());
        findViewById(f73.Q).setOnClickListener(this);
        this.d = findViewById(f73.c0);
        View findViewById2 = findViewById(f73.p);
        this.i = findViewById2;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(findViewById2, PropertyValuesHolder.ofFloat("scaleX", 4.0f, 0.8f, 1.0f), PropertyValuesHolder.ofFloat("scaleY", 4.0f, 0.8f, 1.0f), PropertyValuesHolder.ofFloat("alpha", 0.0f, 1.0f));
        this.j = ofPropertyValuesHolder;
        ofPropertyValuesHolder.setDuration(150L);
        this.j.setInterpolator(new AccelerateInterpolator());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == f73.Q) {
            y0();
        }
    }

    @Override // defpackage.b1
    public void release() {
        zh4.a("videoWatchStart");
        zh4.a("videoWatchEnd");
        this.t.removeCallbacksAndMessages(null);
        View view = this.c;
        nw0 nw0Var = this.e;
        this.c = null;
        this.e = null;
        if (view != null) {
            try {
                view.setPlayer((p) null);
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(view);
                }
            } catch (Exception unused) {
            }
        }
        if (nw0Var != null) {
            try {
                nw0Var.stop();
                nw0Var.m();
            } catch (RuntimeException unused2) {
            }
            nw0Var.release();
        }
        this.h = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.p = null;
    }

    public final void w0(String str) {
        try {
            pg4.s();
        } catch (Throwable unused) {
        }
        MemoryPressureUtil.e();
        lx1.c("ExoPlayer", "trim playback memory: " + str + ", available=" + MemoryPressureUtil.g());
    }

    public final void y0() {
        nw0 nw0Var;
        if (!this.k || (nw0Var = this.e) == null) {
            return;
        }
        if (this.o) {
            Runnable runnable = this.p;
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        if (this.g) {
            nw0Var.h();
            k30 k30Var = this.s;
            if (k30Var != null) {
                k30Var.a(1);
            }
            z0();
        } else {
            nw0Var.pause();
            k30 k30Var2 = this.s;
            if (k30Var2 != null) {
                k30Var2.a(0);
            }
            K0();
            ObjectAnimator objectAnimator = this.j;
            if (objectAnimator != null) {
                objectAnimator.start();
            }
        }
        this.g = !this.g;
    }

    public final void z0() {
        View view = this.i;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.i.setVisibility(4);
    }
}
