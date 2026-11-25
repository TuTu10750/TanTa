package com.yunbao.common.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.uc.crashsdk.export.LogType;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.bs3;
import defpackage.gk3;
import defpackage.j10;
import defpackage.j30;
import defpackage.lx1;
import defpackage.rx1;
import defpackage.uy1;
import defpackage.vq2;
import defpackage.y63;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class AbsActivity extends AppCompatActivity {
    public String a;
    public Context b;
    public List c;
    public boolean d;

    private void s1() {
        View findViewById = findViewById(y63.F);
        if (findViewById != null) {
            findViewById.setPadding(0, gk3.a().d(), 0, 0);
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(rx1.a(context));
    }

    public void b1(uy1 uy1Var) {
        List list = this.c;
        if (list == null || uy1Var == null) {
            return;
        }
        list.add(uy1Var);
    }

    public void backClick(View view) {
        if (view.getId() == y63.f) {
            onBackPressed();
        }
    }

    public boolean c1() {
        return j10.a();
    }

    public void d1(boolean z) {
        if (this.d != z) {
            r1(z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super/*android.app.Activity*/.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            if (!this.h1(e)) {
                throw e;
            }
            lx1.c(this.a, "ignore Huawei OverScroller HiEvent touch crash--->" + e.getMessage());
            return true;
        }
    }

    public boolean e1() {
        if (j30.q().N()) {
            return true;
        }
        u1();
        return false;
    }

    public void f1() {
    }

    public abstract int g1();

    public final boolean h1(NullPointerException nullPointerException) {
        StackTraceElement[] stackTrace = nullPointerException.getStackTrace();
        if (stackTrace == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                if ("com.huawei.hiview.HiEvent".equals(className)) {
                    z = true;
                } else if ("android.widget.OverScroller".equals(className) && "fling".equals(stackTraceElement.getMethodName())) {
                    z2 = true;
                }
                if (z && z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean i1() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.maxMemory() - (runtime.totalMemory() - runtime.freeMemory()) < 33554432;
    }

    public boolean j1() {
        return false;
    }

    public final boolean k1(ClassCastException classCastException) {
        String message = classCastException != null ? classCastException.getMessage() : null;
        if (message == null || !message.contains("SavedState")) {
            return false;
        }
        return message.contains("AbsSavedState") || message.contains("CompoundButton$SavedState");
    }

    public final boolean l1(IllegalArgumentException illegalArgumentException) {
        String message = illegalArgumentException != null ? illegalArgumentException.getMessage() : null;
        return message != null && message.contains("Wrong state class") && message.contains("expecting View State");
    }

    public void m1() {
    }

    public void n1(Bundle bundle) {
        m1();
    }

    public void o1(uy1 uy1Var) {
        List list = this.c;
        if (list != null) {
            list.remove(uy1Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        Bundle p1 = p1(bundle);
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(p1);
        this.a = getClass().getSimpleName();
        f1();
        r1(j1());
        int g1 = g1();
        if (g1 > 0) {
            q1(g1);
        }
        s1();
        this.b = this;
        this.c = new ArrayList();
        n1(p1);
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onCreate();
            }
        }
    }

    public void onDestroy() {
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onDestroy();
            }
            this.c.clear();
            this.c = null;
        }
        super.onDestroy();
    }

    public void onPause() {
        super/*androidx.fragment.app.FragmentActivity*/.onPause();
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onPause();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestart() {
        super/*android.app.Activity*/.onRestart();
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onReStart();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onRestoreInstanceState(Bundle bundle) {
        try {
            super/*android.app.Activity*/.onRestoreInstanceState(bundle);
        } catch (ClassCastException e) {
            if (!k1(e)) {
                throw e;
            }
            lx1.c(this.a, "ignore bad view saved state restore--->" + e.getMessage());
        } catch (IllegalArgumentException e2) {
            if (!l1(e2)) {
                throw e2;
            }
            lx1.c(this.a, "ignore wrong view saved state restore--->" + e2.getMessage());
        }
    }

    public void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onResume();
            }
        }
        v1();
    }

    public void onStart() {
        try {
            super.onStart();
        } catch (ClassCastException e) {
            if (!k1(e)) {
                throw e;
            }
            lx1.c(this.a, "ignore bad view saved state onStart--->" + e.getMessage());
        }
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onStart();
            }
        }
    }

    public void onStop() {
        super.onStop();
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((uy1) it.next()).onStop();
            }
        }
    }

    public final Bundle p1(Bundle bundle) {
        boolean z;
        if (bundle != null && i1()) {
            try {
                Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                boolean z2 = true;
                if (bundle2 == null || !bundle2.containsKey("android:support:activity-result")) {
                    z = false;
                } else {
                    bundle2.remove("android:support:activity-result");
                    z = true;
                }
                if (bundle.containsKey("android:support:activity-result")) {
                    bundle.remove("android:support:activity-result");
                } else {
                    z2 = z;
                }
                if (z2) {
                    lx1.c(getClass().getSimpleName(), "drop activity-result saved state before low-memory restore");
                    return bundle;
                }
            } catch (OutOfMemoryError unused) {
                bundle.clear();
                lx1.c(getClass().getSimpleName(), "clear saved state before onCreate OOM restore");
            } catch (RuntimeException e) {
                lx1.c(getClass().getSimpleName(), "sanitize saved state failed--->" + e.getMessage());
            }
        }
        return bundle;
    }

    public final void q1(int i) {
        if (MemoryPressureUtil.j()) {
            MemoryPressureUtil.e();
            lx1.c(getClass().getSimpleName(), "clear memory before setContentView, available=" + MemoryPressureUtil.g());
        }
        try {
            setContentView(i);
        } catch (OutOfMemoryError unused) {
            lx1.c(getClass().getSimpleName(), "setContentView oom, retry after clear memory");
            MemoryPressureUtil.e();
            setContentView(i);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r1(boolean z) {
        this.d = z;
        Window window = getWindow();
        window.clearFlags(67108864);
        if (z) {
            window.getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
        } else {
            window.getDecorView().setSystemUiVisibility(9472);
        }
        window.addFlags(ImageHolder.WRAP_CONTENT);
        window.setStatusBarColor(0);
    }

    public void t1(String str) {
        TextView textView = (TextView) findViewById(y63.i0);
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u1() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        vq2 vq2Var = new vq2();
        if (getSupportFragmentManager().O0()) {
            vq2Var.q2(getSupportFragmentManager(), "NotLoginDialogFragment");
        } else {
            vq2Var.d2(getSupportFragmentManager(), "NotLoginDialogFragment");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void v1() {
        float c = bs3.d().c();
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (c != attributes.screenBrightness) {
            attributes.screenBrightness = c;
            window.setAttributes(attributes);
        }
    }
}
