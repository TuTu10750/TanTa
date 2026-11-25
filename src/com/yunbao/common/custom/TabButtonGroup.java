package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;

/* loaded from: /tmp/classes2.dex */
public class TabButtonGroup extends LinearLayout implements View.OnClickListener {
    public TabButton[] a;
    public ViewPager b;
    public int c;
    public a d;
    public b e;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        boolean a(int i);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(int i);
    }

    public TabButtonGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabButtonGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void a(int i) {
        TabButton tabButton;
        TabButton[] tabButtonArr = this.a;
        if (tabButtonArr == null || (tabButton = tabButtonArr[i]) == null) {
            return;
        }
        tabButton.performClick();
    }

    public void b() {
        TabButton[] tabButtonArr = this.a;
        if (tabButtonArr != null) {
            for (TabButton tabButton : tabButtonArr) {
                if (tabButton != null) {
                    tabButton.f();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag != null) {
            setCurPosition(((Integer) tag).intValue());
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        if (childCount > 0) {
            this.a = new TabButton[childCount];
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                childAt.setTag(Integer.valueOf(i));
                childAt.setOnClickListener(this);
                this.a[i] = (TabButton) childAt;
            }
        }
    }

    public void setClickIntercepter(a aVar) {
        this.d = aVar;
    }

    public void setCurPosition(int i) {
        if (i == this.c) {
            b bVar = this.e;
            if (bVar != null) {
                bVar.a(i);
                return;
            }
            return;
        }
        a aVar = this.d;
        if (aVar == null || !aVar.a(i)) {
            this.a[this.c].setChecked(false);
            this.a[i].setChecked(true);
            this.c = i;
            ViewPager viewPager = this.b;
            if (viewPager != null) {
                viewPager.M(i, false);
            }
        }
    }

    public void setOnBtnClickListener(b bVar) {
        this.e = bVar;
    }

    public void setSelectVideo(boolean z) {
        TabButton[] tabButtonArr = this.a;
        if (z) {
            tabButtonArr[0].setTint(-1);
            this.a[2].setTint(-1);
            this.a[3].setTint(-1);
            this.a[4].setTint(-1);
            return;
        }
        tabButtonArr[0].h();
        this.a[1].h();
        this.a[2].h();
        this.a[3].h();
        this.a[4].h();
    }

    public void setViewPager(ViewPager viewPager) {
        this.b = viewPager;
    }
}
