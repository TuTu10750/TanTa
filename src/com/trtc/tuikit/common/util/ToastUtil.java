package com.trtc.tuikit.common.util;

import android.R;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast$Callback;
import com.trtc.tuikit.common.system.ContextProvider;

/* loaded from: /tmp/classes2.dex */
public class ToastUtil {
    private static Toast toast;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static boolean enableToast = true;

    public static void setEnableToast(boolean z) {
        enableToast = z;
    }

    public static void show(String str, boolean z, int i) {
        toastMessage(str, z, i);
    }

    public static void toastLongMessage(String str) {
        toastMessage(str, true, 80);
    }

    public static void toastLongMessageCenter(String str) {
        toastMessage(str, true, 17);
    }

    private static void toastMessage(final String str, final boolean z, final int i) {
        if (enableToast) {
            handler.post(new Runnable() { // from class: com.trtc.tuikit.common.util.ToastUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    TextView textView;
                    if (ToastUtil.toast != null) {
                        ToastUtil.toast.cancel();
                        Toast unused = ToastUtil.toast = null;
                    }
                    Toast unused2 = ToastUtil.toast = Toast.makeText(ContextProvider.getApplicationContext(), str, z ? 1 : 0);
                    ToastUtil.toast.setGravity(i, 0, 0);
                    View view = ToastUtil.toast.getView();
                    if (view != null && (textView = (TextView) view.findViewById(R.id.message)) != null) {
                        textView.setGravity(17);
                    }
                    if (TUIBuild.getVersionInt() >= 30) {
                        ToastUtil.toast.addCallback(new Toast$Callback() { // from class: com.trtc.tuikit.common.util.ToastUtil.1.1
                            public void onToastHidden() {
                                super.onToastHidden();
                                Toast unused3 = ToastUtil.toast = null;
                            }
                        });
                    }
                    ToastUtil.toast.show();
                }
            });
        }
    }

    public static void toastShortMessage(String str) {
        toastMessage(str, false, 80);
    }

    public static void toastShortMessageCenter(String str) {
        toastMessage(str, false, 17);
    }
}
