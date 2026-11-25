package com.umeng.pagesdk;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;

/* loaded from: /tmp/classes2.dex */
public class PageConfigManger {
    public static final String APM_FPSPERF_COLLECT_INTERVAL = "apm_pageperf_collect_interval";
    public static final String APM_FPSPERF_COLLECT_INTERVAL_TOGETHER = "apm_pageperf_collect_interval_together";
    public static final String APM_FPSPERF_COLLECT_MAX_PERIOD_SEC = "apm_pageperf_collect_max_period_sec";
    private Context b;
    private EfsReporter c;
    private int d;
    private int f;
    private boolean g;
    private final String a = "PageConfigManager";
    private final int e = 0;

    /* JADX WARN: Removed duplicated region for block: B:15:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public PageConfigManger(android.content.Context r18, com.efs.sdk.base.EfsReporter r19) {
        /*
            Method dump skipped, instructions count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.pagesdk.PageConfigManger.<init>(android.content.Context, com.efs.sdk.base.EfsReporter):void");
    }

    public boolean enableTracer() {
        return this.g;
    }
}
