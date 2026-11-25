package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.yunbao.common.ijkplay.IjkVideoView;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class s32 extends p0 {
    public IjkVideoView f;
    public boolean g;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            s32 s32Var = s32.this;
            s32Var.b = false;
            if (s32Var.f != null) {
                s32.this.f.setVideoURI(Uri.parse(this.a));
                s32.this.f.start();
            }
            lx1.c("LiveLinkMicPlayTxViewHolder", "play----url--->" + this.a);
        }
    }

    public s32(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public static /* synthetic */ boolean g0(s32 s32Var, IMediaPlayer iMediaPlayer, int i, int i2) {
        s32Var.getClass();
        if (i == 3) {
            lx1.a("ijk", "真正开始播放");
            s32Var.g = true;
            s32Var.e.setVisibility(4);
            return true;
        }
        if (i == 701) {
            lx1.a("ijk", "卡顿中...");
            return true;
        }
        if (i == 702) {
            lx1.a("ijk", "恢复播放");
        }
        return true;
    }

    public static /* synthetic */ void h0(s32 s32Var, IMediaPlayer iMediaPlayer, int i) {
        s32Var.getClass();
        lx1.a("ijk", "缓冲进度: " + i + "%");
        View view = s32Var.e;
        if (view == null || view.getVisibility() == 0 || s32Var.g) {
            s32Var.e.setVisibility(4);
        } else {
            s32Var.e.setVisibility(0);
        }
    }

    @Override // defpackage.p0
    public void b0() {
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView != null) {
            ijkVideoView.pause();
        }
        this.a = true;
    }

    @Override // defpackage.p0
    public void d0(String str) {
        if (TextUtils.isEmpty(str)) {
            IjkVideoView ijkVideoView = this.f;
            if (ijkVideoView != null) {
                ijkVideoView.a0();
            }
            this.b = true;
            return;
        }
        Handler handler = this.c;
        if (handler != null) {
            handler.postDelayed(new a(str), 500L);
        }
    }

    @Override // defpackage.p0
    public void e0() {
        if (this.a) {
            this.f.Y();
        }
        this.a = false;
    }

    @Override // defpackage.p0
    public void f0(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.d.setVisibility(0);
            this.d.setOnClickListener(onClickListener);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.L1;
    }

    @Override // defpackage.p0, defpackage.b1
    public void init() {
        super.init();
        IjkVideoView ijkVideoView = (IjkVideoView) findViewById(b73.f6);
        this.f = ijkVideoView;
        ijkVideoView.setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() { // from class: q32
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                s32.h0(s32.this, iMediaPlayer, i);
            }
        });
        this.f.setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: r32
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public final boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                return s32.g0(s32.this, iMediaPlayer, i, i2);
            }
        });
    }

    @Override // defpackage.p0, defpackage.b1
    public void release() {
        this.b = true;
        IjkVideoView ijkVideoView = this.f;
        if (ijkVideoView != null) {
            ijkVideoView.W(true);
        }
        View view = this.d;
        if (view != null) {
            view.setOnClickListener(null);
        }
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.c = null;
        lx1.c("LiveLinkMicPlayTxViewHolder", "release------->");
    }
}
