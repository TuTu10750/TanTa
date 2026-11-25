package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.provider.MediaStore;
import android.view.View;
import java.io.FileNotFoundException;

/* loaded from: /tmp/classes2.dex */
public class pj3 {
    public static final pj3 a = new pj3();

    public static pj3 b() {
        return a;
    }

    public Bitmap a(View view) {
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        lx1.d("9527", "width:" + view.getWidth() + "  height:" + view.getHeight());
        view.draw(canvas);
        return createBitmap;
    }

    public void c(Context context, Bitmap bitmap) {
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, context.getContentResolver().openOutputStream(context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new ContentValues()), "rw"))) {
                t54.b("保存成功");
            } else {
                t54.b("保存失败");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void d(Context context, View view) {
        c(context, a(view));
    }
}
