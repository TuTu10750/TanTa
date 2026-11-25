package com.yunbao.live.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.yunbao.common.bean.MsgStyleBean;

/* loaded from: /tmp/classes2.dex */
public class LiveChatBean {
    public static final int ENTER_ROOM = 3;
    public static final int GIFT = 2;
    public static final int LIGHT = 4;
    public static final int NORMAL = 0;
    public static final int RED_PACK = 5;
    public static final int SYSTEM = 1;
    public static final int SYSTEM_TOP = 6;
    private boolean anchor;
    private String content;
    private int guardType;
    private int heart;
    private String id;
    private int level;
    private String liangName;
    private boolean manager;
    private MsgStyleBean msgStyleBean;
    private int type;
    private String userNiceName;
    private int userType;
    private int vipType;

    public String getContent() {
        return this.content;
    }

    @JSONField(name = "guard_type")
    public int getGuardType() {
        return this.guardType;
    }

    public int getHeart() {
        return this.heart;
    }

    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

    @JSONField(name = "liangname")
    public String getLiangName() {
        return this.liangName;
    }

    public MsgStyleBean getMsgStyleBean() {
        return this.msgStyleBean;
    }

    public int getType() {
        return this.type;
    }

    @JSONField(name = "user_nickname")
    public String getUserNiceName() {
        return this.userNiceName;
    }

    public int getUserType() {
        return this.userType;
    }

    @JSONField(name = "vip_type")
    public int getVipType() {
        return this.vipType;
    }

    public boolean isAnchor() {
        return this.anchor;
    }

    public boolean isManager() {
        return this.manager;
    }

    public boolean isSuper() {
        return this.userType == 60;
    }

    public void setAnchor(boolean z) {
        this.anchor = z;
    }

    public void setContent(String str) {
        this.content = str;
    }

    @JSONField(name = "guard_type")
    public void setGuardType(int i) {
        this.guardType = i;
    }

    public void setHeart(int i) {
        this.heart = i;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    @JSONField(name = "liangname")
    public void setLiangName(String str) {
        if ("0".equals(str)) {
            return;
        }
        this.liangName = str;
    }

    public void setManager(boolean z) {
        this.manager = z;
    }

    public void setMsgStyleBean(MsgStyleBean msgStyleBean) {
        this.msgStyleBean = msgStyleBean;
    }

    public void setType(int i) {
        this.type = i;
    }

    @JSONField(name = "user_nickname")
    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    public void setUserType(int i) {
        this.userType = i;
    }

    @JSONField(name = "vip_type")
    public void setVipType(int i) {
        this.vipType = i;
    }
}
