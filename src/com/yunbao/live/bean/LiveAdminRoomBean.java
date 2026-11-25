package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveAdminRoomBean implements Parcelable {
    public static final Parcelable.Creator<LiveAdminRoomBean> CREATOR = new Parcelable.Creator<LiveAdminRoomBean>() { // from class: com.yunbao.live.bean.LiveAdminRoomBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveAdminRoomBean createFromParcel(Parcel parcel) {
            return new LiveAdminRoomBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveAdminRoomBean[] newArray(int i) {
            return new LiveAdminRoomBean[i];
        }
    };
    private String mAvatar;
    private String mAvatarThumb;
    private int mLevel;
    private String mLiveUid;
    private int mSex;
    private String mUserNiceName;

    public LiveAdminRoomBean() {
    }

    public LiveAdminRoomBean(Parcel parcel) {
        this.mLiveUid = parcel.readString();
        this.mUserNiceName = parcel.readString();
        this.mAvatar = parcel.readString();
        this.mAvatarThumb = parcel.readString();
        this.mSex = parcel.readInt();
        this.mLevel = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "avatar_thumb")
    public String getAvatarThumb() {
        return this.mAvatarThumb;
    }

    @JSONField(name = "level")
    public int getLevel() {
        return this.mLevel;
    }

    @JSONField(name = "liveuid")
    public String getLiveUid() {
        return this.mLiveUid;
    }

    @JSONField(name = "sex")
    public int getSex() {
        return this.mSex;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.mUserNiceName;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "avatar_thumb")
    public void setAvatarThumb(String str) {
        this.mAvatarThumb = str;
    }

    @JSONField(name = "level")
    public void setLevel(int i) {
        this.mLevel = i;
    }

    @JSONField(name = "liveuid")
    public void setLiveUid(String str) {
        this.mLiveUid = str;
    }

    @JSONField(name = "sex")
    public void setSex(int i) {
        this.mSex = i;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.mUserNiceName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mLiveUid);
        parcel.writeString(this.mUserNiceName);
        parcel.writeString(this.mAvatar);
        parcel.writeString(this.mAvatarThumb);
        parcel.writeInt(this.mSex);
        parcel.writeInt(this.mLevel);
    }
}
