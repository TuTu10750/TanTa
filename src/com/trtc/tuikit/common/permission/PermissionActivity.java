package com.trtc.tuikit.common.permission;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.event.EventManager;
import com.trtc.tuikit.common.permission.PermissionActivity;
import com.trtc.tuikit.common.permission.PermissionRequester;
import com.trtc.tuikit.common.util.TUIBuild;
import com.uc.crashsdk.export.LogType;
import java.util.HashMap;

/* loaded from: /tmp/classes2.dex */
public class PermissionActivity extends Activity {
    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String TAG = "PermissionActivity";
    private ImageView mPermissionIconIv;
    private TextView mRationaleDescriptionTv;
    private TextView mRationaleTitleTv;
    private PermissionRequester.RequestData mRequestData;
    private PermissionRequester.Result mResult = PermissionRequester.Result.Denied;

    public static /* synthetic */ boolean a(Dialog dialog, DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            dialog.dismiss();
        }
        return true;
    }

    public static /* synthetic */ void b(PermissionActivity permissionActivity, Dialog dialog, View view) {
        permissionActivity.getClass();
        dialog.dismiss();
        permissionActivity.finishWithResult(PermissionRequester.Result.Denied);
    }

    public static /* synthetic */ void c(PermissionActivity permissionActivity, Dialog dialog, View view) {
        permissionActivity.getClass();
        dialog.dismiss();
        permissionActivity.launchAppDetailsSettings();
        permissionActivity.finishWithResult(PermissionRequester.Result.Requesting);
    }

    private void finishWithResult(PermissionRequester.Result result) {
        Log.i(TAG, "finishWithResult : " + result);
        this.mResult = result;
        finish();
    }

    private PermissionRequester.RequestData getPermissionRequest() {
        Intent intent = getIntent();
        if (intent == null) {
            return null;
        }
        return (PermissionRequester.RequestData) intent.getParcelableExtra(PermissionRequester.PERMISSION_REQUEST_KEY);
    }

    private void hidePermissionRationale() {
        this.mRationaleTitleTv.setVisibility(4);
        this.mRationaleDescriptionTv.setVisibility(4);
        this.mPermissionIconIv.setVisibility(4);
    }

    private void initView() {
        setContentView(R.layout.common_permission_activity_layout);
        this.mRationaleTitleTv = (TextView) findViewById(R.id.permission_reason_title);
        this.mRationaleDescriptionTv = (TextView) findViewById(R.id.permission_reason);
        this.mPermissionIconIv = (ImageView) findViewById(R.id.permission_icon);
    }

    private boolean isAllPermissionsGranted(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    private void launchAppDetailsSettings() {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + getPackageName()));
        intent.addFlags(268435456);
        if (getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) {
            Log.e(TAG, "launchAppDetailsSettings can not find system settings");
        } else {
            startActivity(intent);
        }
    }

    private void makeBackGroundTransparent() {
        if (TUIBuild.getVersionInt() >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(LogType.UNEXP_ANR);
            getWindow().setStatusBarColor(0);
            getWindow().setNavigationBarColor(0);
        }
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void showPermissionRationale() {
        PermissionRequester.RequestData requestData = this.mRequestData;
        if (requestData == null) {
            return;
        }
        this.mRationaleTitleTv.setText(requestData.getTitle());
        this.mRationaleDescriptionTv.setText(this.mRequestData.getDescription());
        this.mPermissionIconIv.setBackgroundResource(this.mRequestData.getPermissionIconId());
        this.mRationaleTitleTv.setVisibility(0);
        this.mRationaleDescriptionTv.setVisibility(0);
        this.mPermissionIconIv.setVisibility(0);
    }

    private void showSettingsTip() {
        if (this.mRequestData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.common_permission_tip_layout, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.tips);
        TextView textView2 = (TextView) inflate.findViewById(R.id.positive_btn);
        TextView textView3 = (TextView) inflate.findViewById(R.id.negative_btn);
        textView.setText(this.mRequestData.getSettingsTip());
        final AlertDialog create = new AlertDialog.Builder(this).setView(inflate).setCancelable(false).create();
        textView2.setOnClickListener(new View.OnClickListener() { // from class: sx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.c(PermissionActivity.this, create, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: tx2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PermissionActivity.b(PermissionActivity.this, create, view);
            }
        });
        create.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: ux2
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return PermissionActivity.a(create, dialogInterface, i, keyEvent);
            }
        });
        Window window = create.getWindow();
        window.setBackgroundDrawable(new ColorDrawable());
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        create.show();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        PermissionRequester.RequestData permissionRequest = getPermissionRequest();
        this.mRequestData = permissionRequest;
        if (permissionRequest == null || permissionRequest.isPermissionsExistEmpty()) {
            Log.e(TAG, "onCreate mRequestData exist empty permission");
            finishWithResult(PermissionRequester.Result.Denied);
            return;
        }
        Log.i(TAG, "onCreate : " + this.mRequestData.toString());
        if (TUIBuild.getVersionInt() < 23) {
            finishWithResult(PermissionRequester.Result.Granted);
            return;
        }
        makeBackGroundTransparent();
        initView();
        showPermissionRationale();
        requestPermissions(this.mRequestData.getPermissions(), 100);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        HashMap hashMap = new HashMap(1);
        hashMap.put(PermissionRequester.PERMISSION_RESULT, this.mResult);
        EventManager.getInstance().notifyEvent(PermissionRequester.PERMISSION_NOTIFY_EVENT_KEY, PermissionRequester.PERMISSION_NOTIFY_EVENT_SUB_KEY, hashMap);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        hidePermissionRationale();
        if (isAllPermissionsGranted(iArr)) {
            finishWithResult(PermissionRequester.Result.Granted);
        } else {
            showSettingsTip();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
