package com.trtc.tuikit.common.ui.floatwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.trtc.tuikit.common.permission.PermissionRequester;
import com.trtc.tuikit.common.system.ContextProvider;
import com.trtc.tuikit.common.util.ScreenUtil;
import com.trtc.tuikit.common.util.TUIBuild;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /tmp/classes2.dex */
public class FloatWindowManager {
    private static final int CLICK_ACTION_MAX_MOVE_DISTANCE_PX = 10;
    private static final int VIEW_MARGIN_EDGE_PX = ScreenUtil.dip2px(10.0f);
    private static volatile FloatWindowManager sInstance;
    private float mCurrentTouchX;
    private float mCurrentTouchY;
    private boolean mIsActionDrag;
    private OrientationReceiver mOrientationReceiver;
    private WindowManager.LayoutParams mOriginalLayoutParams;
    private FrameLayout mRootView;
    private float mTouchDownPointX;
    private float mTouchDownPointY;
    private WindowManager.LayoutParams mWindowLayoutParams;
    private WindowManager mWindowManager;
    private boolean mIsShowing = false;
    private Context mAppContext = ContextProvider.getApplicationContext();
    private List<FloatWindowObserver> mObserverList = new CopyOnWriteArrayList();

    /* loaded from: /tmp/classes2.dex */
    public class FloatRootViewTouchListener implements View.OnTouchListener {
        private FloatRootViewTouchListener() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                FloatWindowManager.this.mTouchDownPointX = motionEvent.getRawX();
                FloatWindowManager.this.mTouchDownPointY = motionEvent.getRawY();
                FloatWindowManager floatWindowManager = FloatWindowManager.this;
                floatWindowManager.mCurrentTouchX = floatWindowManager.mTouchDownPointX;
                FloatWindowManager floatWindowManager2 = FloatWindowManager.this;
                floatWindowManager2.mCurrentTouchY = floatWindowManager2.mTouchDownPointY;
                FloatWindowManager floatWindowManager3 = FloatWindowManager.this;
                floatWindowManager3.mOriginalLayoutParams = floatWindowManager3.mWindowLayoutParams;
                FloatWindowManager.this.mIsActionDrag = false;
            } else if (action == 1) {
                boolean z = FloatWindowManager.this.mIsActionDrag;
                FloatWindowManager floatWindowManager4 = FloatWindowManager.this;
                if (z) {
                    floatWindowManager4.autoMoveToScreenEdge();
                } else {
                    floatWindowManager4.moveBackToOriginalPosition();
                    FloatWindowManager.this.handleClickAction();
                }
            } else if (action == 2) {
                FloatWindowManager.this.mWindowLayoutParams.x += (int) (FloatWindowManager.this.mCurrentTouchX - motionEvent.getRawX());
                FloatWindowManager.this.mWindowLayoutParams.y += (int) (motionEvent.getRawY() - FloatWindowManager.this.mCurrentTouchY);
                FloatWindowManager.this.updateLayout();
                FloatWindowManager.this.updateFlagOfDragAction(motionEvent.getRawX(), motionEvent.getRawY());
                FloatWindowManager.this.mCurrentTouchX = (int) motionEvent.getRawX();
                FloatWindowManager.this.mCurrentTouchY = (int) motionEvent.getRawY();
            }
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class OrientationReceiver extends BroadcastReceiver {
        private OrientationReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction())) {
                FloatWindowManager.this.updateWindowLayoutParams();
                FloatWindowManager.this.updateLayout();
            }
        }
    }

    private FloatWindowManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autoMoveToScreenEdge() {
        if (this.mRootView != null) {
            WindowManager.LayoutParams layoutParams = this.mWindowLayoutParams;
            layoutParams.x = layoutParams.x > (getMaxPositionX() >> 1) ? getMaxPositionX() : VIEW_MARGIN_EDGE_PX;
            this.mWindowManager.updateViewLayout(this.mRootView, this.mWindowLayoutParams);
        }
    }

    private int getMaxPositionX() {
        return (ScreenUtil.getScreenWidth(this.mAppContext) - this.mRootView.getWidth()) - VIEW_MARGIN_EDGE_PX;
    }

    private int getMaxPositionY() {
        return (ScreenUtil.getScreenHeight(this.mAppContext) - this.mRootView.getHeight()) - VIEW_MARGIN_EDGE_PX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleClickAction() {
        for (FloatWindowObserver floatWindowObserver : this.mObserverList) {
            if (floatWindowObserver != null) {
                floatWindowObserver.onFloatWindowClick();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveBackToOriginalPosition() {
        FrameLayout frameLayout = this.mRootView;
        if (frameLayout != null) {
            WindowManager.LayoutParams layoutParams = this.mOriginalLayoutParams;
            this.mWindowLayoutParams = layoutParams;
            this.mWindowManager.updateViewLayout(frameLayout, layoutParams);
        }
    }

    private void registerReceiver() {
        if (this.mOrientationReceiver != null) {
            return;
        }
        this.mOrientationReceiver = new OrientationReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
        this.mAppContext.registerReceiver(this.mOrientationReceiver, intentFilter);
    }

    public static FloatWindowManager sharedInstance() {
        if (sInstance == null) {
            synchronized (FloatWindowManager.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new FloatWindowManager();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private void unregisterReceiver() {
        OrientationReceiver orientationReceiver = this.mOrientationReceiver;
        if (orientationReceiver != null) {
            this.mAppContext.unregisterReceiver(orientationReceiver);
            this.mOrientationReceiver = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateFlagOfDragAction(float f, float f2) {
        float abs = Math.abs(f - this.mTouchDownPointX);
        float abs2 = Math.abs(f2 - this.mTouchDownPointY);
        if (abs >= 10.0f || abs2 >= 10.0f) {
            this.mIsActionDrag = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLayout() {
        if (this.mRootView != null) {
            WindowManager.LayoutParams layoutParams = this.mWindowLayoutParams;
            int i = layoutParams.x;
            int i2 = VIEW_MARGIN_EDGE_PX;
            layoutParams.x = Math.max(i, i2);
            WindowManager.LayoutParams layoutParams2 = this.mWindowLayoutParams;
            layoutParams2.x = Math.min(layoutParams2.x, getMaxPositionX());
            WindowManager.LayoutParams layoutParams3 = this.mWindowLayoutParams;
            layoutParams3.y = Math.max(layoutParams3.y, i2);
            WindowManager.LayoutParams layoutParams4 = this.mWindowLayoutParams;
            layoutParams4.y = Math.min(layoutParams4.y, getMaxPositionY());
            this.mWindowManager.updateViewLayout(this.mRootView, this.mWindowLayoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateWindowLayoutParams() {
        this.mWindowLayoutParams = new WindowManager.LayoutParams();
        int versionInt = TUIBuild.getVersionInt();
        WindowManager.LayoutParams layoutParams = this.mWindowLayoutParams;
        if (versionInt >= 26) {
            layoutParams.type = 2038;
        } else {
            layoutParams.type = 2002;
        }
        WindowManager.LayoutParams layoutParams2 = this.mWindowLayoutParams;
        layoutParams2.flags = 552;
        layoutParams2.gravity = 53;
        layoutParams2.x = VIEW_MARGIN_EDGE_PX;
        layoutParams2.y = ScreenUtil.getScreenHeight(this.mAppContext) / 4;
        WindowManager.LayoutParams layoutParams3 = this.mWindowLayoutParams;
        layoutParams3.width = -2;
        layoutParams3.height = -2;
        layoutParams3.format = -2;
    }

    public void addObserver(FloatWindowObserver floatWindowObserver) {
        if (floatWindowObserver == null || this.mObserverList.contains(floatWindowObserver)) {
            return;
        }
        this.mObserverList.add(floatWindowObserver);
    }

    public void dismiss() {
        if (this.mIsShowing) {
            unregisterReceiver();
            this.mIsShowing = false;
            FrameLayout frameLayout = this.mRootView;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
                this.mWindowManager.removeView(this.mRootView);
                this.mRootView = null;
            }
        }
    }

    public boolean isPictureInPictureSupported() {
        return this.mAppContext.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void removeObserver(FloatWindowObserver floatWindowObserver) {
        if (floatWindowObserver == null) {
            return;
        }
        this.mObserverList.remove(floatWindowObserver);
    }

    public void show(View view) {
        if (this.mIsShowing) {
            return;
        }
        PermissionRequester newInstance = PermissionRequester.newInstance(PermissionRequester.FLOAT_PERMISSION);
        if (!newInstance.has()) {
            newInstance.request();
            return;
        }
        this.mIsShowing = true;
        FrameLayout frameLayout = new FrameLayout(this.mAppContext);
        this.mRootView = frameLayout;
        frameLayout.setOnTouchListener(new FloatRootViewTouchListener());
        this.mRootView.addView(view);
        this.mWindowManager = (WindowManager) this.mAppContext.getSystemService("window");
        updateWindowLayoutParams();
        this.mWindowManager.addView(this.mRootView, this.mWindowLayoutParams);
        registerReceiver();
    }
}
