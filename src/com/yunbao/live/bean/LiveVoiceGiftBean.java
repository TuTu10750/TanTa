package com.yunbao.live.bean;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* loaded from: /tmp/classes2.dex */
public class LiveVoiceGiftBean {
    private String mAvatar;
    private boolean mChecked;
    private Drawable mCheckedDrawable;
    private int mTextRes;
    private int mType;
    private String mUid;
    private Drawable mUnCheckedDrawable;

    public String getAvatar() {
        return this.mAvatar;
    }

    public Drawable getCheckedDrawable() {
        return this.mCheckedDrawable;
    }

    public int getTextRes() {
        return this.mTextRes;
    }

    public int getType() {
        return this.mType;
    }

    public String getUid() {
        return this.mUid;
    }

    public Drawable getUnCheckedDrawable() {
        return this.mUnCheckedDrawable;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setDrawable(Context context, int i, int i2) {
        this.mCheckedDrawable = o60.d(context, i);
        this.mUnCheckedDrawable = o60.d(context, i2);
    }

    public void setTextRes(int i) {
        this.mTextRes = i;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void setUid(String str) {
        this.mUid = str;
    }
}
