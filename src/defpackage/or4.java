package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import defpackage.kr4;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: /tmp/classes2.dex */
public class or4 {
    public kr4 a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            or4.this.a = kr4.a.g(iBinder);
            synchronized (or4.this.d) {
                or4.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            or4.this.a = null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b {
        public static final or4 a = new or4(null);
    }

    public /* synthetic */ or4(a aVar) {
    }

    public synchronized String a(Context context, String str) {
        try {
        } catch (Throwable th) {
            throw th;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        if (this.a != null) {
            try {
                return c(context, str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return "";
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        if (context.bindService(intent, this.e, 1)) {
            synchronized (this.d) {
                try {
                    this.d.wait(3000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (this.a == null) {
            return "";
        }
        try {
            return c(context, str);
        } catch (RemoteException e3) {
            e3.printStackTrace();
            return "";
        }
        throw th;
    }

    public boolean b(Context context) {
        long longVersionCode;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT < 28) {
                return packageInfo != null && packageInfo.versionCode >= 1;
            }
            if (packageInfo != null) {
                longVersionCode = packageInfo.getLongVersionCode();
                if (longVersionCode >= 1) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String c(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            String str2 = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = str2;
        }
        String g = ((kr4.a.C0132a) this.a).g(this.b, this.c, str);
        return TextUtils.isEmpty(g) ? "" : g;
    }
}
