package com.yunbao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class ManageClassBean implements Parcelable {
    public static final Parcelable.Creator<ManageClassBean> CREATOR = new Parcelable.Creator<ManageClassBean>() { // from class: com.yunbao.mall.bean.ManageClassBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageClassBean createFromParcel(Parcel parcel) {
            return new ManageClassBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ManageClassBean[] newArray(int i) {
            return new ManageClassBean[i];
        }
    };
    private boolean mChecked;
    private int mExist;
    private String mId;
    private String mName;

    public ManageClassBean() {
    }

    public ManageClassBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mExist = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "isexists")
    public int getExist() {
        return this.mExist;
    }

    @JSONField(name = "gc_id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "gc_name")
    public String getName() {
        return this.mName;
    }

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    @JSONField(name = "isexists")
    public void setExist(int i) {
        this.mExist = i;
    }

    @JSONField(name = "gc_id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "gc_name")
    public void setName(String str) {
        this.mName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mExist);
    }
}
