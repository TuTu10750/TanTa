package com.yunbao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/classes2.dex */
public class GoodsClassBean extends ManageClassBean implements Parcelable {
    public static final Parcelable.Creator<ManageClassBean> CREATOR = new Parcelable.Creator<ManageClassBean>() { // from class: com.yunbao.mall.bean.GoodsClassBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageClassBean createFromParcel(Parcel parcel) {
            return new GoodsClassBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageClassBean[] newArray(int i) {
            return new GoodsClassBean[i];
        }
    };
    private String mOneClassId;
    private boolean mTitle;
    private String mTwoClassId;

    public GoodsClassBean() {
    }

    public GoodsClassBean(Parcel parcel) {
        super(parcel);
        this.mOneClassId = parcel.readString();
        this.mTwoClassId = parcel.readString();
    }

    @Override // com.yunbao.mall.bean.ManageClassBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getOneClassId() {
        return this.mOneClassId;
    }

    public String getTwoClassId() {
        return this.mTwoClassId;
    }

    public boolean isTitle() {
        return this.mTitle;
    }

    public void setOneClassId(String str) {
        this.mOneClassId = str;
    }

    public void setTitle(boolean z) {
        this.mTitle = z;
    }

    public void setTwoClassId(String str) {
        this.mTwoClassId = str;
    }

    @Override // com.yunbao.mall.bean.ManageClassBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mOneClassId);
        parcel.writeString(this.mTwoClassId);
    }
}
