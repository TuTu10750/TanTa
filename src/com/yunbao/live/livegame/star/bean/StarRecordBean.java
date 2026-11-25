package com.yunbao.live.livegame.star.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class StarRecordBean {
    private String mAddTime;
    private List<StarRecordGiftBean> mList;
    private String mTitle;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "gift_list")
    public List<StarRecordGiftBean> getList() {
        return this.mList;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.mTitle;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "gift_list")
    public void setList(List<StarRecordGiftBean> list) {
        this.mList = list;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }
}
