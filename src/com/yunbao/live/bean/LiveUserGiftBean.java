package com.yunbao.live.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.UserBean;

/* loaded from: /tmp/classes2.dex */
public class LiveUserGiftBean extends UserBean {
    private int age;
    private String contribution;
    private int guardType;
    private WatchTime watchTime;

    /* loaded from: /tmp/classes2.dex */
    public class WatchTime {
        private Long enter_time;
        private int num;
        private String time_text;
        private int watch_time;
        private String watch_time_text;

        public WatchTime() {
        }

        public String getWatch_time_text() {
            String str = this.watch_time_text;
            return str == null ? "" : str;
        }

        public void setWatch_time_text(String str) {
            this.watch_time_text = str;
        }
    }

    public int getAge() {
        return this.age;
    }

    public String getContribution() {
        return this.contribution;
    }

    @JSONField(name = "guard_type")
    public int getGuardType() {
        return this.guardType;
    }

    @JSONField(name = "watch_time")
    public WatchTime getWatchTime() {
        if (this.watchTime == null) {
            this.watchTime = new WatchTime();
        }
        return this.watchTime;
    }

    public boolean hasContribution() {
        return (TextUtils.isEmpty(this.contribution) || "0".equals(this.contribution)) ? false : true;
    }

    public void setAge(int i) {
        this.age = i;
    }

    public void setContribution(String str) {
        this.contribution = str;
    }

    @JSONField(name = "guard_type")
    public void setGuardType(int i) {
        this.guardType = i;
    }

    @JSONField(name = "watch_time")
    public void setWatchTime(WatchTime watchTime) {
        this.watchTime = watchTime;
    }
}
