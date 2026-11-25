package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class RedPackBean implements Parcelable {
    public static final Parcelable.Creator<RedPackBean> CREATOR = new Parcelable.Creator<RedPackBean>() { // from class: com.yunbao.live.bean.RedPackBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPackBean createFromParcel(Parcel parcel) {
            return new RedPackBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RedPackBean[] newArray(int i) {
            return new RedPackBean[i];
        }
    };
    private String avatar;
    private int coin;
    private int count;
    private int id;
    private int isRob;
    private String liveUid;
    private int robTime;
    private int sendType;
    private String title;
    private int type;
    private String uid;
    private String userNiceName;

    public RedPackBean() {
    }

    public RedPackBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.uid = parcel.readString();
        this.liveUid = parcel.readString();
        this.type = parcel.readInt();
        this.sendType = parcel.readInt();
        this.coin = parcel.readInt();
        this.count = parcel.readInt();
        this.title = parcel.readString();
        this.userNiceName = parcel.readString();
        this.avatar = parcel.readString();
        this.isRob = parcel.readInt();
        this.robTime = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getCoin() {
        return this.coin;
    }

    @JSONField(name = "nums")
    public int getCount() {
        return this.count;
    }

    public int getId() {
        return this.id;
    }

    @JSONField(name = "isrob")
    public int getIsRob() {
        return this.isRob;
    }

    @JSONField(name = "liveuid")
    public String getLiveUid() {
        return this.liveUid;
    }

    @JSONField(name = "second")
    public int getRobTime() {
        return this.robTime;
    }

    @JSONField(name = "type_grant")
    public int getSendType() {
        return this.sendType;
    }

    @JSONField(name = "des")
    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCoin(int i) {
        this.coin = i;
    }

    @JSONField(name = "nums")
    public void setCount(int i) {
        this.count = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    @JSONField(name = "isrob")
    public void setIsRob(int i) {
        this.isRob = i;
    }

    @JSONField(name = "liveuid")
    public void setLiveUid(String str) {
        this.liveUid = str;
    }

    @JSONField(name = "second")
    public void setRobTime(int i) {
        this.robTime = i;
    }

    @JSONField(name = "type_grant")
    public void setSendType(int i) {
        this.sendType = i;
    }

    @JSONField(name = "des")
    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.uid);
        parcel.writeString(this.liveUid);
        parcel.writeInt(this.type);
        parcel.writeInt(this.sendType);
        parcel.writeInt(this.coin);
        parcel.writeInt(this.count);
        parcel.writeString(this.title);
        parcel.writeString(this.userNiceName);
        parcel.writeString(this.avatar);
        parcel.writeInt(this.isRob);
        parcel.writeInt(this.robTime);
    }
}
