package com.yunbao.im.custom;

import android.content.Context;
import android.util.AttributeSet;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.dao.IMMessageBean;

/* loaded from: /tmp/classes2.dex */
public class MyImageView extends RoundedImageView {
    public ImMessageBean r;
    public IMMessageBean s;

    public MyImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IMMessageBean getIMMessageBean() {
        return this.s;
    }

    public ImMessageBean getImMessageBean() {
        return this.r;
    }

    public void setIMMessageBean(IMMessageBean iMMessageBean) {
        this.s = iMMessageBean;
    }

    public void setImMessageBean(ImMessageBean imMessageBean) {
        this.r = imMessageBean;
    }
}
