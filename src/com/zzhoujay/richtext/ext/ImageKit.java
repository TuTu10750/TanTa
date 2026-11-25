package com.zzhoujay.richtext.ext;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
public class ImageKit {
    private static final String GIF_FILE_HEAD = "47494638";

    private static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static boolean isGif(InputStream inputStream) {
        if (inputStream.markSupported()) {
            inputStream.mark(10);
            byte[] bArr = new byte[4];
            try {
                inputStream.read(bArr, 0, 4);
                inputStream.reset();
                return GIF_FILE_HEAD.equals(bytesToHexString(bArr));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v2 */
    public static boolean isGif(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        FileNotFoundException e;
        BufferedInputStream bufferedInputStream;
        try {
            try {
                fileInputStream = new FileInputStream(str);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (FileNotFoundException e2) {
            fileInputStream = null;
            e = e2;
            bufferedInputStream = null;
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
            str = 0;
        }
        try {
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                boolean isGif = isGif(bufferedInputStream);
                try {
                    bufferedInputStream.close();
                    fileInputStream.close();
                    return isGif;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return isGif;
                }
            } catch (FileNotFoundException e4) {
                e = e4;
                e.printStackTrace();
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        return false;
                    }
                }
                if (fileInputStream == null) {
                    return false;
                }
                fileInputStream.close();
                return false;
            }
        } catch (FileNotFoundException e6) {
            e = e6;
            bufferedInputStream = null;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
            if (str != 0) {
                try {
                    str.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                    throw th;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public static boolean isGif(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        return GIF_FILE_HEAD.equals(bytesToHexString(bArr2));
    }
}
