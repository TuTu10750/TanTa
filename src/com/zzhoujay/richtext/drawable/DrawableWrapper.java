package com.zzhoujay.richtext.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.zzhoujay.richtext.ImageHolder;

/* loaded from: /tmp/classes2.dex */
public class DrawableWrapper extends Drawable {
    private Drawable drawable;
    private boolean hasCache;
    private Paint paint;
    private DrawableSizeHolder sizeHolder;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private float translateX = 0.0f;
    private float translateY = 0.0f;

    /* renamed from: com.zzhoujay.richtext.drawable.DrawableWrapper$1, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType;

        static {
            int[] iArr = new int[ImageHolder.ScaleType.values().length];
            $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType = iArr;
            try {
                iArr[ImageHolder.ScaleType.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.center.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.center_crop.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.center_inside.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.fit_center.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.fit_start.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.fit_end.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.fit_xy.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[ImageHolder.ScaleType.fit_auto.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public DrawableWrapper(ImageHolder imageHolder) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        DrawableSizeHolder drawableSizeHolder = new DrawableSizeHolder(imageHolder);
        this.sizeHolder = drawableSizeHolder;
        this.hasCache = false;
        setUpBorderHolder(drawableSizeHolder.borderHolder);
        setBounds(this.sizeHolder.border);
    }

    public DrawableWrapper(DrawableSizeHolder drawableSizeHolder) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.sizeHolder = drawableSizeHolder;
        this.hasCache = true;
        setUpBorderHolder(drawableSizeHolder.borderHolder);
        setBounds(drawableSizeHolder.border);
    }

    private void center(int i, int i2, int i3, int i4) {
        this.translateX = (i3 - i) / 2.0f;
        this.translateY = (i4 - i2) / 2.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r0 > 1.0f) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void centerCrop(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            float r7 = (float) r7
            float r5 = (float) r5
            float r0 = r7 / r5
            float r8 = (float) r8
            float r6 = (float) r6
            float r1 = r8 / r6
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 <= 0) goto L13
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 <= 0) goto L19
            goto L1a
        L13:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 <= 0) goto L19
            r0 = r1
            goto L1a
        L19:
            r0 = r3
        L1a:
            float r5 = r5 * r0
            float r6 = r6 * r0
            float r7 = r7 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r0
            float r7 = r7 / r5
            r4.translateX = r7
            float r8 = r8 - r6
            float r8 = r8 / r5
            r4.translateY = r8
            r4.scaleX = r0
            r4.scaleY = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zzhoujay.richtext.drawable.DrawableWrapper.centerCrop(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (r0 < 1.0f) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void centerInside(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            float r7 = (float) r7
            float r5 = (float) r5
            float r0 = r7 / r5
            float r8 = (float) r8
            float r6 = (float) r6
            float r1 = r8 / r6
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r2 >= 0) goto L13
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 >= 0) goto L19
            goto L1a
        L13:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L19
            r0 = r1
            goto L1a
        L19:
            r0 = r3
        L1a:
            float r5 = r5 * r0
            float r6 = r6 * r0
            float r7 = r7 - r5
            r5 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r0
            float r7 = r7 / r5
            r4.translateX = r7
            float r8 = r8 - r6
            float r8 = r8 / r5
            r4.translateY = r8
            r4.scaleX = r0
            r4.scaleY = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zzhoujay.richtext.drawable.DrawableWrapper.centerInside(int, int, int, int):void");
    }

    private void drawBorder(Canvas canvas) {
        DrawableBorderHolder drawableBorderHolder;
        DrawableSizeHolder drawableSizeHolder = this.sizeHolder;
        if (drawableSizeHolder == null || (drawableBorderHolder = drawableSizeHolder.borderHolder) == null || !drawableBorderHolder.isShowBorder()) {
            return;
        }
        DrawableSizeHolder drawableSizeHolder2 = this.sizeHolder;
        if (drawableSizeHolder2.border != null) {
            float radius = drawableSizeHolder2.borderHolder.getRadius();
            canvas.drawRoundRect(this.sizeHolder.border, radius, radius, this.paint);
        }
    }

    private void drawImage(Canvas canvas) {
        canvas.save();
        canvas.scale(this.scaleX, this.scaleY);
        canvas.translate(this.translateX, this.translateY);
        this.drawable.draw(canvas);
        canvas.restore();
    }

    private void fitAuto(int i, int i2, int i3, int i4) {
        DrawableSizeHolder drawableSizeHolder;
        float f = i3;
        float f2 = f / i;
        int i5 = (int) (i2 * f2);
        this.scaleX = f2;
        this.scaleY = f2;
        this.translateX = 0.0f;
        this.translateY = 0.0f;
        setBounds(0, 0, i3, i5);
        if (!this.hasCache || (drawableSizeHolder = this.sizeHolder) == null) {
            return;
        }
        drawableSizeHolder.border.set(0.0f, 0.0f, f, i5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r0 != false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void fitCenter(int r4, int r5, int r6, int r7, int r8) {
        /*
            r3 = this;
            float r6 = (float) r6
            float r4 = (float) r4
            float r0 = r6 / r4
            float r7 = (float) r7
            float r5 = (float) r5
            float r1 = r7 / r5
            float r2 = java.lang.Math.min(r0, r1)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L12
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            float r4 = r4 * r2
            float r5 = r5 * r2
            float r6 = r6 - r4
            r4 = 1073741824(0x40000000, float:2.0)
            float r1 = r6 / r4
            float r7 = r7 - r5
            float r4 = r7 / r4
            if (r8 >= 0) goto L27
            r6 = 0
            if (r0 == 0) goto L24
        L22:
            r7 = r4
            goto L2e
        L24:
            r7 = r6
        L25:
            r6 = r1
            goto L2e
        L27:
            if (r8 <= 0) goto L2c
            if (r0 == 0) goto L25
            goto L22
        L2c:
            r7 = r4
            goto L25
        L2e:
            r3.scaleX = r2
            r3.scaleY = r2
            float r6 = r6 / r2
            r3.translateX = r6
            float r7 = r7 / r2
            r3.translateY = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zzhoujay.richtext.drawable.DrawableWrapper.fitCenter(int, int, int, int, int):void");
    }

    private void fitXY(int i, int i2, int i3, int i4) {
        this.scaleX = i3 / i;
        this.scaleY = i4 / i2;
        this.translateX = 0.0f;
        this.translateY = 0.0f;
    }

    private void none(int i, int i2, int i3, int i4) {
        this.translateX = 0.0f;
        this.translateY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
    }

    private void setBounds(float f, float f2, float f3, float f4) {
        setBounds((int) f, (int) f2, (int) f3, (int) f4);
    }

    private void setBounds(RectF rectF) {
        setBounds(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    private void setUpBorderHolder(DrawableBorderHolder drawableBorderHolder) {
        if (drawableBorderHolder != null) {
            this.paint.setColor(drawableBorderHolder.getBorderColor());
            this.paint.setStrokeWidth(drawableBorderHolder.getBorderSize());
            this.paint.setStyle(Paint.Style.STROKE);
        }
    }

    public void calculate() {
        int width;
        int height;
        Drawable drawable = this.drawable;
        if (drawable instanceof BitmapDrawable) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            width = bitmap.getWidth();
            height = bitmap.getHeight();
        } else if (drawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) drawable;
            width = gifDrawable.getWidth();
            height = gifDrawable.getHeight();
        } else {
            Rect bounds = drawable.getBounds();
            width = bounds.width();
            height = bounds.height();
        }
        int i = height;
        int i2 = width;
        Rect bounds2 = getBounds();
        int width2 = bounds2.width();
        int height2 = bounds2.height();
        if (width2 <= 0 || height2 <= 0) {
            return;
        }
        DrawableSizeHolder drawableSizeHolder = this.sizeHolder;
        switch (AnonymousClass1.$SwitchMap$com$zzhoujay$richtext$ImageHolder$ScaleType[(drawableSizeHolder == null ? ImageHolder.ScaleType.none : drawableSizeHolder.scaleType).ordinal()]) {
            case 1:
                none(i2, i, width2, height2);
                return;
            case 2:
                center(i2, i, width2, height2);
                return;
            case 3:
                centerCrop(i2, i, width2, height2);
                return;
            case 4:
                centerInside(i2, i, width2, height2);
                return;
            case 5:
                fitCenter(i2, i, width2, height2, 0);
                return;
            case 6:
                fitCenter(i2, i, width2, height2, -1);
                return;
            case 7:
                fitCenter(i2, i, width2, height2, 1);
                return;
            case 8:
                fitXY(i2, i, width2, height2);
                return;
            case 9:
                fitAuto(i2, i, width2, height2);
                return;
            default:
                return;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        canvas.save();
        if (this.drawable != null) {
            canvas.clipRect(getBounds());
            Drawable drawable = this.drawable;
            if ((drawable instanceof BitmapDrawable) && ((bitmap = ((BitmapDrawable) drawable).getBitmap()) == null || bitmap.isRecycled())) {
                return;
            } else {
                drawImage(canvas);
            }
        }
        drawBorder(canvas);
        canvas.restore();
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.drawable;
        if (drawable == null) {
            return -2;
        }
        return drawable.getOpacity();
    }

    public DrawableSizeHolder getSizeHolder() {
        return this.sizeHolder;
    }

    public boolean isHasCache() {
        return this.hasCache;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
    }

    public void setBorderHolder(DrawableBorderHolder drawableBorderHolder) {
        DrawableSizeHolder drawableSizeHolder;
        if (this.hasCache || (drawableSizeHolder = this.sizeHolder) == null) {
            return;
        }
        drawableSizeHolder.borderHolder.set(drawableBorderHolder);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        DrawableSizeHolder drawableSizeHolder;
        super.setBounds(i, i2, i3, i4);
        if (this.hasCache || (drawableSizeHolder = this.sizeHolder) == null) {
            return;
        }
        drawableSizeHolder.border.set(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        DrawableSizeHolder drawableSizeHolder;
        super.setBounds(rect);
        if (this.hasCache || (drawableSizeHolder = this.sizeHolder) == null) {
            return;
        }
        drawableSizeHolder.border.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.drawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setScaleType(ImageHolder.ScaleType scaleType) {
        DrawableSizeHolder drawableSizeHolder;
        if (this.hasCache || (drawableSizeHolder = this.sizeHolder) == null) {
            return;
        }
        drawableSizeHolder.scaleType = scaleType;
    }

    public void setSizeHolder(DrawableSizeHolder drawableSizeHolder) {
        if (this.hasCache || drawableSizeHolder == null) {
            return;
        }
        this.sizeHolder.set(drawableSizeHolder);
        setUpBorderHolder(drawableSizeHolder.borderHolder);
    }
}
