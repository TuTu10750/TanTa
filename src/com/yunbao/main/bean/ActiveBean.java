package com.yunbao.main.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.g;
import defpackage.j30;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ActiveBean implements Parcelable {
    public static final Parcelable.Creator<ActiveBean> CREATOR = new Parcelable.Creator<ActiveBean>() { // from class: com.yunbao.main.bean.ActiveBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveBean createFromParcel(Parcel parcel) {
            return new ActiveBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveBean[] newArray(int i) {
            return new ActiveBean[i];
        }
    };
    private int mActiveType;
    private String mAddress;
    private String mCity;
    private int mCommentNum;
    private String mDateTime;
    private String mGoodsInfo;
    private String mId;
    private List<String> mImageList;
    private int mIsLike;
    private String mLat;
    private int mLikeNum;
    private String mLng;
    private int mStatus;
    private String mText;
    private String mTopicId;
    private String mTopicName;
    private String mUid;
    private ActiveUserBean mUserBean;
    private String mVideoImage;
    private String mVideoUrl;
    private int mVoiceDuration;
    private File mVoiceFile;
    private String mVoiceUrl;

    public ActiveBean() {
    }

    public ActiveBean(Parcel parcel) {
        this.mActiveType = parcel.readInt();
        this.mText = parcel.readString();
        this.mImageList = parcel.createStringArrayList();
        this.mVideoImage = parcel.readString();
        this.mVideoUrl = parcel.readString();
        this.mVoiceUrl = parcel.readString();
        this.mVoiceDuration = parcel.readInt();
        this.mLng = parcel.readString();
        this.mLat = parcel.readString();
        this.mCity = parcel.readString();
        this.mAddress = parcel.readString();
        this.mId = parcel.readString();
        this.mUid = parcel.readString();
        this.mLikeNum = parcel.readInt();
        this.mCommentNum = parcel.readInt();
        this.mIsLike = parcel.readInt();
        this.mDateTime = parcel.readString();
        this.mStatus = parcel.readInt();
        this.mTopicId = parcel.readString();
        this.mTopicName = parcel.readString();
        this.mUserBean = (ActiveUserBean) parcel.readParcelable(ActiveUserBean.class.getClassLoader());
        this.mGoodsInfo = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "type")
    public int getActiveType() {
        return this.mActiveType;
    }

    @JSONField(name = "address")
    public String getAddress() {
        return this.mAddress;
    }

    @JSONField(name = "city")
    public String getCity() {
        return this.mCity;
    }

    @JSONField(name = "comments")
    public int getCommentNum() {
        return this.mCommentNum;
    }

    public String getCommentNumString() {
        int i = this.mCommentNum;
        return i == 0 ? "" : String.valueOf(i);
    }

    @JSONField(name = "datetime")
    public String getDateTime() {
        return this.mDateTime;
    }

    @JSONField(name = "goodsinfo")
    public String getGoodsInfo() {
        return this.mGoodsInfo;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "thumbs")
    public List<String> getImageList() {
        return this.mImageList;
    }

    @JSONField(name = "islike")
    public int getIsLike() {
        return this.mIsLike;
    }

    @JSONField(name = g.C)
    public String getLat() {
        return this.mLat;
    }

    @JSONField(name = "likes")
    public int getLikeNum() {
        return this.mLikeNum;
    }

    public String getLikeNumString() {
        int i = this.mLikeNum;
        return i == 0 ? "" : String.valueOf(i);
    }

    @JSONField(name = g.D)
    public String getLng() {
        return this.mLng;
    }

    @JSONField(name = cl.i)
    public int getStatus() {
        return this.mStatus;
    }

    @JSONField(name = "title")
    public String getText() {
        return this.mText;
    }

    @JSONField(name = "labelid")
    public String getTopicId() {
        return this.mTopicId;
    }

    @JSONField(name = "label_name")
    public String getTopicName() {
        return this.mTopicName;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "userinfo")
    public ActiveUserBean getUserBean() {
        return this.mUserBean;
    }

    @JSONField(name = "video_thumb")
    public String getVideoImage() {
        return this.mVideoImage;
    }

    @JSONField(name = "href")
    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    @JSONField(name = "length")
    public int getVoiceDuration() {
        return this.mVoiceDuration;
    }

    @JSONField(serialize = false)
    public File getVoiceFile() {
        return this.mVoiceFile;
    }

    @JSONField(name = "voice")
    public String getVoiceUrl() {
        return this.mVoiceUrl;
    }

    public boolean isFollow() {
        ActiveUserBean activeUserBean = this.mUserBean;
        return activeUserBean != null && activeUserBean.getIsAttention() == 1;
    }

    public boolean isLike() {
        return this.mIsLike == 1;
    }

    public boolean isSelf() {
        return !TextUtils.isEmpty(this.mUid) && this.mUid.equals(j30.q().C());
    }

    @JSONField(name = "type")
    public void setActiveType(int i) {
        this.mActiveType = i;
    }

    @JSONField(name = "address")
    public void setAddress(String str) {
        this.mAddress = str;
    }

    @JSONField(name = "city")
    public void setCity(String str) {
        this.mCity = str;
    }

    @JSONField(name = "comments")
    public void setCommentNum(int i) {
        this.mCommentNum = i;
    }

    @JSONField(name = "datetime")
    public void setDateTime(String str) {
        this.mDateTime = str;
    }

    @JSONField(name = "goodsinfo")
    public void setGoodsInfo(String str) {
        this.mGoodsInfo = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "thumbs")
    public void setImageList(List<String> list) {
        this.mImageList = list;
    }

    @JSONField(name = "islike")
    public void setIsLike(int i) {
        this.mIsLike = i;
    }

    @JSONField(name = g.C)
    public void setLat(String str) {
        this.mLat = str;
    }

    @JSONField(name = "likes")
    public void setLikeNum(int i) {
        this.mLikeNum = i;
    }

    @JSONField(name = g.D)
    public void setLng(String str) {
        this.mLng = str;
    }

    @JSONField(name = cl.i)
    public void setStatus(int i) {
        this.mStatus = i;
    }

    @JSONField(name = "title")
    public void setText(String str) {
        this.mText = str;
    }

    @JSONField(name = "labelid")
    public void setTopicId(String str) {
        this.mTopicId = str;
    }

    @JSONField(name = "label_name")
    public void setTopicName(String str) {
        this.mTopicName = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "userinfo")
    public void setUserBean(ActiveUserBean activeUserBean) {
        this.mUserBean = activeUserBean;
    }

    @JSONField(name = "video_thumb")
    public void setVideoImage(String str) {
        this.mVideoImage = str;
    }

    @JSONField(name = "href")
    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    @JSONField(name = "length")
    public void setVoiceDuration(int i) {
        this.mVoiceDuration = i;
    }

    @JSONField(serialize = false)
    public void setVoiceFile(File file) {
        this.mVoiceFile = file;
    }

    @JSONField(name = "voice")
    public void setVoiceUrl(String str) {
        this.mVoiceUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mActiveType);
        parcel.writeString(this.mText);
        parcel.writeStringList(this.mImageList);
        parcel.writeString(this.mVideoImage);
        parcel.writeString(this.mVideoUrl);
        parcel.writeString(this.mVoiceUrl);
        parcel.writeInt(this.mVoiceDuration);
        parcel.writeString(this.mLng);
        parcel.writeString(this.mLat);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mAddress);
        parcel.writeString(this.mId);
        parcel.writeString(this.mUid);
        parcel.writeInt(this.mLikeNum);
        parcel.writeInt(this.mCommentNum);
        parcel.writeInt(this.mIsLike);
        parcel.writeString(this.mDateTime);
        parcel.writeInt(this.mStatus);
        parcel.writeString(this.mTopicId);
        parcel.writeString(this.mTopicName);
        parcel.writeParcelable(this.mUserBean, i);
        parcel.writeString(this.mGoodsInfo);
    }
}
