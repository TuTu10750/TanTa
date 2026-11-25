package com.trtc.tuikit.common.ui;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;

/* loaded from: /tmp/classes2.dex */
public class PopupDialog extends a {
    private View mBaseView;
    private View mBottomSheet;

    /* loaded from: /tmp/classes2.dex */
    public interface DialogActionListener {
        void dismiss();
    }

    public PopupDialog(Context context) {
        super(context);
    }

    public PopupDialog(Context context, int i) {
        super(context, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void changeConfiguration(Window window) {
        Configuration configuration = getContext().getResources().getConfiguration();
        window.setBackgroundDrawableResource(R.color.transparent);
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (configuration.orientation == 2) {
            attributes.gravity = 8388613;
            attributes.width = getContext().getResources().getDisplayMetrics().widthPixels / 2;
        } else {
            attributes.gravity = 80;
            attributes.width = -1;
        }
        attributes.height = getContext().getResources().getDisplayMetrics().heightPixels;
        window.setAttributes(attributes);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mBaseView);
        this.mBottomSheet = findViewById(o63.f);
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.trtc.tuikit.common.ui.PopupDialog.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                PopupDialog.this.mBottomSheet.setBackgroundResource(com.trtc.tuikit.common.R.color.common_design_bottom_sheet_color);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        changeConfiguration(window);
        window.setWindowAnimations(com.trtc.tuikit.common.R.style.TUICommonBottomDialoglAnim);
        BottomSheetBehavior q0 = BottomSheetBehavior.q0(this.mBottomSheet);
        q0.b1(true);
        q0.c1(3);
        q0.O0(false);
    }

    public PopupDialog setView(View view) {
        this.mBaseView = view;
        return this;
    }
}
