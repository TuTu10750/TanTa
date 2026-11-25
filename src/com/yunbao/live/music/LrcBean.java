package com.yunbao.live.music;

/* loaded from: /tmp/classes2.dex */
public class LrcBean {
    private float duration;
    private long endTime;
    private int index;
    private String lrc;
    private float progress;
    private long startTime;

    public LrcBean(long j, String str) {
        this.startTime = j;
        this.lrc = str;
    }

    public float getDuration() {
        return this.duration;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getIndex() {
        return this.index;
    }

    public String getLrc() {
        return this.lrc;
    }

    public float getProgress() {
        return this.progress;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
        this.duration = (float) (j - this.startTime);
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setLrc(String str) {
        this.lrc = str;
    }

    public void setProgress(float f) {
        this.progress = f;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }
}
