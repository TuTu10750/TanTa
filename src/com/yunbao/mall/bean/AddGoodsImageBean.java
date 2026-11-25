package com.yunbao.mall.bean;

import android.text.TextUtils;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class AddGoodsImageBean {
    private File mFile;
    private String mImgUrl;
    private String mUploadResultUrl;

    public File getFile() {
        return this.mFile;
    }

    public String getImgUrl() {
        return this.mImgUrl;
    }

    public String getUploadResultUrl() {
        int lastIndexOf;
        return !TextUtils.isEmpty(this.mUploadResultUrl) ? this.mUploadResultUrl : (TextUtils.isEmpty(this.mImgUrl) || (lastIndexOf = this.mImgUrl.lastIndexOf("/") + 1) <= 0) ? "" : this.mImgUrl.substring(lastIndexOf);
    }

    public boolean isEmpty() {
        return this.mFile == null && TextUtils.isEmpty(this.mImgUrl);
    }

    public void setEmpty() {
        this.mFile = null;
        this.mImgUrl = null;
    }

    public void setFile(File file) {
        this.mFile = file;
    }

    public void setImgUrl(String str) {
        this.mImgUrl = str;
    }

    public void setUploadResultUrl(String str) {
        this.mUploadResultUrl = str;
    }
}
