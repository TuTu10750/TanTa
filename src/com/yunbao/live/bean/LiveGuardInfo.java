package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: /tmp/classes2.dex */
public class LiveGuardInfo implements Parcelable {
    public static final Parcelable.Creator<LiveGuardInfo> CREATOR = new Parcelable.Creator<LiveGuardInfo>() { // from class: com.yunbao.live.bean.LiveGuardInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveGuardInfo createFromParcel(Parcel parcel) {
            return new LiveGuardInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveGuardInfo[] newArray(int i) {
            return new LiveGuardInfo[i];
        }
    };
    private int guardNum;
    private String myGuardEndTime;
    private int myGuardType;

    public LiveGuardInfo() {
    }

    public LiveGuardInfo(Parcel parcel) {
        this.myGuardType = parcel.readInt();
        this.myGuardEndTime = parcel.readString();
        this.guardNum = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getGuardNum() {
        return this.guardNum;
    }

    public String getMyGuardEndTime() {
        return this.myGuardEndTime;
    }

    public int getMyGuardType() {
        return this.myGuardType;
    }

    public void setGuardNum(int i) {
        this.guardNum = i;
    }

    public void setMyGuardEndTime(String str) {
        this.myGuardEndTime = str;
    }

    public void setMyGuardType(int i) {
        this.myGuardType = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.myGuardType);
        parcel.writeString(this.myGuardEndTime);
        parcel.writeInt(this.guardNum);
    }
}
