package com.yunbao.live.bean;

import defpackage.aq4;
import defpackage.m93;

/* loaded from: /tmp/classes2.dex */
public class GuardBuyBean {
    private int coin;
    private int id;
    private String name;
    private int[] privilege;
    private int type;

    public int getCoin() {
        return this.coin;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int[] getPrivilege() {
        return this.privilege;
    }

    public String getShopName() {
        int i = this.id;
        return i != 1 ? i != 2 ? i != 3 ? "" : aq4.a(m93.m2) : aq4.a(m93.l2) : aq4.a(m93.k2);
    }

    public int getType() {
        return this.type;
    }

    public void setCoin(int i) {
        this.coin = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPrivilege(int[] iArr) {
        this.privilege = iArr;
    }

    public void setType(int i) {
        this.type = i;
    }
}
