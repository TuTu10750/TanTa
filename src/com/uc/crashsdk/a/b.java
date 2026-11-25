package com.uc.crashsdk.a;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import okhttp3.internal.ws.WebSocketProtocol;

/* loaded from: /tmp/classes2.dex */
public final class b {
    private static final int[] a = {WebSocketProtocol.PAYLOAD_SHORT, 147, 115, 241, 101, 198, 215, 134};
    private static final int[] b = {125, 185, 233, 226, 129, 142, 151, 176};
    private static final int[] c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        File file = new File(str);
        FileInputStream fileInputStream2 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream3 = new FileInputStream(file);
            try {
                byte[] bArr = new byte[(int) file.length()];
                fileInputStream3.read(bArr);
                g.a(fileInputStream3);
                byte[] a2 = a(bArr, a);
                if (a2 == null || a2.length <= 0) {
                    g.a((Closeable) null);
                    return null;
                }
                int length = a2.length - 1;
                String str2 = a2[length] == 10 ? new String(a2, 0, length) : new String(a2);
                g.a((Closeable) null);
                return str2;
            } catch (Exception e) {
                fileInputStream = fileInputStream3;
                e = e;
                try {
                    g.a(e);
                    g.a(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    g.a(fileInputStream2);
                    throw th;
                }
            } catch (Throwable th2) {
                fileInputStream2 = fileInputStream3;
                th = th2;
                g.a(fileInputStream2);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8, boolean r9) {
        /*
            if (r9 != 0) goto L4
            goto Lb5
        L4:
            boolean r0 = com.uc.crashsdk.a.g.a(r7)
            if (r0 == 0) goto Lc
            goto Lb5
        Lc:
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            boolean r1 = r0.exists()
            if (r1 == 0) goto Lb5
            long r1 = r0.length()
            r3 = 3145728(0x300000, double:1.554196E-317)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L24
            goto Lb5
        L24:
            byte[] r1 = com.uc.crashsdk.a.g.e(r0)
            if (r1 == 0) goto Lb5
            int r2 = r1.length
            if (r2 > 0) goto L2f
            goto Lb5
        L2f:
            r2 = 1
            r3 = 0
            if (r9 == 0) goto L89
            r9 = 0
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L52
            r4.<init>()     // Catch: java.lang.Throwable -> L52
            java.util.zip.GZIPOutputStream r5 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L4d
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L4d
            r5.write(r1)     // Catch: java.lang.Throwable -> L4b
            r4.flush()     // Catch: java.lang.Throwable -> L4b
            com.uc.crashsdk.a.g.a(r4)
        L47:
            com.uc.crashsdk.a.g.a(r5)
            goto L5d
        L4b:
            r9 = move-exception
            goto L56
        L4d:
            r5 = move-exception
            r6 = r5
            r5 = r9
            r9 = r6
            goto L56
        L52:
            r4 = move-exception
            r5 = r9
            r9 = r4
            r4 = r5
        L56:
            com.uc.crashsdk.a.g.a(r9)     // Catch: java.lang.Throwable -> L81
            com.uc.crashsdk.a.g.a(r4)
            goto L47
        L5d:
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L63
            r9 = r2
            goto L68
        L63:
            r9 = move-exception
            com.uc.crashsdk.a.g.a(r9)
            r9 = r3
        L68:
            if (r9 == 0) goto Lb5
            if (r1 == 0) goto Lb5
            int r9 = r1.length
            if (r9 > 0) goto L70
            goto Lb5
        L70:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            r9.append(r7)
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = r2
            goto L8b
        L81:
            r7 = move-exception
            com.uc.crashsdk.a.g.a(r4)
            com.uc.crashsdk.a.g.a(r5)
            throw r7
        L89:
            r8 = r7
            r9 = r3
        L8b:
            if (r9 == 0) goto Lb5
            java.lang.String r9 = r0.getName()
            boolean r9 = r8.equals(r9)
            if (r9 == 0) goto L9e
            java.lang.String r9 = ".tmp"
            java.lang.String r9 = r8.concat(r9)
            goto La0
        L9e:
            r9 = r8
            r2 = r3
        La0:
            java.io.File r3 = new java.io.File
            r3.<init>(r9)
            boolean r9 = com.uc.crashsdk.a.g.a(r3, r1)
            if (r9 != 0) goto Lac
            goto Lb5
        Lac:
            if (r2 == 0) goto Lb4
            r0.delete()
            r3.renameTo(r0)
        Lb4:
            return r8
        Lb5:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.b.a(java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b2 = b(str2.getBytes(), a);
        if (b2 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b2);
            g.a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            try {
                g.a(th2);
                return false;
            } finally {
                g.a(fileOutputStream);
            }
        }
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length >= 2 && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            int i = length - 2;
            try {
                byte[] bArr2 = new byte[i];
                byte b2 = 0;
                for (int i2 = 0; i2 < i; i2++) {
                    byte b3 = (byte) (bArr[i2] ^ iArr[i2 % 8]);
                    bArr2[i2] = b3;
                    b2 = (byte) (b2 ^ b3);
                }
                if (bArr[i] == ((byte) ((iArr[0] ^ b2) & 255)) && bArr[length - 1] == ((byte) ((iArr[1] ^ b2) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b2 = 0;
                for (int i = 0; i < length; i++) {
                    byte b3 = bArr[i];
                    bArr2[i] = (byte) (iArr[i % 8] ^ b3);
                    b2 = (byte) (b2 ^ b3);
                }
                bArr2[length] = (byte) (iArr[0] ^ b2);
                bArr2[length + 1] = (byte) (iArr[1] ^ b2);
                return bArr2;
            } catch (Exception e) {
                g.a(e);
            }
        }
        return null;
    }
}
