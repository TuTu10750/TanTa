package com.yunbao.live.bean;

import android.graphics.PointF;
import android.text.TextUtils;
import com.alibaba.fastjson.annotation.JSONField;
import defpackage.rv3;
import defpackage.rx1;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class LiveReceiveGiftBean {
    private String avatar;
    private int gifType;
    private String gifUrl;
    private int giftCount;
    private String giftIcon;
    private String giftId;
    private String giftName;
    private int level;
    private int lianCount = 1;
    private float mDrawHeight;
    private float mDrawWidth;
    private String mGiftNameEn;
    private int mIsGlobal;
    private String mKey;
    private int mLuck;
    private String mLuckTime;
    private int mMark;
    private float mPlayTime;
    private List<PointF> mPointList;
    private String mStickerId;
    private String toName;
    private String toUid;
    private int type;
    private String uid;
    private String userNiceName;
    private String votes;

    public String getAvatar() {
        return this.avatar;
    }

    public float getDrawHeight() {
        return this.mDrawHeight;
    }

    public float getDrawWidth() {
        return this.mDrawWidth;
    }

    @JSONField(name = "swftype")
    public int getGifType() {
        return this.gifType;
    }

    @JSONField(name = "swf")
    public String getGifUrl() {
        return this.gifUrl;
    }

    @JSONField(name = "giftcount")
    public int getGiftCount() {
        return this.giftCount;
    }

    @JSONField(name = "gifticon")
    public String getGiftIcon() {
        return this.giftIcon;
    }

    @JSONField(name = "giftid")
    public String getGiftId() {
        return this.giftId;
    }

    @JSONField(name = "giftname")
    public String getGiftName() {
        return "en".equals(rx1.c().d()) ? this.mGiftNameEn : this.giftName;
    }

    @JSONField(name = "giftname_en")
    public String getGiftNameEn() {
        return this.mGiftNameEn;
    }

    @JSONField(name = "isplatgift")
    public int getIsGlobal() {
        return this.mIsGlobal;
    }

    public String getKey() {
        if (TextUtils.isEmpty(this.mKey)) {
            this.mKey = rv3.a(this.uid, this.toUid, this.giftId, String.valueOf(this.giftCount));
        }
        return this.mKey;
    }

    @JSONField(name = "level")
    public int getLevel() {
        return this.level;
    }

    public int getLianCount() {
        return this.lianCount;
    }

    @JSONField(name = "isluck")
    public int getLuck() {
        return this.mLuck;
    }

    @JSONField(name = "lucktimes")
    public String getLuckTime() {
        return this.mLuckTime;
    }

    @JSONField(name = "mark")
    public int getMark() {
        return this.mMark;
    }

    @JSONField(name = "swftime")
    public float getPlayTime() {
        return this.mPlayTime;
    }

    public List<PointF> getPointList() {
        return this.mPointList;
    }

    @JSONField(name = "sticker_id")
    public String getStickerId() {
        return this.mStickerId;
    }

    @JSONField(name = "to_username")
    public String getToName() {
        return this.toName;
    }

    @JSONField(name = "touid")
    public String getToUid() {
        return this.toUid;
    }

    @JSONField(name = "type")
    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserNiceName() {
        return this.userNiceName;
    }

    @JSONField(name = "votestotal")
    public String getVotes() {
        return this.votes;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setDrawHeight(float f) {
        this.mDrawHeight = f;
    }

    public void setDrawWidth(float f) {
        this.mDrawWidth = f;
    }

    @JSONField(name = "type")
    public void setGif(int i) {
        this.type = i;
    }

    @JSONField(name = "swftype")
    public void setGifType(int i) {
        this.gifType = i;
    }

    @JSONField(name = "swf")
    public void setGifUrl(String str) {
        this.gifUrl = str;
    }

    @JSONField(name = "giftcount")
    public void setGiftCount(int i) {
        this.giftCount = i;
    }

    @JSONField(name = "gifticon")
    public void setGiftIcon(String str) {
        this.giftIcon = str;
    }

    @JSONField(name = "giftid")
    public void setGiftId(String str) {
        this.giftId = str;
    }

    @JSONField(name = "giftname")
    public void setGiftName(String str) {
        this.giftName = str;
    }

    @JSONField(name = "giftname_en")
    public void setGiftNameEn(String str) {
        this.mGiftNameEn = str;
    }

    @JSONField(name = "isplatgift")
    public void setIsGlobal(int i) {
        this.mIsGlobal = i;
    }

    @JSONField(name = "level")
    public void setLevel(int i) {
        this.level = i;
    }

    public void setLianCount(int i) {
        this.lianCount = i;
    }

    @JSONField(name = "isluck")
    public void setLuck(int i) {
        this.mLuck = i;
    }

    @JSONField(name = "lucktimes")
    public void setLuckTime(String str) {
        this.mLuckTime = str;
    }

    @JSONField(name = "mark")
    public void setMark(int i) {
        this.mMark = i;
    }

    @JSONField(name = "swftime")
    public void setPlayTime(float f) {
        this.mPlayTime = f;
    }

    public void setPointList(List<PointF> list) {
        this.mPointList = list;
    }

    @JSONField(name = "sticker_id")
    public void setStickerId(String str) {
        this.mStickerId = str;
    }

    @JSONField(name = "to_username")
    public void setToName(String str) {
        this.toName = str;
    }

    @JSONField(name = "touid")
    public void setToUid(String str) {
        this.toUid = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserNiceName(String str) {
        this.userNiceName = str;
    }

    @JSONField(name = "votestotal")
    public void setVotes(String str) {
        this.votes = str;
    }
}
