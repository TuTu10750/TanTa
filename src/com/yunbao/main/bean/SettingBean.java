package com.yunbao.main.bean;

/* loaded from: /tmp/classes2.dex */
public class SettingBean {
    private String href;
    private int id;
    private boolean mChecked;
    private String name;
    private String thumb;

    public String getHref() {
        return this.href;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getThumb() {
        return this.thumb;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }
}
