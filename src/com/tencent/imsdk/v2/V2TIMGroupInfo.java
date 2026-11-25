package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupInfo;
import com.tencent.imsdk.group.GroupMemberInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class V2TIMGroupInfo implements Serializable {
    static final String GROUP_TYPE_INTERNAL_CHATROOM = "ChatRoom";
    static final String GROUP_TYPE_INTERNAL_PRIVATE = "Private";
    public static final int V2TIM_GROUP_ADD_ANY = 2;
    public static final int V2TIM_GROUP_ADD_AUTH = 1;
    public static final int V2TIM_GROUP_ADD_FORBID = 0;
    private final String TAG = "V2TIMGroupInfo";
    private GroupInfo groupInfo = new GroupInfo();
    private int modifyFlag = 0;

    public long getCreateTime() {
        return this.groupInfo.getCreateTime();
    }

    public Map<String, byte[]> getCustomInfo() {
        return this.groupInfo.getCustomInfo();
    }

    public long getDefaultPermissions() {
        return this.groupInfo.getDefaultPermissions();
    }

    public String getFaceUrl() {
        return this.groupInfo.getFaceUrl();
    }

    public int getGroupAddOpt() {
        int applyApproveOption = this.groupInfo.getApplyApproveOption();
        if (applyApproveOption == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
            return 2;
        }
        if (applyApproveOption == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
            return 0;
        }
        return applyApproveOption == GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION ? 1 : 2;
    }

    public int getGroupApproveOpt() {
        int inviteApproveOption = this.groupInfo.getInviteApproveOption();
        if (inviteApproveOption == GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY) {
            return 2;
        }
        if (inviteApproveOption == GroupInfo.GROUP_ADD_OPTION_FORBID_ANY) {
            return 0;
        }
        return inviteApproveOption == GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION ? 1 : 2;
    }

    public String getGroupID() {
        return this.groupInfo.getGroupID();
    }

    public GroupInfo getGroupInfo() {
        return this.groupInfo;
    }

    public String getGroupName() {
        return this.groupInfo.getGroupName();
    }

    public String getGroupType() {
        String groupType = this.groupInfo.getGroupType();
        return groupType.equals(GROUP_TYPE_INTERNAL_PRIVATE) ? V2TIMManager.GROUP_TYPE_WORK : groupType.equals(GROUP_TYPE_INTERNAL_CHATROOM) ? V2TIMManager.GROUP_TYPE_MEETING : groupType;
    }

    public String getIntroduction() {
        return this.groupInfo.getIntroduction();
    }

    public long getJoinTime() {
        return this.groupInfo.getGroupSelfInfo().getJoinTime();
    }

    public long getLastInfoTime() {
        return this.groupInfo.getGroupInfoTimestamp();
    }

    public long getLastMessageTime() {
        return this.groupInfo.getLastMessageTimestamp();
    }

    public int getMemberCount() {
        return (int) this.groupInfo.getMemberCount();
    }

    public long getMemberMaxCount() {
        return this.groupInfo.getMemberMaxCount();
    }

    public int getModifyFlag() {
        return this.modifyFlag;
    }

    public String getNotification() {
        return this.groupInfo.getNotification();
    }

    @Deprecated
    public int getOnlineCount() {
        return (int) this.groupInfo.getMemberOnlineCount();
    }

    public String getOwner() {
        return this.groupInfo.getOwnerUserID();
    }

    public int getRecvOpt() {
        int messageReceiveOption = this.groupInfo.getGroupSelfInfo().getMessageReceiveOption();
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE) {
            return 0;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE) {
            return 1;
        }
        if (messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH) {
            return 2;
        }
        return messageReceiveOption == GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH_EXCEPT_AT ? 3 : 0;
    }

    public int getRole() {
        int role = this.groupInfo.getGroupSelfInfo().getRole();
        if (role == GroupMemberInfo.MEMBER_ROLE_MEMBER) {
            return 200;
        }
        if (role == GroupMemberInfo.MEMBER_ROLE_ADMINISTRATOR) {
            return 300;
        }
        if (role == GroupMemberInfo.MEMBER_ROLE_OWNER) {
            return V2TIMGroupMemberFullInfo.V2TIM_GROUP_MEMBER_ROLE_OWNER;
        }
        return 0;
    }

    public boolean isAllMuted() {
        return this.groupInfo.isAllShutUp();
    }

    public boolean isEnablePermissionGroup() {
        return this.groupInfo.isEnablePermissionGroup();
    }

    public boolean isSupportTopic() {
        return this.groupInfo.isSupportTopic();
    }

    public void setAllMuted(boolean z) {
        this.groupInfo.setAllShutUp(z);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_SHUTUP_ALL);
    }

    public void setCustomInfo(Map<String, byte[]> map) {
        if (map == null) {
            return;
        }
        if (!(map instanceof HashMap)) {
            IMLog.e("V2TIMGroupInfo", "customInfoMap must be HashMap");
        } else {
            this.groupInfo.setCustomInfo(map);
            this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_CUSTOM_INFO);
        }
    }

    public void setDefaultPermissions(long j) {
        this.groupInfo.setDefaultPermissions(j);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_DEFAULT_PERMISSIONS);
    }

    public void setEnablePermissionGroup(boolean z) {
        this.groupInfo.setEnablePermissionGroup(z);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_ENABLE_PERMISSION_GROUP);
    }

    public void setFaceUrl(String str) {
        this.groupInfo.setFaceUrl(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_FACE_URL);
    }

    public void setGroupAddOpt(int i) {
        if (2 == i) {
            this.groupInfo.setApplyApproveOption(GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY);
        } else if (i == 0) {
            this.groupInfo.setApplyApproveOption(GroupInfo.GROUP_ADD_OPTION_FORBID_ANY);
        } else if (1 == i) {
            this.groupInfo.setApplyApproveOption(GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION);
        }
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_APPLY_APPROVE_OPTION);
    }

    public void setGroupApproveOpt(int i) {
        if (2 == i) {
            this.groupInfo.setInviteApproveOption(GroupInfo.GROUP_ADD_OPTION_ALLOW_ANY);
        } else if (i == 0) {
            this.groupInfo.setInviteApproveOption(GroupInfo.GROUP_ADD_OPTION_FORBID_ANY);
        } else if (1 == i) {
            this.groupInfo.setInviteApproveOption(GroupInfo.GROUP_ADD_OPTION_NEED_AUTHENTICATION);
        }
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INVITE_APPROVE_OPTION);
    }

    public void setGroupID(String str) {
        this.groupInfo.setGroupID(str);
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public void setGroupName(String str) {
        this.groupInfo.setGroupName(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NAME);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
    
        if (r4.equalsIgnoreCase(com.tencent.imsdk.v2.V2TIMManager.GROUP_TYPE_AVCHATROOM) != false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setGroupType(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto Le
            java.lang.String r3 = "V2TIMGroupInfo"
            java.lang.String r4 = "setGroupType error type is null"
            com.tencent.imsdk.common.IMLog.e(r3, r4)
            return
        Le:
            java.lang.String r0 = "Work"
            boolean r0 = r4.equalsIgnoreCase(r0)
            java.lang.String r1 = "Private"
            if (r0 == 0) goto L1a
        L18:
            r4 = r1
            goto L47
        L1a:
            java.lang.String r0 = "Meeting"
            boolean r0 = r4.equalsIgnoreCase(r0)
            java.lang.String r2 = "ChatRoom"
            if (r0 == 0) goto L26
        L24:
            r4 = r2
            goto L47
        L26:
            boolean r0 = r4.equalsIgnoreCase(r1)
            if (r0 == 0) goto L2d
            goto L18
        L2d:
            boolean r0 = r4.equalsIgnoreCase(r2)
            if (r0 == 0) goto L34
            goto L24
        L34:
            java.lang.String r0 = "Public"
            boolean r1 = r4.equalsIgnoreCase(r0)
            if (r1 == 0) goto L3e
        L3c:
            r4 = r0
            goto L47
        L3e:
            java.lang.String r0 = "AVChatRoom"
            boolean r1 = r4.equalsIgnoreCase(r0)
            if (r1 == 0) goto L47
            goto L3c
        L47:
            com.tencent.imsdk.group.GroupInfo r3 = r3.groupInfo
            r3.setGroupType(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.v2.V2TIMGroupInfo.setGroupType(java.lang.String):void");
    }

    public void setIntroduction(String str) {
        this.groupInfo.setIntroduction(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_INTRODUCTION);
    }

    public void setModifyFlag(int i) {
        this.modifyFlag = i;
    }

    public void setNotification(String str) {
        this.groupInfo.setNotification(str);
        this.modifyFlag = (int) (this.modifyFlag | GroupInfo.GROUP_INFO_MODIFY_FLAG_NOTIFICATION);
    }

    public void setSupportTopic(boolean z) {
        this.groupInfo.setSupportTopic(z);
    }
}
