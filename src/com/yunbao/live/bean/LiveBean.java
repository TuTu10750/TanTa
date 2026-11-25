package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import defpackage.aq4;
import defpackage.m93;

/* loaded from: /tmp/classes2.dex */
public class LiveBean implements Parcelable {
    public static final Parcelable.Creator<LiveBean> CREATOR = new Parcelable.Creator<LiveBean>() { // from class: com.yunbao.live.bean.LiveBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveBean createFromParcel(Parcel parcel) {
            return new LiveBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveBean[] newArray(int i) {
            return new LiveBean[i];
        }
    };
    private int anyway;
    private String avatar;
    private String avatarThumb;
    private String city;
    private String distance;
    private String game;
    private int gameAction;
    private String goodNum;
    private int isshop;
    private int levelAnchor;
    private int livePlatform;
    private int mIsVoice;
    private int mRecommend;
    private String nums;
    private int pkuid;
    private String pull;
    private String roomId;
    private int sex;
    private String stream;
    private String thumb;
    private String title;
    private int type;
    private String typeVal;
    private String uid;
    private String userNiceName;

    public LiveBean() {
    }

    private LiveBean(Parcel parcel) {
        this.uid = parcel.readString();
        this.avatar = parcel.readString();
        this.avatarThumb = parcel.readString();
        this.userNiceName = parcel.readString();
        this.sex = parcel.readInt();
        this.title = parcel.readString();
        this.city = parcel.readString();
        this.stream = parcel.readString();
        this.pull = parcel.readString();
        this.thumb = parcel.readString();
        this.nums = parcel.readString();
        this.distance = parcel.readString();
        this.levelAnchor = parcel.readInt();
        this.type = parcel.readInt();
        this.typeVal = parcel.readString();
        this.goodNum = parcel.readString();
        this.gameAction = parcel.readInt();
        this.game = parcel.readString();
        this.isshop = parcel.readInt();
        this.mRecommend = parcel.readInt();
        this.mIsVoice = parcel.readInt();
        this.anyway = parcel.readInt();
        this.roomId = parcel.readString();
        this.livePlatform = parcel.readInt();
        this.pkuid = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAnyway() {
        return this.anyway;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @JSONField(name = "avatar_thumb")
    public String getAvatarThumb() {
        return this.avatarThumb;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistance() {
        return this.distance;
    }

    public String getGame() {
        return this.game;
    }

    @JSONField(name = "game_action")
    public int getGameAction() {
        return this.gameAction;
    }

    @JSONField(name = "goodnum")
    public String getGoodNum() {
        return this.goodNum;
    }

    public boolean getIsPK() {
        return this.pkuid != 0;
    }

    @JSONField(name = "live_type")
    public int getIsVoice() {
        return this.mIsVoice;
    }

    public int getIsshop() {
        return this.isshop;
    }

    @JSONField(name = "level_anchor")
    public int getLevelAnchor() {
        return this.levelAnchor;
    }

    public String getLiangNameTip() {
        if (TextUtils.isEmpty(this.goodNum) || "0".equals(this.goodNum)) {
            return "ID:" + this.uid;
        }
        return aq4.a(m93.R3) + ":" + this.goodNum;
    }

    @JSONField(name = "live_platform")
    public int getLivePlatform() {
        return this.livePlatform;
    }

    public String getNums() {
        return this.nums;
    }

    @JSONField(name = "pkuid")
    public int getPkuid() {
        return this.pkuid;
    }

    public String getPull() {
        return this.pull;
    }

    @JSONField(name = "isrecommend")
    public int getRecommend() {
        return this.mRecommend;
    }

    @JSONField(name = "room_id")
    public String getRoomId() {
        return this.roomId;
    }

    public int getSex() {
        return this.sex;
    }

    public String getStream() {
        return this.stream;
    }

    public String getThumb() {
        return this.thumb;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    @JSONField(name = "type_val")
    public String getTypeVal() {
        return this.typeVal;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public boolean isVoiceRoom() {
        return this.mIsVoice == 1;
    }

    public void setAnyway(int i) {
        this.anyway = i;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    @JSONField(name = "avatar_thumb")
    public void setAvatarThumb(String str) {
        this.avatarThumb = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setGame(String str) {
        this.game = str;
    }

    @JSONField(name = "game_action")
    public void setGameAction(int i) {
        this.gameAction = i;
    }

    @JSONField(name = "goodnum")
    public void setGoodNum(String str) {
        this.goodNum = str;
    }

    @JSONField(name = "live_type")
    public void setIsVoice(int i) {
        this.mIsVoice = i;
    }

    public void setIsshop(int i) {
        this.isshop = i;
    }

    @JSONField(name = "level_anchor")
    public void setLevelAnchor(int i) {
        this.levelAnchor = i;
    }

    @JSONField(name = "live_platform")
    public void setLivePlatform(int i) {
        this.livePlatform = i;
    }

    public void setNums(String str) {
        this.nums = str;
    }

    @JSONField(name = "pkuid")
    public void setPkuid(int i) {
        this.pkuid = i;
    }

    public void setPull(String str) {
        this.pull = str;
    }

    @JSONField(name = "isrecommend")
    public void setRecommend(int i) {
        this.mRecommend = i;
    }

    @JSONField(name = "room_id")
    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setStream(String str) {
        this.stream = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    @JSONField(name = "type_val")
    public void setTypeVal(String str) {
        this.typeVal = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    public String toString() {
        return "uid: " + this.uid + " , userNiceName: " + this.userNiceName + " ,playUrl: " + this.pull;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.uid);
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarThumb);
        parcel.writeString(this.userNiceName);
        parcel.writeInt(this.sex);
        parcel.writeString(this.title);
        parcel.writeString(this.city);
        parcel.writeString(this.stream);
        parcel.writeString(this.pull);
        parcel.writeString(this.thumb);
        parcel.writeString(this.nums);
        parcel.writeString(this.distance);
        parcel.writeInt(this.levelAnchor);
        parcel.writeInt(this.type);
        parcel.writeString(this.typeVal);
        parcel.writeString(this.goodNum);
        parcel.writeInt(this.gameAction);
        parcel.writeString(this.game);
        parcel.writeInt(this.isshop);
        parcel.writeInt(this.mRecommend);
        parcel.writeInt(this.mIsVoice);
        parcel.writeInt(this.anyway);
        parcel.writeString(this.roomId);
        parcel.writeInt(this.livePlatform);
        parcel.writeInt(this.pkuid);
    }
}
