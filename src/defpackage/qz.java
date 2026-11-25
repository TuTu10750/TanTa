package defpackage;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.provider.MediaStore;
import com.umeng.analytics.pro.bz;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.ChooseImageBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class qz {
    public ContentResolver a = CommonAppContext.n().getContentResolver();
    public k30 b;
    public boolean c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {

        /* renamed from: qz$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class RunnableC0152a implements Runnable {
            public final /* synthetic */ List a;

            public RunnableC0152a(List list) {
                this.a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (qz.this.b != null) {
                    qz.this.b.a(this.a);
                }
            }
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qz.this.b != null) {
                CommonAppContext.z(new RunnableC0152a(qz.this.c()));
            }
        }
    }

    public final List c() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursor = this.a.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, "mime_type=? or mime_type=?", new String[]{"image/jpeg", "image/png"}, "date_modified desc");
                if (cursor != null) {
                    while (!this.c && cursor.moveToNext()) {
                        long j = cursor.getLong(cursor.getColumnIndex(bz.d));
                        if (j > 0) {
                            arrayList.add(new ChooseImageBean(1, ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j)));
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
