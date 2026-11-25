package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public class u31 implements View.OnTouchListener {
    public WindowManager a = (WindowManager) CommonAppContext.n().getSystemService("window");
    public WindowManager.LayoutParams b;
    public View c;
    public int d;
    public int e;
    public float f;
    public float g;
    public float h;
    public float i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public Runnable n;

    public u31() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.b = layoutParams;
        layoutParams.gravity = 8388659;
        layoutParams.format = 1;
        layoutParams.flags = 552;
        layoutParams.windowAnimations = 0;
        layoutParams.type = 2038;
        this.k = ViewConfiguration.get(CommonAppContext.n()).getScaledTouchSlop();
    }

    public void a() {
        View view;
        try {
            if (this.a != null && (view = this.c) != null) {
                view.setOnTouchListener(null);
                this.m = false;
                this.a.removeView(this.c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.c = null;
        this.n = null;
        this.j = 0;
    }

    public final void b() {
        View view;
        if (this.a == null || this.b == null || (view = this.c) == null || !this.m) {
            return;
        }
        if (!view.isAttachedToWindow()) {
            this.m = false;
            return;
        }
        try {
            this.a.updateViewLayout(this.c, this.b);
        } catch (IllegalArgumentException e) {
            this.m = false;
            lx1.c("FloatWindow", "updateViewLayout failed: " + e.getMessage());
        } catch (Exception e2) {
            lx1.c("FloatWindow", "updateViewLayout failed: " + e2.getMessage());
        }
    }

    public void c(Runnable runnable) {
        this.n = runnable;
    }

    public void d(int i) {
        this.e = i;
        WindowManager.LayoutParams layoutParams = this.b;
        if (layoutParams != null) {
            layoutParams.height = i;
        }
    }

    public void e(View view) {
        view.setOnTouchListener(this);
        this.c = view;
    }

    public void f(boolean z) {
        WindowManager.LayoutParams layoutParams;
        if (this.a == null || (layoutParams = this.b) == null || this.c == null) {
            return;
        }
        if (z) {
            int i = this.j;
            if (i == 0) {
                i = gk3.a().c() - this.d;
            }
            layoutParams.x = i;
        } else {
            this.j = layoutParams.x;
            layoutParams.x = gk3.a().c();
        }
        b();
    }

    public void g(int i) {
        this.d = i;
        WindowManager.LayoutParams layoutParams = this.b;
        if (layoutParams != null) {
            layoutParams.width = i;
        }
    }

    public void h(int i) {
        WindowManager.LayoutParams layoutParams = this.b;
        if (layoutParams != null) {
            layoutParams.x = i;
        }
    }

    public void i(int i) {
        WindowManager.LayoutParams layoutParams = this.b;
        if (layoutParams != null) {
            layoutParams.y = i;
        }
    }

    public boolean j() {
        WindowManager.LayoutParams layoutParams;
        this.j = 0;
        try {
            WindowManager windowManager = this.a;
            if (windowManager != null && (layoutParams = this.b) != null) {
                windowManager.addView(this.c, layoutParams);
                this.m = true;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.m = false;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Runnable runnable;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        lx1.b("XXX--getActionMasked-->" + motionEvent.getActionMasked());
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.l = false;
            this.f = rawX;
            this.g = rawY;
            this.h = rawX;
            this.i = rawY;
        } else if (actionMasked != 1) {
            if (actionMasked == 2) {
                if (!this.l) {
                    this.l = Math.abs(rawX - this.f) > ((float) this.k) || Math.abs(rawY - this.g) > ((float) this.k);
                }
                if (this.l) {
                    float f = rawX - this.h;
                    float f2 = rawY - this.i;
                    float f3 = this.b.x + f;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    float c = gk3.a().c() - this.d;
                    if (f3 > c) {
                        f3 = c;
                    }
                    this.b.x = (int) f3;
                    float f4 = r3.y + f2;
                    float f5 = f4 >= 0.0f ? f4 : 0.0f;
                    float b = gk3.a().b() - this.e;
                    if (f5 > b) {
                        f5 = b;
                    }
                    this.b.y = (int) f5;
                    b();
                }
            }
        } else if (!this.l && (runnable = this.n) != null) {
            runnable.run();
        }
        this.h = rawX;
        this.i = rawY;
        return this.l;
    }
}
