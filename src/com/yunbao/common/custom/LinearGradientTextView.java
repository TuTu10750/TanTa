package com.yunbao.common.custom;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.appcompat.widget.AppCompatTextView;
import com.umeng.analytics.pro.bv;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001J/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/yunbao/common/custom/LinearGradientTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "w", bv.aG, "oldw", "oldh", "Lqc4;", "onSizeChanged", "(IIII)V", "Landroid/graphics/Canvas;", "canvas", "onDraw", "(Landroid/graphics/Canvas;)V", "I", "mStartColor", bv.aC, "mEndColor", "Landroid/graphics/Paint;", "j", "Landroid/graphics/Paint;", "mPaint", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class LinearGradientTextView extends AppCompatTextView {

    /* renamed from: h, reason: from kotlin metadata */
    public final int mStartColor;

    /* renamed from: i, reason: from kotlin metadata */
    public final int mEndColor;

    /* renamed from: j, reason: from kotlin metadata */
    public final Paint mPaint;

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas canvas) {
        canvas.getClass();
        String obj = getText().toString();
        this.mPaint.getFontMetricsInt().getClass();
        canvas.drawText(obj, 0.0f, getHeight() - r1.bottom, this.mPaint);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super/*android.view.View*/.onSizeChanged(w, h, oldw, oldh);
        this.mPaint.setShader(new LinearGradient(0.0f, 0.0f, w, h, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP));
    }
}
