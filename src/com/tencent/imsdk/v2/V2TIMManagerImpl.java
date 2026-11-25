package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.community.TopicInfo;
import com.tencent.imsdk.group.GroupApplication;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.message.C2CMessageReceipt;
import com.tencent.imsdk.message.GroupMessageReceipt;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import com.tencent.imsdk.relationship.UserSearchResult;
import com.tencent.imsdk.relationship.UserStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private GroupListener mGroupInternalListener;
    private V2TIMSDKListener mIMSDKListener;
    private MessageListener mMessageInternalListener;
    private V2TIMGroupListener mV2TIMGroupListener;
    private Object mLockObject = new Object();
    private final List<V2TIMSDKListener> mIMSDKListenerList = new ArrayList();
    private final List<V2TIMGroupListener> mGroupListenerList = new ArrayList();
    private List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();

    /* loaded from: /tmp/classes2.dex */
    public static class V2TIMManagerImplHolder {
        private static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        private V2TIMManagerImplHolder() {
        }
    }

    public V2TIMManagerImpl() {
        initMessageListener();
        initGroupListener();
        V2TIMMessageManagerImpl.getInstance().initListener();
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    private void initGroupListener() {
        this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.32
            public V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo groupMemberInfo) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                if (groupMemberInfo != null) {
                    v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                }
                return v2TIMGroupMemberInfo;
            }

            public List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> list) {
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    Iterator<GroupMemberInfo> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(convertToV2GroupMemberInfo(it.next()));
                    }
                }
                return arrayList;
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onAllGroupMembersMuted(String str, boolean z) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onAllGroupMembersMuted(str, z);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onApplicationProcessed(str, convertToV2GroupMemberInfo(groupMemberInfo), z, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGrantAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupAttributeChanged(str, unmodifiableMap);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCounterChanged(String str, Map<String, Long> map) {
                for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                    for (Map.Entry<String, Long> entry : map.entrySet()) {
                        v2TIMGroupListener.onGroupCounterChanged(str, entry.getKey(), entry.getValue().longValue());
                    }
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCounterDeleted(String str, List<String> list) {
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCreated(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupCreated(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupDismissed(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupInfoChangeItem groupInfoChangeItem : list) {
                    V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                    v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
                    arrayList.add(v2TIMGroupChangeInfo);
                }
                List<V2TIMGroupChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupRecycled(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberEnter(String str, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberEnter(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : list) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
                    arrayList.add(v2TIMGroupMemberChangeInfo);
                }
                List<V2TIMGroupMemberChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInvited(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list, String str2) {
                V2TIMGroupMemberInfo convertToV2GroupMemberInfo = convertToV2GroupMemberInfo(groupMemberInfo);
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                HashMap hashMap = new HashMap();
                hashMap.put("groupID", str);
                hashMap.put("opUser", convertToV2GroupMemberInfo);
                hashMap.put("memberList", unmodifiableList);
                hashMap.put("reason", str2);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberKicked(str, convertToV2GroupMemberInfo, unmodifiableList);
                }
                Iterator it2 = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                while (it2.hasNext()) {
                    ((V2TIMSDKListener) it2.next()).onExperimentalNotify("onMemberKicked", hashMap);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberLeave(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberMarkChanged(String str, List<String> list, int i, boolean z) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberMarkChanged(str, list, i, z);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onQuitFromGroup(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onQuitFromGroup(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveInviteApplication(String str, int i, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list, String str2) {
                if (GroupApplication.REQUEST_TYPE_INVITE_TO_ADMIN == i) {
                    for (V2TIMGroupListener v2TIMGroupListener : V2TIMManagerImpl.this.mGroupListenerList) {
                        Iterator<GroupMemberInfo> it = list.iterator();
                        while (it.hasNext()) {
                            v2TIMGroupListener.onReceiveJoinApplication(str, convertToV2GroupMemberInfo(it.next()), str2);
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveJoinApplication(str, convertToV2GroupMemberInfo(groupMemberInfo), str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveRESTCustomData(str, (byte[]) bArr.clone());
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onRevokeAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicCreated(String str, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicCreated(str, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicDeleted(String str, List<String> list) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicDeleted(str, list);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onTopicInfoChanged(String str, TopicInfo topicInfo) {
                V2TIMTopicInfo v2TIMTopicInfo = new V2TIMTopicInfo();
                v2TIMTopicInfo.setTopicInfo(topicInfo);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onTopicInfoChanged(str, v2TIMTopicInfo);
                }
            }
        };
        GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
    }

    private void initMessageListener() {
        this.mMessageInternalListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.31
            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveC2CMessageReceipt(List<C2CMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveGroupMessageReceipt(List<GroupMessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(Map<MessageKey, Map<UserInfo, String>> map, boolean z) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo;
                if (list == null || list.isEmpty()) {
                    return;
                }
                for (Message message : list) {
                    int messageType = message.getMessageType();
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    int elemType = v2TIMMessage.getElemType();
                    V2TIMUserInfo v2TIMUserInfo = null;
                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                        V2TIMUserInfo v2TIMUserInfo2 = new V2TIMUserInfo();
                        v2TIMUserInfo2.setUserID(v2TIMMessage.getSender());
                        v2TIMUserInfo2.setNickName(v2TIMMessage.getNickName());
                        v2TIMUserInfo2.setFaceUrl(v2TIMMessage.getFaceUrl());
                        v2TIMUserInfo = v2TIMUserInfo2;
                        v2TIMGroupMemberInfo = null;
                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                        v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                        groupMemberInfo.setGroupID(message.getGroupID());
                        groupMemberInfo.setUserID(message.getSenderUserID());
                        groupMemberInfo.setNickname(message.getNickName());
                        groupMemberInfo.setNameCard(message.getNameCard());
                        groupMemberInfo.setFaceUrl(message.getFaceUrl());
                        groupMemberInfo.setFriendRemark(message.getFriendRemark());
                        v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                    } else {
                        v2TIMGroupMemberInfo = null;
                    }
                    if (elemType == 1) {
                        V2TIMTextElem textElem = v2TIMMessage.getTextElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            try {
                                for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                                        v2TIMSimpleMsgListener.onRecvC2CTextMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, textElem.getText());
                                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                        v2TIMSimpleMsgListener.onRecvGroupTextMessage(v2TIMMessage.getMsgID(), message.getGroupID(), v2TIMGroupMemberInfo, textElem.getText());
                                    }
                                }
                            } finally {
                            }
                        }
                    } else if (elemType == 2) {
                        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            try {
                                for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener2 : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                                        v2TIMSimpleMsgListener2.onRecvC2CCustomMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, customElem.getData());
                                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                        v2TIMSimpleMsgListener2.onRecvGroupCustomMessage(v2TIMMessage.getMsgID(), v2TIMMessage.getGroupID(), v2TIMGroupMemberInfo, customElem.getData());
                                    }
                                }
                            } finally {
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
    }

    private void setSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(V2TIMManagerImpl.this.mIMSDKListener);
                }
                if (v2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                }
                V2TIMManagerImpl.this.mIMSDKListener = v2TIMSDKListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.13
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mGroupListenerList.contains(v2TIMGroupListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListenerList.contains(v2TIMSDKListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            try {
                if (this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                    return;
                }
                this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        V2TIMManagerExperimentImpl.getInstance().callExperimentalAPI(str, obj, v2TIMValueCallback);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r4.equalsIgnoreCase(com.tencent.imsdk.v2.V2TIMManager.GROUP_TYPE_AVCHATROOM) != false) goto L26;
     */
    @Override // com.tencent.imsdk.v2.V2TIMManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void createGroup(java.lang.String r4, java.lang.String r5, java.lang.String r6, com.tencent.imsdk.v2.V2TIMValueCallback<java.lang.String> r7) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 6017(0x1781, float:8.432E-42)
            if (r0 == 0) goto L10
            if (r7 == 0) goto L1d
            java.lang.String r3 = "groupType is empty"
            r7.onError(r1, r3)
            return
        L10:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L1e
            if (r7 == 0) goto L1d
            java.lang.String r3 = "groupName is empty"
            r7.onError(r1, r3)
        L1d:
            return
        L1e:
            java.lang.String r0 = "Work"
            boolean r0 = r4.equalsIgnoreCase(r0)
            java.lang.String r1 = "Private"
            if (r0 == 0) goto L2a
        L28:
            r4 = r1
            goto L57
        L2a:
            java.lang.String r0 = "Meeting"
            boolean r0 = r4.equalsIgnoreCase(r0)
            java.lang.String r2 = "ChatRoom"
            if (r0 == 0) goto L36
        L34:
            r4 = r2
            goto L57
        L36:
            boolean r0 = r4.equalsIgnoreCase(r1)
            if (r0 == 0) goto L3d
            goto L28
        L3d:
            boolean r0 = r4.equalsIgnoreCase(r2)
            if (r0 == 0) goto L44
            goto L34
        L44:
            java.lang.String r0 = "Public"
            boolean r1 = r4.equalsIgnoreCase(r0)
            if (r1 == 0) goto L4e
        L4c:
            r4 = r0
            goto L57
        L4e:
            java.lang.String r0 = "AVChatRoom"
            boolean r1 = r4.equalsIgnoreCase(r0)
            if (r1 == 0) goto L57
            goto L4c
        L57:
            com.tencent.imsdk.group.GroupManager r0 = com.tencent.imsdk.group.GroupManager.getInstance()
            com.tencent.imsdk.v2.V2TIMManagerImpl$15 r1 = new com.tencent.imsdk.v2.V2TIMManagerImpl$15
            r1.<init>(r7)
            r0.createGroup(r4, r5, r6, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.v2.V2TIMManagerImpl.createGroup(java.lang.String, java.lang.String, java.lang.String, com.tencent.imsdk.v2.V2TIMValueCallback):void");
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void dismissGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().dismissGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.18
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public int getLoginStatus() {
        return BaseManager.getInstance().getLoginStatus();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getLoginUser() {
        return BaseManager.getInstance().getLoginUser();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public long getServerTime() {
        return BaseManager.getInstance().getServerTime();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUserStatus(List<String> list, final V2TIMValueCallback<List<V2TIMUserStatus>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUserStatus(list, new IMCallback<List<UserStatus>>(new V2TIMValueCallback<List<UserStatus>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.26
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserStatus> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserStatus userStatus : list2) {
                            V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                            v2TIMUserStatus.setUserStatus(userStatus);
                            arrayList.add(v2TIMUserStatus);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.27
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(List<UserStatus> list2) {
                    super.success(list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUsersInfo(list, new IMCallback<List<UserInfo>>(new V2TIMValueCallback<List<UserInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.19
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserInfo userInfo : list2) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.20
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(List<UserInfo> list2) {
                    super.success(list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig) {
        return initSDK(context, i, v2TIMSDKConfig, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        final V2TIMLogListener logListener = v2TIMSDKConfig.getLogListener();
        boolean z = logListener != null;
        SDKConfig sDKConfig = new SDKConfig();
        sDKConfig.sdkAppId = i;
        sDKConfig.logSetting.logLevel = v2TIMSDKConfig.getLogLevel();
        setSDKListener(v2TIMSDKListener);
        return BaseManager.getInstance().initSDK(context, sDKConfig, z, new SDKListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1
            @Override // com.tencent.imsdk.manager.SDKListener
            public void onAllReceiveMessageOptChanged(final ReceiveMessageOptInfo receiveMessageOptInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.12
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMReceiveMessageOptInfo v2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
                            v2TIMReceiveMessageOptInfo.setReceiveMessageOptInfo(receiveMessageOptInfo);
                            v2TIMSDKListener2.onAllReceiveMessageOptChanged(v2TIMReceiveMessageOptInfo);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectFailed(final int i2, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectFailed(i2, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectSuccess() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectSuccess();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnecting() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnecting();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onExperimentalNotify(final String str, final Object obj) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify(str, obj);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onKickedOffline() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onKickedOffline();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onLog(final int i2, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        V2TIMLogListener v2TIMLogListener = logListener;
                        if (v2TIMLogListener != null) {
                            v2TIMLogListener.onLog(i2, str);
                        }
                    }
                });
            }

            public void onLogout() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify("onLogout", "");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onSelfInfoUpdated(final UserInfo userInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                        }
                    }
                });
            }

            public void onUninited() {
                BaseManager.getInstance().unInitSDK(false);
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onExperimentalNotify("onUninited", "");
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserInfoChanged(final List<UserInfo> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.11
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            ArrayList arrayList = new ArrayList();
                            for (UserInfo userInfo : list) {
                                V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                                v2TIMUserFullInfo.setUserInfo(userInfo);
                                arrayList.add(v2TIMUserFullInfo);
                            }
                            v2TIMSDKListener2.onUserInfoChanged(arrayList);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserSigExpired() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onUserSigExpired();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserStatusChanged(final List<UserStatus> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.10
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            ArrayList arrayList = new ArrayList();
                            for (UserStatus userStatus : list) {
                                V2TIMUserStatus v2TIMUserStatus = new V2TIMUserStatus();
                                v2TIMUserStatus.setUserStatus(userStatus);
                                arrayList.add(v2TIMUserStatus);
                            }
                            v2TIMSDKListener2.onUserStatusChanged(arrayList);
                        }
                    }
                });
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().joinGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.16
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void login(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            v2TIMCallback.onError(6017, "userID or userSig is empty");
        } else {
            BaseManager.getInstance().login(str, str2, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.5
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i, String str3) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.6
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            }, 1);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void logout(V2TIMCallback v2TIMCallback) {
        BaseManager.getInstance().logout(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.7
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void quitGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            GroupManager.getInstance().quitGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.17
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid groupID");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.14
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mGroupListenerList.remove(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mIMSDKListenerList.remove(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void searchUsers(V2TIMUserSearchParam v2TIMUserSearchParam, final V2TIMValueCallback<V2TIMUserSearchResult> v2TIMValueCallback) {
        if (v2TIMUserSearchParam == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "searchParam is null");
            }
        } else if (v2TIMUserSearchParam.getKeywordList() == null || v2TIMUserSearchParam.getKeywordList().size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "empty keywordList");
            }
        } else {
            RelationshipManager.getInstance().searchUsers(v2TIMUserSearchParam.getUserSearchParam(), new IMCallback<UserSearchResult>(new V2TIMValueCallback<UserSearchResult>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.23
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(UserSearchResult userSearchResult) {
                    V2TIMUserSearchResult v2TIMUserSearchResult = new V2TIMUserSearchResult();
                    v2TIMUserSearchResult.setUserSearchResult(userSearchResult);
                    v2TIMValueCallback.onSuccess(v2TIMUserSearchResult);
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.24
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(UserSearchResult userSearchResult) {
                    super.success(userSearchResult);
                }
            });
            BaseManager.getInstance().reportTUIComponentUsage(6L);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "customData is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, str, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "text is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, str2, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupCustomMessage(byte[] bArr, String str, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(6017, "customData is null");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback == null) {
                return "";
            }
            v2TIMValueCallback.onError(6017, "groupID is empty");
            return "";
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, null, str, (i != 0 && (i == 1 || i == 3)) ? i : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.11
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupTextMessage(String str, String str2, int i, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback == null) {
                return null;
            }
            v2TIMValueCallback.onError(6017, "text is null");
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback == null) {
                return "";
            }
            v2TIMValueCallback.onError(6017, "groupID is empty");
            return "";
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, null, str2, (i != 0 && (i == 1 || i == 3)) ? i : 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.10
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i2, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i2) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(V2TIMManagerImpl.this.mV2TIMGroupListener);
                }
                if (v2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                }
                V2TIMManagerImpl.this.mV2TIMGroupListener = v2TIMGroupListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid params");
                return;
            }
            return;
        }
        HashMap<String, Object> modifyParams = v2TIMUserFullInfo.getModifyParams();
        if (modifyParams != null && !modifyParams.isEmpty()) {
            RelationshipManager.getInstance().setSelfInfo(v2TIMUserFullInfo.getModifyParams(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.21
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "no changed info");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfStatus(V2TIMUserStatus v2TIMUserStatus, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserStatus == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid params");
            }
        } else {
            UserStatus userStatus = v2TIMUserStatus.getUserStatus();
            if (userStatus == null && v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "no userStatus");
            }
            RelationshipManager.getInstance().setSelfStatus(userStatus, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.28
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void subscribeUserInfo(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().subscribeUserInfo(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.22
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void subscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().subscribeUserStatus(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.29
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unInitSDK() {
        this.mIMSDKListener = null;
        BaseManager.getInstance().unInitSDK(true);
        V2TIMSignalingManagerImpl.getInstance().unInit();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unsubscribeUserInfo(List<String> list, V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().unsubscribeUserInfo(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.25
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unsubscribeUserStatus(List<String> list, V2TIMCallback v2TIMCallback) {
        RelationshipManager.getInstance().unsubscribeUserStatus(list, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.30
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }
}
