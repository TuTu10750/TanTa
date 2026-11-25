package defpackage;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable;

/* loaded from: /tmp/classes2.dex */
public final class fg4 {
    public static final a b = new a(null);
    public static final fg4 c = new fg4(s20.k());
    public final List a;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final fg4 a(ProtoBuf$VersionRequirementTable protoBuf$VersionRequirementTable) {
            protoBuf$VersionRequirementTable.getClass();
            if (protoBuf$VersionRequirementTable.v() == 0) {
                return b();
            }
            List w = protoBuf$VersionRequirementTable.w();
            w.getClass();
            return new fg4(w, null);
        }

        public final fg4 b() {
            return fg4.c;
        }
    }

    public fg4(List list) {
        this.a = list;
    }

    public /* synthetic */ fg4(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
