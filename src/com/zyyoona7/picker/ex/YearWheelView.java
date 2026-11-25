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
public class YearWheelView extends WheelView<Integer> {
    public int A0;
    public int B0;
    public int y0;
    public int z0;

    public YearWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YearWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A0 = -1;
        this.B0 = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, la3.h);
        this.y0 = obtainStyledAttributes.getInt(la3.k, 1900);
        this.z0 = obtainStyledAttributes.getInt(la3.i, 2100);
        int i2 = obtainStyledAttributes.getInt(la3.j, Calendar.getInstance().get(1));
        obtainStyledAttributes.recycle();
        f0();
        setSelectedYear(i2);
    }

    private void Y(int i) {
        if (a0(i)) {
            setSelectedYear(this.A0);
        } else if (Z(i)) {
            setSelectedYear(this.B0);
        }
    }

    public final boolean Z(int i) {
        int i2 = this.B0;
        return i < i2 && i2 > 0;
    }

    public final boolean a0(int i) {
        int i2 = this.A0;
        return i > i2 && i2 > 0;
    }

    @Override // com.zyyoona7.wheel.WheelView
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void D(Integer num, int i) {
        Y(num.intValue());
    }

    public void c0(int i, boolean z) {
        d0(i, z, 0);
    }

    public void d0(int i, boolean z, int i2) {
        if (i < this.y0 || i > this.z0) {
            return;
        }
        if (a0(i)) {
            i = this.A0;
        } else if (Z(i)) {
            i = this.B0;
        }
        e0(i, z, i2);
    }

    public final void e0(int i, boolean z, int i2) {
        S(i - this.y0, z, i2);
    }

    public final void f0() {
        ArrayList arrayList = new ArrayList(1);
        for (int i = this.y0; i <= this.z0; i++) {
            arrayList.add(Integer.valueOf(i));
        }
        super.setData(arrayList);
    }

    public int getSelectedYear() {
        return getSelectedItemData().intValue();
    }

    @Override // com.zyyoona7.wheel.WheelView
    public void setData(List<Integer> list) {
        throw new UnsupportedOperationException("You can not invoke setData method in " + YearWheelView.class.getSimpleName() + ".");
    }

    public void setMaxYear(int i) {
        int i2 = this.z0;
        if (i > i2) {
            this.A0 = i2;
        } else {
            this.A0 = i;
            Y(getSelectedItemData().intValue());
        }
    }

    public void setMinYear(int i) {
        int i2 = this.y0;
        if (i < i2) {
            this.B0 = i2;
        } else {
            this.B0 = i;
            Y(getSelectedItemData().intValue());
        }
    }

    public void setSelectedYear(int i) {
        c0(i, false);
    }
}
