package com.yunbao.mall.bean;

import android.text.TextUtils;
import defpackage.rv3;

/* loaded from: /tmp/classes2.dex */
public class GoodsCommentTypeBean {
    private boolean mChecked;
    private String mCount;
    private String mTip;
    private String mType;

    public GoodsCommentTypeBean(String str, String str2) {
        this.mType = str;
        this.mTip = str2;
    }

    public String getCount() {
        return this.mCount;
    }

    public String getText() {
        boolean isEmpty = TextUtils.isEmpty(this.mCount);
        String str = this.mTip;
        return isEmpty ? str : rv3.a(str, "(", this.mCount, ")");
    }

    public String getTip() {
        return this.mTip;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setCount(String str) {
        this.mCount = str;
    }

    public void setTip(String str) {
        this.mTip = str;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
