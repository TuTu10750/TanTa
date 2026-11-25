package com.yunbao.main.bean;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class RecommendBean {
    private String attention;
    private String avatar;
    private String avatarThumb;
    private boolean checked = true;
    private String fans;
    private String id;
    private String userNiceName;

    @JSONField(name = "isattention")
    public String getAttention() {
        return this.attention;
    }

    public String getAvatar() {
        return this.avatar;
    }

    @JSONField(name = "avatar_thumb")
    public String getAvatarThumb() {
        return this.avatarThumb;
    }

    public String getFans() {
        return this.fans;
    }

    public String getId() {
        return this.id;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public boolean isChecked() {
        return this.checked;
    }

    @JSONField(name = "isattention")
    public void setAttention(String str) {
        this.attention = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    @JSONField(name = "avatar_thumb")
    public void setAvatarThumb(String str) {
        this.avatarThumb = str;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setFans(String str) {
        this.fans = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    public void toggleChecked() {
        this.checked = !this.checked;
    }
}
