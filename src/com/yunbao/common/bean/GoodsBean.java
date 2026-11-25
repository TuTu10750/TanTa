package com.yunbao.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;

/* loaded from: /tmp/classes2.dex */
public class GoodsBean implements Parcelable {
    public static final Parcelable.Creator<GoodsBean> CREATOR = new Parcelable.Creator<GoodsBean>() { // from class: com.yunbao.common.bean.GoodsBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsBean createFromParcel(Parcel parcel) {
            return new GoodsBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsBean[] newArray(int i) {
            return new GoodsBean[i];
        }
    };
    private String addtime;
    private int isLiveShow;
    private int issale;
    private boolean mAdded;
    private String mDes;
    private String mHits;
    private String mId;
    private String mLink;
    private String mLocalPath;
    private String mName;
    private String mOriginPrice;
    private String mPriceNow;
    private String mPriceYong;
    private String mThumb;
    private String mUid;
    private String mVideoId;
    private int status;
    private int type;

    public GoodsBean() {
    }

    public GoodsBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mUid = parcel.readString();
        this.mVideoId = parcel.readString();
        this.mLink = parcel.readString();
        this.mName = parcel.readString();
        this.mPriceNow = parcel.readString();
        this.mDes = parcel.readString();
        this.mThumb = parcel.readString();
        this.mHits = parcel.readString();
        this.mLocalPath = parcel.readString();
        this.addtime = parcel.readString();
        this.issale = parcel.readInt();
        this.status = parcel.readInt();
        this.type = parcel.readInt();
        this.mOriginPrice = parcel.readString();
        this.isLiveShow = parcel.readInt();
        this.mPriceYong = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddtime() {
        return this.addtime;
    }

    @JSONField(name = "des")
    public String getDes() {
        return this.mDes;
    }

    public String getHaveUnitPrice() {
        return null;
    }

    public String getHaveUnitmOriginPrice() {
        return null;
    }

    @JSONField(name = "hits")
    public String getHits() {
        return this.mHits;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "live_isshow")
    public int getIsLiveShow() {
        return this.isLiveShow;
    }

    public int getIssale() {
        return this.issale;
    }

    @JSONField(name = "href")
    public String getLink() {
        return this.mLink;
    }

    @JSONField(serialize = false)
    public String getLocalPath() {
        return this.mLocalPath;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "original_price")
    public String getOriginPrice() {
        return this.mOriginPrice;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public String getPriceNow() {
        return this.mPriceNow;
    }

    @JSONField(name = "commission")
    public String getPriceYong() {
        return this.mPriceYong;
    }

    public int getStatus() {
        return this.status;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    public int getType() {
        return this.type;
    }

    @JSONField(name = "uid")
    public String getUid() {
        String str = this.mUid;
        return str == null ? "" : str;
    }

    @JSONField(name = "videoid")
    public String getVideoId() {
        return this.mVideoId;
    }

    @JSONField(serialize = false)
    public boolean isAdded() {
        return this.mAdded;
    }

    @JSONField(serialize = false)
    public void setAdded(boolean z) {
        this.mAdded = z;
    }

    public void setAddtime(String str) {
        this.addtime = str;
    }

    @JSONField(name = "des")
    public void setDes(String str) {
        this.mDes = str;
    }

    @JSONField(name = "hits")
    public void setHits(String str) {
        this.mHits = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "live_isshow")
    public void setIsLiveShow(int i) {
        this.isLiveShow = i;
    }

    public void setIssale(int i) {
        this.issale = i;
    }

    @JSONField(name = "href")
    public void setLink(String str) {
        this.mLink = str;
    }

    @JSONField(serialize = false)
    public void setLocalPath(String str) {
        this.mLocalPath = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "original_price")
    public void setOriginPrice(String str) {
        this.mOriginPrice = str;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public void setPriceNow(String str) {
        this.mPriceNow = str;
    }

    @JSONField(name = "commission")
    public void setPriceYong(String str) {
        this.mPriceYong = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "videoid")
    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mUid);
        parcel.writeString(this.mVideoId);
        parcel.writeString(this.mLink);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPriceNow);
        parcel.writeString(this.mDes);
        parcel.writeString(this.mThumb);
        parcel.writeString(this.mHits);
        parcel.writeString(this.mLocalPath);
        parcel.writeString(this.addtime);
        parcel.writeInt(this.issale);
        parcel.writeInt(this.status);
        parcel.writeInt(this.type);
        parcel.writeString(this.mOriginPrice);
        parcel.writeInt(this.isLiveShow);
        parcel.writeString(this.mPriceYong);
    }
}
