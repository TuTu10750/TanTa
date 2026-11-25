package com.umeng.analytics.pro;

import java.util.BitSet;

/* loaded from: /tmp/classes2.dex */
public final class ej extends dx {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements ef {
        @Override // com.umeng.analytics.pro.ef
        public ed a(er erVar) {
            return new ej(erVar);
        }
    }

    public ej(er erVar) {
        super(erVar);
    }

    public static BitSet a(byte[] bArr) {
        BitSet bitSet = new BitSet();
        for (int i = 0; i < bArr.length * 8; i++) {
            if ((bArr[(bArr.length - (i / 8)) - 1] & (1 << (i % 8))) > 0) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public static byte[] b(BitSet bitSet, int i) {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < bitSet.length(); i2++) {
            if (bitSet.get(i2)) {
                int i3 = (ceil - (i2 / 8)) - 1;
                bArr[i3] = (byte) ((1 << (i2 % 8)) | bArr[i3]);
            }
        }
        return bArr;
    }

    @Override // com.umeng.analytics.pro.ed
    public Class<? extends el> D() {
        return eo.class;
    }

    public void a(BitSet bitSet, int i) {
        for (byte b : b(bitSet, i)) {
            a(b);
        }
    }

    public BitSet b(int i) {
        int ceil = (int) Math.ceil(i / 8.0d);
        byte[] bArr = new byte[ceil];
        for (int i2 = 0; i2 < ceil; i2++) {
            bArr[i2] = u();
        }
        return a(bArr);
    }
}
