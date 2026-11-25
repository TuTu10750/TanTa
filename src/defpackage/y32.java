package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.music.LrcTextView;
import defpackage.x32;

/* loaded from: /tmp/classes2.dex */
public class y32 extends b1 implements View.OnClickListener, View.OnTouchListener {
    public LrcTextView a;
    public TextView b;
    public TextView c;
    public oh1 d;
    public int e;
    public int f;
    public float g;
    public float h;
    public x32 i;
    public final StringBuilder j;
    public final Runnable k;
    public final Handler l;
    public long m;
    public int n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (y32.this.c != null) {
                y32.this.c.setText(rv3.e(y32.this.n, y32.this.j));
            }
            y32.e0(y32.this);
            y32.i0(y32.this, 1000L);
            y32.this.l.postAtTime(y32.this.k, y32.this.m);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements x32.a {
        public b() {
        }

        @Override // x32.a
        public void a(String str) {
            if (y32.this.d != null) {
                y32.this.d.M(str);
            }
            y32.this.l.removeCallbacksAndMessages(null);
            y32.this.m = SystemClock.uptimeMillis();
            y32.this.n = 0;
            if (y32.this.k != null) {
                y32.this.k.run();
            }
        }

        @Override // x32.a
        public void b(boolean z) {
            if (z || y32.this.a == null) {
                return;
            }
            y32.this.a.setText(m93.P8);
        }

        @Override // x32.a
        public void c(String str) {
            if (y32.this.a != null) {
                y32.this.a.setText(str);
            }
        }

        @Override // x32.a
        public void d(float f) {
            if (y32.this.a != null) {
                y32.this.a.setProgress(f);
            }
        }

        @Override // x32.a
        public void e(String str) {
            Context context = y32.this.mContext;
            y32 y32Var = y32.this;
            if (context != null) {
                ((LiveAnchorActivity) y32Var.mContext).R3();
            } else {
                y32Var.release();
            }
        }
    }

    public y32(Context context, ViewGroup viewGroup, oh1 oh1Var) {
        super(context, viewGroup);
        this.d = oh1Var;
        this.e = viewGroup.getWidth();
        this.f = viewGroup.getHeight();
        this.j = new StringBuilder();
        this.l = new Handler();
        this.k = new a();
    }

    public static /* synthetic */ int e0(y32 y32Var) {
        int i = y32Var.n;
        y32Var.n = i + 1;
        return i;
    }

    public static /* synthetic */ long i0(y32 y32Var, long j) {
        long j2 = y32Var.m + j;
        y32Var.m = j2;
        return j2;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.c2;
    }

    @Override // defpackage.b1
    public void init() {
        TextView textView = (TextView) findViewById(b73.X);
        this.b = textView;
        textView.setOnClickListener(this);
        this.c = (TextView) findViewById(b73.e5);
        this.a = (LrcTextView) findViewById(b73.O3);
        this.mContentView.setOnTouchListener(this);
        x32 x32Var = new x32();
        this.i = x32Var;
        x32Var.d(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == b73.X) {
            ((LiveAnchorActivity) this.mContext).R3();
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.g = rawX;
            this.h = rawY;
        } else if (action == 2) {
            float f = rawX - this.g;
            float f2 = rawY - this.h;
            if (f != 0.0f) {
                float translationX = this.mContentView.getTranslationX() + f;
                if (translationX < 0.0f) {
                    translationX = 0.0f;
                }
                float width = this.e - this.mContentView.getWidth();
                if (translationX > width) {
                    translationX = width;
                }
                this.mContentView.setTranslationX(translationX);
            }
            if (f2 != 0.0f) {
                float translationY = this.mContentView.getTranslationY() + f2;
                float f3 = translationY >= 0.0f ? translationY : 0.0f;
                float height = this.f - this.mContentView.getHeight();
                if (f3 > height) {
                    f3 = height;
                }
                this.mContentView.setTranslationY(f3);
            }
        }
        this.g = rawX;
        this.h = rawY;
        return true;
    }

    public void p0(String str) {
        x32 x32Var;
        if (TextUtils.isEmpty(str) || (x32Var = this.i) == null) {
            return;
        }
        x32Var.b(str);
    }

    @Override // defpackage.b1
    public void release() {
        this.l.removeCallbacksAndMessages(null);
        x32 x32Var = this.i;
        if (x32Var != null) {
            x32Var.c();
        }
        this.i = null;
        removeFromParent();
        oh1 oh1Var = this.d;
        if (oh1Var != null) {
            oh1Var.v();
        }
        this.d = null;
    }
}
