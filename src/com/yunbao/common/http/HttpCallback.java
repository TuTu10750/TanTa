package com.yunbao.common.http;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import defpackage.lx1;

/* loaded from: /tmp/classes2.dex */
public abstract class HttpCallback {
    private Dialog mLoadingDialog;

    private void dismissLoadingDialogSafely(Dialog dialog) {
        try {
            if (dialog.isShowing() && isDialogContextAlive(dialog) && isDialogWindowAttached(dialog)) {
                dialog.dismiss();
            }
        } catch (IllegalArgumentException e) {
            lx1.c("HttpCallback", "dismiss loading dialog detached--->" + e.getMessage());
        } catch (RuntimeException e2) {
            lx1.c("HttpCallback", "dismiss loading dialog error--->" + e2.getMessage());
        } catch (Throwable th) {
            lx1.c("HttpCallback", "dismiss loading dialog throwable--->" + th.getMessage());
        }
    }

    private Activity findActivity(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    private boolean isDialogContextAlive(Dialog dialog) {
        Activity findActivity = findActivity(dialog == null ? null : dialog.getContext());
        if (findActivity != null) {
            return (findActivity.isFinishing() || findActivity.isDestroyed()) ? false : true;
        }
        return true;
    }

    private boolean isDialogWindowAttached(Dialog dialog) {
        Window window = dialog.getWindow();
        if (window == null) {
            return false;
        }
        View decorView = window.getDecorView();
        return decorView == null || decorView.isAttachedToWindow();
    }

    private void showLoadingDialogSafely(Dialog dialog) {
        if (dialog == null || !isDialogContextAlive(dialog)) {
            return;
        }
        try {
            if (dialog.isShowing()) {
                return;
            }
            dialog.show();
        } catch (WindowManager.BadTokenException e) {
            lx1.c("HttpCallback", "show loading dialog bad token--->" + e.getMessage());
        } catch (RuntimeException e2) {
            lx1.c("HttpCallback", "show loading dialog error--->" + e2.getMessage());
        } catch (Throwable th) {
            lx1.c("HttpCallback", "show loading dialog throwable--->" + th.getMessage());
        }
    }

    public Dialog createLoadingDialog() {
        return null;
    }

    public boolean isUseLoginInvalid() {
        return false;
    }

    public void onError() {
    }

    public void onFinish() {
        Dialog dialog = this.mLoadingDialog;
        this.mLoadingDialog = null;
        if (dialog != null) {
            dismissLoadingDialogSafely(dialog);
        }
    }

    public void onLoginInvalid() {
    }

    public void onStart() {
        try {
            if (showLoadingDialog()) {
                if (this.mLoadingDialog == null) {
                    this.mLoadingDialog = createLoadingDialog();
                }
                showLoadingDialogSafely(this.mLoadingDialog);
            }
        } catch (Throwable th) {
            lx1.c("HttpCallback", "show loading dialog failed--->" + th.getMessage());
            this.mLoadingDialog = null;
        }
    }

    public abstract void onSuccess(int i, String str, String[] strArr);

    public boolean showLoadingDialog() {
        return false;
    }
}
