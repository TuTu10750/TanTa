package defpackage;

import com.umeng.analytics.pro.ek;
import java.io.UnsupportedEncodingException;

/* loaded from: /tmp/classes2.dex */
public abstract class pg {

    /* loaded from: /tmp/classes2.dex */
    public static abstract class a {
        public byte[] a;
        public int b;
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends a {
        public static final int[] f = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public static final int[] g = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        public int c;
        public int d;
        public final int[] e;

        public b(int i, byte[] bArr) {
            this.a = bArr;
            this.e = (i & 8) == 0 ? f : g;
            this.c = 0;
            this.d = 0;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3 = this.c;
            if (i3 == 6) {
                return false;
            }
            int i4 = i2 + i;
            int i5 = this.d;
            byte[] bArr2 = this.a;
            int[] iArr = this.e;
            int i6 = 0;
            int i7 = i5;
            int i8 = i3;
            int i9 = i;
            while (i9 < i4) {
                if (i8 == 0) {
                    while (true) {
                        int i10 = i9 + 4;
                        if (i10 > i4 || (i7 = (iArr[bArr[i9] & 255] << 18) | (iArr[bArr[i9 + 1] & 255] << 12) | (iArr[bArr[i9 + 2] & 255] << 6) | iArr[bArr[i9 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i6 + 2] = (byte) i7;
                        bArr2[i6 + 1] = (byte) (i7 >> 8);
                        bArr2[i6] = (byte) (i7 >> 16);
                        i6 += 3;
                        i9 = i10;
                    }
                    if (i9 >= i4) {
                        break;
                    }
                }
                int i11 = i9 + 1;
                int i12 = iArr[bArr[i9] & 255];
                if (i8 != 0) {
                    if (i8 == 1) {
                        if (i12 < 0) {
                            if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 == 2) {
                        if (i12 < 0) {
                            if (i12 == -2) {
                                bArr2[i6] = (byte) (i7 >> 4);
                                i6++;
                                i8 = 4;
                            } else if (i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        }
                        i12 |= i7 << 6;
                    } else if (i8 != 3) {
                        if (i8 != 4) {
                            if (i8 == 5 && i12 != -1) {
                                this.c = 6;
                                return false;
                            }
                        } else if (i12 == -2) {
                            i8++;
                        } else if (i12 != -1) {
                            this.c = 6;
                            return false;
                        }
                    } else if (i12 >= 0) {
                        int i13 = i12 | (i7 << 6);
                        bArr2[i6 + 2] = (byte) i13;
                        bArr2[i6 + 1] = (byte) (i13 >> 8);
                        bArr2[i6] = (byte) (i13 >> 16);
                        i6 += 3;
                        i7 = i13;
                        i8 = 0;
                    } else if (i12 == -2) {
                        bArr2[i6 + 1] = (byte) (i7 >> 2);
                        bArr2[i6] = (byte) (i7 >> 10);
                        i6 += 2;
                        i8 = 5;
                    } else if (i12 != -1) {
                        this.c = 6;
                        return false;
                    }
                    i8++;
                    i7 = i12;
                } else {
                    if (i12 < 0) {
                        if (i12 != -1) {
                            this.c = 6;
                            return false;
                        }
                    }
                    i8++;
                    i7 = i12;
                }
                i9 = i11;
            }
            if (!z) {
                this.c = i8;
                this.d = i7;
                this.b = i6;
                return true;
            }
            if (i8 == 1) {
                this.c = 6;
                return false;
            }
            if (i8 == 2) {
                bArr2[i6] = (byte) (i7 >> 4);
                i6++;
            } else if (i8 == 3) {
                int i14 = i6 + 1;
                bArr2[i6] = (byte) (i7 >> 10);
                i6 += 2;
                bArr2[i14] = (byte) (i7 >> 2);
            } else if (i8 == 4) {
                this.c = 6;
                return false;
            }
            this.c = i8;
            this.b = i6;
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class c extends a {
        public static final byte[] j = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        public static final byte[] k = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public final byte[] c;
        public int d;
        public int e;
        public final boolean f;
        public final boolean g;
        public final boolean h;
        public final byte[] i;

        public c(int i, byte[] bArr) {
            this.a = bArr;
            this.f = (i & 1) == 0;
            boolean z = (i & 2) == 0;
            this.g = z;
            this.h = (i & 4) != 0;
            this.i = (i & 8) == 0 ? j : k;
            this.c = new byte[2];
            this.d = 0;
            this.e = z ? 19 : -1;
        }

        public boolean a(byte[] bArr, int i, int i2, boolean z) {
            int i3;
            int i4;
            int i5;
            int i6;
            byte b;
            byte b2;
            byte b3;
            int i7;
            int i8;
            byte[] bArr2 = this.i;
            byte[] bArr3 = this.a;
            int i9 = this.e;
            int i10 = i2 + i;
            int i11 = this.d;
            char c = 2;
            int i12 = 0;
            if (i11 != 1) {
                if (i11 == 2 && (i8 = i + 1) <= i10) {
                    byte[] bArr4 = this.c;
                    i4 = ((bArr4[1] & 255) << 8) | ((bArr4[0] & 255) << 16) | (bArr[i] & 255);
                    this.d = 0;
                    i3 = i8;
                }
                i3 = i;
                i4 = -1;
            } else {
                if (i + 2 <= i10) {
                    i3 = i + 2;
                    i4 = (bArr[i + 1] & 255) | ((this.c[0] & 255) << 16) | ((bArr[i] & 255) << 8);
                    this.d = 0;
                }
                i3 = i;
                i4 = -1;
            }
            if (i4 != -1) {
                bArr3[0] = bArr2[(i4 >> 18) & 63];
                bArr3[1] = bArr2[(i4 >> 12) & 63];
                bArr3[2] = bArr2[(i4 >> 6) & 63];
                bArr3[3] = bArr2[i4 & 63];
                i9--;
                if (i9 == 0) {
                    if (this.h) {
                        bArr3[4] = ek.k;
                        i7 = 5;
                    } else {
                        i7 = 4;
                    }
                    i5 = i7 + 1;
                    bArr3[i7] = 10;
                    i9 = 19;
                } else {
                    i5 = 4;
                }
            } else {
                i5 = 0;
            }
            while (true) {
                int i13 = i3 + 3;
                if (i13 > i10) {
                    break;
                }
                char c2 = c;
                int i14 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16) | (bArr[i3 + 2] & 255);
                bArr3[i5] = bArr2[(i14 >> 18) & 63];
                bArr3[i5 + 1] = bArr2[(i14 >> 12) & 63];
                bArr3[i5 + 2] = bArr2[(i14 >> 6) & 63];
                bArr3[i5 + 3] = bArr2[i14 & 63];
                int i15 = i5 + 4;
                i9--;
                if (i9 == 0) {
                    if (this.h) {
                        bArr3[i15] = ek.k;
                        i15 = i5 + 5;
                    }
                    i5 = i15 + 1;
                    bArr3[i15] = 10;
                    c = c2;
                    i9 = 19;
                    i3 = i13;
                } else {
                    i5 = i15;
                    i3 = i13;
                    c = c2;
                }
            }
            if (z) {
                int i16 = this.d;
                if (i3 - i16 == i10 - 1) {
                    if (i16 > 0) {
                        b3 = this.c[0];
                        i12 = 1;
                    } else {
                        b3 = bArr[i3];
                    }
                    int i17 = (b3 & 255) << 4;
                    this.d = i16 - i12;
                    bArr3[i5] = bArr2[(i17 >> 6) & 63];
                    int i18 = i5 + 2;
                    bArr3[i5 + 1] = bArr2[i17 & 63];
                    if (this.f) {
                        bArr3[i18] = 61;
                        i18 = i5 + 4;
                        bArr3[i5 + 3] = 61;
                    }
                    if (this.g) {
                        if (this.h) {
                            bArr3[i18] = ek.k;
                            i18++;
                        }
                        i6 = i18 + 1;
                        bArr3[i18] = 10;
                        i5 = i6;
                    } else {
                        i5 = i18;
                    }
                } else if (i3 - i16 == i10 - 2) {
                    if (i16 > 1) {
                        b = this.c[0];
                        i12 = 1;
                    } else {
                        byte b4 = bArr[i3];
                        i3++;
                        b = b4;
                    }
                    int i19 = (b & 255) << 10;
                    if (i16 > 0) {
                        b2 = this.c[i12];
                        i12++;
                    } else {
                        b2 = bArr[i3];
                    }
                    int i20 = i19 | ((b2 & 255) << 2);
                    this.d = i16 - i12;
                    bArr3[i5] = bArr2[(i20 >> 12) & 63];
                    bArr3[i5 + 1] = bArr2[(i20 >> 6) & 63];
                    int i21 = i5 + 3;
                    bArr3[i5 + 2] = bArr2[i20 & 63];
                    if (this.f) {
                        bArr3[i21] = 61;
                        i21 = i5 + 4;
                    }
                    if (this.g) {
                        if (this.h) {
                            bArr3[i21] = ek.k;
                            i21++;
                        }
                        i6 = i21 + 1;
                        bArr3[i21] = 10;
                        i5 = i6;
                    } else {
                        i5 = i21;
                    }
                } else if (this.g && i5 > 0 && i9 != 19) {
                    if (this.h) {
                        bArr3[i5] = ek.k;
                        i5++;
                    }
                    i6 = i5 + 1;
                    bArr3[i5] = 10;
                    i5 = i6;
                }
            } else if (i3 == i10 - 1) {
                byte[] bArr5 = this.c;
                int i22 = this.d;
                this.d = i22 + 1;
                bArr5[i22] = bArr[i3];
            } else if (i3 == i10 - 2) {
                byte[] bArr6 = this.c;
                int i23 = this.d;
                int i24 = i23 + 1;
                this.d = i24;
                bArr6[i23] = bArr[i3];
                this.d = i23 + 2;
                bArr6[i24] = bArr[i3 + 1];
            }
            this.b = i5;
            this.e = i9;
            return true;
        }
    }

    public static byte[] a(String str, int i) {
        return b(str.getBytes(), i);
    }

    public static byte[] b(byte[] bArr, int i) {
        return c(bArr, 0, bArr.length, i);
    }

    public static byte[] c(byte[] bArr, int i, int i2, int i3) {
        b bVar = new b(i3, new byte[(i2 * 3) / 4]);
        if (!bVar.a(bArr, i, i2, true)) {
            ik.a("bad base-64");
            return null;
        }
        int i4 = bVar.b;
        byte[] bArr2 = bVar.a;
        if (i4 == bArr2.length) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, i4);
        return bArr3;
    }

    public static byte[] d(byte[] bArr, int i) {
        return e(bArr, 0, bArr.length, i);
    }

    public static byte[] e(byte[] bArr, int i, int i2, int i3) {
        c cVar = new c(i3, null);
        int i4 = (i2 / 3) * 4;
        if (!cVar.f) {
            int i5 = i2 % 3;
            if (i5 == 1) {
                i4 += 2;
            } else if (i5 == 2) {
                i4 += 3;
            }
        } else if (i2 % 3 > 0) {
            i4 += 4;
        }
        if (cVar.g && i2 > 0) {
            i4 += (((i2 - 1) / 57) + 1) * (cVar.h ? 2 : 1);
        }
        cVar.a = new byte[i4];
        cVar.a(bArr, i, i2, true);
        return cVar.a;
    }

    public static String f(byte[] bArr, int i) {
        try {
            return new String(d(bArr, i), "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            jk.a(e);
            return null;
        }
    }
}
