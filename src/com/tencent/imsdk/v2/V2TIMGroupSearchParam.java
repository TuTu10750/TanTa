package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupSearchParam;
import java.io.Serializable;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class V2TIMGroupSearchParam implements Serializable {
    private static final int SEARCH_FIELD_GROUP_ID = 1;
    private static final int SEARCH_FIELD_GROUP_NAME = 2;
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_AND = 1;
    public static final int V2TIM_KEYWORD_LIST_MATCH_TYPE_OR = 0;
    private GroupSearchParam groupSearchParam = new GroupSearchParam();

    public GroupSearchParam getGroupSearchParam() {
        return this.groupSearchParam;
    }

    public List<String> getKeywordList() {
        return this.groupSearchParam.getKeywordList();
    }

    public void setKeywordList(List<String> list) {
        this.groupSearchParam.setKeywordList(list);
    }

    public void setKeywordListMatchType(int i) {
        GroupSearchParam groupSearchParam = this.groupSearchParam;
        if (i == 0) {
            groupSearchParam.setKeywordListMatchType(0);
        } else {
            groupSearchParam.setKeywordListMatchType(1);
        }
    }

    public void setSearchCount(int i) {
        this.groupSearchParam.setSearchCount(i);
    }

    public void setSearchCursor(String str) {
        this.groupSearchParam.setSearchCursor(str);
    }

    public void setSearchGroupID(boolean z) {
        GroupSearchParam groupSearchParam = this.groupSearchParam;
        if (z) {
            groupSearchParam.addSearchField(1);
        } else {
            groupSearchParam.removeSearchField(1);
        }
    }

    public void setSearchGroupName(boolean z) {
        GroupSearchParam groupSearchParam = this.groupSearchParam;
        if (z) {
            groupSearchParam.addSearchField(2);
        } else {
            groupSearchParam.removeSearchField(2);
        }
    }
}
