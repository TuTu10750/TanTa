package defpackage;

import android.view.MotionEvent;

/* loaded from: /tmp/classes2.dex */
public abstract class vm2 {
    public static int a(MotionEvent motionEvent) {
        return motionEvent.getActionMasked();
    }

    public static int b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static boolean c(MotionEvent motionEvent, int i) {
        return (motionEvent.getSource() & i) == i;
    }
}
