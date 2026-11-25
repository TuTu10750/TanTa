package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserSearchParam;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class V2TIMFriendSearchParam implements Serializable {
    private static final int SEARCH_FIELD_NICK_NAME = 2;
    private static final int SEARCH_FIELD_REMARK = 4;
    private static final int SEARCH_FIELD_USER_ID = 1;
    private UserSearchParam userSearchParam = new UserSearchParam();

    public List<String> getKeywordList() {
        return this.userSearchParam.getKeywordList();
    }

    public UserSearchParam getUserSearchParam() {
        return this.userSearchParam;
    }

    public void setKeywordList(List<String> list) {
        this.userSearchParam.setKeywordList(list);
    }

    public void setSearchNickName(boolean z) {
        UserSearchParam userSearchParam = this.userSearchParam;
        if (z) {
            userSearchParam.addSearchField(2);
        } else {
            userSearchParam.removeSearchField(2);
        }
    }

    public void setSearchRemark(boolean z) {
        UserSearchParam userSearchParam = this.userSearchParam;
        if (z) {
            userSearchParam.addSearchField(4);
        } else {
            userSearchParam.removeSearchField(4);
        }
    }

    public void setSearchUserID(boolean z) {
        UserSearchParam userSearchParam = this.userSearchParam;
        if (z) {
            userSearchParam.addSearchField(1);
        } else {
            userSearchParam.removeSearchField(1);
        }
    }
}
