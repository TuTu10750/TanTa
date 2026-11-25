package com.trtc.tuikit.common.livedata;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class LiveData<T> {
    private volatile Object mData;
    private List<Observer<? super T>> mObservers = new CopyOnWriteArrayList();

    public LiveData() {
    }

    public LiveData(T t) {
        this.mData = t;
    }

    private void dispatchingValue() {
        if (this.mData == null) {
            return;
        }
        Iterator<Observer<? super T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onChanged((Object) this.mData);
        }
    }

    public void add(Object obj) {
        if (this.mData == null) {
            return;
        }
        boolean z = this.mData instanceof HashSet;
        Object obj2 = this.mData;
        if (z) {
            HashSet hashSet = (HashSet) obj2;
            int size = hashSet.size();
            hashSet.add(obj);
            if (size != hashSet.size()) {
                dispatchingValue();
                return;
            }
            return;
        }
        boolean z2 = obj2 instanceof List;
        Object obj3 = this.mData;
        if (z2) {
            ((List) obj3).add(obj);
            dispatchingValue();
        } else if (obj3 instanceof Set) {
            ((Set) this.mData).add(obj);
            dispatchingValue();
        }
    }

    public void addAll(Collection collection) {
        if (this.mData == null) {
            return;
        }
        boolean z = this.mData instanceof List;
        Object obj = this.mData;
        if (z) {
            ((List) obj).addAll(collection);
            dispatchingValue();
        } else if (obj instanceof Set) {
            ((Set) this.mData).addAll(collection);
            dispatchingValue();
        }
    }

    public void clear() {
        if (this.mData == null) {
            return;
        }
        boolean z = this.mData instanceof List;
        Object obj = this.mData;
        if (z) {
            ((List) obj).clear();
            dispatchingValue();
        } else if (obj instanceof Set) {
            ((Set) this.mData).clear();
            dispatchingValue();
        }
    }

    public T get() {
        return (T) this.mData;
    }

    public void notifyDataChanged() {
        dispatchingValue();
    }

    public void observe(Observer<? super T> observer) {
        if (observer == null || this.mObservers.contains(observer)) {
            return;
        }
        this.mObservers.add(observer);
        if (this.mData == null) {
            return;
        }
        observer.onChanged((Object) this.mData);
    }

    public void remove(Object obj) {
        if (this.mData == null) {
            return;
        }
        boolean z = this.mData instanceof HashSet;
        Object obj2 = this.mData;
        if (z) {
            HashSet hashSet = (HashSet) obj2;
            int size = hashSet.size();
            hashSet.remove(obj);
            if (size != hashSet.size()) {
                dispatchingValue();
                return;
            }
            return;
        }
        boolean z2 = obj2 instanceof List;
        Object obj3 = this.mData;
        if (z2) {
            ((List) obj3).remove(obj);
            dispatchingValue();
        } else if (obj3 instanceof Set) {
            ((Set) this.mData).remove(obj);
            dispatchingValue();
        }
    }

    public void removeAll() {
        this.mObservers.clear();
    }

    public void removeObserver(Observer<? super T> observer) {
        this.mObservers.remove(observer);
    }

    public void set(T t) {
        set(t, true);
    }

    public void set(T t, boolean z) {
        if (t == null) {
            return;
        }
        if (z || !t.equals(this.mData)) {
            this.mData = t;
            dispatchingValue();
        }
    }
}
