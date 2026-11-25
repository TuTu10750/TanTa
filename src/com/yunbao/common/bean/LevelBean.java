package com.yunbao.common.bean;

import android.graphics.Color;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: /tmp/classes2.dex */
public class LevelBean {
    private String bgIcon;
    private String color;
    private int level;
    private int mColorValue;
    private String thumb;
    private String thumbIcon;

    @JSONField(name = "bg")
    public String getBgIcon() {
        return this.bgIcon;
    }

    @JSONField(name = "colour")
    public String getColor() {
        return this.color;
    }

    public int getColorValue() {
        if (this.mColorValue == 0) {
            if (TextUtils.isEmpty(this.color)) {
                this.mColorValue = -1;
            } else {
                try {
                    this.mColorValue = Color.parseColor(this.color);
                } catch (Exception unused) {
                    this.mColorValue = -1;
                }
            }
        }
        return this.mColorValue;
    }

    @JSONField(name = "levelid")
    public int getLevel() {
        return this.level;
    }

    public String getThumb() {
        return this.thumb;
    }

    @JSONField(name = "thumb_mark")
    public String getThumbIcon() {
        return this.thumbIcon;
    }

    @JSONField(name = "bg")
    public void setBgIcon(String str) {
        this.bgIcon = str;
    }

    @JSONField(name = "colour")
    public void setColor(String str) {
        this.color = str;
    }

    @JSONField(name = "levelid")
    public void setLevel(int i) {
        this.level = i;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    @JSONField(name = "thumb_mark")
    public void setThumbIcon(String str) {
        this.thumbIcon = str;
    }
}
