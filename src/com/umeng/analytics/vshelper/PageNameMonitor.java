package com.umeng.analytics.vshelper;

/* loaded from: /tmp/classes2.dex */
public class PageNameMonitor implements com.umeng.analytics.vshelper.a {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        private static final PageNameMonitor a = new PageNameMonitor();

        private a() {
        }
    }

    private PageNameMonitor() {
    }

    public static PageNameMonitor getInstance() {
        return a.a;
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.a
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            try {
                String str = currentCustomPage;
                if (str != null) {
                    return str;
                }
                String str2 = currentActivity;
                if (str2 != null) {
                    return str2;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }
}
