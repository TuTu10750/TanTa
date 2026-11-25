package com.trtc.tuikit.common.imageloader;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderEffect;
import android.graphics.Shader;
import android.os.Build;
import android.widget.ImageView;
import com.bumptech.glide.a;
import com.trtc.tuikit.common.imageloader.ImageOptions;
import com.trtc.tuikit.common.system.ContextProvider;
import java.lang.ref.WeakReference;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/* loaded from: /tmp/classes2.dex */
public class ImageLoader {

    /* loaded from: /tmp/classes2.dex */
    public static class BlurTransformation extends lj {
        private final float radius;
        private final WeakReference<Context> weakPreference;

        public BlurTransformation(Context context, float f) {
            this.radius = f * 0.25f;
            this.weakPreference = new WeakReference<>(context);
        }

        public Bitmap transform(ij ijVar, Bitmap bitmap, int i, int i2) {
            return BlurUtils.blur(this.weakPreference.get(), ijVar, bitmap, (int) this.radius);
        }

        public void updateDiskCacheKey(MessageDigest messageDigest) {
            messageDigest.update(("blur:" + this.radius).getBytes());
        }
    }

    public static void clear(Context context, ImageView imageView) {
        if (imageView != null) {
            a.t(context.getApplicationContext()).m(imageView);
        }
    }

    private static int dip2px(int i) {
        return (int) ((i * ContextProvider.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void load(Context context, ImageView imageView, Object obj, int i) {
        load(context, imageView, obj, new ImageOptions.Builder().setPlaceImage(i).build());
    }

    public static void load(Context context, ImageView imageView, Object obj, ImageOptions imageOptions) {
        if (imageView == null) {
            return;
        }
        if (obj == null) {
            imageView.setImageResource(imageOptions.getPlaceImage() != 0 ? imageOptions.getPlaceImage() : imageOptions.getErrorImage());
        } else {
            loadImageView(context, imageView, obj, imageOptions);
        }
    }

    private static void loadImageView(Context context, ImageView imageView, Object obj, ImageOptions imageOptions) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        df3 v0 = imageOptions.isGif() ? a.t(context.getApplicationContext()).k().v0(obj) : a.t(context.getApplicationContext()).r(obj);
        setBuilderOptions(context.getApplicationContext(), v0, imageOptions);
        v0.t0(imageView);
        setRenderEffect(imageView, imageOptions);
    }

    private static void setBuilderOptions(Context context, df3 df3Var, ImageOptions imageOptions) {
        pf3 pf3Var = new pf3();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new jx());
        if (imageOptions.getRoundRadius() > 0) {
            arrayList.add(new mi3(dip2px(imageOptions.getRoundRadius())));
        }
        if (imageOptions.getBlurEffect() > 0.0f && Build.VERSION.SDK_INT < 31) {
            arrayList.add(new BlurTransformation(context, imageOptions.getBlurEffect()));
        }
        pf3Var.d0(new co2(arrayList));
        if (imageOptions.getPlaceImage() != 0) {
            pf3Var.U(imageOptions.getPlaceImage());
        }
        if (imageOptions.getErrorImage() != 0) {
            pf3Var.i(imageOptions.getErrorImage());
        }
        pf3Var.f(imageOptions.skipDiskCache() ? xm0.b : xm0.a);
        pf3Var.c0(imageOptions.skipMemoryCache());
        df3Var.j0(pf3Var);
    }

    private static void setRenderEffect(ImageView imageView, ImageOptions imageOptions) {
        RenderEffect createBlurEffect;
        float blurEffect = imageOptions.getBlurEffect();
        if (blurEffect <= 0.0f || Build.VERSION.SDK_INT < 31) {
            return;
        }
        createBlurEffect = RenderEffect.createBlurEffect(blurEffect, blurEffect, Shader.TileMode.MIRROR);
        imageView.setRenderEffect(createBlurEffect);
    }

    public static Bitmap transformBitmap(Context context, Object obj, int i, int i2, ImageOptions imageOptions) {
        if (obj == null) {
            return null;
        }
        df3 v0 = a.t(context.getApplicationContext()).d().v0(obj);
        setBuilderOptions(context.getApplicationContext(), v0, imageOptions);
        try {
            return (Bitmap) v0.y0(i, i2).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }
}
