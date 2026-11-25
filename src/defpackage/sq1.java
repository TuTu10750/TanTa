package defpackage;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /tmp/classes2.dex */
public class sq1 implements RecyclerView.s, GestureDetector.OnGestureListener {
    public final int a = 150;
    public View b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public Animator j;
    public rb1 k;
    public b l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            sq1.this.j = null;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            sq1.this.j = null;
            if (sq1.this.j()) {
                sq1.this.b = null;
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        RecyclerView.e0 a(View view);

        void b(RecyclerView.e0 e0Var);

        View c(float f, float f2);

        int d(RecyclerView.e0 e0Var);

        boolean e();
    }

    public sq1(Context context, b bVar) {
        this.l = bVar;
        this.k = new rb1(context, this);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d = viewConfiguration.getScaledTouchSlop();
        this.e = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        Animator animator = this.j;
        if ((animator == null || !animator.isRunning()) && this.b != null) {
            if (this.k.a(motionEvent)) {
                this.i = false;
                return;
            }
            int x = (int) motionEvent.getX();
            motionEvent.getY();
            int a2 = vm2.a(motionEvent);
            if (a2 != 1) {
                if (a2 == 2) {
                    int x2 = (int) (this.g - motionEvent.getX());
                    if (this.i) {
                        h(x2);
                    }
                    this.g = x;
                    return;
                }
                if (a2 != 3) {
                    return;
                }
            }
            if (this.i) {
                if (!l(0.0f) && j()) {
                    this.b = null;
                }
                this.i = false;
            }
        }
    }

    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int a2 = vm2.a(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        boolean z = false;
        if (recyclerView.getScrollState() != 0) {
            if (this.b != null) {
                l(75.0f);
                this.b = null;
            }
            return false;
        }
        Animator animator = this.j;
        if (animator != null && animator.isRunning()) {
            return true;
        }
        if (a2 == 0) {
            this.c = vm2.b(motionEvent, 0);
            this.g = (int) motionEvent.getX();
            this.h = (int) motionEvent.getY();
            if (this.b != null) {
                return !i(x, y);
            }
            this.b = this.l.c(x, y);
            return false;
        }
        if (a2 != 1) {
            if (a2 == 2) {
                int i = x - this.g;
                if (Math.abs(y - this.h) > Math.abs(i)) {
                    return false;
                }
                if (this.b != null && Math.abs(i) >= this.d) {
                    z = true;
                }
                this.i = z;
                return z;
            }
            if (a2 != 3) {
                return false;
            }
        }
        if (k()) {
            z = !i(x, y);
            l(75.0f);
        }
        this.b = null;
        return z;
    }

    public void c(boolean z) {
    }

    public int g() {
        RecyclerView.e0 a2 = this.l.a(this.b);
        if (a2 == null) {
            return 0;
        }
        return this.l.d(a2);
    }

    public final void h(int i) {
        b bVar = this.l;
        if (bVar != null && !bVar.e()) {
            if (i > 0) {
                this.l.b(this.l.a(this.b));
                return;
            }
            return;
        }
        int scrollX = this.b.getScrollX();
        int scrollY = this.b.getScrollY();
        int i2 = scrollX + i;
        if (i2 <= 0) {
            this.b.scrollTo(0, scrollY);
            return;
        }
        int g = g();
        int abs = Math.abs(i2);
        View view = this.b;
        if (abs < g) {
            view.scrollTo(i2, scrollY);
        } else {
            view.scrollTo(g, scrollY);
        }
    }

    public final boolean i(int i, int i2) {
        View view = this.b;
        if (view == null) {
            return false;
        }
        int width = this.b.getWidth() - view.getScrollX();
        return new Rect(width, this.b.getTop(), g() + width, this.b.getBottom()).contains(i, i2);
    }

    public final boolean j() {
        View view = this.b;
        return view != null && view.getScrollX() == 0;
    }

    public final boolean k() {
        View view;
        int g = g();
        return (g == 0 || (view = this.b) == null || view.getScrollX() != g) ? false : true;
    }

    public final boolean l(float f) {
        int abs;
        int scrollX = this.b.getScrollX();
        int g = g();
        if (this.j != null) {
            return false;
        }
        if (f == 0.0f) {
            abs = 150;
            if (scrollX <= g / 2) {
                g = 0;
            }
        } else {
            if (f > 0.0f) {
                g = 0;
            }
            abs = (int) ((1.0f - (Math.abs(f) / this.e)) * 150.0f);
        }
        if (g == scrollX) {
            return false;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.b, "scrollX", g);
        this.j = ofInt;
        ofInt.setDuration(abs);
        this.j.addListener(new a());
        this.j.start();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f) <= this.f || Math.abs(f) >= this.e || l(f)) {
            return false;
        }
        if (!j()) {
            return true;
        }
        this.b = null;
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
