package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.WindowManager;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
public abstract class hj {
    public static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        while (true) {
            if (i3 / i5 <= i2 && i4 / i5 <= i) {
                return i5;
            }
            i5 *= 2;
        }
    }

    public static int b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int sqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int min = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (min > 0) {
            sqrt = Math.min(sqrt, min);
        }
        int b = ns0.b();
        if (b > 0) {
            sqrt = Math.min(sqrt, b);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + sqrt);
        return sqrt;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(Context context, Uri uri, Uri uri2, int i, int i2, fj fjVar) {
        new gj(context, uri, uri2, i, i2, fjVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static int e(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int f(int i) {
        return (i == 2 || i == 7 || i == 4 || i == 5) ? -1 : 1;
    }

    public static int g(Context context, Uri uri) {
        int i = 0;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return 0;
            }
            i = new fm1(openInputStream).g();
            c(openInputStream);
            return i;
        } catch (IOException e) {
            Log.e("BitmapLoadUtils", "getExifOrientation: " + uri.toString(), e);
            return i;
        }
    }

    public static boolean h(Uri uri) {
        return uri != null && "content".equals(uri.getScheme());
    }

    public static Bitmap i(Bitmap bitmap, Matrix matrix) {
        Bitmap bitmap2;
        try {
            bitmap2 = bitmap;
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                return !bitmap2.sameAs(createBitmap) ? createBitmap : bitmap2;
            } catch (OutOfMemoryError e) {
                e = e;
                Log.e("BitmapLoadUtils", "transformBitmap: ", e);
                return bitmap2;
            }
        } catch (OutOfMemoryError e2) {
            e = e2;
            bitmap2 = bitmap;
        }
    }
}
