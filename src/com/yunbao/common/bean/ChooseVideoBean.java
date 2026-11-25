package com.yunbao.common.bean;

import android.net.Uri;

/* loaded from: /tmp/classes2.dex */
public class ChooseVideoBean {
    public static final int CAMERA = 0;
    public static final int FILE = 1;
    private long duration;
    private String durationString;
    private final int mType;
    private final Uri videoUri;

    public ChooseVideoBean(int i, Uri uri) {
        this.mType = i;
        this.videoUri = uri;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getDurationString() {
        return this.durationString;
    }

    public int getType() {
        return this.mType;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        if (r2 > 0) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.yunbao.common.bean.ChooseVideoBean] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File getVideoFile() {
        /*
            r7 = this;
            java.io.File r0 = new java.io.File
            java.lang.String r1 = defpackage.j30.H
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 != 0) goto L10
            r0.mkdirs()
        L10:
            java.io.File r1 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            android.net.Uri r3 = r7.videoUri
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = defpackage.fa2.a(r3)
            r2.append(r3)
            java.lang.String r3 = ".mp4"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r0, r2)
            boolean r0 = r1.exists()
            if (r0 == 0) goto L41
            long r2 = r1.length()
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L41
            goto L93
        L41:
            r0 = 0
            com.yunbao.common.CommonAppContext r2 = com.yunbao.common.CommonAppContext.n()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            android.net.Uri r7 = r7.videoUri     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            java.io.InputStream r7 = r2.openInputStream(r7)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L74 java.lang.Exception -> L78
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
        L59:
            int r3 = r7.read(r0)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            if (r3 <= 0) goto L68
            r4 = 0
            r2.write(r0, r4, r3)     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L66
            goto L59
        L64:
            r0 = move-exception
            goto L94
        L66:
            r0 = move-exception
            goto L86
        L68:
            r2.close()     // Catch: java.io.IOException -> L6f
            r7.close()     // Catch: java.io.IOException -> L6f
            return r1
        L6f:
            r7 = move-exception
            r7.printStackTrace()
            goto L93
        L74:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L94
        L78:
            r2 = move-exception
            r6 = r2
            r2 = r0
            r0 = r6
            goto L86
        L7d:
            r7 = move-exception
            r2 = r0
            r0 = r7
            r7 = r2
            goto L94
        L82:
            r7 = move-exception
            r2 = r0
            r0 = r7
            r7 = r2
        L86:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L64
            if (r2 == 0) goto L8e
            r2.close()     // Catch: java.io.IOException -> L6f
        L8e:
            if (r7 == 0) goto L93
            r7.close()     // Catch: java.io.IOException -> L6f
        L93:
            return r1
        L94:
            if (r2 == 0) goto L9c
            r2.close()     // Catch: java.io.IOException -> L9a
            goto L9c
        L9a:
            r7 = move-exception
            goto La2
        L9c:
            if (r7 == 0) goto La5
            r7.close()     // Catch: java.io.IOException -> L9a
            goto La5
        La2:
            r7.printStackTrace()
        La5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.bean.ChooseVideoBean.getVideoFile():java.io.File");
    }

    public Uri getVideoUri() {
        return this.videoUri;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public void setDurationString(String str) {
        this.durationString = str;
    }
}
