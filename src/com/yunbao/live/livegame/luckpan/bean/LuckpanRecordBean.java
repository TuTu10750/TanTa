package com.yunbao.live.livegame.luckpan.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LuckpanRecordBean {
    private String mAddTime;
    private List<LuckpanRecordGiftBean> mList;
    private String mTitle;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "gift_list")
    public List<LuckpanRecordGiftBean> getList() {
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
    public void setList(List<LuckpanRecordGiftBean> list) {
        this.mList = list;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.mTitle = str;
    }
}
