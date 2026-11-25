package com.yunbao.main.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;
import defpackage.aq4;
import defpackage.m93;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ActiveCommentBean implements Parcelable {
    private String mActiveId;
    private String mAddTime;
    private String mAtInfo;
    private List<ActiveCommentBean> mChildList;
    private int mChildPage = 1;
    private String mCommentId;
    private String mContent;
    private String mDatetime;
    private String mId;
    private int mIsLike;
    private String mLikeNum;
    private String mParentId;
    private boolean mParentNode;
    private ActiveCommentBean mParentNodeBean;
    private int mPosition;
    private int mReplyNum;
    private String mToUid;
    private UserBean mToUserBean;
    private String mUid;
    private UserBean mUserBean;
    private static final String REPLY = aq4.a(m93.ra) + " ";
    public static final Parcelable.Creator<ActiveCommentBean> CREATOR = new Parcelable.Creator<ActiveCommentBean>() { // from class: com.yunbao.main.bean.ActiveCommentBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveCommentBean createFromParcel(Parcel parcel) {
            return new ActiveCommentBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveCommentBean[] newArray(int i) {
            return new ActiveCommentBean[i];
        }
    };

    public ActiveCommentBean() {
    }

    public ActiveCommentBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mUid = parcel.readString();
        this.mToUid = parcel.readString();
        this.mActiveId = parcel.readString();
        this.mCommentId = parcel.readString();
        this.mParentId = parcel.readString();
        this.mContent = parcel.readString();
        this.mLikeNum = parcel.readString();
        this.mAddTime = parcel.readString();
        this.mAtInfo = parcel.readString();
        this.mIsLike = parcel.readInt();
        this.mReplyNum = parcel.readInt();
        this.mDatetime = parcel.readString();
        this.mUserBean = (UserBean) parcel.readParcelable(UserBean.class.getClassLoader());
        this.mToUserBean = (UserBean) parcel.readParcelable(UserBean.class.getClassLoader());
        this.mChildList = parcel.createTypedArrayList(CREATOR);
        this.mParentNode = parcel.readByte() != 0;
        this.mPosition = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "dynamicid")
    public String getActiveId() {
        return this.mActiveId;
    }

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "at_info")
    public String getAtInfo() {
        return this.mAtInfo;
    }

    @JSONField(name = "replylist")
    public List<ActiveCommentBean> getChildList() {
        return this.mChildList;
    }

    @JSONField(serialize = false)
    public int getChildPage() {
        return this.mChildPage;
    }

    @JSONField(name = "commentid")
    public String getCommentId() {
        return this.mCommentId;
    }

    @JSONField(name = "content")
    public String getContent() {
        UserBean userBean;
        if (!this.mParentNode && (userBean = this.mToUserBean) != null && !TextUtils.isEmpty(userBean.getId())) {
            String userNiceName = this.mToUserBean.getUserNiceName();
            if (!TextUtils.isEmpty(userNiceName)) {
                return REPLY + userNiceName + " : " + this.mContent;
            }
        }
        return this.mContent;
    }

    @JSONField(name = "datetime")
    public String getDatetime() {
        return this.mDatetime;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "islike")
    public int getIsLike() {
        return this.mIsLike;
    }

    @JSONField(name = "likes")
    public String getLikeNum() {
        return this.mLikeNum;
    }

    @JSONField(name = "parentid")
    public String getParentId() {
        return this.mParentId;
    }

    public ActiveCommentBean getParentNodeBean() {
        return this.mParentNodeBean;
    }

    public int getPosition() {
        return this.mPosition;
    }

    @JSONField(name = "replys")
    public int getReplyNum() {
        return this.mReplyNum;
    }

    @JSONField(name = "touid")
    public String getToUid() {
        return this.mToUid;
    }

    @JSONField(name = "touserinfo")
    public UserBean getToUserBean() {
        return this.mToUserBean;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "userinfo")
    public UserBean getUserBean() {
        return this.mUserBean;
    }

    public boolean isFirstChild(ActiveCommentBean activeCommentBean) {
        List<ActiveCommentBean> childList;
        return (this.mParentNode || activeCommentBean == null || (childList = activeCommentBean.getChildList()) == null || childList.size() <= 0 || this != childList.get(0)) ? false : true;
    }

    public boolean isParentNode() {
        return this.mParentNode;
    }

    public boolean needShowCollapsed(ActiveCommentBean activeCommentBean) {
        List<ActiveCommentBean> childList;
        int size;
        return !this.mParentNode && activeCommentBean != null && (childList = activeCommentBean.getChildList()) != null && (size = childList.size()) > 1 && size >= activeCommentBean.getReplyNum() && this == childList.get(size - 1);
    }

    public boolean needShowExpand(ActiveCommentBean activeCommentBean) {
        List<ActiveCommentBean> childList;
        if (this.mParentNode || activeCommentBean == null || (childList = activeCommentBean.getChildList()) == null) {
            return false;
        }
        int size = childList.size();
        return activeCommentBean.getReplyNum() > 1 && activeCommentBean.getReplyNum() > size && this == childList.get(size - 1);
    }

    public void removeChild() {
        List<ActiveCommentBean> list = this.mChildList;
        if (list == null || list.size() <= 1) {
            return;
        }
        this.mChildList = this.mChildList.subList(0, 1);
    }

    @JSONField(name = "dynamicid")
    public void setActiveId(String str) {
        this.mActiveId = str;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "at_info")
    public void setAtInfo(String str) {
        this.mAtInfo = str;
    }

    @JSONField(name = "replylist")
    public void setChildList(List<ActiveCommentBean> list) {
        this.mChildList = list;
        for (ActiveCommentBean activeCommentBean : list) {
            if (activeCommentBean != null) {
                activeCommentBean.setParentNodeBean(this);
            }
        }
    }

    @JSONField(serialize = false)
    public void setChildPage(int i) {
        this.mChildPage = i;
    }

    @JSONField(name = "commentid")
    public void setCommentId(String str) {
        this.mCommentId = str;
    }

    @JSONField(name = "content")
    public void setContent(String str) {
        this.mContent = str;
    }

    @JSONField(name = "datetime")
    public void setDatetime(String str) {
        this.mDatetime = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "islike")
    public void setIsLike(int i) {
        this.mIsLike = i;
    }

    @JSONField(name = "likes")
    public void setLikeNum(String str) {
        this.mLikeNum = str;
    }

    @JSONField(name = "parentid")
    public void setParentId(String str) {
        this.mParentId = str;
    }

    public void setParentNode(boolean z) {
        this.mParentNode = z;
    }

    public void setParentNodeBean(ActiveCommentBean activeCommentBean) {
        this.mParentNodeBean = activeCommentBean;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }

    @JSONField(name = "replys")
    public void setReplyNum(int i) {
        this.mReplyNum = i;
    }

    @JSONField(name = "touid")
    public void setToUid(String str) {
        this.mToUid = str;
    }

    @JSONField(name = "touserinfo")
    public void setToUserBean(UserBean userBean) {
        this.mToUserBean = userBean;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "userinfo")
    public void setUserBean(UserBean userBean) {
        this.mUserBean = userBean;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mUid);
        parcel.writeString(this.mToUid);
        parcel.writeString(this.mActiveId);
        parcel.writeString(this.mCommentId);
        parcel.writeString(this.mParentId);
        parcel.writeString(this.mContent);
        parcel.writeString(this.mLikeNum);
        parcel.writeString(this.mAddTime);
        parcel.writeString(this.mAtInfo);
        parcel.writeInt(this.mIsLike);
        parcel.writeInt(this.mReplyNum);
        parcel.writeString(this.mDatetime);
        parcel.writeParcelable(this.mUserBean, i);
        parcel.writeParcelable(this.mToUserBean, i);
        parcel.writeTypedList(this.mChildList);
        parcel.writeByte(this.mParentNode ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.mPosition);
    }
}
