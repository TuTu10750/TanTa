package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.GroupMessageReadMembers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class V2TIMGroupMessageReadMemberList implements Serializable {
    private int filter;
    private GroupMessageReadMembers readMembers;

    public List<V2TIMGroupMemberInfo> getMemberInfoList() {
        if (this.readMembers == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = this.filter;
        GroupMessageReadMembers groupMessageReadMembers = this.readMembers;
        if (i == 0) {
            for (GroupMemberInfo groupMemberInfo : groupMessageReadMembers.getReadMembers()) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                arrayList.add(v2TIMGroupMemberInfo);
            }
        } else {
            for (GroupMemberInfo groupMemberInfo2 : groupMessageReadMembers.getUnreadMembers()) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo2 = new V2TIMGroupMemberInfo();
                v2TIMGroupMemberInfo2.setGroupMemberInfo(groupMemberInfo2);
                arrayList.add(v2TIMGroupMemberInfo2);
            }
        }
        return arrayList;
    }

    public long getNextSeq() {
        GroupMessageReadMembers groupMessageReadMembers = this.readMembers;
        if (groupMessageReadMembers != null) {
            return groupMessageReadMembers.getNextSeq();
        }
        return 0L;
    }

    public boolean isFinished() {
        GroupMessageReadMembers groupMessageReadMembers = this.readMembers;
        if (groupMessageReadMembers != null) {
            return groupMessageReadMembers.isFinish();
        }
        return false;
    }

    public void setMessageReadMembers(GroupMessageReadMembers groupMessageReadMembers, int i) {
        this.readMembers = groupMessageReadMembers;
        this.filter = i;
    }
}
