package com.trtc.tuikit.common.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.util.ScreenUtil;

/* loaded from: /tmp/classes2.dex */
public class ConfirmWithCheckboxDialog extends Dialog {
    private CompoundButton.OnCheckedChangeListener mCheckChangedListener;
    private String mCheckboxText;
    private String mContentText;
    private Context mContext;
    private View mDivideLine;
    private View.OnClickListener mNegativeClickListener;
    private String mNegativeText;
    private View.OnClickListener mPositiveClickListener;
    private String mPositiveText;
    private String mTitleText;

    public ConfirmWithCheckboxDialog(Context context) {
        super(context, R.style.TUICommonConfirmDialogTheme);
        this.mContext = context;
    }

    public ConfirmWithCheckboxDialog(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    private void initButtonNegative() {
        Button button = (Button) findViewById(R.id.btn_negative);
        if (this.mNegativeClickListener == null) {
            button.setVisibility(8);
            this.mDivideLine.setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(this.mNegativeText)) {
                button.setText(this.mNegativeText);
            }
            button.setOnClickListener(this.mNegativeClickListener);
        }
    }

    private void initButtonPositive() {
        Button button = (Button) findViewById(R.id.btn_positive);
        if (this.mPositiveClickListener == null) {
            button.setVisibility(8);
            this.mDivideLine.setVisibility(8);
        } else {
            if (!TextUtils.isEmpty(this.mPositiveText)) {
                button.setText(this.mPositiveText);
            }
            button.setOnClickListener(this.mPositiveClickListener);
        }
    }

    private void initCheckbox() {
        CheckBox checkBox = (CheckBox) findViewById(R.id.check);
        if (this.mCheckChangedListener == null) {
            checkBox.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.mCheckboxText)) {
            checkBox.setText(this.mCheckboxText);
        }
        checkBox.setOnCheckedChangeListener(this.mCheckChangedListener);
    }

    private void initText() {
        TextView textView = (TextView) findViewById(R.id.title);
        TextView textView2 = (TextView) findViewById(R.id.content);
        textView.setText(this.mTitleText);
        textView2.setText(this.mContentText);
        if (this.mTitleText == null) {
            textView.setVisibility(8);
            textView2.setLayoutParams(setTextLayoutParams());
        } else if (this.mContentText == null) {
            textView2.setVisibility(8);
            textView.setLayoutParams(setTextLayoutParams());
        }
    }

    private ConstraintLayout.b setTextLayoutParams() {
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
        int dp2px = (int) ScreenUtil.dp2px(37.0f, this.mContext.getResources().getDisplayMetrics());
        bVar.h = 0;
        bVar.j = this.mCheckChangedListener == null ? R.id.horizontal_divider : R.id.check;
        bVar.setMargins(0, dp2px, 0, dp2px);
        return bVar;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.common_confirm_dialog);
        setCancelable(false);
        this.mDivideLine = findViewById(R.id.vertical_divider);
        initText();
        initCheckbox();
        initButtonPositive();
        initButtonNegative();
    }

    public void setCheckboxText(String str, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mCheckboxText = str;
        this.mCheckChangedListener = onCheckedChangeListener;
    }

    public void setContent(String str) {
        this.mContentText = str;
    }

    public void setNegativeText(String str, View.OnClickListener onClickListener) {
        this.mNegativeText = str;
        this.mNegativeClickListener = onClickListener;
    }

    public void setPositiveText(String str, View.OnClickListener onClickListener) {
        this.mPositiveText = str;
        this.mPositiveClickListener = onClickListener;
    }

    public void setTitle(String str) {
        this.mTitleText = str;
    }
}
