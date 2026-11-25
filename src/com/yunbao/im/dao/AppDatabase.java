package com.yunbao.im.dao;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.f;
import com.umeng.analytics.pro.bv;
import defpackage.qh1;
import defpackage.th1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/yunbao/im/dao/AppDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lth1;", "D", "()Lth1;", "Lqh1;", "C", "()Lqh1;", "o", bv.av, "im_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public abstract class AppDatabase extends RoomDatabase {

    /* renamed from: o, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static volatile AppDatabase p;

    /* renamed from: com.yunbao.im.dao.AppDatabase$a, reason: from kotlin metadata */
    /* loaded from: /tmp/classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppDatabase a(Context context) {
            AppDatabase appDatabase;
            context.getClass();
            AppDatabase appDatabase2 = AppDatabase.p;
            if (appDatabase2 != null) {
                return appDatabase2;
            }
            synchronized (this) {
                RoomDatabase a = f.a(context.getApplicationContext(), AppDatabase.class, "chat_db").a();
                AppDatabase.p = (AppDatabase) a;
                appDatabase = (AppDatabase) a;
            }
            appDatabase.getClass();
            return appDatabase;
        }
    }

    public abstract qh1 C();

    public abstract th1 D();
}
