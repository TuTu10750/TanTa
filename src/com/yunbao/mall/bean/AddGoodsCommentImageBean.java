package com.yunbao.mall.bean;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class AddGoodsCommentImageBean {
    private File mFile;
    private String mUploadResultUrl;

    public File getFile() {
        return this.mFile;
    }

    public String getUploadResultUrl() {
        return this.mUploadResultUrl;
    }

    public boolean isEmpty() {
        File file = this.mFile;
        return file == null || !file.exists();
    }

    public void setEmpty() {
        this.mFile = null;
    }

    public void setFile(File file) {
        this.mFile = file;
    }

    public void setUploadResultUrl(String str) {
        this.mUploadResultUrl = str;
    }
}
