package com.yunbao.common.ijkplay;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class MediaPlayerService extends Service {
    public static IMediaPlayer a;

    public static IMediaPlayer a() {
        return a;
    }

    public static void b(Context context) {
        context.startService(c(context));
    }

    public static Intent c(Context context) {
        return new Intent(context, (Class<?>) MediaPlayerService.class);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }
}
