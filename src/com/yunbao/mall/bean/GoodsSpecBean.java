package com.yunbao.mall.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;

/* loaded from: /tmp/classes2.dex */
public class GoodsSpecBean implements Parcelable {
    public static final Parcelable.Creator<GoodsSpecBean> CREATOR = new Parcelable.Creator<GoodsSpecBean>() { // from class: com.yunbao.mall.bean.GoodsSpecBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsSpecBean createFromParcel(Parcel parcel) {
            return new GoodsSpecBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GoodsSpecBean[] newArray(int i) {
            return new GoodsSpecBean[i];
        }
    };

    @JSONField(serialize = false)
    protected String mId;

    @JSONField(serialize = false)
    protected String mName;

    @JSONField(serialize = false)
    protected String mNum;

    @JSONField(serialize = false)
    protected String mPrice;

    @JSONField(serialize = false)
    protected String mThumb;

    public GoodsSpecBean() {
    }

    public GoodsSpecBean(Parcel parcel) {
        this.mId = parcel.readString();
        this.mName = parcel.readString();
        this.mNum = parcel.readString();
        this.mPrice = parcel.readString();
        this.mThumb = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "spec_id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "spec_name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "spec_num")
    public String getNum() {
        return this.mNum;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public String getPrice() {
        return this.mPrice;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "spec_id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "spec_name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "spec_num")
    public void setNum(String str) {
        this.mNum = str;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public void setPrice(String str) {
        this.mPrice = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mName);
        parcel.writeString(this.mNum);
        parcel.writeString(this.mPrice);
        parcel.writeString(this.mThumb);
    }
}
