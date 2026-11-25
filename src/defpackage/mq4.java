package defpackage;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class mq4 {
    public final uw2 a;
    public final boolean b;
    public final String c;
    public final long d;
    public final long e;
    public final long f;
    public final int g;
    public final Long h;
    public final long i;
    public final List j;

    public mq4(uw2 uw2Var, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4) {
        uw2Var.getClass();
        str.getClass();
        this.a = uw2Var;
        this.b = z;
        this.c = str;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = i;
        this.h = l;
        this.i = j4;
        this.j = new ArrayList();
    }

    public /* synthetic */ mq4(uw2 uw2Var, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uw2Var, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? "" : str, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? -1L : j2, (i2 & 32) != 0 ? -1L : j3, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? null : l, (i2 & 256) != 0 ? -1L : j4);
    }

    public final uw2 a() {
        return this.a;
    }

    public final List b() {
        return this.j;
    }

    public final long c() {
        return this.e;
    }

    public final int d() {
        return this.g;
    }

    public final Long e() {
        return this.h;
    }

    public final long f() {
        return this.i;
    }

    public final long g() {
        return this.f;
    }

    public final boolean h() {
        return this.b;
    }
}
