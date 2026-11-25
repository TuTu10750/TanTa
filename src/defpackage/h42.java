package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.ijkplay.IjkVideoView;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class h42 extends d52 {
    public ViewGroup a;
    public ViewGroup b;
    public ViewGroup c;
    public ViewGroup d;
    public ViewGroup e;
    public IjkVideoView f;
    public View g;
    public ImageView h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public String m;
    public Handler n;
    public int o;
    public float p;
    public float q;
    public int r;
    public boolean s;
    public boolean t;
    public boolean u;
    public Runnable v;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h42 h42Var = h42.this;
            h42Var.r = h42Var.a.getHeight();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            JSONObject parseObject;
            if (i != 0 || strArr.length <= 0 || (parseObject = JSON.parseObject(strArr[0])) == null) {
                return;
            }
            String string = parseObject.getString("streamUrlWithSignature");
            if (TextUtils.isEmpty(string)) {
                return;
            }
            lx1.c("LiveTxPlayViewHolder", "低延时流----->" + string);
            if (h42.this.f != null) {
                h42.this.E0(string);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h42.this.f == null || !h42.this.f.isPlaying()) {
                if (h42.this.n != null) {
                    h42.this.n.postDelayed(this, 3000L);
                    return;
                }
                return;
            }
            try {
                IMediaPlayer mediaPlayer = h42.this.f.getMediaPlayer();
                if (mediaPlayer instanceof IjkMediaPlayer) {
                    IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) mediaPlayer;
                    long max = Math.max(ijkMediaPlayer.getVideoCachedDuration(), ijkMediaPlayer.getAudioCachedDuration());
                    if (max > 4000) {
                        ijkMediaPlayer.setSpeed(1.5f);
                    } else if (max > 2000) {
                        ijkMediaPlayer.setSpeed(1.2f);
                    } else {
                        ijkMediaPlayer.setSpeed(1.0f);
                    }
                }
            } catch (Exception unused) {
            }
            if (h42.this.n != null) {
                h42.this.n.postDelayed(this, 3000L);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements Runnable {
        public final /* synthetic */ boolean a;

        public d(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            h42.this.l = this.a;
            h42.this.F0(this.a);
        }
    }

    public h42(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.o = 0;
        this.t = false;
        this.u = true;
    }

    public static /* synthetic */ boolean m0(h42 h42Var, IMediaPlayer iMediaPlayer, int i, int i2) {
        h42Var.getClass();
        if (i == 3) {
            lx1.a("ijk", "真正开始播放");
            View view = h42Var.g;
            if (view != null) {
                view.setVisibility(4);
            }
            h42Var.t = true;
            h42Var.o = 0;
            if (h42Var.u) {
                h42Var.C0();
                return true;
            }
        } else if (i == 701) {
            lx1.a("ijk", "卡顿中...");
            View view2 = h42Var.g;
            if (view2 != null) {
                view2.setVisibility(0);
                return true;
            }
        } else if (i == 702) {
            lx1.a("ijk", "恢复播放");
            View view3 = h42Var.g;
            if (view3 != null) {
                view3.setVisibility(4);
            }
        }
        return true;
    }

    public static /* synthetic */ void n0(h42 h42Var, IMediaPlayer iMediaPlayer, int i) {
        h42Var.getClass();
        lx1.a("ijk", "缓冲进度: " + i + "%");
        View view = h42Var.g;
        if (view == null || view.getVisibility() == 0 || h42Var.t) {
            return;
        }
        h42Var.g.setVisibility(0);
    }

    public static /* synthetic */ boolean q0(final h42 h42Var, IMediaPlayer iMediaPlayer, int i, int i2) {
        String str;
        h42Var.getClass();
        lx1.c("ijk", "播放出错 what=" + i + " extra=" + i2 + " retryCount=" + h42Var.o);
        if (h42Var.o >= 3 || (str = h42Var.m) == null || str.isEmpty()) {
            t54.b(aq4.a(m93.q4));
            return true;
        }
        int i3 = h42Var.o;
        h42Var.o = i3 + 1;
        int min = (int) Math.min(Math.pow(2.0d, i3) * 1000.0d, 10000.0d);
        lx1.c("ijk", "播放重连第 " + h42Var.o + " 次，" + min + "ms 后重试");
        if (h42Var.n == null) {
            h42Var.n = new Handler();
        }
        h42Var.n.postDelayed(new Runnable() { // from class: g42
            @Override // java.lang.Runnable
            public final void run() {
                r0.E0(h42.this.m);
            }
        }, min);
        return true;
    }

    public final void A0(boolean z) {
        float min;
        float max;
        lx1.c("0099", "changeVideoSize:" + z);
        float f = this.p;
        if (f > 0.0f) {
            float f2 = this.q;
            if (f2 > 0.0f) {
                float f3 = f / f2;
                float width = this.mParentView.getWidth();
                float height = this.mParentView.getHeight();
                if (z) {
                    min = Math.max(width, height);
                    max = Math.min(width, height);
                } else {
                    min = Math.min(width, height);
                    max = Math.max(width, height);
                }
                float f4 = min / max;
                if (f3 != f4) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                    if (f3 <= 0.625f || f3 <= f4) {
                        layoutParams.width = (int) (max * f3);
                        layoutParams.height = -1;
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.width = -1;
                        layoutParams.height = (int) (min / f3);
                        layoutParams.gravity = 17;
                    }
                    this.f.requestLayout();
                    ((LiveAudienceActivity) this.mContext).N3(layoutParams.height, this.r);
                }
            }
        }
    }

    public final void B0() {
        this.f.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: c42
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public final void onPrepared(IMediaPlayer iMediaPlayer) {
                lx1.a("ijk", "准备完成");
            }
        });
        this.f.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() { // from class: d42
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                h42.n0(h42.this, iMediaPlayer, i);
            }
        });
        this.f.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: e42
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                return h42.m0(h42.this, iMediaPlayer, i, i2);
            }
        });
        this.f.setOnErrorListener(new IMediaPlayer.OnErrorListener() { // from class: f42
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
            public final boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
                return h42.q0(h42.this, iMediaPlayer, i, i2);
            }
        });
    }

    public void C0() {
        ImageView imageView = this.h;
        if (imageView == null || imageView.getAlpha() == 0.0f) {
            return;
        }
        lx1.c("LiveTxPlayViewHolder", "隐藏封面---hideCover--->");
        this.h.animate().alpha(0.0f).setDuration(500L).start();
    }

    public void D0(boolean z) {
        if (z) {
            e32.h0(((LiveActivity) this.mContext).F1(), ((LiveActivity) this.mContext).G1(), new b());
        } else if (this.f != null) {
            E0(this.m);
        }
    }

    public final void E0(String str) {
        try {
            if (this.f.isPlaying()) {
                this.f.a0();
            }
            this.f.setVideoURI(Uri.parse(str));
            this.f.start();
            H0();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void F0(boolean z) {
        IjkVideoView ijkVideoView = this.f;
        if (!z) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ijkVideoView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            layoutParams.gravity = 17;
            this.f.setLayoutParams(layoutParams);
            return;
        }
        if (ijkVideoView == null || this.c == null) {
            return;
        }
        ViewParent parent = ijkVideoView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        this.f.setLayoutParams(layoutParams2);
        this.c.addView(this.f);
    }

    public void G0() {
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setAlpha(1.0f);
            if (this.h.getVisibility() != 0) {
                this.h.setVisibility(0);
            }
        }
    }

    public final void H0() {
        if (this.n == null) {
            this.n = new Handler();
        }
        Runnable runnable = this.v;
        if (runnable != null) {
            this.n.removeCallbacks(runnable);
        }
        c cVar = new c();
        this.v = cVar;
        this.n.postDelayed(cVar, 5000L);
    }

    @Override // defpackage.nh1
    public ViewGroup K() {
        return this.d;
    }

    @Override // defpackage.nh1
    public void U() {
        lx1.c("0099", "changeToLeft");
        this.k = true;
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView == null || this.c == null) {
            return;
        }
        ViewParent parent = ijkVideoView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f.setLayoutParams(layoutParams);
        this.c.addView(this.f);
    }

    @Override // defpackage.nh1
    public ViewGroup V() {
        return this.e;
    }

    @Override // defpackage.nh1
    public ViewGroup Z() {
        return this.b;
    }

    @Override // defpackage.d52
    public void a0(boolean z) {
        if (this.s) {
            z0(z);
        } else {
            A0(z);
        }
    }

    @Override // defpackage.d52
    public void b0(boolean z) {
        this.u = z;
    }

    @Override // defpackage.d52
    public void d0() {
        if (this.j) {
            return;
        }
        lx1.c("LiveTxPlayViewHolder", "暂停播放1111");
        this.j = true;
        if (!this.i) {
            this.f.pause();
        }
        G0();
    }

    @Override // defpackage.d52
    public void e0(String str) {
        lx1.c("LiveTxPlayViewHolder", "play------url----->" + str);
        this.s = false;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            if (!str.startsWith("trtc://") && !str.startsWith("rtmp://") && !str.startsWith("http://") && !str.startsWith("https://")) {
                return;
            }
            this.s = true;
            lx1.c("LiveTxPlayViewHolder", "开始播放");
            this.m = str;
            E0(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // defpackage.d52
    public void g0(String str) {
        e0(str);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.f2;
    }

    @Override // defpackage.d52
    public void h0() {
        if (this.j) {
            this.j = false;
            if (!this.i) {
                this.f.start();
            }
            C0();
        }
    }

    @Override // defpackage.d52
    public void i0(boolean z, int i) {
        lx1.c("0099", "林买");
        if (this.f == null) {
            return;
        }
        if (i < 0) {
            i = 0;
        }
        if (i <= 0) {
            this.l = z;
            F0(z);
        } else {
            if (this.n == null) {
                this.n = new Handler();
            }
            this.n.postDelayed(new d(z), i);
        }
    }

    @Override // defpackage.b1
    public void init() {
        ViewGroup viewGroup = (ViewGroup) findViewById(b73.L4);
        this.a = viewGroup;
        viewGroup.post(new a());
        this.b = (ViewGroup) findViewById(b73.X4);
        this.c = (ViewGroup) findViewById(b73.y3);
        this.d = (ViewGroup) findViewById(b73.I4);
        this.e = (ViewGroup) findViewById(b73.p4);
        this.g = findViewById(b73.M3);
        this.h = (ImageView) findViewById(b73.F1);
        this.f = (IjkVideoView) findViewById(b73.G3);
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        layoutParams.height = (int) ((gk3.a().c() / 1080.0f) * 960.0f);
        this.e.setLayoutParams(layoutParams);
        B0();
    }

    @Override // defpackage.d52
    public void j0(String str) {
        ImageView imageView = this.h;
        if (imageView != null) {
            kn1.h(this.mContext, str, imageView);
        }
    }

    @Override // defpackage.d52
    public void k0() {
        this.k = false;
        this.l = false;
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ImageView imageView = this.h;
        if (imageView != null) {
            imageView.setAlpha(1.0f);
            if (this.h.getVisibility() != 0) {
                this.h.setVisibility(0);
            }
        }
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView != null) {
            ijkVideoView.a0();
        }
    }

    @Override // defpackage.nh1
    public void n() {
        lx1.c("0099", "changeToBig");
        this.k = false;
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView == null || this.a == null) {
            return;
        }
        ViewParent parent = ijkVideoView.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f.setLayoutParams(layoutParams);
        this.a.addView(this.f, 0);
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onPause() {
        IjkVideoView ijkVideoView;
        if (!this.j && (ijkVideoView = this.f) != null) {
            ijkVideoView.pause();
        }
        this.i = true;
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        IjkVideoView ijkVideoView;
        if (!this.j && this.i && (ijkVideoView = this.f) != null) {
            ijkVideoView.Y();
        }
        this.i = false;
    }

    @Override // defpackage.d52, defpackage.b1
    public void release() {
        Handler handler = this.n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.n = null;
        e32.f("getTxLinkMicAccUrl");
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView != null) {
            ijkVideoView.W(true);
        }
        lx1.c("LiveTxPlayViewHolder", "release------->");
    }

    public final void z0(boolean z) {
        float min;
        float max;
        lx1.c("0099", "changeLiveSize:" + z);
        float f = this.p;
        if (f > 0.0f) {
            float f2 = this.q;
            if (f2 > 0.0f) {
                float f3 = f / f2;
                float width = this.mParentView.getWidth();
                float height = this.mParentView.getHeight();
                if (z) {
                    min = Math.max(width, height);
                    max = Math.min(width, height);
                } else {
                    min = Math.min(width, height);
                    max = Math.max(width, height);
                }
                float f4 = min / max;
                if (f3 != f4) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f.getLayoutParams();
                    if (f3 <= 0.625f || f3 <= f4) {
                        layoutParams.width = (int) (max * f3);
                        layoutParams.height = -1;
                        layoutParams.gravity = 17;
                    } else {
                        layoutParams.width = -1;
                        layoutParams.height = (int) (min / f3);
                        layoutParams.gravity = 17;
                    }
                    this.f.requestLayout();
                    if (this.l) {
                        return;
                    }
                    ((LiveAudienceActivity) this.mContext).N3(layoutParams.height, this.r);
                }
            }
        }
    }
}
