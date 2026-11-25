package com.zyyoona7.picker;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.widget.LinearLayout;
import com.zyyoona7.wheel.WheelView;
import defpackage.it2;
import defpackage.kt2;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class OptionsPickerView<T> extends LinearLayout implements WheelView.a, WheelView.b {
    public WheelView a;
    public WheelView b;
    public WheelView c;
    public List d;
    public List e;
    public List f;
    public boolean g;
    public boolean h;

    @Override // com.zyyoona7.wheel.WheelView.b
    public void a(int i, int i2) {
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void b(int i) {
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void c(int i) {
    }

    @Override // com.zyyoona7.wheel.WheelView.a
    public void d(WheelView wheelView, Object obj, int i) {
        List list;
        if (this.g) {
            if (wheelView.getId() != 1) {
                if (wheelView.getId() != 2 || (list = this.f) == null) {
                    return;
                }
                this.c.setData((List) ((List) list.get(this.a.getSelectedItemPosition())).get(i));
                return;
            }
            this.b.setData((List) this.e.get(i));
            List list2 = this.f;
            if (list2 != null) {
                this.c.setData((List) ((List) list2.get(i)).get(this.b.getSelectedItemPosition()));
            }
        }
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void e(int i) {
    }

    public void f(List list, List list2, List list3) {
        this.g = false;
        g(list, this.a);
        g(list2, this.b);
        g(list3, this.c);
    }

    public final void g(List list, WheelView wheelView) {
        if (list != null) {
            wheelView.setData(list);
        } else {
            wheelView.setVisibility(8);
        }
    }

    public it2 getOnOptionsSelectedListener() {
        return null;
    }

    public T getOpt1SelectedData() {
        return this.g ? (T) this.d.get(this.a.getSelectedItemPosition()) : (T) this.a.getSelectedItemData();
    }

    public int getOpt1SelectedPosition() {
        return this.a.getSelectedItemPosition();
    }

    public T getOpt2SelectedData() {
        return this.g ? (T) ((List) this.e.get(this.a.getSelectedItemPosition())).get(this.b.getSelectedItemPosition()) : (T) this.b.getSelectedItemData();
    }

    public int getOpt2SelectedPosition() {
        return this.b.getSelectedItemPosition();
    }

    public T getOpt3SelectedData() {
        if (!this.g) {
            return (T) this.c.getSelectedItemData();
        }
        List list = this.f;
        if (list == null) {
            return null;
        }
        return (T) ((List) ((List) list.get(this.a.getSelectedItemPosition())).get(this.b.getSelectedItemPosition())).get(this.c.getSelectedItemPosition());
    }

    public int getOpt3SelectedPosition() {
        return this.c.getSelectedItemPosition();
    }

    public WheelView<T> getOptionsWv1() {
        return this.a;
    }

    public WheelView<T> getOptionsWv2() {
        return this.b;
    }

    public WheelView<T> getOptionsWv3() {
        return this.c;
    }

    public void h(float f, boolean z) {
        this.a.O(f, z);
        this.b.O(f, z);
        this.c.O(f, z);
    }

    public void i(float f, boolean z) {
        this.a.P(f, z);
        this.b.P(f, z);
        this.c.P(f, z);
    }

    public void j(float f, boolean z) {
        this.a.Q(f, z);
        this.b.Q(f, z);
        this.c.Q(f, z);
    }

    public void k(int i, boolean z) {
        l(i, z, 0);
    }

    public void l(int i, boolean z, int i2) {
        this.a.S(i, z, i2);
    }

    public void m(int i, boolean z) {
        n(i, z, 0);
    }

    public void n(int i, boolean z, int i2) {
        this.b.S(i, z, i2);
    }

    public void o(int i, boolean z) {
        p(i, z, 0);
    }

    public void p(int i, boolean z, int i2) {
        this.c.S(i, z, i2);
    }

    public void q(float f, boolean z) {
        this.a.T(f, z);
        this.b.T(f, z);
        this.c.T(f, z);
    }

    public void r(float f, boolean z) {
        this.a.U(f, z);
        this.b.U(f, z);
        this.c.U(f, z);
    }

    public void setAutoFitTextSize(boolean z) {
        this.a.setAutoFitTextSize(z);
        this.b.setAutoFitTextSize(z);
        this.c.setAutoFitTextSize(z);
    }

    public void setCurved(boolean z) {
        this.a.setCurved(z);
        this.b.setCurved(z);
        this.c.setCurved(z);
    }

    public void setCurvedArcDirection(int i) {
        this.a.setCurvedArcDirection(i);
        this.b.setCurvedArcDirection(i);
        this.c.setCurvedArcDirection(i);
    }

    public void setCurvedArcDirectionFactor(float f) {
        this.a.setCurvedArcDirectionFactor(f);
        this.b.setCurvedArcDirectionFactor(f);
        this.c.setCurvedArcDirectionFactor(f);
    }

    @Deprecated
    public void setCurvedRefractRatio(float f) {
        setRefractRatio(f);
    }

    public void setCyclic(boolean z) {
        this.a.setCyclic(z);
        this.b.setCyclic(z);
        this.c.setCyclic(z);
    }

    public void setData(List<T> list) {
        f(list, null, null);
    }

    public void setDividerCap(Paint.Cap cap) {
        this.a.setDividerCap(cap);
        this.b.setDividerCap(cap);
        this.c.setDividerCap(cap);
    }

    public void setDividerColor(int i) {
        this.a.setDividerColor(i);
        this.b.setDividerColor(i);
        this.c.setDividerColor(i);
    }

    public void setDividerColorRes(int i) {
        setDividerColor(o60.b(getContext(), i));
    }

    public void setDividerHeight(float f) {
        h(f, false);
    }

    public void setDividerPaddingForWrap(float f) {
        i(f, false);
    }

    public void setDividerType(int i) {
        this.a.setDividerType(i);
        this.b.setDividerType(i);
        this.c.setDividerType(i);
    }

    public void setDrawSelectedRect(boolean z) {
        this.a.setDrawSelectedRect(z);
        this.b.setDrawSelectedRect(z);
        this.c.setDrawSelectedRect(z);
    }

    public void setLineSpacing(float f) {
        j(f, false);
    }

    public void setNormalItemTextColor(int i) {
        this.a.setNormalItemTextColor(i);
        this.b.setNormalItemTextColor(i);
        this.c.setNormalItemTextColor(i);
    }

    public void setNormalItemTextColorRes(int i) {
        setNormalItemTextColor(o60.b(getContext(), i));
    }

    public void setOnOptionsSelectedListener(it2 it2Var) {
    }

    public void setOnPickerScrollStateChangedListener(kt2 kt2Var) {
    }

    public void setOpt1SelectedPosition(int i) {
        k(i, false);
    }

    public void setOpt2SelectedPosition(int i) {
        m(i, false);
    }

    public void setOpt3SelectedPosition(int i) {
        o(i, false);
    }

    public void setPlayVolume(float f) {
        this.a.setPlayVolume(f);
        this.b.setPlayVolume(f);
        this.c.setPlayVolume(f);
    }

    public void setRefractRatio(float f) {
        this.a.setRefractRatio(f);
        this.b.setRefractRatio(f);
        this.c.setRefractRatio(f);
    }

    public void setResetSelectedPosition(boolean z) {
        this.h = z;
        this.a.setResetSelectedPosition(z);
        this.b.setResetSelectedPosition(z);
        this.c.setResetSelectedPosition(z);
    }

    public void setSelectedItemTextColor(int i) {
        this.a.setSelectedItemTextColor(i);
        this.b.setSelectedItemTextColor(i);
        this.c.setSelectedItemTextColor(i);
    }

    public void setSelectedItemTextColorRes(int i) {
        setSelectedItemTextColor(o60.b(getContext(), i));
    }

    public void setSelectedRectColor(int i) {
        this.a.setSelectedRectColor(i);
        this.b.setSelectedRectColor(i);
        this.c.setSelectedRectColor(i);
    }

    public void setSelectedRectColorRes(int i) {
        setSelectedRectColor(o60.b(getContext(), i));
    }

    public void setShowDivider(boolean z) {
        this.a.setShowDivider(z);
        this.b.setShowDivider(z);
        this.c.setShowDivider(z);
    }

    public void setSoundEffect(boolean z) {
        this.a.setSoundEffect(z);
        this.b.setSoundEffect(z);
        this.c.setSoundEffect(z);
    }

    public void setSoundEffectResource(int i) {
        this.a.setSoundEffectResource(i);
        this.b.setSoundEffectResource(i);
        this.c.setSoundEffectResource(i);
    }

    public void setTextAlign(int i) {
        this.a.setTextAlign(i);
        this.b.setTextAlign(i);
        this.c.setTextAlign(i);
    }

    public void setTextBoundaryMargin(float f) {
        q(f, false);
    }

    public void setTextSize(float f) {
        r(f, false);
    }

    public void setTypeface(Typeface typeface) {
        this.a.setTypeface(typeface);
        this.b.setTypeface(typeface);
        this.c.setTypeface(typeface);
    }

    public void setVisibleItems(int i) {
        this.a.setVisibleItems(i);
        this.b.setVisibleItems(i);
        this.c.setVisibleItems(i);
    }
}
