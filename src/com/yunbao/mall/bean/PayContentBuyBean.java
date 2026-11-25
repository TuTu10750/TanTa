package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class PayContentBuyBean {
    private String mAvatar;
    private String mGoodsId;
    private String mThumb;
    private String mTitle;
    private String mUserName;
    private String mVideoNum;

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "object_id")
    public String getGoodsId() {
        return this.mGoodsId;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "user_nickname")
    public String getUserName() {
        return this.mUserName;
    }

    @JSONField(name = "video_num")
    public String getVideoNum() {
        return this.mVideoNum;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "object_id")
    public void setGoodsId(String str) {
        this.mGoodsId = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserName(String str) {
        this.mUserName = str;
    }

    @JSONField(name = "video_num")
    public void setVideoNum(String str) {
        this.mVideoNum = str;
    }
}
