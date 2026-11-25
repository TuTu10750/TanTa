package com.yunbao.common.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class CoinBean implements Parcelable {
    public static final Parcelable.Creator<CoinBean> CREATOR = new Parcelable.Creator<CoinBean>() { // from class: com.yunbao.common.bean.CoinBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoinBean createFromParcel(Parcel parcel) {
            return new CoinBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CoinBean[] newArray(int i) {
            return new CoinBean[i];
        }
    };
    private boolean checked;
    private String coin;
    private String give;
    private String id;
    private String mCoinPaypal;
    private String money;

    public CoinBean() {
    }

    public CoinBean(Parcel parcel) {
        this.id = parcel.readString();
        this.coin = parcel.readString();
        this.money = parcel.readString();
        this.give = parcel.readString();
        this.checked = parcel.readByte() != 0;
        this.mCoinPaypal = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCoin() {
        return this.coin;
    }

    @JSONField(name = "coin_paypal")
    public String getCoinPaypal() {
        return this.mCoinPaypal;
    }

    public String getGive() {
        return this.give;
    }

    public String getId() {
        return this.id;
    }

    public String getMoney() {
        return this.money;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setCoin(String str) {
        this.coin = str;
    }

    @JSONField(name = "coin_paypal")
    public void setCoinPaypal(String str) {
        this.mCoinPaypal = str;
    }

    public void setGive(String str) {
        this.give = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setMoney(String str) {
        this.money = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.coin);
        parcel.writeString(this.money);
        parcel.writeString(this.give);
        parcel.writeByte(this.checked ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mCoinPaypal);
    }
}
