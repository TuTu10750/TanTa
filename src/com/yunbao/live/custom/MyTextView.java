package com.yunbao.live.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.yunbao.live.bean.ImpressBean;
import defpackage.ha3;

/* loaded from: /tmp/classes2.dex */
public class MyTextView extends AppCompatTextView {
    public Paint h;
    public Paint i;
    public int j;
    public boolean k;
    public int l;
    public int m;
    public RectF n;
    public float o;
    public int p;
    public ImpressBean q;

    public MyTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = context.getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ha3.m2);
        this.j = (int) obtainStyledAttributes.getDimension(ha3.p2, 0.0f);
        this.k = obtainStyledAttributes.getBoolean(ha3.n2, false);
        this.l = obtainStyledAttributes.getColor(ha3.o2, 0);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.h = paint;
        paint.setAntiAlias(true);
        this.h.setDither(true);
        int s = s(1);
        this.p = s;
        this.h.setStrokeWidth(s);
        this.h.setStyle(Paint.Style.STROKE);
        int i2 = this.l;
        if (i2 != 0) {
            this.h.setColor(i2);
        }
        this.n = new RectF();
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setAntiAlias(true);
        this.i.setDither(true);
        this.i.setStyle(Paint.Style.FILL);
    }

    private int s(int i) {
        return (int) ((this.o * i) + 0.5f);
    }

    public ImpressBean getBean() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        if (this.k) {
            Paint paint = this.i;
            if (paint != null) {
                RectF rectF = this.n;
                int i = this.j;
                canvas.drawRoundRect(rectF, i, i, paint);
            }
        } else {
            Paint paint2 = this.h;
            if (paint2 != null) {
                RectF rectF2 = this.n;
                int i2 = this.j;
                canvas.drawRoundRect(rectF2, i2, i2, paint2);
            }
        }
        super/*android.view.View*/.onDraw(canvas);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        RectF rectF = this.n;
        int i5 = this.p;
        rectF.top = i5;
        rectF.left = i5;
        rectF.right = i - i5;
        rectF.bottom = i2 - i5;
        this.i.setShader(new LinearGradient(0.0f, 0.0f, i, 0.0f, this.l, this.m, Shader.TileMode.CLAMP));
    }

    public void setBean(ImpressBean impressBean) {
        u(impressBean, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setChecked(boolean z) {
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            setTextColor(-1);
        } else {
            setTextColor(this.l);
        }
    }

    public boolean t() {
        return this.k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void u(ImpressBean impressBean, boolean z) {
        this.q = impressBean;
        if (!TextUtils.isEmpty(impressBean.getColor())) {
            this.l = Color.parseColor(impressBean.getColor());
        }
        if (!TextUtils.isEmpty(impressBean.getColor2())) {
            this.m = Color.parseColor(impressBean.getColor2());
        }
        this.h.setColor(this.l);
        this.k = impressBean.isChecked();
        if (z) {
            setText(impressBean.getName() + "(" + impressBean.getNums() + ")");
        } else {
            setText(impressBean.getName());
        }
        if (this.k) {
            setTextColor(-1);
        } else {
            setTextColor(this.l);
        }
    }
}
