package com.yunbao.common.http;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class JJBean {
    private DataBean data;
    private DebugBean debug;
    private String msg;
    private int ret;

    /* loaded from: /tmp/classes2.dex */
    public static class DataBean {
        private int code;
        private List<InfoBean> info;
        private String msg;

        /* loaded from: /tmp/classes2.dex */
        public static class InfoBean {
            private String address;
            private String apk_des;
            private String apk_ewm;
            private String apk_url;
            private String apk_ver;
            private String app_android;
            private String app_ios;
            private String big_eye;
            private String brightness;
            private String chin_lift;
            private String cloudtype;
            private String company_desc;
            private String company_name;
            private String copyright_url;
            private String eye_alat;
            private String eye_brow;
            private String eye_corner;
            private String eye_length;
            private String face_lift;
            private String face_shave;
            private String forehead_lift;
            private GuideBean guide;
            private String ios_shelves;
            private String ipa_des;
            private String ipa_ewm;
            private String ipa_url;
            private String ipa_ver;
            private String isup;
            private String leaderboard_switch;
            private String lengthen_noseLift;
            private String letter_switch;
            private List<LevelBean> level;
            private List<LevelanchorBean> levelanchor;
            private List<String> live_time_coin;
            private List<List<String>> live_type;
            private List<LiveclassBean> liveclass;
            private String login_alert_content;
            private String login_alert_content_en;
            private String login_alert_title;
            private String login_alert_title_en;
            private String login_clause_title;
            private String login_clause_title_en;
            private String login_img;
            private String login_img_en;
            private String login_img_old;
            private String login_private_title;
            private String login_private_title_en;
            private String login_private_url;
            private String login_service_title;
            private String login_service_title_en;
            private String login_service_url;
            private List<?> login_type;
            private String maintain_switch;
            private String maintain_tips;
            private String mobile;
            private String mouse_lift;
            private String name_coin;
            private String name_score;
            private String name_votes;
            private String nose_lift;
            private String openinstall_switch;
            private String payment_percent;
            private String payment_time;
            private String qiniu_domain;
            private String qiniu_region;
            private Object qiniu_sign;
            private String qiniu_uphost;
            private List<String> sensitive_words;
            private String share_des;
            private String share_title;
            private List<?> share_type;
            private String shop_system_name;
            private String shopexplain_url;
            private String site;
            private String site_name;
            private String site_name_en;
            private String skin_smooth;
            private String skin_tenderness;
            private String skin_whiting;
            private String socket_url;
            private String sprout_appid;
            private String sprout_appid_ios;
            private String sprout_key;
            private String sprout_key_ios;
            private String stricker_url;
            private String sw_app_id;
            private String teenager_des;
            private String txcloud_appid;
            private String txcloud_bucket;
            private String txcloud_region;
            private String tximgfolder;
            private String txvideofolder;
            private String video_audit_switch;
            private String video_share_des;
            private String video_share_title;
            private String video_watermark;
            private List<VideoclassBean> videoclass;
            private String wechat_ewm;
            private String wx_siteurl;
            private String wxmini_des;
            private String wxmini_shelves_version;
            private String wxmini_version;

            /* loaded from: /tmp/classes2.dex */
            public static class GuideBean {
                private List<?> list;

                @SerializedName("switch")
                private String switchX;
                private String time;
                private String type;

                public List<?> getList() {
                    return this.list;
                }

                public String getSwitchX() {
                    return this.switchX;
                }

                public String getTime() {
                    return this.time;
                }

                public String getType() {
                    return this.type;
                }

                public void setList(List<?> list) {
                    this.list = list;
                }

                public void setSwitchX(String str) {
                    this.switchX = str;
                }

                public void setTime(String str) {
                    this.time = str;
                }

                public void setType(String str) {
                    this.type = str;
                }
            }

            /* loaded from: /tmp/classes2.dex */
            public static class LevelBean {
                private String bg;
                private String colour;
                private int levelid;
                private String levelname_en;
                private String thumb;
                private String thumb_mark;

                public String getBg() {
                    return this.bg;
                }

                public String getColour() {
                    return this.colour;
                }

                public int getLevelid() {
                    return this.levelid;
                }

                public String getLevelname_en() {
                    return this.levelname_en;
                }

                public String getThumb() {
                    return this.thumb;
                }

                public String getThumb_mark() {
                    return this.thumb_mark;
                }

                public void setBg(String str) {
                    this.bg = str;
                }

                public void setColour(String str) {
                    this.colour = str;
                }

                public void setLevelid(int i) {
                    this.levelid = i;
                }

                public void setLevelname_en(String str) {
                    this.levelname_en = str;
                }

                public void setThumb(String str) {
                    this.thumb = str;
                }

                public void setThumb_mark(String str) {
                    this.thumb_mark = str;
                }
            }

            /* loaded from: /tmp/classes2.dex */
            public static class LevelanchorBean {
                private String bg;
                private int levelid;
                private String levelname_en;
                private String thumb;
                private String thumb_mark;

                public String getBg() {
                    return this.bg;
                }

                public int getLevelid() {
                    return this.levelid;
                }

                public String getLevelname_en() {
                    return this.levelname_en;
                }

                public String getThumb() {
                    return this.thumb;
                }

                public String getThumb_mark() {
                    return this.thumb_mark;
                }

                public void setBg(String str) {
                    this.bg = str;
                }

                public void setLevelid(int i) {
                    this.levelid = i;
                }

                public void setLevelname_en(String str) {
                    this.levelname_en = str;
                }

                public void setThumb(String str) {
                    this.thumb = str;
                }

                public void setThumb_mark(String str) {
                    this.thumb_mark = str;
                }
            }

            /* loaded from: /tmp/classes2.dex */
            public static class LiveclassBean {
                private String des;
                private String id;
                private int list_order;
                private String name;
                private String thumb;

                public String getDes() {
                    return this.des;
                }

                public String getId() {
                    return this.id;
                }

                public int getList_order() {
                    return this.list_order;
                }

                public String getName() {
                    return this.name;
                }

                public String getThumb() {
                    return this.thumb;
                }

                public void setDes(String str) {
                    this.des = str;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setList_order(int i) {
                    this.list_order = i;
                }

                public void setName(String str) {
                    this.name = str;
                }

                public void setThumb(String str) {
                    this.thumb = str;
                }
            }

            /* loaded from: /tmp/classes2.dex */
            public static class VideoclassBean {
                private String id;
                private String list_order;
                private String name;

                public String getId() {
                    return this.id;
                }

                public String getList_order() {
                    return this.list_order;
                }

                public String getName() {
                    return this.name;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setList_order(String str) {
                    this.list_order = str;
                }

                public void setName(String str) {
                    this.name = str;
                }
            }

            public String getAddress() {
                return this.address;
            }

            public String getApk_des() {
                return this.apk_des;
            }

            public String getApk_ewm() {
                return this.apk_ewm;
            }

            public String getApk_url() {
                return this.apk_url;
            }

            public String getApk_ver() {
                return this.apk_ver;
            }

            public String getApp_android() {
                return this.app_android;
            }

            public String getApp_ios() {
                return this.app_ios;
            }

            public String getBig_eye() {
                return this.big_eye;
            }

            public String getBrightness() {
                return this.brightness;
            }

            public String getChin_lift() {
                return this.chin_lift;
            }

            public String getCloudtype() {
                return this.cloudtype;
            }

            public String getCompany_desc() {
                return this.company_desc;
            }

            public String getCompany_name() {
                return this.company_name;
            }

            public String getCopyright_url() {
                return this.copyright_url;
            }

            public String getEye_alat() {
                return this.eye_alat;
            }

            public String getEye_brow() {
                return this.eye_brow;
            }

            public String getEye_corner() {
                return this.eye_corner;
            }

            public String getEye_length() {
                return this.eye_length;
            }

            public String getFace_lift() {
                return this.face_lift;
            }

            public String getFace_shave() {
                return this.face_shave;
            }

            public String getForehead_lift() {
                return this.forehead_lift;
            }

            public GuideBean getGuide() {
                return this.guide;
            }

            public String getIos_shelves() {
                return this.ios_shelves;
            }

            public String getIpa_des() {
                return this.ipa_des;
            }

            public String getIpa_ewm() {
                return this.ipa_ewm;
            }

            public String getIpa_url() {
                return this.ipa_url;
            }

            public String getIpa_ver() {
                return this.ipa_ver;
            }

            public String getIsup() {
                return this.isup;
            }

            public String getLeaderboard_switch() {
                return this.leaderboard_switch;
            }

            public String getLengthen_noseLift() {
                return this.lengthen_noseLift;
            }

            public String getLetter_switch() {
                return this.letter_switch;
            }

            public List<LevelBean> getLevel() {
                return this.level;
            }

            public List<LevelanchorBean> getLevelanchor() {
                return this.levelanchor;
            }

            public List<String> getLive_time_coin() {
                return this.live_time_coin;
            }

            public List<List<String>> getLive_type() {
                return this.live_type;
            }

            public List<LiveclassBean> getLiveclass() {
                return this.liveclass;
            }

            public String getLogin_alert_content() {
                return this.login_alert_content;
            }

            public String getLogin_alert_content_en() {
                return this.login_alert_content_en;
            }

            public String getLogin_alert_title() {
                return this.login_alert_title;
            }

            public String getLogin_alert_title_en() {
                return this.login_alert_title_en;
            }

            public String getLogin_clause_title() {
                return this.login_clause_title;
            }

            public String getLogin_clause_title_en() {
                return this.login_clause_title_en;
            }

            public String getLogin_img() {
                return this.login_img;
            }

            public String getLogin_img_en() {
                return this.login_img_en;
            }

            public String getLogin_img_old() {
                return this.login_img_old;
            }

            public String getLogin_private_title() {
                return this.login_private_title;
            }

            public String getLogin_private_title_en() {
                return this.login_private_title_en;
            }

            public String getLogin_private_url() {
                return this.login_private_url;
            }

            public String getLogin_service_title() {
                return this.login_service_title;
            }

            public String getLogin_service_title_en() {
                return this.login_service_title_en;
            }

            public String getLogin_service_url() {
                return this.login_service_url;
            }

            public List<?> getLogin_type() {
                return this.login_type;
            }

            public String getMaintain_switch() {
                return this.maintain_switch;
            }

            public String getMaintain_tips() {
                return this.maintain_tips;
            }

            public String getMobile() {
                return this.mobile;
            }

            public String getMouse_lift() {
                return this.mouse_lift;
            }

            public String getName_coin() {
                return this.name_coin;
            }

            public String getName_score() {
                return this.name_score;
            }

            public String getName_votes() {
                return this.name_votes;
            }

            public String getNose_lift() {
                return this.nose_lift;
            }

            public String getOpeninstall_switch() {
                return this.openinstall_switch;
            }

            public String getPayment_percent() {
                return this.payment_percent;
            }

            public String getPayment_time() {
                return this.payment_time;
            }

            public String getQiniu_domain() {
                return this.qiniu_domain;
            }

            public String getQiniu_region() {
                return this.qiniu_region;
            }

            public Object getQiniu_sign() {
                return this.qiniu_sign;
            }

            public String getQiniu_uphost() {
                return this.qiniu_uphost;
            }

            public List<String> getSensitive_words() {
                return this.sensitive_words;
            }

            public String getShare_des() {
                return this.share_des;
            }

            public String getShare_title() {
                return this.share_title;
            }

            public List<?> getShare_type() {
                return this.share_type;
            }

            public String getShop_system_name() {
                return this.shop_system_name;
            }

            public String getShopexplain_url() {
                return this.shopexplain_url;
            }

            public String getSite() {
                return this.site;
            }

            public String getSite_name() {
                return this.site_name;
            }

            public String getSite_name_en() {
                return this.site_name_en;
            }

            public String getSkin_smooth() {
                return this.skin_smooth;
            }

            public String getSkin_tenderness() {
                return this.skin_tenderness;
            }

            public String getSkin_whiting() {
                return this.skin_whiting;
            }

            public String getSocket_url() {
                return this.socket_url;
            }

            public String getSprout_appid() {
                return this.sprout_appid;
            }

            public String getSprout_appid_ios() {
                return this.sprout_appid_ios;
            }

            public String getSprout_key() {
                return this.sprout_key;
            }

            public String getSprout_key_ios() {
                return this.sprout_key_ios;
            }

            public String getStricker_url() {
                return this.stricker_url;
            }

            public String getSw_app_id() {
                return this.sw_app_id;
            }

            public String getTeenager_des() {
                return this.teenager_des;
            }

            public String getTxcloud_appid() {
                return this.txcloud_appid;
            }

            public String getTxcloud_bucket() {
                return this.txcloud_bucket;
            }

            public String getTxcloud_region() {
                return this.txcloud_region;
            }

            public String getTximgfolder() {
                return this.tximgfolder;
            }

            public String getTxvideofolder() {
                return this.txvideofolder;
            }

            public String getVideo_audit_switch() {
                return this.video_audit_switch;
            }

            public String getVideo_share_des() {
                return this.video_share_des;
            }

            public String getVideo_share_title() {
                return this.video_share_title;
            }

            public String getVideo_watermark() {
                return this.video_watermark;
            }

            public List<VideoclassBean> getVideoclass() {
                return this.videoclass;
            }

            public String getWechat_ewm() {
                return this.wechat_ewm;
            }

            public String getWx_siteurl() {
                return this.wx_siteurl;
            }

            public String getWxmini_des() {
                return this.wxmini_des;
            }

            public String getWxmini_shelves_version() {
                return this.wxmini_shelves_version;
            }

            public String getWxmini_version() {
                return this.wxmini_version;
            }

            public void setAddress(String str) {
                this.address = str;
            }

            public void setApk_des(String str) {
                this.apk_des = str;
            }

            public void setApk_ewm(String str) {
                this.apk_ewm = str;
            }

            public void setApk_url(String str) {
                this.apk_url = str;
            }

            public void setApk_ver(String str) {
                this.apk_ver = str;
            }

            public void setApp_android(String str) {
                this.app_android = str;
            }

            public void setApp_ios(String str) {
                this.app_ios = str;
            }

            public void setBig_eye(String str) {
                this.big_eye = str;
            }

            public void setBrightness(String str) {
                this.brightness = str;
            }

            public void setChin_lift(String str) {
                this.chin_lift = str;
            }

            public void setCloudtype(String str) {
                this.cloudtype = str;
            }

            public void setCompany_desc(String str) {
                this.company_desc = str;
            }

            public void setCompany_name(String str) {
                this.company_name = str;
            }

            public void setCopyright_url(String str) {
                this.copyright_url = str;
            }

            public void setEye_alat(String str) {
                this.eye_alat = str;
            }

            public void setEye_brow(String str) {
                this.eye_brow = str;
            }

            public void setEye_corner(String str) {
                this.eye_corner = str;
            }

            public void setEye_length(String str) {
                this.eye_length = str;
            }

            public void setFace_lift(String str) {
                this.face_lift = str;
            }

            public void setFace_shave(String str) {
                this.face_shave = str;
            }

            public void setForehead_lift(String str) {
                this.forehead_lift = str;
            }

            public void setGuide(GuideBean guideBean) {
                this.guide = guideBean;
            }

            public void setIos_shelves(String str) {
                this.ios_shelves = str;
            }

            public void setIpa_des(String str) {
                this.ipa_des = str;
            }

            public void setIpa_ewm(String str) {
                this.ipa_ewm = str;
            }

            public void setIpa_url(String str) {
                this.ipa_url = str;
            }

            public void setIpa_ver(String str) {
                this.ipa_ver = str;
            }

            public void setIsup(String str) {
                this.isup = str;
            }

            public void setLeaderboard_switch(String str) {
                this.leaderboard_switch = str;
            }

            public void setLengthen_noseLift(String str) {
                this.lengthen_noseLift = str;
            }

            public void setLetter_switch(String str) {
                this.letter_switch = str;
            }

            public void setLevel(List<LevelBean> list) {
                this.level = list;
            }

            public void setLevelanchor(List<LevelanchorBean> list) {
                this.levelanchor = list;
            }

            public void setLive_time_coin(List<String> list) {
                this.live_time_coin = list;
            }

            public void setLive_type(List<List<String>> list) {
                this.live_type = list;
            }

            public void setLiveclass(List<LiveclassBean> list) {
                this.liveclass = list;
            }

            public void setLogin_alert_content(String str) {
                this.login_alert_content = str;
            }

            public void setLogin_alert_content_en(String str) {
                this.login_alert_content_en = str;
            }

            public void setLogin_alert_title(String str) {
                this.login_alert_title = str;
            }

            public void setLogin_alert_title_en(String str) {
                this.login_alert_title_en = str;
            }

            public void setLogin_clause_title(String str) {
                this.login_clause_title = str;
            }

            public void setLogin_clause_title_en(String str) {
                this.login_clause_title_en = str;
            }

            public void setLogin_img(String str) {
                this.login_img = str;
            }

            public void setLogin_img_en(String str) {
                this.login_img_en = str;
            }

            public void setLogin_img_old(String str) {
                this.login_img_old = str;
            }

            public void setLogin_private_title(String str) {
                this.login_private_title = str;
            }

            public void setLogin_private_title_en(String str) {
                this.login_private_title_en = str;
            }

            public void setLogin_private_url(String str) {
                this.login_private_url = str;
            }

            public void setLogin_service_title(String str) {
                this.login_service_title = str;
            }

            public void setLogin_service_title_en(String str) {
                this.login_service_title_en = str;
            }

            public void setLogin_service_url(String str) {
                this.login_service_url = str;
            }

            public void setLogin_type(List<?> list) {
                this.login_type = list;
            }

            public void setMaintain_switch(String str) {
                this.maintain_switch = str;
            }

            public void setMaintain_tips(String str) {
                this.maintain_tips = str;
            }

            public void setMobile(String str) {
                this.mobile = str;
            }

            public void setMouse_lift(String str) {
                this.mouse_lift = str;
            }

            public void setName_coin(String str) {
                this.name_coin = str;
            }

            public void setName_score(String str) {
                this.name_score = str;
            }

            public void setName_votes(String str) {
                this.name_votes = str;
            }

            public void setNose_lift(String str) {
                this.nose_lift = str;
            }

            public void setOpeninstall_switch(String str) {
                this.openinstall_switch = str;
            }

            public void setPayment_percent(String str) {
                this.payment_percent = str;
            }

            public void setPayment_time(String str) {
                this.payment_time = str;
            }

            public void setQiniu_domain(String str) {
                this.qiniu_domain = str;
            }

            public void setQiniu_region(String str) {
                this.qiniu_region = str;
            }

            public void setQiniu_sign(Object obj) {
                this.qiniu_sign = obj;
            }

            public void setQiniu_uphost(String str) {
                this.qiniu_uphost = str;
            }

            public void setSensitive_words(List<String> list) {
                this.sensitive_words = list;
            }

            public void setShare_des(String str) {
                this.share_des = str;
            }

            public void setShare_title(String str) {
                this.share_title = str;
            }

            public void setShare_type(List<?> list) {
                this.share_type = list;
            }

            public void setShop_system_name(String str) {
                this.shop_system_name = str;
            }

            public void setShopexplain_url(String str) {
                this.shopexplain_url = str;
            }

            public void setSite(String str) {
                this.site = str;
            }

            public void setSite_name(String str) {
                this.site_name = str;
            }

            public void setSite_name_en(String str) {
                this.site_name_en = str;
            }

            public void setSkin_smooth(String str) {
                this.skin_smooth = str;
            }

            public void setSkin_tenderness(String str) {
                this.skin_tenderness = str;
            }

            public void setSkin_whiting(String str) {
                this.skin_whiting = str;
            }

            public void setSocket_url(String str) {
                this.socket_url = str;
            }

            public void setSprout_appid(String str) {
                this.sprout_appid = str;
            }

            public void setSprout_appid_ios(String str) {
                this.sprout_appid_ios = str;
            }

            public void setSprout_key(String str) {
                this.sprout_key = str;
            }

            public void setSprout_key_ios(String str) {
                this.sprout_key_ios = str;
            }

            public void setStricker_url(String str) {
                this.stricker_url = str;
            }

            public void setSw_app_id(String str) {
                this.sw_app_id = str;
            }

            public void setTeenager_des(String str) {
                this.teenager_des = str;
            }

            public void setTxcloud_appid(String str) {
                this.txcloud_appid = str;
            }

            public void setTxcloud_bucket(String str) {
                this.txcloud_bucket = str;
            }

            public void setTxcloud_region(String str) {
                this.txcloud_region = str;
            }

            public void setTximgfolder(String str) {
                this.tximgfolder = str;
            }

            public void setTxvideofolder(String str) {
                this.txvideofolder = str;
            }

            public void setVideo_audit_switch(String str) {
                this.video_audit_switch = str;
            }

            public void setVideo_share_des(String str) {
                this.video_share_des = str;
            }

            public void setVideo_share_title(String str) {
                this.video_share_title = str;
            }

            public void setVideo_watermark(String str) {
                this.video_watermark = str;
            }

            public void setVideoclass(List<VideoclassBean> list) {
                this.videoclass = list;
            }

            public void setWechat_ewm(String str) {
                this.wechat_ewm = str;
            }

            public void setWx_siteurl(String str) {
                this.wx_siteurl = str;
            }

            public void setWxmini_des(String str) {
                this.wxmini_des = str;
            }

            public void setWxmini_shelves_version(String str) {
                this.wxmini_shelves_version = str;
            }

            public void setWxmini_version(String str) {
                this.wxmini_version = str;
            }
        }

        public int getCode() {
            return this.code;
        }

        public List<InfoBean> getInfo() {
            return this.info;
        }

        public String getMsg() {
            return this.msg;
        }

        public void setCode(int i) {
            this.code = i;
        }

        public void setInfo(List<InfoBean> list) {
            this.info = list;
        }

        public void setMsg(String str) {
            this.msg = str;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class DebugBean {
        private List<String> sqls;
        private List<String> stack;
        private String version;

        public List<String> getSqls() {
            return this.sqls;
        }

        public List<String> getStack() {
            return this.stack;
        }

        public String getVersion() {
            return this.version;
        }

        public void setSqls(List<String> list) {
            this.sqls = list;
        }

        public void setStack(List<String> list) {
            this.stack = list;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public DataBean getData() {
        return this.data;
    }

    public DebugBean getDebug() {
        return this.debug;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getRet() {
        return this.ret;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setDebug(DebugBean debugBean) {
        this.debug = debugBean;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRet(int i) {
        this.ret = i;
    }
}
