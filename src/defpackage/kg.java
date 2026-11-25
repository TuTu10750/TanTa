package defpackage;

import android.content.res.Resources;
import android.util.TypedValue;

/* loaded from: /tmp/classes2.dex */
public abstract class kg {
    public static int a(float f) {
        return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static int b(boolean z, int i, int i2) {
        if (!z) {
            return i;
        }
        if (i == 0) {
            return i2 - 1;
        }
        if (i == i2 + 1) {
            return 0;
        }
        return i - 1;
    }
}
