package com.yunbao.common.banner.indicator;

import android.view.View;
import defpackage.go1;
import defpackage.ho1;

/* loaded from: /tmp/classes2.dex */
public class BaseIndicator extends View implements go1 {
    public float a;

    @Override // defpackage.jt2
    public void a(int i, float f, int i2) {
        this.a = f;
        invalidate();
    }

    @Override // defpackage.jt2
    public void b(int i) {
    }

    @Override // defpackage.jt2
    public void c(int i) {
        throw null;
    }

    @Override // defpackage.go1
    public void d(int i, int i2) {
        throw null;
    }

    @Override // defpackage.go1
    public ho1 getIndicatorConfig() {
        return null;
    }

    public View getIndicatorView() {
        throw null;
    }
}
