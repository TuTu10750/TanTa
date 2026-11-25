package com.yunbao.common.bean;

import android.view.View;
import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rx1;

/* loaded from: /tmp/classes2.dex */
public class LiveGiftBean {
    public static final int MARK_GUARD = 2;
    public static final int MARK_HOT = 1;
    public static final int MARK_LUCK = 3;
    public static final int MARK_NORMAL = 0;
    public static final int TYPE_DELUXE = 1;
    public static final int TYPE_DRAW = 3;
    public static final int TYPE_NORMAL = 0;
    private boolean checked;
    private String icon;
    private int id;
    private int mIsGlobal;
    private int mStickerId;
    private View mView;
    private int mark;
    private String name;
    private String nameEn;
    private int page;
    private String price;
    private int type;

    @JSONField(name = "gifticon")
    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    @JSONField(name = "isplatgift")
    public int getIsGlobal() {
        return this.mIsGlobal;
    }

    public int getMark() {
        return this.mark;
    }

    @JSONField(name = "giftname")
    public String getName() {
        return this.name;
    }

    @JSONField(name = "giftname_en")
    public String getNameEn() {
        return this.nameEn;
    }

    public String getNameTrans() {
        return rx1.h() ? this.name : this.nameEn;
    }

    public int getPage() {
        return this.page;
    }

    @JSONField(name = "needcoin")
    public String getPrice() {
        return this.price;
    }

    @JSONField(name = "sticker_id")
    public int getStickerId() {
        return this.mStickerId;
    }

    public int getType() {
        return this.type;
    }

    public View getView() {
        return this.mView;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isGlobal() {
        return this.mIsGlobal == 1;
    }

    public boolean isSticker() {
        return this.mStickerId != 0;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    @JSONField(name = "gifticon")
    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    @JSONField(name = "isplatgift")
    public void setIsGlobal(int i) {
        this.mIsGlobal = i;
    }

    public void setMark(int i) {
        this.mark = i;
    }

    @JSONField(name = "giftname")
    public void setName(String str) {
        this.name = str;
    }

    @JSONField(name = "giftname_en")
    public void setNameEn(String str) {
        this.nameEn = str;
    }

    public void setPage(int i) {
        this.page = i;
    }

    @JSONField(name = "needcoin")
    public void setPrice(String str) {
        this.price = str;
    }

    @JSONField(name = "sticker_id")
    public void setStickerId(int i) {
        this.mStickerId = i;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setView(View view) {
        this.mView = view;
    }
}
