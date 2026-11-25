package com.yunbao.live.bean;

import defpackage.rv3;
import defpackage.t83;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveRoomTypeBean {
    private boolean mChecked;
    private int mCheckedIcon;
    private int mId;
    private String mName;
    private int mUnCheckedIcon;

    public LiveRoomTypeBean() {
    }

    public LiveRoomTypeBean(int i, String str) {
        this.mId = i;
        this.mName = str;
    }

    public LiveRoomTypeBean(int i, String str, int i2, int i3) {
        this.mId = i;
        this.mName = str;
        this.mCheckedIcon = i2;
        this.mUnCheckedIcon = i3;
    }

    public static List<LiveRoomTypeBean> getLiveTypeList(String[][] strArr) {
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String[] strArr2 : strArr) {
                LiveRoomTypeBean liveRoomTypeBean = new LiveRoomTypeBean(rv3.h(strArr2[0], 0), strArr2[1]);
                int id = liveRoomTypeBean.getId();
                if (id == 0) {
                    liveRoomTypeBean.setCheckedIcon(t83.C0);
                    liveRoomTypeBean.setUnCheckedIcon(t83.D0);
                } else if (id == 1) {
                    liveRoomTypeBean.setCheckedIcon(t83.G0);
                    liveRoomTypeBean.setUnCheckedIcon(t83.H0);
                } else if (id == 2) {
                    liveRoomTypeBean.setCheckedIcon(t83.E0);
                    liveRoomTypeBean.setUnCheckedIcon(t83.F0);
                } else if (id == 3) {
                    liveRoomTypeBean.setCheckedIcon(t83.I0);
                    liveRoomTypeBean.setUnCheckedIcon(t83.J0);
                }
                arrayList.add(liveRoomTypeBean);
            }
        }
        return arrayList;
    }

    public int getCheckedIcon() {
        return this.mCheckedIcon;
    }

    public int getId() {
        return this.mId;
    }

    public String getName() {
        return this.mName;
    }

    public int getUnCheckedIcon() {
        return this.mUnCheckedIcon;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setChecked(boolean z) {
        this.mChecked = z;
    }

    public void setCheckedIcon(int i) {
        this.mCheckedIcon = i;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUnCheckedIcon(int i) {
        this.mUnCheckedIcon = i;
    }
}
