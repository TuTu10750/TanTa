package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;
import defpackage.rv3;

/* loaded from: /tmp/classes2.dex */
public class SearchUserBean extends UserBean {
    public static final Parcelable.Creator<SearchUserBean> CREATOR = new Parcelable.Creator<SearchUserBean>() { // from class: com.yunbao.live.bean.SearchUserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchUserBean createFromParcel(Parcel parcel) {
            return new SearchUserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SearchUserBean[] newArray(int i) {
            return new SearchUserBean[i];
        }
    };
    private int attention;
    private String livePlatform;
    private String roomId;
    private String stream;

    public SearchUserBean() {
    }

    public SearchUserBean(Parcel parcel) {
        super(parcel);
        this.attention = parcel.readInt();
        this.roomId = parcel.readString();
        this.livePlatform = parcel.readString();
        this.stream = parcel.readString();
    }

    @JSONField(name = "isattention")
    public int getAttention() {
        return this.attention;
    }

    @JSONField(name = "live_platform")
    public String getLivePlatform() {
        return this.livePlatform;
    }

    public int getLivePlatformInt() {
        String str = this.livePlatform;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return rv3.h(this.livePlatform, 0);
    }

    @JSONField(name = "room_id")
    public String getRoomId() {
        return this.roomId;
    }

    @JSONField(name = "stream")
    public String getStream() {
        return this.stream;
    }

    @JSONField(name = "isattention")
    public void setAttention(int i) {
        this.attention = i;
    }

    @JSONField(name = "live_platform")
    public void setLivePlatform(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.livePlatform = str;
    }

    @JSONField(name = "room_id")
    public void setRoomId(String str) {
        this.roomId = str;
    }

    @JSONField(name = "stream")
    public void setStream(String str) {
        this.stream = str;
    }

    @Override // com.yunbao.common.bean.UserBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.attention);
        parcel.writeString(this.roomId);
        parcel.writeString(this.livePlatform);
        parcel.writeString(this.stream);
    }
}
