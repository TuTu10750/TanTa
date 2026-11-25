package com.yunbao.im.dao;

import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.UMCrash;
import com.yunbao.im.bean.ImMessageBean;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import defpackage.dq1;
import defpackage.j30;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.internal.http2.Http2;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bJ\b\u0087\b\u0018\u0000 f2\u00020\u0001:\u0001gB\u0095\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\"J\u0012\u0010$\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b$\u0010\"J\u0012\u0010%\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b%\u0010\"J\u0010\u0010&\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b(\u0010\u001aJ\u0010\u0010)\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b+\u0010*J\u0010\u0010,\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b,\u0010\u001aJ\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010\"J\u0010\u0010.\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b.\u0010\"J\u0010\u0010/\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b/\u0010\"J\u0010\u00100\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b0\u0010\"J\u0010\u00101\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b1\u0010\"J\u0010\u00102\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b2\u0010*J\u0010\u00103\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b3\u0010*J\u0010\u00104\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b4\u0010*JÀ\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\t2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b7\u0010\"J\u0010\u00108\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b8\u0010*J\u001a\u0010:\u001a\u00020\t2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010<\u001a\u0004\b=\u0010\"\"\u0004\b>\u0010?R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010<\u001a\u0004\b@\u0010\"\"\u0004\bA\u0010?R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010<\u001a\u0004\bB\u0010\"\"\u0004\bC\u0010?R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010<\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010?R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010F\u001a\u0004\bG\u0010'\"\u0004\bH\u0010IR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010J\u001a\u0004\bK\u0010\u001a\"\u0004\bL\u0010MR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010N\u001a\u0004\bO\u0010*\"\u0004\bP\u0010QR\"\u0010\r\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010N\u001a\u0004\bR\u0010*\"\u0004\bS\u0010QR\"\u0010\u000e\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010J\u001a\u0004\bT\u0010\u001a\"\u0004\bU\u0010MR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010<\u001a\u0004\bV\u0010\"\"\u0004\bW\u0010?R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010<\u001a\u0004\bX\u0010\"\"\u0004\bY\u0010?R\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010<\u001a\u0004\bZ\u0010\"\"\u0004\b[\u0010?R\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010<\u001a\u0004\b\\\u0010\"\"\u0004\b]\u0010?R\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010<\u001a\u0004\b^\u0010\"\"\u0004\b_\u0010?R\"\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010N\u001a\u0004\b`\u0010*\"\u0004\ba\u0010QR\"\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010N\u001a\u0004\bb\u0010*\"\u0004\bc\u0010QR\"\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010N\u001a\u0004\bd\u0010*\"\u0004\be\u0010Q¨\u0006h"}, d2 = {"Lcom/yunbao/im/dao/IMMessageBean;", "", "", "msgId", "userId", "senderId", "groupId", "", UMCrash.SP_KEY_TIMESTAMP, "", "self", "", "type", cl.i, "revoked", "showTimeString", "text", "localPath", "originImageUrl", "thumbImageUrl", "width", "height", "duration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "isRead", "()Z", "Ljava/io/File;", "getSoundFile", "()Ljava/io/File;", "Lcom/yunbao/im/bean/ImMessageBean;", "getImMessageBean", "()Lcom/yunbao/im/bean/ImMessageBean;", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()J", "component6", "component7", "()I", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)Lcom/yunbao/im/dao/IMMessageBean;", "toString", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMsgId", "setMsgId", "(Ljava/lang/String;)V", "getUserId", "setUserId", "getSenderId", "setSenderId", "getGroupId", "setGroupId", "J", "getTimestamp", "setTimestamp", "(J)V", "Z", "getSelf", "setSelf", "(Z)V", "I", "getType", "setType", "(I)V", "getStatus", "setStatus", "getRevoked", "setRevoked", "getShowTimeString", "setShowTimeString", "getText", "setText", "getLocalPath", "setLocalPath", "getOriginImageUrl", "setOriginImageUrl", "getThumbImageUrl", "setThumbImageUrl", "getWidth", "setWidth", "getHeight", "setHeight", "getDuration", "setDuration", "Companion", bv.av, "im_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final /* data */ class IMMessageBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int duration;
    private String groupId;
    private int height;
    private String localPath;
    private String msgId;
    private String originImageUrl;
    private boolean revoked;
    private boolean self;
    private String senderId;
    private String showTimeString;
    private int status;
    private String text;
    private String thumbImageUrl;
    private long timestamp;
    private int type;
    private String userId;
    private int width;

    /* renamed from: com.yunbao.im.dao.IMMessageBean$a, reason: from kotlin metadata */
    /* loaded from: /tmp/classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IMMessageBean a(String str, String str2, String str3, String str4, long j, boolean z, int i, int i2) {
            str.getClass();
            str2.getClass();
            return new IMMessageBean(str, str2, str3, str4, j, z, i, i2, false, "", "", "", "", "", 0, 0, 0);
        }
    }

    public IMMessageBean(String str, String str2, String str3, String str4, long j, boolean z, int i, int i2, boolean z2, String str5, String str6, String str7, String str8, String str9, int i3, int i4, int i5) {
        str.getClass();
        str2.getClass();
        str6.getClass();
        str7.getClass();
        str8.getClass();
        str9.getClass();
        this.msgId = str;
        this.userId = str2;
        this.senderId = str3;
        this.groupId = str4;
        this.timestamp = j;
        this.self = z;
        this.type = i;
        this.status = i2;
        this.revoked = z2;
        this.showTimeString = str5;
        this.text = str6;
        this.localPath = str7;
        this.originImageUrl = str8;
        this.thumbImageUrl = str9;
        this.width = i3;
        this.height = i4;
        this.duration = i5;
    }

    public static /* synthetic */ IMMessageBean copy$default(IMMessageBean iMMessageBean, String str, String str2, String str3, String str4, long j, boolean z, int i, int i2, boolean z2, String str5, String str6, String str7, String str8, String str9, int i3, int i4, int i5, int i6, Object obj) {
        int i7;
        int i8;
        String str10 = (i6 & 1) != 0 ? iMMessageBean.msgId : str;
        String str11 = (i6 & 2) != 0 ? iMMessageBean.userId : str2;
        String str12 = (i6 & 4) != 0 ? iMMessageBean.senderId : str3;
        String str13 = (i6 & 8) != 0 ? iMMessageBean.groupId : str4;
        long j2 = (i6 & 16) != 0 ? iMMessageBean.timestamp : j;
        boolean z3 = (i6 & 32) != 0 ? iMMessageBean.self : z;
        int i9 = (i6 & 64) != 0 ? iMMessageBean.type : i;
        int i10 = (i6 & 128) != 0 ? iMMessageBean.status : i2;
        boolean z4 = (i6 & 256) != 0 ? iMMessageBean.revoked : z2;
        String str14 = (i6 & IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) != 0 ? iMMessageBean.showTimeString : str5;
        String str15 = (i6 & CacheIOHelper.BUFFER_SIZE) != 0 ? iMMessageBean.text : str6;
        String str16 = (i6 & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? iMMessageBean.localPath : str7;
        String str17 = (i6 & 4096) != 0 ? iMMessageBean.originImageUrl : str8;
        String str18 = str10;
        String str19 = (i6 & 8192) != 0 ? iMMessageBean.thumbImageUrl : str9;
        int i11 = (i6 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? iMMessageBean.width : i3;
        int i12 = (i6 & 32768) != 0 ? iMMessageBean.height : i4;
        if ((i6 & 65536) != 0) {
            i8 = i12;
            i7 = iMMessageBean.duration;
        } else {
            i7 = i5;
            i8 = i12;
        }
        return iMMessageBean.copy(str18, str11, str12, str13, j2, z3, i9, i10, z4, str14, str15, str16, str17, str19, i11, i8, i7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getShowTimeString() {
        return this.showTimeString;
    }

    /* renamed from: component11, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component12, reason: from getter */
    public final String getLocalPath() {
        return this.localPath;
    }

    /* renamed from: component13, reason: from getter */
    public final String getOriginImageUrl() {
        return this.originImageUrl;
    }

    /* renamed from: component14, reason: from getter */
    public final String getThumbImageUrl() {
        return this.thumbImageUrl;
    }

    /* renamed from: component15, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component16, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component17, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSenderId() {
        return this.senderId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getSelf() {
        return this.self;
    }

    /* renamed from: component7, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: component8, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getRevoked() {
        return this.revoked;
    }

    public final IMMessageBean copy(String msgId, String userId, String senderId, String groupId, long timestamp, boolean self, int type, int status, boolean revoked, String showTimeString, String text, String localPath, String originImageUrl, String thumbImageUrl, int width, int height, int duration) {
        msgId.getClass();
        userId.getClass();
        text.getClass();
        localPath.getClass();
        originImageUrl.getClass();
        thumbImageUrl.getClass();
        return new IMMessageBean(msgId, userId, senderId, groupId, timestamp, self, type, status, revoked, showTimeString, text, localPath, originImageUrl, thumbImageUrl, width, height, duration);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IMMessageBean)) {
            return false;
        }
        IMMessageBean iMMessageBean = (IMMessageBean) other;
        return dq1.a(this.msgId, iMMessageBean.msgId) && dq1.a(this.userId, iMMessageBean.userId) && dq1.a(this.senderId, iMMessageBean.senderId) && dq1.a(this.groupId, iMMessageBean.groupId) && this.timestamp == iMMessageBean.timestamp && this.self == iMMessageBean.self && this.type == iMMessageBean.type && this.status == iMMessageBean.status && this.revoked == iMMessageBean.revoked && dq1.a(this.showTimeString, iMMessageBean.showTimeString) && dq1.a(this.text, iMMessageBean.text) && dq1.a(this.localPath, iMMessageBean.localPath) && dq1.a(this.originImageUrl, iMMessageBean.originImageUrl) && dq1.a(this.thumbImageUrl, iMMessageBean.thumbImageUrl) && this.width == iMMessageBean.width && this.height == iMMessageBean.height && this.duration == iMMessageBean.duration;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final int getHeight() {
        return this.height;
    }

    public final ImMessageBean getImMessageBean() {
        ImMessageBean.ImageMsgBean imageMsgBean = new ImMessageBean.ImageMsgBean(this.msgId, this.senderId, this.groupId, this.timestamp, this.self);
        if (this.type == 2) {
            imageMsgBean.setLocalPath(this.localPath);
            imageMsgBean.setOriginImageUrl(this.originImageUrl);
            imageMsgBean.setThumbImageUrl(this.thumbImageUrl);
            imageMsgBean.setWidth(this.width);
            imageMsgBean.setHeight(this.height);
        }
        return new ImMessageBean(imageMsgBean, this.type, this.status);
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getOriginImageUrl() {
        return this.originImageUrl;
    }

    public final boolean getRevoked() {
        return this.revoked;
    }

    public final boolean getSelf() {
        return this.self;
    }

    public final String getSenderId() {
        return this.senderId;
    }

    public final String getShowTimeString() {
        return this.showTimeString;
    }

    public final File getSoundFile() {
        return new File(j30.R, this.msgId);
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final String getThumbImageUrl() {
        return this.thumbImageUrl;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = ((this.msgId.hashCode() * 31) + this.userId.hashCode()) * 31;
        String str = this.senderId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupId;
        int hashCode3 = (((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.self)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.status)) * 31) + Boolean.hashCode(this.revoked)) * 31;
        String str3 = this.showTimeString;
        return ((((((((((((((hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.text.hashCode()) * 31) + this.localPath.hashCode()) * 31) + this.originImageUrl.hashCode()) * 31) + this.thumbImageUrl.hashCode()) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height)) * 31) + Integer.hashCode(this.duration);
    }

    public final boolean isRead() {
        if (this.self) {
            return true;
        }
        File soundFile = getSoundFile();
        soundFile.getClass();
        return soundFile.exists();
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final void setGroupId(String str) {
        this.groupId = str;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setLocalPath(String str) {
        str.getClass();
        this.localPath = str;
    }

    public final void setMsgId(String str) {
        str.getClass();
        this.msgId = str;
    }

    public final void setOriginImageUrl(String str) {
        str.getClass();
        this.originImageUrl = str;
    }

    public final void setRevoked(boolean z) {
        this.revoked = z;
    }

    public final void setSelf(boolean z) {
        this.self = z;
    }

    public final void setSenderId(String str) {
        this.senderId = str;
    }

    public final void setShowTimeString(String str) {
        this.showTimeString = str;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setText(String str) {
        str.getClass();
        this.text = str;
    }

    public final void setThumbImageUrl(String str) {
        str.getClass();
        this.thumbImageUrl = str;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUserId(String str) {
        str.getClass();
        this.userId = str;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public String toString() {
        return "IMMessageBean(msgId=" + this.msgId + ", userId=" + this.userId + ", senderId=" + this.senderId + ", groupId=" + this.groupId + ", timestamp=" + this.timestamp + ", self=" + this.self + ", type=" + this.type + ", status=" + this.status + ", revoked=" + this.revoked + ", showTimeString=" + this.showTimeString + ", text=" + this.text + ", localPath=" + this.localPath + ", originImageUrl=" + this.originImageUrl + ", thumbImageUrl=" + this.thumbImageUrl + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ')';
    }
}
