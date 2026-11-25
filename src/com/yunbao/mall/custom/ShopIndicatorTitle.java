package com.yunbao.mall.custom;

import android.content.Context;
import android.widget.LinearLayout;
import defpackage.vh1;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

/* loaded from: /tmp/classes2.dex */
public class ShopIndicatorTitle extends LinearLayout implements vh1 {
    public SimplePagerTitleView a;

    public ShopIndicatorTitle(Context context) {
        super(context);
        setOrientation(0);
        setGravity(16);
    }

    @Override // defpackage.bi1
    public void d(int i, int i2) {
        this.a.d(i, i2);
    }

    @Override // defpackage.bi1
    public void e(int i, int i2, float f, boolean z) {
        this.a.e(i, i2, f, z);
    }

    @Override // defpackage.bi1
    public void f(int i, int i2) {
        this.a.f(i, i2);
    }

    @Override // defpackage.bi1
    public void g(int i, int i2, float f, boolean z) {
        this.a.g(i, i2, f, z);
    }

    @Override // defpackage.vh1
    public int getContentBottom() {
        return this.a.getContentBottom();
    }

    @Override // defpackage.vh1
    public int getContentLeft() {
        return this.a.getContentLeft() + getLeft();
    }

    @Override // defpackage.vh1
    public int getContentRight() {
        return this.a.getContentRight() + getLeft();
    }

    @Override // defpackage.vh1
    public int getContentTop() {
        return this.a.getContentTop();
    }

    public SimplePagerTitleView getTitleView() {
        return this.a;
    }

    public void setTitleView(SimplePagerTitleView simplePagerTitleView) {
        this.a = simplePagerTitleView;
    }
}
