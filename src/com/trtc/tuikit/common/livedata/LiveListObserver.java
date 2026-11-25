package com.trtc.tuikit.common.livedata;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class LiveListObserver<T> {
    public void onDataChanged(List<T> list) {
    }

    public void onItemChanged(int i, T t) {
    }

    public void onItemInserted(int i, T t) {
    }

    public void onItemMoved(int i, int i2, T t) {
    }

    public void onItemRemoved(int i, T t) {
    }
}
