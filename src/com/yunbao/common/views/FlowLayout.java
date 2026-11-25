package com.yunbao.common.views;

import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.bv;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0014¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/yunbao/common/views/FlowLayout;", "Landroid/view/ViewGroup;", "", "pixelSize", "Lqc4;", "setHorizontalSpacing", "(F)V", "setVerticalSpacing", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "l", bv.aI, "r", "b", "onLayout", "(ZIIII)V", bv.av, "F", "mVerticalSpacing", "mHorizontalSpacing", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class FlowLayout extends ViewGroup {

    /* renamed from: a, reason: from kotlin metadata */
    public float mVerticalSpacing;

    /* renamed from: b, reason: from kotlin metadata */
    public float mHorizontalSpacing;

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
        int i = r - l;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int childCount = getChildCount();
        int i2 = paddingLeft;
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                i3 = Math.max(measuredHeight, i3);
                if (i2 + measuredWidth + paddingRight > i) {
                    paddingTop += (int) (this.mVerticalSpacing + i3);
                    i2 = paddingLeft;
                    i3 = measuredHeight;
                }
                childAt.layout(i2, paddingTop, i2 + measuredWidth, measuredHeight + paddingTop);
                i2 += (int) (measuredWidth + this.mHorizontalSpacing);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = 0;
        int resolveSize = View.resolveSize(0, widthMeasureSpec);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = paddingLeft;
        int i4 = paddingTop;
        while (i < childCount) {
            View childAt = getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i5 = i;
            childAt.measure(ViewGroup.getChildMeasureSpec(widthMeasureSpec, paddingLeft + paddingRight, layoutParams.width), ViewGroup.getChildMeasureSpec(heightMeasureSpec, paddingTop + paddingBottom, layoutParams.height));
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            i2 = Math.max(measuredHeight, i2);
            if (i3 + measuredWidth + paddingRight > resolveSize) {
                i4 += (int) (this.mVerticalSpacing + i2);
                i3 = paddingLeft;
                i2 = measuredHeight;
            } else {
                i3 += (int) (measuredWidth + this.mHorizontalSpacing);
            }
            i = i5 + 1;
        }
        setMeasuredDimension(resolveSize, View.resolveSize(i4 + i2 + paddingBottom, heightMeasureSpec));
    }

    public final void setHorizontalSpacing(float pixelSize) {
        this.mHorizontalSpacing = pixelSize;
    }

    public final void setVerticalSpacing(float pixelSize) {
        this.mVerticalSpacing = pixelSize;
    }
}
