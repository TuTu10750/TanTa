package com.yunbao.video.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class MusicBean implements Parcelable {
    public static final Parcelable.Creator<MusicBean> CREATOR = new Parcelable.Creator<MusicBean>() { // from class: com.yunbao.video.bean.MusicBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean createFromParcel(Parcel parcel) {
            return new MusicBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MusicBean[] newArray(int i) {
            return new MusicBean[i];
        }
    };
    private String author;
    private int collect;
    private boolean expand;
    private String fileUrl;
    private int id;
    private String imgUrl;
    private String length;
    private String localPath;
    private long mDuration;
    private String title;
    private String useNum;

    public MusicBean() {
    }

    public MusicBean(Parcel parcel) {
        this.id = parcel.readInt();
        this.title = parcel.readString();
        this.author = parcel.readString();
        this.imgUrl = parcel.readString();
        this.length = parcel.readString();
        this.fileUrl = parcel.readString();
        this.useNum = parcel.readString();
        this.localPath = parcel.readString();
        this.collect = parcel.readInt();
        this.mDuration = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAuthor() {
        return this.author;
    }

    @JSONField(name = "iscollect")
    public int getCollect() {
        return this.collect;
    }

    public long getDuration() {
        return this.mDuration;
    }

    @JSONField(name = "file_url")
    public String getFileUrl() {
        return this.fileUrl;
    }

    public int getId() {
        return this.id;
    }

    @JSONField(name = "img_url")
    public String getImgUrl() {
        return this.imgUrl;
    }

    public String getLength() {
        return this.length;
    }

    public String getLocalPath() {
        return this.localPath;
    }

    public String getTitle() {
        return this.title;
    }

    @JSONField(name = "use_nums")
    public String getUseNum() {
        return this.useNum;
    }

    public boolean isExpand() {
        return this.expand;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    @JSONField(name = "iscollect")
    public void setCollect(int i) {
        this.collect = i;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setExpand(boolean z) {
        this.expand = z;
    }

    @JSONField(name = "file_url")
    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    @JSONField(name = "img_url")
    public void setImgUrl(String str) {
        this.imgUrl = str;
    }

    public void setLength(String str) {
        this.length = str;
    }

    public void setLocalPath(String str) {
        this.localPath = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @JSONField(name = "use_nums")
    public void setUseNum(String str) {
        this.useNum = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.author);
        parcel.writeString(this.imgUrl);
        parcel.writeString(this.length);
        parcel.writeString(this.fileUrl);
        parcel.writeString(this.useNum);
        parcel.writeString(this.localPath);
        parcel.writeInt(this.collect);
        parcel.writeLong(this.mDuration);
    }
}
