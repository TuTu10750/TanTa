package com.yunbao.common.ijkplay;

import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.TableLayout;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.ijkplay.a;
import defpackage.lx1;
import defpackage.m93;
import defpackage.mo1;
import defpackage.qy2;
import defpackage.wh1;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tv.danmaku.ijk.media.exo.IjkExoMediaPlayer;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.IjkTimedText;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;

/* loaded from: /tmp/classes2.dex */
public class IjkVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    public static final int[] f0 = {0, 1, 2, 4, 5};
    public int A;
    public int B;
    public mo1 C;
    public long D;
    public long E;
    public long F;
    public long G;
    public TextView H;
    public IMediaPlayer.OnVideoSizeChangedListener I;
    public IMediaPlayer.OnPreparedListener J;
    public IMediaPlayer.OnCompletionListener K;
    public IMediaPlayer.OnInfoListener L;
    public IMediaPlayer.OnErrorListener M;
    public IMediaPlayer.OnBufferingUpdateListener N;
    public IMediaPlayer.OnSeekCompleteListener O;
    public IMediaPlayer.OnTimedTextListener P;
    public a.InterfaceC0030a Q;
    public int R;
    public int S;
    public List T;
    public int U;
    public int V;
    public boolean W;
    public String a;
    public Uri b;
    public Map c;
    public int d;
    public int e;
    public a.b f;
    public IMediaPlayer g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public wh1 m;
    public IMediaPlayer.OnCompletionListener n;
    public IMediaPlayer.OnPreparedListener o;
    public int p;
    public IMediaPlayer.OnErrorListener q;
    public IMediaPlayer.OnInfoListener r;
    public IMediaPlayer.OnBufferingUpdateListener s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public Context x;
    public CommonAppContext y;
    public com.yunbao.common.ijkplay.a z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements IMediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(IMediaPlayer iMediaPlayer, int i, int i2, int i3, int i4) {
            lx1.c("0099", "onVideoSizeChanged:width:" + i + "  height:" + i2);
            IjkVideoView.this.h = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.i = iMediaPlayer.getVideoHeight();
            IjkVideoView.this.A = iMediaPlayer.getVideoSarNum();
            IjkVideoView.this.B = iMediaPlayer.getVideoSarDen();
            if (IjkVideoView.this.h == 0 || IjkVideoView.this.i == 0) {
                return;
            }
            if (IjkVideoView.this.z != null) {
                IjkVideoView.this.z.setAspectRatio(IjkVideoView.this.h > IjkVideoView.this.i ? 0 : 1);
                IjkVideoView.this.z.a(IjkVideoView.this.h, IjkVideoView.this.i);
                IjkVideoView.this.z.c(IjkVideoView.this.A, IjkVideoView.this.B);
            }
            IjkVideoView.this.requestLayout();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements IMediaPlayer.OnPreparedListener {
        public b() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        public void onPrepared(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.E = System.currentTimeMillis();
            if (IjkVideoView.this.C != null) {
                IjkVideoView.this.C.n(IjkVideoView.this.E - IjkVideoView.this.D);
            }
            IjkVideoView.this.d = 2;
            if (IjkVideoView.this.o != null) {
                IjkVideoView.this.o.onPrepared(IjkVideoView.this.g);
            }
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.setEnabled(true);
            }
            IjkVideoView.this.h = iMediaPlayer.getVideoWidth();
            IjkVideoView.this.i = iMediaPlayer.getVideoHeight();
            int i = IjkVideoView.this.t;
            if (i != 0) {
                IjkVideoView.this.seekTo(i);
            }
            if (IjkVideoView.this.h == 0 || IjkVideoView.this.i == 0) {
                if (IjkVideoView.this.e == 3) {
                    IjkVideoView.this.start();
                    return;
                }
                return;
            }
            if (IjkVideoView.this.z != null) {
                IjkVideoView.this.z.a(IjkVideoView.this.h, IjkVideoView.this.i);
                IjkVideoView.this.z.c(IjkVideoView.this.A, IjkVideoView.this.B);
                if (!IjkVideoView.this.z.d() || (IjkVideoView.this.j == IjkVideoView.this.h && IjkVideoView.this.k == IjkVideoView.this.i)) {
                    int i2 = IjkVideoView.this.e;
                    IjkVideoView ijkVideoView = IjkVideoView.this;
                    if (i2 == 3) {
                        ijkVideoView.start();
                        if (IjkVideoView.this.m != null) {
                            IjkVideoView.this.m.show();
                            return;
                        }
                        return;
                    }
                    if (ijkVideoView.isPlaying()) {
                        return;
                    }
                    if ((i != 0 || IjkVideoView.this.getCurrentPosition() > 0) && IjkVideoView.this.m != null) {
                        IjkVideoView.this.m.show(0);
                    }
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements IMediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.d = 5;
            IjkVideoView.this.e = 5;
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.hide();
            }
            if (IjkVideoView.this.n != null) {
                IjkVideoView.this.n.onCompletion(IjkVideoView.this.g);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements IMediaPlayer.OnInfoListener {
        public d() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
            if (IjkVideoView.this.r != null) {
                IjkVideoView.this.r.onInfo(iMediaPlayer, i, i2);
            }
            if (i == 3) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_VIDEO_RENDERING_START:");
                return true;
            }
            if (i == 901) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_UNSUPPORTED_SUBTITLE:");
                return true;
            }
            if (i == 902) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_SUBTITLE_TIMED_OUT:");
                return true;
            }
            if (i == 10001) {
                IjkVideoView.this.l = i2;
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_VIDEO_ROTATION_CHANGED: " + i2);
                if (IjkVideoView.this.z == null) {
                    return true;
                }
                IjkVideoView.this.z.setVideoRotation(i2);
                return true;
            }
            if (i == 10002) {
                Log.d(IjkVideoView.this.a, "MEDIA_INFO_AUDIO_RENDERING_START:");
                return true;
            }
            switch (i) {
                case 700:
                    Log.d(IjkVideoView.this.a, "MEDIA_INFO_VIDEO_TRACK_LAGGING:");
                    return true;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_START /* 701 */:
                    Log.d(IjkVideoView.this.a, "MEDIA_INFO_BUFFERING_START:");
                    return true;
                case IMediaPlayer.MEDIA_INFO_BUFFERING_END /* 702 */:
                    Log.d(IjkVideoView.this.a, "MEDIA_INFO_BUFFERING_END:");
                    return true;
                case IMediaPlayer.MEDIA_INFO_NETWORK_BANDWIDTH /* 703 */:
                    Log.d(IjkVideoView.this.a, "MEDIA_INFO_NETWORK_BANDWIDTH: " + i2);
                    return true;
                default:
                    switch (i) {
                        case 800:
                            Log.d(IjkVideoView.this.a, "MEDIA_INFO_BAD_INTERLEAVING:");
                            return true;
                        case IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE /* 801 */:
                            Log.d(IjkVideoView.this.a, "MEDIA_INFO_NOT_SEEKABLE:");
                            return true;
                        case IMediaPlayer.MEDIA_INFO_METADATA_UPDATE /* 802 */:
                            Log.d(IjkVideoView.this.a, "MEDIA_INFO_METADATA_UPDATE:");
                            return true;
                        default:
                            return true;
                    }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements IMediaPlayer.OnErrorListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements DialogInterface.OnClickListener {
            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (IjkVideoView.this.n != null) {
                    IjkVideoView.this.n.onCompletion(IjkVideoView.this.g);
                }
            }
        }

        public e() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        public boolean onError(IMediaPlayer iMediaPlayer, int i, int i2) {
            Log.d(IjkVideoView.this.a, "Error: " + i + "," + i2);
            IjkVideoView.this.d = -1;
            IjkVideoView.this.e = -1;
            if (IjkVideoView.this.m != null) {
                IjkVideoView.this.m.hide();
            }
            if ((IjkVideoView.this.q == null || !IjkVideoView.this.q.onError(IjkVideoView.this.g, i, i2)) && IjkVideoView.this.getWindowToken() != null) {
                IjkVideoView.this.x.getResources();
                new a.a(IjkVideoView.this.getContext()).e(i == 200 ? m93.b : m93.c).setPositiveButton(m93.a, new a()).b(false).h();
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements IMediaPlayer.OnBufferingUpdateListener {
        public f() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
            IjkVideoView.this.p = i;
            if (IjkVideoView.this.s != null) {
                IjkVideoView.this.s.onBufferingUpdate(iMediaPlayer, i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements IMediaPlayer.OnSeekCompleteListener {
        public g() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(IMediaPlayer iMediaPlayer) {
            IjkVideoView.this.G = System.currentTimeMillis();
            IjkVideoView.this.C.o(IjkVideoView.this.G - IjkVideoView.this.F);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements IMediaPlayer.OnTimedTextListener {
        public h() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnTimedTextListener
        public void onTimedText(IMediaPlayer iMediaPlayer, IjkTimedText ijkTimedText) {
            if (ijkTimedText != null) {
                IjkVideoView.this.H.setText(ijkTimedText.getText());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements a.InterfaceC0030a {
        public i() {
        }

        @Override // com.yunbao.common.ijkplay.a.InterfaceC0030a
        public void a(a.b bVar, int i, int i2) {
            com.yunbao.common.ijkplay.a a = bVar.a();
            com.yunbao.common.ijkplay.a aVar = IjkVideoView.this.z;
            IjkVideoView ijkVideoView = IjkVideoView.this;
            if (a != aVar) {
                Log.e(ijkVideoView.a, "onSurfaceCreated: unmatched render callback\n");
                return;
            }
            ijkVideoView.f = bVar;
            IMediaPlayer iMediaPlayer = IjkVideoView.this.g;
            IjkVideoView ijkVideoView2 = IjkVideoView.this;
            if (iMediaPlayer != null) {
                ijkVideoView2.O(ijkVideoView2.g, bVar);
            } else {
                ijkVideoView2.V();
            }
        }

        @Override // com.yunbao.common.ijkplay.a.InterfaceC0030a
        public void b(a.b bVar) {
            com.yunbao.common.ijkplay.a a = bVar.a();
            com.yunbao.common.ijkplay.a aVar = IjkVideoView.this.z;
            IjkVideoView ijkVideoView = IjkVideoView.this;
            if (a != aVar) {
                Log.e(ijkVideoView.a, "onSurfaceDestroyed: unmatched render callback\n");
            } else {
                ijkVideoView.f = null;
                IjkVideoView.this.X();
            }
        }

        @Override // com.yunbao.common.ijkplay.a.InterfaceC0030a
        public void c(a.b bVar, int i, int i2, int i3) {
            com.yunbao.common.ijkplay.a a = bVar.a();
            com.yunbao.common.ijkplay.a aVar = IjkVideoView.this.z;
            IjkVideoView ijkVideoView = IjkVideoView.this;
            if (a != aVar) {
                Log.e(ijkVideoView.a, "onSurfaceChanged: unmatched render callback\n");
                return;
            }
            ijkVideoView.j = i2;
            IjkVideoView.this.k = i3;
            boolean z = false;
            boolean z2 = IjkVideoView.this.e == 3;
            if (!IjkVideoView.this.z.d() || (IjkVideoView.this.h == i2 && IjkVideoView.this.i == i3)) {
                z = true;
            }
            if (IjkVideoView.this.g != null && z2 && z) {
                if (IjkVideoView.this.t != 0) {
                    IjkVideoView ijkVideoView2 = IjkVideoView.this;
                    ijkVideoView2.seekTo(ijkVideoView2.t);
                }
                IjkVideoView.this.start();
            }
        }
    }

    public IjkVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = "IjkVideoView";
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.u = true;
        this.v = true;
        this.w = true;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.I = new a();
        this.J = new b();
        this.K = new c();
        this.L = new d();
        this.M = new e();
        this.N = new f();
        this.O = new g();
        this.P = new h();
        this.Q = new i();
        this.R = 0;
        this.S = f0[0];
        this.T = new ArrayList();
        this.U = 0;
        this.V = 0;
        this.W = false;
        T(context);
    }

    public final void N() {
        wh1 wh1Var;
        if (this.g == null || (wh1Var = this.m) == null) {
            return;
        }
        wh1Var.setMediaPlayer(this);
        this.m.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.m.setEnabled(U());
    }

    public final void O(IMediaPlayer iMediaPlayer, a.b bVar) {
        if (iMediaPlayer == null) {
            return;
        }
        if (bVar == null) {
            iMediaPlayer.setDisplay(null);
        } else {
            bVar.b(iMediaPlayer);
        }
    }

    public final IMediaPlayer P() {
        return new AndroidMediaPlayer();
    }

    public IMediaPlayer Q(int i2) {
        IMediaPlayer iMediaPlayer;
        if (i2 == 1) {
            iMediaPlayer = P();
        } else if (i2 != 3) {
            try {
                if (this.b != null) {
                    IjkMediaPlayer ijkMediaPlayer = new IjkMediaPlayer();
                    IjkMediaPlayer.native_setLogLevel(3);
                    if (this.y.s()) {
                        ijkMediaPlayer.setOption(4, "mediacodec", 1L);
                        if (this.y.t()) {
                            ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
                        } else {
                            ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 0L);
                        }
                        if (this.y.o()) {
                            ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
                        } else {
                            ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 0L);
                        }
                    } else {
                        ijkMediaPlayer.setOption(4, "mediacodec", 0L);
                    }
                    if (this.y.v()) {
                        ijkMediaPlayer.setOption(4, "opensles", 1L);
                    } else {
                        ijkMediaPlayer.setOption(4, "opensles", 0L);
                    }
                    String p = this.y.p();
                    if (TextUtils.isEmpty(p)) {
                        ijkMediaPlayer.setOption(4, "overlay-format", 842225234L);
                    } else {
                        ijkMediaPlayer.setOption(4, "overlay-format", p);
                    }
                    boolean contains = this.b.toString().toLowerCase().contains(".m3u8");
                    qy2.a(ijkMediaPlayer, contains);
                    if (!contains) {
                        ijkMediaPlayer.setOption(4, "max-buffer-size", 1048576L);
                        ijkMediaPlayer.setOption(4, "max_cached_duration", 3000L);
                        ijkMediaPlayer.setOption(4, "infbuf", 0L);
                        ijkMediaPlayer.setOption(4, "packet-buffering", 0L);
                    }
                    ijkMediaPlayer.setOption(1, "http-detect-range-support", 0L);
                    ijkMediaPlayer.setOption(2, "skip_loop_filter", 48L);
                    ijkMediaPlayer.setOption(1, "protocol_whitelist", "concat,crypto,file,subfile,http,https,tcp,tls,udp,rtmp,rtsp,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,data");
                    iMediaPlayer = ijkMediaPlayer;
                } else {
                    iMediaPlayer = null;
                }
            } catch (Throwable th) {
                Log.e(this.a, "IjkMediaPlayer init failed, fallback to AndroidMediaPlayer", th);
                iMediaPlayer = P();
            }
        } else {
            iMediaPlayer = new IjkExoMediaPlayer(this.x);
        }
        return this.y.j() ? new TextureMediaPlayer(iMediaPlayer) : iMediaPlayer;
    }

    public final void R() {
        boolean i2 = this.y.i();
        this.W = i2;
        if (i2) {
            MediaPlayerService.b(getContext());
            IMediaPlayer a2 = MediaPlayerService.a();
            this.g = a2;
            mo1 mo1Var = this.C;
            if (mo1Var != null) {
                mo1Var.l(a2);
            }
        }
    }

    public final void S() {
        this.T.clear();
        if (this.y.l()) {
            this.T.add(1);
        }
        if (this.y.m()) {
            this.T.add(2);
        }
        if (this.y.k()) {
            this.T.add(0);
        }
        if (this.T.isEmpty()) {
            this.T.add(2);
        }
        int intValue = ((Integer) this.T.get(this.U)).intValue();
        this.V = intValue;
        setRender(intValue);
    }

    public final void T(Context context) {
        this.x = context.getApplicationContext();
        this.y = CommonAppContext.n();
        R();
        S();
        this.h = 0;
        this.i = 0;
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.d = 0;
        this.e = 0;
        TextView textView = new TextView(context);
        this.H = textView;
        textView.setTextSize(24.0f);
        this.H.setGravity(17);
        addView(this.H, new FrameLayout.LayoutParams(-1, -2, 80));
    }

    public final boolean U() {
        int i2;
        return (this.g == null || (i2 = this.d) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00cf A[Catch: all -> 0x0087, IllegalArgumentException -> 0x0089, IOException -> 0x008b, TryCatch #2 {IOException -> 0x008b, IllegalArgumentException -> 0x0089, all -> 0x0087, blocks: (B:7:0x0021, B:9:0x0078, B:11:0x007e, B:14:0x008e, B:15:0x00af, B:17:0x00cf, B:18:0x00d4, B:22:0x00a4), top: B:6:0x0021 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.ijkplay.IjkVideoView.V():void");
    }

    public void W(boolean z) {
        IMediaPlayer iMediaPlayer = this.g;
        if (iMediaPlayer != null) {
            iMediaPlayer.reset();
            this.g.release();
            this.g = null;
            this.d = 0;
            if (z) {
                this.e = 0;
            }
            ((AudioManager) this.x.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public void X() {
        IMediaPlayer iMediaPlayer = this.g;
        if (iMediaPlayer != null) {
            try {
                iMediaPlayer.setDisplay(null);
            } catch (Exception e2) {
                Log.e(this.a, "releaseWithoutStop error", e2);
            }
        }
    }

    public void Y() {
        V();
    }

    public final void Z(Uri uri, Map map) {
        this.b = uri;
        this.c = map;
        this.t = 0;
        V();
        requestLayout();
        invalidate();
    }

    public void a0() {
        IMediaPlayer iMediaPlayer = this.g;
        if (iMediaPlayer != null) {
            iMediaPlayer.stop();
            this.g.release();
            this.g = null;
            mo1 mo1Var = this.C;
            if (mo1Var != null) {
                mo1Var.l(null);
            }
            this.d = 0;
            this.e = 0;
            ((AudioManager) this.x.getSystemService("audio")).abandonAudioFocus(null);
        }
    }

    public final void b0() {
        boolean isShowing = this.m.isShowing();
        wh1 wh1Var = this.m;
        if (isShowing) {
            wh1Var.hide();
        } else {
            wh1Var.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.u;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.v;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.w;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        if (this.g != null) {
            return this.p;
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (U()) {
            return (int) this.g.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (U()) {
            return (int) this.g.getDuration();
        }
        return -1;
    }

    public IMediaPlayer getMediaPlayer() {
        return this.g;
    }

    public ITrackInfo[] getTrackInfo() {
        IMediaPlayer iMediaPlayer = this.g;
        if (iMediaPlayer == null) {
            return null;
        }
        return iMediaPlayer.getTrackInfo();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return U() && this.g.isPlaying();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (U() && z && this.m != null) {
            if (i2 == 79 || i2 == 85) {
                if (this.g.isPlaying()) {
                    pause();
                    this.m.show();
                } else {
                    start();
                    this.m.hide();
                }
                return true;
            }
            if (i2 == 126) {
                if (!this.g.isPlaying()) {
                    start();
                    this.m.hide();
                }
                return true;
            }
            if (i2 == 86 || i2 == 127) {
                if (this.g.isPlaying()) {
                    pause();
                    this.m.show();
                }
                return true;
            }
            b0();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!U() || this.m == null) {
            return false;
        }
        b0();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!U() || this.m == null) {
            return false;
        }
        b0();
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (U() && this.g.isPlaying()) {
            this.g.pause();
            this.d = 4;
        }
        this.e = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i2) {
        if (!U()) {
            this.t = i2;
            return;
        }
        this.F = System.currentTimeMillis();
        this.g.seekTo(i2);
        this.t = 0;
    }

    public void setHudView(TableLayout tableLayout) {
        this.C = new mo1(getContext(), tableLayout);
    }

    public void setMediaController(wh1 wh1Var) {
        wh1 wh1Var2 = this.m;
        if (wh1Var2 != null) {
            wh1Var2.hide();
        }
        this.m = wh1Var;
        N();
    }

    public void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.s = onBufferingUpdateListener;
    }

    public void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.n = onCompletionListener;
    }

    public void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.q = onErrorListener;
    }

    public void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.r = onInfoListener;
    }

    public void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.o = onPreparedListener;
    }

    public void setRender(int i2) {
        if (i2 == 0) {
            setRenderView(null);
            return;
        }
        if (i2 == 1) {
            setRenderView(new SurfaceRenderView(getContext()));
            return;
        }
        if (i2 != 2) {
            Log.e(this.a, String.format(Locale.getDefault(), "invalid render %d\n", Integer.valueOf(i2)));
            return;
        }
        TextureRenderView textureRenderView = new TextureRenderView(getContext());
        if (this.g != null) {
            textureRenderView.getSurfaceHolder().b(this.g);
            textureRenderView.a(this.g.getVideoWidth(), this.g.getVideoHeight());
            textureRenderView.c(this.g.getVideoSarNum(), this.g.getVideoSarDen());
            textureRenderView.setAspectRatio(this.S);
        }
        setRenderView(textureRenderView);
    }

    public void setRenderView(com.yunbao.common.ijkplay.a aVar) {
        int i2;
        int i3;
        if (this.z != null) {
            IMediaPlayer iMediaPlayer = this.g;
            if (iMediaPlayer != null) {
                iMediaPlayer.setDisplay(null);
            }
            View view = this.z.getView();
            this.z.b(this.Q);
            this.z = null;
            removeView(view);
        }
        if (aVar == null) {
            return;
        }
        this.z = aVar;
        aVar.setAspectRatio(this.S);
        int i4 = this.h;
        if (i4 > 0 && (i3 = this.i) > 0) {
            aVar.a(i4, i3);
        }
        int i5 = this.A;
        if (i5 > 0 && (i2 = this.B) > 0) {
            aVar.c(i5, i2);
        }
        View view2 = this.z.getView();
        view2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
        addView(view2);
        this.z.e(this.Q);
        this.z.setVideoRotation(this.l);
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        Z(uri, null);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (U()) {
            this.g.start();
            this.d = 3;
        }
        this.e = 3;
    }
}
