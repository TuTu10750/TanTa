package com.yunbao.game.bean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.fastjson.JSONObject;
import defpackage.ua1;

/* loaded from: /tmp/classes2.dex */
public class GameParam {
    private boolean mAnchor;
    private String mCoinName;
    private Context mContext;
    private ua1 mGameActionListener;
    private ViewGroup mInnerContainer;
    private String mLiveUid;
    private JSONObject mObj;
    private ViewGroup mParentView;
    private String mStream;
    private View mTopView;

    public String getCoinName() {
        return this.mCoinName;
    }

    public Context getContext() {
        return this.mContext;
    }

    public ua1 getGameActionListener() {
        return this.mGameActionListener;
    }

    public ViewGroup getInnerContainer() {
        return this.mInnerContainer;
    }

    public String getLiveUid() {
        return this.mLiveUid;
    }

    public JSONObject getObj() {
        return this.mObj;
    }

    public ViewGroup getParentView() {
        return this.mParentView;
    }

    public String getStream() {
        return this.mStream;
    }

    public View getTopView() {
        return this.mTopView;
    }

    public boolean isAnchor() {
        return this.mAnchor;
    }

    public void setAnchor(boolean z) {
        this.mAnchor = z;
    }

    public void setCoinName(String str) {
        this.mCoinName = str;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setGameActionListener(ua1 ua1Var) {
        this.mGameActionListener = ua1Var;
    }

    public void setInnerContainer(ViewGroup viewGroup) {
        this.mInnerContainer = viewGroup;
    }

    public void setLiveUid(String str) {
        this.mLiveUid = str;
    }

    public void setObj(JSONObject jSONObject) {
        this.mObj = jSONObject;
    }

    public void setParentView(ViewGroup viewGroup) {
        this.mParentView = viewGroup;
    }

    public void setStream(String str) {
        this.mStream = str;
    }

    public void setTopView(View view) {
        this.mTopView = view;
    }
}
