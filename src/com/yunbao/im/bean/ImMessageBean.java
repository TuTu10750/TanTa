package com.yunbao.im.bean;

import defpackage.j30;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public class ImMessageBean {
    public static final int STATUS_SEND_FAIL = 3;
    public static final int STATUS_SEND_ING = 1;
    public static final int STATUS_SEND_SUCC = 2;
    public static final int TYPE_GOODS = 5;
    public static final int TYPE_IMAGE = 2;
    public static final int TYPE_LOCATION = 4;
    public static final int TYPE_SOUND = 3;
    public static final int TYPE_TEXT = 1;
    private EntryMsgBean mEntryMsgBean;
    private boolean mRevoked;
    private String mShowTimeString;
    private int mStatus;
    private int mType;

    /* loaded from: /tmp/classes2.dex */
    public static abstract class EntryMsgBean {
        protected String mGroupId;
        protected String mMsgId;
        protected boolean mSelf;
        protected String mSenderId;
        protected long mTimestamp;

        public EntryMsgBean(String str, String str2, String str3, long j, boolean z) {
            this.mMsgId = str;
            this.mSenderId = str2;
            this.mGroupId = str3;
            this.mTimestamp = j * 1000;
            this.mSelf = z;
        }

        public String getGroupId() {
            String str = this.mGroupId;
            return str != null ? str : "";
        }

        public String getMsgId() {
            String str = this.mMsgId;
            return str != null ? str : "";
        }

        public String getSenderId() {
            String str = this.mSenderId;
            return str != null ? str : "";
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }

        public boolean isSelf() {
            return this.mSelf;
        }

        public void setMsgId(String str) {
            this.mMsgId = str;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class GoodsMsgBean extends EntryMsgBean {
        private String mGoodsId;

        public GoodsMsgBean(String str, String str2, String str3, long j, boolean z) {
            super(str, str2, str3, j, z);
        }

        public String getGoodsId() {
            return this.mGoodsId;
        }

        public void setGoodsId(String str) {
            this.mGoodsId = str;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class ImageMsgBean extends EntryMsgBean {
        private int mHeight;
        private String mLocalPath;
        private String mOriginImageUrl;
        private String mThumbImageUrl;
        private int mWidth;

        public ImageMsgBean(String str, String str2, String str3, long j, boolean z) {
            super(str, str2, str3, j, z);
        }

        public int getHeight() {
            return this.mHeight;
        }

        public String getLocalPath() {
            String str = this.mLocalPath;
            return str != null ? str : "";
        }

        public String getOriginImageUrl() {
            String str = this.mOriginImageUrl;
            return str != null ? str : "";
        }

        public String getThumbImageUrl() {
            String str = this.mThumbImageUrl;
            return str != null ? str : "";
        }

        public int getWidth() {
            return this.mWidth;
        }

        public void setHeight(int i) {
            if (this.mHeight == 0) {
                this.mHeight = i;
            }
        }

        public void setLocalPath(String str) {
            this.mLocalPath = str;
        }

        public void setOriginImageUrl(String str) {
            this.mOriginImageUrl = str;
        }

        public void setThumbImageUrl(String str) {
            this.mThumbImageUrl = str;
        }

        public void setWidth(int i) {
            if (this.mWidth == 0) {
                this.mWidth = i;
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class LocationMsgBean extends EntryMsgBean {
        private String mAddress;
        private double mLat;
        private double mLng;

        public LocationMsgBean(String str, String str2, String str3, long j, boolean z) {
            super(str, str2, str3, j, z);
        }

        public String getAddress() {
            String str = this.mAddress;
            return str != null ? str : "";
        }

        public double getLat() {
            return this.mLat;
        }

        public double getLng() {
            return this.mLng;
        }

        public void setAddress(String str) {
            this.mAddress = str;
        }

        public void setLat(double d) {
            this.mLat = d;
        }

        public void setLng(double d) {
            this.mLng = d;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class SoundMsgBean extends EntryMsgBean {
        private int mDuration;
        private File mSoundFile;

        public SoundMsgBean(String str, String str2, String str3, long j, boolean z) {
            super(str, str2, str3, j, z);
        }

        public int getDuration() {
            return this.mDuration;
        }

        public File getSoundFile() {
            if (this.mSoundFile == null) {
                this.mSoundFile = new File(j30.R, this.mMsgId);
            }
            return this.mSoundFile;
        }

        public boolean isRead() {
            if (this.mSelf) {
                return true;
            }
            return getSoundFile().exists();
        }

        public void setDuration(int i) {
            this.mDuration = i;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class TextMsgBean extends EntryMsgBean {
        private String mText;

        public TextMsgBean(String str, String str2, String str3, long j, boolean z) {
            super(str, str2, str3, j, z);
        }

        public String getText() {
            String str = this.mText;
            return str != null ? str : "";
        }

        public void setText(String str) {
            this.mText = str;
        }
    }

    public ImMessageBean(EntryMsgBean entryMsgBean, int i) {
        this.mEntryMsgBean = entryMsgBean;
        this.mType = i;
    }

    public ImMessageBean(EntryMsgBean entryMsgBean, int i, int i2) {
        this(entryMsgBean, i);
        this.mStatus = i2;
    }

    public GoodsMsgBean getGoodsBean() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean == null || !(entryMsgBean instanceof GoodsMsgBean)) {
            return null;
        }
        return (GoodsMsgBean) entryMsgBean;
    }

    public String getGroupId() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        return entryMsgBean != null ? entryMsgBean.getGroupId() : "";
    }

    public ImageMsgBean getImageBean() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean == null || !(entryMsgBean instanceof ImageMsgBean)) {
            return null;
        }
        return (ImageMsgBean) entryMsgBean;
    }

    public LocationMsgBean getLocationBean() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean == null || !(entryMsgBean instanceof LocationMsgBean)) {
            return null;
        }
        return (LocationMsgBean) entryMsgBean;
    }

    public String getMsgId() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        return entryMsgBean != null ? entryMsgBean.getMsgId() : "";
    }

    public String getSenderId() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        return entryMsgBean != null ? entryMsgBean.getSenderId() : "";
    }

    public String getShowTimeString() {
        return this.mShowTimeString;
    }

    public SoundMsgBean getSoundBean() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean == null || !(entryMsgBean instanceof SoundMsgBean)) {
            return null;
        }
        return (SoundMsgBean) entryMsgBean;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public String getTextMsgContent() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        return (entryMsgBean == null || !(entryMsgBean instanceof TextMsgBean)) ? "" : ((TextMsgBean) entryMsgBean).getText();
    }

    public long getTimestamp() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean != null) {
            return entryMsgBean.getTimestamp();
        }
        return 0L;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isRevoked() {
        return this.mRevoked;
    }

    public boolean isSelf() {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean != null) {
            return entryMsgBean.isSelf();
        }
        return false;
    }

    public void setMsgId(String str) {
        EntryMsgBean entryMsgBean = this.mEntryMsgBean;
        if (entryMsgBean != null) {
            entryMsgBean.setMsgId(str);
        }
    }

    public void setRevoked(boolean z) {
        this.mRevoked = z;
    }

    public void setShowTimeString(String str) {
        this.mShowTimeString = str;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }
}
