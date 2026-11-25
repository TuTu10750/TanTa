package com.yunbao.live.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.analytics.pro.bv;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class LiveConfigBean implements Parcelable {
    public static final Parcelable.Creator<LiveConfigBean> CREATOR = new Parcelable.Creator<LiveConfigBean>() { // from class: com.yunbao.live.bean.LiveConfigBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveConfigBean createFromParcel(Parcel parcel) {
            return new LiveConfigBean(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LiveConfigBean[] newArray(int i) {
            return new LiveConfigBean[i];
        }
    };
    private int mAudioKBitrate;
    private int mEncodeMethod;
    private int mPreviewFps;
    private int mPreviewResolution;
    private int mTargetFps;
    private int mTargetGop;
    private int mTargetResolution;
    private int mVideoKBitrate;
    private int mVideoKBitrateMax;
    private int mVideoKBitrateMin;

    public LiveConfigBean() {
    }

    public LiveConfigBean(Parcel parcel) {
        this.mEncodeMethod = parcel.readInt();
        this.mTargetResolution = parcel.readInt();
        this.mTargetFps = parcel.readInt();
        this.mTargetGop = parcel.readInt();
        this.mVideoKBitrate = parcel.readInt();
        this.mVideoKBitrateMax = parcel.readInt();
        this.mVideoKBitrateMin = parcel.readInt();
        this.mAudioKBitrate = parcel.readInt();
        this.mPreviewFps = parcel.readInt();
        this.mPreviewResolution = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @JSONField(name = "audiorate")
    public int getAudioKBitrate() {
        return this.mAudioKBitrate;
    }

    @JSONField(name = "codingmode")
    public int getEncodeMethod() {
        return this.mEncodeMethod;
    }

    @JSONField(name = "preview_fps")
    public int getPreviewFps() {
        return this.mPreviewFps;
    }

    @JSONField(name = "preview_resolution")
    public int getPreviewResolution() {
        return this.mPreviewResolution;
    }

    @JSONField(name = "fps")
    public int getTargetFps() {
        return this.mTargetFps;
    }

    @JSONField(name = "gop")
    public int getTargetGop() {
        return this.mTargetGop;
    }

    @JSONField(name = bv.z)
    public int getTargetResolution() {
        return this.mTargetResolution;
    }

    @JSONField(name = IjkMediaMeta.IJKM_KEY_BITRATE)
    public int getVideoKBitrate() {
        return this.mVideoKBitrate;
    }

    @JSONField(name = "bitrate_max")
    public int getVideoKBitrateMax() {
        return this.mVideoKBitrateMax;
    }

    @JSONField(name = "bitrate_min")
    public int getVideoKBitrateMin() {
        return this.mVideoKBitrateMin;
    }

    @JSONField(name = "audiorate")
    public void setAudioKBitrate(int i) {
        this.mAudioKBitrate = i;
    }

    @JSONField(name = "codingmode")
    public void setEncodeMethod(int i) {
        this.mEncodeMethod = i;
    }

    @JSONField(name = "preview_fps")
    public void setPreviewFps(int i) {
        this.mPreviewFps = i;
    }

    @JSONField(name = "preview_resolution")
    public void setPreviewResolution(int i) {
        this.mPreviewResolution = i;
    }

    @JSONField(name = "fps")
    public void setTargetFps(int i) {
        this.mTargetFps = i;
    }

    @JSONField(name = "gop")
    public void setTargetGop(int i) {
        this.mTargetGop = i;
    }

    @JSONField(name = bv.z)
    public void setTargetResolution(int i) {
        this.mTargetResolution = i;
    }

    @JSONField(name = IjkMediaMeta.IJKM_KEY_BITRATE)
    public void setVideoKBitrate(int i) {
        this.mVideoKBitrate = i;
    }

    @JSONField(name = "bitrate_max")
    public void setVideoKBitrateMax(int i) {
        this.mVideoKBitrateMax = i;
    }

    @JSONField(name = "bitrate_min")
    public void setVideoKBitrateMin(int i) {
        this.mVideoKBitrateMin = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mEncodeMethod);
        parcel.writeInt(this.mTargetResolution);
        parcel.writeInt(this.mTargetFps);
        parcel.writeInt(this.mTargetGop);
        parcel.writeInt(this.mVideoKBitrate);
        parcel.writeInt(this.mVideoKBitrateMax);
        parcel.writeInt(this.mVideoKBitrateMin);
        parcel.writeInt(this.mAudioKBitrate);
        parcel.writeInt(this.mPreviewFps);
        parcel.writeInt(this.mPreviewResolution);
    }
}
