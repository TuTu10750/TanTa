package com.zzhoujay.richtext.drawable;

/* loaded from: /tmp/classes2.dex */
public class DrawableBorderHolder {
    private int borderColor;
    private float borderSize;
    private float radius;
    private boolean showBorder;

    public DrawableBorderHolder() {
        this(false, 5.0f, -16777216, 0.0f);
    }

    public DrawableBorderHolder(DrawableBorderHolder drawableBorderHolder) {
        this(drawableBorderHolder.showBorder, drawableBorderHolder.borderSize, drawableBorderHolder.borderColor, drawableBorderHolder.radius);
    }

    public DrawableBorderHolder(boolean z, float f, int i, float f2) {
        this.showBorder = z;
        this.borderSize = f;
        this.borderColor = i;
        this.radius = f2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawableBorderHolder)) {
            return false;
        }
        DrawableBorderHolder drawableBorderHolder = (DrawableBorderHolder) obj;
        return this.showBorder == drawableBorderHolder.showBorder && Float.compare(drawableBorderHolder.borderSize, this.borderSize) == 0 && this.borderColor == drawableBorderHolder.borderColor && Float.compare(drawableBorderHolder.radius, this.radius) == 0;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public float getBorderSize() {
        return this.borderSize;
    }

    public float getRadius() {
        return this.radius;
    }

    public int hashCode() {
        int i = (this.showBorder ? 1 : 0) * 31;
        float f = this.borderSize;
        int floatToIntBits = (((i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31) + this.borderColor) * 31;
        float f2 = this.radius;
        return floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
    }

    public boolean isShowBorder() {
        return this.showBorder;
    }

    public void set(DrawableBorderHolder drawableBorderHolder) {
        this.showBorder = drawableBorderHolder.showBorder;
        this.borderSize = drawableBorderHolder.borderSize;
        this.borderColor = drawableBorderHolder.borderColor;
        this.radius = drawableBorderHolder.radius;
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
    }

    public void setBorderSize(float f) {
        this.borderSize = f;
    }

    public void setRadius(float f) {
        this.radius = f;
    }

    public void setShowBorder(boolean z) {
        this.showBorder = z;
    }
}
