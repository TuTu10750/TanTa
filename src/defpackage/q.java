package defpackage;

import okio.SegmentedByteString;

/* loaded from: /tmp/classes2.dex */
public abstract class q {
    public static final int a(int[] iArr, int i, int i2, int i3) {
        iArr.getClass();
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final int b(SegmentedByteString segmentedByteString, int i) {
        segmentedByteString.getClass();
        int a = a(segmentedByteString.getDirectory(), i + 1, 0, segmentedByteString.getSegments().length);
        return a >= 0 ? a : ~a;
    }
}
