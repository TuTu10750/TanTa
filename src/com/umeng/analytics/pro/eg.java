package com.umeng.analytics.pro;

import com.umeng.analytics.pro.dx;

/* loaded from: /tmp/classes2.dex */
public class eg {
    private static int a = Integer.MAX_VALUE;

    public static ef a(byte[] bArr, ef efVar) {
        return bArr[0] > 16 ? new dx.a() : (bArr.length <= 1 || (bArr[1] & 128) == 0) ? efVar : new dx.a();
    }

    public static void a(int i) {
        a = i;
    }

    public static void a(ed edVar, byte b) {
        a(edVar, b, a);
    }

    public static void a(ed edVar, byte b, int i) {
        if (i <= 0) {
            throw new dk("Maximum skip depth exceeded");
        }
        int i2 = 0;
        switch (b) {
            case 2:
                edVar.t();
                return;
            case 3:
                edVar.u();
                return;
            case 4:
                edVar.y();
                return;
            case 5:
            case 7:
            case 9:
            default:
                return;
            case 6:
                edVar.v();
                return;
            case 8:
                edVar.w();
                return;
            case 10:
                edVar.x();
                return;
            case 11:
                edVar.A();
                return;
            case 12:
                edVar.j();
                while (true) {
                    byte b2 = edVar.l().b;
                    if (b2 == 0) {
                        edVar.k();
                        return;
                    } else {
                        a(edVar, b2, i - 1);
                        edVar.m();
                    }
                }
            case 13:
                ea n = edVar.n();
                while (i2 < n.c) {
                    int i3 = i - 1;
                    a(edVar, n.a, i3);
                    a(edVar, n.b, i3);
                    i2++;
                }
                edVar.o();
                return;
            case 14:
                eh r = edVar.r();
                while (i2 < r.b) {
                    a(edVar, r.a, i - 1);
                    i2++;
                }
                edVar.s();
                return;
            case 15:
                dz p = edVar.p();
                while (i2 < p.b) {
                    a(edVar, p.a, i - 1);
                    i2++;
                }
                edVar.q();
                return;
        }
    }
}
