package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class GoodsRecordBean {
    private boolean mChecked;
    private boolean mEdit;

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    @JSONField(serialize = false)
    public boolean isEdit() {
        return this.mEdit;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    @JSONField(serialize = false)
    public void setEdit(boolean z) {
        this.mEdit = z;
    }

    public void toggle() {
        this.mChecked = !this.mChecked;
    }
}
