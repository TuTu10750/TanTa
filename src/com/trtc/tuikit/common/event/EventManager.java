package com.trtc.tuikit.common.event;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class EventManager {
    private static final String TAG = "EventManager";
    private final Map<Pair<String, String>, List<INotification>> eventMap;

    /* loaded from: /tmp/classes2.dex */
    public static class EventManagerHolder {
        private static final EventManager eventManager = new EventManager();

        private EventManagerHolder() {
        }
    }

    private EventManager() {
        this.eventMap = new ConcurrentHashMap();
    }

    public static EventManager getInstance() {
        return EventManagerHolder.eventManager;
    }

    public void notifyEvent(String str, String str2, Map<String, Object> map) {
        Log.d(TAG, "notifyEvent : key : " + str + ", subKey : " + str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        List<INotification> list = this.eventMap.get(new Pair(str, str2));
        if (list != null) {
            Iterator<INotification> it = list.iterator();
            while (it.hasNext()) {
                it.next().onNotifyEvent(str, str2, map);
            }
        }
    }

    public void registerEvent(String str, String str2, INotification iNotification) {
        Log.i(TAG, "registerEvent : key : " + str + ", subKey : " + str2 + ", notification : " + iNotification);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || iNotification == null) {
            return;
        }
        Pair<String, String> pair = new Pair<>(str, str2);
        List<INotification> list = this.eventMap.get(pair);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.eventMap.put(pair, list);
        }
        if (list.contains(iNotification)) {
            return;
        }
        list.add(iNotification);
    }

    public void unRegisterEvent(INotification iNotification) {
        Log.i(TAG, "removeEvent : notification : " + iNotification);
        if (iNotification == null) {
            return;
        }
        Iterator<Pair<String, String>> it = this.eventMap.keySet().iterator();
        while (it.hasNext()) {
            List<INotification> list = this.eventMap.get(it.next());
            if (list != null) {
                Iterator<INotification> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    INotification next = it2.next();
                    if (next == iNotification) {
                        list.remove(next);
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterEvent(String str, String str2, INotification iNotification) {
        Log.i(TAG, "removeEvent : key : " + str + ", subKey : " + str2 + " notification : " + iNotification);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || iNotification == null) {
            return;
        }
        List<INotification> list = this.eventMap.get(new Pair(str, str2));
        if (list == null) {
            return;
        }
        list.remove(iNotification);
    }
}
