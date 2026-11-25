package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveAudienceFloatWindowData {
    private String mAgoraToken;
    private boolean mIsTxSDK;
    private int mLinkMicAudienceUid;
    private int mLiveUid;
    private int mPkUid;
    private String mStream;

    public String getAgoraToken() {
        return this.mAgoraToken;
    }

    public int getLinkMicAudienceUid() {
        return this.mLinkMicAudienceUid;
    }

    public int getLiveUid() {
        return this.mLiveUid;
    }

    public int getPkUid() {
        return this.mPkUid;
    }

    public String getStream() {
        return this.mStream;
    }

    public boolean isTxSDK() {
        return this.mIsTxSDK;
    }

    public void setAgoraToken(String str) {
        this.mAgoraToken = str;
    }

    public void setLinkMicAudienceUid(int i) {
        this.mLinkMicAudienceUid = i;
    }

    public void setLiveUid(int i) {
        this.mLiveUid = i;
    }

    public void setPkUid(int i) {
        this.mPkUid = i;
    }

    public void setStream(String str) {
        this.mStream = str;
    }

    public void setTxSDK(boolean z) {
        this.mIsTxSDK = z;
    }

    public String toString() {
        return "LiveAudienceFloatWindowData{mIsTxSDK=" + this.mIsTxSDK + ", mAgoraToken='" + this.mAgoraToken + "', mLiveUid=" + this.mLiveUid + ", mStream='" + this.mStream + "', mPkUid=" + this.mPkUid + ", mLinkMicAudienceUid=" + this.mLinkMicAudienceUid + '}';
    }
}
