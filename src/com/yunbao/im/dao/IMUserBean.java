package com.yunbao.im.dao;

import com.umeng.analytics.pro.bv;
import com.yunbao.common.bean.UserBean;
import com.yunbao.im.bean.ImConUserBean;
import com.yunbao.im.bean.ImConversationBean;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import defpackage.dq1;
import defpackage.h54;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bO\b\u0087\b\u0018\u0000 q2\u00020\u0001:\u0001rB\u009d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0015¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00020$2\u0006\u0010'\u001a\u00020\u001f¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0010\u0010,\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0010\u0010-\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b-\u0010+J\u0010\u0010.\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b0\u0010/J\u0010\u00101\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b1\u0010/J\u0010\u00102\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b2\u0010/J\u0010\u00103\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b5\u0010+J\u0010\u00106\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b6\u0010/J\u0010\u00107\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b7\u00104J\u0012\u00108\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b8\u0010+J\u0010\u00109\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b9\u0010+J\u0012\u0010:\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b:\u0010+J\u0010\u0010;\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b;\u0010+J\u0010\u0010<\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b<\u0010+J\u0010\u0010=\u001a\u00020\u0015HÆ\u0003¢\u0006\u0004\b=\u0010\u001bJ\u0012\u0010>\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b>\u0010+JÊ\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\bA\u0010+J\u0010\u0010B\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\bB\u0010/J\u001a\u0010D\u001a\u00020\u000b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bD\u0010ER\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010F\u001a\u0004\bG\u0010+\"\u0004\bH\u0010IR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010F\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010IR\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010F\u001a\u0004\bL\u0010+\"\u0004\bM\u0010IR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010N\u001a\u0004\bO\u0010/\"\u0004\bP\u0010QR\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010N\u001a\u0004\bR\u0010/\"\u0004\bS\u0010QR\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010N\u001a\u0004\bT\u0010/\"\u0004\bU\u0010QR\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010N\u001a\u0004\bV\u0010/\"\u0004\bW\u0010QR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010X\u001a\u0004\bY\u00104\"\u0004\bZ\u0010[R\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010F\u001a\u0004\b\\\u0010+\"\u0004\b]\u0010IR\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010N\u001a\u0004\b^\u0010/\"\u0004\b_\u0010QR\"\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010X\u001a\u0004\b\u000f\u00104\"\u0004\b`\u0010[R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010F\u001a\u0004\ba\u0010+\"\u0004\bb\u0010IR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010F\u001a\u0004\bc\u0010+\"\u0004\bd\u0010IR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010F\u001a\u0004\be\u0010+\"\u0004\bf\u0010IR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010F\u001a\u0004\bg\u0010+\"\u0004\bh\u0010IR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010F\u001a\u0004\bi\u0010+\"\u0004\bj\u0010IR\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010k\u001a\u0004\bl\u0010\u001b\"\u0004\bm\u0010nR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010F\u001a\u0004\bo\u0010+\"\u0004\bp\u0010I¨\u0006s"}, d2 = {"Lcom/yunbao/im/dao/IMUserBean;", "", "", "id", "userNiceName", "avatar", "", "sex", "level", "attent", "otherAttent", "", "anchorItem", "tips", "unReadCount", "isGroup", "conversationID", "userID", "groupID", "lastMsgId", "lastMsgString", "", "lastMsgTime", "lastMsgTimeString", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIZLjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "getLastMsgTimeFormat", "()J", "Lcom/yunbao/common/bean/UserBean;", "getUserBean", "()Lcom/yunbao/common/bean/UserBean;", "Lcom/yunbao/im/bean/ImConUserBean;", "getImConUserBean", "()Lcom/yunbao/im/bean/ImConUserBean;", "Lcom/yunbao/im/bean/ImConversationBean;", "conUserBean", "Lqc4;", "setConBean", "(Lcom/yunbao/im/bean/ImConversationBean;)V", "bean", "setImConUserBean", "(Lcom/yunbao/im/bean/ImConUserBean;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()I", "component5", "component6", "component7", "component8", "()Z", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIIZLjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Lcom/yunbao/im/dao/IMUserBean;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getUserNiceName", "setUserNiceName", "getAvatar", "setAvatar", "I", "getSex", "setSex", "(I)V", "getLevel", "setLevel", "getAttent", "setAttent", "getOtherAttent", "setOtherAttent", "Z", "getAnchorItem", "setAnchorItem", "(Z)V", "getTips", "setTips", "getUnReadCount", "setUnReadCount", "setGroup", "getConversationID", "setConversationID", "getUserID", "setUserID", "getGroupID", "setGroupID", "getLastMsgId", "setLastMsgId", "getLastMsgString", "setLastMsgString", "J", "getLastMsgTime", "setLastMsgTime", "(J)V", "getLastMsgTimeString", "setLastMsgTimeString", "Companion", bv.av, "im_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final /* data */ class IMUserBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean anchorItem;
    private int attent;
    private String avatar;
    private String conversationID;
    private String groupID;
    private String id;
    private boolean isGroup;
    private String lastMsgId;
    private String lastMsgString;
    private long lastMsgTime;
    private String lastMsgTimeString;
    private int level;
    private int otherAttent;
    private int sex;
    private String tips;
    private int unReadCount;
    private String userID;
    private String userNiceName;

    /* renamed from: com.yunbao.im.dao.IMUserBean$a, reason: from kotlin metadata */
    /* loaded from: /tmp/classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IMUserBean a() {
            return new IMUserBean("", "", "", 0, 0, 0, 0, false, "", 0, false, "", "", "", "", "", 0L, "");
        }
    }

    public IMUserBean(String str, String str2, String str3, int i, int i2, int i3, int i4, boolean z, String str4, int i5, boolean z2, String str5, String str6, String str7, String str8, String str9, long j, String str10) {
        str.getClass();
        str2.getClass();
        str3.getClass();
        str4.getClass();
        str6.getClass();
        str8.getClass();
        str9.getClass();
        this.id = str;
        this.userNiceName = str2;
        this.avatar = str3;
        this.sex = i;
        this.level = i2;
        this.attent = i3;
        this.otherAttent = i4;
        this.anchorItem = z;
        this.tips = str4;
        this.unReadCount = i5;
        this.isGroup = z2;
        this.conversationID = str5;
        this.userID = str6;
        this.groupID = str7;
        this.lastMsgId = str8;
        this.lastMsgString = str9;
        this.lastMsgTime = j;
        this.lastMsgTimeString = str10;
    }

    public static /* synthetic */ IMUserBean copy$default(IMUserBean iMUserBean, String str, String str2, String str3, int i, int i2, int i3, int i4, boolean z, String str4, int i5, boolean z2, String str5, String str6, String str7, String str8, String str9, long j, String str10, int i6, Object obj) {
        String str11;
        long j2;
        String str12 = (i6 & 1) != 0 ? iMUserBean.id : str;
        String str13 = (i6 & 2) != 0 ? iMUserBean.userNiceName : str2;
        String str14 = (i6 & 4) != 0 ? iMUserBean.avatar : str3;
        int i7 = (i6 & 8) != 0 ? iMUserBean.sex : i;
        int i8 = (i6 & 16) != 0 ? iMUserBean.level : i2;
        int i9 = (i6 & 32) != 0 ? iMUserBean.attent : i3;
        int i10 = (i6 & 64) != 0 ? iMUserBean.otherAttent : i4;
        boolean z3 = (i6 & 128) != 0 ? iMUserBean.anchorItem : z;
        String str15 = (i6 & 256) != 0 ? iMUserBean.tips : str4;
        int i11 = (i6 & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0 ? iMUserBean.unReadCount : i5;
        boolean z4 = (i6 & CacheIOHelper.BUFFER_SIZE) != 0 ? iMUserBean.isGroup : z2;
        String str16 = (i6 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? iMUserBean.conversationID : str5;
        String str17 = (i6 & 4096) != 0 ? iMUserBean.userID : str6;
        String str18 = (i6 & 8192) != 0 ? iMUserBean.groupID : str7;
        String str19 = str12;
        String str20 = (i6 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? iMUserBean.lastMsgId : str8;
        String str21 = (i6 & 32768) != 0 ? iMUserBean.lastMsgString : str9;
        String str22 = str20;
        long j3 = (i6 & 65536) != 0 ? iMUserBean.lastMsgTime : j;
        if ((i6 & 131072) != 0) {
            j2 = j3;
            str11 = iMUserBean.lastMsgTimeString;
        } else {
            str11 = str10;
            j2 = j3;
        }
        return iMUserBean.copy(str19, str13, str14, i7, i8, i9, i10, z3, str15, i11, z4, str16, str17, str18, str22, str21, j2, str11);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getUnReadCount() {
        return this.unReadCount;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsGroup() {
        return this.isGroup;
    }

    /* renamed from: component12, reason: from getter */
    public final String getConversationID() {
        return this.conversationID;
    }

    /* renamed from: component13, reason: from getter */
    public final String getUserID() {
        return this.userID;
    }

    /* renamed from: component14, reason: from getter */
    public final String getGroupID() {
        return this.groupID;
    }

    /* renamed from: component15, reason: from getter */
    public final String getLastMsgId() {
        return this.lastMsgId;
    }

    /* renamed from: component16, reason: from getter */
    public final String getLastMsgString() {
        return this.lastMsgString;
    }

    /* renamed from: component17, reason: from getter */
    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    /* renamed from: component18, reason: from getter */
    public final String getLastMsgTimeString() {
        return this.lastMsgTimeString;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserNiceName() {
        return this.userNiceName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSex() {
        return this.sex;
    }

    /* renamed from: component5, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* renamed from: component6, reason: from getter */
    public final int getAttent() {
        return this.attent;
    }

    /* renamed from: component7, reason: from getter */
    public final int getOtherAttent() {
        return this.otherAttent;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAnchorItem() {
        return this.anchorItem;
    }

    /* renamed from: component9, reason: from getter */
    public final String getTips() {
        return this.tips;
    }

    public final IMUserBean copy(String id, String userNiceName, String avatar, int sex, int level, int attent, int otherAttent, boolean anchorItem, String tips, int unReadCount, boolean isGroup, String conversationID, String userID, String groupID, String lastMsgId, String lastMsgString, long lastMsgTime, String lastMsgTimeString) {
        id.getClass();
        userNiceName.getClass();
        avatar.getClass();
        tips.getClass();
        userID.getClass();
        lastMsgId.getClass();
        lastMsgString.getClass();
        return new IMUserBean(id, userNiceName, avatar, sex, level, attent, otherAttent, anchorItem, tips, unReadCount, isGroup, conversationID, userID, groupID, lastMsgId, lastMsgString, lastMsgTime, lastMsgTimeString);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IMUserBean)) {
            return false;
        }
        IMUserBean iMUserBean = (IMUserBean) other;
        return dq1.a(this.id, iMUserBean.id) && dq1.a(this.userNiceName, iMUserBean.userNiceName) && dq1.a(this.avatar, iMUserBean.avatar) && this.sex == iMUserBean.sex && this.level == iMUserBean.level && this.attent == iMUserBean.attent && this.otherAttent == iMUserBean.otherAttent && this.anchorItem == iMUserBean.anchorItem && dq1.a(this.tips, iMUserBean.tips) && this.unReadCount == iMUserBean.unReadCount && this.isGroup == iMUserBean.isGroup && dq1.a(this.conversationID, iMUserBean.conversationID) && dq1.a(this.userID, iMUserBean.userID) && dq1.a(this.groupID, iMUserBean.groupID) && dq1.a(this.lastMsgId, iMUserBean.lastMsgId) && dq1.a(this.lastMsgString, iMUserBean.lastMsgString) && this.lastMsgTime == iMUserBean.lastMsgTime && dq1.a(this.lastMsgTimeString, iMUserBean.lastMsgTimeString);
    }

    public final boolean getAnchorItem() {
        return this.anchorItem;
    }

    public final int getAttent() {
        return this.attent;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getConversationID() {
        return this.conversationID;
    }

    public final String getGroupID() {
        return this.groupID;
    }

    public final String getId() {
        return this.id;
    }

    public final ImConUserBean getImConUserBean() {
        ImConUserBean imConUserBean = new ImConUserBean();
        imConUserBean.setAttent(this.attent);
        imConUserBean.setId(this.id);
        imConUserBean.setUserNiceName(this.userNiceName);
        imConUserBean.setAvatar(this.avatar);
        imConUserBean.setSex(this.sex);
        imConUserBean.setLevel(this.level);
        return imConUserBean;
    }

    public final String getLastMsgId() {
        return this.lastMsgId;
    }

    public final String getLastMsgString() {
        return this.lastMsgString;
    }

    public final long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public final long getLastMsgTimeFormat() {
        return h54.a(this.lastMsgTime);
    }

    public final String getLastMsgTimeString() {
        return this.lastMsgTimeString;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getOtherAttent() {
        return this.otherAttent;
    }

    public final int getSex() {
        return this.sex;
    }

    public final String getTips() {
        return this.tips;
    }

    public final int getUnReadCount() {
        return this.unReadCount;
    }

    public final UserBean getUserBean() {
        UserBean userBean = new UserBean();
        userBean.setId(this.id);
        userBean.setUserNiceName(this.userNiceName);
        userBean.setAvatar(this.avatar);
        userBean.setSex(this.sex);
        userBean.setLevel(this.level);
        return userBean;
    }

    public final String getUserID() {
        return this.userID;
    }

    public final String getUserNiceName() {
        return this.userNiceName;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((((((this.id.hashCode() * 31) + this.userNiceName.hashCode()) * 31) + this.avatar.hashCode()) * 31) + Integer.hashCode(this.sex)) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.attent)) * 31) + Integer.hashCode(this.otherAttent)) * 31) + Boolean.hashCode(this.anchorItem)) * 31) + this.tips.hashCode()) * 31) + Integer.hashCode(this.unReadCount)) * 31) + Boolean.hashCode(this.isGroup)) * 31;
        String str = this.conversationID;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.userID.hashCode()) * 31;
        String str2 = this.groupID;
        int hashCode3 = (((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.lastMsgId.hashCode()) * 31) + this.lastMsgString.hashCode()) * 31) + Long.hashCode(this.lastMsgTime)) * 31;
        String str3 = this.lastMsgTimeString;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isGroup() {
        return this.isGroup;
    }

    public final void setAnchorItem(boolean z) {
        this.anchorItem = z;
    }

    public final void setAttent(int i) {
        this.attent = i;
    }

    public final void setAvatar(String str) {
        str.getClass();
        this.avatar = str;
    }

    public final void setConBean(ImConversationBean conUserBean) {
        conUserBean.getClass();
        this.isGroup = conUserBean.isGroup();
        this.conversationID = conUserBean.getConversationID();
        String userID = conUserBean.getUserID();
        userID.getClass();
        this.userID = userID;
        this.groupID = conUserBean.getGroupID();
        String lastMsgId = conUserBean.getLastMsgId();
        lastMsgId.getClass();
        this.lastMsgId = lastMsgId;
        String lastMsgString = conUserBean.getLastMsgString();
        lastMsgString.getClass();
        this.lastMsgString = lastMsgString;
        this.lastMsgTime = conUserBean.getLastMsgTime();
        this.lastMsgTimeString = conUserBean.getLastMsgTimeString();
        this.unReadCount = conUserBean.getUnReadCount();
    }

    public final void setConversationID(String str) {
        this.conversationID = str;
    }

    public final void setGroup(boolean z) {
        this.isGroup = z;
    }

    public final void setGroupID(String str) {
        this.groupID = str;
    }

    public final void setId(String str) {
        str.getClass();
        this.id = str;
    }

    public final void setImConUserBean(ImConUserBean bean) {
        bean.getClass();
        this.attent = bean.getAttent();
        this.otherAttent = bean.getOtherAttent();
        this.anchorItem = bean.isAnchorItem();
        String lastMsgString = bean.getLastMsgString();
        lastMsgString.getClass();
        this.tips = lastMsgString;
        String id = bean.getId();
        id.getClass();
        this.id = id;
        String userNiceName = bean.getUserNiceName();
        userNiceName.getClass();
        this.userNiceName = userNiceName;
        String avatar = bean.getAvatar();
        avatar.getClass();
        this.avatar = avatar;
        this.sex = bean.getSex();
        this.level = bean.getLevel();
    }

    public final void setLastMsgId(String str) {
        str.getClass();
        this.lastMsgId = str;
    }

    public final void setLastMsgString(String str) {
        str.getClass();
        this.lastMsgString = str;
    }

    public final void setLastMsgTime(long j) {
        this.lastMsgTime = j;
    }

    public final void setLastMsgTimeString(String str) {
        this.lastMsgTimeString = str;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    public final void setOtherAttent(int i) {
        this.otherAttent = i;
    }

    public final void setSex(int i) {
        this.sex = i;
    }

    public final void setTips(String str) {
        str.getClass();
        this.tips = str;
    }

    public final void setUnReadCount(int i) {
        this.unReadCount = i;
    }

    public final void setUserID(String str) {
        str.getClass();
        this.userID = str;
    }

    public final void setUserNiceName(String str) {
        str.getClass();
        this.userNiceName = str;
    }

    public String toString() {
        return "IMUserBean(id=" + this.id + ", userNiceName=" + this.userNiceName + ", avatar=" + this.avatar + ", sex=" + this.sex + ", level=" + this.level + ", attent=" + this.attent + ", otherAttent=" + this.otherAttent + ", anchorItem=" + this.anchorItem + ", tips=" + this.tips + ", unReadCount=" + this.unReadCount + ", isGroup=" + this.isGroup + ", conversationID=" + this.conversationID + ", userID=" + this.userID + ", groupID=" + this.groupID + ", lastMsgId=" + this.lastMsgId + ", lastMsgString=" + this.lastMsgString + ", lastMsgTime=" + this.lastMsgTime + ", lastMsgTimeString=" + this.lastMsgTimeString + ')';
    }
}
