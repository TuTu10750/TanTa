package defpackage;

import android.graphics.Bitmap;
import top.zibin.luban.compression.TurboJpegNative;

/* loaded from: /tmp/classes2.dex */
public final class cu1 implements s40 {
    @Override // defpackage.s40
    public byte[] a(Bitmap bitmap, Integer num, Integer num2) {
        bitmap.getClass();
        byte[] b = b(bitmap);
        if (num2 != null) {
            return TurboJpegNative.a.a(b, bitmap.getWidth(), bitmap.getHeight(), num2.intValue());
        }
        if (num == null) {
            return TurboJpegNative.a.a(b, bitmap.getWidth(), bitmap.getHeight(), 60);
        }
        int i = 95;
        byte[] a = TurboJpegNative.a.a(b, bitmap.getWidth(), bitmap.getHeight(), 95);
        if (a.length / 1024.0d <= num.intValue()) {
            return a;
        }
        byte[] bArr = null;
        int i2 = 5;
        while (i2 <= i) {
            int i3 = (i2 + i) / 2;
            byte[] a2 = TurboJpegNative.a.a(b, bitmap.getWidth(), bitmap.getHeight(), i3);
            if (a2.length / 1024.0d <= num.intValue()) {
                i2 = i3 + 1;
                bArr = a2;
            } else {
                i = i3 - 1;
            }
        }
        return bArr == null ? TurboJpegNative.a.a(b, bitmap.getWidth(), bitmap.getHeight(), 5) : bArr;
    }

    public final byte[] b(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        byte[] bArr = new byte[i * 3];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            bArr[i2] = (byte) ((i4 >> 16) & 255);
            int i5 = i2 + 2;
            bArr[i2 + 1] = (byte) ((i4 >> 8) & 255);
            i2 += 3;
            bArr[i5] = (byte) (i4 & 255);
        }
        return bArr;
    }
}
