package defpackage;

import android.graphics.Bitmap;

/* loaded from: /tmp/classes2.dex */
public final class il1 {
    public final Bitmap a;
    public final float b;

    public il1(Bitmap bitmap, float f) {
        bitmap.getClass();
        this.a = bitmap;
        this.b = f;
    }

    public final Bitmap a() {
        return this.a;
    }

    public final float b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof il1)) {
            return false;
        }
        il1 il1Var = (il1) obj;
        return dq1.a(this.a, il1Var.a) && Float.compare(this.b, il1Var.b) == 0;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Float.hashCode(this.b);
    }

    public String toString() {
        return "ImageData(bitmap=" + this.a + ", fileSizeKb=" + this.b + ")";
    }
}
