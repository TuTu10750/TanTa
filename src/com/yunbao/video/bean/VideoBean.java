package com.yunbao.video.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class VideoBean implements Parcelable {
    public static final Parcelable.Creator<VideoBean> CREATOR = new Parcelable.Creator<VideoBean>() { // from class: com.yunbao.video.bean.VideoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoBean createFromParcel(Parcel parcel) {
            return new VideoBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoBean[] newArray(int i) {
            return new VideoBean[i];
        }
    };
    private String addtime;
    private int attent;
    private String city;
    private String commentNum;
    private String datetime;
    private String distance;
    private String href;
    private String hrefW;
    private String id;
    private String lat;
    private int like;
    private String likeNum;
    private String lng;
    private String mAdUrl;
    private String mGoodsId;
    private int mGoodsType;
    private int mIsAd;
    private int mType;
    private int musicId;
    private String musicImageUrl;
    private String musicTitle;
    private String shareNum;
    private int status;
    private int step;
    private String stepNum;
    private String thumb;
    private String thumbs;
    private String title;
    private String uid;
    private UserBean userBean;
    private String viewNum;

    public VideoBean() {
    }

    public VideoBean(Parcel parcel) {
        this.id = parcel.readString();
        this.uid = parcel.readString();
        this.title = parcel.readString();
        this.thumb = parcel.readString();
        this.thumbs = parcel.readString();
        this.href = parcel.readString();
        this.hrefW = parcel.readString();
        this.likeNum = parcel.readString();
        this.viewNum = parcel.readString();
        this.commentNum = parcel.readString();
        this.stepNum = parcel.readString();
        this.shareNum = parcel.readString();
        this.addtime = parcel.readString();
        this.lat = parcel.readString();
        this.lng = parcel.readString();
        this.city = parcel.readString();
        this.userBean = (UserBean) parcel.readParcelable(UserBean.class.getClassLoader());
        this.datetime = parcel.readString();
        this.distance = parcel.readString();
        this.step = parcel.readInt();
        this.like = parcel.readInt();
        this.attent = parcel.readInt();
        this.status = parcel.readInt();
        this.musicId = parcel.readInt();
        this.mGoodsId = parcel.readString();
        this.mType = parcel.readInt();
        this.mGoodsType = parcel.readInt();
        this.mIsAd = parcel.readInt();
        this.mAdUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "ad_url")
    public String getAdUrl() {
        return this.mAdUrl;
    }

    public String getAddtime() {
        return this.addtime;
    }

    @JSONField(name = "isattent")
    public int getAttent() {
        return this.attent;
    }

    public String getCity() {
        return this.city;
    }

    @JSONField(name = "comments")
    public String getCommentNum() {
        return this.commentNum;
    }

    public String getDatetime() {
        return this.datetime;
    }

    public String getDistance() {
        return this.distance;
    }

    @JSONField(name = "goodsid")
    public String getGoodsId() {
        return this.mGoodsId;
    }

    @JSONField(name = "goods_type")
    public int getGoodsType() {
        return this.mGoodsType;
    }

    public String getHref() {
        return this.href;
    }

    @JSONField(name = "href_w")
    public String getHrefW() {
        return this.hrefW;
    }

    public String getId() {
        return this.id;
    }

    @JSONField(name = "is_ad")
    public int getIsAd() {
        return this.mIsAd;
    }

    public String getLat() {
        return this.lat;
    }

    @JSONField(name = "islike")
    public int getLike() {
        return this.like;
    }

    @JSONField(name = "likes")
    public String getLikeNum() {
        return this.likeNum;
    }

    public String getLng() {
        return this.lng;
    }

    @JSONField(name = "music_id")
    public int getMusicId() {
        return this.musicId;
    }

    @JSONField(name = "music_img")
    public String getMusicImageUrl() {
        return this.musicImageUrl;
    }

    @JSONField(name = "music_title")
    public String getMusicTitle() {
        return this.musicTitle;
    }

    @JSONField(name = "shares")
    public String getShareNum() {
        return this.shareNum;
    }

    public int getStatus() {
        return this.status;
    }

    @JSONField(name = "isstep")
    public int getStep() {
        return this.step;
    }

    @JSONField(name = "steps")
    public String getStepNum() {
        return this.stepNum;
    }

    public String getTag() {
        return "VideoBean" + getId() + hashCode();
    }

    public String getThumb() {
        return this.thumb;
    }

    @JSONField(name = "thumb_s")
    public String getThumbs() {
        return this.thumbs;
    }

    public String getTitle() {
        return this.title;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.mType;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "userinfo")
    public UserBean getUserBean() {
        return this.userBean;
    }

    @JSONField(name = "views")
    public String getViewNum() {
        return this.viewNum;
    }

    @JSONField(name = "ad_url")
    public void setAdUrl(String str) {
        this.mAdUrl = str;
    }

    public void setAddtime(String str) {
        this.addtime = str;
    }

    @JSONField(name = "isattent")
    public void setAttent(int i) {
        this.attent = i;
    }

    public void setCity(String str) {
        this.city = str;
    }

    @JSONField(name = "comments")
    public void setCommentNum(String str) {
        this.commentNum = str;
    }

    public void setDatetime(String str) {
        this.datetime = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    @JSONField(name = "goodsid")
    public void setGoodsId(String str) {
        this.mGoodsId = str;
    }

    @JSONField(name = "goods_type")
    public void setGoodsType(int i) {
        this.mGoodsType = i;
    }

    public void setHref(String str) {
        this.href = str;
    }

    @JSONField(name = "href_w")
    public void setHrefW(String str) {
        this.hrefW = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    @JSONField(name = "is_ad")
    public void setIsAd(int i) {
        this.mIsAd = i;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    @JSONField(name = "islike")
    public void setLike(int i) {
        this.like = i;
    }

    @JSONField(name = "likes")
    public void setLikeNum(String str) {
        this.likeNum = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    @JSONField(name = "music_id")
    public void setMusicId(int i) {
        this.musicId = i;
    }

    @JSONField(name = "music_img")
    public void setMusicImageUrl(String str) {
        this.musicImageUrl = str;
    }

    @JSONField(name = "music_title")
    public void setMusicTitle(String str) {
        this.musicTitle = str;
    }

    @JSONField(name = "shares")
    public void setShareNum(String str) {
        this.shareNum = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    @JSONField(name = "isstep")
    public void setStep(int i) {
        this.step = i;
    }

    @JSONField(name = "steps")
    public void setStepNum(String str) {
        this.stepNum = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    @JSONField(name = "thumb_s")
    public void setThumbs(String str) {
        this.thumbs = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @JSONField(name = "type")
    public void setType(int i) {
        this.mType = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "userinfo")
    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    @JSONField(name = "views")
    public void setViewNum(String str) {
        this.viewNum = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.uid);
        parcel.writeString(this.title);
        parcel.writeString(this.thumb);
        parcel.writeString(this.thumbs);
        parcel.writeString(this.href);
        parcel.writeString(this.hrefW);
        parcel.writeString(this.likeNum);
        parcel.writeString(this.viewNum);
        parcel.writeString(this.commentNum);
        parcel.writeString(this.stepNum);
        parcel.writeString(this.shareNum);
        parcel.writeString(this.addtime);
        parcel.writeString(this.lat);
        parcel.writeString(this.lng);
        parcel.writeString(this.city);
        parcel.writeParcelable(this.userBean, i);
        parcel.writeString(this.datetime);
        parcel.writeString(this.distance);
        parcel.writeInt(this.step);
        parcel.writeInt(this.like);
        parcel.writeInt(this.attent);
        parcel.writeInt(this.status);
        parcel.writeInt(this.musicId);
        parcel.writeString(this.mGoodsId);
        parcel.writeInt(this.mType);
        parcel.writeInt(this.mGoodsType);
        parcel.writeInt(this.mIsAd);
        parcel.writeString(this.mAdUrl);
    }
}
