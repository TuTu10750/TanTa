package defpackage;

import android.text.TextUtils;
import com.yunbao.live.music.LrcBean;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public abstract class f92 {
    public static Pattern a = Pattern.compile("\\[(\\d{2}:\\d{2}\\.\\d{2})\\]");

    public static List a(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("\\[")) {
            LrcBean c = c("[" + str2);
            if (c != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARN: Type inference failed for: r4v3, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List b(java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = defpackage.j30.L
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = ".lrc"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            boolean r4 = r0.exists()
            r1 = 0
            if (r4 != 0) goto L23
            return r1
        L23:
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r0.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
        L37:
            java.lang.String r2 = r4.readLine()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            if (r2 == 0) goto L46
            r0.append(r2)     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            goto L37
        L41:
            r0 = move-exception
            r1 = r4
            goto L71
        L44:
            r0 = move-exception
            goto L57
        L46:
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L44
            r4.close()     // Catch: java.io.IOException -> L4e
            goto L65
        L4e:
            r4 = move-exception
            r4.printStackTrace()
            goto L65
        L53:
            r0 = move-exception
            goto L71
        L55:
            r0 = move-exception
            r4 = r1
        L57:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L41
            if (r4 == 0) goto L64
            r4.close()     // Catch: java.io.IOException -> L60
            goto L64
        L60:
            r4 = move-exception
            r4.printStackTrace()
        L64:
            r0 = r1
        L65:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L6c
            return r1
        L6c:
            java.util.List r4 = a(r0)
            return r4
        L71:
            if (r1 == 0) goto L7b
            r1.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r4 = move-exception
            r4.printStackTrace()
        L7b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f92.b(java.lang.String):java.util.List");
    }

    public static LrcBean c(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("[ti:") || str.startsWith("[ar:") || str.startsWith("[al:")) {
            return null;
        }
        Matcher matcher = a.matcher(str);
        if (!matcher.find()) {
            return null;
        }
        long d = d(matcher.group(1));
        String[] split = a.split(str);
        return new LrcBean(d, split.length > 1 ? split[1] : "");
    }

    public static long d(String str) {
        String[] split = str.split(":");
        int h = rv3.h(split[0], 0);
        String[] split2 = split[1].split("\\.");
        return (h * 60000) + (rv3.h(split2[0], 0) * IjkMediaCodecInfo.RANK_MAX) + (rv3.h(split2[1], 0) * 10);
    }
}
