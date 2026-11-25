package com.yunbao.common.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* loaded from: /tmp/classes2.dex */
public class MyRadioButton extends RadioButton {
    public MyRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(boolean z) {
        super.setChecked(z);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
    }
}
