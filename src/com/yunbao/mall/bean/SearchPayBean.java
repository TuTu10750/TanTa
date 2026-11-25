package com.yunbao.mall.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.umeng.commonsdk.deeplink.DeepLinkPresetEvent;

/* loaded from: /tmp/classes2.dex */
public class SearchPayBean {
    private boolean mChecked;
    private String mId;
    private String mName;
    private String mPrice;
    private String mThumb;
    private String mVideoNum;

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    @JSONField(name = "name")
    public String getName() {
        return this.mName;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public String getPrice() {
        return this.mPrice;
    }

    @JSONField(name = "thumb")
    public String getThumb() {
        return this.mThumb;
    }

    @JSONField(name = "video_num")
    public String getVideoNum() {
        return this.mVideoNum;
    }

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "name")
    public void setName(String str) {
        this.mName = str;
    }

    @JSONField(name = DeepLinkPresetEvent.UMEventParamPrice)
    public void setPrice(String str) {
        this.mPrice = str;
    }

    @JSONField(name = "thumb")
    public void setThumb(String str) {
        this.mThumb = str;
    }

    @JSONField(name = "video_num")
    public void setVideoNum(String str) {
        this.mVideoNum = str;
    }
}
