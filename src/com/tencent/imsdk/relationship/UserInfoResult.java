package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class UserInfoResult implements Serializable {
    private String nextCursor;
    private List<UserInfo> userInfoList;

    public String getNextCursor() {
        return this.nextCursor;
    }

    public List<UserInfo> getUserInfoList() {
        return this.userInfoList;
    }

    public void setNextCursor(String str) {
        this.nextCursor = str;
    }

    public void setUserInfoList(List<UserInfo> list) {
        this.userInfoList = list;
    }
}
