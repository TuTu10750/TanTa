package com.umeng.logsdk;

import android.text.TextUtils;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class UploadFileFilterCodeLog implements IFileFilter {
    private ULogConfigManager a;
    private b b;
    private String c;
    private String e;
    private long g;
    private long h;
    private int d = -1;
    private int f = -1;

    private void a() {
        Log.i("UploadFileFilterCodeLog", "reset task.");
        this.b = null;
        this.c = null;
        this.d = -1;
        this.e = null;
        this.f = -1;
        this.g = 0L;
        this.h = 0L;
    }

    public boolean filter(File file) {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        List<b> taskList;
        if (this.b == null) {
            ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
            this.a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                int i = 0;
                while (true) {
                    if (i >= taskList.size()) {
                        break;
                    }
                    b bVar = taskList.get(i);
                    this.b = bVar;
                    if (bVar != null) {
                        int i2 = bVar.b;
                        this.d = i2;
                        if (i2 == 0) {
                            this.c = bVar.a;
                            this.e = bVar.d;
                            this.f = bVar.c;
                            this.g = bVar.e;
                            this.h = bVar.f;
                            break;
                        }
                        a();
                    }
                    i++;
                }
            }
        }
        if (this.b != null && this.d == 0) {
            Log.i("UploadFileFilterCodeLog", this.c + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h);
            String name = file.getName();
            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith("codelogperf")) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = createLogDtoByName.getBeginTime();
            createLogDtoByName.getEndTime();
            String did = createLogDtoByName.getDid();
            String uid = createLogDtoByName.getUid();
            if (beginTime >= this.g && beginTime <= this.h) {
                Log.i("UploadFileFilterCodeLog", "task target type is " + this.f);
                int i3 = this.f;
                if (i3 == 1) {
                    if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(did) || !this.e.equals(did)) {
                        sb2 = "taskTarget is " + this.e + ", did is " + did;
                        Log.i("UploadFileFilterCodeLog", sb2);
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                } else if (i3 == 0) {
                    if (TextUtils.isEmpty(this.e) || TextUtils.isEmpty(uid) || !this.e.equals(uid)) {
                        sb = new StringBuilder("taskTarget is ");
                        sb.append(this.e);
                        sb.append(", uid is ");
                        sb.append(uid);
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                }
                sb3.append(this.c);
                sb3.append(", target is ");
                sb3.append(this.e);
                sb3.append(", file time is ");
                sb3.append(beginTime);
                Log.i("UploadFileFilterCodeLog", sb3.toString());
                return false;
            }
            sb = new StringBuilder("time is ");
            sb.append(beginTime >= this.g);
            sb.append(", is ");
            sb.append(beginTime <= this.h);
            sb2 = sb.toString();
            Log.i("UploadFileFilterCodeLog", sb2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r0 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void finish() {
        /*
            r6 = this;
            java.lang.String r0 = "clear task."
            java.lang.String r1 = "UploadFileFilterCodeLog"
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "taskEndTime is "
            r0.<init>(r4)
            long r4 = r6.h
            r0.append(r4)
            java.lang.String r4 = ", current time is "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            long r4 = r6.h
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L36
            java.lang.String r0 = "future task. not remove."
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            com.umeng.logsdk.ULogConfigManager r0 = r6.a
            if (r0 == 0) goto L46
            goto L41
        L36:
            com.umeng.logsdk.ULogConfigManager r0 = r6.a
            if (r0 == 0) goto L46
            java.lang.String r1 = r6.c
            r0.reMoveTaskFroSP(r1)
            com.umeng.logsdk.ULogConfigManager r0 = r6.a
        L41:
            com.umeng.logsdk.b r1 = r6.b
            r0.removeTask(r1)
        L46:
            r6.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.UploadFileFilterCodeLog.finish():void");
    }

    public void finish(boolean z, boolean z2) {
    }

    public boolean hasTask() {
        List<b> taskList;
        ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
        if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
            for (int i = 0; i < taskList.size(); i++) {
                b bVar = taskList.get(i);
                if (bVar != null && bVar.b == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
