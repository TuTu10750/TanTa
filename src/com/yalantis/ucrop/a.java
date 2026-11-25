package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: /tmp/classes2.dex */
public class a {
    public Intent a = new Intent();
    public Bundle b;

    /* renamed from: com.yalantis.ucrop.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static class C0029a {
        public final Bundle a = new Bundle();

        public Bundle a() {
            return this.a;
        }

        public void b(int i) {
            this.a.putInt("com.yalantis.ucrop.UcropColorControlsWidgetActive", i);
        }

        public void c(int i) {
            this.a.putInt("com.yalantis.ucrop.MaxBitmapSize", i);
        }

        public void d(int i) {
            this.a.putInt("com.yalantis.ucrop.StatusBarColor", i);
        }

        public void e(int i) {
            this.a.putInt("com.yalantis.ucrop.ToolbarColor", i);
        }

        public void f(int i) {
            this.a.putInt("com.yalantis.ucrop.UcropToolbarWidgetColor", i);
        }
    }

    public a(Uri uri, Uri uri2) {
        Bundle bundle = new Bundle();
        this.b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }

    public static a b(Uri uri, Uri uri2) {
        return new a(uri, uri2);
    }

    public Intent a(Context context) {
        this.a.setClass(context, UCropActivity.class);
        this.a.putExtras(this.b);
        return this.a;
    }

    public a c(float f, float f2) {
        this.b.putFloat("com.yalantis.ucrop.AspectRatioX", f);
        this.b.putFloat("com.yalantis.ucrop.AspectRatioY", f2);
        return this;
    }

    public a d(int i, int i2) {
        if (i < 10) {
            i = 10;
        }
        if (i2 < 10) {
            i2 = 10;
        }
        this.b.putInt("com.yalantis.ucrop.MaxSizeX", i);
        this.b.putInt("com.yalantis.ucrop.MaxSizeY", i2);
        return this;
    }

    public a e(C0029a c0029a) {
        this.b.putAll(c0029a.a());
        return this;
    }
}
