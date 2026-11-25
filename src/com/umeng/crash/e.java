package com.umeng.crash;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: /tmp/classes2.dex */
final class e implements Application.ActivityLifecycleCallbacks {
    private static final e c = new e();
    boolean a;
    String b = "";
    private final LinkedList<Activity> d = new LinkedList<>();
    private int e;
    private boolean f;

    private e() {
    }

    public static e a() {
        return c;
    }

    public final void b() {
        Iterator<Activity> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().finish();
        }
        this.d.clear();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        this.d.addFirst(activity);
        if (this.d.size() > 10) {
            this.d.removeLast();
        }
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        this.d.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        this.b = "";
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        this.b = activity.getComponentName().flattenToShortString();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        int i = this.e + 1;
        this.e = i;
        if (i == 1 && !this.f) {
            this.a = true;
        }
        this.b = activity.getComponentName().flattenToShortString();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        this.f = isChangingConfigurations;
        int i = this.e - 1;
        this.e = i;
        if (i == 0 && !isChangingConfigurations) {
            this.a = false;
        }
        this.b = "";
    }
}
