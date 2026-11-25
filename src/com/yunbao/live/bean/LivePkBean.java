package com.yunbao.live.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LivePkBean {
    private String avatar;
    private int level;
    private int levelAnchor;
    private long mStartTime;
    private String pkUid;
    private int sex;
    private String stream;
    private String uid;
    private String userNiceName;

    public String getAvatar() {
        return this.avatar;
    }

    public int getLevel() {
        return this.level;
    }

    @JSONField(name = "level_anchor")
    public int getLevelAnchor() {
        return this.levelAnchor;
    }

    @JSONField(name = "pkuid")
    public String getPkUid() {
        return this.pkUid;
    }

    public int getSex() {
        return this.sex;
    }

    @JSONField(name = "starttime")
    public long getStartTime() {
        return this.mStartTime;
    }

    public String getStream() {
        return this.stream;
    }

    public String getUid() {
        return this.uid;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public boolean isLinkMic() {
        return (TextUtils.isEmpty(this.pkUid) || "0".equals(this.pkUid)) ? false : true;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    @JSONField(name = "level_anchor")
    public void setLevelAnchor(int i) {
        this.levelAnchor = i;
    }

    @JSONField(name = "pkuid")
    public void setPkUid(String str) {
        this.pkUid = str;
    }

    public void setSex(int i) {
        this.sex = i;
    }

    @JSONField(name = "starttime")
    public void setStartTime(long j) {
        this.mStartTime = j;
    }

    public void setStream(String str) {
        this.stream = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }
}
