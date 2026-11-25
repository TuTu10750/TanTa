package com.yunbao.live.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import defpackage.aq4;
import defpackage.j30;
import defpackage.m93;

/* loaded from: /tmp/classes2.dex */
public class ScreenRecordService extends Service {

    /* loaded from: /tmp/classes2.dex */
    public class b extends Binder {
        public b() {
        }
    }

    public final void a() {
        System.out.println("ffgghh-------startNotification-");
        Notification a2 = new c(this, "com.yunbao.live.ScreenRecordService").i(BitmapFactory.decodeResource(getResources(), j30.q().d())).m(j30.q().d()).g(j30.q().e()).f(aq4.a(m93.Qa)).e(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) ScreenRecordService.class), Build.VERSION.SDK_INT >= 31 ? 201326592 : 134217728)).a();
        NotificationChannel notificationChannel = new NotificationChannel("com.yunbao.live.ScreenRecordService", "com.yunbao.live.channel_name", 3);
        notificationChannel.setDescription("com.yunbao.live.channel_desc");
        ((NotificationManager) getSystemService("notification")).createNotificationChannel(notificationChannel);
        startForeground(1, a2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new b();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }
}
