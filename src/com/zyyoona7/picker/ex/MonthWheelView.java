package com.zyyoona7.picker.ex;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.zyyoona7.wheel.WheelView;
import defpackage.la3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class MonthWheelView extends WheelView<Integer> {
    public int A0;
    public int B0;
    public int C0;
    public int y0;
    public int z0;

    public MonthWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MonthWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y0 = -1;
        this.z0 = -1;
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, la3.e);
        int i2 = obtainStyledAttributes.getInt(la3.f, Calendar.getInstance().get(2) + 1);
        obtainStyledAttributes.recycle();
        Z();
        setSelectedMonth(i2);
    }

    private void Y(int i) {
        if (d0(i)) {
            setSelectedMonth(this.B0);
        } else if (c0(i)) {
            setSelectedMonth(this.C0);
        }
    }

    private boolean a0() {
        int i = this.z0;
        if (i <= 0 || this.y0 != i) {
            return this.y0 < 0 && i < 0 && this.A0 < 0;
        }
        return true;
    }

    private boolean b0() {
        int i = this.y0;
        int i2 = this.A0;
        if (i != i2 || i2 <= 0) {
            return i < 0 && this.z0 < 0 && i2 < 0;
        }
        return true;
    }

    public final void Z() {
        ArrayList arrayList = new ArrayList(1);
        for (int i = 1; i <= 12; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        super.setData(arrayList);
    }

    public final boolean c0(int i) {
        int i2;
        return b0() && i < (i2 = this.C0) && i2 > 0;
    }

    public final boolean d0(int i) {
        int i2;
        return a0() && i > (i2 = this.B0) && i2 > 0;
    }

    @Override // com.zyyoona7.wheel.WheelView
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void D(Integer num, int i) {
        Y(num.intValue());
    }

    public void f0(int i, int i2) {
        this.z0 = i;
        this.B0 = i2;
        Y(getSelectedItemData().intValue());
    }

    public void g0(int i, int i2) {
        this.A0 = i;
        this.C0 = i2;
        Y(getSelectedItemData().intValue());
    }

    public int getCurrentSelectedYear() {
        return this.y0;
    }

    public int getSelectedMonth() {
        return getSelectedItemData().intValue();
    }

    public void h0(int i, boolean z) {
        i0(i, z, 0);
    }

    public void i0(int i, boolean z, int i2) {
        if (i < 1 || i > 12) {
            return;
        }
        if (d0(i)) {
            i = this.B0;
        } else if (c0(i)) {
            i = this.C0;
        }
        j0(i, z, i2);
    }

    public final void j0(int i, boolean z, int i2) {
        S(i - 1, z, i2);
    }

    public void setCurrentSelectedYear(int i) {
        this.y0 = i;
        Y(getSelectedItemData().intValue());
    }

    @Override // com.zyyoona7.wheel.WheelView
    public void setData(List<Integer> list) {
        throw new UnsupportedOperationException("You can not invoke setData method in " + MonthWheelView.class.getSimpleName() + ".");
    }

    public void setMaxMonth(int i) {
        this.B0 = i;
        Y(getSelectedItemData().intValue());
    }

    public void setMinMonth(int i) {
        this.C0 = i;
        Y(getSelectedItemData().intValue());
    }

    public void setSelectedMonth(int i) {
        h0(i, false);
    }
}
