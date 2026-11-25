package com.yunbao.common.utils;

import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;

/* loaded from: /tmp/classes2.dex */
public class EmojiLayout extends FrameLayout {
    public final CardView a;
    public a b;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
    }

    public void setDeleteViewEnable(boolean z) {
        this.a.getChildAt(0).setEnabled(z);
    }

    public void setEmojiListener(a aVar) {
        this.b = aVar;
    }
}
