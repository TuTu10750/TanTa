package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveReportBean {
    private boolean checked;
    private String id;
    private String name;

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "VideoReportBean{id='" + this.id + "', name='" + this.name + "'}";
    }
}
