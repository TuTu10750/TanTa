package com.yunbao.main.custom;

import android.content.Context;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class MainHomePageTitleView extends ColorTransitionPagerTitleView {
    public int c;
    public int d;
    public int e;

    public MainHomePageTitleView(Context context) {
        super(context);
    }

    public void b(boolean z) {
        int i = z ? this.a : this.b;
        if (this.c != i) {
            setTextColor(i);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, defpackage.bi1
    public void d(int i, int i2) {
        super.d(i, i2);
        int i3 = this.d;
        if (i3 != 0) {
            setTextSize(2, i3);
            getPaint().setFakeBoldText(false);
        }
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, defpackage.bi1
    public void f(int i, int i2) {
        super.f(i, i2);
        int i3 = this.e;
        if (i3 != 0) {
            setTextSize(2, i3);
            getPaint().setFakeBoldText(true);
        }
    }

    public void setNormalTextSize(int i) {
        this.d = i;
    }

    public void setSelectedTextSize(int i) {
        this.e = i;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        this.c = i;
        super.setTextColor(i);
    }
}
