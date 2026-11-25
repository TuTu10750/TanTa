package com.zyyoona7.picker.ex;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.zyyoona7.wheel.WheelView;
import defpackage.la3;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class DayWheelView extends WheelView<Integer> {
    public static final SparseArray H0 = new SparseArray(1);
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public Calendar G0;
    public int y0;
    public int z0;

    public DayWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DayWheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.A0 = -1;
        this.B0 = -1;
        this.C0 = -1;
        this.D0 = -1;
        this.E0 = -1;
        this.F0 = -1;
        this.G0 = Calendar.getInstance();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, la3.a);
        this.y0 = obtainStyledAttributes.getInt(la3.d, this.G0.get(1));
        this.z0 = obtainStyledAttributes.getInt(la3.b, this.G0.get(2) + 1);
        int i2 = obtainStyledAttributes.getInt(la3.c, this.G0.get(5));
        obtainStyledAttributes.recycle();
        l0();
        setSelectedDay(i2);
    }

    public final void Y(int i) {
        if (e0(i)) {
            setSelectedDay(this.E0);
        } else if (d0(i)) {
            setSelectedDay(this.F0);
        }
    }

    public final boolean Z() {
        int i = this.C0;
        if (i <= 0 || this.z0 != i) {
            return this.z0 < 0 && i < 0 && this.D0 < 0;
        }
        return true;
    }

    public final boolean a0() {
        int i = this.A0;
        if (i <= 0 || this.y0 != i) {
            return this.y0 < 0 && i < 0 && this.B0 < 0;
        }
        return true;
    }

    public final boolean b0() {
        int i = this.z0;
        int i2 = this.D0;
        if (i != i2 || i2 <= 0) {
            return i < 0 && this.C0 < 0 && i2 < 0;
        }
        return true;
    }

    public final boolean c0() {
        int i = this.y0;
        int i2 = this.B0;
        if (i != i2 || i2 <= 0) {
            return i < 0 && this.A0 < 0 && i2 < 0;
        }
        return true;
    }

    public final boolean d0(int i) {
        int i2;
        return c0() && b0() && i < (i2 = this.F0) && i2 > 0;
    }

    public final boolean e0(int i) {
        int i2;
        return a0() && Z() && i > (i2 = this.E0) && i2 > 0;
    }

    @Override // com.zyyoona7.wheel.WheelView
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void D(Integer num, int i) {
        Y(num.intValue());
    }

    public void g0(int i, int i2, int i3) {
        this.A0 = i;
        this.C0 = i2;
        this.E0 = i3;
        Y(getSelectedItemData().intValue());
    }

    public int getMonth() {
        return this.z0;
    }

    public int getSelectedDay() {
        return getSelectedItemData().intValue();
    }

    public int getYear() {
        return this.y0;
    }

    public void h0(int i, int i2, int i3) {
        this.B0 = i;
        this.D0 = i2;
        this.F0 = i3;
        Y(getSelectedItemData().intValue());
    }

    public void i0(int i, boolean z) {
        j0(i, z, 0);
    }

    public void j0(int i, boolean z, int i2) {
        int i3 = this.G0.get(5);
        if (i < 1 || i > i3) {
            return;
        }
        if (e0(i)) {
            i = this.E0;
        } else if (d0(i)) {
            i = this.F0;
        }
        m0(i, z, i2);
    }

    public void k0(int i, int i2) {
        this.y0 = i;
        this.z0 = i2;
        l0();
    }

    public final void l0() {
        this.G0.set(1, this.y0);
        this.G0.set(2, this.z0 - 1);
        this.G0.set(5, 1);
        this.G0.roll(5, -1);
        int i = this.G0.get(5);
        List list = (List) H0.get(i);
        if (list == null) {
            list = new ArrayList(1);
            for (int i2 = 1; i2 <= i; i2++) {
                list.add(Integer.valueOf(i2));
            }
            H0.put(i, list);
        }
        super.setData(list);
        Y(getSelectedItemData().intValue());
    }

    public final void m0(int i, boolean z, int i2) {
        S(i - 1, z, i2);
    }

    @Override // com.zyyoona7.wheel.WheelView
    public void setData(List<Integer> list) {
        throw new UnsupportedOperationException("You can not invoke setData method in " + DayWheelView.class.getSimpleName() + ".");
    }

    public void setMonth(int i) {
        this.z0 = i;
        l0();
    }

    public void setSelectedDay(int i) {
        i0(i, false);
    }

    public void setYear(int i) {
        this.y0 = i;
        l0();
    }
}
