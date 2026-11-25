package com.yunbao.video.custom;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;

/* loaded from: /tmp/classes2.dex */
public class ThumbView extends View {
    public final int a;
    public Drawable b;
    public boolean c;
    public int d;
    public int e;

    public ThumbView(Context context, int i, Drawable drawable) {
        super(context);
        this.d = i;
        this.b = drawable;
        this.a = (int) TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        setBackgroundDrawable(this.b);
    }

    public boolean a(int i, int i2) {
        Rect rect = new Rect();
        getHitRect(rect);
        int i3 = rect.left;
        int i4 = this.a;
        rect.left = i3 - i4;
        rect.right += i4;
        rect.top -= i4;
        rect.bottom += i4;
        return rect.contains(i, i2);
    }

    public int getRangeIndex() {
        return this.e;
    }

    @Override // android.view.View
    public boolean isPressed() {
        return this.c;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.d, 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824));
        this.b.setBounds(0, 0, this.d, getMeasuredHeight());
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        this.c = z;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.b = drawable;
    }

    public void setThumbWidth(int i) {
        this.d = i;
    }

    public void setTickIndex(int i) {
        this.e = i;
    }
}
