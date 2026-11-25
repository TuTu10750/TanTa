package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class CoinPayBean2 {
    private List<ChargeConfigBean> charge_config;
    private String href;
    private String id;
    private int is_default;
    private boolean mChecked;
    private String name;
    private int open_type;
    private String remark;
    private String thumb;
    private List<ChargeConfigBean> vip_config;

    /* loaded from: /tmp/classes2.dex */
    public static class ChargeConfigBean {
        private String describe;
        private String diamond;
        private int id;
        private boolean mmChecked;
        private String money;
        private String name;
        private String privilege = "";
        private String remark;

        public String getDescribe() {
            return this.describe;
        }

        public String getDiamond() {
            return this.diamond;
        }

        public int getId() {
            return this.id;
        }

        public String getMoney() {
            return this.money;
        }

        public String getName() {
            return this.name;
        }

        public String getPrivilege() {
            return this.privilege;
        }

        public String getRemark() {
            return this.remark;
        }

        public boolean isChecked() {
            return this.mmChecked;
        }

        public void setChecked(boolean z) {
            this.mmChecked = z;
        }

        public void setDescribe(String str) {
            this.describe = str;
        }

        public void setDiamond(String str) {
            this.diamond = str;
        }

        public void setId(int i) {
            this.id = i;
        }

        public void setMoney(String str) {
            this.money = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPrivilege(String str) {
            this.privilege = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }
    }

    public List<ChargeConfigBean> getCharge_config() {
        return this.charge_config;
    }

    public String getHref() {
        return this.href;
    }

    public String getId() {
        return this.id;
    }

    public int getIs_default() {
        return this.is_default;
    }

    public String getName() {
        return this.name;
    }

    public int getOpen_type() {
        return this.open_type;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getThumb() {
        return this.thumb;
    }

    public List<ChargeConfigBean> getVip_config() {
        return this.vip_config;
    }

    @JSONField(serialize = false)
    public boolean isChecked() {
        return this.mChecked;
    }

    public void setCharge_config(List<ChargeConfigBean> list) {
        this.charge_config = list;
    }

    @JSONField(serialize = false)
    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setIs_default(int i) {
        this.is_default = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpen_type(int i) {
        this.open_type = i;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public void setVip_config(List<ChargeConfigBean> list) {
        this.vip_config = list;
    }
}
