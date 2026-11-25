package com.yunbao.im.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class VideoImConcatBean {
    private String mAddTime;
    private String mFromUid;
    private int mIsAttent;
    private UserBean mUserBean;

    @JSONField(name = "addtime")
    public String getAddTime() {
        return this.mAddTime;
    }

    @JSONField(name = "uid")
    public String getFromUid() {
        return this.mFromUid;
    }

    @JSONField(name = "isattention")
    public int getIsAttent() {
        return this.mIsAttent;
    }

    @JSONField(name = "userinfo")
    public UserBean getUserBean() {
        return this.mUserBean;
    }

    @JSONField(name = "addtime")
    public void setAddTime(String str) {
        this.mAddTime = str;
    }

    @JSONField(name = "uid")
    public void setFromUid(String str) {
        this.mFromUid = str;
    }

    @JSONField(name = "isattention")
    public void setIsAttent(int i) {
        this.mIsAttent = i;
    }

    @JSONField(name = "userinfo")
    public void setUserBean(UserBean userBean) {
        this.mUserBean = userBean;
    }
}
