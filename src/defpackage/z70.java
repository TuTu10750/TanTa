package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* loaded from: /tmp/classes2.dex */
public class z70 {
    public int a;
    public int b;
    public Bitmap.CompressFormat c;
    public int d;
    public String e;
    public String f;
    public aw0 g;
    public Uri h;
    public Uri i;

    public z70(int i, int i2, Bitmap.CompressFormat compressFormat, int i3, String str, String str2, aw0 aw0Var) {
        this.a = i;
        this.b = i2;
        this.c = compressFormat;
        this.d = i3;
        this.e = str;
        this.f = str2;
        this.g = aw0Var;
    }

    public Bitmap.CompressFormat a() {
        return this.c;
    }

    public int b() {
        return this.d;
    }

    public Uri c() {
        return this.h;
    }

    public Uri d() {
        return this.i;
    }

    public aw0 e() {
        return this.g;
    }

    public String f() {
        return this.e;
    }

    public String g() {
        return this.f;
    }

    public int h() {
        return this.a;
    }

    public int i() {
        return this.b;
    }

    public void j(Uri uri) {
        this.h = uri;
    }

    public void k(Uri uri) {
        this.i = uri;
    }
}
