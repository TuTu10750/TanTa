package defpackage;

import android.content.BroadcastReceiver;

/* loaded from: /tmp/classes2.dex */
public final class mr4 extends BroadcastReceiver {
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0043, code lost:
    
        if (r3 == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        if (android.text.TextUtils.equals(r5.getStringExtra("openIdPackage"), r4.getPackageName()) != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002d, code lost:
    
        r0 = true;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L86
            if (r5 != 0) goto L6
            goto L86
        L6:
            java.lang.String r3 = "openIdNotifyFlag"
            r0 = 0
            int r3 = r5.getIntExtra(r3, r0)
            java.lang.String r1 = "shouldUpdateId, notifyFlag : "
            java.lang.String r2 = java.lang.String.valueOf(r3)
            java.lang.String r1 = r1.concat(r2)
            defpackage.nr4.e(r1)
            r1 = 1
            if (r3 != r1) goto L2f
            java.lang.String r3 = "openIdPackage"
            java.lang.String r3 = r5.getStringExtra(r3)
            java.lang.String r4 = r4.getPackageName()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 == 0) goto L46
        L2d:
            r0 = r1
            goto L46
        L2f:
            r2 = 2
            if (r3 != r2) goto L43
            java.lang.String r3 = "openIdPackageList"
            java.util.ArrayList r3 = r5.getStringArrayListExtra(r3)
            if (r3 == 0) goto L46
            java.lang.String r4 = r4.getPackageName()
            boolean r0 = r3.contains(r4)
            goto L46
        L43:
            if (r3 != 0) goto L46
            goto L2d
        L46:
            if (r0 != 0) goto L49
            goto L86
        L49:
            java.lang.String r3 = "openIdType"
            java.lang.String r3 = r5.getStringExtra(r3)
            nr4 r4 = defpackage.nr4.b()
            java.lang.String r5 = "oaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L5e
            cu2 r3 = r4.b
            goto L80
        L5e:
            java.lang.String r5 = "vaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L69
            cu2 r3 = r4.d
            goto L80
        L69:
            java.lang.String r5 = "aaid"
            boolean r5 = r5.equals(r3)
            if (r5 == 0) goto L74
            cu2 r3 = r4.c
            goto L80
        L74:
            java.lang.String r5 = "udid"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L7f
            cu2 r3 = r4.a
            goto L80
        L7f:
            r3 = 0
        L80:
            if (r3 != 0) goto L83
            goto L86
        L83:
            r3.e()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mr4.onReceive(android.content.Context, android.content.Intent):void");
    }
}
