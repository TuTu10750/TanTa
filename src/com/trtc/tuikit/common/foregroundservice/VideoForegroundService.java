package com.trtc.tuikit.common.foregroundservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.system.ContextProvider;
import com.trtc.tuikit.common.util.TUIBuild;

/* loaded from: /tmp/classes2.dex */
public class VideoForegroundService extends Service {
    private static final String DESCRIPTION = "description";
    private static final String ICON = "icon";
    private static final int NOTIFICATION_ID = 1001;
    private static final String TAG = "VideoForegroundService";
    private static final String TITLE = "title";
    private static ServiceState state = ServiceState.IDLE;

    private static boolean checkHasPermission(Context context) {
        if (o60.a(context, "android.permission.CAMERA") == 0 && o60.a(context, "android.permission.RECORD_AUDIO") == 0) {
            return TUIBuild.getVersionInt() < 33 || o60.a(context, "android.permission.POST_NOTIFICATIONS") == 0;
        }
        return false;
    }

    private Notification createForegroundNotification(String str, String str2, int i) {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (TUIBuild.getVersionInt() >= 26) {
            String string = getApplicationContext().getString(R.string.common_rtc_channel_name);
            String string2 = getApplicationContext().getString(R.string.common_rtc_channel_description);
            NotificationChannel notificationChannel = new NotificationChannel("rtc_uikit_foreground_service", string, 2);
            notificationChannel.setDescription(string2);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }
        Log.i(TAG, "enableNotification: " + (TUIBuild.getVersionInt() >= 24 ? notificationManager.areNotificationsEnabled() : true));
        c cVar = new c(this, "rtc_uikit_foreground_service");
        cVar.m(i);
        cVar.g(str);
        cVar.f(str2);
        cVar.n(System.currentTimeMillis());
        return cVar.a();
    }

    public static void start(Context context, String str, String str2, int i) {
        ServiceState serviceState = state;
        ServiceState serviceState2 = ServiceState.STARTING;
        if (serviceState == serviceState2 || state == ServiceState.RUNNING) {
            Log.i(TAG, "start foreground service，service is running");
            return;
        }
        if (state == ServiceState.STOPPING) {
            state = serviceState2;
            Log.i(TAG, "start foreground service，service is stopping");
            return;
        }
        state = serviceState2;
        if (!checkHasPermission(context)) {
            state = ServiceState.IDLE;
            Log.e(TAG, "start foreground service failed, please grant camera and microphone permission,as well as notification permission on Android 13+.");
            return;
        }
        Log.d(TAG, "start foreground service title=" + str + " description=" + str2);
        Intent intent = new Intent(context, (Class<?>) VideoForegroundService.class);
        intent.putExtra(TITLE, str);
        intent.putExtra(ICON, i);
        intent.putExtra(DESCRIPTION, str2);
        context.startForegroundService(intent);
    }

    public static void stop(Context context) {
        Log.d(TAG, "stop foreground service: state = " + state);
        if (ServiceState.RUNNING == state) {
            context.stopService(new Intent(context, (Class<?>) VideoForegroundService.class));
            state = ServiceState.IDLE;
        } else if (ServiceState.STARTING == state) {
            state = ServiceState.STOPPING;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            Log.e(TAG, "onStartCommand intent == null, state = " + state);
            return 2;
        }
        Notification createForegroundNotification = createForegroundNotification(intent.getStringExtra(TITLE), intent.getStringExtra(DESCRIPTION), intent.getIntExtra(ICON, ContextProvider.getApplicationContext().getApplicationInfo().icon));
        if (Build.VERSION.SDK_INT >= 30) {
            startForeground(1001, createForegroundNotification, 192);
        } else {
            startForeground(1001, createForegroundNotification);
        }
        Log.d(TAG, "onStartCommand end, state = " + state);
        if (state == ServiceState.STOPPING) {
            stopSelf();
            state = ServiceState.IDLE;
        } else {
            state = ServiceState.RUNNING;
        }
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        super.onTaskRemoved(intent);
        stopSelf();
        state = ServiceState.IDLE;
    }
}
