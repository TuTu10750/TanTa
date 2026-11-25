package com.yunbao.main.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class ActiveUserBean extends UserBean {
    public static final Parcelable.Creator<ActiveUserBean> CREATOR = new Parcelable.Creator<ActiveUserBean>() { // from class: com.yunbao.main.bean.ActiveUserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveUserBean createFromParcel(Parcel parcel) {
            return new ActiveUserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActiveUserBean[] newArray(int i) {
            return new ActiveUserBean[i];
        }
    };
    private int mIsAttention;

    public ActiveUserBean() {
    }

    public ActiveUserBean(Parcel parcel) {
        super(parcel);
        this.mIsAttention = parcel.readInt();
    }

    @JSONField(name = "isAttention")
    public int getIsAttention() {
        return this.mIsAttention;
    }

    @JSONField(name = "isAttention")
    public void setIsAttention(int i) {
        this.mIsAttention = i;
    }

    @Override // com.yunbao.common.bean.UserBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.mIsAttention);
    }
}
