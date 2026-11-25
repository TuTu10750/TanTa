package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveVoiceMixUserBean {
    private final int mIndex;
    private final String mStream;
    private final String mUid;

    public LiveVoiceMixUserBean(int i, String str, String str2) {
        this.mIndex = i;
        this.mUid = str;
        this.mStream = str2;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public String getStream() {
        return this.mStream;
    }

    public String getUid() {
        return this.mUid;
    }
}
