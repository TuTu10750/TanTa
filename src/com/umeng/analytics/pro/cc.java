package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: /tmp/classes2.dex */
public class cc {
    private static final String a = "HttpClient";
    private static HostnameVerifier f;
    private String b;
    private a c;
    private Map<String, String> d;
    private cd e;

    /* loaded from: /tmp/classes2.dex */
    public enum a {
        POST,
        GET
    }

    public cc(String str, a aVar, Map<String, String> map, cd cdVar) {
        this.b = str;
        this.c = aVar;
        this.d = map;
        this.e = cdVar;
    }

    private static HostnameVerifier a() {
        if (f == null) {
            f = new HostnameVerifier() { // from class: com.umeng.analytics.pro.cc.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(str) && ca.a.equalsIgnoreCase(str);
                }
            };
        }
        return f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e9, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e6, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e3, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e0, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00dd, code lost:
    
        if (r1 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00da, code lost:
    
        if (r1 == null) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(int r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.cc.a(int, java.lang.String):java.lang.String");
    }
}
