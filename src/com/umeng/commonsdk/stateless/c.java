package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.ce;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* loaded from: /tmp/classes2.dex */
public class c {
    private Context a;

    public c(Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(byte[] r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }

    public void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.a, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.h = DataHelper.assembleStatelessURL(imprintProperty);
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) {
        String str4 = str2 + "/" + str;
        if (SdkVersion.SDK_TYPE != 1 && ca.a().b()) {
            if (!str4.contains("preulogs")) {
                str4 = str4.replace("ulogs", "cnlogs");
            }
            String c = ce.b().c();
            if (!TextUtils.isEmpty(c)) {
                str4 = ca.a(c, str);
            }
            boolean a = a(bArr, str4, str3);
            if (!a) {
                String a2 = ca.a().a(str);
                if (!TextUtils.isEmpty(a2) && !str4.equalsIgnoreCase(a2)) {
                    return a(bArr, a2, str3);
                }
            }
            return a;
        }
        return a(bArr, str4, str3);
    }

    public void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.a, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.a, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.g = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.j = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.h = a.j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.b.startsWith("460") || com.umeng.commonsdk.statistics.b.b.startsWith("461")) {
            a.h = a.g;
        }
    }
}
