package com.trtc.tuikit.common.permission;

import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.event.EventManager;
import com.trtc.tuikit.common.event.INotification;
import com.trtc.tuikit.common.permission.PermissionRequester;
import com.trtc.tuikit.common.system.ContextProvider;
import com.trtc.tuikit.common.util.TUIBuild;
import com.trtc.tuikit.common.util.ToastUtil;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /tmp/classes2.dex */
public class PermissionRequester {
    public static final String BG_START_PERMISSION = "PermissionStartActivityFromBackground";
    public static final String FLOAT_PERMISSION = "PermissionOverlayWindows";
    public static final String PERMISSION_NOTIFY_EVENT_KEY = "PERMISSION_NOTIFY_EVENT_KEY";
    public static final String PERMISSION_NOTIFY_EVENT_SUB_KEY = "PERMISSION_NOTIFY_EVENT_SUB_KEY";
    public static final String PERMISSION_REQUEST_KEY = "PERMISSION_REQUEST_KEY";
    public static final String PERMISSION_RESULT = "PERMISSION_RESULT";
    private static final String TAG = "PermissionRequester";
    private String mDescription;
    private List<String> mDirectPermissionList = new ArrayList();
    private List<String> mIndirectPermissionList = new ArrayList();
    private PermissionCallback mPermissionCallback;
    private INotification mPermissionNotification;
    private String[] mPermissions;
    private String mSettingsTip;
    private String mTitle;
    private static final Object sLock = new Object();
    private static AtomicBoolean sIsRequesting = new AtomicBoolean(false);

    /* loaded from: /tmp/classes2.dex */
    public static class RequestData implements Parcelable {
        public static final Parcelable.Creator<RequestData> CREATOR = new Parcelable.Creator<RequestData>() { // from class: com.trtc.tuikit.common.permission.PermissionRequester.RequestData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestData createFromParcel(Parcel parcel) {
                return new RequestData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RequestData[] newArray(int i) {
                return new RequestData[i];
            }
        };
        private final String mDescription;
        private int mPermissionIconId;
        private final String[] mPermissions;
        private final String mSettingsTip;
        private final String mTitle;

        public RequestData(Parcel parcel) {
            this.mPermissions = parcel.createStringArray();
            this.mTitle = parcel.readString();
            this.mDescription = parcel.readString();
            this.mSettingsTip = parcel.readString();
            this.mPermissionIconId = parcel.readInt();
        }

        public RequestData(String str, String str2, String str3, String... strArr) {
            this.mTitle = str;
            this.mDescription = str2;
            this.mSettingsTip = str3;
            this.mPermissions = (String[]) strArr.clone();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public int getPermissionIconId() {
            return this.mPermissionIconId;
        }

        public String[] getPermissions() {
            return (String[]) this.mPermissions.clone();
        }

        public String getSettingsTip() {
            return this.mSettingsTip;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public boolean isPermissionsExistEmpty() {
            String[] strArr = this.mPermissions;
            if (strArr == null || strArr.length <= 0) {
                return true;
            }
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
            }
            return false;
        }

        public void setPermissionIconId(int i) {
            this.mPermissionIconId = i;
        }

        public String toString() {
            return "PermissionRequest{mPermissions=" + Arrays.toString(this.mPermissions) + ", mTitle=" + this.mTitle + ", mDescription='" + this.mDescription + ", mSettingsTip='" + this.mSettingsTip + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeStringArray(this.mPermissions);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDescription);
            parcel.writeString(this.mSettingsTip);
            parcel.writeInt(this.mPermissionIconId);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public enum Result {
        Granted,
        Denied,
        Requesting
    }

    private PermissionRequester(String... strArr) {
        this.mPermissions = strArr;
        for (String str : strArr) {
            if (FLOAT_PERMISSION.equals(str) || BG_START_PERMISSION.equals(str)) {
                this.mIndirectPermissionList.add(str);
            } else {
                this.mDirectPermissionList.add(str);
            }
        }
        this.mPermissionNotification = new INotification() { // from class: xx2
            @Override // com.trtc.tuikit.common.event.INotification
            public final void onNotifyEvent(String str2, String str3, Map map) {
                PermissionRequester.a(PermissionRequester.this, str2, str3, map);
            }
        };
    }

    public static /* synthetic */ void a(PermissionRequester permissionRequester, String str, String str2, Map map) {
        Object obj;
        permissionRequester.getClass();
        if (map == null || (obj = map.get(PERMISSION_RESULT)) == null) {
            return;
        }
        permissionRequester.notifyPermissionRequestResult((Result) obj);
    }

    private String[] findUnauthorizedPermissions(String[] strArr) {
        Context applicationContext = ContextProvider.getApplicationContext();
        if (applicationContext == null) {
            Log.e(TAG, "findUnauthorizedPermissions appContext is null");
            return strArr;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : strArr) {
            if (o60.a(applicationContext, str) != 0) {
                linkedList.add(str);
            }
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private boolean has(String str) {
        return TUIBuild.getVersionInt() < 23 || o60.a(ContextProvider.getApplicationContext(), str) == 0;
    }

    private boolean hasBgStartPermission() {
        Context applicationContext = ContextProvider.getApplicationContext();
        return (TUIBuild.isBrandHuawei() && TUIBuild.isHarmonyOS()) ? isHarmonyBgStartPermissionAllowed(applicationContext) : TUIBuild.isBrandVivo() ? isVivoBgStartPermissionAllowed(applicationContext) : (TUIBuild.isBrandXiaoMi() && TUIBuild.isMiuiOptimization()) ? isXiaomiBgStartPermissionAllowed(applicationContext) : hasFloatPermission();
    }

    private boolean hasFloatPermission() {
        try {
            return Settings.canDrawOverlays(ContextProvider.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isHarmonyBgStartPermissionAllowed(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            Class<?> cls = Class.forName("com.huawei.android.app.AppOpsManagerEx");
            Class cls2 = Integer.TYPE;
            int intValue = ((Integer) cls.getDeclaredMethod("checkHwOpNoThrow", AppOpsManager.class, cls2, cls2, String.class).invoke(cls.newInstance(), appOpsManager, 100000, Integer.valueOf(Process.myUid()), context.getPackageName())).intValue();
            StringBuilder sb = new StringBuilder("isHarmonyBgStartPermissionAllowed, result: ");
            sb.append(intValue == 0);
            Log.i(TAG, sb.toString());
            return intValue == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean isVivoBgStartPermissionAllowed(Context context) {
        Cursor query;
        try {
            query = context.getContentResolver().query(Uri.parse("content://com.vivo.permissionmanager.provider.permission/start_bg_activity"), null, "pkgname = ?", new String[]{context.getPackageName()}, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (query == null) {
            return false;
        }
        if (!query.moveToFirst()) {
            query.close();
            return false;
        }
        int i = query.getInt(query.getColumnIndex("currentstate"));
        query.close();
        StringBuilder sb = new StringBuilder("isVivoBgStartPermissionAllowed, result: ");
        sb.append(i == 0);
        Log.i(TAG, sb.toString());
        return i == 0;
    }

    private boolean isXiaomiBgStartPermissionAllowed(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (appOpsManager == null) {
                return false;
            }
            Class<?> cls = appOpsManager.getClass();
            Class cls2 = Integer.TYPE;
            Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
            method.setAccessible(true);
            int intValue = ((Integer) method.invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), context.getPackageName())).intValue();
            StringBuilder sb = new StringBuilder("isXiaomiBgStartPermissionAllowed, result: ");
            sb.append(intValue == 0);
            Log.i(TAG, sb.toString());
            return intValue == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static PermissionRequester newInstance(String... strArr) {
        return new PermissionRequester(strArr);
    }

    private void notifyPermissionRequestResult(Result result) {
        EventManager.getInstance().unRegisterEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
        sIsRequesting.set(false);
        if (this.mPermissionCallback == null) {
            return;
        }
        if (Result.Granted.equals(result)) {
            this.mPermissionCallback.onGranted();
        } else {
            boolean equals = Result.Requesting.equals(result);
            PermissionCallback permissionCallback = this.mPermissionCallback;
            if (equals) {
                permissionCallback.onRequesting();
            } else {
                permissionCallback.onDenied();
            }
        }
        this.mPermissionCallback = null;
    }

    private void requestDirectPermission(String[] strArr) {
        synchronized (sLock) {
            try {
                if (sIsRequesting.get()) {
                    Log.e(TAG, "can not request during requesting");
                    PermissionCallback permissionCallback = this.mPermissionCallback;
                    if (permissionCallback != null) {
                        permissionCallback.onDenied();
                    }
                    return;
                }
                sIsRequesting.set(true);
                EventManager.getInstance().registerEvent(PERMISSION_NOTIFY_EVENT_KEY, PERMISSION_NOTIFY_EVENT_SUB_KEY, this.mPermissionNotification);
                if (TUIBuild.getVersionInt() < 23) {
                    Log.i(TAG, "current version is lower than 23");
                    notifyPermissionRequestResult(Result.Granted);
                    return;
                }
                String[] findUnauthorizedPermissions = findUnauthorizedPermissions(strArr);
                if (findUnauthorizedPermissions.length <= 0) {
                    notifyPermissionRequestResult(Result.Granted);
                } else {
                    startPermissionActivity(new RequestData(this.mTitle, this.mDescription, this.mSettingsTip, findUnauthorizedPermissions));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void startAppDetailsSettingsByBrand() {
        Context applicationContext = ContextProvider.getApplicationContext();
        if (TUIBuild.isBrandVivo()) {
            startVivoPermissionSettings(applicationContext);
            return;
        }
        if (TUIBuild.isBrandHuawei()) {
            startHuaweiPermissionSettings(applicationContext);
        } else if (TUIBuild.isBrandXiaoMi()) {
            startXiaomiPermissionSettings(applicationContext);
        } else {
            startCommonSettings(applicationContext);
        }
    }

    private void startCommonSettings(Context context) {
        try {
            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startHuaweiPermissionSettings(Context context) {
        if (!TUIBuild.isHarmonyOS()) {
            Log.i(TAG, "The device is not Harmony or cannot get system operator");
            startCommonSettings(context);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.putExtra("packageName", context.getPackageName());
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            intent.setFlags(268435456);
            context.startActivity(intent);
            ToastUtil.toastShortMessage(context.getResources().getString(R.string.common_float_permission_hint));
        } catch (Exception unused) {
            Log.w(TAG, "startHuaweiPermissionSettings: open common settings");
            startCommonSettings(context);
        }
    }

    private void startPermissionActivity(RequestData requestData) {
        Context applicationContext = ContextProvider.getApplicationContext();
        if (applicationContext == null) {
            return;
        }
        Intent intent = new Intent(applicationContext, (Class<?>) PermissionActivity.class);
        intent.putExtra(PERMISSION_REQUEST_KEY, requestData);
        intent.addFlags(268435456);
        applicationContext.startActivity(intent);
    }

    private void startVivoPermissionSettings(Context context) {
        try {
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.setAction("secure.intent.action.softPermissionDetail");
            intent.putExtra("packagename", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
            ToastUtil.toastShortMessage(context.getResources().getString(R.string.common_float_permission_hint));
        } catch (Exception unused) {
            Log.w(TAG, "startVivoPermissionSettings: open common settings");
            startCommonSettings(context);
        }
    }

    private void startXiaomiPermissionSettings(Context context) {
        if (!TUIBuild.isMiuiOptimization()) {
            Log.i(TAG, "The device do not open miuiOptimization or cannot get miui property");
            startCommonSettings(context);
            return;
        }
        try {
            Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", context.getPackageName());
            intent.setFlags(268435456);
            context.startActivity(intent);
            ToastUtil.toastShortMessage(context.getResources().getString(R.string.common_float_permission_hint));
        } catch (Exception unused) {
            Log.w(TAG, "startXiaomiPermissionSettings: open common settings");
            startCommonSettings(context);
        }
    }

    public PermissionRequester callback(PermissionCallback permissionCallback) {
        this.mPermissionCallback = permissionCallback;
        return this;
    }

    public PermissionRequester description(String str) {
        this.mDescription = str;
        return this;
    }

    public boolean has() {
        if (this.mIndirectPermissionList.contains(BG_START_PERMISSION)) {
            return hasFloatPermission() && hasBgStartPermission();
        }
        if (this.mIndirectPermissionList.contains(FLOAT_PERMISSION)) {
            return hasFloatPermission();
        }
        Iterator<String> it = this.mDirectPermissionList.iterator();
        while (it.hasNext()) {
            if (!has(it.next())) {
                return false;
            }
        }
        return true;
    }

    public void request() {
        Log.i(TAG, "request, directPermissionList: " + this.mDirectPermissionList + " ,indirectPermissionList:  " + this.mIndirectPermissionList);
        List<String> list = this.mDirectPermissionList;
        if (list != null && list.size() > 0) {
            requestDirectPermission((String[]) this.mDirectPermissionList.toArray(new String[0]));
        }
        List<String> list2 = this.mIndirectPermissionList;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        startAppDetailsSettingsByBrand();
    }

    public PermissionRequester settingsTip(String str) {
        this.mSettingsTip = str;
        return this;
    }

    public PermissionRequester title(String str) {
        this.mTitle = str;
        return this;
    }
}
