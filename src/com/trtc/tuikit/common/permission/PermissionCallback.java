package com.trtc.tuikit.common.permission;

/* loaded from: /tmp/classes2.dex */
public abstract class PermissionCallback {
    public void onDenied() {
    }

    public abstract void onGranted();

    public void onRequesting() {
    }
}
