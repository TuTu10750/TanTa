package com.yunbao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class BuyerAddressBean implements Parcelable {
    public static final Parcelable.Creator<BuyerAddressBean> CREATOR = new Parcelable.Creator<BuyerAddressBean>() { // from class: com.yunbao.mall.bean.BuyerAddressBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BuyerAddressBean createFromParcel(Parcel parcel) {
            return new BuyerAddressBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BuyerAddressBean[] newArray(int i) {
            return new BuyerAddressBean[i];
        }
    };
    private String mAddress;
    private String mCity;
    private String mId;
    private int mIsDefault;
    private String mName;
    private String mPhoneNum;
    private String mProvince;
    private String mZone;

    public BuyerAddressBean() {
    }

    public BuyerAddressBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mPhoneNum = parcel.readString();
        this.mProvince = parcel.readString();
        this.mCity = parcel.readString();
        this.mZone = parcel.readString();
        this.mAddress = parcel.readString();
        this.mIsDefault = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "address")
    public String getAddress() {
        return this.mAddress;
    }

    @JSONField(name = "city")
    public String getCity() {
        return this.mCity;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "is_default")
    public int getIsDefault() {
        return this.mIsDefault;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "phone")
    public String getPhoneNum() {
        return this.mPhoneNum;
    }

    @JSONField(name = "province")
    public String getProvince() {
        return this.mProvince;
    }

    @JSONField(name = "area")
    public String getZone() {
        return this.mZone;
    }

    @JSONField(name = "address")
    public void setAddress(String str) {
        this.mAddress = str;
    }

    @JSONField(name = "city")
    public void setCity(String str) {
        this.mCity = str;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "is_default")
    public void setIsDefault(int i) {
        this.mIsDefault = i;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "phone")
    public void setPhoneNum(String str) {
        this.mPhoneNum = str;
    }

    @JSONField(name = "province")
    public void setProvince(String str) {
        this.mProvince = str;
    }

    @JSONField(name = "area")
    public void setZone(String str) {
        this.mZone = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mPhoneNum);
        parcel.writeString(this.mProvince);
        parcel.writeString(this.mCity);
        parcel.writeString(this.mZone);
        parcel.writeString(this.mAddress);
        parcel.writeInt(this.mIsDefault);
    }
}
