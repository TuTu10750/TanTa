package com.yunbao.mall.bean;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import okhttp3.HttpUrl;

/* loaded from: /tmp/classes2.dex */
public class GoodsCommentBean {
    private GoodsCommentBean mAppendBean;
    private String mAppendComment;
    private String mAvatar;
    private String mBuyerName;
    private String mContent;
    private String mDateTime;
    private String mDateTip;
    private String mGoodsId;
    private String mGoodsSpecName;
    private int mHasAppend;
    private String mId;
    private List<String> mImageList;
    private int mIsAppend;
    private String mOrderId;
    private String mSellerId;
    private int mStarCount;
    private String mThumbs;
    private String mUid;
    private String mVideoThumb;
    private String mVideoUrl;

    @JSONField(name = "append_comment")
    public String getAppendComment() {
        return this.mAppendComment;
    }

    public GoodsCommentBean getAppendCommentBean() {
        if (this.mHasAppend == 1 && this.mAppendBean == null && !TextUtils.isEmpty(this.mAppendComment) && this.mAppendComment.startsWith("{")) {
            try {
                this.mAppendBean = (GoodsCommentBean) JSON.parseObject(this.mAppendComment, GoodsCommentBean.class);
            } catch (Exception unused) {
            }
        }
        return this.mAppendBean;
    }

    @JSONField(name = "avatar")
    public String getAvatar() {
        return this.mAvatar;
    }

    @JSONField(name = "user_nickname")
    public String getBuyerName() {
        return this.mBuyerName;
    }

    @JSONField(name = "content")
    public String getContent() {
        return this.mContent;
    }

    @JSONField(name = "time_format")
    public String getDateTime() {
        return this.mDateTime;
    }

    @JSONField(name = "date_tips")
    public String getDateTip() {
        return this.mDateTip;
    }

    @JSONField(name = "goodsid")
    public String getGoodsId() {
        return this.mGoodsId;
    }

    @JSONField(name = "spec_name")
    public String getGoodsSpecName() {
        return this.mGoodsSpecName;
    }

    @JSONField(name = "has_append_comment")
    public int getHasAppend() {
        return this.mHasAppend;
    }

    @JSONField(name = "id")
    public String getId() {
        return this.mId;
    }

    public List<String> getImageList() {
        if (this.mImageList == null) {
            this.mImageList = JSON.parseArray(this.mThumbs, String.class);
            if (!TextUtils.isEmpty(this.mVideoThumb)) {
                this.mImageList.add(0, this.mVideoThumb);
            }
        }
        return this.mImageList;
    }

    @JSONField(name = "is_append")
    public int getIsAppend() {
        return this.mIsAppend;
    }

    @JSONField(name = "orderid")
    public String getOrderId() {
        return this.mOrderId;
    }

    @JSONField(name = "shop_uid")
    public String getSellerId() {
        return this.mSellerId;
    }

    @JSONField(name = "quality_points")
    public int getStarCount() {
        return this.mStarCount;
    }

    @JSONField(name = "thumb_format")
    public String getThumbs() {
        return this.mThumbs;
    }

    @JSONField(name = "uid")
    public String getUid() {
        return this.mUid;
    }

    @JSONField(name = "video_thumb")
    public String getVideoThumb() {
        return this.mVideoThumb;
    }

    @JSONField(name = "video_url")
    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public boolean hasImgOrVideo() {
        return ((TextUtils.isEmpty(this.mVideoUrl) || TextUtils.isEmpty(this.mVideoThumb)) && HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(this.mThumbs)) ? false : true;
    }

    @JSONField(name = "append_comment")
    public void setAppendComment(String str) {
        this.mAppendComment = str;
    }

    @JSONField(name = "avatar")
    public void setAvatar(String str) {
        this.mAvatar = str;
    }

    @JSONField(name = "user_nickname")
    public void setBuyerName(String str) {
        this.mBuyerName = str;
    }

    @JSONField(name = "content")
    public void setContent(String str) {
        this.mContent = str;
    }

    @JSONField(name = "time_format")
    public void setDateTime(String str) {
        this.mDateTime = str;
    }

    @JSONField(name = "date_tips")
    public void setDateTip(String str) {
        this.mDateTip = str;
    }

    @JSONField(name = "goodsid")
    public void setGoodsId(String str) {
        this.mGoodsId = str;
    }

    @JSONField(name = "spec_name")
    public void setGoodsSpecName(String str) {
        this.mGoodsSpecName = str;
    }

    @JSONField(name = "has_append_comment")
    public void setHasAppend(int i) {
        this.mHasAppend = i;
    }

    @JSONField(name = "id")
    public void setId(String str) {
        this.mId = str;
    }

    @JSONField(name = "is_append")
    public void setIsAppend(int i) {
        this.mIsAppend = i;
    }

    @JSONField(name = "orderid")
    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    @JSONField(name = "shop_uid")
    public void setSellerId(String str) {
        this.mSellerId = str;
    }

    @JSONField(name = "quality_points")
    public void setStarCount(int i) {
        this.mStarCount = i;
    }

    @JSONField(name = "thumb_format")
    public void setThumbs(String str) {
        this.mThumbs = str;
    }

    @JSONField(name = "uid")
    public void setUid(String str) {
        this.mUid = str;
    }

    @JSONField(name = "video_thumb")
    public void setVideoThumb(String str) {
        this.mVideoThumb = str;
    }

    @JSONField(name = "video_url")
    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }
}
