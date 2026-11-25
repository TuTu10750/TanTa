package com.yunbao.common.upload;

import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class UploadBean {
    public static final int IMG = 0;
    public static final int VIDEO = 1;
    public static final int VOICE = 2;
    private String bucket_url;
    private File mCompressFile;
    private File mOriginFile;
    private String mRemoteFileName;
    private Object mTag;
    private final int mType;

    public UploadBean(File file, int i) {
        this.mOriginFile = file;
        this.mType = i;
    }

    public String getBucket_url() {
        return this.bucket_url;
    }

    public File getCompressFile() {
        return this.mCompressFile;
    }

    public File getOriginFile() {
        return this.mOriginFile;
    }

    public String getRemoteFileName() {
        return this.mRemoteFileName;
    }

    public Object getTag() {
        return this.mTag;
    }

    public int getType() {
        return this.mType;
    }

    public void setBucket_url(String str) {
        this.bucket_url = str;
    }

    public void setCompressFile(File file) {
        this.mCompressFile = file;
    }

    public void setOriginFile(File file) {
        this.mOriginFile = file;
    }

    public void setRemoteFileName(String str) {
        this.mRemoteFileName = str;
    }

    public void setTag(Object obj) {
        this.mTag = obj;
    }
}
