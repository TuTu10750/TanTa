package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.CustomServerInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageExtension;
import com.tencent.imsdk.message.MessageExtensionResult;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.offlinepush.OfflinePushConfig;
import com.tencent.imsdk.offlinepush.OfflinePushEventItem;
import com.tencent.imsdk.offlinepush.OfflinePushManager;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public class V2TIMManagerExperimentImpl {

    /* loaded from: /tmp/classes2.dex */
    public static class V2TIMManagerExperimentImplHolder {
        private static final V2TIMManagerExperimentImpl v2TIMManagerExperiment = new V2TIMManagerExperimentImpl();

        private V2TIMManagerExperimentImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnError(V2TIMValueCallback<Object> v2TIMValueCallback, int i, String str) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(i, str);
        }
    }

    private void callbackOnSuccess(V2TIMValueCallback<Object> v2TIMValueCallback, Object obj) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(obj);
        }
    }

    private void cancelSendingMessage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
        } else {
            MessageCenter.getInstance().cancelSendingMessage((String) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.29
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void clearLocalHistoryMessage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            MessageCenter.getInstance().clearLocalHistoryMessage(V2TIMConversationManagerImpl.getInstance().getConversationKey(jSONObject.optString("conversationID")), jSONObject.optLong("beginTimestamp"), jSONObject.optLong("endTimestamp"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.8
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void disableHttpRequest(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().disableHttpRequest(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void downloadLibrary(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof Context)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not context");
        }
        BaseManager.getInstance().downloadLibrary((Context) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.18
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj2) {
                super.success(obj2);
            }
        });
    }

    private void findMergerMessages(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("messageID");
            if (TextUtils.isEmpty(optString)) {
                callbackOnError(v2TIMValueCallback, 6017, "messageID is empty");
                return;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("mergerMessageIDList");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String string = optJSONArray.getString(i);
                    if (string != null && string != null) {
                        arrayList.add(string);
                    }
                    callbackOnError(v2TIMValueCallback, 6017, "mergerMessageID is empty");
                    return;
                }
            }
            if (arrayList.size() == 0) {
                callbackOnError(v2TIMValueCallback, 6017, "mergerMessageIDList is empty");
            } else {
                MessageCenter.getInstance().findRelayMessageList(optString, arrayList, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.21
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i2, String str2) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onError(i2, str2);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(List<Message> list) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Message message : list) {
                            V2TIMMessage v2TIMMessage = new V2TIMMessage();
                            v2TIMMessage.setMessage(message);
                            arrayList2.add(v2TIMMessage);
                        }
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onSuccess(arrayList2);
                        }
                    }
                }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.22
                    public void fail(int i2, String str2) {
                        super.fail(i2, str2);
                    }

                    public void success(List<Message> list) {
                        super.success(list);
                    }
                });
            }
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void getAIDenoiseSignature(V2TIMValueCallback<Object> v2TIMValueCallback) {
        BaseManager.getInstance().getAIDenoiseSignature(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.10
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private void getBriefGroupMemberList(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        V2TIMValueCallback<List<GroupMemberInfo>> v2TIMValueCallback2 = new V2TIMValueCallback<List<GroupMemberInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.23
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<GroupMemberInfo> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (GroupMemberInfo groupMemberInfo : list) {
                        V2TIMGroupMemberFullInfo v2TIMGroupMemberFullInfo = new V2TIMGroupMemberFullInfo();
                        v2TIMGroupMemberFullInfo.setGroupMemberInfo(groupMemberInfo);
                        arrayList.add(v2TIMGroupMemberFullInfo);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        };
        BaseManager.getInstance().getBriefGroupMemberList((String) obj, new IMCallback<List<GroupMemberInfo>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.24
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(List<GroupMemberInfo> list) {
                super.success(list);
            }
        });
    }

    private void getConversationGroupOrderData(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationGroupOrderData(new IMCallback<String>(new V2TIMValueCallback<String>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.2
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(String str) {
                v2TIMValueCallback.onSuccess(str);
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.3
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(String str) {
                super.success(str);
            }
        });
    }

    private void getGroupMessageReceipts(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        JSONObject jSONObject;
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        HashMap hashMap = new HashMap();
        String str2 = "";
        try {
            jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("groupID");
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(str2)) {
            callbackOnError(v2TIMValueCallback, 6017, "groupID is empty");
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("requestList");
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
            if (jSONObject2.has("messageSequence") && jSONObject2.has("memberIDList")) {
                int i2 = jSONObject2.getInt("messageSequence");
                JSONArray jSONArray = jSONObject2.getJSONArray("memberIDList");
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(jSONArray.getString(i3));
                }
                hashMap.put(Integer.valueOf(i2), arrayList);
            }
            callbackOnError(v2TIMValueCallback, 6017, "invalid param");
            return;
        }
        BaseManager.getInstance().getGroupMessageReceipt(str2, hashMap, new IMCallback<Map<Integer, Map<Integer, List<String>>>>(new V2TIMValueCallback<Map<Integer, Map<Integer, List<String>>>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.30
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i4, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i4, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Map<Integer, Map<Integer, List<String>>> map) {
                if (v2TIMValueCallback != null) {
                    try {
                        JSONArray jSONArray2 = new JSONArray();
                        for (Map.Entry<Integer, Map<Integer, List<String>>> entry : map.entrySet()) {
                            Map<Integer, List<String>> value = entry.getValue();
                            if (value != null && !value.isEmpty()) {
                                Iterator<Map.Entry<Integer, List<String>>> it = value.entrySet().iterator();
                                if (it.hasNext()) {
                                    Map.Entry<Integer, List<String>> next = it.next();
                                    List<String> value2 = next.getValue();
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (String str3 : value2) {
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("memberID", str3);
                                        jSONArray3.put(jSONObject3);
                                    }
                                    int intValue = entry.getKey().intValue();
                                    int intValue2 = next.getKey().intValue();
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("messageSequence", intValue);
                                    jSONObject4.put("errorCode", intValue2);
                                    jSONObject4.put("readInfoList", jSONArray3);
                                    jSONArray2.put(jSONObject4);
                                }
                            }
                        }
                        v2TIMValueCallback.onSuccess(jSONArray2);
                    } catch (JSONException e2) {
                        V2TIMManagerExperimentImpl.this.callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
                        e2.printStackTrace();
                    }
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.31
            public void fail(int i4, String str3) {
                super.fail(i4, str3);
            }

            public void success(Map<Integer, Map<Integer, List<String>>> map) {
                super.success(map);
            }
        });
    }

    public static V2TIMManagerExperimentImpl getInstance() {
        return V2TIMManagerExperimentImplHolder.v2TIMManagerExperiment;
    }

    private void getLoginAccountType(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        BaseManager.getInstance().getLoginAccountType(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.20
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj2) {
                super.success(obj2);
            }
        });
    }

    private void getMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        long j;
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        String str2 = "";
        new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("groupID");
            j = jSONObject.optLong("messageSequence");
        } catch (JSONException e) {
            e.printStackTrace();
            j = 0;
        }
        V2TIMValueCallback<List<MessageExtension>> v2TIMValueCallback2 = new V2TIMValueCallback<List<MessageExtension>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.6
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i, String str3) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<MessageExtension> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MessageExtension messageExtension : list) {
                        V2TIMMessageExtension v2TIMMessageExtension = new V2TIMMessageExtension();
                        v2TIMMessageExtension.setMessageExtension(messageExtension);
                        arrayList.add(v2TIMMessageExtension);
                    }
                    v2TIMValueCallback.onSuccess(arrayList);
                }
            }
        };
        Message message = new Message();
        message.setMessageStatus(2);
        message.setSupportMessageExtension(true);
        message.addElement(new TextElement());
        message.setMessageType(2);
        message.setGroupID(str2);
        message.setSeq(j);
        MessageCenter.getInstance().getMessageExtensions(message, new IMCallback<List<MessageExtension>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.7
            public void fail(int i, String str3) {
                super.fail(i, str3);
            }

            public void success(List<MessageExtension> list) {
                super.success(list);
            }
        });
    }

    private void getMessageRevoker(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof List)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not list");
            return;
        }
        List<String> list = (List) obj;
        Iterator<String> it = list.iterator();
        if (it.hasNext() && !(it.next() instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "item is no String type");
        } else {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.12
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list2) {
                    int size = list2.size();
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (size == 0) {
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onError(6017, "local messages do not exist");
                        }
                    } else if (v2TIMValueCallback2 != null) {
                        HashMap hashMap = new HashMap();
                        for (Message message : list2) {
                            hashMap.put(message.getMsgID(), message.getRevokerInfo().getUserID());
                        }
                        v2TIMValueCallback.onSuccess(hashMap);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.13
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(List<Message> list2) {
                    super.success(list2);
                }
            });
        }
    }

    private void getMessageSource(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof V2TIMMessage)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not int");
        } else {
            Message message = ((V2TIMMessage) obj).getMessage();
            callbackOnSuccess(v2TIMValueCallback, new Integer(message != null ? message.getMessageSource() : 0));
        }
    }

    private void getOfflinePushState(V2TIMValueCallback<Object> v2TIMValueCallback) {
        OfflinePushManager.getInstance().getOfflinePushConfig(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.15
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                final int openOfflinePush = ((OfflinePushConfig) obj).getOpenOfflinePush();
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.15.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (((IMCallback) AnonymousClass15.this).valueCallback != null) {
                            ((IMCallback) AnonymousClass15.this).valueCallback.onSuccess(Integer.valueOf(openOfflinePush));
                        }
                    }
                });
            }
        });
    }

    private void getVideoEditSignature(V2TIMValueCallback<Object> v2TIMValueCallback) {
        BaseManager.getInstance().getVideoEditSignature(new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.11
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    private void initLocalStorage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "invalid userID");
        } else {
            BaseManager.getInstance().initLocalStorage(str, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.19
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void isCommercialAbilityEnabled(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof Long)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not int");
        } else {
            BaseManager.getInstance().isCommercialAbilityEnabled(((Long) obj).longValue(), new IMCallback<Object>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.16
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void pushLogin(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            BaseManager.getInstance().login(jSONObject.optString("userID"), jSONObject.optString("appKey"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.26
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            }, 2);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void reportOfflinePushEvent(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("eventList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    OfflinePushEventItem offlinePushEventItem = new OfflinePushEventItem();
                    offlinePushEventItem.setEventType(jSONObject.optInt("type"));
                    offlinePushEventItem.setEventTime(jSONObject.getLong(DeepLinkPresetEvent.UMEventParamTime));
                    offlinePushEventItem.setPushId(jSONObject.optString("pushId"));
                    arrayList.add(offlinePushEventItem);
                }
            }
            OfflinePushManager.getInstance().reportOfflinePushEvent(arrayList, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.25
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void reportPushSDKEvent(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            BaseManager.getInstance().reportPushSDKEvent(jSONObject.optLong("event_id"), jSONObject.optLong("event_code"), jSONObject.optLong("event_result"), jSONObject.optString("event_message"), jSONObject.optString("more_message"), jSONObject.optString("extension_message"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.27
                public void fail(int i, String str2) {
                    super.fail(i, str2);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void reportTUIComponentUsage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            BaseManager.getInstance().reportTUIComponentUsage(jSONObject.optLong("UIComponentType"), jSONObject.optLong("UIStyleType"));
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void sendTRTCCustomData(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof byte[])) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not byte array");
        } else {
            BaseManager.getInstance().sendTRTCCustomData((byte[]) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.9
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void setApplicationID(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Integer)) {
            BaseManager.getInstance().setApplicationID(((Integer) obj).intValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setBuildInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("buildBrand");
            String optString2 = jSONObject.optString("buildManufacturer");
            String optString3 = jSONObject.optString("buildModel");
            String optString4 = jSONObject.optString("buildVersionRelease");
            int optInt = jSONObject.optInt("buildVersionSDKInt");
            SystemUtil.setBuildBrand(optString);
            SystemUtil.setBuildManufacturer(optString2);
            SystemUtil.setBuildModel(optString3);
            SystemUtil.setBuildVersionRelease(optString4);
            SystemUtil.setBuildVersionSDKInt(optInt);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setConversationGroupOrderData(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
        } else {
            ConversationManager.getInstance().setConversationGroupOrderData((String) obj, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.1
                public void fail(int i, String str) {
                    super.fail(i, str);
                }

                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void setCosSaveRegion(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("conversationID");
            String optString2 = jSONObject.optString("cosSaveRegion");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                ConversationManager.getInstance().setCosSaveRegionForConversation(V2TIMConversationManagerImpl.getInstance().getConversationKey(optString), optString2, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.17
                    public void fail(int i, String str2) {
                        super.fail(i, str2);
                    }

                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                });
                return;
            }
            callbackOnError(v2TIMValueCallback, 6017, "invalid param");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setCustomLoginInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("userID") && jSONObject.has("customLoginInfo")) {
                BaseManager.getInstance().setCustomLoginInfo(jSONObject.optString("userID"), jSONObject.optString("customLoginInfo"), new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.28
                    public void fail(int i, String str2) {
                        super.fail(i, str2);
                    }

                    public void success(Object obj2) {
                        super.success(obj2);
                    }
                });
                return;
            }
            callbackOnError(v2TIMValueCallback, 6017, "invalid param");
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setCustomServerInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        CustomServerInfo customServerInfo = new CustomServerInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("longconnectionAddressList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    CustomServerInfo.ServerAddress serverAddress = new CustomServerInfo.ServerAddress();
                    serverAddress.ip = jSONObject2.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
                    serverAddress.port = jSONObject2.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
                    serverAddress.isIPv6 = jSONObject2.has("isIPv6") ? jSONObject2.optBoolean("isIPv6") : false;
                    serverAddress.isQuic = jSONObject2.has("isQuic") ? jSONObject2.optBoolean("isQuic") : false;
                    arrayList.add(serverAddress);
                }
                customServerInfo.longconnectionAddressList = arrayList;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("shortconnectionAddressList");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                    CustomServerInfo.ServerAddress serverAddress2 = new CustomServerInfo.ServerAddress();
                    serverAddress2.ip = jSONObject3.optString(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP);
                    serverAddress2.port = jSONObject3.optInt(IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
                    serverAddress2.isIPv6 = jSONObject3.has("isIPv6") ? jSONObject3.optBoolean("isIPv6") : false;
                    arrayList2.add(serverAddress2);
                }
                customServerInfo.shortconnectionAddressList = arrayList2;
            }
            customServerInfo.serverPublicKey = jSONObject.optString("serverPublicKey");
            BaseManager.getInstance().setCustomServerInfo(customServerInfo);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setDatabaseEncryptInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("encryptType")) {
                callbackOnError(v2TIMValueCallback, 6017, "encryptType must be set");
                return;
            }
            SDKConfig.DatabaseEncryptInfo databaseEncryptInfo = new SDKConfig.DatabaseEncryptInfo();
            databaseEncryptInfo.encryptType = jSONObject.optInt("encryptType");
            if (jSONObject.has("encryptKey")) {
                databaseEncryptInfo.encryptKey = jSONObject.optString("encryptKey");
            }
            BaseManager.getInstance().setDatabaseEncryptInfo(databaseEncryptInfo);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setIPv6Prior(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setIPv6Prior(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setLibraryPath(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        if (BaseManager.getInstance().setLibraryPath((String) obj)) {
            callbackOnSuccess(v2TIMValueCallback, null);
        } else {
            callbackOnError(v2TIMValueCallback, 6017, "system load so library failed");
        }
    }

    private void setMessageExtensionsBySequence(Object obj, final V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        String str2 = "";
        ArrayList arrayList = new ArrayList();
        long j = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            str2 = jSONObject.optString("groupID");
            j = jSONObject.optLong("messageSequence");
            JSONArray optJSONArray = jSONObject.optJSONArray("messageExtensionList");
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                MessageExtension messageExtension = new MessageExtension();
                messageExtension.setExtensionKey(jSONObject2.optString("extensionKey"));
                messageExtension.setExtensionValue(jSONObject2.optString("extensionValue"));
                arrayList.add(messageExtension);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        V2TIMValueCallback<List<MessageExtensionResult>> v2TIMValueCallback2 = new V2TIMValueCallback<List<MessageExtensionResult>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.4
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i2, String str3) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i2, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<MessageExtensionResult> list) {
                if (v2TIMValueCallback != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (MessageExtensionResult messageExtensionResult : list) {
                        V2TIMMessageExtensionResult v2TIMMessageExtensionResult = new V2TIMMessageExtensionResult();
                        v2TIMMessageExtensionResult.setMessageExtensionResult(messageExtensionResult);
                        arrayList2.add(v2TIMMessageExtensionResult);
                    }
                    v2TIMValueCallback.onSuccess(arrayList2);
                }
            }
        };
        Message message = new Message();
        message.setMessageStatus(2);
        message.setSupportMessageExtension(true);
        message.addElement(new TextElement());
        message.setMessageType(2);
        message.setGroupID(str2);
        message.setSeq(j);
        MessageCenter.getInstance().setMessageExtensions(message, arrayList, new IMCallback<List<MessageExtensionResult>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.5
            public void fail(int i2, String str3) {
                super.fail(i2, str3);
            }

            public void success(List<MessageExtensionResult> list) {
                super.success(list);
            }
        });
    }

    private void setOfflinePushInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("notification_bar_state");
            String optString = jSONObject.optString("tim_push_plugin_version");
            String optString2 = jSONObject.optString("system_language");
            if (optInt < 0 || optInt > 2) {
                optInt = 0;
            }
            OfflinePushManager.getInstance().setOfflinePushInfo(optString, optInt, optString2);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setOfflinePushState(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof Integer)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not int");
            return;
        }
        OfflinePushConfig offlinePushConfig = new OfflinePushConfig();
        offlinePushConfig.setOpenOfflinePush(((Integer) obj).intValue());
        OfflinePushManager.getInstance().setOfflinePushConfig(offlinePushConfig, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerExperimentImpl.14
            public void fail(int i, String str) {
                super.fail(i, str);
            }

            public void success(Object obj2) {
                super.success(obj2);
            }
        });
    }

    private void setPacketRetryInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            SDKConfig.PacketRetryInfo packetRetryInfo = new SDKConfig.PacketRetryInfo();
            if (jSONObject.has("maxRetryCount")) {
                packetRetryInfo.maxRetryCount = jSONObject.optInt("maxRetryCount");
            }
            if (jSONObject.has("packetRequestTimeout")) {
                packetRetryInfo.packetRequestTimeout = jSONObject.optInt("packetRequestTimeout");
            }
            BaseManager.getInstance().setPacketRetryInfo(packetRetryInfo);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setProxyInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("proxyType")) {
                callbackOnError(v2TIMValueCallback, 6017, "proxyType must be set");
                return;
            }
            if ((jSONObject.has("proxyHost") && !jSONObject.has("proxyPort")) || (!jSONObject.has("proxyHost") && jSONObject.has("proxyPort"))) {
                callbackOnError(v2TIMValueCallback, 6017, "proxyHost and proxyPort must be set together if need");
                return;
            }
            SDKConfig.ProxyInfo proxyInfo = new SDKConfig.ProxyInfo();
            proxyInfo.proxyType = jSONObject.optInt("proxyType");
            if (jSONObject.has("proxyHost") && jSONObject.has("proxyPort")) {
                proxyInfo.proxyHost = jSONObject.optString("proxyHost");
                proxyInfo.proxyPort = jSONObject.optInt("proxyPort");
            }
            if (jSONObject.has("proxyUsername")) {
                proxyInfo.proxyUsername = jSONObject.optString("proxyUsername");
            }
            if (jSONObject.has("proxyPassword")) {
                proxyInfo.proxyPassword = jSONObject.optString("proxyPassword");
            }
            BaseManager.getInstance().setProxyInfo(proxyInfo);
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setQuicChannelEnabled(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            BaseManager.getInstance().setQuicEnabled(new JSONObject(str).optBoolean("enableQuic"));
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    private void setTestEnvironment(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setTestEnvironment(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void setUIPlatform(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        String str;
        if (obj == null) {
            callbackOnError(v2TIMValueCallback, 6017, "param is null");
            return;
        }
        int i = 0;
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            if (obj instanceof Integer) {
                i = ((Integer) obj).intValue();
            } else {
                callbackOnError(v2TIMValueCallback, 6017, "param is invalid");
            }
            str = "";
        }
        BaseManager.getInstance().setCustomUIPlatform(str, i);
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    private void writeLog(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj == null || !(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("logLevel");
            String optString = jSONObject.optString("logContent");
            String optString2 = jSONObject.optString("fileName");
            if (optInt == 2) {
                IMLog.v(optString2, optString);
            } else if (optInt == 3) {
                IMLog.d(optString2, optString);
            } else if (optInt == 4) {
                IMLog.i(optString2, optString);
            } else if (optInt == 5) {
                IMLog.w(optString2, optString);
            } else {
                if (optInt != 6) {
                    callbackOnError(v2TIMValueCallback, 6017, "invalid logLevel");
                    return;
                }
                IMLog.e(optString2, optString);
            }
            callbackOnSuccess(v2TIMValueCallback, null);
        } catch (JSONException e) {
            callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
            e.printStackTrace();
        }
    }

    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "invalid api");
            return;
        }
        if (str.equals("setCustomServerInfo")) {
            setCustomServerInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("enableQuicChannel")) {
            setQuicChannelEnabled(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setProxyInfo")) {
            setProxyInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setLibraryPath")) {
            setLibraryPath(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("downloadLibrary")) {
            downloadLibrary(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("initLocalStorage")) {
            initLocalStorage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setTestEnvironment")) {
            setTestEnvironment(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setIPv6Prior")) {
            setIPv6Prior(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setCosSaveRegionForConversation")) {
            setCosSaveRegion(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setUIPlatform")) {
            setUIPlatform(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setBuildInfo")) {
            setBuildInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setDatabaseEncryptInfo")) {
            setDatabaseEncryptInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("isCommercialAbilityEnabled")) {
            isCommercialAbilityEnabled(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setPacketRetryInfo")) {
            setPacketRetryInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setOfflinePushState")) {
            setOfflinePushState(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getOfflinePushState")) {
            getOfflinePushState(v2TIMValueCallback);
            return;
        }
        if (str.equals("getMessageRevoker")) {
            getMessageRevoker(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("writeLog")) {
            writeLog(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getAIDenoiseSignature")) {
            getAIDenoiseSignature(v2TIMValueCallback);
            return;
        }
        if (str.equals("getVideoEditSignature")) {
            getVideoEditSignature(v2TIMValueCallback);
            return;
        }
        if (str.equals("sendTRTCCustomData")) {
            sendTRTCCustomData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setMessageExtensionsBySequence")) {
            setMessageExtensionsBySequence(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getMessageExtensionsBySequence")) {
            getMessageExtensionsBySequence(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("clearLocalHistoryMessage")) {
            clearLocalHistoryMessage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("reportTUIComponentUsage")) {
            reportTUIComponentUsage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setConversationGroupOrderData")) {
            setConversationGroupOrderData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getConversationGroupOrderData")) {
            getConversationGroupOrderData(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("reportOfflinePushEvent")) {
            reportOfflinePushEvent(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setOfflinePushInfo")) {
            setOfflinePushInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setApplicationID")) {
            setApplicationID(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("findMergerMessages")) {
            findMergerMessages(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getBriefGroupMemberList")) {
            getBriefGroupMemberList(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("pushLogin")) {
            pushLogin(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("reportPushSDKEvent")) {
            reportPushSDKEvent(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setCustomLoginInfo")) {
            setCustomLoginInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("disableHttpRequest")) {
            disableHttpRequest(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getLoginAccountType")) {
            getLoginAccountType(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("cancelSendingMessage")) {
            cancelSendingMessage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("getMessageSource")) {
            getMessageSource(obj, v2TIMValueCallback);
        } else if (str.equals("getGroupMessageReceipts")) {
            getGroupMessageReceipts(obj, v2TIMValueCallback);
        } else {
            callbackOnError(v2TIMValueCallback, 6017, "unsupported api");
        }
    }
}
