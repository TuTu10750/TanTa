package com.yunbao.mall.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class AddGoodsSpecBean extends GoodsSpecBean {

    @JSONField(serialize = false)
    private File mFile;

    @JSONField(serialize = false)
    private String mUploadResultUrl;

    @JSONField(serialize = false)
    public File getFile() {
        return this.mFile;
    }

    @JSONField(serialize = false)
    public String getUploadResultUrl() {
        int lastIndexOf;
        return !TextUtils.isEmpty(this.mUploadResultUrl) ? this.mUploadResultUrl : (TextUtils.isEmpty(this.mThumb) || (lastIndexOf = this.mThumb.lastIndexOf("/") + 1) <= 0) ? "" : this.mThumb.substring(lastIndexOf);
    }

    @JSONField(serialize = false)
    public boolean isEmpty() {
        return this.mFile == null && TextUtils.isEmpty(this.mThumb);
    }

    @JSONField(serialize = false)
    public void setEmpty() {
        this.mFile = null;
        this.mThumb = null;
    }

    @JSONField(serialize = false)
    public void setFile(File file) {
        this.mFile = file;
    }

    @JSONField(serialize = false)
    public void setUploadResultUrl(String str) {
        this.mUploadResultUrl = str;
    }
}
