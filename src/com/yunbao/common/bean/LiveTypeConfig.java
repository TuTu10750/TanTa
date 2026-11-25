package com.yunbao.common.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveTypeConfig {
    private int TicketMax;
    private int TicketMin;
    private int TimeRoomMax;
    private int TimeRoomMin;
    private int fullHD;
    private String mStream;
    private int isFullHD = 0;
    private int isTicketRoom = 0;
    private int isTimeRoom = 0;
    private int liveType = 0;
    private int LiveTypeVal = 0;

    public int getFullHD() {
        return this.fullHD;
    }

    public int getIsFullHD() {
        return this.isFullHD;
    }

    public int getIsTicketRoom() {
        return this.isTicketRoom;
    }

    public int getIsTimeRoom() {
        return this.isTimeRoom;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public int getLiveTypeVal() {
        return this.LiveTypeVal;
    }

    public String getStream() {
        return this.mStream;
    }

    public int getTicketMax() {
        return this.TicketMax;
    }

    public int getTicketMin() {
        return this.TicketMin;
    }

    public int getTimeRoomMax() {
        return this.TimeRoomMax;
    }

    public int getTimeRoomMin() {
        return this.TimeRoomMin;
    }

    public int getVideoQuality() {
        int i = this.fullHD;
        return (i != 720 && i == 1080) ? 4 : 3;
    }

    public void setFullHD(int i) {
        this.fullHD = i;
    }

    public void setIsFullHD(int i) {
        this.isFullHD = i;
    }

    public void setIsTicketRoom(int i) {
        this.isTicketRoom = i;
    }

    public void setIsTimeRoom(int i) {
        this.isTimeRoom = i;
    }

    public void setLiveType(int i) {
        this.liveType = i;
    }

    public void setLiveTypeVal(int i) {
        this.LiveTypeVal = i;
    }

    public void setStream(String str) {
        this.mStream = str;
    }

    public void setTicketMax(int i) {
        this.TicketMax = i;
    }

    public void setTicketMin(int i) {
        this.TicketMin = i;
    }

    public void setTimeRoomMax(int i) {
        this.TimeRoomMax = i;
    }

    public void setTimeRoomMin(int i) {
        this.TimeRoomMin = i;
    }
}
