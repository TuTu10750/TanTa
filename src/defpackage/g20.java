package defpackage;

import android.content.Context;
import coil.ImageLoader;

/* loaded from: /tmp/classes2.dex */
public final class g20 {
    public static final g20 a = new g20();
    public static ImageLoader b;

    public static final ImageLoader a(Context context) {
        ImageLoader imageLoader = b;
        return imageLoader == null ? a.b(context) : imageLoader;
    }

    public static final synchronized void c(ImageLoader imageLoader) {
        synchronized (g20.class) {
            b = imageLoader;
        }
    }

    public final synchronized ImageLoader b(Context context) {
        ImageLoader imageLoader = b;
        if (imageLoader != null) {
            return imageLoader;
        }
        context.getApplicationContext();
        ImageLoader a2 = lm1.a(context);
        b = a2;
        return a2;
    }
}
