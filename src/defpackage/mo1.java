package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.widget.TableLayout;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaPlayerProxy;

/* loaded from: /tmp/classes2.dex */
public class mo1 {
    public u14 a;
    public IMediaPlayer c;
    public SparseArray b = new SparseArray();
    public long d = 0;
    public long e = 0;
    public Handler f = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IMediaPlayer internalMediaPlayer;
            if (message.what == 1 && mo1.this.c != null) {
                boolean z = mo1.this.c instanceof IjkMediaPlayer;
                mo1 mo1Var = mo1.this;
                IjkMediaPlayer ijkMediaPlayer = z ? (IjkMediaPlayer) mo1Var.c : ((mo1Var.c instanceof MediaPlayerProxy) && (internalMediaPlayer = ((MediaPlayerProxy) mo1.this.c).getInternalMediaPlayer()) != null && (internalMediaPlayer instanceof IjkMediaPlayer)) ? (IjkMediaPlayer) internalMediaPlayer : null;
                if (ijkMediaPlayer == null) {
                    return;
                }
                int videoDecoder = ijkMediaPlayer.getVideoDecoder();
                if (videoDecoder != 1) {
                    mo1 mo1Var2 = mo1.this;
                    if (videoDecoder != 2) {
                        mo1Var2.m(m93.ha, "");
                    } else {
                        mo1Var2.m(m93.ha, "MediaCodec");
                    }
                } else {
                    mo1.this.m(m93.ha, "avcodec");
                }
                float videoOutputFramesPerSecond = ijkMediaPlayer.getVideoOutputFramesPerSecond();
                float videoDecodeFramesPerSecond = ijkMediaPlayer.getVideoDecodeFramesPerSecond();
                mo1 mo1Var3 = mo1.this;
                int i = m93.O1;
                Locale locale = Locale.US;
                mo1Var3.m(i, String.format(locale, "%.2f / %.2f", Float.valueOf(videoDecodeFramesPerSecond), Float.valueOf(videoOutputFramesPerSecond)));
                long videoCachedDuration = ijkMediaPlayer.getVideoCachedDuration();
                long audioCachedDuration = ijkMediaPlayer.getAudioCachedDuration();
                long videoCachedBytes = ijkMediaPlayer.getVideoCachedBytes();
                long audioCachedBytes = ijkMediaPlayer.getAudioCachedBytes();
                long tcpSpeed = ijkMediaPlayer.getTcpSpeed();
                long bitRate = ijkMediaPlayer.getBitRate();
                long seekLoadDuration = ijkMediaPlayer.getSeekLoadDuration();
                mo1.this.m(m93.ga, String.format(locale, "%s, %s", mo1.i(videoCachedDuration), mo1.j(videoCachedBytes)));
                mo1.this.m(m93.w0, String.format(locale, "%s, %s", mo1.i(audioCachedDuration), mo1.j(audioCachedBytes)));
                mo1 mo1Var4 = mo1.this;
                mo1Var4.m(m93.Y4, String.format(locale, "%d ms", Long.valueOf(mo1Var4.d)));
                mo1 mo1Var5 = mo1.this;
                mo1Var5.m(m93.V9, String.format(locale, "%d ms", Long.valueOf(mo1Var5.e)));
                mo1.this.m(m93.W9, String.format(locale, "%d ms", Long.valueOf(seekLoadDuration)));
                mo1.this.m(m93.fa, String.format(locale, "%s", mo1.k(tcpSpeed, 1000L)));
                mo1.this.m(m93.M0, String.format(locale, "%.2f kbs", Float.valueOf(((float) bitRate) / 1000.0f)));
                mo1.this.f.removeMessages(1);
                mo1.this.f.sendEmptyMessageDelayed(1, 500L);
            }
        }
    }

    public mo1(Context context, TableLayout tableLayout) {
        this.a = new u14(context, tableLayout);
    }

    public static String i(long j) {
        return j >= 1000 ? String.format(Locale.US, "%.2f sec", Float.valueOf(((float) j) / 1000.0f)) : String.format(Locale.US, "%d msec", Long.valueOf(j));
    }

    public static String j(long j) {
        return j >= 100000 ? String.format(Locale.US, "%.2f MB", Float.valueOf((((float) j) / 1000.0f) / 1000.0f)) : j >= 100 ? String.format(Locale.US, "%.1f KB", Float.valueOf(((float) j) / 1000.0f)) : String.format(Locale.US, "%d B", Long.valueOf(j));
    }

    public static String k(long j, long j2) {
        if (j2 <= 0 || j <= 0) {
            return "0 B/s";
        }
        float f = (((float) j) * 1000.0f) / ((float) j2);
        return f >= 1000000.0f ? String.format(Locale.US, "%.2f MB/s", Float.valueOf((f / 1000.0f) / 1000.0f)) : f >= 1000.0f ? String.format(Locale.US, "%.1f KB/s", Float.valueOf(f / 1000.0f)) : String.format(Locale.US, "%d B/s", Long.valueOf(f));
    }

    public void l(IMediaPlayer iMediaPlayer) {
        this.c = iMediaPlayer;
        Handler handler = this.f;
        if (iMediaPlayer != null) {
            handler.sendEmptyMessageDelayed(1, 500L);
        } else {
            handler.removeMessages(1);
        }
    }

    public final void m(int i, String str) {
        View view = (View) this.b.get(i);
        u14 u14Var = this.a;
        if (view != null) {
            u14Var.f(view, str);
        } else {
            this.b.put(i, u14Var.b(i, str));
        }
    }

    public void n(long j) {
        this.d = j;
    }

    public void o(long j) {
        this.e = j;
    }
}
