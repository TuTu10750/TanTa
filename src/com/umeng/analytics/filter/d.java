package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public class d {
    private static final String b = "Ă";
    private MessageDigest c;
    private boolean e;
    private final String a = "MD5";
    private Set<Object> d = new HashSet();

    public d(boolean z, String str) {
        this.e = z;
        try {
            this.c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (str != null) {
            int i = 0;
            if (!z) {
                String[] split = str.split(b);
                int length = split.length;
                while (i < length) {
                    this.d.add(split[i]);
                    i++;
                }
                return;
            }
            try {
                byte[] decode = Base64.decode(str.getBytes(), 0);
                while (i < decode.length / 4) {
                    int i2 = i * 4;
                    this.d.add(Integer.valueOf(((decode[i2] & 255) << 24) + ((decode[i2 + 1] & 255) << 16) + ((decode[i2 + 2] & 255) << 8) + (decode[i2 + 3] & 255)));
                    i++;
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
            }
        }
    }

    private Integer c(String str) {
        try {
            this.c.update(str.getBytes());
            byte[] digest = this.c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        Iterator<Object> it = this.d.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    public boolean a(String str) {
        boolean z = this.e;
        Set<Object> set = this.d;
        return z ? set.contains(c(str)) : set.contains(str);
    }

    public void b(String str) {
        boolean z = this.e;
        Set<Object> set = this.d;
        if (z) {
            set.add(c(str));
        } else {
            set.add(str);
        }
    }

    public String toString() {
        boolean z = this.e;
        Set<Object> set = this.d;
        if (!z) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : set) {
                if (sb.length() > 0) {
                    sb.append(b);
                }
                sb.append(obj.toString());
            }
            return sb.toString();
        }
        byte[] bArr = new byte[set.size() * 4];
        Iterator<Object> it = this.d.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            bArr[i] = (byte) (((-16777216) & intValue) >> 24);
            bArr[i + 1] = (byte) ((16711680 & intValue) >> 16);
            int i2 = i + 3;
            bArr[i + 2] = (byte) ((65280 & intValue) >> 8);
            i += 4;
            bArr[i2] = (byte) (intValue & 255);
        }
        return new String(Base64.encode(bArr, 0));
    }
}
