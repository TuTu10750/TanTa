package com.yunbao.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ConfigBean {
    private String beautyAppId;
    private String beautyKey;
    private String coinName;
    private String downloadApkUrl;
    private int forceup;
    private int intervalTime;
    private int isPop;
    private int isup;
    private String kefu;
    private int leaderboard_switch;
    private List<LiveClassBean> liveClass;
    private String liveShareDes;
    private String liveShareTitle;
    private String[] liveTimeCoin;
    private String[][] liveType;
    private String liveWxShareUrl;
    private String live_notice;
    private List<Integer> live_pk_time;
    private String[] loginType;
    private String mAdInfo;
    private String mAgoraAppId;
    private int mOpenInstallSwitch;
    private String mShopSystemName;
    private String mWaterMarkUrl;
    private int maintainSwitch;
    private String maintainTips;
    private int priMsgSwitch;
    private int recharge_config = 1;
    private String scoreName;
    private String[] shareType;
    private String share_url;
    private String site;
    private String statisticsUrl;
    private String teenager_des;
    private String txCosAppId;
    private String txCosBucketName;
    private String txCosImagePath;
    private String txCosRegion;
    private String txCosVideoPath;
    private String updateDes;
    private String version;
    private int videoAuditSwitch;
    private String videoClass;
    private int videoCloudType;
    private String videoFreeDesc;
    private String videoQiNiuHost;
    private String videoShareDes;
    private String videoShareTitle;
    private String votesName;

    @JSONField(name = "guide")
    public String getAdInfo() {
        return this.mAdInfo;
    }

    @JSONField(name = "sw_app_id")
    public String getAgoraAppId() {
        return this.mAgoraAppId;
    }

    @JSONField(name = "sprout_appid")
    public String getBeautyAppId() {
        return this.beautyAppId;
    }

    @JSONField(name = "sprout_key")
    public String getBeautyKey() {
        return this.beautyKey;
    }

    @JSONField(name = "name_coin")
    public String getCoinName() {
        return this.coinName;
    }

    @JSONField(name = "apk_url")
    public String getDownloadApkUrl() {
        return this.downloadApkUrl;
    }

    public int getForceup() {
        return this.forceup;
    }

    @JSONField(name = "refresh_time")
    public int getIntervalTime() {
        return this.intervalTime;
    }

    @JSONField(name = "is_pop")
    public int getIsPop() {
        return this.isPop;
    }

    @JSONField(name = "isup")
    public int getIsup() {
        return this.isup;
    }

    @JSONField(name = "service_url")
    public String getKefu() {
        return this.kefu;
    }

    public int getLeaderboard_switch() {
        return this.leaderboard_switch;
    }

    @JSONField(name = "liveclass")
    public List<LiveClassBean> getLiveClass() {
        return this.liveClass;
    }

    @JSONField(name = "share_des")
    public String getLiveShareDes() {
        return this.liveShareDes;
    }

    @JSONField(name = "share_title")
    public String getLiveShareTitle() {
        return this.liveShareTitle;
    }

    @JSONField(name = "live_time_coin")
    public String[] getLiveTimeCoin() {
        return this.liveTimeCoin;
    }

    @JSONField(name = "live_type")
    public String[][] getLiveType() {
        return this.liveType;
    }

    @JSONField(name = "wx_siteurl")
    public String getLiveWxShareUrl() {
        return this.liveWxShareUrl;
    }

    public String getLive_notice() {
        return this.live_notice;
    }

    @JSONField(name = "live_pk_time")
    public List<Integer> getLive_pk_time() {
        return this.live_pk_time;
    }

    @JSONField(name = "login_type")
    public String[] getLoginType() {
        return this.loginType;
    }

    @JSONField(name = "maintain_switch")
    public int getMaintainSwitch() {
        return this.maintainSwitch;
    }

    @JSONField(name = "maintain_tips")
    public String getMaintainTips() {
        return this.maintainTips;
    }

    @JSONField(name = "openinstall_switch")
    public int getOpenInstallSwitch() {
        return this.mOpenInstallSwitch;
    }

    @JSONField(name = "letter_switch")
    public int getPriMsgSwitch() {
        return this.priMsgSwitch;
    }

    public int getRecharge_config() {
        return this.recharge_config;
    }

    @JSONField(name = "name_score")
    public String getScoreName() {
        return this.scoreName;
    }

    @JSONField(name = "share_type")
    public String[] getShareType() {
        return this.shareType;
    }

    public String getShare_url() {
        return this.share_url;
    }

    @JSONField(name = "shop_system_name")
    public String getShopSystemName() {
        return this.mShopSystemName;
    }

    public String getSite() {
        return this.site;
    }

    @JSONField(name = "statistics_url")
    public String getStatisticsUrl() {
        return this.statisticsUrl;
    }

    public String getTeenager_des() {
        return this.teenager_des;
    }

    @JSONField(name = "txcloud_appid")
    public String getTxCosAppId() {
        return this.txCosAppId;
    }

    @JSONField(name = "txcloud_bucket")
    public String getTxCosBucketName() {
        return this.txCosBucketName;
    }

    @JSONField(name = "tximgfolder")
    public String getTxCosImagePath() {
        return this.txCosImagePath;
    }

    @JSONField(name = "txcloud_region")
    public String getTxCosRegion() {
        return this.txCosRegion;
    }

    @JSONField(name = "txvideofolder")
    public String getTxCosVideoPath() {
        return this.txCosVideoPath;
    }

    @JSONField(name = " ")
    public String getUpdateDes() {
        return this.updateDes;
    }

    @JSONField(name = "apk_ver")
    public String getVersion() {
        return this.version;
    }

    @JSONField(name = "video_audit_switch")
    public int getVideoAuditSwitch() {
        return this.videoAuditSwitch;
    }

    @JSONField(name = "videoclass")
    public String getVideoClass() {
        return this.videoClass;
    }

    @JSONField(name = "cloudtype")
    public int getVideoCloudType() {
        return this.videoCloudType;
    }

    @JSONField(name = "video_free_desc")
    public String getVideoFreeDesc() {
        return this.videoFreeDesc;
    }

    @JSONField(name = "qiniu_domain")
    public String getVideoQiNiuHost() {
        return this.videoQiNiuHost;
    }

    @JSONField(name = "video_share_des")
    public String getVideoShareDes() {
        return this.videoShareDes;
    }

    @JSONField(name = "video_share_title")
    public String getVideoShareTitle() {
        return this.videoShareTitle;
    }

    public String[] getVideoShareTypes() {
        return this.shareType;
    }

    @JSONField(name = "name_votes")
    public String getVotesName() {
        return this.votesName;
    }

    @JSONField(name = "video_watermark")
    public String getWaterMarkUrl() {
        return this.mWaterMarkUrl;
    }

    @JSONField(name = "guide")
    public void setAdInfo(String str) {
        this.mAdInfo = str;
    }

    @JSONField(name = "sw_app_id")
    public void setAgoraAppId(String str) {
        this.mAgoraAppId = str;
    }

    @JSONField(name = "sprout_appid")
    public void setBeautyAppId(String str) {
        this.beautyAppId = str;
    }

    @JSONField(name = "sprout_key")
    public void setBeautyKey(String str) {
        this.beautyKey = str;
    }

    @JSONField(name = "name_coin")
    public void setCoinName(String str) {
        this.coinName = str;
    }

    @JSONField(name = "apk_url")
    public void setDownloadApkUrl(String str) {
        this.downloadApkUrl = str;
    }

    public void setForceup(int i) {
        this.forceup = i;
    }

    @JSONField(name = "refresh_time")
    public void setIntervalTime(int i) {
        this.intervalTime = i;
    }

    @JSONField(name = "is_pop")
    public void setIsPop(int i) {
        this.isPop = i;
    }

    @JSONField(name = "isup")
    public void setIsup(int i) {
        this.isup = i;
    }

    @JSONField(name = "service_url")
    public void setKefu(String str) {
        this.kefu = str;
    }

    public void setLeaderboard_switch(int i) {
        this.leaderboard_switch = i;
    }

    @JSONField(name = "liveclass")
    public void setLiveClass(List<LiveClassBean> list) {
        this.liveClass = list;
    }

    @JSONField(name = "share_des")
    public void setLiveShareDes(String str) {
        this.liveShareDes = str;
    }

    @JSONField(name = "share_title")
    public void setLiveShareTitle(String str) {
        this.liveShareTitle = str;
    }

    @JSONField(name = "live_time_coin")
    public void setLiveTimeCoin(String[] strArr) {
        this.liveTimeCoin = strArr;
    }

    @JSONField(name = "live_type")
    public void setLiveType(String[][] strArr) {
        this.liveType = strArr;
    }

    @JSONField(name = "wx_siteurl")
    public void setLiveWxShareUrl(String str) {
        this.liveWxShareUrl = str;
    }

    public void setLive_notice(String str) {
        this.live_notice = str;
    }

    @JSONField(name = "live_pk_time")
    public void setLive_pk_time(List<Integer> list) {
        this.live_pk_time = list;
    }

    @JSONField(name = "login_type")
    public void setLoginType(String[] strArr) {
        this.loginType = strArr;
    }

    @JSONField(name = "maintain_switch")
    public void setMaintainSwitch(int i) {
        this.maintainSwitch = i;
    }

    @JSONField(name = "maintain_tips")
    public void setMaintainTips(String str) {
        this.maintainTips = str;
    }

    @JSONField(name = "openinstall_switch")
    public void setOpenInstallSwitch(int i) {
        this.mOpenInstallSwitch = i;
    }

    @JSONField(name = "letter_switch")
    public void setPriMsgSwitch(int i) {
        this.priMsgSwitch = i;
    }

    public void setRecharge_config(int i) {
        this.recharge_config = i;
    }

    @JSONField(name = "name_score")
    public void setScoreName(String str) {
        this.scoreName = str;
    }

    @JSONField(name = "share_type")
    public void setShareType(String[] strArr) {
        this.shareType = strArr;
    }

    public void setShare_url(String str) {
        this.share_url = str;
    }

    @JSONField(name = "shop_system_name")
    public void setShopSystemName(String str) {
        this.mShopSystemName = str;
    }

    public void setSite(String str) {
        this.site = str;
    }

    @JSONField(name = "statistics_url")
    public void setStatisticsUrl(String str) {
        this.statisticsUrl = str;
    }

    public void setTeenager_des(String str) {
        this.teenager_des = str;
    }

    @JSONField(name = "txcloud_appid")
    public void setTxCosAppId(String str) {
        this.txCosAppId = str;
    }

    @JSONField(name = "txcloud_bucket")
    public void setTxCosBucketName(String str) {
        this.txCosBucketName = str;
    }

    @JSONField(name = "tximgfolder")
    public void setTxCosImagePath(String str) {
        this.txCosImagePath = str;
    }

    @JSONField(name = "txcloud_region")
    public void setTxCosRegion(String str) {
        this.txCosRegion = str;
    }

    @JSONField(name = "txvideofolder")
    public void setTxCosVideoPath(String str) {
        this.txCosVideoPath = str;
    }

    @JSONField(name = "apk_des")
    public void setUpdateDes(String str) {
        this.updateDes = str;
    }

    @JSONField(name = "apk_ver")
    public void setVersion(String str) {
        this.version = str;
    }

    @JSONField(name = "video_audit_switch")
    public void setVideoAuditSwitch(int i) {
        this.videoAuditSwitch = i;
    }

    @JSONField(name = "videoclass")
    public void setVideoClass(String str) {
        this.videoClass = str;
    }

    @JSONField(name = "cloudtype")
    public void setVideoCloudType(int i) {
        this.videoCloudType = i;
    }

    @JSONField(name = "video_free_desc")
    public void setVideoFreeDesc(String str) {
        this.videoFreeDesc = str;
    }

    @JSONField(name = "qiniu_domain")
    public void setVideoQiNiuHost(String str) {
        this.videoQiNiuHost = str;
    }

    @JSONField(name = "video_share_des")
    public void setVideoShareDes(String str) {
        this.videoShareDes = str;
    }

    @JSONField(name = "video_share_title")
    public void setVideoShareTitle(String str) {
        this.videoShareTitle = str;
    }

    @JSONField(name = "name_votes")
    public void setVotesName(String str) {
        this.votesName = str;
    }

    @JSONField(name = "video_watermark")
    public void setWaterMarkUrl(String str) {
        this.mWaterMarkUrl = str;
    }
}
