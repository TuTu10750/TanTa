package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.MessageOfflinePushInfo;
import java.io.Serializable;

/* loaded from: /tmp/classes2.dex */
public class V2TIMOfflinePushInfo implements Serializable {
    public static final String IOS_OFFLINE_PUSH_DEFAULT_SOUND = "default";
    public static final String IOS_OFFLINE_PUSH_NO_SOUND = "push.no_sound";
    public static final int IOS_OFFLINE_PUSH_TYPE_APNS = 0;
    public static final int IOS_OFFLINE_PUSH_TYPE_VOIP = 1;
    private MessageOfflinePushInfo messageOfflinePushInfo = new MessageOfflinePushInfo();

    public void disablePush(boolean z) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (z) {
            messageOfflinePushInfo.setPushFlag(1);
        } else {
            messageOfflinePushInfo.setPushFlag(0);
        }
    }

    public void enableIOSBackgroundNotification(boolean z) {
        this.messageOfflinePushInfo.getApnsConfig().setBackgroundNotification(z ? 1 : 0);
    }

    public String getAndroidSound() {
        return this.messageOfflinePushInfo.getAndroidConfig().getSoundFilePath();
    }

    public String getDesc() {
        return this.messageOfflinePushInfo.getDescription();
    }

    public byte[] getExt() {
        return this.messageOfflinePushInfo.getExtension();
    }

    public MessageOfflinePushInfo getMessageOfflinePushInfo() {
        return this.messageOfflinePushInfo;
    }

    public String getTitle() {
        return this.messageOfflinePushInfo.getTitle();
    }

    public boolean isDisablePush() {
        return this.messageOfflinePushInfo.getPushFlag() == 1;
    }

    public void setAndroidFCMChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setFCMChannelID(str);
    }

    public void setAndroidFCMImage(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setFCMImageUrl(str);
    }

    public void setAndroidHonorImage(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setHonorImageUrl(str);
    }

    public void setAndroidHonorImportance(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setHonorImportance(str);
    }

    public void setAndroidHuaWeiCategory(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setHuaWeiCategory(str);
    }

    public void setAndroidHuaWeiImage(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setHuaWeiImageUrl(str);
    }

    public void setAndroidMeizuNotifyType(int i) {
        this.messageOfflinePushInfo.getAndroidConfig().setMeizuNotifyType(i);
    }

    public void setAndroidOPPOCategory(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setOppoCategory(str);
    }

    public void setAndroidOPPOChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setOppoChannelID(str);
    }

    public void setAndroidOPPONotifyLevel(int i) {
        this.messageOfflinePushInfo.getAndroidConfig().setOppoNotifyLevel(i);
    }

    public void setAndroidSound(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setSoundFilePath(str);
    }

    public void setAndroidVIVOCategory(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setVivoCategory(str);
    }

    @Deprecated
    public void setAndroidVIVOClassification(int i) {
        this.messageOfflinePushInfo.getAndroidConfig().setVivoClassification(i);
    }

    public void setAndroidXiaoMiChannelID(String str) {
        this.messageOfflinePushInfo.getAndroidConfig().setXiaoMiChannelID(str);
    }

    public void setDesc(String str) {
        this.messageOfflinePushInfo.setDescription(str);
    }

    public void setExt(byte[] bArr) {
        this.messageOfflinePushInfo.setExtension(bArr);
    }

    public void setHarmonyCategory(String str) {
        this.messageOfflinePushInfo.getHarmonyConfig().setCategory(str);
    }

    public void setHarmonyImage(String str) {
        this.messageOfflinePushInfo.getHarmonyConfig().setImageUrl(str);
    }

    public void setIOSImage(String str) {
        this.messageOfflinePushInfo.getApnsConfig().setIOSImageUrl(str);
    }

    public void setIOSInterruptionLevel(String str) {
        this.messageOfflinePushInfo.getApnsConfig().setInterruptionLevel(str);
    }

    public void setIOSPushType(int i) {
        this.messageOfflinePushInfo.getApnsConfig().setIOSPushType(i);
    }

    public void setIOSSound(String str) {
        this.messageOfflinePushInfo.getApnsConfig().setSoundFilePath(str);
    }

    public void setIgnoreHarmonyBadge(boolean z) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (z) {
            messageOfflinePushInfo.getHarmonyConfig().setBadgeMode(1);
        } else {
            messageOfflinePushInfo.getHarmonyConfig().setBadgeMode(0);
        }
    }

    public void setIgnoreIOSBadge(boolean z) {
        MessageOfflinePushInfo messageOfflinePushInfo = this.messageOfflinePushInfo;
        if (z) {
            messageOfflinePushInfo.getApnsConfig().setBadgeMode(1);
        } else {
            messageOfflinePushInfo.getApnsConfig().setBadgeMode(0);
        }
    }

    public void setMessageOfflinePushInfo(MessageOfflinePushInfo messageOfflinePushInfo) {
        if (messageOfflinePushInfo == null) {
            messageOfflinePushInfo = new MessageOfflinePushInfo();
        }
        this.messageOfflinePushInfo = messageOfflinePushInfo;
    }

    public void setTitle(String str) {
        this.messageOfflinePushInfo.setTitle(str);
    }
}
