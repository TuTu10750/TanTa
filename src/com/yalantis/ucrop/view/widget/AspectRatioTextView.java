package com.yalantis.ucrop.view.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.ba3;
import defpackage.o53;
import defpackage.w53;
import defpackage.wb;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public class AspectRatioTextView extends AppCompatTextView {
    public final float h;
    public final Rect i;
    public Paint j;
    public int k;
    public float l;
    public String m;
    public float n;
    public float o;

    public AspectRatioTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.h = 1.5f;
        this.i = new Rect();
        u(context.obtainStyledAttributes(attributeSet, ba3.U));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        super/*android.view.View*/.onDraw(canvas);
        if (isSelected()) {
            canvas.getClipBounds(this.i);
            Rect rect = this.i;
            float f = (rect.right - rect.left) / 2.0f;
            float f2 = rect.bottom - (rect.top / 2.0f);
            int i = this.k;
            canvas.drawCircle(f, f2 - (i * 1.5f), i / 2.0f, this.j);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void s(int i) {
        Paint paint = this.j;
        if (paint != null) {
            paint.setColor(i);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[]{0}}, new int[]{i, o60.b(getContext(), o53.k)}));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setActiveColor(int i) {
        s(i);
        invalidate();
    }

    public void setAspectRatio(wb wbVar) {
        this.m = wbVar.e();
        this.n = wbVar.f();
        float g = wbVar.g();
        this.o = g;
        float f = this.n;
        if (f == 0.0f || g == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f / g;
        }
        v();
    }

    public float t(boolean z) {
        if (z) {
            w();
            v();
        }
        return this.l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u(TypedArray typedArray) {
        setGravity(1);
        this.m = typedArray.getString(ba3.V);
        this.n = typedArray.getFloat(ba3.W, 0.0f);
        float f = typedArray.getFloat(ba3.X, 0.0f);
        this.o = f;
        float f2 = this.n;
        if (f2 == 0.0f || f == 0.0f) {
            this.l = 0.0f;
        } else {
            this.l = f2 / f;
        }
        this.k = getContext().getResources().getDimensionPixelSize(w53.h);
        Paint paint = new Paint(1);
        this.j = paint;
        paint.setStyle(Paint.Style.FILL);
        v();
        s(getResources().getColor(o53.l));
        typedArray.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v() {
        if (TextUtils.isEmpty(this.m)) {
            setText(String.format(Locale.US, "%d:%d", Integer.valueOf((int) this.n), Integer.valueOf((int) this.o)));
        } else {
            setText(this.m);
        }
    }

    public final void w() {
        if (this.l != 0.0f) {
            float f = this.n;
            float f2 = this.o;
            this.n = f2;
            this.o = f;
            this.l = f2 / f;
        }
    }
}
