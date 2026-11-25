package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class UserSearchResult implements Serializable {
    private boolean isFinished;
    private String nextCursor;
    private int totalCount;
    private List<UserInfo> userList;

    public boolean getIsFinished() {
        return this.isFinished;
    }

    public String getNextCursor() {
        return this.nextCursor;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public List<UserInfo> getUserList() {
        return this.userList;
    }
}
