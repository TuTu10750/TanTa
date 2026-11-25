package defpackage;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMConversation;
import com.tencent.imsdk.v2.V2TIMConversationResult;
import com.tencent.imsdk.v2.V2TIMDownloadCallback;
import com.tencent.imsdk.v2.V2TIMElem;
import com.tencent.imsdk.v2.V2TIMImageElem;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.imsdk.v2.V2TIMSoundElem;
import com.tencent.imsdk.v2.V2TIMTextElem;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.dao.IMMessageBean;
import com.yunbao.im.dao.IMUserBean;
import com.zzhoujay.richtext.ImageHolder;
import defpackage.ck1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class m94 implements hj1 {
    public SimpleDateFormat a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;
    public boolean i;
    public V2TIMValueCallback m;
    public int h = -1;
    public boolean j = false;
    public final ik1 k = new ik1();
    public List l = Arrays.asList("c2c_goodsorder_admin", "c2c_dsp_fans", "c2c_dsp_like", "c2c_dsp_at", "c2c_dsp_comment");

    /* loaded from: /tmp/classes2.dex */
    public class a implements V2TIMValueCallback {
        public final /* synthetic */ List a;
        public final /* synthetic */ k30 b;

        public a(List list, k30 k30Var) {
            this.a = list;
            this.b = k30Var;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(V2TIMConversationResult v2TIMConversationResult) {
            List<V2TIMConversation> conversationList = v2TIMConversationResult.getConversationList();
            if (conversationList != null) {
                lx1.c("9527IM", "获取会话列表成功---->" + conversationList.size());
                for (V2TIMConversation v2TIMConversation : conversationList) {
                    if (v2TIMConversation != null) {
                        String userID = v2TIMConversation.getUserID();
                        if (!"dsp_fans".equals(userID) && !"dsp_like".equals(userID) && !"dsp_at".equals(userID) && !"dsp_comment".equals(userID)) {
                            IMUserBean a = IMUserBean.INSTANCE.a();
                            a.setConversationID(v2TIMConversation.getConversationID());
                            a.setUserID(userID);
                            a.setGroupID(v2TIMConversation.getGroupID());
                            a.setGroup(v2TIMConversation.getType() == 2);
                            a.setUnReadCount(v2TIMConversation.getUnreadCount());
                            V2TIMMessage lastMessage = v2TIMConversation.getLastMessage();
                            if (lastMessage != null) {
                                a.setLastMsgId(lastMessage.getMsgID());
                                a.setLastMsgString(m94.this.B(lastMessage));
                                a.setLastMsgTime(lastMessage.getTimestamp());
                                a.setLastMsgTimeString(m94.this.C(lastMessage.getTimestamp()));
                            }
                            this.a.add(a);
                        }
                    }
                }
            }
            k30 k30Var = this.b;
            if (k30Var != null) {
                k30Var.a(this.a);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "获取会话列表失败--code-->" + i + "---desc-->" + str);
            k30 k30Var = this.b;
            if (k30Var != null) {
                k30Var.a(this.a);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements V2TIMSendCallback {
        public final /* synthetic */ ck1.a a;
        public final /* synthetic */ IMMessageBean b;

        public b(ck1.a aVar, IMMessageBean iMMessageBean) {
            this.a = aVar;
            this.b = iMMessageBean;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(V2TIMMessage v2TIMMessage) {
            this.b.setMsgId(v2TIMMessage.getMsgID());
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, true);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, false);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int i) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.a(this.b, i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements V2TIMSendCallback {
        public final /* synthetic */ ck1.a a;
        public final /* synthetic */ IMMessageBean b;

        public c(ck1.a aVar, IMMessageBean iMMessageBean) {
            this.a = aVar;
            this.b = iMMessageBean;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(V2TIMMessage v2TIMMessage) {
            List<V2TIMImageElem.V2TIMImage> imageList;
            this.b.setMsgId(v2TIMMessage.getMsgID());
            V2TIMImageElem imageElem = v2TIMMessage.getImageElem();
            if (imageElem != null && (imageList = imageElem.getImageList()) != null) {
                for (V2TIMImageElem.V2TIMImage v2TIMImage : imageList) {
                    if (v2TIMImage.getType() == 0) {
                        this.b.setOriginImageUrl(v2TIMImage.getUrl());
                        this.b.setWidth(v2TIMImage.getWidth());
                        this.b.setHeight(v2TIMImage.getHeight());
                    } else if (v2TIMImage.getType() == 1) {
                        this.b.setThumbImageUrl(v2TIMImage.getUrl());
                        this.b.setWidth(v2TIMImage.getWidth());
                        this.b.setHeight(v2TIMImage.getHeight());
                    }
                }
            }
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, true);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, false);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int i) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.a(this.b, i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements V2TIMSendCallback {
        public final /* synthetic */ ck1.a a;
        public final /* synthetic */ IMMessageBean b;

        public d(ck1.a aVar, IMMessageBean iMMessageBean) {
            this.a = aVar;
            this.b = iMMessageBean;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(V2TIMMessage v2TIMMessage) {
            this.b.setMsgId(v2TIMMessage.getMsgID());
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, true);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.c(this.b, false);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int i) {
            ck1.a aVar = this.a;
            if (aVar != null) {
                aVar.a(this.b, i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements V2TIMValueCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ k30 b;

        public e(String str, k30 k30Var) {
            this.a = str;
            this.b = k30Var;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            lx1.c("9527IM", "拉取单聊历史消息成功------>");
            ArrayList arrayList = new ArrayList();
            for (int size = list.size() - 1; size >= 0; size--) {
                IMMessageBean A = m94.this.A((V2TIMMessage) list.get(size), this.a);
                if (A != null) {
                    arrayList.add(A);
                }
            }
            k30 k30Var = this.b;
            if (k30Var != null) {
                k30Var.a(arrayList);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "拉取单聊历史消息失败---code-->" + i + "---desc--->" + str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements V2TIMValueCallback {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ k30 b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements V2TIMDownloadCallback {
            public final /* synthetic */ File a;

            public a(File file) {
                this.a = file;
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
            public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                k30 k30Var = f.this.b;
                if (k30Var != null) {
                    k30Var.a(this.a);
                }
            }
        }

        public f(boolean z, k30 k30Var) {
            this.a = z;
            this.b = k30Var;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            V2TIMImageElem imageElem;
            V2TIMImageElem.V2TIMImage v2TIMImage;
            if (list == null || list.size() == 0 || (imageElem = ((V2TIMMessage) list.get(0)).getImageElem()) == null) {
                return;
            }
            Iterator<V2TIMImageElem.V2TIMImage> it = imageElem.getImageList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    v2TIMImage = null;
                    break;
                }
                v2TIMImage = it.next();
                if (this.a) {
                    if (v2TIMImage.getType() == 1) {
                        break;
                    }
                } else if (v2TIMImage.getType() == 0) {
                    break;
                }
            }
            if (v2TIMImage == null) {
                return;
            }
            File file = new File(j30.S);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, v2TIMImage.getUUID());
            if (!file2.exists()) {
                v2TIMImage.downloadImage(file2.getAbsolutePath(), new a(file2));
                return;
            }
            k30 k30Var = this.b;
            if (k30Var != null) {
                k30Var.a(file2);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements V2TIMValueCallback {
        public final /* synthetic */ File a;
        public final /* synthetic */ k30 b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements V2TIMDownloadCallback {
            public a() {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                lx1.c("9527IM", "下载声音文件失败-----code--->" + i + "--desc---->" + str);
            }

            @Override // com.tencent.imsdk.v2.V2TIMDownloadCallback
            public void onProgress(V2TIMElem.V2ProgressInfo v2ProgressInfo) {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                g gVar = g.this;
                k30 k30Var = gVar.b;
                if (k30Var != null) {
                    k30Var.a(gVar.a);
                }
            }
        }

        public g(File file, k30 k30Var) {
            this.a = file;
            this.b = k30Var;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            if (list == null || list.size() == 0) {
                return;
            }
            ((V2TIMMessage) list.get(0)).getSoundElem().downloadSound(this.a.getAbsolutePath(), new a());
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements V2TIMCallback {
        public final /* synthetic */ String a;

        public h(String str) {
            this.a = str;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", this.a + "_会话标记已读失败---code-->" + i + "----desc--->" + str);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            lx1.c("9527IM", this.a + "_会话标记已读成功----->");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements V2TIMCallback {
        public i() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "全部会话标记已读失败---code-->" + i + "----desc--->" + str);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            lx1.c("9527IM", "全部会话标记已读成功----->");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements V2TIMSendCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ List b;
        public final /* synthetic */ V2TIMMessage c;
        public final /* synthetic */ Runnable d;

        public j(String str, List list, V2TIMMessage v2TIMMessage, Runnable runnable) {
            this.a = str;
            this.b = list;
            this.c = v2TIMMessage;
            this.d = runnable;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(V2TIMMessage v2TIMMessage) {
            lx1.c("9527IM", "sendCustomMessage----结束ok----> " + this.a);
            m94.y(m94.this);
            if (m94.this.g < this.b.size()) {
                m94.this.D(this.b, this.c, this.d);
                return;
            }
            lx1.c("9527IM", "sendCustomMessage----全部完成----> ");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "sendCustomMessage----结束error----> " + this.a + "----code---->" + i + "----desc-->" + str);
            m94.y(m94.this);
            if (m94.this.g < this.b.size()) {
                m94.this.D(this.b, this.c, this.d);
                return;
            }
            lx1.c("9527IM", "sendCustomMessage----全部完成----> ");
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMSendCallback
        public void onProgress(int i) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k implements V2TIMCallback {
        public k() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "删除会话失败---code-->" + i + "----desc-->" + str);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            lx1.c("9527IM", "删除会话成功-----> ");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l implements V2TIMValueCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        /* loaded from: /tmp/classes2.dex */
        public class a implements V2TIMCallback {
            public a() {
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onError(int i, String str) {
                lx1.c("9527IM", "撤回消息失败----code--> " + i + " ----desc--> " + str);
                if (i == 20016 || i == 10031) {
                    t54.a(m93.m1);
                } else {
                    t54.a(m93.n1);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMCallback
            public void onSuccess() {
                lx1.c("9527IM", "撤回消息成功----->");
                zu0 c = zu0.c();
                l lVar = l.this;
                c.j(new bk1(lVar.a, lVar.b, true));
            }
        }

        public l(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            if (list == null || list.size() == 0) {
                return;
            }
            V2TIMManager.getMessageManager().revokeMessage((V2TIMMessage) list.get(0), new a());
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m implements V2TIMCallback {
        public m() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "登录失败---code-->" + i + "---desc-->" + str);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            lx1.c("9527IM", "登录成功----->");
            m94.this.h();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n implements V2TIMCallback {
        public n() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "登出失败---code-->" + i + "---desc-->" + str);
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            lx1.c("9527IM", "登出成功----->");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o implements V2TIMValueCallback {
        public o() {
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Long l) {
            lx1.c("9527IM", "主动获取未读消息数成功----->" + l);
            m94.this.E(l.longValue());
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            lx1.c("9527IM", "主动获取未读消息数失败---code-->" + i + "---desc-->" + str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class p implements V2TIMValueCallback {
        public final /* synthetic */ long a;

        public p(long j) {
            this.a = j;
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(List list) {
            if (m94.this.k != null) {
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        V2TIMConversation v2TIMConversation = (V2TIMConversation) it.next();
                        if (v2TIMConversation != null) {
                            String userID = v2TIMConversation.getUserID();
                            if ("goodsorder_admin".equals(userID)) {
                                m94.this.k.m(v2TIMConversation.getUnreadCount());
                            } else if ("dsp_fans".equals(userID)) {
                                m94.this.k.l(v2TIMConversation.getUnreadCount());
                            } else if ("dsp_like".equals(userID)) {
                                m94.this.k.n(v2TIMConversation.getUnreadCount());
                            } else if ("dsp_at".equals(userID)) {
                                m94.this.k.j(v2TIMConversation.getUnreadCount());
                            } else if ("dsp_comment".equals(userID)) {
                                m94.this.k.k(v2TIMConversation.getUnreadCount());
                            }
                        }
                    }
                }
                zu0.c().j(new kk1((int) this.a));
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMValueCallback
        public void onError(int i, String str) {
            if (m94.this.k != null) {
                zu0.c().j(new kk1((int) this.a));
            }
        }
    }

    public m94() {
        j();
    }

    public static /* synthetic */ int y(m94 m94Var) {
        int i2 = m94Var.g;
        m94Var.g = i2 + 1;
        return i2;
    }

    public final IMMessageBean A(V2TIMMessage v2TIMMessage, String str) {
        List<V2TIMImageElem.V2TIMImage> imageList;
        IMMessageBean iMMessageBean = null;
        if (v2TIMMessage == null) {
            return null;
        }
        int status = v2TIMMessage.getStatus();
        int i2 = status != 1 ? status != 3 ? 2 : 3 : 1;
        int elemType = v2TIMMessage.getElemType();
        if (elemType == 1) {
            iMMessageBean = IMMessageBean.INSTANCE.a(v2TIMMessage.getMsgID(), str, v2TIMMessage.getSender(), v2TIMMessage.getGroupID(), v2TIMMessage.getTimestamp(), v2TIMMessage.isSelf(), 1, i2);
            iMMessageBean.setText(v2TIMMessage.getTextElem().getText());
        } else if (elemType == 3) {
            iMMessageBean = IMMessageBean.INSTANCE.a(v2TIMMessage.getMsgID(), str, v2TIMMessage.getSender(), v2TIMMessage.getGroupID(), v2TIMMessage.getTimestamp(), v2TIMMessage.isSelf(), 2, i2);
            V2TIMImageElem imageElem = v2TIMMessage.getImageElem();
            if (imageElem != null && (imageList = imageElem.getImageList()) != null) {
                for (V2TIMImageElem.V2TIMImage v2TIMImage : imageList) {
                    if (v2TIMImage.getType() == 0) {
                        iMMessageBean.setOriginImageUrl(v2TIMImage.getUrl());
                        iMMessageBean.setWidth(v2TIMImage.getWidth());
                        iMMessageBean.setHeight(v2TIMImage.getHeight());
                    } else if (v2TIMImage.getType() == 1) {
                        iMMessageBean.setThumbImageUrl(v2TIMImage.getUrl());
                        iMMessageBean.setWidth(v2TIMImage.getWidth());
                        iMMessageBean.setHeight(v2TIMImage.getHeight());
                    }
                }
            }
        } else if (elemType == 4) {
            iMMessageBean = IMMessageBean.INSTANCE.a(v2TIMMessage.getMsgID(), str, v2TIMMessage.getSender(), v2TIMMessage.getGroupID(), v2TIMMessage.getTimestamp(), v2TIMMessage.isSelf(), 3, i2);
            V2TIMSoundElem soundElem = v2TIMMessage.getSoundElem();
            if (soundElem != null) {
                iMMessageBean.setDuration(soundElem.getDuration());
            }
        }
        if (iMMessageBean != null) {
            iMMessageBean.setRevoked(v2TIMMessage.getStatus() == 6);
        }
        return iMMessageBean;
    }

    public final String B(V2TIMMessage v2TIMMessage) {
        String str = "";
        if (v2TIMMessage == null) {
            return "";
        }
        if (v2TIMMessage.getStatus() == 6) {
            return v2TIMMessage.isSelf() ? aq4.a(m93.k1) : aq4.a(m93.l1);
        }
        int elemType = v2TIMMessage.getElemType();
        if (elemType == 2) {
            String str2 = new String(v2TIMMessage.getCustomElem().getData());
            if (!TextUtils.isEmpty(str2)) {
                try {
                    JSONObject parseObject = JSON.parseObject(str2);
                    String string = parseObject.getString("method");
                    if ("GoodsMsg".equals(string)) {
                        str = this.e;
                    } else if ("order".equals(string)) {
                        str = rx1.h() ? parseObject.getString("zh-cn") : parseObject.getString("en");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return str;
        }
        if (elemType == 1) {
            V2TIMTextElem textElem = v2TIMMessage.getTextElem();
            if (textElem != null) {
                String text = textElem.getText();
                return !rx1.h() ? iz0.d(text, this.f) : text;
            }
        } else {
            if (elemType == 3) {
                return this.b;
            }
            if (elemType == 4) {
                return this.c;
            }
            if (elemType == 7) {
                return this.d;
            }
        }
        return "";
    }

    public final String C(long j2) {
        if (this.a == null) {
            this.a = new SimpleDateFormat("MM-dd HH:mm");
        }
        return this.a.format(new Date(j2 * 1000));
    }

    public final void D(List list, V2TIMMessage v2TIMMessage, Runnable runnable) {
        String str = (String) list.get(this.g);
        lx1.c("9527IM", "sendCustomMessage----开始----> " + str);
        V2TIMManager.getMessageManager().sendMessage(v2TIMMessage, str, null, 2, false, null, new j(str, list, v2TIMMessage, runnable));
    }

    public final void E(long j2) {
        lx1.c("腾讯IM", "未读消息总数----->" + j2);
        ik1 ik1Var = this.k;
        if (ik1Var != null) {
            ik1Var.o((int) j2);
        }
        if (this.m == null) {
            this.m = new p(j2);
        }
        V2TIMManager.getConversationManager().getConversationList(this.l, this.m);
    }

    @Override // defpackage.hj1
    public void a(k30 k30Var) {
        V2TIMManager.getConversationManager().getConversationList(0L, ImageHolder.MATCH_PARENT, new a(new ArrayList(), k30Var));
    }

    @Override // defpackage.hj1
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        V2TIMManager.getMessageManager().markC2CMessageAsRead(str, new h(str));
    }

    @Override // defpackage.hj1
    public void c(List list, String str, Runnable runnable) {
        if (list == null || list.size() == 0 || TextUtils.isEmpty(str)) {
            return;
        }
        V2TIMMessage createCustomMessage = V2TIMManager.getMessageManager().createCustomMessage(str.getBytes());
        this.g = 0;
        D(list, createCustomMessage, runnable);
    }

    @Override // defpackage.hj1
    public void d(String str, String str2, ck1.a aVar) {
        V2TIMMessage createTextMessage = V2TIMManager.getMessageManager().createTextMessage(str);
        IMMessageBean a2 = IMMessageBean.INSTANCE.a(createTextMessage.getMsgID(), str2, createTextMessage.getSender(), createTextMessage.getGroupID(), createTextMessage.getTimestamp(), createTextMessage.isSelf(), 1, 1);
        a2.setText(str);
        if (aVar != null) {
            aVar.b(a2);
        }
        V2TIMManager.getMessageManager().sendMessage(createTextMessage, str2, null, 2, false, null, new b(aVar, a2));
    }

    @Override // defpackage.hj1
    public ik1 e() {
        return this.k;
    }

    @Override // defpackage.hj1
    public void f() {
        ik1 ik1Var = this.k;
        if (ik1Var != null) {
            ik1Var.a();
        }
        zu0.c().j(new kk1());
        V2TIMManager.getInstance().logout(new n());
    }

    @Override // defpackage.hj1
    public void g(String str) {
        V2TIMManager.getConversationManager().deleteConversation("c2c_" + str, new k());
    }

    @Override // defpackage.hj1
    public void h() {
        V2TIMManager.getConversationManager().getTotalUnreadMessageCount(new o());
    }

    @Override // defpackage.hj1
    public void i(ImMessageBean imMessageBean, boolean z, k30 k30Var) {
        ImMessageBean.ImageMsgBean imageBean = imMessageBean.getImageBean();
        if (imageBean == null) {
            return;
        }
        if (imageBean.isSelf()) {
            String localPath = imageBean.getLocalPath();
            if (!TextUtils.isEmpty(localPath)) {
                File file = new File(localPath);
                if (file.exists()) {
                    if (k30Var != null) {
                        k30Var.a(file);
                        return;
                    }
                    return;
                }
            }
        }
        V2TIMManager.getMessageManager().findMessages(Collections.singletonList(imMessageBean.getMsgId()), new f(z, k30Var));
    }

    @Override // defpackage.hj1
    public void j() {
        this.b = aq4.a(m93.I2);
        this.c = aq4.a(m93.K2);
        this.d = aq4.a(m93.J2);
        this.e = aq4.a(m93.H2);
        this.f = aq4.a(m93.G2);
    }

    @Override // defpackage.hj1
    public void k(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        V2TIMManager.getMessageManager().findMessages(Collections.singletonList(str2), new l(str, str2));
    }

    @Override // defpackage.hj1
    public void l(String str, k30 k30Var) {
        V2TIMManager.getMessageManager().getC2CHistoryMessageList(str, 20, null, new e(str, k30Var));
    }

    @Override // defpackage.hj1
    public void m(String str, String str2, ck1.a aVar) {
        V2TIMMessage createImageMessage = V2TIMManager.getMessageManager().createImageMessage(str);
        IMMessageBean a2 = IMMessageBean.INSTANCE.a(createImageMessage.getMsgID(), str2, createImageMessage.getSender(), createImageMessage.getGroupID(), createImageMessage.getTimestamp(), createImageMessage.isSelf(), 2, 1);
        a2.setLocalPath(str);
        if (aVar != null) {
            aVar.b(a2);
        }
        V2TIMManager.getMessageManager().sendMessage(createImageMessage, str2, null, 2, false, null, new c(aVar, a2));
    }

    @Override // defpackage.hj1
    public void n(boolean z) {
        this.i = z;
    }

    @Override // defpackage.hj1
    public void o(String str, int i2, String str2, ck1.a aVar) {
        V2TIMMessage createSoundMessage = V2TIMManager.getMessageManager().createSoundMessage(str, i2);
        IMMessageBean a2 = IMMessageBean.INSTANCE.a(createSoundMessage.getMsgID(), str2, createSoundMessage.getSender(), createSoundMessage.getGroupID(), createSoundMessage.getTimestamp(), createSoundMessage.isSelf(), 3, 1);
        V2TIMSoundElem soundElem = createSoundMessage.getSoundElem();
        if (soundElem != null) {
            a2.setDuration(soundElem.getDuration());
        }
        if (aVar != null) {
            aVar.b(a2);
        }
        V2TIMManager.getMessageManager().sendMessage(createSoundMessage, str2, null, 2, false, null, new d(aVar, a2));
    }

    @Override // defpackage.hj1
    public void p(IMMessageBean iMMessageBean, k30 k30Var) {
        if (iMMessageBean.getDuration() == 0) {
            return;
        }
        File file = new File(j30.R, iMMessageBean.getMsgId());
        if (file.exists()) {
            if (k30Var != null) {
                k30Var.a(file);
            }
        } else {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            V2TIMManager.getMessageManager().findMessages(Collections.singletonList(iMMessageBean.getMsgId()), new g(file, k30Var));
        }
    }

    @Override // defpackage.hj1
    public void q() {
        V2TIMManager.getMessageManager().markAllMessageAsRead(new i());
    }

    @Override // defpackage.hj1
    public void r(String str) {
        int loginStatus = V2TIMManager.getInstance().getLoginStatus();
        if (loginStatus == 1) {
            lx1.c("9527IM", "已经登录了");
            h();
            return;
        }
        if (loginStatus == 2) {
            lx1.c("9527IM", "正在登录中");
            return;
        }
        String g2 = bs3.d().g("txImUserSign");
        if (TextUtils.isEmpty(g2)) {
            lx1.c("9527IM", "userSig不存在，无法登录");
            return;
        }
        lx1.c("9527IM", "开始登录--userSig-->" + g2);
        V2TIMManager.getInstance().login(j30.q().C(), j30.q().D().getUserSig(), new m());
    }
}
