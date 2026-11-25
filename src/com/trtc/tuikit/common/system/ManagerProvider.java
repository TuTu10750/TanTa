package com.trtc.tuikit.common.system;

import android.view.inputmethod.InputMethodManager;

/* loaded from: /tmp/classes2.dex */
public class ManagerProvider {
    public static InputMethodManager getInputMethodManager() {
        return (InputMethodManager) ContextProvider.getApplicationContext().getSystemService("input_method");
    }
}
