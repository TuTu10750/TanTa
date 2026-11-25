package com.yunbao.video.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public class RecordProgressView extends View {
    public final String a;
    public float b;
    public Paint c;
    public Paint d;
    public Paint e;
    public int f;
    public int g;
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public Handler l;
    public ArrayList m;
    public b n;
    public boolean o;
    public int p;
    public int q;
    public int r;
    public Runnable s;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordProgressView.this.j = !r0.j;
            RecordProgressView.this.l.postDelayed(RecordProgressView.this.s, 500L);
            RecordProgressView.this.invalidate();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b {
        public int a;
        public int b;

        public b() {
        }

        public /* synthetic */ b(RecordProgressView recordProgressView, a aVar) {
            this();
        }
    }

    public RecordProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = "RecordProgressView";
        this.j = false;
        this.k = false;
        this.s = new a();
        this.b = context.getResources().getDisplayMetrics().density;
        f();
    }

    public final int e(int i) {
        return (int) ((this.b * i) + 0.5f);
    }

    public final void f() {
        this.c = new Paint();
        this.d = new Paint();
        this.e = new Paint();
        this.c.setAntiAlias(true);
        this.d.setAntiAlias(true);
        this.e.setAntiAlias(true);
        this.f = 1711276032;
        this.g = -42888;
        this.h = -42888;
        this.i = -1;
        this.c.setColor(-42888);
        this.d.setColor(this.h);
        this.e.setColor(this.i);
        this.m = new ArrayList();
        this.n = new b(this, null);
        this.o = false;
        this.l = new Handler();
        g();
    }

    public final void g() {
        Handler handler = this.l;
        if (handler != null) {
            handler.postDelayed(this.s, 500L);
        }
    }

    public final void h() {
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        canvas.drawColor(this.f);
        Iterator it = this.m.iterator();
        int i2 = 0;
        float f = 0.0f;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            float width = getWidth() * ((bVar.a + i2) / this.p);
            int i3 = bVar.b;
            if (i3 == 1) {
                canvas.drawRect(f, 0.0f, width, getHeight(), this.c);
            } else if (i3 == 2) {
                canvas.drawRect(f, 0.0f, width, getHeight(), this.d);
            } else if (i3 == 3) {
                canvas.drawRect(f - e(1), 0.0f, width, getHeight(), this.e);
            }
            i2 += bVar.a;
            f = width;
        }
        b bVar2 = this.n;
        if (bVar2 != null && (i = bVar2.a) != 0) {
            canvas.drawRect(f, 0.0f, f + ((i / this.p) * getWidth()), getHeight(), this.c);
            f += (this.n.a / this.p) * getWidth();
        }
        float f2 = f;
        int i4 = i2 + this.n.a;
        int i5 = this.q;
        if (i4 < i5) {
            canvas.drawRect(getWidth() * (i5 / this.p), 0.0f, ((this.q / this.p) * getWidth()) + e(2), getHeight(), this.e);
        }
        if (this.j || this.k) {
            canvas.drawRect(f2, 0.0f, f2 + e(2), getHeight(), this.e);
        }
    }

    public void setMaxDuration(int i) {
        this.p = i;
    }

    public void setMinDuration(int i) {
        this.q = i;
    }

    public void setProgress(int i) {
        this.k = true;
        h();
        if (this.o) {
            Iterator it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b bVar = (b) it.next();
                if (bVar.b == 2) {
                    bVar.b = 1;
                    this.o = false;
                    break;
                }
            }
        }
        b bVar2 = this.n;
        bVar2.b = 1;
        bVar2.a = i - this.r;
        invalidate();
    }
}
