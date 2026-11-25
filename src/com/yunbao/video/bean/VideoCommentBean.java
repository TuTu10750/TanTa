package com.yunbao.video.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;
import defpackage.aq4;
import defpackage.m93;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class VideoCommentBean implements Parcelable {
    private String mAddTime;
    private String mAtInfo;
    private List<VideoCommentBean> mChildList;
    private int mChildPage = 1;
    private String mCommentId;
    private String mContent;
    private String mDatetime;
    private String mId;
    private int mIsLike;
    private String mLikeNum;
    private String mParentId;
    private boolean mParentNode;
    private VideoCommentBean mParentNodeBean;
    private int mPosition;
    private int mReplyNum;
    private String mToUid;
    private UserBean mToUserBean;
    private String mUid;
    private UserBean mUserBean;
    private String mVideoId;
    private static final String REPLY = aq4.a(m93.ra) + " ";
    public static final Parcelable.Creator<VideoCommentBean> CREATOR = new Parcelable.Creator<VideoCommentBean>() { // from class: com.yunbao.video.bean.VideoCommentBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoCommentBean createFromParcel(Parcel parcel) {
            return new VideoCommentBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoCommentBean[] newArray(int i) {
            return new VideoCommentBean[i];
        }
    };

    public VideoCommentBean() {
    }

    public VideoCommentBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mUid = parcel.readString();
        this.mToUid = parcel.readString();
        this.mVideoId = parcel.readString();
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

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "at_info")
    public String getAtInfo() {
        return this.mAtInfo;
    }

    @JSONField(name = "replylist")
    public List<VideoCommentBean> getChildList() {
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

    public VideoCommentBean getParentNodeBean() {
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

    @JSONField(name = "videoid")
    public String getVideoId() {
        return this.mVideoId;
    }

    public boolean isFirstChild(VideoCommentBean videoCommentBean) {
        List<VideoCommentBean> childList;
        return (this.mParentNode || videoCommentBean == null || (childList = videoCommentBean.getChildList()) == null || childList.size() <= 0 || this != childList.get(0)) ? false : true;
    }

    public boolean isParentNode() {
        return this.mParentNode;
    }

    public boolean needShowCollapsed(VideoCommentBean videoCommentBean) {
        List<VideoCommentBean> childList;
        int size;
        return !this.mParentNode && videoCommentBean != null && (childList = videoCommentBean.getChildList()) != null && (size = childList.size()) > 1 && size >= videoCommentBean.getReplyNum() && this == childList.get(size - 1);
    }

    public boolean needShowExpand(VideoCommentBean videoCommentBean) {
        List<VideoCommentBean> childList;
        if (this.mParentNode || videoCommentBean == null || (childList = videoCommentBean.getChildList()) == null) {
            return false;
        }
        int size = childList.size();
        return videoCommentBean.getReplyNum() > 1 && videoCommentBean.getReplyNum() > size && this == childList.get(size - 1);
    }

    public void removeChild() {
        List<VideoCommentBean> list = this.mChildList;
        if (list == null || list.size() <= 1) {
            return;
        }
        this.mChildList = this.mChildList.subList(0, 1);
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
    public void setChildList(List<VideoCommentBean> list) {
        this.mChildList = list;
        for (VideoCommentBean videoCommentBean : list) {
            if (videoCommentBean != null) {
                videoCommentBean.setParentNodeBean(this);
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

    public void setParentNodeBean(VideoCommentBean videoCommentBean) {
        this.mParentNodeBean = videoCommentBean;
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

    @JSONField(name = "videoid")
    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mUid);
        parcel.writeString(this.mToUid);
        parcel.writeString(this.mVideoId);
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
