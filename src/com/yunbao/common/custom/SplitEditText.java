package com.yunbao.common.custom;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import defpackage.da3;
import defpackage.ik;
import defpackage.p53;

/* loaded from: /tmp/classes2.dex */
public class SplitEditText extends AppCompatEditText {
    public Paint A;
    public b B;
    public int C;
    public float D;
    public int E;
    public int F;
    public int G;
    public int H;
    public RectF g;
    public RectF h;
    public Paint i;
    public Paint j;
    public Paint k;
    public Paint l;
    public Float m;
    public int n;
    public float o;
    public float p;
    public int q;
    public float r;
    public int s;
    public int t;
    public float u;
    public int v;
    public float w;
    public int x;
    public boolean y;
    public c z;

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        /* JADX WARN: Type inference failed for: r0v6, types: [com.yunbao.common.custom.SplitEditText, android.view.View] */
        @Override // java.lang.Runnable
        public void run() {
            SplitEditText.this.A.setAlpha(SplitEditText.this.A.getAlpha() == 0 ? 255 : 0);
            SplitEditText.this.invalidate();
            SplitEditText.this.postDelayed(this, r0.F);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void C(String str);

        void Z(String str);
    }

    public SplitEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SplitEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        r(context, attributeSet);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private float getContentItemWidth() {
        float f;
        float f2;
        float floatValue;
        int i = this.v;
        if (i == 2) {
            float width = getWidth();
            int i2 = this.s;
            f = width - ((i2 - 1) * this.u);
            f2 = i2 * 2;
            floatValue = this.m.floatValue();
        } else if (i != 3) {
            f = getWidth() - (this.p * (this.s - 1));
            f2 = this.m.floatValue();
            floatValue = 2.0f;
        } else {
            f = getWidth();
            f2 = this.s - 1;
            floatValue = this.u;
        }
        return (f - (f2 * floatValue)) / this.s;
    }

    public final float g(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public int getContentShowMode() {
        return this.t;
    }

    public int getInputBoxStyle() {
        return this.v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(Canvas canvas) {
        this.g.setEmpty();
        this.g.set(this.m.floatValue() / 2.0f, this.m.floatValue() / 2.0f, getWidth() - (this.m.floatValue() / 2.0f), getHeight() - (this.m.floatValue() / 2.0f));
        RectF rectF = this.g;
        float f = this.o;
        canvas.drawRoundRect(rectF, f, f, this.k);
        k(canvas);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Canvas canvas) {
        int height = getHeight() / 2;
        String trim = getText().toString().trim();
        int i = this.t;
        Paint paint = this.j;
        int i2 = 0;
        if (i == 1) {
            paint.setColor(-16777216);
            while (i2 < trim.length()) {
                canvas.drawCircle(o(i2), height, this.r, this.j);
                i2++;
            }
            return;
        }
        paint.setColor(this.x);
        float p = p(this.j, height);
        while (i2 < trim.length()) {
            float o = o(i2);
            String valueOf = String.valueOf(trim.charAt(i2));
            canvas.drawText(valueOf, o - (this.j.measureText(valueOf) / 2.0f), p, this.j);
            i2++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(Canvas canvas) {
        if (this.E > getHeight()) {
            throw new InflateException("cursor height must smaller than view height");
        }
        float o = o(getText().toString().trim().length());
        if (this.E == 0) {
            this.E = getHeight() / 2;
        }
        canvas.drawLine(o, this.m.floatValue() + ((getHeight() - this.E) / 2), o, (getHeight() - r0) - this.m.floatValue(), this.A);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void k(Canvas canvas) {
        float height = getHeight() - this.m.floatValue();
        int i = 0;
        while (i < this.s - 1) {
            int i2 = i + 1;
            float contentItemWidth = (i2 * getContentItemWidth()) + (i * this.p) + this.m.floatValue() + (this.p / 2.0f);
            canvas.drawLine(contentItemWidth, this.m.floatValue(), contentItemWidth, height, this.i);
            i = i2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(Canvas canvas) {
        int i = 0;
        while (i < this.s) {
            this.h.setEmpty();
            float f = i;
            i++;
            this.h.set((getContentItemWidth() * f) + (this.u * f) + (this.m.floatValue() * f * 2.0f) + (this.m.floatValue() / 2.0f), this.m.floatValue() / 2.0f, (((f * this.u) + (i * getContentItemWidth())) + ((i * 2) * this.m.floatValue())) - (this.m.floatValue() / 2.0f), getHeight() - (this.m.floatValue() / 2.0f));
            RectF rectF = this.h;
            float f2 = this.o;
            canvas.drawRoundRect(rectF, f2, f2, this.k);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(Canvas canvas) {
        String trim = getText().toString().trim();
        for (int i = 0; i < this.s; i++) {
            float f = i;
            float contentItemWidth = (getContentItemWidth() * f) + (f * this.u);
            float contentItemWidth2 = getContentItemWidth() + contentItemWidth;
            float height = getHeight() - (this.m.floatValue() / 2.0f);
            if (this.G != 0) {
                int length = trim.length();
                Paint paint = this.l;
                if (length >= i) {
                    paint.setColor(this.G);
                } else {
                    paint.setColor(this.H);
                }
            }
            canvas.drawLine(contentItemWidth, height, contentItemWidth2, height, this.l);
        }
    }

    public final float n(int i) {
        float f;
        float f2;
        float floatValue;
        int i2 = this.v;
        if (i2 == 2) {
            int i3 = this.s;
            f = i - ((i3 - 1) * this.u);
            f2 = i3 * 2;
            floatValue = this.m.floatValue();
        } else if (i2 != 3) {
            f = i - (this.p * (this.s - 1));
            f2 = this.m.floatValue();
            floatValue = 2.0f;
        } else {
            f = i;
            f2 = this.s - 1;
            floatValue = this.u;
        }
        return (f - (f2 * floatValue)) / this.s;
    }

    public final float o(int i) {
        int i2 = this.v;
        if (i2 == 2) {
            float f = i;
            return (getContentItemWidth() / 2.0f) + (getContentItemWidth() * f) + (f * this.u) + (((i * 2) + 1) * this.m.floatValue());
        }
        if (i2 != 3) {
            float f2 = i;
            return (getContentItemWidth() / 2.0f) + (getContentItemWidth() * f2) + (f2 * this.p) + this.m.floatValue();
        }
        float f3 = i;
        return (getContentItemWidth() / 2.0f) + (this.u * f3) + (f3 * getContentItemWidth());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachedToWindow() {
        super/*android.view.View*/.onAttachedToWindow();
        if (hasFocus()) {
            t();
        }
    }

    public void onDetachedFromWindow() {
        u();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        int i = this.v;
        if (i == 2) {
            l(canvas);
        } else if (i != 3) {
            h(canvas);
        } else {
            m(canvas);
        }
        i(canvas);
        if (hasFocus()) {
            j(canvas);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super/*android.view.View*/.onFocusChanged(z, i, rect);
        if (z) {
            t();
        } else {
            u();
        }
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onMeasure(int i, int i2) {
        super/*android.view.View*/.onMeasure(i, i2);
        if (this.y) {
            int size = View.MeasureSpec.getSize(i);
            float n = n(size);
            int i3 = this.v;
            Float f = this.m;
            if (i3 != 3) {
                setMeasuredDimension(size, (int) (n + (f.floatValue() * 2.0f)));
            } else {
                setMeasuredDimension(size, (int) (n + f.floatValue()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super/*android.widget.TextView*/.onTextChanged(charSequence, i, i2, i3);
        String trim = charSequence.toString().trim();
        c cVar = this.z;
        if (cVar != null) {
            cVar.C(trim);
            if (trim.length() == this.s) {
                this.z.Z(trim);
            }
        }
    }

    public final float p(Paint paint, float f) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.bottom;
        return f + (((f2 - fontMetrics.top) / 2.0f) - f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q() {
        Paint paint = new Paint(1);
        this.k = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.k.setStrokeWidth(this.m.floatValue());
        this.k.setColor(this.n);
        Paint paint2 = new Paint(1);
        this.i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.i.setStrokeWidth(this.p);
        this.i.setColor(this.q);
        Paint paint3 = new Paint(1);
        this.j = paint3;
        paint3.setTextSize(this.w);
        Paint paint4 = new Paint(1);
        this.A = paint4;
        paint4.setStrokeWidth(this.D);
        this.A.setColor(this.C);
        Paint paint5 = new Paint(1);
        this.l = paint5;
        paint5.setStrokeWidth(this.m.floatValue());
        this.l.setColor(this.H);
        this.h = new RectF();
        this.g = new RectF();
        setSingleLine();
        setFocusableInTouchMode(true);
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(this.s)});
    }

    public final void r(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, da3.c4);
        this.m = Float.valueOf(obtainStyledAttributes.getDimension(da3.g4, g(1.0f)));
        this.n = obtainStyledAttributes.getColor(da3.f4, -16777216);
        this.o = obtainStyledAttributes.getDimension(da3.k4, 0.0f);
        this.p = obtainStyledAttributes.getDimension(da3.q4, g(1.0f));
        this.q = obtainStyledAttributes.getColor(da3.p4, -16777216);
        this.r = obtainStyledAttributes.getDimension(da3.h4, g(5.0f));
        this.s = obtainStyledAttributes.getInt(da3.i4, 6);
        this.t = obtainStyledAttributes.getInteger(da3.j4, 1);
        this.v = obtainStyledAttributes.getInteger(da3.s4, 1);
        this.u = obtainStyledAttributes.getDimension(da3.t4, g(10.0f));
        this.w = obtainStyledAttributes.getDimension(da3.d4, s(16.0f));
        this.x = obtainStyledAttributes.getColor(da3.e4, -16777216);
        this.y = obtainStyledAttributes.getBoolean(da3.r4, true);
        this.C = obtainStyledAttributes.getColor(da3.l4, o60.b(context, p53.e));
        this.F = obtainStyledAttributes.getInt(da3.m4, 500);
        this.D = obtainStyledAttributes.getDimension(da3.o4, g(2.0f));
        this.E = (int) obtainStyledAttributes.getDimension(da3.n4, 0.0f);
        this.H = obtainStyledAttributes.getInt(da3.v4, -16777216);
        this.G = obtainStyledAttributes.getInt(da3.u4, 0);
        obtainStyledAttributes.recycle();
        q();
    }

    public final float s(float f) {
        return TypedValue.applyDimension(2, f, Resources.getSystem().getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setContentShowMode(int i) {
        if (i != 1 && i != 2) {
            ik.a("the value of the parameter must be one of{1:EDIT_SHOW_MODE_PASSWORD} or {2:EDIT_SHOW_MODE_TEXT}");
        } else {
            this.t = i;
            invalidate();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInputBoxStyle(int i) {
        if (i != 1 && i != 2 && i != 3) {
            ik.a("the value of the parameter must be one of{1:INPUT_BOX_STYLE_CONNECT}, {2:INPUT_BOX_STYLE_SINGLE} or {3:INPUT_BOX_STYLE_UNDERLINE}");
        } else {
            this.v = i;
            requestLayout();
        }
    }

    public void setOnInputListener(c cVar) {
        this.z = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        if (this.B == null) {
            this.B = new b();
        }
        postDelayed(this.B, this.F);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() {
        b bVar = this.B;
        if (bVar != null) {
            removeCallbacks(bVar);
        }
    }
}
