package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import com.zzhoujay.richtext.cache.CacheIOHelper;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: /tmp/classes2.dex */
public class ay {
    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPOutputStream gZIPOutputStream;
        GZIPOutputStream gZIPOutputStream2 = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(outputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            gZIPOutputStream.write(bArr);
            at.a(gZIPOutputStream);
        } catch (Throwable th2) {
            th = th2;
            gZIPOutputStream2 = gZIPOutputStream;
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "gzip error: " + th.getMessage());
            } finally {
                at.a(gZIPOutputStream2);
            }
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }

    public static void b(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr2 = new byte[CacheIOHelper.BUFFER_SIZE];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read == -1) {
                    at.a(gZIPInputStream);
                    return;
                }
                outputStream.write(bArr2, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            gZIPInputStream2 = gZIPInputStream;
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "unGzip error: " + th.getMessage());
            } finally {
                at.a(gZIPInputStream2);
            }
        }
    }
}
