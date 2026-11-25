package com.zhpan.bannerview.indicator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.umeng.analytics.pro.bv;
import com.zhpan.indicator.base.BaseIndicatorView;
import defpackage.fb3;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0014¢\u0006\u0004\b\n\u0010\u000bJ1\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0018R\u0016\u0010\u001e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0018R\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u0018¨\u0006!"}, d2 = {"Lcom/zhpan/bannerview/indicator/DrawableIndicator;", "Lcom/zhpan/indicator/base/BaseIndicatorView;", "", "widthMeasureSpec", "heightMeasureSpec", "Lqc4;", "onMeasure", "(II)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "left", "top", "Landroid/graphics/Bitmap;", "icon", bv.aG, "(Landroid/graphics/Canvas;IILandroid/graphics/Bitmap;)V", "e", "Landroid/graphics/Bitmap;", "mCheckedBitmap", "f", "mNormalBitmap", "g", "I", "mIndicatorPadding", "mCheckedBitmapWidth", bv.aC, "mCheckedBitmapHeight", "j", "mNormalBitmapWidth", "k", "mNormalBitmapHeight", "bannerview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class DrawableIndicator extends BaseIndicatorView {

    /* renamed from: e, reason: from kotlin metadata */
    public Bitmap mCheckedBitmap;

    /* renamed from: f, reason: from kotlin metadata */
    public Bitmap mNormalBitmap;

    /* renamed from: g, reason: from kotlin metadata */
    public int mIndicatorPadding;

    /* renamed from: h, reason: from kotlin metadata */
    public int mCheckedBitmapWidth;

    /* renamed from: i, reason: from kotlin metadata */
    public int mCheckedBitmapHeight;

    /* renamed from: j, reason: from kotlin metadata */
    public int mNormalBitmapWidth;

    /* renamed from: k, reason: from kotlin metadata */
    public int mNormalBitmapHeight;

    public final void h(Canvas canvas, int left, int top2, Bitmap icon) {
        if (icon == null) {
            return;
        }
        canvas.drawBitmap(icon, left, top2, (Paint) null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        int measuredHeight;
        int i2;
        int measuredHeight2;
        canvas.getClass();
        super.onDraw(canvas);
        if (getPageSize() <= 1 || this.mCheckedBitmap == null || this.mNormalBitmap == null) {
            return;
        }
        int pageSize = getPageSize() + 1;
        for (int i3 = 1; i3 < pageSize; i3++) {
            Bitmap bitmap = this.mNormalBitmap;
            int i4 = i3 - 1;
            if (i4 < getCurrentPosition()) {
                i = i4 * (this.mNormalBitmapWidth + this.mIndicatorPadding);
                measuredHeight = getMeasuredHeight() / 2;
                i2 = this.mNormalBitmapHeight / 2;
            } else if (i4 == getCurrentPosition()) {
                i = i4 * (this.mNormalBitmapWidth + this.mIndicatorPadding);
                measuredHeight2 = (getMeasuredHeight() / 2) - (this.mCheckedBitmapHeight / 2);
                bitmap = this.mCheckedBitmap;
                h(canvas, i, measuredHeight2, bitmap);
            } else {
                i = (i4 * this.mIndicatorPadding) + ((i3 - 2) * this.mNormalBitmapWidth) + this.mCheckedBitmapWidth;
                measuredHeight = getMeasuredHeight() / 2;
                i2 = this.mNormalBitmapHeight / 2;
            }
            measuredHeight2 = measuredHeight - i2;
            h(canvas, i, measuredHeight2, bitmap);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(this.mCheckedBitmapWidth + ((this.mNormalBitmapWidth + this.mIndicatorPadding) * (getPageSize() - 1)), fb3.c(this.mCheckedBitmapHeight, this.mNormalBitmapHeight));
    }
}
