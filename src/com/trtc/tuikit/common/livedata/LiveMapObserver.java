package com.trtc.tuikit.common.livedata;

import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public abstract class LiveMapObserver<K, V> {
    public void onDataChanged(Map<K, V> map) {
    }

    public void onItemChanged(K k, V v) {
    }

    public void onItemRemoved(K k, V v) {
    }
}
