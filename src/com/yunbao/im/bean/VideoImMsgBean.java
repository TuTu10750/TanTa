package com.yunbao.im.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class VideoImMsgBean {
    private String mAddTime;
    private String mAvatar;
    private String mContent;
    private String mFromUid;
    private String mThumb;
    private int mType;
    private String mUserName;
    private String mVideoId;
    private String mVideoTitle;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "content")
    public String getContent() {
        return this.mContent;
    }

    @JSONField(name = "uid")
    public String getFromUid() {
        return this.mFromUid;
    }

    @JSONField(name = "video_thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.mType;
    }

    @JSONField(name = "user_nickname")
    public String getUserName() {
        String str = this.mUserName;
        return str == null ? "" : str;
    }

    @JSONField(name = "videoid")
    public String getVideoId() {
        return this.mVideoId;
    }

    @JSONField(name = "video_title")
    public String getVideoTitle() {
        return this.mVideoTitle;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "content")
    public void setContent(String str) {
        this.mContent = str;
    }

    @JSONField(name = "uid")
    public void setFromUid(String str) {
        this.mFromUid = str;
    }

    @JSONField(name = "video_thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "type")
    public void setType(int i) {
        this.mType = i;
    }

    @JSONField(name = "user_nickname")
    public void setUserName(String str) {
        this.mUserName = str;
    }

    @JSONField(name = "videoid")
    public void setVideoId(String str) {
        this.mVideoId = str;
    }

    @JSONField(name = "video_title")
    public void setVideoTitle(String str) {
        this.mVideoTitle = str;
    }
}
