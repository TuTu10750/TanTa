package defpackage;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public abstract class qy2 {
    public static void a(IjkMediaPlayer ijkMediaPlayer, boolean z) {
        ijkMediaPlayer.setOption(4, "mediacodec", 1L);
        ijkMediaPlayer.setOption(4, "mediacodec-auto-rotate", 1L);
        ijkMediaPlayer.setOption(4, "mediacodec-handle-resolution-change", 1L);
        ijkMediaPlayer.setOption(4, "framedrop", 1L);
        ijkMediaPlayer.setOption(4, "start-on-prepared", 1L);
        if (z) {
            ijkMediaPlayer.setOption(1, "analyzeduration", 5000000L);
            ijkMediaPlayer.setOption(1, "probesize", 1048576L);
            ijkMediaPlayer.setOption(4, "packet-buffering", 1L);
        } else {
            ijkMediaPlayer.setOption(1, "rtmp_live", "live");
            ijkMediaPlayer.setOption(1, "rtmp_buffer", "100");
            ijkMediaPlayer.setOption(1, "flush_packets", 1L);
            ijkMediaPlayer.setOption(1, "analyzeduration", 1L);
            ijkMediaPlayer.setOption(1, "probesize", 1024L);
        }
        ijkMediaPlayer.setOption(1, "dns_cache_clear", 1L);
    }
}
