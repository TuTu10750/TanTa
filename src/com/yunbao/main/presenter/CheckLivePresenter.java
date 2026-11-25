package com.yunbao.main.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.bean.LiveBean;
import defpackage.e32;
import defpackage.ie3;
import defpackage.j62;
import defpackage.t54;
import defpackage.zu0;

/* loaded from: /tmp/classes2.dex */
public class CheckLivePresenter {
    private int mChatRoomType;
    private Context mContext;
    private boolean mIsChatRoom;
    private String mKey;
    private LiveBean mLiveBean;
    private int mLiveSdk;
    private int mLiveType;
    private String mLiveTypeMsg;
    private int mLiveTypeVal;
    private int mPosition;
    private HttpCallback mRoomChargeCallback = new HttpCallback() { // from class: com.yunbao.main.presenter.CheckLivePresenter.2
        @Override // com.yunbao.common.http.HttpCallback
        public Dialog createLoadingDialog() {
            return a.c(CheckLivePresenter.this.mContext);
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (CheckLivePresenter.this.isActivityInvalid()) {
                return;
            }
            if (i == 0) {
                CheckLivePresenter.this.forwardLiveAudienceActivity();
            } else {
                t54.b(str);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean showLoadingDialog() {
            return true;
        }
    };

    public CheckLivePresenter(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forwardLiveAudienceActivity() {
        if (isActivityInvalid() || this.mLiveBean.getLivePlatform() == 6) {
            return;
        }
        boolean z = this.mIsChatRoom;
        Context context = this.mContext;
        if (z) {
            LiveAudienceActivity.F3(context, this.mLiveBean, this.mLiveType, this.mLiveTypeVal, "", 0, this.mLiveSdk, true, this.mChatRoomType);
        } else {
            LiveAudienceActivity.F3(context, this.mLiveBean, this.mLiveType, this.mLiveTypeVal, this.mKey, this.mPosition, this.mLiveSdk, false, this.mChatRoomType);
        }
    }

    private void forwardNormalRoom() {
        forwardLiveAudienceActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCheckLiveFailure(LiveBean liveBean, String str) {
        zu0.c().j(new ie3(liveBean.getUid()));
        t54.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCheckLiveSuccess(String[] strArr) {
        if (hasInfo(strArr)) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            this.mIsChatRoom = parseObject.getIntValue("live_type") == 1;
            this.mChatRoomType = parseObject.getIntValue("voice_type");
            this.mLiveType = parseObject.getIntValue("type");
            this.mLiveTypeVal = parseObject.getIntValue("type_val");
            this.mLiveTypeMsg = parseObject.getString("type_msg");
            this.mLiveSdk = parseObject.getIntValue("live_platform");
            forwardNormalRoom();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLiveVipRequired(String[] strArr) {
        if (hasInfo(strArr) && (this.mContext instanceof FragmentActivity) && !isActivityInvalid()) {
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("sharelink");
            String string2 = parseObject.getString("fail_msg");
            j62 j62Var = new j62();
            j62Var.u2(string2, string);
            j62Var.v2("live");
            j62Var.w2(this.mContext.getSupportFragmentManager(), "LiveVipDialog");
        }
    }

    private boolean hasInfo(String[] strArr) {
        return strArr != null && strArr.length > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActivityInvalid() {
        Context context = this.mContext;
        if (context instanceof Activity) {
            return ((Activity) context).isFinishing() || ((Activity) this.mContext).isDestroyed();
        }
        return false;
    }

    public void cancel() {
        e32.f("checkLive");
        e32.f("roomCharge");
    }

    public void roomCharge() {
        e32.w0(this.mLiveBean.getUid(), this.mLiveBean.getStream(), this.mRoomChargeCallback);
    }

    public void watchLive(LiveBean liveBean) {
        watchLive(liveBean, "", 0);
    }

    public void watchLive(LiveBean liveBean, String str, int i) {
        watchLive(liveBean, str, i, true);
    }

    public void watchLive(final LiveBean liveBean, String str, int i, boolean z) {
        this.mLiveBean = liveBean;
        this.mKey = str;
        this.mPosition = i;
        e32.k(liveBean.getUid(), liveBean.getStream(), new HttpCallback() { // from class: com.yunbao.main.presenter.CheckLivePresenter.1
            @Override // com.yunbao.common.http.HttpCallback
            public Dialog createLoadingDialog() {
                return a.c(CheckLivePresenter.this.mContext);
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i2, String str2, String[] strArr) {
                if (CheckLivePresenter.this.isActivityInvalid()) {
                    return;
                }
                if (i2 == 0) {
                    CheckLivePresenter.this.handleCheckLiveSuccess(strArr);
                    return;
                }
                CheckLivePresenter checkLivePresenter = CheckLivePresenter.this;
                if (i2 == 40018) {
                    checkLivePresenter.handleLiveVipRequired(strArr);
                } else {
                    checkLivePresenter.handleCheckLiveFailure(liveBean, str2);
                }
            }

            @Override // com.yunbao.common.http.HttpCallback
            public boolean showLoadingDialog() {
                return true;
            }
        });
    }

    public void watchLive(LiveBean liveBean, boolean z) {
        watchLive(liveBean, "", 0, z);
    }
}
