package defpackage;

import com.umeng.analytics.pro.ek;
import java.security.MessageDigest;

/* loaded from: /tmp/classes2.dex */
public abstract class fa2 {
    public static char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                char[] cArr2 = a;
                cArr[i] = cArr2[(b >>> 4) & 15];
                i += 2;
                cArr[i2] = cArr2[b & ek.m];
            }
            return new String(cArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
