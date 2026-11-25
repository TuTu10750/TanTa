package com.yunbao.im.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class ImConUserBean extends UserBean implements Parcelable {
    public static final Parcelable.Creator<ImConUserBean> CREATOR = new Parcelable.Creator<ImConUserBean>() { // from class: com.yunbao.im.bean.ImConUserBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImConUserBean createFromParcel(Parcel parcel) {
            return new ImConUserBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImConUserBean[] newArray(int i) {
            return new ImConUserBean[i];
        }
    };
    private boolean anchorItem;
    private int attent;
    private ImConversationBean mConBean;
    private String mTips;
    private int mUnReadCount;
    private int mUserStatus;
    private int otherAttent;

    public ImConUserBean() {
    }

    public ImConUserBean(Parcel parcel) {
        super(parcel);
        this.attent = parcel.readInt();
        this.otherAttent = parcel.readInt();
        this.mUserStatus = parcel.readInt();
    }

    @Override // com.yunbao.common.bean.UserBean, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "utot")
    public int getAttent() {
        return this.attent;
    }

    public ImConversationBean getConBean() {
        return this.mConBean;
    }

    public String getConUserId() {
        ImConversationBean imConversationBean = this.mConBean;
        return imConversationBean != null ? imConversationBean.getUserID() : getId();
    }

    public String getLastMsgId() {
        ImConversationBean imConversationBean = this.mConBean;
        return imConversationBean != null ? imConversationBean.getLastMsgId() : "";
    }

    public String getLastMsgString() {
        if (!TextUtils.isEmpty(this.mTips)) {
            return this.mTips;
        }
        ImConversationBean imConversationBean = this.mConBean;
        return imConversationBean != null ? imConversationBean.getLastMsgString() : "";
    }

    public long getMsgTime() {
        ImConversationBean imConversationBean = this.mConBean;
        if (imConversationBean != null) {
            return imConversationBean.getLastMsgTime();
        }
        return 0L;
    }

    public String getMsgTimeString() {
        ImConversationBean imConversationBean = this.mConBean;
        return imConversationBean != null ? imConversationBean.getLastMsgTimeString() : "";
    }

    @JSONField(name = "ttou")
    public int getOtherAttent() {
        return this.otherAttent;
    }

    public int getUnReadCount() {
        return this.mUnReadCount;
    }

    @JSONField(name = "is_ban")
    public int getUserStatus() {
        return this.mUserStatus;
    }

    public boolean isAnchorItem() {
        return this.anchorItem;
    }

    public boolean isHasConversation() {
        return this.mConBean != null;
    }

    public void setAnchorItem(boolean z) {
        this.anchorItem = z;
    }

    @JSONField(name = "utot")
    public void setAttent(int i) {
        this.attent = i;
    }

    public void setConBean(ImConversationBean imConversationBean) {
        this.mConBean = imConversationBean;
        this.mUnReadCount = imConversationBean != null ? imConversationBean.getUnReadCount() : 0;
        this.mTips = null;
    }

    @JSONField(name = "ttou")
    public void setOtherAttent(int i) {
        this.otherAttent = i;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public void setUnReadCount(int i) {
        this.mUnReadCount = i;
    }

    @JSONField(name = "is_ban")
    public void setUserStatus(int i) {
        this.mUserStatus = i;
    }

    @Override // com.yunbao.common.bean.UserBean, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.attent);
        parcel.writeInt(this.otherAttent);
        parcel.writeInt(this.mUserStatus);
    }
}
