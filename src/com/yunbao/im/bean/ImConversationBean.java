package com.yunbao.im.bean;

import defpackage.h54;

/* loaded from: /tmp/classes2.dex */
public class ImConversationBean {
    private String mConversationID;
    private String mGroupID;
    private boolean mIsGroup;
    private String mLastMsgId;
    private String mLastMsgString;
    private long mLastMsgTime;
    private String mLastMsgTimeString;
    private int mUnReadCount;
    private String mUserID;

    public String getConversationID() {
        return this.mConversationID;
    }

    public String getGroupID() {
        String str = this.mGroupID;
        return str != null ? str : "";
    }

    public String getLastMsgId() {
        String str = this.mLastMsgId;
        return str != null ? str : "";
    }

    public String getLastMsgString() {
        String str = this.mLastMsgString;
        return str != null ? str : "";
    }

    public long getLastMsgTime() {
        return this.mLastMsgTime;
    }

    public long getLastMsgTimeFormat() {
        return h54.a(getLastMsgTime());
    }

    public String getLastMsgTimeString() {
        return this.mLastMsgTimeString;
    }

    public int getUnReadCount() {
        return this.mUnReadCount;
    }

    public String getUserID() {
        String str = this.mUserID;
        return str != null ? str : "";
    }

    public boolean isGroup() {
        return this.mIsGroup;
    }

    public void setConversationID(String str) {
        this.mConversationID = str;
    }

    public void setGroup(boolean z) {
        this.mIsGroup = z;
    }

    public void setGroupID(String str) {
        this.mGroupID = str;
    }

    public void setLastMsgId(String str) {
        this.mLastMsgId = str;
    }

    public void setLastMsgString(String str) {
        this.mLastMsgString = str;
    }

    public void setLastMsgTime(long j) {
        this.mLastMsgTime = j * 1000;
    }

    public void setLastMsgTimeString(String str) {
        this.mLastMsgTimeString = str;
    }

    public void setUnReadCount(int i) {
        this.mUnReadCount = i;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }
}
