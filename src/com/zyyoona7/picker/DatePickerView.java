package com.zyyoona7.picker;

import android.graphics.Typeface;
import androidx.appcompat.widget.AppCompatTextView;
import com.zyyoona7.picker.base.BaseDatePickerView;
import defpackage.d83;
import defpackage.i73;

/* loaded from: /tmp/classes2.dex */
public class DatePickerView extends BaseDatePickerView {
    public AppCompatTextView d;
    public AppCompatTextView e;
    public AppCompatTextView f;

    private void setLabelVisibility(int i) {
        this.d.setVisibility(i);
        this.e.setVisibility(i);
        this.f.setVisibility(i);
    }

    @Override // com.zyyoona7.picker.base.BaseDatePickerView
    public int getDatePickerViewLayoutId() {
        return d83.a;
    }

    public AppCompatTextView getDayTv() {
        return this.f;
    }

    @Override // com.zyyoona7.picker.base.BaseDatePickerView
    public int getDayWheelViewId() {
        return i73.d;
    }

    public AppCompatTextView getMonthTv() {
        return this.e;
    }

    @Override // com.zyyoona7.picker.base.BaseDatePickerView
    public int getMonthWheelViewId() {
        return i73.e;
    }

    public String getSelectedDate() {
        return getSelectedYear() + "-" + getSelectedMonth() + "-" + getSelectedDay();
    }

    public int getSelectedDay() {
        return this.c.getSelectedDay();
    }

    public int getSelectedMonth() {
        return this.b.getSelectedMonth();
    }

    public int getSelectedYear() {
        return this.a.getSelectedYear();
    }

    public AppCompatTextView getYearTv() {
        return this.d;
    }

    @Override // com.zyyoona7.picker.base.BaseDatePickerView
    public int getYearWheelViewId() {
        return i73.f;
    }

    public void h(float f, boolean z) {
        this.a.O(f, z);
        this.b.O(f, z);
        this.c.O(f, z);
    }

    public void i(float f, boolean z) {
        this.a.Q(f, z);
        this.b.Q(f, z);
        this.c.Q(f, z);
    }

    public void j(int i, boolean z) {
        k(i, z, 0);
    }

    public void k(int i, boolean z, int i2) {
        this.a.d0(i, z, i2);
    }

    public void l(float f, boolean z) {
        this.a.U(f, z);
        this.b.U(f, z);
        this.c.U(f, z);
    }

    @Override // com.zyyoona7.picker.base.BaseDatePickerView, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.d = findViewById(i73.c);
        this.e = findViewById(i73.b);
        this.f = findViewById(i73.a);
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

    public void setLabelTextColor(int i) {
        this.d.setTextColor(i);
        this.e.setTextColor(i);
        this.f.setTextColor(i);
    }

    public void setLabelTextColorRes(int i) {
        setLabelTextColor(o60.b(getContext(), i));
    }

    public void setLabelTextSize(float f) {
        this.d.setTextSize(f);
        this.e.setTextSize(f);
        this.f.setTextSize(f);
    }

    public void setLineSpacing(float f) {
        i(f, false);
    }

    public void setNormalItemTextColor(int i) {
        this.a.setNormalItemTextColor(i);
        this.b.setNormalItemTextColor(i);
        this.c.setNormalItemTextColor(i);
    }

    public void setNormalItemTextColorRes(int i) {
        setNormalItemTextColor(o60.b(getContext(), i));
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
        this.a.setResetSelectedPosition(z);
        this.b.setResetSelectedPosition(z);
        this.c.setResetSelectedPosition(z);
    }

    public void setSelectedDay(int i) {
        this.c.i0(i, false);
    }

    public void setSelectedItemTextColor(int i) {
        this.a.setSelectedItemTextColor(i);
        this.b.setSelectedItemTextColor(i);
        this.c.setSelectedItemTextColor(i);
    }

    public void setSelectedItemTextColorRes(int i) {
        setSelectedItemTextColor(o60.b(getContext(), i));
    }

    public void setSelectedMonth(int i) {
        this.b.h0(i, false);
    }

    public void setSelectedRectColor(int i) {
        this.a.setSelectedRectColor(i);
        this.b.setSelectedRectColor(i);
        this.c.setSelectedRectColor(i);
    }

    public void setSelectedRectColorRes(int i) {
        setSelectedRectColor(o60.b(getContext(), i));
    }

    public void setSelectedYear(int i) {
        j(i, false);
    }

    public void setShowDivider(boolean z) {
        this.a.setShowDivider(z);
        this.b.setShowDivider(z);
        this.c.setShowDivider(z);
    }

    public void setShowLabel(boolean z) {
        if (z) {
            setLabelVisibility(0);
        } else {
            setLabelVisibility(8);
        }
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

    public void setTextSize(float f) {
        l(f, false);
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
