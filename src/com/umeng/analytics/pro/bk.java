package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.analytics.pro.c;
import com.umeng.analytics.pro.d;
import defpackage.pr4;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: /tmp/classes2.dex */
class bk implements bf {
    private static String a = "";

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements ServiceConnection {
        boolean a;
        private final LinkedBlockingQueue<IBinder> b;

        private a() {
            this.a = false;
            this.b = new LinkedBlockingQueue<>();
        }

        public IBinder a() {
            if (this.a) {
                pr4.a();
                return null;
            }
            this.a = true;
            return this.b.poll(5L, TimeUnit.SECONDS);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b extends c.b {
        private b() {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(int i, Bundle bundle) {
            if (i != 0 || bundle == null) {
                return;
            }
            String string = bundle.getString(c.b);
            if (bk.c(string)) {
                String unused = bk.a = string;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        public static final int a = 0;
        public static final String b = "oa_id_flag";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean c(String str) {
        return (TextUtils.isEmpty(str) || str.equalsIgnoreCase("00000000-0000-0000-0000-000000000000")) ? false : true;
    }

    @Override // com.umeng.analytics.pro.bf
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (!Boolean.parseBoolean(Settings.Secure.getString(context.getContentResolver(), "oaid_limit_state"))) {
                String string = Settings.Global.getString(context.getContentResolver(), "oaid");
                if (c(string)) {
                    a = string;
                    return string;
                }
            }
        } catch (Throwable unused) {
        }
        a aVar = new a();
        Intent intent = new Intent();
        intent.setAction("com.hihonor.id.HnOaIdService");
        intent.setPackage("com.hihonor.id");
        if (context.bindService(intent, aVar, 1)) {
            try {
                d.b.a(aVar.a()).a(new b());
                return a;
            } catch (Exception unused2) {
            } finally {
                context.unbindService(aVar);
            }
        }
        return null;
    }
}
