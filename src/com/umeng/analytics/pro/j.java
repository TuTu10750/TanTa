package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /tmp/classes2.dex */
class j {
    private static SQLiteOpenHelper b;
    private static Context d;
    private AtomicInteger a;
    private SQLiteDatabase c;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final j a = new j();

        private a() {
        }
    }

    private j() {
        this.a = new AtomicInteger();
    }

    public static j a(Context context) {
        if (d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            d = applicationContext;
            b = i.a(applicationContext);
        }
        return a.a;
    }

    public synchronized SQLiteDatabase a() {
        try {
            if (this.a.incrementAndGet() == 1) {
                this.c = b.getWritableDatabase();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.c;
    }

    public synchronized void b() {
        try {
            if (this.a.decrementAndGet() == 0) {
                this.c.close();
            }
        } catch (Throwable unused) {
        }
    }
}
