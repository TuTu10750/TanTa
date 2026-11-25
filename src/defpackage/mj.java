package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.yunbao.common.CommonAppContext;
import java.io.IOException;
import java.lang.ref.SoftReference;

/* loaded from: /tmp/classes2.dex */
public class mj {
    public static mj c;
    public Resources a = CommonAppContext.n().getResources();
    public BitmapFactory.Options b;

    public mj() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.b = options;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inDither = true;
        options.inSampleSize = 1;
    }

    public static mj b() {
        if (c == null) {
            synchronized (mj.class) {
                try {
                    if (c == null) {
                        c = new mj();
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public Bitmap a(int i) {
        Bitmap bitmap;
        try {
            byte[] c2 = yh1.c(this.a.openRawResource(i));
            bitmap = BitmapFactory.decodeByteArray(c2, 0, c2.length, this.b);
        } catch (IOException e) {
            e.printStackTrace();
            bitmap = null;
        }
        return (Bitmap) new SoftReference(bitmap).get();
    }
}
