package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.provider.MediaStore;
import com.umeng.analytics.pro.bz;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.ChooseVideoBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class tz {
    public ContentResolver a = CommonAppContext.n().getContentResolver();
    public k30 b;
    public boolean c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {

        /* renamed from: tz$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0158a implements Runnable {
            public final /* synthetic */ List a;

            public RunnableC0158a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (tz.this.b != null) {
                    tz.this.b.a(this.a);
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            List c = tz.this.c();
            if (tz.this.b != null) {
                CommonAppContext.z(new RunnableC0158a(c));
            }
        }
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{bz.d, "_data", "_display_name", "duration", "date_modified"}, null, null, "date_modified desc");
                if (cursor != null) {
                    while (!this.c && cursor.moveToNext()) {
                        long j = cursor.getLong(cursor.getColumnIndexOrThrow("duration"));
                        if (j > 0) {
                            long j2 = cursor.getLong(cursor.getColumnIndex(bz.d));
                            if (j2 > 0) {
                                ChooseVideoBean chooseVideoBean = new ChooseVideoBean(1, ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, j2));
                                chooseVideoBean.setDuration(j);
                                chooseVideoBean.setDurationString(rv3.d(j));
                                arrayList.add(chooseVideoBean);
                            }
                        }
                    }
                }
                if (cursor != null) {
                    cursor.close();
                    return arrayList;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (cursor != null) {
                    cursor.close();
                }
            }
            return arrayList;
        } finally {
        }
    }

    public void d(k30 k30Var) {
        if (k30Var == null) {
            return;
        }
        this.b = k30Var;
        new Thread(new a()).start();
    }

    public void e() {
        this.c = true;
        this.b = null;
    }
}
