package com.yunbao.im.custom;

import android.content.Context;
import android.util.AttributeSet;
import com.yunbao.common.custom.ZoomView;
import com.yunbao.im.bean.ImMessageBean;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class MyImageView2 extends ZoomView {
    public File W;
    public ImMessageBean f0;

    public MyImageView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public File getFile() {
        return this.W;
    }

    public ImMessageBean getImMessageBean() {
        return this.f0;
    }

    public void setFile(File file) {
        this.W = file;
    }

    public void setImMessageBean(ImMessageBean imMessageBean) {
        this.f0 = imMessageBean;
    }
}
