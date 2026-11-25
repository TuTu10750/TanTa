package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CountryListBean {
    private List<CountryBean> lists;
    private String title;

    @JSONField(name = "lists")
    public List<CountryBean> getLists() {
        return this.lists;
    }

    @JSONField(name = "title")
    public String getTitle() {
        return this.title;
    }

    @JSONField(name = "lists")
    public void setLists(List<CountryBean> list) {
        this.lists = list;
    }

    @JSONField(name = "title")
    public void setTitle(String str) {
        this.title = str;
    }
}
