package com.zyyoona7.picker.base;

import android.widget.FrameLayout;
import com.zyyoona7.picker.ex.DayWheelView;
import com.zyyoona7.picker.ex.MonthWheelView;
import com.zyyoona7.picker.ex.YearWheelView;
import com.zyyoona7.wheel.WheelView;
import defpackage.ct2;
import defpackage.kt2;
import java.util.Calendar;
import java.util.Date;

/* loaded from: /tmp/classes2.dex */
public abstract class BaseDatePickerView extends FrameLayout implements WheelView.a, WheelView.b {
    public YearWheelView a;
    public MonthWheelView b;
    public DayWheelView c;

    @Override // com.zyyoona7.wheel.WheelView.b
    public void a(int i, int i2) {
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void b(int i) {
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void c(int i) {
    }

    @Override // com.zyyoona7.wheel.WheelView.b
    public void e(int i) {
    }

    public final boolean f(int i) {
        return (i == 0 || i == -1) ? false : true;
    }

    @Override // com.zyyoona7.wheel.WheelView.a
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(WheelView wheelView, Integer num, int i) {
        DayWheelView dayWheelView;
        if (wheelView.getId() == getYearWheelViewId()) {
            DayWheelView dayWheelView2 = this.c;
            if (dayWheelView2 != null) {
                dayWheelView2.setYear(num.intValue());
            }
            MonthWheelView monthWheelView = this.b;
            if (monthWheelView != null) {
                monthWheelView.setCurrentSelectedYear(num.intValue());
            }
        } else if (wheelView.getId() == getMonthWheelViewId() && (dayWheelView = this.c) != null) {
            dayWheelView.setMonth(num.intValue());
        }
        YearWheelView yearWheelView = this.a;
        int selectedYear = yearWheelView == null ? 1970 : yearWheelView.getSelectedYear();
        MonthWheelView monthWheelView2 = this.b;
        int selectedMonth = monthWheelView2 == null ? 1 : monthWheelView2.getSelectedMonth();
        DayWheelView dayWheelView3 = this.c;
        int selectedDay = dayWheelView3 != null ? dayWheelView3.getSelectedDay() : 1;
        StringBuilder sb = new StringBuilder();
        sb.append(selectedYear);
        sb.append("-");
        sb.append(selectedMonth);
        sb.append("-");
        sb.append(selectedDay);
    }

    public abstract int getDatePickerViewLayoutId();

    public abstract int getDayWheelViewId();

    public DayWheelView getDayWv() {
        return this.c;
    }

    public abstract int getMonthWheelViewId();

    public MonthWheelView getMonthWv() {
        return this.b;
    }

    public abstract int getYearWheelViewId();

    public YearWheelView getYearWv() {
        return this.a;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int yearWheelViewId = getYearWheelViewId();
        if (f(yearWheelViewId)) {
            this.a = (YearWheelView) findViewById(yearWheelViewId);
        }
        int monthWheelViewId = getMonthWheelViewId();
        if (f(monthWheelViewId)) {
            this.b = (MonthWheelView) findViewById(monthWheelViewId);
        }
        int dayWheelViewId = getDayWheelViewId();
        if (f(dayWheelViewId)) {
            this.c = (DayWheelView) findViewById(dayWheelViewId);
        }
        YearWheelView yearWheelView = this.a;
        if (yearWheelView != null) {
            yearWheelView.setOnItemSelectedListener(this);
            this.a.setOnWheelChangedListener(this);
        }
        MonthWheelView monthWheelView = this.b;
        if (monthWheelView != null) {
            monthWheelView.setOnItemSelectedListener(this);
            this.b.setOnWheelChangedListener(this);
            YearWheelView yearWheelView2 = this.a;
            if (yearWheelView2 != null) {
                this.b.setCurrentSelectedYear(yearWheelView2.getSelectedYear());
            }
        }
        DayWheelView dayWheelView = this.c;
        if (dayWheelView != null) {
            dayWheelView.setOnItemSelectedListener(this);
            this.c.setOnWheelChangedListener(this);
            YearWheelView yearWheelView3 = this.a;
            if (yearWheelView3 == null || this.b == null) {
                return;
            }
            this.c.k0(yearWheelView3.getSelectedYear(), this.b.getSelectedMonth());
        }
    }

    public void setMaxDate(Calendar calendar) {
        setMaxDate(calendar.getTime());
    }

    public void setMaxDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        YearWheelView yearWheelView = this.a;
        if (yearWheelView != null) {
            yearWheelView.setMaxYear(i);
        }
        MonthWheelView monthWheelView = this.b;
        if (monthWheelView != null) {
            monthWheelView.f0(i, i2);
        }
        DayWheelView dayWheelView = this.c;
        if (dayWheelView != null) {
            dayWheelView.g0(i, i2, i3);
        }
    }

    public void setMinDate(Calendar calendar) {
        setMinDate(calendar.getTime());
    }

    public void setMinDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(1);
        int i2 = calendar.get(2) + 1;
        int i3 = calendar.get(5);
        YearWheelView yearWheelView = this.a;
        if (yearWheelView != null) {
            yearWheelView.setMinYear(i);
        }
        MonthWheelView monthWheelView = this.b;
        if (monthWheelView != null) {
            monthWheelView.g0(i, i2);
        }
        DayWheelView dayWheelView = this.c;
        if (dayWheelView != null) {
            dayWheelView.h0(i, i2, i3);
        }
    }

    public void setOnDateSelectedListener(ct2 ct2Var) {
    }

    public void setOnPickerScrollStateChangedListener(kt2 kt2Var) {
    }
}
