package com.yunbao.mall.bean;

import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class GoodsRecordTitleBean extends GoodsRecordBean {
    private String mDate;
    private List<GoodsRecordItemBean> mItemList;
    private int mPosition;

    public String getDate() {
        return this.mDate;
    }

    public List<GoodsRecordItemBean> getItemList() {
        return this.mItemList;
    }

    public int getPosition() {
        return this.mPosition;
    }

    public boolean isItemAllChecked() {
        List<GoodsRecordItemBean> list = this.mItemList;
        if (list == null || list.size() == 0) {
            return false;
        }
        Iterator<GoodsRecordItemBean> it = this.mItemList.iterator();
        while (it.hasNext()) {
            if (!it.next().isChecked()) {
                return false;
            }
        }
        return true;
    }

    public void setDate(String str) {
        this.mDate = str;
    }

    public void setItemList(List<GoodsRecordItemBean> list) {
        this.mItemList = list;
    }

    public void setPosition(int i) {
        this.mPosition = i;
    }
}
