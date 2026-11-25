package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class ActiveTopicBean {
    private String mId;
    private String mName;
    private int mNum;
    private String mNumString;
    private String mThumb;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = "use_nums")
    public int getNum() {
        return this.mNum;
    }

    @JSONField(name = "use_nums_msg")
    public String getNumString() {
        return this.mNumString;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = "use_nums")
    public void setNum(int i) {
        this.mNum = i;
    }

    @JSONField(name = "use_nums_msg")
    public void setNumString(String str) {
        this.mNumString = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }
}
