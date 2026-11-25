package com.umeng.crash;

import android.util.Log;

/* loaded from: /tmp/classes2.dex */
final class h implements g {
    static boolean a;

    @Override // com.umeng.crash.g
    public final void a(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    @Override // com.umeng.crash.g
    public final void a(String str, String str2, Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }

    @Override // com.umeng.crash.g
    public final void b(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }

    @Override // com.umeng.crash.g
    public final void c(String str, String str2) {
        if (a) {
            Log.w(str, str2);
        }
    }

    @Override // com.umeng.crash.g
    public final void d(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }
}
