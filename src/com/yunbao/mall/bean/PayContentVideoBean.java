package com.yunbao.mall.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class PayContentVideoBean {
    protected File mFile;
    protected int mIsSee;
    protected String mId = "";
    protected String mUploadResultUrl = "";
    protected String mTitle = "";
    protected String mDuration = "";
    protected String mFilePath = "";

    @JSONField(serialize = false)
    public void clear() {
        this.mFilePath = "";
        this.mFile = null;
        this.mDuration = "";
        this.mIsSee = 0;
        this.mTitle = "";
    }

    @JSONField(name = "video_length")
    public String getDuration() {
        return this.mDuration;
    }

    @JSONField(serialize = false)
    public File getFile() {
        return this.mFile;
    }

    @JSONField(serialize = false)
    public String getFilePath() {
        return this.mFilePath;
    }

    @JSONField(name = "video_id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "is_see")
    public int getIsSee() {
        return this.mIsSee;
    }

    @JSONField(name = "video_title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "video_url")
    public String getUploadResultUrl() {
        return this.mUploadResultUrl;
    }

    @JSONField(serialize = false)
    public boolean hasFile() {
        File file = this.mFile;
        return file != null && file.exists();
    }

    @JSONField(name = "video_length")
    public void setDuration(String str) {
        this.mDuration = str;
    }

    @JSONField(serialize = false)
    public void setFilePath(String str) {
        this.mFilePath = str;
        if (TextUtils.isEmpty(str)) {
            this.mFile = null;
        } else {
            this.mFile = new File(str);
        }
    }

    @JSONField(name = "video_id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "is_see")
    public void setIsSee(int i) {
        this.mIsSee = i;
    }

    @JSONField(name = "video_title")
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @JSONField(name = "video_url")
    public void setUploadResultUrl(String str) {
        this.mUploadResultUrl = str;
    }
}
