package defpackage;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class k11 {
    public final boolean a;
    public final boolean b;
    public final uw2 c;
    public final Long d;
    public final Long e;
    public final Long f;
    public final Long g;
    public final Map h;

    public k11(boolean z, boolean z2, uw2 uw2Var, Long l, Long l2, Long l3, Long l4, Map map) {
        map.getClass();
        this.a = z;
        this.b = z2;
        this.c = uw2Var;
        this.d = l;
        this.e = l2;
        this.f = l3;
        this.g = l4;
        this.h = a.u(map);
    }

    public /* synthetic */ k11(boolean z, boolean z2, uw2 uw2Var, Long l, Long l2, Long l3, Long l4, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : uw2Var, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? a.i() : map);
    }

    public static /* synthetic */ k11 b(k11 k11Var, boolean z, boolean z2, uw2 uw2Var, Long l, Long l2, Long l3, Long l4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = k11Var.a;
        }
        if ((i & 2) != 0) {
            z2 = k11Var.b;
        }
        if ((i & 4) != 0) {
            uw2Var = k11Var.c;
        }
        if ((i & 8) != 0) {
            l = k11Var.d;
        }
        if ((i & 16) != 0) {
            l2 = k11Var.e;
        }
        if ((i & 32) != 0) {
            l3 = k11Var.f;
        }
        if ((i & 64) != 0) {
            l4 = k11Var.g;
        }
        if ((i & 128) != 0) {
            map = k11Var.h;
        }
        Long l5 = l4;
        Map map2 = map;
        Long l6 = l2;
        Long l7 = l3;
        return k11Var.a(z, z2, uw2Var, l, l6, l7, l5, map2);
    }

    public final k11 a(boolean z, boolean z2, uw2 uw2Var, Long l, Long l2, Long l3, Long l4, Map map) {
        map.getClass();
        return new k11(z, z2, uw2Var, l, l2, l3, l4, map);
    }

    public final Long c() {
        return this.f;
    }

    public final Long d() {
        return this.d;
    }

    public final uw2 e() {
        return this.c;
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean g() {
        return this.a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.a) {
            arrayList.add("isRegularFile");
        }
        if (this.b) {
            arrayList.add("isDirectory");
        }
        if (this.d != null) {
            arrayList.add("byteCount=" + this.d);
        }
        if (this.e != null) {
            arrayList.add("createdAt=" + this.e);
        }
        if (this.f != null) {
            arrayList.add("lastModifiedAt=" + this.f);
        }
        if (this.g != null) {
            arrayList.add("lastAccessedAt=" + this.g);
        }
        if (!this.h.isEmpty()) {
            arrayList.add("extras=" + this.h);
        }
        return b30.k0(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }
}
