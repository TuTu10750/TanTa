package com.trtc.tuikit.common.livedata;

import android.util.Log;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class LiveListData<T> {
    private static final String TAG = "LiveListData";
    private List<T> mList;
    private final List<LiveListObserver<T>> mObservers;

    public LiveListData() {
        this.mObservers = new CopyOnWriteArrayList();
        this.mList = new LinkedList();
    }

    public LiveListData(List<T> list) {
        this.mObservers = new CopyOnWriteArrayList();
        this.mList = list;
    }

    public void add(T t) {
        insert(this.mList.size(), (int) t);
    }

    public void change(T t) {
        int indexOf = this.mList.indexOf(t);
        if (indexOf == -1) {
            return;
        }
        this.mList.set(indexOf, t);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemChanged(indexOf, t);
        }
    }

    public void clear() {
        this.mList.clear();
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged(this.mList);
        }
    }

    public boolean contains(T t) {
        return this.mList.contains(t);
    }

    public T find(T t) {
        int indexOf = this.mList.indexOf(t);
        if (indexOf == -1) {
            return null;
        }
        return this.mList.get(indexOf);
    }

    public T get(int i) {
        return this.mList.get(i);
    }

    public List<T> getList() {
        return this.mList;
    }

    public int indexOf(T t) {
        return this.mList.indexOf(t);
    }

    public void insert(int i, T t) {
        if (this.mList.contains(t)) {
            return;
        }
        this.mList.add(i, t);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemInserted(i, t);
        }
    }

    public void insert(T t, Comparator<T> comparator) {
        int size = this.mList.size();
        int i = 0;
        while (i < size && comparator.compare(t, this.mList.get(i)) >= 0) {
            i++;
        }
        insert(i, (int) t);
    }

    public boolean isEmpty() {
        return this.mList.isEmpty();
    }

    public void move(int i, int i2) {
        T remove = this.mList.remove(i);
        this.mList.add(i2, remove);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemMoved(i, i2, remove);
        }
    }

    public void move(T t, Comparator<T> comparator) {
        int indexOf = this.mList.indexOf(t);
        if (indexOf == -1) {
            return;
        }
        this.mList.remove(t);
        int size = this.mList.size();
        int i = 0;
        while (i < size && comparator.compare(t, this.mList.get(i)) >= 0) {
            i++;
        }
        this.mList.add(i, t);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemMoved(indexOf, i, t);
        }
    }

    public void observe(LiveListObserver<T> liveListObserver) {
        if (liveListObserver == null || this.mObservers.contains(liveListObserver)) {
            return;
        }
        this.mObservers.add(liveListObserver);
        liveListObserver.onDataChanged(this.mList);
    }

    public void redirect(List<T> list) {
        this.mList = list;
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged(this.mList);
        }
    }

    public T remove(int i) {
        T remove = this.mList.remove(i);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onItemRemoved(i, remove);
        }
        return remove;
    }

    public T remove(T t) {
        int indexOf = this.mList.indexOf(t);
        if (indexOf == -1) {
            return null;
        }
        return remove(indexOf);
    }

    public void removeObserver(LiveListObserver<T> liveListObserver) {
        this.mObservers.remove(liveListObserver);
    }

    public void replaceAll(List<T> list) {
        List<T> list2 = this.mList;
        if (list2 == list) {
            Log.e(TAG, "Replace the same object, you can use redirect instead.");
            return;
        }
        list2.clear();
        this.mList.addAll(list);
        Iterator<LiveListObserver<T>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged(this.mList);
        }
    }

    public int size() {
        return this.mList.size();
    }
}
