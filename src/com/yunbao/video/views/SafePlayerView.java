package com.yunbao.video.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.media3.ui.PlayerView;
import com.yunbao.common.utils.MemoryPressureUtil;
import defpackage.lx1;

/* loaded from: /tmp/classes2.dex */
public class SafePlayerView extends PlayerView {
    public SafePlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void Q() {
        if (MemoryPressureUtil.i()) {
            lx1.c("SafePlayerView", "clear memory before surface layout, available=" + MemoryPressureUtil.g());
            MemoryPressureUtil.e();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Q();
        try {
            super/*android.view.View*/.onLayout(z, i, i2, i3, i4);
        } catch (OutOfMemoryError e) {
            lx1.c("SafePlayerView", "surface layout oom, retry after clear memory: " + e.getMessage());
            MemoryPressureUtil.e();
            super/*android.view.View*/.onLayout(z, i, i2, i3, i4);
        }
    }
}
