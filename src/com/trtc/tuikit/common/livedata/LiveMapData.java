package com.trtc.tuikit.common.livedata;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class LiveMapData<K, V> {
    private final Map<K, V> mData;
    private final List<LiveMapObserver<K, V>> mObservers = new CopyOnWriteArrayList();

    public LiveMapData(Map<K, V> map) {
        this.mData = map;
    }

    public void clear() {
        Map<K, V> map = this.mData;
        if (map != null) {
            map.clear();
            Iterator<LiveMapObserver<K, V>> it = this.mObservers.iterator();
            while (it.hasNext()) {
                it.next().onDataChanged(this.mData);
            }
        }
    }

    public Map<K, V> get() {
        return this.mData;
    }

    public void observe(LiveMapObserver<K, V> liveMapObserver) {
        if (liveMapObserver == null || this.mObservers.contains(liveMapObserver)) {
            return;
        }
        this.mObservers.add(liveMapObserver);
        liveMapObserver.onDataChanged(this.mData);
    }

    public void put(K k, V v) {
        Map<K, V> map;
        if (v == null || (map = this.mData) == null) {
            return;
        }
        map.put(k, v);
        Iterator<LiveMapObserver<K, V>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemChanged(k, v);
        }
    }

    public void remove(K k) {
        V remove;
        Map<K, V> map = this.mData;
        if (map == null || (remove = map.remove(k)) == null) {
            return;
        }
        Iterator<LiveMapObserver<K, V>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemRemoved(k, remove);
        }
    }

    public void removeAll() {
        this.mObservers.clear();
    }

    public void removeObserver(LiveMapObserver<K, V> liveMapObserver) {
        this.mObservers.remove(liveMapObserver);
    }
}
