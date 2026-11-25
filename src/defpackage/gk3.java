package defpackage;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public class gk3 {
    public static gk3 f;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    public gk3() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) CommonAppContext.n().getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(displayMetrics);
        this.b = displayMetrics.widthPixels;
        this.c = displayMetrics.heightPixels;
        defaultDisplay.getRealMetrics(displayMetrics);
        this.d = displayMetrics.heightPixels;
        Resources resources = CommonAppContext.n().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.a = resources.getDimensionPixelSize(identifier);
        } else {
            this.a = 0;
        }
        if (resources.getIdentifier("navigation_bar_height", "dimen", "android") > 0) {
            this.e = resources.getDimensionPixelSize(identifier);
        } else {
            this.e = 0;
        }
    }

    public static gk3 a() {
        if (f == null) {
            synchronized (gk3.class) {
                try {
                    if (f == null) {
                        f = new gk3();
                    }
                } finally {
                }
            }
        }
        return f;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }
}
