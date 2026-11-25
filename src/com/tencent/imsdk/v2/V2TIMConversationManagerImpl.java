package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationListFilter;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.conversation.ConversationOperationResult;
import com.tencent.imsdk.conversation.ConversationResult;
import com.tencent.imsdk.conversation.UnreadMessageCountResult;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import com.tencent.imsdk.message.MessageCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class V2TIMConversationManagerImpl extends V2TIMConversationManager {
    private ConversationListener mConversationListener;
    private V2TIMConversationListener mV2TIMConversationListener;
    private final List<V2TIMConversationListener> mV2TIMConversationListenerList;

    /* loaded from: /tmp/classes2.dex */
    public static class V2TIMConversationManagerImplHolder {
        private static final V2TIMConversationManagerImpl v2TIMConversationManagerImpl = new V2TIMConversationManagerImpl();

        private V2TIMConversationManagerImplHolder() {
        }
    }

    private V2TIMConversationManagerImpl() {
        this.mV2TIMConversationListenerList = new ArrayList();
        initListener();
    }

    public static V2TIMConversationManagerImpl getInstance() {
        return V2TIMConversationManagerImplHolder.v2TIMConversationManagerImpl;
    }

    private void initListener() {
        if (this.mConversationListener == null) {
            this.mConversationListener = new ConversationListener() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.1
                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationChanged(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationChanged(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationDeleted(List<String> list) {
                    List<String> unmodifiableList = Collections.unmodifiableList(list);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationDeleted(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupCreated(String str, List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationGroupCreated(str, unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupDeleted(String str) {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationGroupDeleted(str);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationGroupNameChanged(String str, String str2) {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationGroupNameChanged(str, str2);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationsAddedToGroup(String str, List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationsAddedToGroup(str, unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationsDeletedFromGroup(String str, List<Conversation> list, int i) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        v2TIMConversationListener.onConversationsDeletedFromGroup(str, unmodifiableList);
                        v2TIMConversationListener.onConversationsDeletedFromGroup(str, unmodifiableList, i);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onNewConversation(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onNewConversation(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFailed() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerFailed();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFinish() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerFinish();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerStart() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerStart();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onUnreadMessageCountChanged(UnreadMessageCountResult unreadMessageCountResult) {
                    for (V2TIMConversationListener v2TIMConversationListener : V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList) {
                        ConversationListFilter filter = unreadMessageCountResult.getFilter();
                        if (filter == null || filter.isNull()) {
                            v2TIMConversationListener.onTotalUnreadMessageCountChanged(unreadMessageCountResult.getTotalUnreadCount());
                        } else {
                            V2TIMConversationListFilter v2TIMConversationListFilter = new V2TIMConversationListFilter();
                            v2TIMConversationListFilter.setConversationFilter(filter);
                            v2TIMConversationListener.onUnreadMessageCountChangedByFilter(v2TIMConversationListFilter, unreadMessageCountResult.getTotalUnreadCount());
                        }
                    }
                }
            };
        }
        ConversationManager.getInstance().setConversationListener(this.mConversationListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void addConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.contains(v2TIMConversationListener)) {
                    return;
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void addConversationsToGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupName is empty");
            }
        } else if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList is empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().addConversationsToGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.33
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.34
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void cleanConversationUnreadMessageCount(String str, long j, long j2, V2TIMCallback v2TIMCallback) {
        IMCallback iMCallback = new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.23
            public void fail(int i, String str2) {
                super.fail(i, str2);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        };
        if (str == null || str.length() == 0) {
            ConversationManager.getInstance().clearUnreadMessage(true, true, iMCallback);
            return;
        }
        ConversationKey conversationKey = getConversationKey(str);
        if (1 == conversationKey.getConversationType()) {
            if (conversationKey.getConversationID().isEmpty()) {
                ConversationManager.getInstance().clearUnreadMessage(true, false, iMCallback);
                return;
            } else {
                MessageCenter.getInstance().setC2CMessageRead(conversationKey.getConversationID(), j, iMCallback);
                return;
            }
        }
        if (2 != conversationKey.getConversationType()) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is invalid");
            }
        } else if (conversationKey.getConversationID().isEmpty()) {
            ConversationManager.getInstance().clearUnreadMessage(false, true, iMCallback);
        } else {
            MessageCenter.getInstance().setGroupMessageRead(conversationKey.getConversationID(), j2, iMCallback);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void createConversationGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "group name is empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().createConversationGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.28
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.29
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversation(String str, final V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationKey conversationKey = getConversationKey(str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(conversationKey);
            ConversationManager.getInstance().deleteConversationList(arrayList, true, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.13
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list) {
                    if (v2TIMCallback != null) {
                        if (list.isEmpty() || list.get(0).getResultCode() == 0) {
                            v2TIMCallback.onSuccess();
                        } else {
                            v2TIMCallback.onError(list.get(0).getResultCode(), list.get(0).getResultInfo());
                        }
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.14
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversationGroup(String str, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().deleteConversationGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.31
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "group name is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversationList(List<String> list, boolean z, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList is empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().deleteConversationList(arrayList, z, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.15
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.16
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversationsFromGroup(String str, List<String> list, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupName is empty");
            }
        } else if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList is empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().deleteConversationsFromGroup(str, arrayList, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.35
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.36
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversation(String str, final V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationManager.getInstance().getConversationInfo(getConversationKey(str), new IMCallback<Conversation>(new V2TIMValueCallback<Conversation>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.11
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Conversation conversation) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        v2TIMValueCallback.onSuccess(v2TIMConversation);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.12
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Conversation conversation) {
                    super.success(conversation);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationGroupList(V2TIMValueCallback<List<String>> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationGroupList(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.30
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    public ConversationKey getConversationKey(String str) {
        ConversationKey conversationKey = new ConversationKey();
        if (TextUtils.isEmpty(str)) {
            return conversationKey;
        }
        if (str.indexOf("c2c_") == 0) {
            String substring = str.substring(4);
            conversationKey.setConversationType(1);
            conversationKey.setConversationID(substring);
            return conversationKey;
        }
        if (str.indexOf("group_") == 0) {
            String substring2 = str.substring(6);
            conversationKey.setConversationType(2);
            conversationKey.setConversationID(substring2);
            return conversationKey;
        }
        if (str.equals("c2c")) {
            conversationKey.setConversationType(1);
            conversationKey.setConversationID("");
            return conversationKey;
        }
        if (str.equals("group")) {
            conversationKey.setConversationType(2);
            conversationKey.setConversationID("");
            return conversationKey;
        }
        if (str.length() == 0) {
            conversationKey.setConversationType(3);
            conversationKey.setConversationID("");
            return conversationKey;
        }
        conversationKey.setConversationType(0);
        conversationKey.setConversationID("");
        return conversationKey;
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(long j, int i, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        if (i <= 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "count is invalid");
            }
        } else {
            ConversationManager.getInstance().getConversationList(j, i, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.5
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(ConversationResult conversationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                        v2TIMConversationResult.setConversationResult(conversationResult);
                        v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.6
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                public void success(ConversationResult conversationResult) {
                    super.success(conversationResult);
                }
            });
            BaseManager.getInstance().reportTUIComponentUsage(2L);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(List<String> list, final V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList cannot be empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().getConversationList(arrayList, new IMCallback<List<Conversation>>(new V2TIMValueCallback<List<Conversation>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.7
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Conversation> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Conversation conversation : list2) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList2.add(v2TIMConversation);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.8
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(List<Conversation> list2) {
                    super.success(list2);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationListByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, long j, int i, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        if (v2TIMConversationListFilter == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "filter is null");
            }
        } else if (i > 0) {
            ConversationManager.getInstance().getConversationListByFilter(v2TIMConversationListFilter.getConversationFilter(), j, i, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.9
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i2, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(ConversationResult conversationResult) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                        v2TIMConversationResult.setConversationResult(conversationResult);
                        v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.10
                public void fail(int i2, String str) {
                    super.fail(i2, str);
                }

                public void success(ConversationResult conversationResult) {
                    super.success(conversationResult);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "count is invalid");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getTotalUnreadMessageCount(final V2TIMValueCallback<Long> v2TIMValueCallback) {
        ConversationManager.getInstance().getTotalUnreadMessageCount(new ConversationListFilter(), new IMCallback<UnreadMessageCountResult>(new V2TIMValueCallback<UnreadMessageCountResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.19
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(UnreadMessageCountResult unreadMessageCountResult) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(Long.valueOf(unreadMessageCountResult.getTotalUnreadCount()));
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.20
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(UnreadMessageCountResult unreadMessageCountResult) {
                super.success(unreadMessageCountResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter, final V2TIMValueCallback<Long> v2TIMValueCallback) {
        if (v2TIMConversationListFilter == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "filter must not be null");
            }
        } else {
            ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
            if (conversationFilter.isNull()) {
                v2TIMValueCallback.onError(6017, "one of type, conversationGroup and markType fields of the filter must be set");
            } else {
                ConversationManager.getInstance().getTotalUnreadMessageCount(conversationFilter, new IMCallback<UnreadMessageCountResult>(new V2TIMValueCallback<UnreadMessageCountResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.21
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i, String str) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onError(i, str);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(UnreadMessageCountResult unreadMessageCountResult) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onSuccess(Long.valueOf(unreadMessageCountResult.getTotalUnreadCount()));
                        }
                    }
                }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.22
                    public void fail(int i, String str) {
                        super.fail(i, str);
                    }

                    public void success(UnreadMessageCountResult unreadMessageCountResult) {
                        super.success(unreadMessageCountResult);
                    }
                });
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void markConversation(List<String> list, long j, boolean z, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList is empty");
            }
        } else if (j == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "markType is invalid");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().markConversation(arrayList, j, z, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.24
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.25
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void pinConversation(String str, boolean z, V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str)) {
            ConversationManager.getInstance().pinConversation(getConversationKey(str), z, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.18
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "conversationID is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void removeConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void renameConversationGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "oldName is empty");
            }
        } else if (!TextUtils.isEmpty(str2)) {
            ConversationManager.getInstance().renameConversationGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.32
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "newName is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationCustomData(List<String> list, String str, final V2TIMValueCallback<List<V2TIMConversationOperationResult>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList is empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().setConversationCustomData(arrayList, str, new IMCallback(new V2TIMValueCallback<List<ConversationOperationResult>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.26
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ConversationOperationResult> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (ConversationOperationResult conversationOperationResult : list2) {
                        V2TIMConversationOperationResult v2TIMConversationOperationResult = new V2TIMConversationOperationResult();
                        v2TIMConversationOperationResult.setConversationOperationResult(conversationOperationResult);
                        arrayList2.add(v2TIMConversationOperationResult);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.27
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationKey conversationKey = getConversationKey(str);
            DraftMessage draftMessage = new DraftMessage();
            if (str2 != null) {
                draftMessage.setUserDefinedData(str2.getBytes());
            }
            ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.17
                public void fail(int i, String str3) {
                    super.fail(i, str3);
                }

                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(V2TIMConversationManagerImpl.this.mV2TIMConversationListener);
                }
                if (v2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListener = v2TIMConversationListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void subscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter) {
        if (v2TIMConversationListFilter == null) {
            return;
        }
        ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
        if (conversationFilter.isNull()) {
            return;
        }
        ConversationManager.getInstance().subscribeUnreadMessageCountByFilter(conversationFilter);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void unsubscribeUnreadMessageCountByFilter(V2TIMConversationListFilter v2TIMConversationListFilter) {
        if (v2TIMConversationListFilter == null) {
            return;
        }
        ConversationListFilter conversationFilter = v2TIMConversationListFilter.getConversationFilter();
        if (conversationFilter.isNull()) {
            return;
        }
        ConversationManager.getInstance().unsubscribeUnreadMessageCountByFilter(conversationFilter);
    }
}
