package com.yunbao.common.banner.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.h;
import defpackage.fg;
import defpackage.v72;

/* loaded from: /tmp/classes2.dex */
public class BannerLifecycleObserverAdapter implements cz1 {
    public final fg a;
    public final dz1 b;

    @h(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        v72.a("onDestroy");
        this.a.onDestroy(this.b);
    }

    @h(Lifecycle.Event.ON_START)
    public void onStart() {
        v72.a("onStart");
        this.a.onStart(this.b);
    }

    @h(Lifecycle.Event.ON_STOP)
    public void onStop() {
        v72.a("onStop");
        this.a.onStop(this.b);
    }
}
