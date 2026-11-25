package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LiveRecordBean {
    private String city;
    private String dateEndTime;
    private String dateStartTime;
    private String endTime;
    private String id;
    private int nums;
    private String startTime;
    private String title;
    private String uid;

    public String getCity() {
        return this.city;
    }

    @JSONField(name = "dateendtime")
    public String getDateEndTime() {
        return this.dateEndTime;
    }

    @JSONField(name = "datestarttime")
    public String getDateStartTime() {
        return this.dateStartTime;
    }

    @JSONField(name = "endtime")
    public String getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id;
    }

    public int getNums() {
        return this.nums;
    }

    @JSONField(name = "starttime")
    public String getStartTime() {
        return this.startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUid() {
        return this.uid;
    }

    public void setCity(String str) {
        this.city = str;
    }

    @JSONField(name = "dateendtime")
    public void setDateEndTime(String str) {
        this.dateEndTime = str;
    }

    @JSONField(name = "datestarttime")
    public void setDateStartTime(String str) {
        this.dateStartTime = str;
    }

    @JSONField(name = "endtime")
    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setNums(int i) {
        this.nums = i;
    }

    @JSONField(name = "starttime")
    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
