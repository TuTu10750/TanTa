package defpackage;

import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public abstract class zn0 {
    public static float a = CommonAppContext.n().getResources().getDisplayMetrics().density;

    public static int a(int i) {
        return (int) ((a * i) + 0.5f);
    }
}
