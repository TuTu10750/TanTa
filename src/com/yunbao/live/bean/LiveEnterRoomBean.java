package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class LiveEnterRoomBean {
    private LiveChatBean mLiveChatBean;
    private LiveUserGiftBean mUserBean;

    public LiveEnterRoomBean(LiveUserGiftBean liveUserGiftBean, LiveChatBean liveChatBean) {
        this.mUserBean = liveUserGiftBean;
        this.mLiveChatBean = liveChatBean;
    }

    public LiveChatBean getLiveChatBean() {
        return this.mLiveChatBean;
    }

    public LiveUserGiftBean getUserBean() {
        return this.mUserBean;
    }

    public void setLiveChatBean(LiveChatBean liveChatBean) {
        this.mLiveChatBean = liveChatBean;
    }

    public void setUserBean(LiveUserGiftBean liveUserGiftBean) {
        this.mUserBean = liveUserGiftBean;
    }
}
