package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rv3;

/* loaded from: /tmp/classes2.dex */
public class VersionBean {
    private String apkDescribe;
    private String apkUrl;
    private String apkVersion;
    private String forceUp;
    private String isUp;

    @JSONField(name = "    @JSONField(name = \"apk_describe\")\n")
    public String getApkDescribe() {
        return this.apkDescribe;
    }

    @JSONField(name = "apk_url")
    public String getApkUrl() {
        return this.apkUrl;
    }

    @JSONField(name = "apk_ver")
    public String getApkVersion() {
        return this.apkVersion;
    }

    @JSONField(name = "forceup")
    public String getForceUp() {
        return this.forceUp;
    }

    @JSONField(name = "isup")
    public String getIsUp() {
        return this.isUp;
    }

    public int isForceUp() {
        String str = this.forceUp;
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return rv3.h(this.forceUp, 0);
    }

    @JSONField(name = "apk_describe")
    public void setApkDescribe(String str) {
        this.apkDescribe = str;
    }

    @JSONField(name = "apk_url")
    public void setApkUrl(String str) {
        this.apkUrl = str;
    }

    @JSONField(name = "apk_ver")
    public void setApkVersion(String str) {
        this.apkVersion = str;
    }

    @JSONField(name = "forceup")
    public void setForceUp(String str) {
        this.forceUp = str;
    }

    @JSONField(name = "isup")
    public void setIsUp(String str) {
        this.isUp = str;
    }
}
