package com.yunbao.common.mob;

import defpackage.m93;
import defpackage.q83;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class MobBean {
    private boolean mChecked;
    private int mIcon1;
    private int mIcon2;
    private int mName;
    private String mType;

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
    public static List<MobBean> getLiveReadyShareTypeList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                MobBean mobBean = new MobBean();
                mobBean.setType(str);
                str.getClass();
                char c = 65535;
                switch (str.hashCode()) {
                    case -916346253:
                        if (str.equals("twitter")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3809:
                        if (str.equals("wx")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 112951375:
                        if (str.equals("wchat")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 497130182:
                        if (str.equals("facebook")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        mobBean.setIcon1(q83.J1);
                        mobBean.setIcon2(q83.K1);
                        break;
                    case 1:
                        mobBean.setIcon1(q83.N1);
                        mobBean.setIcon2(q83.O1);
                        break;
                    case 2:
                        mobBean.setIcon1(q83.F1);
                        mobBean.setIcon2(q83.G1);
                        break;
                    case 3:
                        mobBean.setIcon1(q83.B1);
                        mobBean.setIcon2(q83.C1);
                        break;
                }
                arrayList.add(mobBean);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
    public static List<MobBean> getLiveShareTypeList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                MobBean mobBean = new MobBean();
                mobBean.setType(str);
                str.getClass();
                char c = 65535;
                switch (str.hashCode()) {
                    case -916346253:
                        if (str.equals("twitter")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3809:
                        if (str.equals("wx")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 112951375:
                        if (str.equals("wchat")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 497130182:
                        if (str.equals("facebook")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        mobBean.setIcon1(q83.L1);
                        mobBean.setName(m93.K8);
                        break;
                    case 1:
                        mobBean.setIcon1(q83.P1);
                        mobBean.setName(m93.L8);
                        break;
                    case 2:
                        mobBean.setIcon1(q83.H1);
                        mobBean.setName(m93.M8);
                        break;
                    case 3:
                        mobBean.setIcon1(q83.D1);
                        mobBean.setName(m93.J8);
                        break;
                }
                arrayList.add(mobBean);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
    public static List<MobBean> getLoginTypeList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                MobBean mobBean = new MobBean();
                mobBean.setType(str);
                str.getClass();
                char c = 65535;
                switch (str.hashCode()) {
                    case -916346253:
                        if (str.equals("twitter")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3809:
                        if (str.equals("wx")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 497130182:
                        if (str.equals("facebook")) {
                            c = 2;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        mobBean.setIcon1(q83.v1);
                        break;
                    case 1:
                        mobBean.setIcon1(q83.w1);
                        break;
                    case 2:
                        mobBean.setIcon1(q83.u1);
                        break;
                }
                arrayList.add(mobBean);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
    public static List<MobBean> getVideoShareTypeList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str : strArr) {
                MobBean mobBean = new MobBean();
                mobBean.setType(str);
                str.getClass();
                char c = 65535;
                switch (str.hashCode()) {
                    case -916346253:
                        if (str.equals("twitter")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3809:
                        if (str.equals("wx")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 112951375:
                        if (str.equals("wchat")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 497130182:
                        if (str.equals("facebook")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        mobBean.setIcon1(q83.L1);
                        mobBean.setIcon2(q83.M1);
                        mobBean.setName(m93.K8);
                        break;
                    case 1:
                        mobBean.setIcon1(q83.P1);
                        mobBean.setIcon2(q83.Q1);
                        mobBean.setName(m93.L8);
                        break;
                    case 2:
                        mobBean.setIcon1(q83.H1);
                        mobBean.setIcon2(q83.I1);
                        mobBean.setName(m93.M8);
                        break;
                    case 3:
                        mobBean.setIcon1(q83.D1);
                        mobBean.setIcon2(q83.E1);
                        mobBean.setName(m93.J8);
                        break;
                }
                arrayList.add(mobBean);
            }
        }
        return arrayList;
    }

    public int getIcon1() {
        return this.mIcon1;
    }

    public int getIcon2() {
        return this.mIcon2;
    }

    public int getName() {
        return this.mName;
    }

    public String getType() {
        return this.mType;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setIcon1(int i) {
        this.mIcon1 = i;
    }

    public void setIcon2(int i) {
        this.mIcon2 = i;
    }

    public void setName(int i) {
        this.mName = i;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
