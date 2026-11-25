package com.yunbao.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import defpackage.aq4;
import defpackage.m93;

/* loaded from: /tmp/classes2.dex */
public class UserBean implements Parcelable {
    public static final Parcelable.Creator<UserBean> CREATOR = new Parcelable.Creator<UserBean>() { // from class: com.yunbao.common.bean.UserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean createFromParcel(Parcel parcel) {
            return new UserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserBean[] newArray(int i) {
            return new UserBean[i];
        }
    };
    protected String avatar;
    protected String avatarThumb;
    protected String birthday;
    protected Car car;
    protected String city;
    protected String coin;
    protected String consumption;
    protected String countryCode;
    protected int fans;
    protected int follows;
    protected String id;
    private int isPass;
    protected int level;
    protected int levelAnchor;
    protected Liang liang;
    protected int lives;
    protected String location;
    private int mIsOpenPayContent;
    private int mIsOpenShop;
    protected String province;
    protected int sdkAppID;
    protected int sdkType;
    protected int sex;
    protected String signature;
    protected String userLogin;
    protected String userNiceName;
    protected String userSig;
    protected Vip vip;
    protected String votes;
    protected int votestotal;

    /* loaded from: /tmp/classes2.dex */
    public static class Car implements Parcelable {
        public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>() { // from class: com.yunbao.common.bean.UserBean.Car.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Car createFromParcel(Parcel parcel) {
                return new Car(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Car[] newArray(int i) {
                return new Car[i];
            }
        };
        protected int id;
        protected String swf;
        protected float swftime;
        protected String words;

        public Car() {
        }

        public Car(Parcel parcel) {
            this.id = parcel.readInt();
            this.swf = parcel.readString();
            this.swftime = parcel.readFloat();
            this.words = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getId() {
            return this.id;
        }

        public String getSwf() {
            return this.swf;
        }

        public float getSwftime() {
            return this.swftime;
        }

        public String getWords() {
            return this.words;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setSwf(String str) {
            this.swf = str;
        }

        public void setSwftime(float f) {
            this.swftime = f;
        }

        public void setWords(String str) {
            this.words = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeString(this.swf);
            parcel.writeFloat(this.swftime);
            parcel.writeString(this.words);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class Liang implements Parcelable {
        public static final Parcelable.Creator<Liang> CREATOR = new Parcelable.Creator<Liang>() { // from class: com.yunbao.common.bean.UserBean.Liang.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Liang createFromParcel(Parcel parcel) {
                return new Liang(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Liang[] newArray(int i) {
                return new Liang[i];
            }
        };
        protected String name;

        public Liang() {
        }

        public Liang(Parcel parcel) {
            this.name = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.name);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class Vip implements Parcelable {
        public static final Parcelable.Creator<Vip> CREATOR = new Parcelable.Creator<Vip>() { // from class: com.yunbao.common.bean.UserBean.Vip.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Vip createFromParcel(Parcel parcel) {
                return new Vip(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Vip[] newArray(int i) {
                return new Vip[i];
            }
        };
        protected int type;

        public Vip() {
        }

        public Vip(Parcel parcel) {
            this.type = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.type);
        }
    }

    public UserBean() {
    }

    public UserBean(Parcel parcel) {
        this.id = parcel.readString();
        this.userNiceName = parcel.readString();
        this.avatar = parcel.readString();
        this.avatarThumb = parcel.readString();
        this.sex = parcel.readInt();
        this.signature = parcel.readString();
        this.coin = parcel.readString();
        this.votes = parcel.readString();
        this.consumption = parcel.readString();
        this.votestotal = parcel.readInt();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.location = parcel.readString();
        this.birthday = parcel.readString();
        this.level = parcel.readInt();
        this.levelAnchor = parcel.readInt();
        this.lives = parcel.readInt();
        this.follows = parcel.readInt();
        this.fans = parcel.readInt();
        this.vip = (Vip) parcel.readParcelable(Vip.class.getClassLoader());
        this.liang = (Liang) parcel.readParcelable(Liang.class.getClassLoader());
        this.car = (Car) parcel.readParcelable(Car.class.getClassLoader());
        this.sdkType = parcel.readInt();
        this.sdkAppID = parcel.readInt();
        this.userSig = parcel.readString();
        this.userLogin = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @JSONField(name = "avatar_thumb")
    public String getAvatarThumb() {
        return this.avatarThumb;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public Car getCar() {
        return this.car;
    }

    public String getCity() {
        return this.city;
    }

    public String getCoin() {
        return this.coin;
    }

    public String getConsumption() {
        return this.consumption;
    }

    @JSONField(name = "country_code")
    public String getCountryCode() {
        return this.countryCode;
    }

    public int getFans() {
        return this.fans;
    }

    public int getFollows() {
        return this.follows;
    }

    public String getGoodName() {
        Liang liang = this.liang;
        return liang != null ? liang.getName() : "0";
    }

    public String getId() {
        String str = this.id;
        return str != null ? str : "";
    }

    @JSONField(name = "paidprogram_switch")
    public int getIsOpenPayContent() {
        return this.mIsOpenPayContent;
    }

    @JSONField(name = "shop_switch")
    public int getIsOpenShop() {
        return this.mIsOpenShop;
    }

    @JSONField(name = "is_pass")
    public int getIsPass() {
        return this.isPass;
    }

    public int getLevel() {
        if (this.level == 0) {
            this.level = 1;
        }
        return this.level;
    }

    @JSONField(name = "level_anchor")
    public int getLevelAnchor() {
        return this.levelAnchor;
    }

    public Liang getLiang() {
        return this.liang;
    }

    public String getLiangNameTip() {
        Liang liang = this.liang;
        if (liang != null) {
            String name = liang.getName();
            if (!TextUtils.isEmpty(name) && !"0".equals(name)) {
                return aq4.a(m93.R3) + ":" + name;
            }
        }
        return "ID:" + this.id;
    }

    public int getLives() {
        return this.lives;
    }

    public String getLocation() {
        return this.location;
    }

    public String getProvince() {
        return this.province;
    }

    public int getSdkAppID() {
        return this.sdkAppID;
    }

    public int getSdkType() {
        return this.sdkType;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSignature() {
        return this.signature;
    }

    @JSONField(name = "user_login")
    public String getUserLogin() {
        return this.userLogin;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public String getUserSig() {
        return this.userSig;
    }

    public Vip getVip() {
        return this.vip;
    }

    public int getVipType() {
        Vip vip = this.vip;
        if (vip != null) {
            return vip.getType();
        }
        return 0;
    }

    public String getVotes() {
        return this.votes;
    }

    public int getVotestotal() {
        return this.votestotal;
    }

    public int isVip() {
        Vip vip = this.vip;
        return (vip == null || vip.type != 1) ? 0 : 1;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    @JSONField(name = "avatar_thumb")
    public void setAvatarThumb(String str) {
        this.avatarThumb = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    public void setConsumption(String str) {
        this.consumption = str;
    }

    @JSONField(name = "country_code")
    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setFans(int i) {
        this.fans = i;
    }

    public void setFollows(int i) {
        this.follows = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    @JSONField(name = "paidprogram_switch")
    public void setIsOpenPayContent(int i) {
        this.mIsOpenPayContent = i;
    }

    @JSONField(name = "shop_switch")
    public void setIsOpenShop(int i) {
        this.mIsOpenShop = i;
    }

    @JSONField(name = "is_pass")
    public void setIsPass(int i) {
        this.isPass = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    @JSONField(name = "level_anchor")
    public void setLevelAnchor(int i) {
        this.levelAnchor = i;
    }

    public void setLiang(Liang liang) {
        this.liang = liang;
    }

    public void setLives(int i) {
        this.lives = i;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setSdkAppID(int i) {
        this.sdkAppID = i;
    }

    public void setSdkType(int i) {
        this.sdkType = i;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    @JSONField(name = "user_login")
    public void setUserLogin(String str) {
        this.userLogin = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    public void setUserSig(String str) {
        this.userSig = str;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public void setVotes(String str) {
        this.votes = str;
    }

    public void setVotestotal(int i) {
        this.votestotal = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.userNiceName);
        parcel.writeString(this.avatar);
        parcel.writeString(this.avatarThumb);
        parcel.writeInt(this.sex);
        parcel.writeString(this.signature);
        parcel.writeString(this.coin);
        parcel.writeString(this.votes);
        parcel.writeString(this.consumption);
        parcel.writeInt(this.votestotal);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.location);
        parcel.writeString(this.birthday);
        parcel.writeInt(this.level);
        parcel.writeInt(this.levelAnchor);
        parcel.writeInt(this.lives);
        parcel.writeInt(this.follows);
        parcel.writeInt(this.fans);
        parcel.writeParcelable(this.vip, i);
        parcel.writeParcelable(this.liang, i);
        parcel.writeParcelable(this.car, i);
        parcel.writeInt(this.sdkAppID);
        parcel.writeInt(this.sdkType);
        parcel.writeString(this.userSig);
        parcel.writeString(this.userLogin);
    }
}
