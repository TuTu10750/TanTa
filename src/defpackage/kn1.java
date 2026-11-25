package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public abstract class kn1 {
    public static final ln1 a = new i20();

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void onLoadFailed();

        void onLoadSuccess(Drawable drawable);
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        i20 i20Var = a;
        if (i20Var instanceof i20) {
            i20Var.p(imageView);
        } else {
            imageView.setImageDrawable(null);
        }
    }

    public static void b() {
        a.e();
    }

    public static void c() {
        i20 i20Var = a;
        if (i20Var instanceof i20) {
            i20Var.q();
        } else {
            i20Var.e();
        }
    }

    public static void d(Context context, Uri uri, ImageView imageView) {
        a.i(context, uri, imageView);
    }

    public static void e(Context context, File file, ImageView imageView) {
        a.k(context, file, imageView);
    }

    public static void f(Context context, String str, ImageView imageView) {
        a.a(context, str, imageView);
    }

    public static void g(Context context, String str, ImageView imageView) {
        a.l(context, str, imageView);
    }

    public static void h(Context context, String str, ImageView imageView) {
        a.g(context, str, imageView);
    }

    public static void i(Context context, File file, a aVar) {
        a.c(context, file, aVar);
    }

    public static void j(Context context, String str, a aVar) {
        a.f(context, str, aVar);
    }

    public static void k(Context context, String str, ImageView imageView, int i, int i2) {
        i20 i20Var = a;
        if (i20Var instanceof i20) {
            i20Var.s(context, str, imageView, i, i2);
        } else {
            i20Var.a(context, str, imageView);
        }
    }

    public static void l(Context context, String str, ImageView imageView, int i, int i2) {
        i20 i20Var = a;
        if (i20Var instanceof i20) {
            i20Var.t(context, str, imageView, i, i2);
        } else {
            i20Var.m(context, str, imageView);
        }
    }

    public static void m(Context context, Uri uri, ImageView imageView) {
        a.h(context, uri, imageView);
    }

    public static void n(Context context, File file, ImageView imageView) {
        a.d(context, file, imageView);
    }

    public static void o(Context context, String str, ImageView imageView) {
        a.j(context, str, imageView);
    }

    public static String p() {
        return a.b();
    }
}
