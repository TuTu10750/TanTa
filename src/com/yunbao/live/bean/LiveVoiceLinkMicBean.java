package com.yunbao.live.bean;

import android.text.TextUtils;

/* loaded from: /tmp/classes2.dex */
public class LiveVoiceLinkMicBean {
    private String mAvatar;
    private int mFaceIndex = -1;
    private int mStatus;
    private String mUid;
    private String mUserName;
    private String mUserStream;

    public String getAvatar() {
        return this.mAvatar;
    }

    public int getFaceIndex() {
        return this.mFaceIndex;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getUid() {
        return this.mUid;
    }

    public String getUserName() {
        return this.mUserName;
    }

    public String getUserStream() {
        return this.mUserStream;
    }

    public boolean isEmpty() {
        return TextUtils.isEmpty(this.mUid) || "0".equals(this.mUid);
    }

    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    public void setFaceIndex(int i) {
        this.mFaceIndex = i;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public void setUid(String str) {
        this.mUid = str;
    }

    public void setUserName(String str) {
        this.mUserName = str;
    }

    public void setUserStream(String str) {
        this.mUserStream = str;
    }
}
