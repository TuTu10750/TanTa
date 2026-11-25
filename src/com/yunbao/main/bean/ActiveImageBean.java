package com.yunbao.main.bean;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class ActiveImageBean {
    private File mImageFile;

    public ActiveImageBean() {
    }

    public ActiveImageBean(File file) {
        this.mImageFile = file;
    }

    public File getImageFile() {
        return this.mImageFile;
    }

    public void setImageFile(File file) {
        this.mImageFile = file;
    }
}
